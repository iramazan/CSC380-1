package edu.oswego.csc380_2;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ViewTableOrders extends ListActivity {
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_table_orders);
        index = Integer.parseInt(getIntent().getStringExtra("index"));
        ListView listView = (ListView) findViewById(android.R.id.list);
        ArrayAdapter<Table> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, RestaurantData.Instance().tables.get(index).getOrders());
        if (!adapter.isEmpty()) {
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Intent intent = new Intent(this, EmployeeOrderActivity.class);
        //retrieve current listview
        ListView lv = (ListView) findViewById(android.R.id.list);
        //retrieve current adapter
        ListAdapter la = lv.getAdapter();
        System.out.println(position);
        System.out.println(id);
        if(la != null){
            //create a string to store the info for tha
            //pass it into the new activity
            intent.putExtra("index", ""+index);
            intent.putExtra("order", ""+position);
        }

        startActivity(intent);

    }
}
