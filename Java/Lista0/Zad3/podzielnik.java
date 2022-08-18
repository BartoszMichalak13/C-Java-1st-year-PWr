
public class podzielnik
{
    public static void main(String[] args)
    {
        int len= args.length;
        
        for(int i=0; i<len; i++)
        {

            int n=0;
            try 
            { 
                n=Integer.parseInt(args[i]); 
                int m = div(n);
                System.out.println(args[i] + ", " + m);
            }
            catch (NumberFormatException ex)
            {
                
                System.out.println(args[i] + " nie jest liczba calkowita");
            }



        }
    }
    public static int div(int n)
    {
        int m =0;
        for(int i=2; i<n; i++)
        {
            if(n%i==0)
            return n/i;

        }
        return 1;      
    }
}