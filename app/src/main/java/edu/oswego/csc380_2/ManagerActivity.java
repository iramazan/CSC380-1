package edu.oswego.csc380_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.menuEdit:

                break;
            case R.id.employeeSchedule:
                break;
            case R.id.stock:

        }
    }
}
