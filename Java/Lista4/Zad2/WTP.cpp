#include "hed.hpp"
#include "exc.hpp"
#include <exception>
void WTP::WierszTrojkatPascala(int n)
{

	tab=new int[n+1];
	int *t;
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

int WTP::wspolczynnik(int m)
{
	try
	{
		if(m>=l)
			throw Big();
		else if(m<0)
			throw Small();
		else if(m<l||m>=0)
			return tab[m];
		else
			return (-3);
	}
	catch(Small e)
	{
		cerr<< m << e.what() <<endl;
		return 0;
	}
	catch(Big e)
	{
		cerr<< m << e.what() <<endl;
		return 0;
	}

}
