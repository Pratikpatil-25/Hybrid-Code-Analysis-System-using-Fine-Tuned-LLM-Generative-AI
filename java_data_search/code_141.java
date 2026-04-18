package javasolutionsforalgorithms.leettests.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Trie {

    private TrieNode root;                                
    public Trie() {
        this.root = new TrieNode();
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        int count;

        TrieNode() {
            this.children = new TrieNode[26];                 this.isWord = false;                              this.count = 0;                               }
    }

    public void insertWords(List<String> words) {
        words.forEach(this::insert);
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        TrieNode current = root;                  
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) {                TrieNode node = new TrieNode();
                current.children[index] = node;                   current = node;                               } else {
                current = current.children[index];            }
            current.count += 1;                           }
        current.isWord = true;
    }


    public boolean search(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            TrieNode node = currentNode.children[index];
            if (node == null) {
                return false;
            }
            currentNode = node;                         }

        return currentNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';

            TrieNode node = currentNode.children[index];
            if (node == null) {
                return false;
            }

            currentNode = node;
        }

        return true;
    }

    public int countPrefixStartingWith(String prefix) {
        TrieNode currentNode = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';

            TrieNode node = currentNode.children[index];
            if (node == null) {
                return 0;
            }

            currentNode = node;
        }

        return currentNode.count;
    }


    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("app", "apple", "applications", "cats", "cap", "cup", "ape", "hut");

        Trie trie = new Trie();
        trie.insertWords(dictionary);

        List<String> searches = Arrays.asList("app", "ap", "hum", "cat", "cap", "hut");
        searches.forEach(search -> System.out.println("Search for " + search + " | Outcome: " + trie.search(search)));


        List<String> stringStartingWith = Arrays.asList("hu", "ca", "bat", "apply");
        stringStartingWith.forEach(search -> System.out.println("Search count of " + search +
                " | Exists: " + trie.countPrefixStartingWith(search)));


        List<String> searchCounts = Arrays.asList("ap", "huge", "cat", "cap", "h");
        searchCounts.forEach(search -> System.out.println("Search count of " + search +
                " | Count: " + trie.countPrefixStartingWith(search)));

    }
}