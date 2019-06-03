package tribalway.by.paigow.com.paigowtilesbyrob;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Table extends AppCompatActivity {

    int unSelectedMargin;
    double bankroll = 1000.00;
    long delay = 1000;

    ArrayList<Tile> deck = new ArrayList<Tile>();
    ArrayList<Tile> playerTiles = new ArrayList<Tile>();
    ArrayList<Tile> dealerTiles = new ArrayList<Tile>();
    ArrayList<TextView> playerTileViews = new ArrayList<TextView>();

    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_table);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        TextView dealer = (TextView) findViewById(R.id.dealer_tile_0);

        setPlayerTileViews();

        unSelectedMargin = getMargin(dealer);
        }




    public void selectPlayerTile(View view) {
        System.out.println("unselected margin = " + unSelectedMargin);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (params.bottomMargin == unSelectedMargin) {
            params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, params.bottomMargin + 30);
            view.setLayoutParams(params);
        } else {
            params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, params.bottomMargin - 30);
            view.setLayoutParams(params);
        }

    }


    //-------DEAL

    public void deal(View view) {


        deck.addAll(Deck.getNewDeck());
        Tile tempTile;
        Context context = Table.this;

        Random random = new Random();


        for (int i = 0; i < 4; i++) {
            delay = (i + 1) * 50;

            int tile = random.nextInt(deck.size());

            tempTile = deck.get(tile);
            playerTiles.add(tempTile);
            deck.remove(tile);

            TextView playerTexView = playerTileViews.get(i);

            handler.postDelayed(new TileFlip(playerTexView, tempTile,handler,context), delay);

        }
        delay = 1000;
        playerTiles = new ArrayList<Tile>();
        deck = new ArrayList<Tile>();
    }




    public void setPlayerTileViews() {


        TextView playerTile0 = (TextView) findViewById(R.id.player_tile_0);
        TextView playerTile1 = (TextView) findViewById(R.id.player_tile_1);
        TextView playerTile2 = (TextView) findViewById(R.id.player_tile_2);
        TextView playerTile3 = (TextView) findViewById(R.id.player_tile_3);


        playerTileViews.add(playerTile0);
        playerTileViews.add(playerTile1);
        playerTileViews.add(playerTile2);
        playerTileViews.add(playerTile3);
    }

    public int getMargin(View view) {

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return params.topMargin;
    }




}


