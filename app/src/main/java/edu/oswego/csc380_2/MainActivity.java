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

        Button login = (Button) findViewById(R.id.login);
        Button customer = (Button) findViewById(R.id.customer);

        login.setOnClickListener(this);
        customer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.login:
                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);
                break;
            case R.id.customer:
                Intent menu = new Intent(this, MenuActivity.class);
                startActivity(menu);
                break;
        }

    }
}

