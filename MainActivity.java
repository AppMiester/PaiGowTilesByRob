package tribalway.by.paigow.com.paigowtilesbyrob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToTable(View view){
        Intent intent = new Intent(this,Table.class);
        startActivity(intent);
    }
}
