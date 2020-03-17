import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
/**
 * CPSC 240 Project 1 Importer Class 
 *
 * @author Hayden Webb
 * @version (a version number or a date)
 */
public class Importer
{
    
    //LinkedList<String>
    public static LinkedList<BikePart> Import(String directory, int state) throws IOException
    
    /**
 * This method will import the file, take each line of data, and convert 
 * each part separated by comma into a bikePart object, then combined
 * into a bikePart linked list
 * 
 *
 * @param  directory - The string of the file name to import a file from
 * @param state - an int to check if the file is valid or not, 1 or 0
 * @param return - A linked list of bikeParts
 *
 */
//We discussed using LinkedList, but can be changed to ArrayList if better
    {
      
      Boolean noException = true;
      //String directory; //file that scnr reads from, warehouseDB.txt
      //directory = "warehouseDB.txt"; Typical default
      
      LinkedList<BikePart> items = new LinkedList<BikePart>(); //main parts list
                                                           //if no file or txt
      //needed for conversion                                                     //will return empty 
      String raw = " ";
      String[] rawList;
      
      BikePart part;
      double b2;
      double b3;
      boolean b4 = true;
      int b5;
      
      
      int flag = 0; //flag is used to determine what state something is in
                    //if flag = 0, there is still text to read and loop goes
                    //if flag = 1, end of the file is reached,and loop ends
      
      
      try {      //try block to check for file existing
      
      FileInputStream fileIn= new FileInputStream(directory);
      
      Scanner scnr = new Scanner(fileIn); //Basic Scanner
      

            
      try {      //try block to check for end of file
          
      while (flag == 0) {
         //items.addLast(scnr.nextLine()); 
         raw = scnr.nextLine();
         rawList = raw.split(",");
         b2 = Double.parseDouble(rawList[2]);
         b3 = Double.parseDouble(rawList[3]);
         if (rawList[4].toUpperCase().equals("FALSE")){
        b4 = false;    
        }
         if (rawList[4].toUpperCase().equals("TRUE")){
        b4 = true;    
        }
        b5 = (int) Double.parseDouble(rawList[5]); 
        
         part = new BikePart(rawList[0],rawList[1],b2,b3,b4,b5); 
         items.addLast(part);
         
         //items.addLast()
         
         
          
        }
          
          
          
        }   
       catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }      //catch block to check for end of file
      fileIn.close();
      //System.out.println(items);//--InternalTesting--
      //System.out.println("FileGood");//--InternalTesting--
      
    }
    catch (java.io.FileNotFoundException exception){
    
    if(state == 0) {
    //System.out.println("warehouseDB.txt created \n\n");  
    flag = writeEmptyFile (directory); //Will Create a blank new file
                                         //if file does not exist
      //System.out.println(items); //--InternalTesting--
      //System.out.println("CaughtNoFile"); //--InternalTesting--
    }      //catch block to check for file existing  
    else {
    	 //System.out.println("File Not Found \n\n");
    }
    noException = false;
    }
      
    if(state == 1) {
    	if(noException) {
    		//System.out.println("The warehouse list has been updated \n\n");
    	}
    }
    else {
    	if(noException) {
    		//System.out.println("warehouseDB.txt was found \n\n");
    	}
    }
    return items;  
      //items = list;
    }
    public static int writeEmptyFile (String directory) throws IOException
       /**
 * This method will create a blank file
 * 
 *
 * @param  directory - The string of the file name to write a file to
 * @param return - An int of 1
 * 
 */
   {
     FileOutputStream fileOut= new FileOutputStream(directory);
     
     return 1;
     //Pretty much does as titled, creates a blank file when called upon
    }
    
}
