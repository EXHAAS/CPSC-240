/*The Employee class that all other types of workers inherit from.
*I hereby declare upon my word of honor that I have neither given nor
*recieved unauthorized help on this work
*
*@author Eleanor Haas
*/

public class Employee{
   String firstName;
   String lastName;
   String email;
   String username;
   String password;
   
   public Employee(String fn, String ln, String email, String un,
      String password){
      firstName = fn;
      lastName = ln;
      this.email = email;
      username = un;
      this.password = password;
      
   }
   
/*Returns the Employee's first name
*@return The Employee's first name
*/   
   public String getFirstName(){
      return firstName;
   }
 
/*Returns the Employee's last name
*@return The Employee's last name
*/     
   public String getLastName(){
      return lastName;
   }

/*Returns the Employee's email
*@return The Employee's email
*/      
   public String getEmail(){
      return this.email;
   }

/*Returns the Employee's username
*@return The Employee's username
*/      
   public String getUsername(){
      return username;
   }

/*Sets the Employee's username
*@param un The username to be set
*/   
   public void setUsername(String un){
      this.username = un;
   }
 /*Returns the account's type
*@return The account type
*/      
   public int getType(){
      return 0;
   }  
  /*
  *Checks if given password and username match the fields of the employee object.
  *
  *@param user given username
  *@param pass given password
  *@return returns boolean on whether the the username and password are correct or not.
  */
   public boolean check(String user, String pass) 
  {
	Boolean x = false;
	if(user.equals(this.username) && pass.equals(this.password)) {
		x = true;
	}	
	   return x;	   
   }
   //NO METHOD TO GET THE PASSWORD BECAUSE THEY SHOULDN'T HAVE THAT
   
}
