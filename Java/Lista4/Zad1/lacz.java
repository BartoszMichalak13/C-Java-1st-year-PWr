class Small extends Exception{};
public class lacz
{
    public static void main(String[] args)
    {
        
        int n=0;
        try
        {
            n=Integer.parseInt(args[0]);
            if(n<0)
                throw new Small();
        }
        catch(NumberFormatException e)
        {
            System.out. println("Musisz podać liczbę");
        }
        catch(Small e)
        {
            System.out. println("Musisz podać liczbę >=0");
        }
        catch(Exception e)
        {
            System.out. println("Niespodzianka");
        }


        gui frame = new gui();
        frame.app(n);
        //frame.setVisible(true);
        

        
    }


}