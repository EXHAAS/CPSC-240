import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
/**
 * Write a description of class OfficeManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OfficeManager extends Employee 
{
    // instance variables - replace the example below with your own
    public OfficeManager(String fn, String ln, String email, String un,
      String password){
      super(fn, ln, email, un, password);
   }

   

    /**
     * Constructor for objects of class OfficeManager
     */
    public static void OfficeManagerReadName(java.util.Scanner reader) throws IOException
    {
        // Will Be in a loop until it 
        
        System.out.println ("What action would you like to take?");
        EnterSellDisplay.displayPart(reader);
        
        
        
    }
    


    
}
