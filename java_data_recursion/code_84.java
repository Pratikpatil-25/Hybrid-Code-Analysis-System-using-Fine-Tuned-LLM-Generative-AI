public class Ex12 {

    
    public static int digitDiffer(int a, int b) {
        if (a == 0 && b == 0)
            return 0;

                int diff = (a % 10 != b % 10) ? 1 : 0;

                return diff + digitDiffer(a / 10, b / 10);
    }

    
    public static int numWaysToClimb(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;

                return numWaysToClimb(n - 1) + numWaysToClimb(n - 2);
    }

    
    public static int solutions(int num) {
        if (num < 3 || num > 30)
            return 0;

                return solutions(num, 1, 1, 1);
    }

    
    private static int solutions(int num, int x, int y, int z) {
        if (z > 10) {
                        if (y < 10)
                return solutions(num, x, y + 1, 1);

                        else if (x < 10)
                return solutions(num, x + 1, 1, 1);

                        else
                return 0;
        }

        int count = 0;

                if (x + y + z == num) {
            System.out.println(x + " + " + y + " + " + z);
            count = 1;
        }

                return count + solutions(num, x, y, z + 1);
    }
}