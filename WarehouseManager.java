/**
* 
* *CPSC-240
*I hereby declare upon my word of honor that I have neither given nor received
*unauthorized help on this work.
*
*  @author  Anthony Tompkins
*/
public class WarehouseManager extends Employee {

	public WarehouseManager(String fn, String ln, String email, String un, String password) {
		super(fn, ln, email, un, password);
	}
   
   public int getType(){
      return 3;
   } 

}
