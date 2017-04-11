package edu.oswego.csc380_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    boolean menuLayout = true;
    ArrayList<Order> appetizers = new ArrayList<>();
    ArrayList<Order> entrees = new ArrayList<>();
    ArrayList<Order> desserts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        createMenu();

        Button appetizers = (Button) findViewById(R.id.appetizers);
        Button entrees = (Button) findViewById(R.id.entrees);
        Button desserts = (Button) findViewById(R.id.desserts);

        appetizers.setOnClickListener(this);
        entrees.setOnClickListener(this);
        desserts.setOnClickListener(this);

        ListView listView = (ListView) findViewById(android.R.id.list);
        /*ArrayAdapter<Order> appAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, appetizers);
        ArrayAdapter<Order> entAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, entrees);
        ArrayAdapter<Order> desAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, desserts);*/
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.appetizers:
                setContentView(R.layout.activity_appetizer);
                menuLayout = false;
                break;
            case R.id.entrees:
                setContentView(R.layout.activity_entrees);
                menuLayout = false;
                break;
            case R.id.desserts:
                setContentView(R.layout.activity_desserts);
                menuLayout = false;
                break;
        }
    }
    @Override
    public void onBackPressed(){
        if(!menuLayout){
            setContentView(R.layout.activity_menu);
            menuLayout = true;
        }
        else{
            menuLayout = true;
            super.onBackPressed();
        }
    }
    public void createMenu(){
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.appetizers));
        while(scan.hasNextLine()){
            String oName = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Order app = new Order(oName, "appetizer", price);
            appetizers.add(app);
        }
        scan.close();
        scan = new Scanner(getResources().openRawResource(R.raw.entrees));
        while(scan.hasNextLine()){
            String oName = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Order ent = new Order(oName, "entree", price);
            entrees.add(ent);
        }
        scan.close();
        scan = new Scanner(getResources().openRawResource(R.raw.entrees));
        while(scan.hasNextLine()){
            String oName = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Order des = new Order(oName, "dessert", price);
            desserts.add(des);
        }
    }
}
