/**
 * Created by George Dzagali on 2/22/2017.
 */
public abstract class Employee {
    // variables
    private String lastName;
    private String firstName;

    // constructor
    public Employee(String ln, String fn){
        lastName = ln;
        firstName = fn;
    }
    // abstract method
    public abstract void printPaycheck();

    // get methods
    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
}
