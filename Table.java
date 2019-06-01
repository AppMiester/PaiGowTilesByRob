package tribalway.by.paigow.com.paigowtilesbyrob;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Table extends AppCompatActivity {

    int unSelectedMargin;
    double bankroll = 1000.00;

    ArrayList<Tile> deck = new ArrayList<Tile>();
    ArrayList <Tile> playerTiles= new ArrayList<Tile>();
    ArrayList <Tile> dealerTiles = new ArrayList<Tile>();
    ArrayList <TextView> playerTileViews = new ArrayList<TextView>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        TextView dealer = (TextView) findViewById(R.id.dealer_tile_0);
        /*TextView playerTile0 = (TextView) findViewById(R.id.player_tile_0);
        TextView playerTile1= (TextView) findViewById(R.id.player_tile_1);
        TextView playerTile2 = (TextView) findViewById(R.id.player_tile_2);
        TextView playerTile3 = (TextView) findViewById(R.id.player_tile_0);*/

        unSelectedMargin = getMargin(dealer);
     //   setPlayerTileViews(playerTile0,playerTile1,playerTile2,playerTile3);


    }





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

    public void deal(View view){
        setPlayerTileViews();

        deck.addAll(Deck.getNewDeck());
        Tile tempTile;

        Random random = new Random();

        for(int i = 0; i < 4; i++){
            int tile = random.nextInt(deck.size()+1);
            Log.e("first tile", deck.get(0).getName());
            tempTile = deck.get(tile);
            Log.e("temptile =" , tempTile.getName());
            playerTiles.add(tempTile);
            deck.remove(tile);
            System.out.println("deck" + deck);

            TextView playerTexView = playerTileViews.get(i);

            playerTexView.setText(playerTiles.get(i).getName() + playerTiles.get(i).isMixedPair());

        }


    }

    public void setPlayerTileViews(){
       /* TextView t0 = (TextView) view0;
        TextView t1 = (TextView) view1;
        TextView t2 = (TextView) view2;
        TextView t3 = (TextView) view3;*/

        TextView playerTile0 = (TextView) findViewById(R.id.player_tile_0);
        TextView playerTile1= (TextView) findViewById(R.id.player_tile_1);
        TextView playerTile2 = (TextView) findViewById(R.id.player_tile_2);
        TextView playerTile3 = (TextView) findViewById(R.id.player_tile_3);


        playerTileViews.add(playerTile0);
        playerTileViews.add(playerTile1);
        playerTileViews.add(playerTile2);
        playerTileViews.add(playerTile3);
    }

    public int getMargin(View view){

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return params.topMargin;
    }

}
