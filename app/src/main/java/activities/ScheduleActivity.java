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
        ListView lv = (ListView) findViewById(android.R.id.list);
        ArrayAdapter<String> ar = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, RestaurantData.Instance().users.get(userIndex).getSchedule());
        lv.setAdapter(ar);

    }
}
