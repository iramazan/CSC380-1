package activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import edu.oswego.csc380_2.R;
import menu.FinanceFragment;
import menu.ManagerEmployeeScheduleFragment;
import menu.ManagerMenuEditFragment;
import menu.StockFragment;

public class ManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        BottomNavigationView bnav = (BottomNavigationView) findViewById(R.id.managerBottomNav);
        bnav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch(item.getItemId()) {
                    case R.id.managerMenuEdit:
                        fragment = ManagerMenuEditFragment.newInstance();
                        break;
                    /*
                    case R.id.managerEmployeeSchedules:
                        fragment = ManagerEmployeeScheduleFragment.newInstance();
                        break;
                    case R.id.managerFinance:
                        fragment = FinanceFragment.newInstance();
                        break;
                    */
                    case R.id.managerStock:
                        fragment = StockFragment.newInstance();
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.managerContainer, fragment);
                transaction.commit();
                return true;
            }
        });

        // Display default fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.managerContainer, StockFragment.newInstance());
        transaction.commit();
    }

}
