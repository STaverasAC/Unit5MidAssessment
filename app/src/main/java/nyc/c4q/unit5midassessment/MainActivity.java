package nyc.c4q.unit5midassessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import nyc.c4q.unit5midassessment.network.UserAPI;
import nyc.c4q.unit5midassessment.network.UserAPIClient;

public class MainActivity extends AppCompatActivity {

    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.user_rec_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

        final UserAPIClient client = new UserAPIClient(recyclerView);
        client.start();

        refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client.start();
            }
        });



    }
}
