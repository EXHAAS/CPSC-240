/**
* 
* *CPSC-240
*I hereby declare upon my word of honor that I have neither given nor received
*unauthorized help on this work.
*
*  @author  Anthony Tompkins
*/
public class SalesAssociate extends Employee{


	private String van;
	SalesAssociate(String firstName, String lastName, String email, String username, String password,String van) {
		super(firstName, lastName, email, username, password);
		this.van = van;
	}
	
	 public String getVan() {
		 return this.van;
	 }
    
   public int getType(){
      return 4;
   }     
}
