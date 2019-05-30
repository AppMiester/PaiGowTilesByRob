package tribalway.by.paigow.com.paigowtilesbyrob;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        TextView dealer = (TextView) findViewById(R.id.dealer_tile_0);
        unSelectedMargin = getMargin(dealer);
    }

    int unSelectedMargin;




    public void selectPlayerTile(View view) {
        System.out.println("unselected margin = " + unSelectedMargin);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (params.bottomMargin == unSelectedMargin) {
            params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, params.bottomMargin + 30);
            view.setLayoutParams(params);
        }else{
            params.setMargins(params.leftMargin, params.topMargin, params.rightMargin,params.bottomMargin - 30);
            view.setLayoutParams(params);
        }

    }

    public int getMargin(View view){

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return params.topMargin;
    }
}
