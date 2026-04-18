class Solution {
public int maxProduct(int[] nums) {
  int max_product = nums[0];
int n = nums.length;
for (int i = 0; i< n; i++)
{
int product = 1;
for (int j = 0 ; j <n ; j++)
{
product *= nums[j];
max_product = Math.max(max_product, product);
}
}
return max_product;
}
}