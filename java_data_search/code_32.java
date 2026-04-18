import java.util.Scanner;




public class x1 {

    public static int search(int[] nums, int target){



        if(target<nums[0]||target>nums[nums.length-1]){

            return -1;

        }

        int left=0,right=nums.length-1;

        while(left<=right){

            int mid=(left+right)/2;

            if(nums[mid]==target){

                return mid;

            }

            else if (nums[mid]<target){

                left=mid+1;

            }

            else{

                right=mid-1;

            }

        }

            return -1;

    }

    public static void main(String[] args) {

        System.out.println("Hello, World!");

        Scanner scanner=new Scanner(System.in);

        System.out.print("请输入数组有几位数字:");

        int x=scanner.nextInt();

        int[] nums = new int[x];

        System.out.print("请输入需要查找的目标值:");

        int target=scanner.nextInt();

        System.out.print("请输入"+x+"位数组数字:");

        for(int i = 0; i<x; i++)

        {

            nums[i]=scanner.nextInt();

        }

        System.out.print("目标值的数组下标为："+search(nums,target));



    }

}