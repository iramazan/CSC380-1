package edu.oswego.csc380_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create new buttons
        Button login = (Button) findViewById(R.id.login);
        Button customer = (Button) findViewById(R.id.customer);
        //set onClickListeners
        login.setOnClickListener(this);
        customer.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        //switch case to check which button is selected
        switch(v.getId()){
            //if login button, begin login activity
            case R.id.login:
                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);
                break;
            //if customer button, begin menu activity
            case R.id.customer:
                Intent menu = new Intent(this, MenuActivity.class);
                startActivity(menu);
                break;
        }

    }
}

