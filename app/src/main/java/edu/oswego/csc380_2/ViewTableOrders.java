package edu.oswego.csc380_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ViewTableOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_table_orders);
        int index = Integer.parseInt(getIntent().getStringExtra("table"));
        ListView listView = (ListView) findViewById(android.R.id.list);
        ArrayAdapter<Table> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, RestaurantData.Instance().tables.get(index).getOrders());
        if (!adapter.isEmpty()) {
            listView.setAdapter(adapter);
        }
    }

}
