class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
                if (strs == null || strs.length == 0)   return null;
        HashMap<String, List<String>> map = new HashMap();          for (String str : strs){
            char[] words = str.toCharArray();
            Arrays.sort(words);
            String key = String.valueOf(words);                         if (!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());                     }
}