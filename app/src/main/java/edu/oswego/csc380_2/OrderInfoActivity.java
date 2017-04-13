package edu.oswego.csc380_2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderInfoActivity extends ListActivity {
    ArrayList<Order> appetizersMenu = new ArrayList<>();
    ArrayList<Order> entreesMenu = new ArrayList<>();
    ArrayList<Order> dessertsMenu = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listView;
        ArrayAdapter<Order> adapter;
        createMenu();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderinfo);
        if(getIntent().getStringExtra("type").equals("appetizers")){
            listView = (ListView) findViewById(android.R.id.list);
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, appetizersMenu);
            listView.setAdapter(adapter);
        }
        else if(getIntent().getStringExtra("type").equals("entrees")){
            listView = (ListView) findViewById(android.R.id.list);
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, entreesMenu);
            listView.setAdapter(adapter);
        }
        else{
            listView = (ListView) findViewById(android.R.id.list);
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dessertsMenu);
            listView.setAdapter(adapter);
        }
    }

    public void createMenu(){
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.appetizers));
        while(scan.hasNextLine()){
            String oName = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Order app = new Order(oName, "appetizer", price);
            appetizersMenu.add(app);
        }
        scan.close();
        scan = new Scanner(getResources().openRawResource(R.raw.entrees));
        while(scan.hasNextLine()){
            String oName = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Order ent = new Order(oName, "entree", price);
            entreesMenu.add(ent);
        }
        scan.close();
        scan = new Scanner(getResources().openRawResource(R.raw.desserts));
        while(scan.hasNextLine()){
            String oName = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Order des = new Order(oName, "dessert", price);
            dessertsMenu.add(des);
        }
    }
}
