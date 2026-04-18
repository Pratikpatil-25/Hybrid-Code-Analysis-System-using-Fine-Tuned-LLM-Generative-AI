public class Knap

{  



public static int max(int a1, int a2)  

{  

return (a1 > a2) ? a1 : a2;  

}  




public int maxknapSackVal(int C, int wt[], int v[], int l)  

{  


if (l == 0 || C == 0)  

{  

    
    
    
    return 0;  

}  





if (wt[l - 1] > C)  

{  

return maxknapSackVal(C, wt, v, l - 1);  

}  

else  

{  



int val1 = maxknapSackVal(C - wt[l - 1], wt, v, l - 1);  


int val2 = maxknapSackVal(C, wt, v, l - 1);  


return max(v[l - 1] + val1, val2);  

}  

}  


public static void main(String argvs[])  

{  


int values[] = new int[] { 100, 60, 120 };  

int weight[] = new int[] { 20, 10, 30 };  


int C = 50;  


int length = values.length;  


K

nap knapObj = new Knap();  

int maxVal = knapObj.maxknapSackVal(C, weight, values, length);  

System.out.println("The maximum value is: " + maxVal);  

}  

}