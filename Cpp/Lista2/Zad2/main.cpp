#include "hed.hpp"
#include <string> 

int main(int argc, char** argv)
{

    int maks;
    try
    {
        maks=stoi(argv[1]);
    }
    catch(std::invalid_argument f)
    {
        cout<<argv[1] <<" - nieprawidłowy zakres\n";
        exit(5);
    }
    if(stoi(argv[1])<=0)
    {
        cout<<argv[1] <<" - nieprawidłowy zakres\n";
        exit(5);
    }
	if(stoi(argv[1])==1)
	{
		cout<< argv[1]<< (" - Trójkąt Pascala to sama 1\n");//mozna przenieść do Test
		return 0;
	}
	
	WTP w;
	w.WierszTrojkatPascala(maks);
	
	for(int i=2; i<argc; i++)
	{
		int s;
		
		try
		{
        	s=stoi(argv[i]);
    	}
    	catch(std::invalid_argument f)
		{
			cout<< argv[i]<< " - Nieprawidłowy argument\n";
			break;
		}
		int p=w.wspolczynnik(s);

		if(p==(-1))
			cout<< argv[i]<< " - Nieprawidłowy argument\n";
		else if(p==0)
			continue;
		else
			cout<< argv[i]<< " - "<< p << "\n";
	}
}

