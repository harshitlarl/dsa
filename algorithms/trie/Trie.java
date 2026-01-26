package trie;

class Trie{
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //Insert  word into Trie
     void insert(String word){
        TrieNode current = root;
        for(Character ch : word.toCharArray()){
            int index = ch - 'a';
            if(current.children[index]== null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];

        }
        current.isEndOfWord=true;
    }


    // Returns true if the word is in the trie
    public boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isEndOfWord;
    }

    //Return true if tehre is any word start with this prefix
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private TrieNode getNode(String word){
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            int index = ch-'a';
            if(curr.children[index]==null)
                return null;
            curr = curr.children[index];
        }
        return curr;
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;

        TrieNode(){}
    }

}

