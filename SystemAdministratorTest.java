import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;


public class SystemAdministratorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Test for creating an office manager */
   @Test public void testCreateOfficeManager(){
      SystemAdministrator testAdmin = new SystemAdministrator("James", "Bond",
         "bondman@verizon.net", "Double_O 7", "eu*iSe45");
         
      OfficeManager test = new OfficeManager("Greg", "Owens", "gOwens2@gmail.com",
         "the_gregster", "trI90neiWp");
         
      OfficeManager compare = testAdmin.createOfficeManager("Greg", "Owens", 
         "gOwens2@gmail.com", "the_gregster", "trI90neiWp");
         
      assertEquals(compare.getFirstName(), test.getFirstName());
      assertEquals(compare.getLastName(), test.getLastName());
      assertEquals(compare.getEmail(), test.getEmail());
      assertEquals(compare.getUsername(), test.getUsername());
      assertEquals(compare.getPassword(), test.getPassword());      
   }
   
   @Test public void testCreateWarehouseManager(){
      SystemAdministrator testAdmin = new SystemAdministrator("James", "Bond",
         "bondman@verizon.net", "Double_O 7", "eu*iSe45");
         
      WarehouseManager test = new WarehouseManager("Greg", "Owens",
      "gOwens2@gmail.com", "the_gregster", "trI90neiWp");
         
      WarehouseManager compare = testAdmin.createWarehouseManager("Greg", 
      "Owens", "gOwens2@gmail.com", "the_gregster", "trI90neiWp"); 
      
      assertEquals(compare.getFirstName(), test.getFirstName());
      assertEquals(compare.getLastName(), test.getLastName());
      assertEquals(compare.getEmail(), test.getEmail());
      assertEquals(compare.getUsername(), test.getUsername());
      assertEquals(compare.getPassword(), test.getPassword());      
      
   }
   
   @Test public void testDeleteAccount() throws IOException{
      SystemAdministrator testAdmin = new SystemAdministrator("James", "Bond",
      "bondman@verizon.net", "Double_O 7", "eu*iSe45");
         
      Employee test = new WarehouseManager("Greg", "Owens",
      "gOwens2@gmail.com", "the_gregster", "trI90neiWp"); 
      
      test = testAdmin.deleteAccount(test);
      
      assertEquals(null, test);     
   }
   
   @Test public void testAddSalesVan() throws IOException{
      SystemAdministrator testAdmin = new SystemAdministrator("James", "Bond",
      "bondman@verizon.net", "Double_O 7", "eu*iSe45");
         
      SalesAssociate test = new SalesAssociate("Greg", "Owens",
      "gOwens2@gmail.com", "the_gregster", "trI90neiWp", "SalesVan1");
         
      SalesAssociate compare = testAdmin.addSalesVan("Greg", 
      "Owens", "gOwens2@gmail.com", "the_gregster", "trI90neiWp", "SalesVan1"); 
      
      assertEquals(compare.getFirstName(), test.getFirstName());
      assertEquals(compare.getLastName(), test.getLastName());
      assertEquals(compare.getEmail(), test.getEmail());
      assertEquals(compare.getUsername(), test.getUsername());
      assertEquals(compare.getPassword(), test.getPassword());    
   }
   
}
