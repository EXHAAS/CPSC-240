/**
*CPSC-240
*I hereby declare upon my word of honor that I have neither given nor recieved
*unauthorized help on this work.
*@author Eleanor Haas
*/

public class BikePart{
   private String name;
   private String number;
   private double listPrice;
   private double salesPrice;
   private boolean onSale;   
   private int quantity;

   public BikePart (String name, String number, double listPrice, double salesPrice,
   boolean onSale, int quantity){
    this.name = name;
    this.number = number;
    this.listPrice = listPrice;
    this.salesPrice = salesPrice;
    this.onSale = onSale; 
    this.quantity = quantity; 
    }

/**
*@param n The name to be set
*/
   public void setName(String n){
      this.name = n;
   }
   
/**
*@return The BikePart name  
*/
   public String getName(){
      return name;
   }

/**
*@param n The BikePart number being set
*/   
   public void setNumber(String n){
      this.number = n;
   }
   
/**
*@return the BikePart number
*/   
   public String getNumber(){
      return number;
   }

/**
*@param listPrice The listed price of the part
*/   
   public void setListPrice(double listPrice){
      this.listPrice = listPrice;
   }

/**
*@return The part's listed price
*/   
   public double getListPrice(){
      return this.listPrice;
   }
 
/**
*@param salesPrice The sales price of the part
*/  
   public void setSalesPrice(double salesPrice){
      this.salesPrice = salesPrice;
   }

/**
*@return The sales price of the part
*/   
   public double getSalesPrice(){
      return this.salesPrice;
   }

/**
*@param onSale If the part is on sale the value is true. If not it's false
*/  
   public void setOnSale(boolean onSale){
      this.onSale = onSale;
   }

/**
@return True if the part is on sale, false if not
*/   
   public boolean getOnSale(){
      return this.onSale;
   }
   
/**
*@return The quantity of the BikePart in stock
*/
   public int getQuantity(){
      return this.quantity;
   }
   
/**
*@param q The quantity to be set
*/
   public void setQuantity(int q){
      this.quantity = q;
   }

/**
*Prints all of the parts info, seperated by commas not spaces
*/   
   public void printInfo(){
      System.out.println(name + "," + number + "," + listPrice + "," + salesPrice
      + "," + onSale + "," + quantity);
   }

/**
*Returns the part's info as a String
*/   
   public String getInfo(){
      return name + "," + number + "," + listPrice + "," + salesPrice + "," + onSale + "," + quantity;
   }
}


   
