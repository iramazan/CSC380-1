package edu.oswego.csc380_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceOrderActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        TextView orderInfo = (TextView) findViewById(R.id.orderInfo);
        //sets textfield to the name and price of the clicked dish
        orderInfo.setText(getIntent().getStringExtra("dish"));
        Button placeOrder = (Button) findViewById(R.id.placeOrder);
        placeOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        String info[] = getIntent().getStringExtra("dish").split("\n");
        int type = Integer.parseInt(getIntent().getStringExtra("type"));
        String access = getIntent().getStringExtra("access");
        if(type == 0){
            ArrayList<Order> appetizersMenu = RestaurantData.Instance().appetizersMenu;
            for(int i = 0; i < appetizersMenu.size(); i++){
                if(appetizersMenu.get(i).getName().equals(info[0])){
                    Order o = appetizersMenu.get(i);
                    RestaurantData.Instance().orders.add(o);
                    if(access.equals("employee")){
                        String tableNum = getIntent().getStringExtra("index");
                        int index = Integer.parseInt(tableNum);
                        RestaurantData.Instance().tables.get(index).placeOrder(o);
                    }
                }
            }
        }
        else if(type == 1){
            ArrayList<Order> entreesMenu = RestaurantData.Instance().entreesMenu;
            for(int i = 0; i < entreesMenu.size(); i++){
                if(entreesMenu.get(i).getName().equals(info[0])){
                    Order o = entreesMenu.get(i);
                    RestaurantData.Instance().orders.add(o);
                    if(access.equals("employee")){
                        String tableNum = getIntent().getStringExtra("index");
                        int index = Integer.parseInt(tableNum);
                        RestaurantData.Instance().tables.get(index).placeOrder(o);
                    }
                }
            }
        }
        else{
            ArrayList<Order> dessertsMenu = RestaurantData.Instance().dessertsMenu;
            for(int i = 0; i < dessertsMenu.size(); i++){
                if(dessertsMenu.get(i).getName().equals(info[0])){
                    Order o = dessertsMenu.get(i);
                    RestaurantData.Instance().orders.add(o);
                    if(access.equals("employee")){
                        String tableNum = getIntent().getStringExtra("index");
                        int index = Integer.parseInt(tableNum);
                        RestaurantData.Instance().tables.get(index).placeOrder(o);
                    }
                }
            }
        }
        onBackPressed();
    }
}
