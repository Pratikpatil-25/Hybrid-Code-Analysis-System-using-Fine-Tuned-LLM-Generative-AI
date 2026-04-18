class WordDictionary {
    Node root;
    
    class Node{
        char d;
        boolean isEnd;
        int cnt;
        Node next[];
            public Node(char data){
                d = data;
                isEnd = false;
                cnt = 0;
                next = new Node[26];
            }
    }

    public WordDictionary() {
        root = new Node('0');
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
                if(curr.next[c-'a']==null) curr.next[c-'a'] = new Node(c);
                else curr.cnt++;
                curr = curr.next[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(c=='.'){
                for(Node nexy : curr.next){
                    if(nexy!=null){
                        
                    }
                }
                continue;
            }
            if(curr.next[c-'a']!=null) curr = curr.next[c-'a'];
            else return false;
        }
        return curr.isEnd;
    }
}