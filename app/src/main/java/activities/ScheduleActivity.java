package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import edu.oswego.csc380_2.R;

public class ScheduleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        String username = getIntent().getStringExtra("id");
        int userIndex = -1;
        for(int i = 0; i < RestaurantData.Instance().users.size(); i++){
            if(RestaurantData.Instance().users.get(i).getName().equals(username)){
                userIndex = i;
            }
        }
//        TextView monday = (TextView) findViewById(R.id.monday);
//        TextView tuesday = (TextView) findViewById(R.id.tuesday);
//        TextView wednesday = (TextView) findViewById(R.id.wednesday);
//        TextView thursday = (TextView) findViewById(R.id.thursday);
//        TextView friday = (TextView) findViewById(R.id.friday);
//        TextView saturday = (TextView) findViewById(R.id.saturday);
//        TextView sunday = (TextView) findViewById(R.id.sunday);
//
//        TextView week[] = new TextView[7];
//        week[0] = monday;
//        week[1] = tuesday;
//        week[2] = wednesday;
//        week[3] = thursday;
//        week[4] = friday;
//        week[5] = saturday;
//        week[6] = sunday;
//
//        for(int i = 0; i < 7; i++){
//            week[i].setText(RestaurantData.Instance().dateHelper(i) + );
//        }
        ListView lv = (ListView) findViewById(android.R.id.list);
        ArrayAdapter<String> ar = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, RestaurantData.Instance().users.get(userIndex).getSchedule());
        lv.setAdapter(ar);

    }
}
