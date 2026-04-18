class Solution {
class Node {
Node[] links = new Node[2];
public Node() {
}
boolean containsKey(int bit){
return links[bit] != null;
}
Node get(int bit){
return links[bit];
}
void put(int bit, Node node){
links[bit] = node;
}
}
class Trie {
private Node root;
public Trie(){
root = new Node();
}
public void insert(int num){
Node node = root;
for(int i = 31; i >= 0; i--){
int bit = (num >> i) & 1;
  if(!node.containsKey(bit)){
node.put(bit, new Node());
}
node = node.get(bit);
}
}
public int getMax(int num){
Node node = root;
int maxNum = 0;
for(int i = 31; i >= 0; i--){
int bit = (num >> i) & 1;
if(node.containsKey(1 - bit)){
maxNum = maxNum | (1 << i);
node = node.get(1 - bit);
}else{
node = node.get(bit);
}
}
return maxNum;
}
}
public int[] maximizeXor(int[] nums, int[][] queries) {
int queriesLength = queries.length;
int[] ans = new int[queriesLength];
int[][] temp = new int[queriesLength][3];
for (int i = 0; i < queriesLength; i++) {
temp[i][0] = queries[i][0];
temp[i][1] = queries[i][1];
temp[i][2] = i;
}
Arrays.sort(temp, (a, b) -> {
  return a[1] - b[1];
});
Arrays.sort(nums);
Trie trie = new Trie();
int ind = 0;
for(int[] q : temp){
while(ind < nums.length && nums[ind] <= q[1]){
trie.insert(nums[ind]);
ind++;
}
if(ind == 0){
ans[q[2]] = -1;
}else{
ans[q[2]] = trie.getMax(q[0]);
}
}
return ans;
}
}