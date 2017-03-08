/**
 * Created by George Dzagali on 2/22/2017.
 */
public abstract class Employee {
    // variables
    private String lastName;
    private String firstName;
    private float salary;

    // constructor
    public Employee(String ln, String fn, float salary){
        lastName = ln;
        firstName = fn;
        this.salary = salary;
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
    public float getSalary() {
        return salary;
    }

    // Setters
    public void setSalary(float salary) {
        this.salary = salary;
    }
}
