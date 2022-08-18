import java.io.*;
import java.net.*;
 
/**
 * Głowna klasa serwera, tworzaca watki dla klientow
 */
public class MultiServerThread 
{
    public static void main(String[] args) 
    {
        try (ServerSocket serverSocket = new ServerSocket(4444)) 
        {
            /**
             * @param socket gniazdko sieciowe
             */
            System.out.println("Server is listening on port 4444");
            while (true) 
            {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                new MultiThread(socket).start();
            }
        } 
        catch (IOException ex) 
        {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}