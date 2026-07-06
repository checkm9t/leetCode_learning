package org.example.practice;

class Trie {

    public Trie[] children;
    public Boolean isEnd;

    public Trie() {
        children = new Trie[26];
    }

    public void insert(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] != null) {
                // 这里需要尤其注意，应该是cur.children，而不是children
                cur = cur.children[c - 'a'];
            } else {
                cur.children[c - 'a'] = new Trie();
                cur = cur.children[c - 'a'];
            }
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = this;

        for (char c : word.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null) {
                return false;
            }
        }

        // 这里isEnd没有赋默认值，容易为null
        return Boolean.TRUE.equals(cur.isEnd);
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;

        for (char c : prefix.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
