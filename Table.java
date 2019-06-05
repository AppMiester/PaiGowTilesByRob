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

    boolean tilesDealt = false;

    ArrayList<Tile> deck = new ArrayList<Tile>();
    ArrayList<Tile> playerTiles = new ArrayList<Tile>();
    ArrayList<Tile> dealerTiles = new ArrayList<Tile>();
    ArrayList<TextView> playerTileViews = new ArrayList<TextView>();

    Handler handler = new Handler();

    Hand playerHand_0 = new Hand();
    Hand playerHand_1 = new Hand();
    Hand dealerHand_0 = new Hand();
    Hand dealerHand_1 = new Hand();


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

        if(tilesDealt) {

            Tile tile;

            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (params.bottomMargin == unSelectedMargin) {
                params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, params.bottomMargin + 30);
                view.setLayoutParams(params);



                switch(view.getId()){

                    case R.id.player_tile_0:
                        tile = playerTiles.get(0);
                        tile.setViewId(R.id.player_tile_0);

                        if(playerHand_0.getTile0()== null){
                            playerHand_0.setTile0(tile);
                            break;
                        }else{
                            playerHand_0.setTile1(tile);
                            break;

                        }

                    case R.id.player_tile_1:
                        tile = playerTiles.get(1);
                        tile.setViewId(R.id.player_tile_1);

                        if(playerHand_0.getTile0()== null){
                            playerHand_0.setTile0(tile);
                            break;
                        }else{
                            playerHand_0.setTile1(tile);
                            break;

                        }

                    case R.id.player_tile_2:
                        tile = playerTiles.get(2);
                        tile.setViewId(R.id.player_tile_2);

                        if(playerHand_0.getTile0()== null){
                            playerHand_0.setTile0(tile);
                            break;
                        }else{
                            playerHand_0.setTile1(tile);
                            break;

                        }

                    case R.id.player_tile_3:
                        tile = playerTiles.get(3);
                        tile.setViewId(R.id.player_tile_3);

                        if(playerHand_0.getTile0()== null){
                            playerHand_0.setTile0(tile);
                            break;
                        }else{
                            playerHand_0.setTile1(tile);
                            break;

                        }


                }
            } else {
                params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, params.bottomMargin - 30);
                view.setLayoutParams(params);

                switch(view.getId()){

                    case R.id.player_tile_0:
                        tile = playerTiles.get(0);
                        if(tile == playerHand_0.getTile0()){
                            playerHand_0.setTile0(null);
                            break;
                        }else{
                            playerHand_0.setTile1(null);
                            break;
                        }

                    case R.id.player_tile_1:
                        tile = playerTiles.get(1);
                        if(tile == playerHand_0.getTile0()){
                            playerHand_0.setTile0(null);
                            break;
                        }else{
                            playerHand_0.setTile1(null);
                            break;
                        }

                    case R.id.player_tile_2:
                        tile = playerTiles.get(2);
                        if(tile == playerHand_0.getTile0()){
                            playerHand_0.setTile0(null);
                            break;
                        }else{
                            playerHand_0.setTile1(null);
                            break;
                        }

                    case R.id.player_tile_3:
                        tile = playerTiles.get(0);
                        if(tile == playerHand_0.getTile0()){
                            playerHand_0.setTile0(null);
                            break;
                        }else{
                            playerHand_0.setTile1(null);
                            break;
                        }
                }
            }

        }

    }


    //-------DEAL

    public void deal(View view) {

        tilesDealt = true;


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


