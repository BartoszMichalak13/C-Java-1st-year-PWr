#include "nag.hpp"
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
    if(stoi(argv[1])<0)
    {
        cout<<argv[1] <<" - nieprawidłowy zakres\n";
        exit(5);
    }
    IlePierwszych tab;  
    tab.Pierwsze(maks);
    int licz;
    int num;
    if(2>argc)
    {
        cout << "Za mało argumentów\n";
        exit(3);
    }
    if(maks<2)
    {
        cout<< "Pierwsza liczba Pierwsza to 2, brak liczb pierwszych w zadanym zakresie\n";
        exit(4);
    }
     int i;
    try
    {
       
        for(i=2; i<argc; i++)//wypisujemy podane liczby pierwsze
        {
            num=stoi(argv[i]);
            if(num<0)      
                cout<<num <<" - nieprawidłowa dana\n";
            else
            {
                licz=tab.liczba(num);//zwraca liczbe z tabelki
                cout << num<< "-"<< licz<< "\n";
            }
        }

    }
    catch(std::invalid_argument e)
    {
        cout<<argv[i] <<" - nieprawidłowa dana\n";
    }
}