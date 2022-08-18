public class TEST
{
	public static void main(String[] args)
	{

		int k=0;
		int n=0;
		int len=args.length;
		try
		{
			n=Integer.parseInt(args[k]); 
		}
		catch(NumberFormatException ex) 
		{
		    System.out.println(args[k] + "-Nieprawidłowy zakres/nieprawidłowa dana");
		    System.exit(0);
		}
		if(n<=0)
		{
			System.out.println("Zła wartość");
			return;
		}
		if(n==1)
		{
			System.out.println("Trójkąt Pascala to sama 1");//mozna przenieść do Test
			return;
		}
		
		WTP w= new WTP();
		w.WierszTrojkatPascala(n);
		
		for(int i=1; i<len; i++)
		{
			int s;
			
			try
			{
			s=Integer.parseInt(args[i]);
			}
			catch(NumberFormatException e)
			{
				System.out.println(args[i]+"-Nieprawidłowy argument");
				break;
			}
			int p=0;
			try
			{
				p=w.wspolczynnik(s);
			}
			catch(Small e)
			{
				System.out.println(args[i]+"-Podano za mały argument");
			}
			catch(Big e)
			{
				System.out.println(args[i]+"-Podano za duży argument");
			}
			if(p==(-1))
				System.out.println(args[i]+"-Nieprawidłowy argument");
			else if(p==0)
				continue;
			else
				System.out.println(args[i] +" - "+ p);
		}
    }
    

}

	
