package edu.oswego.csc380_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

public class ManagerActivity extends Activity {

    private BottomNavigationView bnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        bnav = (BottomNavigationView) findViewById(R.id.managerBottomNav);
        bnav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.managerMenuEdit:
                        break;
                    case R.id.managerEmployeeSchedules:
                        break;
                    case R.id.managerFinance:
                        break;
                    case R.id.managerStock:
                }
                return true;
            }
        });
    }

}
