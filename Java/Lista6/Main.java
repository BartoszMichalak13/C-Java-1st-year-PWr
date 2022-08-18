import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
/**
 * @version 1.0
 * @author Bartosz Michalak
 */
public class Main extends Application
{
    Radom random=new Radom();
    /**
     * @param n 
     * @param m 
     * @param speed
     * @param prob  
     */
    int n=15;
    int m=15;
    int speed=500;
    double prob=0.00;
    Kom[][] table = new Kom[n][m];
    /**
     * Glowna funkcja obslugujaca gui
     */
    @Override
    public void start(Stage stage)
    {
        GridPane gl=new GridPane();
        gl.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                int r=random.gen().nextInt(256);
                int g=random.gen().nextInt(256);
                int b=random.gen().nextInt(256);
                Kom kom= new Kom(Color.rgb(r,g,b) );
                kom.widthProperty().bind(gl.widthProperty().divide(n));
                kom.heightProperty().bind(gl.heightProperty().divide(m));
                gl.add(kom, i, j);
                table[i][j]=kom;
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                int sg=j-1;
                int sd=(j+1)%m;
                int sl=i-1;
                int sp=(i+1)%n;
                if(i==0)
                    sl=n-1;
                if(j==0)
                    sg=m-1;
                table[i][j].setNei(table[i][sg], table[i][sd], table[sl][j], table[sp][j]);
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                Watki t1= new Watki(table[i][j], speed, prob);
                t1.setDaemon(true);
                t1.start();
            }
        }
        Scene scene = new Scene(gl, 1600, 900);
        stage.setTitle("Lista6");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
}

