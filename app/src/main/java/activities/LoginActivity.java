package activities;


import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import edu.oswego.csc380_2.R;
import edu.oswego.csc380_2.User;


/**
 * A login screen that offers login via username/password
 */
public class LoginActivity extends Activity implements OnClickListener {
//    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //createUsers();
        Button enter = (Button) findViewById(R.id.bE);
        enter.setOnClickListener(this);
        //RestaurantData.Instance().createUsers(getResources().openRawResource(R.raw.users));
    }

    @Override
    public void onClick(View v) {
        //create text views corresponding to android ids
        TextView loginStatus = (TextView) findViewById(R.id.loginStatus);
        TextView user = (TextView) findViewById(R.id.username);
        TextView pass = (TextView) findViewById(R.id.password);
        //retrieve the user inputted data from the textfields
        String username = user.getText().toString();
        String password = pass.getText().toString();
        //variable to keep track of login status
        boolean login = false;
        boolean validUser = false;
        String access = "";
        //for each loop to iterate through the users array
        for(User u:RestaurantData.Instance().users){
            //check if username is valid
            if(u.getName().equals(username)){
                validUser = true;
                //check if the valid user's password is correct
                if(u.getPassword().equals(password)){
                    //login is successful
                    login = true;
                    access = u.getAccess();
                }
                else{
                    loginStatus.setText("Invalid password");
                }
            }
        }
        //output for invalid user
        if(!validUser){
            loginStatus.setText("Invalid user");
        }
        if(login){
            //if the user access is waiter/chef starts corresponding activity
            if(access.equals("waiter")||access.equals("chef")){
                Intent employeeLogin = new Intent(this, EmployeeActivity.class);
                //pass the username into the new activity
                employeeLogin.putExtra("access","employee");
                employeeLogin.putExtra("id", username);
                startActivity(employeeLogin);
            }
            //start activity for manager
            else{
                Intent managerLogin = new Intent(this, ManagerActivity.class);
                startActivity(managerLogin);
            }
        }
    }
    //read through users.txt raw file to create user objects
//    public void createUsers() {
//        Scanner scan = new Scanner(getResources().openRawResource(R.raw.users));
//        while(scan.hasNextLine()){
//            String username = scan.nextLine();
//            String password = scan.nextLine();
//            String access = scan.nextLine();
//            User user = new User(username, password, access);
//            users.add(user);
//        }
//    }
}

