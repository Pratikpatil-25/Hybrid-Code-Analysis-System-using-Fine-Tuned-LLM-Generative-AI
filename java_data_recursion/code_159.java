package dailyproblems.recursion;

public class SumOf1stNNumber 
{
    private void print(int n, int i)
    {
        if(n<1)
        {
            System.out.println(i);
            return;
        }
        i+=n;
        print(n-1, i);
    }

    public static void main(String[] args) {
        SumOf1stNNumber sumOf1stNNumber=new SumOf1stNNumber();
        sumOf1stNNumber.print(5, 0);
    }
}