package tribalway.by.paigow.com.paigowtilesbyrob;

import java.util.ArrayList;

public class Deck
{
    ArrayList <Tile> newDeck;



      public Deck(){
          newDeck = new ArrayList <Tile>();

          newDeck.add(new Tile(Constants.gee_joon, true, 1, 3, 1, 16));
          newDeck.add(new Tile(Constants.gee_joon, true, 2, 6,1, 16));
          newDeck.add(new Tile(Constants.teen, false, -1, 12, 2,1));
          newDeck.add(new Tile(Constants.teen, false, -1, 12, 2,1));
          newDeck.add(new Tile(Constants.day, false, -1, 2, 3,2));
          newDeck.add(new Tile(Constants.day, false, -1, 2, 3,2));
          newDeck.add(new Tile(Constants.yun, false, -1, 8, 4,3));
          newDeck.add(new Tile(Constants.yun, false, -1, 8, 4,3));
          newDeck.add(new Tile(Constants.ngor, false, -1, 4, 5,4));
          newDeck.add(new Tile(Constants.ngor, false, -1, 4, 5, 4));
          newDeck.add(new Tile(Constants.mooy, false, -1, 10, 6, 5));
          newDeck.add(new Tile(Constants.mooy, false, -1, 10, 6, 5));
          newDeck.add(new Tile(Constants.chong, false, -1, 6, 7, 6));
          newDeck.add(new Tile(Constants.chong, false, -1, 6, 7, 6));
          newDeck.add(new Tile(Constants.bon, false, -1, 4, 8, 7));
          newDeck.add(new Tile(Constants.bon, false, -1, 4, 8, 7));
          newDeck.add(new Tile(Constants.foo, false, -1, 11, 9, 8));
          newDeck.add(new Tile(Constants.foo, false, -1, 11, 9, 8));
          newDeck.add(new Tile(Constants.ping, false, -1, 10, 10, 9));
          newDeck.add(new Tile(Constants.ping, false, -1, 10, 10, 9));
          newDeck.add(new Tile(Constants.tit, false, -1, 7, 11, 10));
          newDeck.add(new Tile(Constants.tit, false, -1, 7, 11, 10));
          newDeck.add(new Tile(Constants.look, false, -1, 6, 12, 11));
          newDeck.add(new Tile(Constants.look, false, -1, 6, 12, 11));
          newDeck.add(new Tile(Constants.chop_gow, true, 0, 9, 13, 12));
          newDeck.add(new Tile(Constants.chop_gow, true, 1, 9, 13, 12));
          newDeck.add(new Tile(Constants.chop_baht, true, 0, 8, 14, 13));
          newDeck.add(new Tile(Constants.chop_baht, true, 1, 8, 14, 13));
          newDeck.add(new Tile(Constants.chop_chit, true, 0, 7, 15, 14));
          newDeck.add(new Tile(Constants.chop_chit, true, 1, 7, 15, 14));
          newDeck.add(new Tile(Constants.chop_ng, true, 0, 5, 16, 15));
          newDeck.add(new Tile(Constants.chop_ng, true, 1, 5, 16, 15));
      }



      public static ArrayList getNewDeck(){
          return new Deck().newDeck;
      }


}
