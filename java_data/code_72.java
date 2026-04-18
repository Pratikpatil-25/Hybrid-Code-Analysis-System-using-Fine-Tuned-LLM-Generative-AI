class Solution {

public int lengthOfLongestSubstring(String s) {

if (s == null || s.length() == 0) {
  return 0;

}

int n = s.length();

int i = 0, j = 0;

int maxLength = 0;

HashMap<Character, Integer> map = new HashMap<>();

while (j < n) {

char ch = s.charAt(j);

if (map.containsKey(ch) && map.get(ch) >= i) {

i = map.get(ch) + 1;

}

map.put(ch, j);

maxLength = Math.max(maxLength, j - i + 1);

j++;

}

return maxLength;

}

}