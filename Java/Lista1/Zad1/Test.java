
public class Test
{
    public static void main(String[] args)
    {
        
        int i=0;
        int n=0;
        int s;
        int p;
        int len=args.length;

        try 
        {
            n=Integer.parseInt(args[i]); 
            if(n<=2)
            {
                System.out.println(args[i] + " - Nieprawidłowy zakres");
                System.exit(0);
            }
            LiczbyPierwsze t = new LiczbyPierwsze();
                t.liczbypierwsze(n);
           for(i=1; i<=len; i++)
           {
                s= Integer.parseInt(args[i]);
                p=t.liczba(s);
                if(p==1)
                    System.out.println(args[i] +" - liczba spoza zakresu");
                else if(p==(-1))
                    System.out.println(args[i] +" - nieprawidłowa dana");
                else
                    System.out.println(args[i] +" - "+ p);
           }
        }
        catch (NumberFormatException ex) 
        {
            System.out.println(args[i] + " - Nieprawidłowy zakres/nieprawidłowa dana");
        }
    }

}
