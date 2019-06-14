package tribalway.by.paigow.com.paigowtilesbyrob;

import java.util.ArrayList;

public class Deck
{
    ArrayList <Tile> newDeck;



      public Deck(){
          newDeck = new ArrayList <Tile>();

          newDeck.add(new Tile(Constants.gee_joon, true, 1, 3, 1, 16, R.drawable.gee_joon_1));//0
          newDeck.add(new Tile(Constants.gee_joon, true, 2, 3,1, 16, R.drawable.gee_joon_2));//1
          newDeck.add(new Tile(Constants.teen, false, -1, 12, 2,1, R.drawable.teen));//2
          newDeck.add(new Tile(Constants.teen, false, -1, 12, 2,1, R.drawable.teen));//3
          newDeck.add(new Tile(Constants.day, false, -1, 2, 3,2, R.drawable.day));//4
          newDeck.add(new Tile(Constants.day, false, -1, 2, 3,2, R.drawable.day));//5
          newDeck.add(new Tile(Constants.yun, false, -1, 8, 4,3, R.drawable.yun));//6
          newDeck.add(new Tile(Constants.yun, false, -1, 8, 4,3, R.drawable.yun));//7
          newDeck.add(new Tile(Constants.ngor, false, -1, 4, 5,4, R.drawable.ngor));//8
          newDeck.add(new Tile(Constants.ngor, false, -1, 4, 5, 4, R.drawable.ngor));//9
          newDeck.add(new Tile(Constants.mooy, false, -1, 10, 6, 5, R.drawable.mooy));//10
          newDeck.add(new Tile(Constants.mooy, false, -1, 10, 6, 5, R.drawable.mooy));//11
          newDeck.add(new Tile(Constants.chong, false, -1, 6, 7, 6, R.drawable.chong));//12
          newDeck.add(new Tile(Constants.chong, false, -1, 6, 7, 6, R.drawable.chong));//13
          newDeck.add(new Tile(Constants.bon, false, -1, 4, 8, 7, R.drawable.bon));//14
          newDeck.add(new Tile(Constants.bon, false, -1, 4, 8, 7, R.drawable.bon));//15
          newDeck.add(new Tile(Constants.foo, false, -1, 11, 9, 8, R.drawable.foo));//16
          newDeck.add(new Tile(Constants.foo, false, -1, 11, 9, 8, R.drawable.foo));//17
          newDeck.add(new Tile(Constants.ping, false, -1, 10, 10, 9, R.drawable.ping));//18
          newDeck.add(new Tile(Constants.ping, false, -1, 10, 10, 9, R.drawable.ping));//19
          newDeck.add(new Tile(Constants.tit, false, -1, 7, 11, 10, R.drawable.tit));//20
          newDeck.add(new Tile(Constants.tit, false, -1, 7, 11, 10, R.drawable.tit));//21
          newDeck.add(new Tile(Constants.look, false, -1, 6, 12, 11, R.drawable.look));//22
          newDeck.add(new Tile(Constants.look, false, -1, 6, 12, 11, R.drawable.look));//23
          newDeck.add(new Tile(Constants.chop_gow, true, 0, 9, 13, 12, R.drawable.chop_gow_1));//24
          newDeck.add(new Tile(Constants.chop_gow, true, 1, 9, 13, 12, R.drawable.chop_gow_2));//25
          newDeck.add(new Tile(Constants.chop_baht, true, 0, 8, 14, 13, R.drawable.chop_baht_1));//26
          newDeck.add(new Tile(Constants.chop_baht, true, 1, 8, 14, 13, R.drawable.chop_baht_2));//27
          newDeck.add(new Tile(Constants.chop_chit, true, 0, 7, 15, 14, R.drawable.chop_chit_1));//28
          newDeck.add(new Tile(Constants.chop_chit, true, 1, 7, 15, 14, R.drawable.chop_chit_2));//29
          newDeck.add(new Tile(Constants.chop_ng, true, 0, 5, 16, 15, R.drawable.chop_ng_1));//30
          newDeck.add(new Tile(Constants.chop_ng, true, 1, 5, 16, 15, R.drawable.chop_ng_2));//31
      }



      public static ArrayList getNewDeck(){
          return new Deck().newDeck;
      }


}
