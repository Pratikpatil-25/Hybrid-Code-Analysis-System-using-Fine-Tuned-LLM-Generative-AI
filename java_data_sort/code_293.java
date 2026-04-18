class Solution {
    public String sortVowels(String s) {
        StringBuilder ans = new StringBuilder(s);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A' ||s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U' || s.charAt(i)=='a' ||s.charAt(i)=='e'|| s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u' ){
                int x = (int) s.charAt(i);
                pq.add(x);
            }
        }  
        for(int i=0;i<ans.length();i++){
            if(s.charAt(i)=='A' ||s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U' || s.charAt(i)=='a' ||s.charAt(i)=='e'|| s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u' ){
                int data = pq.remove();
                char ch = (char) (int)data;
                ans.setCharAt(i,ch);
            }
        }
        return ans.toString();
    }
}