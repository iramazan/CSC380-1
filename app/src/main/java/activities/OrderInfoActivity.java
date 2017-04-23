package activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.oswego.csc380_2.Order;
import edu.oswego.csc380_2.R;

public class OrderInfoActivity extends ListActivity {
    ArrayList<Order> appetizersMenu = RestaurantData.Instance().appetizersMenu;
    ArrayList<Order> entreesMenu = RestaurantData.Instance().entreesMenu;
    ArrayList<Order> dessertsMenu = RestaurantData.Instance().dessertsMenu;
    String type = "-1";
    String access;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //create listview to display items
        ListView listView;
        //create adapter to load the listview
        ArrayAdapter<Order> adapter;
        //call create menu method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderinfo);
        //conditionals to check which list of items to display
        if(getIntent().getStringExtra("type").equals("appetizers")){
            //initialize list view
            listView = (ListView) findViewById(android.R.id.list);
            //initialize arrayadpater with the appropriate arraylist
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, appetizersMenu);
            listView.setAdapter(adapter);
            type = "0";
        }
        else if(getIntent().getStringExtra("type").equals("entrees")){
            listView = (ListView) findViewById(android.R.id.list);
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, entreesMenu);
            listView.setAdapter(adapter);
            type = "1";
        }
        else{
            listView = (ListView) findViewById(android.R.id.list);
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dessertsMenu);
            listView.setAdapter(adapter);
            type = "2";
        }

        access = getIntent().getStringExtra("access");
    }

    //method for clicking on a list iem
    public void onListItemClick(ListView l, View v, int position, long id){
        Intent intent = new Intent(this, PlaceOrderActivity.class);
        //retrieve current listview
        ListView lv = (ListView) findViewById(android.R.id.list);
        //retrieve current adapter
        ListAdapter la = lv.getAdapter();
        if(la != null){
            //create a string to store the info for that item
            String info = la.getItem(position).toString();
            //pass it into the new activity
            intent.putExtra("dish", info);
            intent.putExtra("type", type);
            intent.putExtra("access", access);
            if(access.equals("employee")){
                String index = getIntent().getStringExtra("index");
                intent.putExtra("index", index);
            }

        }
        startActivity(intent);
    }
}
