package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.oswego.csc380_2.R;

public class EmployeeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        Button viewOrders = (Button) findViewById(R.id.viewOrders);
        Button schedule = (Button) findViewById(R.id.schedule);
        Button serverTables = (Button) findViewById(R.id.serverTables);
        viewOrders.setOnClickListener(this);
        schedule.setOnClickListener(this);
        serverTables.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent;
        //retrieve the extra from previous activity in order to match schedule and tables to current employee
        String id = getIntent().getStringExtra("id");
        switch(v.getId()){
            case R.id.viewOrders:
                intent = new Intent(this, FoodOrdersActivity.class);
                startActivity(intent);
                break;
            case R.id.schedule:
                intent = new Intent(this, ScheduleActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.serverTables:
                intent = new Intent(this, ViewTablesActivity.class);
                startActivity(intent);
                break;

        }
    }
}
