package trie;

public class LongestCommonPrefix {
    //https://leetcode.com/problems/longest-common-prefix/description/

    class Trie{
        TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void add(String word){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                int index = ch - 'a';
                if(curr.children[index]==null){
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isEndofWord=true;
        }


    }

    class TrieNode{
        TrieNode[] children  =new TrieNode[26];
        boolean isEndofWord;

        TrieNode(){}
    }
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String str : strs){
            trie.add(str);
        }

        return null;
    }
}
