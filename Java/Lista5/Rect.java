
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate; 
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.event.*;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.ContextMenuEvent;
// Nowa klasa prostokata

public class Rect extends Rectangle 
{
  public Rect(double x, double y, double width, double height) 
  { 
    super(x, y, width, height);
    setFill(Color.RED);
    setOnMouseClicked(new FXRectangleEventHandler());
    setOnMouseDragged(new FXRectangleEventHandler());
    setOnScroll(new FXRectangleScrollHandler());
    ColorPicker colorPicker = new ColorPicker();

    EventHandler wyborKolor = new EventHandler() 
    {
        @Override
        public void handle(Event event) {
            Rect.this.setFill(colorPicker.getValue());
        }
    };
    colorPicker.setOnAction(wyborKolor);
    ContextMenu contextMenu = new ContextMenu();
    MenuItem menuKolor = new MenuItem(null, colorPicker);
    contextMenu.getItems().addAll(menuKolor);
    setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
      
      @Override
      public void handle(ContextMenuEvent contextMenuEvent) {

          contextMenu.show(Rect.this, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());
      }
  });
  }
    /**Metoda sprawdzajaca czy trafiono figure
    *
    */
  /// Metoda sprawdza czy najechalismy na figure
  public boolean isHit(double x, double y) 
  { 
    return getBoundsInLocal().contains(x,y);   
  }

  // Zmiana wspolrzednej x prostakata
  public void addX(double x) 
  {  
    setX(getX()+x);
  }

  // Zmiana wspolrzednej y prostakata
  public void addY(double y) 
  {  
    setY(getY()+y);
  }
  
  // Zmiana szerokosci prostokata
  public void addWidth(double w) 
  {
    setWidth(getWidth()+w);
  }
  
  // Zmiana wysokosci prostokata
  public void addHeight(double h) 
  {     
    setHeight(getHeight()+h);
  }

  
  /**Obsluga myszy
  *
  *
 	*/
  class FXRectangleEventHandler implements EventHandler<MouseEvent>
  {
    
    Rect rectangle;
    private double x;
    private double y;
    private double width;
    private double height;
    
    private void doMove(MouseEvent event) 
    {      
      double dx=event.getX()-x;
      double dy=event.getY()-y;
      // Jesli nacisnelismy na elipse
      if(rectangle.isHit(x, y)) 
      {
        rectangle.addX(dx);
        rectangle.addY(dy);
      }
      x+=dx;
      y+=dy;            
    }
    public void doRotate(MouseEvent event)
    {
      if(rectangle.isHit(x, y))
      {
        Rotate rotate = new Rotate();
        rotate.setPivotX(x+(width)/2);
        rotate.setPivotY(y+(height)/2);
        rotate.setAngle((event.getX()-event.getY())*0.001);
        rectangle.getTransforms().addAll(rotate);
        rectangle.getTransforms().add(rotate);
      }
                    
    }         
  
    @Override
    public void handle(MouseEvent event) 
    {
      rectangle=(Rect) event.getSource();
      if(event.getEventType()==MouseEvent.MOUSE_CLICKED)
      {
        x=event.getX();
        y=event.getY();

      }
      if(event.getEventType()==MouseEvent.MOUSE_DRAGGED)
      {
        if(event.getClickCount()==2)
          doRotate(event);
        else
          doMove(event);
       
      }
      if(event.getButton() == MouseButton.SECONDARY)
      {


      }
      
    }
  }

  /**Obsluga myszy
  *
  *
  */
  // Implementacja scrollowania   
  class FXRectangleScrollHandler implements EventHandler<ScrollEvent>
  {

    Rect rectangle;
    private void doScale(ScrollEvent e) 
    {       
      double x=e.getX();
      double y=e.getY();
  
      // Jesli nacisnelismy na elipse
      if(rectangle.isHit(x, y)) 
      {                 
        rectangle.addWidth(e.getDeltaY()*0.2);
        rectangle.addHeight(e.getDeltaY()*0.2);
      }
    }            
    @Override
    public void handle(ScrollEvent event) 
    {
      rectangle=(Rect) event.getSource();
      if (event.getEventType()==ScrollEvent.SCROLL)
        doScale(event);
    }
  }
}
