#include "nag.hpp"

void IlePierwszych::Pierwsze(int n)
{
    licznik=0;
    PLZ *dana= new PLZ[n+1];
    
    dana[0]=zlo;
    dana[1]=zlo;
    for(int i=2; i<=n; i++)//zakladamy ze all pierwsze
        dana[i]=pier;

    for(int i=2; i<=sqrt(n); i++)//i szukamy zlozonych
    {
        if(dana[i]==pier)
        {
            int kwadr=i*i;
            while(kwadr<=n)
            {
                dana[kwadr]=zlo;
                kwadr=kwadr+i;
            }
        }
    }

    for(int i=2; i<=n; i++)
    {
        if(dana[i]==pier) 
            licznik++;
    }
    p=new int[licznik];
    
    int roz=0;
    for(int i=2; i<=n; i++)
    {
        if(dana[i]==pier)
        {
            p[roz]=i;
            roz++;
        }
    }
    delete[] dana;

}

    int IlePierwszych::liczba(int m)
    {
        if(m<0 || m>licznik)
        {
            cout<< m<< "- Następnym razem wybierz coś między 0 a "<<licznik <<" Kod błędu\n"; 
            return 0;
        }
        else
            return p[m];
    }