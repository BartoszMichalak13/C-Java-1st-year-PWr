#ifndef nag_hpp
#define nag_hpp
#include <iostream>
#include <stdlib.h>
#include <math.h>

using namespace std;
class IlePierwszych
{
        enum PLZ
        {
            pier,
            zlo
        };
    public:
        int licznik;
        int *p;
        int liczba(int m);
        void Pierwsze(int maks);
        ~IlePierwszych()
        {
            delete[] p;

        }

};

#endif
