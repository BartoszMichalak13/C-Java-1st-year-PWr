#include "hed.hpp"
#include "Fig.hpp"
#include <string> 
bool proba(string z1)
{
    int m=0;
    try
    {
        m=stoi(z1);
        if(m<=0)
        throw Small();
    }
    catch(std::invalid_argument e)
    {
        cout<<z1 << " - nie jest liczbą"<<endl;
        return false;
    }
    catch(Small e)
    {
        cout<<z1 + " - nie jest dodatnie"<<endl;
        return false;
    }
    catch(exception e)
    {
        cout<<z1 << " - jest nie odpowiednie"<<endl;
        return false;
    }
    return true;
}
