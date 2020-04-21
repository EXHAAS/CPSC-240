import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;
import java.util.LinkedList;
import java.io.IOException;

public class EnterSellDisplayTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test to sell a part **/
   @Test public void testSellPart() {
      
   }
   
      
   /** A test to display a part **/
   @Test public void testDisplayPart() throws IOException{
      Scanner reader = new Scanner(System.in);
      LinkedList<BikePart> test = getPartList();
      
      BikePart expected = new BikePart("seatPost", "1234567892", 17.00, 15.21, true, 300);
//TEST: ENTER WAREHOUSE warehouseDB.txt
//TEST: ENTER NAME seatPost
      BikePart temp = EnterSellDisplay.displayPart(reader);
      
      String exp = expected.getInfo();
      String actual = temp.getInfo();
      
      assertEquals(exp, actual);  
   }
   
   
   /** A test for the input check **/
   @Test public void testInputCheck(){
      String test1 = "134";
      String test2 = "45.67";
      String test3 = "hello";
      
//FIRST TEST, USE FLAG ONE FOR INTEGER. SHOULD RETURN THE NUMBER UNCHANGED.
      String result1 = EnterSellDisplay.inputCheck(test1, 1);
      assertEquals(test1, result1);
      
//SECOND TEST, USE FLAG TWO FOR DOUBLE. SHOULD RETURN UNCHANGED.
      String result2 = EnterSellDisplay.inputCheck(test2, 2);
      assertEquals(test2, result2);
      
//THIRD TEST, USE FLAG ONE JUST BECAUSE. SHOULD RETURN A NULL STRING
      String result3 = EnterSellDisplay.inputCheck(test3, 1);
      assertNull(result3);  
   }
   
   
   /**A supplemental method that creates a LinkedList of BikeParts for testing**/
   public LinkedList<BikePart> getPartList(){
      LinkedList<BikePart> testList = new LinkedList<BikePart>();
      
      BikePart bp1 = new BikePart("WTB_saddle", "1234567890", 33.00, 25.58, false, 5);
      testList.add(bp1);
      BikePart bp2 = new BikePart("26inTube", "1234567891", 7.00, 5.58, true, 20);
      testList.add(bp2);
      BikePart bp3 = new BikePart("seatPost", "1234567892", 17.00, 15.21, true, 300);
      testList.add(bp3);
      BikePart bp4 = new BikePart("leftPedal", "1738597039", 14.80, 23.00, false, 34);
      testList.add(bp4);
      BikePart bp5 = new BikePart("bikeRack", "2729475067", 50.00, 45.00, true, 67);
      testList.add(bp5);
      
      return testList;
   }
}
