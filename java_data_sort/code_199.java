class Solution {
    public String customSortString(String order, String s) {

        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        Character[] sArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sArray[i] = s.charAt(i);
        }

        Arrays.sort(sArray, (a, b) -> {
            Integer order1 = orderMap.get(a);
            Integer order2 = orderMap.get(b);
            if (order1 != null && order2 != null) {
                return order1 - order2;
            } else if (order1 != null) {
                return -1;
            } else if (order2 != null) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        });

        StringBuilder result = new StringBuilder();
        for (char c : sArray) {
            result.append(c);
        }
        return result.toString();
    }
}