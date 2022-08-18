import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.Group; 
import javafx.scene.input.MouseEvent;
import java.lang.Math;
import javafx.scene.input.MouseButton;
//TODO: instrkukcja obsługi, dokumentacja
/**
 * Główna klasa zawierająca menu {@link GUI GUI}
 * @version 1.0
 * @author Bartosz Michalak
 */
public class GUI extends Application
{
    BorderPane root = new BorderPane();
    Group gr;

	/**
	*	@param x wspolrzedna x ostatniego kliknięcia  
	*	@param y wspolrzedna y ostatniego kliknięcia  
	*	@param i ilość kropek
	*	@param tabp tablica punktów
	*/

    double x;
    double y;
    Point2D[] tabp= new Point2D[4];
    int i=0;
	/**Funkcja głowna clasy GUI
	*	@param stage stage
	*	
	*/
    @Override
    public void start(Stage stage)
    {
        class BorderPaneListener implements EventHandler<MouseEvent>
        {
        	/**	Funkcja służąca do zaznaczania wybranych punktów(sprawiała problemy, nie używana)
        	*	@deprecated draw()
        	*/
            //gdybym chcial rysyowac
            public void draw()
            {
                Circle circle= new Circle(x,y, 5);
                circle.setFill(Color.RED);
                circle.setStrokeWidth(3);
                circle.setStroke(Color.BLACK);
                gr= new Group();
                gr.getChildren().add(circle);
                root.getChildren().add(gr);
            }
            
            @Override
            public void handle(MouseEvent event) 
            {   
            /**Funkcja znajdująca kliknięcia myszki
            *		@param handle
            *
            */
                if(event.getButton() == MouseButton.PRIMARY)
                {
                    x=event.getX();
                    y=event.getY();
                    tabp[i]=new Point2D(x,y);
                    i++;
                    //draw();
                    System.out.println(x + "to jest x"+ y+  "to jest y");
                    if(i>=4)
                        i=0;
                }

            }
        }


        MenuBar mymenu= new MenuBar();
        Menu menu1= new Menu("Menu");
        Menu figury= new Menu("Figury");
        SeparatorMenuItem separator= new SeparatorMenuItem();
        SeparatorMenuItem separator1= new SeparatorMenuItem();
        SeparatorMenuItem separator2= new SeparatorMenuItem();
        root.setOnMouseClicked(new BorderPaneListener());
        	/** Funkcja zajmująca się obsługą menu
        	* 	@param x1 wspolrzedna x pierwszego punktu
        	*	@param y1 wspolrzedna y pierwszego punktu
        	*	@param x2 wspolrzedna x drugiego punktu
        	*	@param y2 wspolrzedna y drugiego punktu
        	*	@param x3 wspolrzedna x trzeciego punktu
        	*	@param y3 wspolrzedna y trzeciego punktu
        	*	@param Radius promien koła
        	*	@param width szerokość prostokata
        	*	@param height wysokosc prostokata
        	*	@param xmax wspolrzedna x dla konstruktora prostokata
        	*	@param ymax wspolrzedna y dla konstruktora prostokata
         	*/
        EventHandler<ActionEvent> evnHandler = new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                MenuItem m =(MenuItem) event.getSource(); 
                if(m.getText().equals("Info"))//w wolnej chwili mozna sprobowac dac to nie w menu    
                {
                    OD w=new OD();
                    w.wysk(1);
                }    
                else if (m.getText().equals("Exit")) 
                    System.exit(0);
                else if (m.getText().equals("Circle"))
                {
                    if(i>1)
                    {
                    	
                        double x1=tabp[0].getX();
                        double y1=tabp[0].getY();
                        double x2=tabp[1].getX();
                        double y2=tabp[1].getY();
                        
                        double Radius=Math.sqrt(Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2));

                        Okrag cir = new Okrag(x1, y1, Radius);
                        root.getChildren().add(cir);
                        i=0;                     
                    }
                    
               
                }
                else if (m.getText().equals("Rectangle"))
                {
                    
                            if(i>1)
                            {
				 double x1=tabp[0].getX();
                                double y1=tabp[0].getY();
                                double x2=tabp[1].getX();
                                double y2=tabp[1].getY();
                                
                                double width=Math.abs(x1-x2);
                                double height=Math.abs(y1-y2);
                                double xmax=Math.min(x1,x2);
                                double ymax=Math.min(y1,y2);
                                Rect rect = new Rect(xmax, ymax, width, height);
                                root.getChildren().add(rect);
                                i=0;
                                             
                            }
                }
                else if (m.getText().equals("Triangle"))
                {
                    if(i>2)
                    {
                        double x1=tabp[0].getX();
                        double y1=tabp[0].getY();
                        double x2=tabp[1].getX();
                        double y2=tabp[1].getY();
                        double x3=tabp[2].getX();
                        double y3=tabp[2].getY();
                                             
                        Triangle triangle= new Triangle(x1,y1,x2,y2,x3,y3);
                        root.getChildren().add(triangle);
                        i=0;
                                        
                    }
                }
                else if(m.getText().equals("Instrukcja"))
                {
			OD w=new OD();
                    	w.wysk(2);
                }
                
            }
        };

        MenuItem i1=new MenuItem("Circle");
        i1.setOnAction(evnHandler);
        MenuItem i2=new MenuItem("Rectangle");
        i2.setOnAction(evnHandler);
        MenuItem i3=new MenuItem("Triangle");
        i3.setOnAction(evnHandler);
        MenuItem info=new MenuItem("Info");
        info.setOnAction(evnHandler);
        MenuItem exit=new MenuItem("Exit");
        exit.setOnAction(evnHandler);
        MenuItem instrukcja=new MenuItem("Instrukcja");
        instrukcja.setOnAction(evnHandler);
       
        figury.getItems().addAll(i1,i2,i3);
        menu1.getItems().addAll(figury,separator,info,separator1,instrukcja,separator2,exit);

        mymenu.getMenus().addAll(menu1);
        mymenu.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        root.setTop(mymenu);
        
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Malarz");
        stage.setScene(scene);
        stage.show();
    }
	/**
	*	Funkcja main uruchamiająca aplikację
	*/
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
}
