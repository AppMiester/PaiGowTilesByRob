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
    int tilesSelected = 0;

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

        Tile tile;
        TextView deal = (TextView) findViewById(R.id.deal);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();

        if(tilesDealt && tilesSelected < 2 && params.bottomMargin == unSelectedMargin) {


            params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, params.bottomMargin + 30);
                view.setLayoutParams(params);


                switch (view.getId()) {

                    case R.id.player_tile_0:
                        tilesSelected++;
                        tile = playerTiles.get(0);
                        //tile.setViewId(R.id.player_tile_0);

                        if (playerHand_0.getTile0() == null) {
                            playerHand_0.setTile0(tile);
                            Log.e("tileline85", "selectPlayerTile: ");
                            Log.e("tile86",playerHand_0.tile0.getName() );
                            break;
                        } else {
                            playerHand_0.setTile1(tile);
                            break;

                        }

                    case R.id.player_tile_1:
                        tilesSelected++;
                        tile = playerTiles.get(1);
                        //tile.setViewId(R.id.player_tile_1);

                        if (playerHand_0.getTile0() == null) {
                            playerHand_0.setTile0(tile);
                            break;
                        } else {
                            playerHand_0.setTile1(tile);
                            break;

                        }

                    case R.id.player_tile_2:
                        tilesSelected++;
                        tile = playerTiles.get(2);
                        //tile.setViewId(R.id.player_tile_2);

                        if (playerHand_0.getTile0() == null) {
                            playerHand_0.setTile0(tile);
                            break;
                        } else {
                            playerHand_0.setTile1(tile);
                            break;

                        }

                    case R.id.player_tile_3:
                        tilesSelected++;
                        tile = playerTiles.get(3);
                        //tile.setViewId(R.id.player_tile_3);

                        if (playerHand_0.getTile0() == null) {
                            playerHand_0.setTile0(tile);
                            break;
                        } else {
                            playerHand_0.setTile1(tile);
                            break;

                        }


                }



        }else {

            if (tilesDealt && tilesSelected > 0 && params.bottomMargin > unSelectedMargin) {
                params.setMargins(params.leftMargin, params.topMargin, params.rightMargin, params.bottomMargin - 30);
                view.setLayoutParams(params);

                switch (view.getId()) {

                    case R.id.player_tile_0:
                        tilesSelected--;
                        tile = playerTiles.get(0);
                        //tile.setViewId(0);
                        if (tile == playerHand_0.getTile0()) {
                            playerHand_0.setTile0(null);
                            break;
                        } else {
                            playerHand_0.setTile1(null);
                            break;
                        }

                    case R.id.player_tile_1:
                        tilesSelected--;
                        tile = playerTiles.get(1);
                        //tile.setViewId(0);
                        if (tile == playerHand_0.getTile0()) {
                            playerHand_0.setTile0(null);
                            break;
                        } else {
                            playerHand_0.setTile1(null);
                            break;
                        }

                    case R.id.player_tile_2:
                        tilesSelected--;
                        tile = playerTiles.get(2);
                      //  tile.setViewId(0);
                        if (tile == playerHand_0.getTile0()) {
                            playerHand_0.setTile0(null);
                            break;
                        } else {
                            playerHand_0.setTile1(null);
                            break;
                        }

                    case R.id.player_tile_3:
                        tilesSelected--;
                        tile = playerTiles.get(0);
                    //    tile.setViewId(0);
                        if (tile == playerHand_0.getTile0()) {
                            playerHand_0.setTile0(null);
                            break;
                        } else {
                            playerHand_0.setTile1(null);
                            break;
                        }
                }
            }
        }


        if(tilesSelected == 2){
            deal.setTextColor(Color.GREEN);
        }else{
            deal.setTextColor(Color.BLACK);
        }



    }







    //-------DEAL

    public void deal(View view) {




        //-----this runs whn deal is first pressed

        if (tilesDealt == false && tilesSelected == 0) {
            tilesDealt = true;


            deck.addAll(Deck.getNewDeck());
            Tile tempTile;
            Context context = Table.this;

            Random random = new Random();


            for (int i = 0; i < 4; i++) {
                delay = (i + 1) * 50;

                int tile = random.nextInt(deck.size());

                tempTile = deck.get(tile);
                tempTile.setViewId(playerTileViews.get(i).getId());
                playerTiles.add(tempTile);
                deck.remove(tile);

                TextView playerTexView = playerTileViews.get(i);

                handler.postDelayed(new TileFlip(playerTexView, tempTile, handler, context), delay);

            }
            delay = 1000;

            deck = new ArrayList<Tile>();
        }

        TextView deal = (TextView) findViewById(R.id.deal);
        deal.setText(getResources().getString(R.string.select));

         if(tilesDealt && tilesSelected == 2){

             for(int i = 0; i < playerTiles.size(); i++){
              Tile  tempTile = playerTiles.get(i);
              if(tempTile != playerHand_0.tile0 && tempTile != playerHand_0.tile1 && playerHand_1.tile0 == null){
                  playerHand_1.tile0 = playerTiles.get(i);
                  continue;
              }
                 if(tempTile != playerHand_0.tile0 && tempTile != playerHand_0.tile1 && playerHand_1.tile1 == null){
                     playerHand_1.tile1 = playerTiles.get(i);
                 }

             }


             Log.e("tile275", playerHand_0.tile0.getName() );
             Log.e("tile276", playerHand_0.tile1.getName() );
             Log.e("tile277", playerHand_1.tile0.getName() );
             Log.e("tile278", playerHand_1.tile1.getName() );
           playerHand_0.setHandValues();
           playerHand_1.setHandValues();
           Hand.findHighHand(playerHand_0,playerHand_1);
           Log.e("o is hafhand", Boolean.toString(playerHand_0.isHighHand()));
           Log.e("player0 rank =", Integer.toString(playerHand_0.getHandRank()));
             Log.e("player0 number points =", Integer.toString(playerHand_0.getNumberOfPoints()));
             Log.e("player1 rank =", Integer.toString(playerHand_1.getHandRank()));
             Log.e("player1 numberpoints =", Integer.toString(playerHand_1.getNumberOfPoints()));
           movePlayerViews(playerHand_0,playerHand_1);
         }
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


    public void movePlayerViews(Hand playerHand_0, Hand playerHand_1){
        Hand highHand = (playerHand_0.isHighHand())? playerHand_0 : playerHand_1;
        Hand lowHand = (playerHand_0.isHighHand())? playerHand_1 : playerHand_0;

        TextView highHandView0 = (TextView) findViewById(highHand.tile0.getViewId());
        TextView highHandView1 = (TextView) findViewById(highHand.tile1.getViewId());
        TextView lowHandView0 = (TextView) findViewById(lowHand.tile0.getViewId());
        TextView lowHandView1 = (TextView) findViewById(lowHand.tile1.getViewId());

        highHandView0.setRotation(90);
        highHandView1.setRotation(90);

        highHand.setHighHand(false);
        highHand.setHighHand(false);

    }




}


