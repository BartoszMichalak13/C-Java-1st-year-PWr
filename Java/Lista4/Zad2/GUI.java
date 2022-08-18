import java.io.*;
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
public class GUI extends Frame 
{
    public static void main(String[] args) 
    {
        Frame okno = new Frame("EXCERCISE DEUX");
        Box parent = Box.createVerticalBox();
        Label number= new Label();
        try
        {

            System.out.println("Creating Pascal triangle...");
            Process p = Runtime.getRuntime().exec("main.exe 5 0 1 2 3 4 5 6 7 aaa -6 15");

            BufferedReader reader = new BufferedReader
            (
                new InputStreamReader(p.getInputStream())
            );
            BufferedReader inErr = new BufferedReader
            (
                new InputStreamReader(p.getErrorStream())
            );

            String l;
            String c;
            while((l=reader.readLine())!=null)
            {
                /*
                if(r.read()!=0)
                {
                    f=String.valueOf(r.read());
                    number.setText(f);
                    parent.add(new Label(f,Label.CENTER));
                    System.out.println(f);
                }
                */
                number.setText(l);
                parent.add(new Label(l,Label.CENTER));
                System.out.println(l);
            }
            while ((c = inErr.readLine()) != null) 
                number.setText("Error: "+c+"\n");
            inErr.close();   
            reader.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        okno.add(parent);
        parent.setBackground(Color.MAGENTA);
        parent.setForeground(Color.BLACK);
        parent.setFont(new Font(Font.MONOSPACED, Font.BOLD,40));
        okno.addWindowListener(new MyWindowAdapter(parent));

        //okno.setMaximumSize(new Dimension(1920,1080));
        //okno.setMinimumSize(new Dimension(100,50));
        //okno.setPreferredSize(number.getSize());
        okno.pack();
        okno.setVisible(true);
        
    }
}
