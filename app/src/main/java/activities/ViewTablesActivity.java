package activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import edu.oswego.csc380_2.R;
import edu.oswego.csc380_2.Table;

public class ViewTablesActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tables);
        //initialize list view
        ListView listView = (ListView) findViewById(android.R.id.list);
        //initialize arrayadpater with the appropriate arraylist
        ArrayAdapter<Table> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, RestaurantData.Instance().tables);
        listView.setAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Intent intent = new Intent(this, ViewTableOptionsActivity.class);
        //retrieve current listview
        ListView lv = (ListView) findViewById(android.R.id.list);
        //retrieve current adapter
        ListAdapter la = lv.getAdapter();
        if(la != null){
            //create a string to store the info for that item
            String temp = la.getItem(position).toString();
            System.out.println(temp);
            String tempArray[] = temp.split(" ");
            //pass it into the new activity
            intent.putExtra("table", tempArray[1]);
        }
        startActivity(intent);
    }
}
