import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;
public class Kom extends Rectangle
{
    /**
     *  @param Nei lista sasiadow
     *  @param ac stan komórki(aktywna lub nie)
     */
    Radom random =new Radom();
    List<Kom> Nei= new ArrayList<>();
    Boolean ac=false;
    /**
     * Konstruktor komórek, maluje je w zadanym kolorze
     * @param color
     */
    public Kom(Color color)
    {
        this.setFill(color);
        setOnMouseClicked(new isActive());
    }
    /**
     * Zwraca stan komorki
     * @param kom dana komorka
     * @return stan komorki
     */
    public boolean st(Kom kom){return ac;}
    class isActive implements EventHandler<MouseEvent> 
    {
        /**
         * Sprawdzanie czy komórka ma byc aktywna czy nie
         * @param x wspolrzedne x klikniecia myszka
         * @param y wspolrzedne y klikniecia myszka
         */
        public void isactive(double x, double y)
        {
            if(isHit(x, y)&&ac==false)
            {
                ac=true;
                System.out.println("nietraf");
            }
            else
            {
                System.out.println("traf");
                ac=false;
            }
        }
        @Override
        public void handle(MouseEvent e)
        {
            double x=e.getX();
            double y=e.getY();
            isactive(x, y);
            System.out.println("Status:"+ac);
        }
    }
    /**
     * Sprawdza czy trafiono w komórke
     * @param x wspolrzedna x 
     * @param y wspolrzedna y
     * @return czy trafiono czy nie
     */
    public boolean isHit(double x, double y){return getBoundsInLocal().contains(x,y);}
    /**
     * Dodaje sasiadow do listy
     * @param k1 sasiad1
     * @param k2 sasiad2
     * @param k3 sasiad3
     * @param k4 sasiad4
     */
    public void setNei(Kom k1, Kom k2, Kom k3, Kom k4)
    {
        Nei.add(k1);
        Nei.add(k2);
        Nei.add(k3);
        Nei.add(k4);
    }
    /**
     * Zwraca liste sasiadow
     * @return lista sasiadow
     */
    public List<Kom> getNei(){return Nei;}
}
