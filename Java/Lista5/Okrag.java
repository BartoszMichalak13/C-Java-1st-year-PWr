import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Circle;
import javafx.scene.control.MenuItem;
import javafx.event.*;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.ContextMenuEvent;
// Nowa klasa elipsy
/**Zajmowanie sie kolem

*
*/
public class Okrag extends Circle
{     
    public Okrag(double x,double y,double radius) 
    {
        super(x,y,radius);
        setOnMouseClicked(new FXCircleEventHandler());
        setOnMouseDragged(new FXCircleEventHandler());
        setOnScroll(new FXCircleScrollHandler());
        ColorPicker colorPicker = new ColorPicker();

        EventHandler wyborKolor = new EventHandler() 
        {
            @Override
            public void handle(Event event) {
                Okrag.this.setFill(colorPicker.getValue());
            }
        };
        colorPicker.setOnAction(wyborKolor);
        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuKolor = new MenuItem(null, colorPicker);
        contextMenu.getItems().addAll(menuKolor);
        setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
          
          @Override
          public void handle(ContextMenuEvent contextMenuEvent) {
    
              contextMenu.show(Okrag.this, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());
          }
      });
    }
    /**Metoda sprawdzajaca czy trafiono figure
    *
    */
    /// Metoda sprawdza czy najechalismy na figure
    public boolean isHit(double x,double y) 
    { 
        return getBoundsInLocal().contains(x,y);  
    }
    // Zmiana wspolrzednej x elipsy
    public void addX(double x) 
    {  
        this.setCenterX(this.getCenterX()+x);
    }
    // Zmiana wspolrzednej y elipsy
    public void addY(double y) 
    {         
        this.setCenterY(this.getCenterY()+y);
    }
    // Zmiana szerokosci elipsy
    public void addRadius(double w) 
    {    
        this.setRadius(this.getRadius()+w);
    }
  /**Obsluga myszy
  *
  *
  */
    //Implementacja scrollowania   
    class FXCircleScrollHandler implements EventHandler<ScrollEvent>
    {
        Okrag circle;
        private void doScale(ScrollEvent e) 
        {    
            double x=e.getX();
            double y=e.getY();
            // Jesli nacisnelismy na elipse
            if(circle.isHit(x,y))                
                circle.addRadius(e.getDeltaY()*0.2);
        }            
        @Override
        public void handle(ScrollEvent event) 
        {
            circle=(Okrag)event.getSource();
            if(event.getEventType()==ScrollEvent.SCROLL)
                doScale(event);
        }
    }
      
  /**Obsluga myszy
  *
  *
  */
  // Implementacja przesuwania
    class FXCircleEventHandler implements EventHandler<MouseEvent>
    {
        Okrag circle;
        private double x;
        private double y;
        private void doMove(MouseEvent event) 
        {     
            double dx=event.getX()-x;
            double dy=event.getY()-y;
            // Jesli naciselismy na elipse
            if(circle.isHit(x,y)) 
            {
                circle.addX(dx);
                circle.addY(dy);
            }
            x+=dx;
            y+=dy;            
        }
    
        @Override
        public void handle(MouseEvent event) 
        {
            circle=(Okrag)event.getSource();
            if (event.getEventType()==MouseEvent.MOUSE_CLICKED)
            {
                x=event.getX();
                y=event.getY();
            }
            if(event.getEventType()==MouseEvent.MOUSE_DRAGGED)
                doMove(event);
        }
    }
}
