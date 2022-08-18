public class pascal
{
    public String[] troj(int n)
    {

        int[] tab=new int[n+1];
        int[] t=new int[n+1];
        String[] m= new String[n+1];
        for(int j=1; j<=n; j++)
        {
            System.out.println();
            m[0]=" 1";
            for(int i=0; i<j; i++)
            {
                if((i-1)<0||(i+1)==j)
                {
                    tab[i]=1;
                    System.out.print(tab[i]+" ");
                    String s=String.valueOf(tab[i]);
                    if(i+1==j)
                        m[j-1]=m[j-1]+" "+s;
                    else
                        m[j-1]=" 1";
                }
                else
                {
                    tab[i]=t[i-1]+t[i];
                    System.out.print(tab[i]+" ");          
                    m[j-1]=m[j-1]+" "+tab[i];
                }
                if((i+1)==j)
                {
                    for(int k=0; k<j; k++)
                        t[k]=tab[k];
                        
                }
            }
        }
        return m;
    
    }
}