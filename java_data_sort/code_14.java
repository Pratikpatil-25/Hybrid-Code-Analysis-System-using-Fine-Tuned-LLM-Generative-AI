import java.io.*;
public class Q6
{
    int Sum[];
    String Word[],str;
    Q6()
    {
        str="";
    }

    void input()throws IOException    
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.print("Enter sentence in UPPERCASE : ");
            str=br.readLine();            
        }    
        while(str.charAt(str.length()-1)!='.' && str.charAt(str.length()-1)!=',' && str.charAt(str.length()-1)!='?' && str.charAt(str.length()-1)!='!');
        str=str.toUpperCase();
        str=str.trim();
        int c=0;
        for(int i=0;i<str.length();i++)
        {
            char w=str.charAt(i);
            if(w==' ' || w=='.' || w==',' || w=='?' || w=='!')c++;
        }
        Sum=new int [c];
        Word=new String [c];
        c=0;
        String s="";
        for(int i=0;i<str.length();i++)
        {
            char w=str.charAt(i);
            if(w==' ' || w=='.' || w==',' || w=='?' || w=='!')
            {
                Word[c]=s;
                c++;
                s="";
            }
            else s=s+w;
        }
    }

    void sort()
    {
        System.out.println("Word\tStrength");
        for(int i=0;i<Word.length;i++)
        {
            Sum[i]=0;
            for(int j=0;j<Word[i].length();j++)
            {
                char w=Word[i].charAt(j);
                Sum[i]+=((int)w-64);                
            }
            System.out.println(Word[i]+"\t"+Sum[i]);
        }
        for(int i=0;i<Sum.length;i++)
        {
            for(int j=0; j<Sum.length-i-1;j++)
            {
                if(Sum[j]>Sum[j+1])
                {
                    int t1=Sum[j];
                    Sum[j]=Sum[j+1];
                    Sum[j+1]=t1;

                    String t2=Word[j];
                    Word[j]=Word[j+1];
                    Word[j+1]=t2;
                }
            }
        }
    }

    void display()
    {        
        System.out.print("Sorted Sentence = ");
        for(int i=0;i<Sum.length;i++)
        {            
            System.out.print(Word[i]+" ");
        }
    }

    public static void main() throws IOException
    {
        Q6 obj=new Q6();
        obj.input();
        obj.sort();
        obj.display();
    }
}