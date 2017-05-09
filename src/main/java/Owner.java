import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public class Owner extends Employee implements Observer {

    public Owner(String lastName, String firstName, float salary, int pin) {
        super(firstName, firstName, salary, pin);
    }

    @Override
    public void update(Observable observable, Object o) {
        Stock stockUpdate = (Stock) observable;
        Optional<ArrayList<String>> runningLow = stockUpdate.warnRunningLow();
        if(runningLow.isPresent()) {
            System.out.println(runningLow.get().toString());
        }
    }
}
