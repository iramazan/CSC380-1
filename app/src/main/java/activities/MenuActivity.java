package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.oswego.csc380_2.R;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    String access;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        access = getIntent().getStringExtra("access");
        System.out.println(access);

        Button appetizers = (Button) findViewById(R.id.appetizers);
        Button entrees = (Button) findViewById(R.id.entrees);
        Button desserts = (Button) findViewById(R.id.desserts);

        appetizers.setOnClickListener(this);
        entrees.setOnClickListener(this);
        desserts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            //if appetizers button pressed, start order info activity for appetizers
            case R.id.appetizers:
                intent = new Intent(this, OrderInfoActivity.class).putExtra("type", "appetizers");
                intent.putExtra("access",access);
                if(access.equals("employee")){
                    String index = getIntent().getStringExtra("index");
                    System.out.println(index);
                     intent.putExtra("index", ""+index);
                }
                startActivity(intent);
                break;
            //if appetizers button pressed, start order info activity for entrees
            case R.id.entrees:
                intent = new Intent(this, OrderInfoActivity.class).putExtra("type", "entrees");
                intent.putExtra("access",access);
                if(access.equals("employee")){
                    String index = getIntent().getStringExtra("index");
                    intent.putExtra("index", ""+index);
                }
                startActivity(intent);
                break;
            //if appetizers button pressed, start order info activity for desserts
            case R.id.desserts:
                intent = new Intent(this, OrderInfoActivity.class).putExtra("type", "desserts");
                intent.putExtra("access",access);
                if(access.equals("employee")){
                    String index = getIntent().getStringExtra("index");
                    intent.putExtra("index", ""+index);
                }
                startActivity(intent);
                break;
        }
    }
}
