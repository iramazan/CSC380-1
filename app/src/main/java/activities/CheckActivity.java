package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.oswego.csc380_2.Order;
import edu.oswego.csc380_2.R;


public class CheckActivity extends AppCompatActivity implements View.OnClickListener{
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        index = Integer.parseInt(getIntent().getStringExtra("index"));
        //create buttons
        Button fullCheck = (Button) findViewById(R.id.fullcheck);
        Button splitCheck = (Button) findViewById(R.id.splitcheck);
        //set onClickListeners
        fullCheck.setOnClickListener(this);
        splitCheck.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        //check if the table has orders
        if(!RestaurantData.Instance().tables.get(index).getOrders().isEmpty()) {
            //changes view to check view
            setContentView(R.layout.activity_check_view);
            Button payCheck = (Button) findViewById(R.id.paycheck);
            payCheck.setOnClickListener(this);
            //temporary variable to hold check value
            double check;
            //create textviews based off of XML ids
            TextView price = (TextView) findViewById(R.id.price);
            TextView peopleCount = (TextView) findViewById(R.id.peoplecount);
            TextView table = (TextView) findViewById(R.id.tableNumber);
            switch (v.getId()) {
                //return the full value of the tables check
                case R.id.fullcheck:
                    check = RestaurantData.Instance().tables.get(index).generateBill().getAmount();
                    table.setText("Table ID:" + index);
                    price.setText("$" + check);
                    break;
                //return the value of the check split by the number of people seated
                case R.id.splitcheck:
                    int people = RestaurantData.Instance().tables.get(index).getSeatedCustomers();
                    check = (RestaurantData.Instance().tables.get(index).generateBill().splitBillByNumber(people));
                    table.setText("Table ID:" + index);
                    price.setText("$" + check);
                    peopleCount.setText("People count:" + people);
                    break;
                //"pay" the check, remove the orders from the global orders array, and free the table
                case R.id.paycheck:
                    RestaurantData.Instance().removeTableOrders(RestaurantData.Instance().tables.get(index).getOrders());
                    RestaurantData.Instance().tables.get(index).freeTable();
                    onBackPressed();
            }
        }
        else{
            //if the table has no orders
            TextView checkStatus = (TextView) findViewById(R.id.checkStatus);
            checkStatus.setText("This table has no check");
        }
    }
}
