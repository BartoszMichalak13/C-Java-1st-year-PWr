import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.StageStyle;
import javafx.scene.layout.GridPane;
/**Obluga okna dialogowe info
*
*/
public class OD 
{
    public void wysk(int i)
    {
    	
    	if(i==1)
    	{
        Dialog<String> dialog= new Dialog<String>();
        dialog.setTitle("Info");
        ButtonType type= new ButtonType("Close", ButtonData.CANCEL_CLOSE);
        GridPane grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);
        grid.setPadding(new Insets(20, 15, 10, 10));
        grid.add(new Label("Autor: Bartosz Michalak "), 0, 0);
        grid.add(new Label("Przeznaczenie: Zaliczenie listy5 "), 0, 1);
        grid.add(new Label("Nazwa Programu: Malarz "), 1, 0);
        grid.add(new Label("Data stworzenia: 04.05.2022 "), 1, 1);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.getDialogPane().setContent(grid);
        dialog.showAndWait();
        }
        else if(i==2)
        {
                       Dialog<String> dialog1= new Dialog<String>();
			dialog1.setTitle("Instrukcja Obslugi");
			ButtonType type= new ButtonType("Close", ButtonData.CANCEL_CLOSE);
			GridPane grid = new GridPane();
			grid.setHgap(3);
			grid.setVgap(3);
			grid.setPadding(new Insets(20, 15, 10, 10));
			grid.add(new Label("Aby utworzyć figurę zaznacz 2punkty (jeśli chcesz stworzyć koło lub prostokąt) lub 3 jeśli chcesz stworzyć trójkąt, a następnie kliknij w menu figurę którą chcesz utworzyć "), 0, 0);
			grid.add(new Label("Aby obrócić figurę kliknij na nią dwukrotnie i poruszaj myszką"), 0, 1);
			grid.add(new Label("Aby przesunac figurę naciśnij na nią i poruszaj myszką"), 1, 0);
			grid.add(new Label("Aby zwiększyć figurę najedz na nia myszką i poruszaj scrollem"), 1, 1);
			grid.add(new Label("Aby zmienić kolor kliknij na figurę prawym przyciskiem myszy i wybierz kolor"), 1, 2);
			dialog1.getDialogPane().getButtonTypes().add(type);
			dialog1.initStyle(StageStyle.UTILITY);
			dialog1.getDialogPane().setContent(grid);
			dialog1.showAndWait();
        }
    }

}
