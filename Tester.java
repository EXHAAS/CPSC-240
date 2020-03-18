import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(int y) throws IOException
    {
      LinkedList<BikePart> paq = new LinkedList<BikePart>();
      BikePart q6 = new BikePart("Xhath","1234222890",33.0,25.58,false,5);
      paq.addLast(q6);
        
        
        
      Van qq = new Van();
      qq.Transfer("tester.txt", "BetterTest.txt", q6);  
       // return 7;
    }
}
