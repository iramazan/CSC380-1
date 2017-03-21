/**
 * Created by George Dzagali on 2/22/2017.
 */
public abstract class Employee {
    // variables
    private String lastName;
    private String firstName;
    private float salary;
    private int pin;

    // constructor
    public Employee(String ln, String fn, float salary, int pin){
        lastName = ln;
        firstName = fn;
        this.salary = salary;
        this.setPin(pin);
    }
    // abstract method
    public abstract void printPaycheck();

    // Allow employee to login to system if provided correct pin
    // Pin must be 4 digits
    public boolean authenticate(int pin) {
        return pin == this.pin;
    }

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
    public int getPin() { return pin; }

    // Setters
    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Will throw exception if pin is not 4 digits
    public void setPin(int pin) {
        if(String.valueOf(pin).length() == 4)
            this.pin = pin;
        else throw new IllegalArgumentException("A pin must be 4 digits.");
    }
}
