package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.oswego.csc380_2.Order;
import edu.oswego.csc380_2.R;
import edu.oswego.csc380_2.Table;

public class ViewTableOptionsActivity extends AppCompatActivity implements View.OnClickListener{
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_table_options);
        index = Integer.parseInt(getIntent().getStringExtra("table"));

        Button seatTable = (Button) findViewById(R.id.seatTable);
        Button placeTableOrder = (Button) findViewById(R.id.placeTableOrder);
        Button getCheck = (Button) findViewById(R.id.getCheck);
        Button viewOrders = (Button) findViewById(R.id.viewTableOrders);
        Button evict = (Button) findViewById(R.id.evict);

        seatTable.setOnClickListener(this);
        placeTableOrder.setOnClickListener(this);
        viewOrders.setOnClickListener(this);
        getCheck.setOnClickListener(this);
        evict.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        TextView numCustomers = (TextView) findViewById(R.id.seatedCustomers);
        TextView custOutput = (TextView) findViewById(R.id.actionOutputEmployee);
        TextView tableStatus = (TextView) findViewById(R.id.tableStatus);
        Intent intent;
        Table.TableStatus t = RestaurantData.Instance().tables.get(index).getTableStatus();
        switch(v.getId()){
            case R.id.seatTable:
                //if the table is unuoccupied
                if(t != Table.TableStatus.OCCUPIED && t != Table.TableStatus.DIRTY) {
                    //set content to the miniactivity and create the button in it
                    setContentView(R.layout.miniactivity_seat_table);
                    Button seatCustomers = (Button) findViewById(R.id.seatCustomer);
                    seatCustomers.setOnClickListener(this);
                }
                else if(t == Table.TableStatus.DIRTY){
                    tableStatus.setText("This table is currently dirty.");
                }
                else{
                    tableStatus.setText("This table is currently occupied.");
                }
                break;
            case R.id.placeTableOrder:
                if(t != Table.TableStatus.OCCUPIED){
                    tableStatus.setText("This table must be seated to place orders for it.");
                }
                else{
                    //create the new intent and place the info in it
                    intent = new Intent(this, MenuActivity.class);
                    intent.putExtra("access","employee");
                    intent.putExtra("index",""+index);
                    System.out.println(index);
                    startActivity(intent);
                }
                break;
            case R.id.getCheck:
                //retrieve the check if the table is occupied
                if(t != Table.TableStatus.OCCUPIED){
                    tableStatus.setText("This table does not have a check.");
                }
                else{
                    intent = new Intent(this, CheckActivity.class);
                    intent.putExtra("index",""+index);
                    startActivity(intent);
                }
                break;
            case R.id.viewTableOrders:
                //retrieve a listview of the orders in a table if the orders array is not empty
                if(RestaurantData.Instance().tables.get(index).getOrders()!=null){
                    intent = new Intent(this, ViewTableOrders.class);
                    intent.putExtra("index", ""+index);
                    startActivity(intent);
                }
                else{
                    tableStatus.setText("This table has no orders");
                }
                break;
            case R.id.evict:
                //evict a table and set its ENUM to something depending on the current state of it
                if(t == Table.TableStatus.OCCUPIED){
                    tableStatus.setText("This table is now DIRTY");
                    //for each order at this table
                    RestaurantData.Instance().removeTableOrders(RestaurantData.Instance().tables.get(index).getOrders());
                    RestaurantData.Instance().tables.get(index).freeTable();
                }
                else if(t == Table.TableStatus.DIRTY){
                    tableStatus.setText("This table is now CLEAN and FREE");
                    RestaurantData.Instance().tables.get(index).cleanTable();
                }
                break;
            case R.id.seatCustomer:
                //retrieve the inputted amount
                String nCust = numCustomers.getText().toString();
                //parse to int
                int seatAmount = Integer.parseInt(nCust);
                //if the inputted amount is valid for the given table, seat the table
                if(seatAmount <= RestaurantData.Instance().tables.get(index).getSeatingCapacity() && seatAmount > 0){
                    RestaurantData.Instance().tables.get(index).seatTable(seatAmount);
                    this.recreate();
                }
                //else output an error message
                else{
                    int cap = RestaurantData.Instance().tables.get(index).getSeatingCapacity();
                    custOutput.setText("Please enter a number greater than 0, and equal to or less then " + cap);
                }
                break;
        }
    }
}
