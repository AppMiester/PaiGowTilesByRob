package tribalway.by.paigow.com.paigowtilesbyrob;

import java.util.ArrayList;

public class Deck
{
    ArrayList <Tile> newDeck;

    int x;
    int y;

      public Deck(){
          newDeck = new ArrayList <Tile>();

          newDeck.add(new Tile(Constants.gee_joon, true, 1, 3, 16));
          newDeck.add(new Tile(Constants.gee_joon, true, 2, 6, 16));
          newDeck.add(new Tile(Constants.teen, false, -1, 12, 1));
          newDeck.add(new Tile(Constants.teen, false, -1, 12, 1));
          newDeck.add(new Tile(Constants.day, false, -1, 2, 2));
          newDeck.add(new Tile(Constants.day, false, -1, 2, 2));
          newDeck.add(new Tile(Constants.yun, false, -1, 8, 3));
          newDeck.add(new Tile(Constants.yun, false, -1, 8, 3));
          newDeck.add(new Tile(Constants.ngor, false, -1, 4, 4));
          newDeck.add(new Tile(Constants.ngor, false, -1, 4, 4));
          newDeck.add(new Tile(Constants.mooy, false, -1, 10, 5));
          newDeck.add(new Tile(Constants.mooy, false, -1, 10, 5));
      }


}
