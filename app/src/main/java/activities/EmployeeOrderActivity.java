package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.oswego.csc380_2.R;

public class EmployeeOrderActivity extends AppCompatActivity implements View.OnClickListener{
    int index;
    int oIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_order);
        Button start = (Button) findViewById(R.id.start);
        Button finish = (Button) findViewById(R.id.finish);
        Button stop = (Button) findViewById(R.id.stop);

        start.setOnClickListener(this);
        finish.setOnClickListener(this);
        stop.setOnClickListener(this);

        index = Integer.parseInt(getIntent().getStringExtra("index"));
        oIndex = Integer.parseInt(getIntent().getStringExtra("order"));
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.start:
                RestaurantData.Instance().tables.get(index).getOrders().get(oIndex).startOrder();
                break;
            case R.id.finish:
                RestaurantData.Instance().tables.get(index).getOrders().get(oIndex).finishOrder();
                break;
            case R.id.stop:
                RestaurantData.Instance().tables.get(index).getOrders().get(oIndex).stopOrder();
                break;
        }
    }
}
