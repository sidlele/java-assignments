import java.io.*;

public class writeFile 
{
    public static void main(String[] args) throws IOException 
    {
        InputStream f = new FileInputStream(args[0]);
        OutputStream even = new FileOutputStream("./even.txt");
        OutputStream odd = new FileOutputStream("./odd.txt");
        int line = 1;
        int data;
        int size = f.available();
        try 
        {
            for (int i = 0; i < size; i++) 
            {
                data = f.read();

                if((char)data == '\n')
                    line += 1;

                if(line%2!=0)
                {
                    odd.write((char)data);
                }
                else
                {
                    even.write((char)data);
                }
            }
    

          System.out.println("Operation Successfull.");
        } 
        catch (IOException ioe) 
        {
            System.out.println(ioe);    
        }

        try 
        {
            f.close();
            odd.close();
            even.close();    
        } catch (IOException ioe) 
        {
            System.out.println(ioe);
        }
    }
}
