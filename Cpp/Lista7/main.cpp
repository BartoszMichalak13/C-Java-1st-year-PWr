#include "head.hpp"
using namespace std;
/**
 * @version 1.0
 * @author Bartosz Michalak
 */
/**
 * Funkcja Obslugujaca drzewa
 * @param val wartosc szukana/usuwana/wpisywana
 * @param text polecenia użytkownika
 */
template <typename T>
string handle(Tree<T>* &tree)
{
    T val;
    while(true)
    {
        string text;
        cout<<"Podaj polecenie"<<endl;
        cin>> text;
        if(text=="draw")
        {
            cout<<tree->draw()<<endl;
        }
        else if(text=="insert")
        {
            cout<<"Podaj wartosc"<<endl;
            cin>> val;
            tree->insert(val);
            cout<<tree->draw()<<endl;
        }
        else if(text=="search")
        {
            cout<<"Podaj wartosc"<<endl;
            cin>> val;
            if(tree->search(val))
                cout<<"Znaleziono element"<<endl;
            else   
                cout<<"Nie znaleziono elementu"<<endl;
        }
        else if(text=="delete")
        {
            cout<<"Podaj wartosc"<<endl;
            cin>> val;
            tree->delete1(val);
            cout<<tree->draw()<<endl;
        }
        else if(text=="bye")
            return "Pa pa";
        else
            cout<<"Podano zle polcenie"<<endl;
    }
}
/**
 * Głowna funkcja tworzaca dany rodzaj drzewa
 * @param dint drzewo int
 * @param ddouble drzewo double
 * @param dstring drzwo string
 */ 
int main()
{
    Tree<int>* dint= new Tree<int>();
    Tree<double>* ddouble= new Tree<double>();
    Tree<string>* dstring= new Tree<string>();
    /**
     * Pętla wybierania rodzaju drzewa
     * @param text input użytkownika
     */
    while(true)
    {
        cout<<"Podaj rodzaj drzewa"<<endl;
        string text="";
        cin >>text;
        if(text=="Integer")
        {
            cout<< handle(dint)<<endl;
            break;
        }
        if(text=="Double")
        {
            cout<< handle(ddouble)<<endl;
            break;
        }
        if(text=="String")
        {
            cout<< handle(dstring)<<endl;
            break;
        }
        else
            cout<<"Podano zly rodzaj drzewa"<<endl;
    } 
}