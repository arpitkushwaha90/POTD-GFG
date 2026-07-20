import java.util.ArrayList;

class Solution {
    
    // Trie Node structure
    static class TrieNode {
        TrieNode[] children = new TrieNode[256]; // supports extended ASCII or standard lowercase
        int freq = 0; // count of words passing through this node
    }

    // Function to insert a word into the Trie
    private void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch] == null) {
                curr.children[ch] = new TrieNode();
            }
            curr = curr.children[ch];
            curr.freq++; // Increment frequency of the prefix
        }
    }

    // Function to search the shortest unique prefix for a given word
    private String getShortestPrefix(TrieNode root, String word) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            prefix.append(ch);
            curr = curr.children[ch];

            // If the current node has freq == 1, it's unique
            if (curr.freq == 1) {
                break;
            }
        }
        return prefix.toString();
    }

    public ArrayList<String> findPrefixes(ArrayList<String> arr) {
        TrieNode root = new TrieNode();

        // 1. Insert all words into the Trie
        for (String word : arr) {
            insert(root, word);
        }

        // 2. Find shortest unique prefix for each word
        ArrayList<String> result = new ArrayList<>();
        for (String word : arr) {
            result.add(getShortestPrefix(root, word));
        }

        return result;
    }
}
