package ass2;

import java.io.*;

public class ass2
{
    public static void main(String[] args) {
        int data;
        FileInputStream Fin = null;
        int words = 0 ;
        int lines = 0 ;
        int characters =0 ;
        //Checks presence of file.
        try  
        {
            Fin = new FileInputStream(args[0]);    
        } 
        catch (FileNotFoundException fnfe) 
        {
            System.out.println(fnfe);
        }

        //Reads file data till EOF
        try 
        {
            do
            {
                data = Fin.read();
                if(data != -1)
                {
                 if((char)data == '\n')
                 {
                     lines += 1;
                     words += 1;
                 }   
                 if ((char)data == ' ') 
                 {
                    words += 1;    
                 }
                 characters += 1;
                }
            }while(data!=-1);
            System.out.println("Number of Characters : "+characters);
            System.out.println("Number of Words : "+words);
            System.out.println("Number of Lines : "+lines);
        } 
        catch (IOException ioe) 
        {
            System.out.println(ioe);
        }

        //Closes file after the successful operation.
        try 
        {
            Fin.close();    
        } 
        catch (IOException ioe) 
        {
            System.out.println(ioe);
        }
    }    
}
