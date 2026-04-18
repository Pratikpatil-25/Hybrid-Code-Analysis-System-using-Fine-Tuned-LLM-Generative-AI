package xbird.util.concurrent.cache.algorithm;

import java.util.concurrent.ConcurrentMap;

import xbird.util.cache.Cleaner;
import xbird.util.cache.ICacheEntry;
import xbird.util.concurrent.cache.ReplacementPolicy;
import xbird.util.concurrent.cache.helpers.NopCleaner;


public final class LRUCachePolicy<K, V> implements ReplacementPolicy<K, V, LRUCacheEntry<K, V>> {

    private final int _maxCapacity;
    private final LRUCacheEntry<K, V> _headEntry;
    private int _numEntries = 0;

    private Cleaner<K, V> _cleaner = NopCleaner.getInstance();

    public LRUCachePolicy(int capacity) {
        this._maxCapacity = capacity;
        this._headEntry = new LRUCacheEntry<K, V>(null, null);
        initEntryChain(_headEntry);
    }

    private void initEntryChain(LRUCacheEntry<K, V> header) {
        header.prev = header.next = header;
    }

    public int getMaxCapacity() {
        return _maxCapacity;
    }

    public void setCleaner(Cleaner<K, V> cleaner) {
        this._cleaner = cleaner;
    }

    public void recordAccess(LRUCacheEntry<K, V> entry) {
        entry.recordAccess(_headEntry);
    }

    public void recordRemoval(LRUCacheEntry<K, V> entry) {
        entry.recordRemoval();
    }

    public V addEntry(ConcurrentMap<K, LRUCacheEntry<K, V>> map, K key, V value, boolean replace) {
        final LRUCacheEntry<K, V> newEntry = new LRUCacheEntry<K, V>(key, value);

        map.put(key, newEntry);

        newEntry.addBefore(_headEntry);
        ++_numEntries;

        if(removeEldestEntry()) {
            LRUCacheEntry<K, V> eldest = _headEntry.next;
            eldest.setEvicted();
            K remotedKey = eldest.getKey();
            _cleaner.cleanup(remotedKey, eldest.getValue());
            map.remove(remotedKey, eldest);
            --_numEntries;
            eldest.recordRemoval();
        }

        return null;
    }

    public LRUCacheEntry<K, V> allocateEntry(ConcurrentMap<K, LRUCacheEntry<K, V>> map, K key, V value) {
        final LRUCacheEntry<K, V> newEntry = new LRUCacheEntry<K, V>(key, value);

        map.put(key, newEntry);

        newEntry.addBefore(_headEntry);
        ++_numEntries;

        if(removeEldestEntry()) {
            LRUCacheEntry<K, V> eldest = _headEntry.next;
            while(!eldest.tryEvict()) {
                eldest = eldest.next;
            }
                        K remotedKey = eldest.getKey();
            _cleaner.cleanup(remotedKey, eldest.getValue());
            map.remove(remotedKey, eldest);
            eldest.recordRemoval();
        }

        return newEntry;
    }

    private boolean removeEldestEntry() {
        return _numEntries > _maxCapacity;
    }

    public int prefetchEntries(final ICacheEntry<K, V> e) {
        final LRUCacheEntry<K, V> entry = (LRUCacheEntry<K, V>) e;
        int sum = 0;
        if(_headEntry != null) {
            sum++;
        }
        final LRUCacheEntry<K, V> prev = entry.prev;
        if(prev != null) {
            if(prev.next != null) {
                sum++;
            }
        }
        final LRUCacheEntry<K, V> next = entry.next;
        if(next != null) {
            if(next.prev != null) {
                sum++;
            }
        }
        return sum;
    }
}