import java.io.*;
import java.net.*;

/**
 * Klasa poszczegolnych watkow serwera
 */
public class MultiThread extends Thread 
{
    private Socket socket;
    public MultiThread(Socket socket){this.socket = socket;}
    /**
     * Podklasa zawierająca funkcje obsługujace drzewa typu INT, DOUBLE i STRING
     */
    public class Hand<T extends Comparable<T>>
    {
        /**
         * Funkcja Obslugujaca INT
         * @param tree drzewo typu int
         * @param in czytanie polecen uzytkownika
         * @param out wysylanie informacji zwrotnej
         * @return
         */
        String handleInt(Tree<Integer> tree, BufferedReader in, PrintWriter out)
        {
            try 
            {
                int val;
                while(true)
                {
                    String text;
                    out.println("Podaj polecenie");
                    text = in.readLine();
                    if(text.equals("draw"))
                    {
                        out.println(tree.draw()+" Press ENTER to confirm");
                        text = in.readLine();
                    }
                    else if(text.equals("insert"))
                    {
                        try
                        {
                            out.println("Podaj wartosc");
                            val= Integer.parseInt(in.readLine());
                            tree.insert(val);
                            out.println(tree.draw()+" Press ENTER to confirm");
                            text = in.readLine();
                        }
                        catch(NumberFormatException e)
                        {
                            out.println("Podano zly typ zmiennej"+" Press ENTER to confirm");
                            text = in.readLine();
                        }

                    }
                    else if(text.equals("search"))
                    {
                        try
                        {
                            out.println("Podaj wartosc");
                            val= Integer.parseInt(in.readLine());
                            tree.delete(val);
                            if(tree.search(val))
                            {
                                out.println("Znaleziono element"+" Press ENTER to confirm");
                                text = in.readLine();
                            }
                            else   
                            {
                                out.println("Nie znaleziono elementu"+" Press ENTER to confirm");
                                text = in.readLine();
                            }  
                        }
                        catch(NumberFormatException e)
                        {
                            out.println("Podano zly typ zmiennej"+" Press ENTER to confirm");
                            text = in.readLine();
                        }
  
                    }
                    else if(text.equals("delete"))
                    {
                        try
                        {
                            out.println("Podaj wartosc");
                            val= Integer.parseInt(in.readLine());
                            tree.delete(val);
                            out.println(tree.draw()+" Press ENTER to confirm");
                            text = in.readLine();
                        }
                        catch(NumberFormatException e)
                        {
                            out.println("Podano zly typ zmiennej"+" Press ENTER to confirm");
                            text = in.readLine();
                        }

                    }
                    else if(text.equals("bye"))
                    {
                        socket.close();
                        return "Pa pa";
                    }
                    else
                    {
                        out.println("Podano zle polcenie"+" Press ENTER to confirm");
                        text = in.readLine();
                    }
                }
            }
            catch(IOException ex)
            {
                out.println("Server exception in Hand: " + ex.getMessage());
                ex.printStackTrace();
                return "Jakis blad";
            }
        }
        /**
         * Funkcja Obslugujaca Double
         * @param tree drzewo typu double
         * @param in czytanie polecen uzytkownika
         * @param out wysylanie informacji zwrotnej
         * @return
         */
        String handleDouble(Tree<Double> tree, BufferedReader in, PrintWriter out)
        {
            try 
            {
                Double val;
                while(true)
                {
                    String text;
                    out.println("Podaj polecenie");
                    text = in.readLine();
                    if(text.equals("draw"))
                    {
                        out.println(tree.draw()+" Press ENTER to confirm");
                        text = in.readLine();
                    }
                    else if(text.equals("insert"))
                    {
                        try
                        {
                            out.println("Podaj wartosc");
                            val= Double.parseDouble(in.readLine());
                            tree.insert(val);
                            out.println(tree.draw()+" Press ENTER to confirm");
                            text = in.readLine();
                        }
                        catch(NumberFormatException e)
                        {
                            out.println("Podano zly typ zmiennej"+" Press ENTER to confirm");
                            text = in.readLine();
                        }

                    }
                    else if(text.equals("search"))
                    {
                        try
                        {
                            out.println("Podaj wartosc");
                            val= Double.parseDouble(in.readLine());
                            tree.delete(val);
                            if(tree.search(val))
                            {
                                out.println("Znaleziono element"+" Press ENTER to confirm");
                                text = in.readLine();
                            }
                            else   
                            {
                                out.println("Nie znaleziono elementu"+" Press ENTER to confirm");
                                text = in.readLine();
                            }  
                        }
                        catch(NumberFormatException e)
                        {
                            out.println("Podano zly typ zmiennej"+" Press ENTER to confirm");
                            text = in.readLine();
                        }
  
                    }
                    else if(text.equals("delete"))
                    {
                        try
                        {
                            out.println("Podaj wartosc");
                            val= Double.parseDouble(in.readLine());
                            tree.delete(val);
                            out.println(tree.draw()+" Press ENTER to confirm");
                            text = in.readLine();
                        }
                        catch(NumberFormatException e)
                        {
                            out.println("Podano zly typ zmiennej"+" Press ENTER to confirm");
                            text = in.readLine();
                        }

                    }
                    else if(text.equals("bye"))
                    {
                        socket.close();
                        return "Pa pa";
                    }
                    else
                    {
                        out.println("Podano zle polcenie"+" Press ENTER to confirm");
                        text = in.readLine();
                    }
                }
            }
            catch(IOException ex)
            {
                out.println("Server exception in Hand: " + ex.getMessage());
                ex.printStackTrace();
                return "Jakis blad";
            }
        }
        /**
         * Funkcja Obslugujaca String
         * @param tree drzewo typu string
         * @param in czytanie polecen uzytkownika
         * @param out wysylanie informacji zwrotnej
         * @return
         */
        String handleString(Tree<String> tree, BufferedReader in, PrintWriter out)
        {
            try 
            {
                String val;
                while(true)
                {
                    String text;
                    out.println("Podaj polecenie");
                    text = in.readLine();
                    if(text.equals("draw"))
                    {
                        out.println(tree.draw()+" Press ENTER to confirm");
                        text = in.readLine();
                    }
                    else if(text.equals("insert"))
                    {
                        out.println("Podaj wartosc");
                        val= in.readLine();
                        tree.insert(val);
                        out.println(tree.draw()+" Press ENTER to confirm");
                        text = in.readLine();
                    }
                    else if(text.equals("search"))
                    {
                        out.println("Podaj wartosc");
                        val= in.readLine();
                        tree.delete(val);
                        if(tree.search(val))
                        {
                            out.println("Znaleziono element"+" Press ENTER to confirm");
                            text = in.readLine();
                        }
                        else   
                        {
                            out.println("Nie znaleziono elementu"+" Press ENTER to confirm");
                            text = in.readLine();
                        }  
                    }
                    else if(text.equals("delete"))
                    {
                        out.println("Podaj wartosc");
                        val= in.readLine();
                        tree.delete(val);
                        out.println(tree.draw()+" Press ENTER to confirm");
                        text = in.readLine();
                    }
                    else if(text.equals("bye"))
                    {
                        socket.close();
                        return "Pa pa";
                    }
                    else
                    {
                        out.println("Podano zle polcenie"+" Press ENTER to confirm");
                        text = in.readLine();
                    }
                }
            }
            catch(IOException ex)
            {
                out.println("Server exception in Hand: " + ex.getMessage());
                ex.printStackTrace();
                return "Jakis blad";
            }
        }
    }
    /**
     * Glowna funkcja obslugujaca watek
     */
    public void run() 
    {
        try 
        {
            /**
             * @param input inputstream
             * @param in BufferReader od input
             * @param output outputstream
             * @param out PrintWriter od output
             * @param line string do zpisywania informacji od uzytkownika
             * @param h drzewo typu Integer
             * @param d drzewo typu Double
             * @param s drzewo typo String
             */
            //Odbieranie od socketa
            InputStream input = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            //Wysylanie do socketa
            OutputStream output = socket.getOutputStream();
            PrintWriter out = new PrintWriter(output, true);
            String line;
            Hand<Integer> h= new Hand<Integer>();
            Hand<Double> d= new Hand<Double>();
            Hand<String> s= new Hand<String>();
            /**
             * Pętla tworząca drzewo
             */
            while(true)
            {
                line = in.readLine();
                if(line.equals("Integer"))
                {out.println(h.handleInt(new Tree<Integer>(), in, out));}
                else if(line.equals("Double"))
                {out.println(d.handleDouble(new Tree<Double>(), in, out));}
                else if(line.equals("String"))
                {out.println(s.handleString(new Tree<String>(), in, out));}
                else{out.println("Musisz wybrać drzewo.");}
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}