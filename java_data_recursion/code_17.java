class Solution {
    public void recursion(int open, int close, String str, List<String> result) {
        if (open > close || open < 0 || close < 0) {
            return;
        }

        if (open == 0 && close == 0) {
            result.add(str);
            return;
        }

        recursion(open-1,close,str+"(",result);
        recursion(open,close-1,str+")",result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        recursion(n,n,"",result);

        return result;
    }
}