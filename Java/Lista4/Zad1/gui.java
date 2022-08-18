import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

class MyWindowAdapter extends WindowAdapter
{
    Box p;
    MyWindowAdapter(Box p) { this.p = p; }
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}
public class gui extends Frame
{
    public void app(int n)
    {
        Frame okno = new Frame("Trojkat Pascala");
        Box parent = Box.createVerticalBox();

        pascal t= new pascal();

        Label number= new Label();
        String[] m=t.troj(n);
        String g;

        for(int i=0; i<n; i++)
        {    
            g=m[i];
            number.setText(g);
            parent.add(new Label(g,Label.CENTER));
        }
        okno.add(parent);
        parent.setBackground(Color.RED);
        parent.setForeground(Color.BLUE);
        parent.setFont(new Font(Font.SANS_SERIF, Font.BOLD,40));
        okno.addWindowListener(new MyWindowAdapter(parent));

        //okno.setMaximumSize(new Dimension(1920,1080));
        //okno.setMinimumSize(new Dimension(100,50));
        //okno.setPreferredSize(number.getSize());
        okno.pack();
        okno.setVisible(true);
        
        //MONOSPACED
    }
}