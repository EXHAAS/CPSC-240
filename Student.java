/**
 * A description of the Student object
 *
 * @author Ellie Haas
 * @version 11-4-19
 */
import java.util.ArrayList;
public class Student{
    //DECLARE VARIABLES FOR STUDENT
    private String name;
    private int age;
    private SocialYear year;
    private ArrayList<String> friends;
    
    //CONSTRUCTOR
    public Student(String n, int a, SocialYear y, ArrayList<String> friends){
        name = n;
        age = a;
        year = y;
        this.friends = friends;
    }
    
    //METHODS
    /**
     * Returns the name of the student
     * @return Student name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Sets the students name
     * @param n The name the user wants
     */
    public void setName(String n){
        this.name = n;
    }
    
    /**
     * Returns the students age
     * @return Student age
     */
    public int getAge(){
        return age;
    }
    
    /**
     * Sets the students age
     * @param The age
     */
    public void setAge(int a){
        this.age = a;
    }
    
    /**
     * Returns the social year of the student
     * @return The social year
     */
    public SocialYear getSocialYear(){
        return year;
    }
    
    /**
     * Sets the students social year
     * @param The social year
     */
    public void setSocialYear(SocialYear y){
        this.year = y;
    }
    
    /**
     * Checks if the student can vote or not
     * @return True if yes, false if no
     */
    public boolean canVote(){
        if(this.age >= 18){
            return true;
        }
        return false;
    }
    
    /**
     * Adds one year to the age of a student
     */
    public void birthday(){
        this.age++;
    }    
    
    /**
     * Adds a friend to the list
     * @param friend The name of the friend
     */
    public void addFriend(String friend){
        friends.add(friend);        
    }
    
    /**
     * Returns true if this friend is on the list of friends
     * @param friend The name being checked
     * @return True if friend is on list, false if not
     */
    public boolean hasFriend(String friend){
        for(String i : friends){
            if(i.equals(friend)){
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
}