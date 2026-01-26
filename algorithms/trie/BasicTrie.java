package trie;

public class BasicTrie {
    public static void main(String[] args){
        Trie myTrie = new Trie();
        myTrie.insert("hello");
        myTrie.insert("hi");
        myTrie.insert("help");
        myTrie.insert("hero");
        myTrie.insert("hes");
        myTrie.insert("hashh");

        System.out.println(myTrie.search("hello"));
        System.out.println(myTrie.search("hes"));
        System.out.println(myTrie.search("her"));
        System.out.println(myTrie.startsWith("her"));


//        System.out.println("Hello World");
    }


}
