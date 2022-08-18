
public class LiczbyPierwsze
{
    int[] tab;
    int l=1;

    public void liczbypierwsze(int n)
    {
        tab = new int[n+1];
        if(n<3)
        {
            System.out.println("Podano nieprawidłowy zakres");
            return;
        }
        for(int i=0; (i+1)<n; i++)//wyp tablice
            tab[i]=i+2;
        
        
        while(tab[l]!=0)
        {  
            for(int i=0; i<l; i++)
            {
                if(tab[l]==0)//nie wiem czy bardzo potrzebne
                {
                    System.out.println("Koniec tablicy");
                    break;
                }
                if(tab[l]%tab[i]==0)
                {
                    int m=l;
                    while((l+1)<n)//przesuwacz
                    {
                        tab[l]=tab[l+1];
                        l++;
                    }
                    l=(m);
                    break;
                }
            }
            l++;
        }
    }
    
    public int liczba(int u) 
    {   

        if(u<l-1&&u>=0)//l-1 bo po zakonczeniu metody liczbypierwsze jest jeszcz l++
            return tab[u];
        else if(l-1<=u)   
            return 1;
        else 
            return -1;
    }
}
