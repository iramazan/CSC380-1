package edu.oswego.csc380_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlaceOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        TextView orderInfo = (TextView) findViewById(R.id.orderInfo);
        //sets textfield to the name and price of the clicked dish
        orderInfo.setText(getIntent().getStringExtra("dish"));
    }
}
