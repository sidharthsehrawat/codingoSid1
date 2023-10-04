package folder.trie;
public class TrieImpl {
    private TrieNode root;
    TrieImpl() {
        root = new TrieNode();   // root is empty.
    }
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public static void main(String[] args) {
        TrieImpl obj = new TrieImpl();
        obj.insertWord("abc");
        obj.insertWord("sid");
        obj.searchWord("sidh");
    }
    private boolean searchWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] != null) {
                current = current.children[index];
                if (current.isWord == true) {
                    System.out.println("word present");
                    return true;
                }
            } else {
                System.out.println("word not present");
                return false;
            }
        }
        return false;
    }

    private void insertWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i); // abc  | abcd
            int index = ch - 'a';
            if (current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            } else {
                current = current.children[index];
            }
        }
        current.isWord = true;
    }
}