package edu.oswego.csc380_2;


import android.app.Activity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A login screen that offers login via username/password
 */
public class LoginActivity extends Activity implements OnClickListener {
    ArrayList<User> users = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createUsers();
        Button enter = (Button) findViewById(R.id.bE);
        enter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView loginStatus = (TextView) findViewById(R.id.loginStatus);
        TextView user = (TextView) findViewById(R.id.username);
        TextView pass = (TextView) findViewById(R.id.password);
        String username = user.getText().toString();
        String password = pass.getText().toString();
        boolean login = false;
        boolean validUser = false;
        String access = "";
        for(User u:users){
            if(u.getName().equals(username)){
                validUser = true;
                if(u.getPassword().equals(password)){
                    login = true;
                    access = u.getAccess();
                }
                else{
                    loginStatus.setText("Invalid password");
                }
            }
        }
        if(!validUser){
            loginStatus.setText("Invalid user");
        }
        if(login){
            if(access.equals("waiter")||access.equals("chef")){
                Intent employeeLogin = new Intent(this, EmployeeActivity.class);
                employeeLogin.putExtra("id", username);
                startActivity(employeeLogin);
            }
            else{
                Intent managerLogin = new Intent(this, ManagerActivity.class);
                startActivity(managerLogin);
            }
        }
    }

    public void createUsers() {
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.users));
        while(scan.hasNextLine()){
            String username = scan.nextLine();
            String password = scan.nextLine();
            String access = scan.nextLine();
            User user = new User(username, password, access);
            users.add(user);
        }
    }
}

