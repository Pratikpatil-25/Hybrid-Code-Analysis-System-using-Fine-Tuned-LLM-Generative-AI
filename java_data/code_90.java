class check

{

    static int check(int x, int y) 
    {

     if(x==0)

     return y;

     if(y==0)

     return x;

     if (x>y)

     return check (x-y,y);

     return check(x,y-x);

    }

    public static void main(String[] args)

    {

        int x= 100 ,y=90;

        System.out.println("GCD of " + x + " and " + y 

        + " is " + check(x, y));

    }

}




class check{

    static int check(int x, int y)

    {

        if (y==0)

        return x;

        return check(y, x % y);

    }

    public static void main(String[] args)

    {

        int x= 45, y=77;

        System.out.println("The GCD of " + x + " and " + y 

        + " is: " + check(x, y));

    }

}

====================================================================================================

The GCD of 56 and 90 is: 2