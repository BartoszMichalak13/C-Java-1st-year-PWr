class Small extends Exception {};
class Big extends Exception {};
public class WTP
{
	int[] tab;
	int l;
	public void WierszTrojkatPascala(int n)
	{

		tab=new int[n+1];
		int[] t;
		t= new int[n+1];
		l=n;
		for(int j=1; j<=n; j++)
		{
			for(int i=0; i<j; i++)
			{
				if((i-1)<0||(i+1)==j)
					tab[i]=1;
				else
				{
					tab[i]=t[i-1]+t[i];
				}
				if((i+1)==j)
				{
					for(int k=0; k<j; k++)
						t[k]=tab[k];
				}
			}
		}
	}
	
	int wspolczynnik(int m) throws Small, Big
	{
		if(m>=l)
			throw new Big();
		else if(m<0)
			throw new Small();
		else if(m<l||m>=0)
			return tab[m];
		else
			return (-1);
	}
}

