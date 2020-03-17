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
 * CPSC 240 Project 1 Importer Class 
 *
 * @author Hayden Webb
 * @version (a version number or a date)
 */
public class Fleet
{
    
    
    public static void FleetAdd(String Van) throws IOException
    
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
    
    public static int NotWorkingFleetWrite(String directory, String updatedFleet, String Fleet) throws IOException {
    // Scanner inputb = new Scanner(System.in);
      //String Baq = input.next();
      //System.out.println("Please enter the name of the text file:");
      FileInputStream fileIn2= new FileInputStream(directory);
      Scanner scnr2= new Scanner(fileIn2);
      PrintWriter out = new PrintWriter(directory);
      
      int aqq = 0;
      //String qaaa = scnr.nextLine();
      boolean endOrNot = true;
      //String vmm = scnr.nextLine();
      String qaaa;
      String fleetName = Fleet;
      String[] FleetList;
      //String[] FleetList;
      System.out.println ("Alk");
      try {
      while (aqq == 0){
          
          qaaa = scnr2.nextLine();
          
          //double qaaa2 = Double.parseDouble(qaaa);
          if (fleetName.equals (qaaa)) {
             
              
            }else {
            out.println(qaaa);    
                
            }
            
          System.out.println ("A");
          
          //aqq = aqq + 1;
        }
    }
    catch (java.util.NoSuchElementException exception){
        System.out.println ("NoElemebt");
        aqq = 1;
        out.println(updatedFleet);
    }
      
       out.flush();
    
       fileIn2.close(); 
       return 7;
    }
/*Prints out the list of all the van files in the fleet
*
*@author Eleanor Haas
*/
   public static void printFleet() throws IOException{
      File inFile = new File("fleet.txt");   
      Scanner scan = new Scanner(inFile);
      
      while(scan.hasNext()){
         String line = scan.next();
         System.out.println(line);
      }
   }
       
    
    
}