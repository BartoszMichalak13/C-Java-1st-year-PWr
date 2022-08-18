#ifndef hed_hpp
#define hed_hpp

#include <iostream>
#include <stdlib.h>
#include <math.h>

using namespace std;

class WTP
{
    public:
	    int *tab;
	    int l;
	    void WierszTrojkatPascala(int n);
	    int wspolczynnik(int m);
    
	~WTP()
	{
		delete[] tab;
	}

};
/*
void main(int argc, char** argv);
void WierszTrojkatPascala(int n);
int wspolczynnik(int m);
*/
#endif