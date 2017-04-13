package edu.oswego.csc380_2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button appetizers = (Button) findViewById(R.id.appetizers);
        Button entrees = (Button) findViewById(R.id.entrees);
        Button desserts = (Button) findViewById(R.id.desserts);

        appetizers.setOnClickListener(this);
        entrees.setOnClickListener(this);
        desserts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ListView listView = null;
        ArrayAdapter<Order> adapter = null;
        Intent intent;
        switch(v.getId()){

            case R.id.appetizers:
                intent = new Intent(this, OrderInfoActivity.class).putExtra("type", "appetizers");
                startActivity(intent);
                break;
            case R.id.entrees:
                intent = new Intent(this, OrderInfoActivity.class).putExtra("type", "entrees");
                startActivity(intent);
                break;
            case R.id.desserts:
                intent = new Intent(this, OrderInfoActivity.class).putExtra("type", "desserts");
                startActivity(intent);
                break;
        }
    }
}
