import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate; 
import javafx.geometry.Point2D;
import java.lang.Math;
import javafx.scene.control.MenuItem;
import javafx.event.*;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.ContextMenuEvent;

// Nowa klasa prostokata
public class Triangle extends Polygon
{
  public Triangle(double x1,double y1,double x2,double y2,double x3,double y3) 
  { 
    super(x1,y1,x2,y2,x3,y3);
    setFill(Color.BLUE);
    setOnMouseClicked(new FXTriangleEventHandler());
    setOnMouseDragged(new FXTriangleEventHandler());
    setOnScroll(new FXTriangleScrollHandler());
    ColorPicker colorPicker = new ColorPicker();

    EventHandler wyborKolor = new EventHandler() 
    {
        @Override
        public void handle(Event event) {
            Triangle.this.setFill(colorPicker.getValue());
        }
    };
    colorPicker.setOnAction(wyborKolor);
    ContextMenu contextMenu = new ContextMenu();
    MenuItem menuKolor = new MenuItem(null, colorPicker);
    contextMenu.getItems().addAll(menuKolor);
    setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
      
      @Override
      public void handle(ContextMenuEvent contextMenuEvent) {

          contextMenu.show(Triangle.this, contextMenuEvent.getScreenX(), contextMenuEvent.getScreenY());
      }
  });
  }

  double area(double x1, double y1, double x2, double y2, double x3, double y3)
  {
    return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
  }
    /**Metoda sprawdzajaca czy trafiono figure
    *
    */
  /* A function to check whether point P(x, y) lies inside the triangle formed
    by A(x1, y1), B(x2, y2) and C(x3, y3) */
  boolean isHit(double x1,double y1,double x2, double y2, double x3, double y3, double x, double y)
  {  
    /* Calculate area of triangle ABC */
    double A = area (x1, y1, x2, y2, x3, y3);
    
    /* Calculate area of triangle PBC */ 
    double A1 = area (x, y, x2, y2, x3, y3);
    
    /* Calculate area of triangle PAC */ 
    double A2 = area (x1, y1, x, y, x3, y3);
    
    /* Calculate area of triangle PAB */  
    double A3 = area (x1, y1, x2, y2, x, y);
    
    /* Check if sum of A1, A2 and A3 is same as A */
    return (A == A1 + A2 + A3);
  }
  
  /**Obsluga myszy
  *
  *
 	*/
  class FXTriangleEventHandler implements EventHandler<MouseEvent>
  //class MouseTrojkat implements EventHandler<MouseEvent> 
  {

    Triangle trojkat;
    private double x, y;
    private double x1,y1,x2,y2,x3,y3;
    Point2D p1=new Point2D(x1, y1);
    Point2D p2=new Point2D(x2, y2);
    Point2D p3=new Point2D(x3, y3);
    Point2D centre = p1.midpoint(p2).midpoint(p3);
    /**
     * Metoda zajmująca się zmienianiem położenia figury w zależności od położenia myszy
     * @param event
     */

    private void przenies(MouseEvent event) 
    {
        double dx=event.getX()-x; 
        double dy=event.getY()-y;
        if(isHit(x1,y1,x2,y2,x3,y3,x,y)) 
        {

            for (int i = 0; i<trojkat.getPoints().size(); i++) 
            {
                if (i % 2 == 0) 
                {

                    trojkat.getPoints().set(i, trojkat.getPoints().get(i) + dx);
                    
                } else 
                {

                    trojkat.getPoints().set(i, trojkat.getPoints().get(i) + dy);
                    
                }
            }
        }
        x=x+dx;
        y=y+dy;
    }

    public void doRotate(MouseEvent event)
    {
      if(trojkat.isHit(x1,y1,x2,y2,x3,y3,x,y))
      {
        Rotate rotate = new Rotate();
        rotate.setPivotX(trojkat.getPoints().get(0));
        rotate.setPivotY(trojkat.getPoints().get(1));
        rotate.setAngle((event.getX()-event.getY())*0.001);
        trojkat.getTransforms().addAll(rotate);
        trojkat.getTransforms().add(rotate);
      }
                    
    }   
    /**
     * Metoda ustawia koordynaty myszy przy kliknięciu i przesuwa figure przy przesunięciu
     * @param event
     */
    @Override
    public void handle(MouseEvent event) {
        trojkat = (Triangle) event.getSource();
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) 
        {
            x = event.getX();
            y = event.getY();
        }
        if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) 
        {
          if(event.getClickCount()==2)
            doRotate(event);
          else
            przenies(event);
        }
    }
  }
 /**Obsluga myszy
  *
  *
  */
  // Implementacja scrollowania   
  class FXTriangleScrollHandler implements EventHandler<ScrollEvent>
  {

    Triangle triangle;
    private double x1,y1,x2,y2,x3,y3;
    Point2D p1=new Point2D(x1, y1);
    Point2D p2=new Point2D(x2, y2);
    Point2D p3=new Point2D(x3, y3);
    Point2D centre = p1.midpoint(p2).midpoint(p3);
    private void doScale(ScrollEvent e) 
    {       
      double x=e.getX();
      double y=e.getY();
  
      // Jesli nacisnelismy na elipse
      if(triangle.isHit(x1,y1,x2,y2,x3,y3,x,y)) 
      {         
        triangle.setScaleX(triangle.getScaleX()+e.getDeltaY()*0.001); 
        triangle.setScaleY(triangle.getScaleY()+e.getDeltaY()*0.001);
        triangle.setScaleZ(triangle.getScaleZ()+e.getDeltaY()*0.001);       
      }
    }            
  
    @Override
    public void handle(ScrollEvent event) 
    {
      triangle=(Triangle) event.getSource();
      if (event.getEventType()==ScrollEvent.SCROLL)
        doScale(event);
    }
  }
}
