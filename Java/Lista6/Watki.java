import javafx.application.Platform;
import javafx.scene.paint.Color;
public class Watki extends Thread
{
    /**
     * @param k nasz kwadracik
     * @param speed predkosc
     * @param prob prawdopodobienstwo
     */
    Kom k; 
    int speed;
    double prob;
    /**
     * Konstruktor Watkow
     * @param k nasz kwadracik
     * @param speed predkosc
     * @param prob prawdopodobienstwo
     */
    public Watki(Kom k, int speed, double prob)
    {
        this.k=k;
        this.speed=speed;
        this.prob=prob;
    }
    Radom random =new Radom();
    /**
     * Funkacja malujaca
     * @param k nasz kwadracik
     * @param speed predkosc
     * @param prob prawdopodobienstwo
     */
    synchronized public void cchange(Kom k, int speed, double prob)
    {
        if(random.gen().nextDouble()<=prob)
        {
            int r=random.gen().nextInt(256);
            int g=random.gen().nextInt(256);
            int b=random.gen().nextInt(256);
            Platform.runLater(() -> { k.setFill(Color.rgb(r,g,b)); });
        }
        else
        {
            int licznik=0;
            int r=0, g=0, b=0;
            for(int i=0; i<k.getNei().size();i++)
            {
                if(k.getNei().get(i).st(k.getNei().get(i))==true){}
                else
                {
                    Color c= (Color) k.getNei().get(i).getFill();
                    r+=(int) (c.getRed()*255);
                    b+=(int) (c.getBlue()*255);
                    g+=(int) (c.getGreen()*255);
                    licznik++;
                }
            }
            if(licznik==0)
                return;
            int rf=r/licznik, bf=b/licznik, gf=g/licznik;
            Platform.runLater(() -> { k.setFill(Color.rgb(rf,gf,bf)); });
        }
    }
    /**
     * Glowna funkcja watku
     * Sprawdza czy watek jest aktywny, jesli tak to uzywa metody cchange
     */
    @Override
    public void run()
    {
        while(true)
        {
            synchronized(k)
            {
                if(k.st(k)==false)
                {
                    cchange(k,speed,prob);       
                    try{Thread.sleep(random.gen().nextInt((int)1.0*speed)+(int)0.5*speed);}
                    catch(Exception e){System.out.println("Sleep failure");}
                }

            }
        }
    }    
}