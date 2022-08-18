#include "Fig.hpp"
#include "hed.hpp"
#include <string> 
int main(int argc, char** argv)//ma pisac jak zle arg dla czwor i jak za malo arg
{
    int n=0;

    /*
    int o=0;
    int c=0;
    int p=0;
    int s=0;
    */
    
    /*for(n=1; n<args.length; n++)//to jest teraz prob
    {
        try
        {
        int u=Integer.parseInt(args[n]);
        if(u<=0)
            throw new Small();
        }
        catch(NumberFormatException e)
        {
        System.out.println(args[n] + " - nie jest liczbą");
        }
        catch(Small e)
        {
        System.out.println(args[n] + " - nie jest dodatnie");
        }
        catch(Exception e)
        {
        System.out.println(args[n] + " - jest nie odpowiednie");
        }
    }
    */
    int j=2;
    for(int i=0; i+1<=argc; i++)//+/-1
    {
        if(j>argc)
        {
            cout<< "Nie podano argumentów"<<endl;         
            break;
        }
        if(argv[1][i]=='o')//koło
        {
            
            if(proba(argv[j])==true)
            {
                int m=stoi(argv[j]); 
                Disc kol;
                cout<<"Pole koła to: " << kol.Pole(m, 0)<<endl;
                cout<<"Obwód koła to: " << kol.Obw(m, 0)<<endl;
            }
            j++;
        }
        else if(argv[1][i]=='c')//czworokąty
        {
            if(j+4>=argc)
            {
                cout<<"Podano za mało argumentów"<<endl;
                break;
            }
            int w=0;    
            for(int k=0; k<5; k++)
            {
                if(proba(argv[j+k])==true)
                    continue;
                else
                    w=1;
            }

            if(w!=1)
            {
                int b1=stoi(argv[j]);//czwrookąty
                int b2=stoi(argv[j+1]);
                int b3=stoi(argv[j+2]);
                int b4=stoi(argv[j+3]);
                int deg=stoi(argv[j+4]);
                if(deg>=180)
                {
                    cout<<deg << " - jest nie odpowiednie"<<endl;
                    break;
                }
                //cout << "Bok 1: "<<  b1 <<"Bok 2: "<< b2 <<"Bok 3: "<< b3 <<"Bok 4: "<< b4 <<"Deg: "<< deg<<endl;
                if(deg>90&&deg<180)//żeby liczyc sin 30 a nie 120
                    deg=deg-90;
                if(deg!=90&&(b1==b2&&b2==b3&&b3==b4))//romb
                {
                    Rhombus rom;
                    cout<<"Pole rombu to: " <<rom.Pole(b1, deg)<<endl;
                    cout<<"Obw rombu to: " <<rom.Obw(b1, 0)<<endl;
                }
                else if(deg==90&&(b1==b2&&b2==b3&&b3==b4))//kwadrat
                {
                    Square kw;
                    cout<<"Pole kwadratu to: " << kw.Pole(b1, 0)<<endl;
                    cout<<"Obw kwadratu to: " << kw.Obw(b1, 0)<<endl;
                }//prostokąt
                else if(deg==90&&((b1==b2&&b3==b4)||(b1==b3&&b2==b4)||(b1==b4&&b3==b2)))
                {
                    int m; 
                    if(b1==b2)
                        m=b3;
                    else if(b1==b3)
                        m=b2;
                    else if(b1==b4)
                        m=b2;
                    else 
                    {
                        cout<<"To jest nie możliwe"<<endl;
                        break;
                    }
                
                        
                    Rectangle pr;
                    cout<<"Pole prostokąta to: " << pr.Pole(b1, m)<<endl;
                    cout<<"Obw prostokąta to: " << pr.Obw(b1, m)<<endl;
                }
                else 
                    cout<<"Podano nieodpowiednie argumenty"<<endl;
            }
            j=j+5;
        }
        else if(argv[1][i]=='p')//pięciokąt
        {
        
          
            if(proba(argv[j])==true)
            {
                int m=stoi(argv[j]);
                Pentagon Pen;
                cout<<"Pole pięciokąta to: " << Pen.Pole(m, 0)<<endl;
                cout<<"Obw pięciokąta to: " << Pen.Obw(m, 0)<<endl;
            }
            j++;
        }
        else if(argv[1][i]=='s')//sześciokąt
        {
         
            if(proba(argv[j])==true)
            {
                int m=stoi(argv[j]);
                Hexagon Hex;
                cout<<"Pole sześciokąta to: " << Hex.Pole(m, 0)<<endl;
                cout<<"Obw sześciokąta to: " << Hex.Obw(m, 0)<<endl;
            }
            j++;
        }
        else if(argv[1][i]=='\0')
            break;
        else
        {
            cout<<"Podano nieprawidłową figurę :" << argv[1][i]<<endl;
        }
    }
    return 0;
}

