/**
 * The tester class for the Student class
 *
 * @author Ellie Haas
 * @version 11-4-19
 */
import java.util.ArrayList;
public class Lab12{
    public static void main(String[] args){
        ArrayList<String> f1 = new ArrayList<String>();
        ArrayList<String> f2 = new ArrayList<String>();
        Student s1 = new Student("Iris", 17, SocialYear.SENIOR, f1);
        Student s2 = new Student("Theseus", 16, SocialYear.SOPHOMORE, f2);
        
        System.out.println("Student 1's name is " + s1.getName());
        System.out.println("Student 2's age is " + s2.getAge());
        
        s1.birthday();
        System.out.println("Student 1's new age is " + s1.getAge());
        
        System.out.println("Student 2's social year is " + s2.getSocialYear());
        
        System.out.println("Can student 1 vote? " + s1.canVote());
        System.out.println("Can student 2 vote? " + s2.canVote());
        
        f2.add("Heracles");
        f2.add("Orpheus");
        f2.add("Jason");
        
        System.out.println("Is student 2 friends with Orpheus? " + s2.hasFriend("Orpheus"));
        System.out.println("Is student 2 friends with Perseus? " + s2.hasFriend("Perseus"));
        
    }
}
