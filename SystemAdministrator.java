/*The System Administrator class, with a general information about the admin
*and a username and password. I'm making it general because I don't know if
*there's supposed to be more than one.
*I hereby declare upon my word of honor that I have neither given nor 
*recieved unauthorized help on this work.
*
*@author Eleanor Haas
*/

//MAKING THIS ASSUMING THAT THERE ISN'T AN OVERARCHING EMPLOYEE CLASS. THAT
//IS SUBJECT TO CHANGE
public class SystemAdministrator extends Employee{
   
   public SystemAdministrator(String fn, String ln, String email, String un,
      String password){
      super(fn, ln, email, un, password);
   }

/*Creates and returns an OfficeManager object
*@return An office manager
*/
   public OfficeManager createOfficeManager(String fn, String ln, String email,
   String un, String password){
      return new OfficeManager(fn, ln, email, un, password);
   }
 
/*Creates and returns a WarehouseManager object
*@return A Warehouse Manager
*/  
   public WarehouseManager createWarehouseManager(String fn, String ln, 
   String email, String un, String password){
      return new WarehouseManager(fn, ln, email, un, password);
   }
   
/*Deletes an existing account by setting the Employee object to null
*@param a The account to be deleted
*/
   public void deleteAccount(Account a){
      a = null;
   }
   
   public SalesAssosiate addSalesVan(String fn, String ln, String email, 
   String un, String password, String van){//ADD A LINKEDLIST FOR THE INVENTORY?
      return new SalesAssosiate(fn, ln, email, un, password, van);
   }     
}
      
