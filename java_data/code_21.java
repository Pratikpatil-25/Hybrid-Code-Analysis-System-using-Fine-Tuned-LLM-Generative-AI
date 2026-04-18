public class CRT
{
  
  public static int[] euclidean(int a, int b)
  {
    if(b > a)
    {
            int[] coeffs = euclidean(b, a);
      int[] output = {coeffs[1], coeffs[0]};
      return output;
    }

    int q = a/b;
        int r = a -q*b;
    
        if(r == 0)
    {
      int[] output = {0, 1};
      return output;
    }
    
        int[] next = euclidean(b, r);
    
    int[] output = {next[1], next[0] - q*next[1]};
    return output;
  }
  
    public static int leastPosEquiv(int a, int m)
  {
        if(m < 0)
      return leastPosEquiv(a, -1*m);
        if(a >= 0 && a < m)
      return a;
    
            if(a < 0)
      return -1*leastPosEquiv(-1*a, m) + m;
    
        
        int q = a/m;
    
    
    return a - q*m;
  }
  
  public static void main(String[] args)
  {
	
    int[] constraints = {2,3,4,5};     int[] mods = {5,7,9,11};     
        int M = 1;
    for(int i = 0; i < mods.length; i++)
      M *= mods[i];
    
    int[] multInv = new int[constraints.length];
    
    
    for(int i = 0; i < multInv.length; i++)
      multInv[i] = euclidean(M/mods[i], mods[i])[0];
    
    int x = 0;
    
        for(int i = 0; i < mods.length; i++)
      x += (M/mods[i])*constraints[i]*multInv[i];
    
    x = leastPosEquiv(x, M);
    
    System.out.println("x is equivalent to " + x + " mod " + M);
  }
}