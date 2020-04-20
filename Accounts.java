import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;
import java.io.PrintWriter;
import java.io.FileOutputStream;
/**
 * Write a description of class Accounts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Accounts
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Accounts
     */
    public static LinkedList<Employee> Employees() throws IOException
    {
        // initialise instance variables
        //x = 0;
        LinkedList<Employee> employees = new LinkedList<Employee>();
        //employees.add(new SalesAssociate("Bob","Bobby","email","user","pass","S.txt")); 
        
        LinkedList<OfficeManager> omList = readOm();
        LinkedList<WarehouseManager> wmList = readWm();
        LinkedList<SystemAdministrator> adminList = readAdmin();
        LinkedList<SalesAssociate> saleList = readSale();
        
    
      ListIterator<OfficeManager> omIt = omList.listIterator(); 
      OfficeManager currentOm; 
      
      ListIterator<WarehouseManager> wmIt = wmList.listIterator(); 
      WarehouseManager currentWm; 
      
      ListIterator<SystemAdministrator> adminIt = adminList.listIterator(); 
      SystemAdministrator currentAdmin; 
      
      ListIterator<SalesAssociate> saleIt = saleList.listIterator(); 
      SalesAssociate currentSale; 
      
        int aqq = 0;
        int flag = 0;
        try {
        while (flag == 0) {
        //out.println 
        
        currentOm = omIt.next();
        employees.add(currentOm);
        //out.println("OM`" +currentOm.getFirstName() + "`" + currentOm.getLastName() + "`" + currentOm.getEmail() + "`" + currentOm.getUsername() + "`" + currentOm.getPassword());
        }
    }
    catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }
    
        aqq = 0;
        flag = 0;
        try {
        while (flag == 0) {
        //out.println 
        
        currentWm = wmIt.next();
        employees.add(currentWm);
        //out.println("OM`" +currentOm.getFirstName() + "`" + currentOm.getLastName() + "`" + currentOm.getEmail() + "`" + currentOm.getUsername() + "`" + currentOm.getPassword());
        }
    }
    catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }
        
        aqq = 0;
        flag = 0;
        try {
        while (flag == 0) {
        //out.println 
        
        currentAdmin = adminIt.next();
        employees.add(currentAdmin);
        //out.println("OM`" +currentOm.getFirstName() + "`" + currentOm.getLastName() + "`" + currentOm.getEmail() + "`" + currentOm.getUsername() + "`" + currentOm.getPassword());
        }
    }
    catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }
    
        aqq = 0;
        flag = 0;
        try {
        while (flag == 0) {
        //out.println 
        
        currentSale = saleIt.next();
        employees.add(currentSale);
        //out.println("OM`" +currentOm.getFirstName() + "`" + currentOm.getLastName() + "`" + currentOm.getEmail() + "`" + currentOm.getUsername() + "`" + currentOm.getPassword());
        }
    }
    catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }
    
    
    
    
    
    
    
    
    
      return employees;  
    }
    
    
    
    public static void writeAccount(LinkedList<Employee> accounts) throws IOException
    {
        // initialise instance variables
        //x = 0;
        String outputDirectory = ("accounts.txt");
        PrintWriter out = new PrintWriter(outputDirectory); 
        
        FileInputStream fileIn= new FileInputStream(outputDirectory);
      
      Scanner scnr = new Scanner(fileIn); //Basic Scanner
      ListIterator<Employee> acIt = accounts.listIterator(); 
      Employee currentE; 
      
        int aqq = 0;
        int flag = 0;
        try {
        while (flag == 0) {
        //out.println 
        currentE = acIt.next();
        
        //Current employee account type
        int cet = currentE.getType();
        
        if(cet==1) {
        	out.println("ADMIN`" +currentE.getFirstName() + "`" + currentE.getLastName() + "`" + currentE.getEmail() + "`" + currentE.getUsername() + "`" + currentE.getPassword());
        }
        else if(cet==2) {
        	out.println("OM`" +currentE.getFirstName() + "`" + currentE.getLastName() + "`" + currentE.getEmail() + "`" + currentE.getUsername() + "`" + currentE.getPassword());
        }
        else if(cet==3) {
            out.println("WM`" +currentE.getFirstName() + "`" + currentE.getLastName() + "`" + currentE.getEmail() + "`" + currentE.getUsername() + "`" + currentE.getPassword());

        }
        else if(cet==4) {
            String van = ((SalesAssociate) currentE).getVan();
        	out.println("SALE`" +currentE.getFirstName() + "`" + currentE.getLastName() + "`" + currentE.getEmail() + "`" + currentE.getUsername() + "`" + currentE.getPassword() + "`" + van);
        }       
        }
    }
    catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }          
        out.flush();       
        fileIn.close();       
    }
    
    
    public static LinkedList<OfficeManager> readOm() throws IOException
    {
        // initialise instance variables
        //x = 0;
        
        // partName;
        String directory = "accounts.txt";
        
        LinkedList<OfficeManager> omList = new LinkedList<OfficeManager>();
        
        
        
      FileInputStream fileIn= new FileInputStream(directory);
      
      Scanner scnr = new Scanner(fileIn); //Basic Scanner
        
        int flag = 0;
        
        String raw;
        String[] rawList;
        
        try {      //try block to check for end of file
          
      while (flag == 0) {
         //items.addLast(scnr.nextLine()); 
         raw = scnr.nextLine();
         rawList = raw.split("`");
         //b2 = Double.parseDouble(rawList[2]);
         //b3 = Double.parseDouble(rawList[3]);
         if (rawList[0].toUpperCase().equals("OM")){
        OfficeManager om = new OfficeManager(rawList[1],rawList[2],rawList[3],rawList[4],rawList[5]); 
        omList.addLast(om);
        
        //System.out.println(rawList[1] + rawList[2] + rawList[3] + rawList[4] + rawList[5]); 
        }
        
        //b5 = (int) Double.parseDouble(rawList[5]); 
        
         
         
         //items.addLast()
         
         
          
        }
          
          
          
        }   
       catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }      //catch block to check for end of file
      fileIn.close();
      //writeAccount(omList);
      return omList;
      
    }
    
    public static LinkedList<WarehouseManager> readWm() throws IOException
    {
        // initialise instance variables
        //x = 0;
        
        // partName;
        String directory = "accounts.txt";
        
        LinkedList<WarehouseManager> wmList = new LinkedList<WarehouseManager>();
        
        
        
      FileInputStream fileIn= new FileInputStream(directory);
      
      Scanner scnr = new Scanner(fileIn); //Basic Scanner
        
        int flag = 0;
        
        String raw;
        String[] rawList;
        
        try {      //try block to check for end of file
          
      while (flag == 0) {
         //items.addLast(scnr.nextLine()); 
         raw = scnr.nextLine();
         rawList = raw.split("`");
         //b2 = Double.parseDouble(rawList[2]);
         //b3 = Double.parseDouble(rawList[3]);
         if (rawList[0].toUpperCase().equals("WM")){
        WarehouseManager wm = new WarehouseManager(rawList[1],rawList[2],rawList[3],rawList[4],rawList[5]); 
        wmList.addLast(wm);
        
        //System.out.println(rawList[1] + rawList[2] + rawList[3] + rawList[4] + rawList[5]); 
        }
        
        //b5 = (int) Double.parseDouble(rawList[5]); 
        
         
         
         //items.addLast()
         
         
          
        }
          
          
          
        }   
       catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }      //catch block to check for end of file
      fileIn.close();
      //writeAccount(wmList);
      return wmList;
      
    }
    
    
    public static LinkedList<SystemAdministrator> readAdmin() throws IOException
    {
        // initialise instance variables
        //x = 0;
        
        // partName;
        String directory = "accounts.txt";
        
        LinkedList<SystemAdministrator> adminList = new LinkedList<SystemAdministrator>();
        
        
        
      FileInputStream fileIn= new FileInputStream(directory);
      
      Scanner scnr = new Scanner(fileIn); //Basic Scanner
        
        int flag = 0;
        
        String raw;
        String[] rawList;
        
        try {      //try block to check for end of file
          
      while (flag == 0) {
         //items.addLast(scnr.nextLine()); 
         raw = scnr.nextLine();
         rawList = raw.split("`");
         //b2 = Double.parseDouble(rawList[2]);
         //b3 = Double.parseDouble(rawList[3]);
         if (rawList[0].toUpperCase().equals("ADMIN")){
        SystemAdministrator admin = new SystemAdministrator(rawList[1],rawList[2],rawList[3],rawList[4],rawList[5]); 
        adminList.addLast(admin);
        
        //System.out.println(rawList[1] + rawList[2] + rawList[3] + rawList[4] + rawList[5]); 
        }
        
        //b5 = (int) Double.parseDouble(rawList[5]); 
        
         
         
         //items.addLast()
         
         
          
        }
          
          
          
        }   
       catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }      //catch block to check for end of file
      fileIn.close();
      //writeAccount(adminList);
      return adminList;
      
    }
    
    
    
    public static LinkedList<SalesAssociate> readSale() throws IOException
    {
        // initialise instance variables
        //x = 0;
        
        // partName;
        String directory = "accounts.txt";
        
        LinkedList<SalesAssociate> saleList = new LinkedList<SalesAssociate>();
        
        
        
      FileInputStream fileIn= new FileInputStream(directory);
      
      Scanner scnr = new Scanner(fileIn); //Basic Scanner
        
        int flag = 0;
        
        String raw;
        String[] rawList;
        //rawList = new String [7];
        
        try {      //try block to check for end of file
          
      while (flag == 0) {
         //items.addLast(scnr.nextLine()); 
         raw = scnr.nextLine();
         rawList = raw.split("`");
         //b2 = Double.parseDouble(rawList[2]);
         //b3 = Double.parseDouble(rawList[3]);
         if (rawList[0].toUpperCase().equals("SALE")){
        SalesAssociate sale = new SalesAssociate(rawList[1],rawList[2],rawList[3],rawList[4],rawList[5],rawList[6]); 
        saleList.addLast(sale);
        
        //System.out.println(rawList[1] + rawList[2] + rawList[3] + rawList[4] + rawList[5] + rawList[6]); 
        }
        
        //b5 = (int) Double.parseDouble(rawList[5]); 
        
         
         
         //items.addLast()
         
         
          
        }
          
          
          
        }   
       catch (java.util.NoSuchElementException exception){
        flag = 1; //end loop
        
    }      //catch block to check for end of file
      fileIn.close();
      //writeAccount(saleList);
      return saleList;
      
    }
    
    
    
    
    
    
    
    
    public static void logIn()
    {
        // initialise instance variables
        //x = 0;
        String partName;
        
        
        
        
        
    }

    
}
