import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * CPSC 240 Project 1 Importer Class 
 *
 * @author Hayden Webb
 * @version (a version number or a date)
 */
public class Fleet
{
    
    
    public static void FleetAdd(String Van) throws IOException
       /**
 * This method will import the fleet file, add the Van to the fleet, and
 * update the fleet file
 * @author Hayden Webb
 *
 * @param  Van - The Van to be inserted into the fleet
 *
 */
    {
     String Fleet = "Fleet";
        
     String directory = "fleet.txt";
    
     FileInputStream fileIn= new FileInputStream(directory);
      
      Scanner scnr = new Scanner(fileIn);
     
      
      
      
      int flag = 0;
      //String qaaa = scnr.nextLine();
      boolean endOrNot = true;
      //String vmm = scnr.nextLine();
      String qaaa;
      String updatedFleet = "debug";
      String fleetName;
      String[] FleetList;
      //String[] FleetList;
      
      try {
      while (endOrNot = true){
          
          qaaa = scnr.nextLine();
          FleetList = qaaa.split("~");
          fleetName = FleetList[0];
          //double qaaa2 = Double.parseDouble(qaaa);
          if (fleetName.equals (Fleet)) {
             endOrNot = false;
             updatedFleet = qaaa + "~" + Van; 
             flag = 1;
            }
        
          //System.out.println ("Alk");
          //aqq = aqq + 1;
        }
    }
    catch (java.util.NoSuchElementException exception){
        
        endOrNot = false;
        //out.println(Fleet + "~" + Van);
    }
      
       //out.flush();
       //System.out.println ("A1");
       fileIn.close();
       if (flag == 0) {
       updatedFleet = Fleet + "~" + Van;
    }
    fileIn.close();
    PrintWriter out = new PrintWriter(directory);
    out.println(updatedFleet);
    //int qam = FleetWrite(directory, updatedFleet, Fleet);
    out.flush();
       //FleetList[0];
       //System.out.println (updatedFleet);
       
     //return TotNum; 
    }
/**
 * Prints out fleet.txt file.   
 * @throws IOException
 */
    public static void printFleet() throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader("fleet.txt"));  
    	String line = null;  
    	while ((line = br.readLine()) != null)  
    	{  
    	  System.out.println(line); 
    	} 
    	br.close();
    }
 
       
    
    
}
