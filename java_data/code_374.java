package org.infinispan.commons.hash;

import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;
import org.infinispan.marshall.Ids;
import org.infinispan.marshall.exts.NoStateExternalizer;
import org.infinispan.util.ByteArrayKey;
import org.infinispan.util.Util;

import java.io.ObjectInput;
import java.util.Set;


@ThreadSafe
@Immutable
public class MurmurHash2Compat implements Hash {
   private static final int M = 0x5bd1e995;
   private static final int R = 24;
   private static final int H = -1;

   @Override
   public final int hash(byte[] payload) {
      int h = H;
      int len = payload.length;
      int offset = 0;
      while (len >= 4) {
         int k = payload[offset];
         k |= payload[offset + 1] << 8;
         k |= payload[offset + 2] << 16;
         k |= payload[offset + 3] << 24;

         k *= M;
         k ^= k >> R;
         k *= M;
         h *= M;
         h ^= k;

         len -= 4;
         offset += 4;
      }

      switch (len) {
         case 3:
            h ^= payload[offset + 2] << 16;
         case 2:
            h ^= payload[offset + 1] << 8;
         case 1:
            h ^= payload[offset];
            h *= M;
      }

      h ^= h >> 13;
      h *= M;
      h ^= h >> 15;

      return h;
   }

   @Override
   public final int hash(int hashcode) {
      byte[] b = new byte[4];
      b[0] = (byte) hashcode;
      b[1] = (byte) (hashcode >> 8);
      b[2] = (byte) (hashcode >> 16);
      b[3] = (byte) (hashcode >> 24);
      return hash(b);
   }

   @Override
   public final int hash(Object o) {
      if (o instanceof byte[])
         return hash((byte[]) o);
      else if (o instanceof String)
         return hash(((String) o).getBytes());
      else if (o instanceof ByteArrayKey)
         return hash(((ByteArrayKey) o).getData());
      else
         return hash(o.hashCode());
   }

   @Override
   public boolean equals(Object other) {
      return other != null && other.getClass() == getClass();
   }

   @Override
   public String toString() {
      return "MurmurHash2Compat";
   }

   public static class Externalizer extends NoStateExternalizer<MurmurHash2Compat> {
      @Override
      public Set<Class<? extends MurmurHash2Compat>> getTypeClasses() {
         return Util.<Class<? extends MurmurHash2Compat>>asSet(MurmurHash2Compat.class);
      }

      @Override
      public MurmurHash2Compat readObject(ObjectInput input) {
         return new MurmurHash2Compat();
      }

      @Override
      public Integer getId() {
         return Ids.MURMURHASH_2_COMPAT;
      }
   }
}