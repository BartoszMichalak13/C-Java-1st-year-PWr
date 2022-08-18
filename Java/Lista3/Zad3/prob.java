public class prob{

    public Boolean proba(String z1)
    {
        int m=0;
        try
        {
        m=Integer.parseInt(z1);
        if(m<=0)
            throw new Small();
        }
        catch(NumberFormatException e)
        {
            System.out.println(z1 + " - nie jest liczbą");
            return false;
        }
        catch(Small e)
        {
            System.out.println(z1 + " - nie jest dodatnie");
            return false;
        }
        catch(Exception e)
        {
            System.out.println(z1 + " - jest nie odpowiednie");
            return false;
        }
        return true;
    }
}