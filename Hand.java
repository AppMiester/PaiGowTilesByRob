package tribalway.by.paigow.com.paigowtilesbyrob;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class Hand {


    String handName = "";

    int handRank = 100;
    int highTileIndividualRank;
    int numberOfPoints;
    Tile tile0 = null;
    Tile tile1 = null;
    boolean isHighHand = false;
    boolean isPair = false;
    boolean isWong = false;
    boolean isGong = false;
    boolean isHighNine = false;
    boolean jeeJoon = false;

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Integer> dots = new ArrayList<Integer>();


    public Tile getTile1() {
        return tile1;
    }

    public void setTile1(Tile tile1) {
        this.tile1 = tile1;
    }

    public Tile getTile0() {

        return tile0;
    }

    public void setTile0(Tile tile0) {
        this.tile0 = tile0;
    }

    public int getHandRank() {
        return handRank;
    }

    public void setHandRank(int handRank) {
        this.handRank = handRank;


    }

    public String getHandName() {
        return handName;
    }

    public void setName(String name) {
        this.handName = name;
    }

    public boolean isHighHand() {

        return isHighHand;
    }

    public void setHighHand(boolean highHand) {
        isHighHand = highHand;
    }


    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public int getHighTileIndividualRank() {
        return highTileIndividualRank;
    }


    public void setHandValues() {
        System.out.println("setaaa" + this.tile0.getName());
        System.out.println("setaaa" + this.tile1.getName());
        System.out.println("setaaa" + this.isGong + this.isHighNine + this.isPair + this.isWong);

        if (tile0.getName().equals(tile1.getName())) {
            isPair = true;
            handRank = tile0.getPairRank();
            handName = Constants.pair;
            System.out.println("setaaa pair ran");


        }


        if (tile0.getName().equals(Constants.teen) || tile1.getName().equals(Constants.teen)) {
            if (tile0.getName().equals(Constants.chop_gow) || tile0.getName().equals(Constants.chop_gow)) {


                isGong = true;
                handName = Constants.teen_gow_wong;
                handRank = 17;
                System.out.println("setaaa teen gow ran");

            }
        }

        if (tile0.getName().equals(Constants.day) || tile1.getName().equals(Constants.day)) {
            if (tile0.getName().equals(Constants.chop_gow) || tile0.getName().equals(Constants.chop_gow) || tile0.getName().equals(Constants.chop_baht) || tile1.getName().equals(Constants.chop_baht)) {

                isWong = true;
                handName = Constants.day_gow_wong;
                handRank = 18;
                System.out.println("setaaa day gow wong ran");

            }
        }


        if (tile0.getName().equals(Constants.teen) || tile1.getName().equals(Constants.teen)) {
            if (tile0.getName().equals(Constants.yun) || tile0.getName().equals(Constants.chop_baht) || tile1.getName().equals(Constants.yun) || tile1.getName().equals(Constants.chop_baht)) {

                isGong = true;
                handName = Constants.teen_gong;
                handRank = 19;
                System.out.println("setaaa teen gong ran");
            }
        }


        if (tile0.getName().equals(Constants.day) || tile1.getName().equals(Constants.day)) {
            if (tile0.getName().equals(Constants.yun) || tile0.getName().equals(Constants.chop_baht) || tile1.getName().equals(Constants.yun) || tile1.getName().equals(Constants.chop_baht)) {

                isGong = true;
                handName = Constants.day_gong;
                handRank = 20;
                System.out.println("setaaa day gong ran");
            }
        }

        if (tile0.getName().equals(Constants.teen) || tile1.getName().equals(Constants.teen)) {
            if (tile0.getName().equals(Constants.tit) || tile0.getName().equals(Constants.chop_chit) || tile1.getName().equals(Constants.tit) || tile1.getName().equals(Constants.chop_chit)) {


                handName = Constants.teen_high_nine;
                handRank = 21;
                isHighNine = true;
                System.out.println("setaaa teen high nine ran");
            }
        }

        if (tile0.getName().equals(Constants.day) || tile1.getName().equals(Constants.day)) {
            if (tile0.getName().equals(Constants.tit) || tile0.getName().equals(Constants.chop_chit) || tile1.getName().equals(Constants.tit) || tile1.getName().equals(Constants.chop_chit)) {


                handName = Constants.day_high_nine;
                handRank = 22;
                isHighNine = true;
                System.out.println("setaaa day high nine ran");
            }
        }


        if (!this.isPair) {


            if (tile0.getName().equals(Constants.gee_joon) || tile1.getName().equals(Constants.gee_joon)) {
                System.out.println("setaaa jee joon ran");
                jeeJoon = true;

                Tile geeJoon = (tile0.getName().equals(Constants.gee_joon) ? tile0 : tile1);
                Tile notJeeJoon = (tile0.getName().equals(geeJoon.getName()) ? tile1 : tile0);


                int valueThree = (geeJoon.getNumberOfSpots() + notJeeJoon.getNumberOfSpots()) % 10;
                int valueSix = (6 + notJeeJoon.getNumberOfSpots()) % 10;

                if (valueThree > valueSix) {
                    numberOfPoints = valueThree;
                    handRank = 100;
                    handName = "jee joon 3 ran";
                } else {
                    numberOfPoints = valueSix;
                    handRank = 100;
                    handName = "jee joon 6 ran";
                }

                highTileIndividualRank = notJeeJoon.getIndividualRank();
                handRank = 100;
                handName = "nothing";


            }
        }

        if (this.isPair == false && this.isGong == false && this.isWong == false && this.isHighNine == false && !jeeJoon) {
            System.out.println("setaaa points only ran");


            numberOfPoints = (tile0.getNumberOfSpots() + tile1.getNumberOfSpots()) % 10;
            highTileIndividualRank = (tile0.getIndividualRank() < tile1.getIndividualRank()) ? tile0.getIndividualRank() : tile1.getIndividualRank();

            handRank = 100;
            handName = "point only";
            System.out.println("setaa num of points " + numberOfPoints);


        }
        System.out.println("setaaa" + this.isGong + this.isHighNine + this.isPair + this.isWong);

    }

    public Hand() {
    }

    ;


    //------ finds the highest hand and sets isHighHand to true

    public static void findHighHand(Hand playerHand0, Hand playerHand1) {

        if (playerHand0.getHandRank() < playerHand1.getHandRank() && playerHand0.getHandRank() != 0) {
            playerHand0.setHighHand(true);
        }

        if (playerHand1.getHandRank() < playerHand0.getHandRank() && playerHand1.getHandRank() != 0) {
            playerHand1.setHighHand(true);
        }


        if (playerHand0.getHandRank() > 50 && playerHand1.getHandRank() > 50) {
            int p_h_0numberOfPoints = playerHand0.getNumberOfPoints();
            int p_h_1numberOfPoints = playerHand1.getNumberOfPoints();
            int p_h_0individualRank = playerHand0.getHighTileIndividualRank();
            int p_h_1individualRank = playerHand1.getHighTileIndividualRank();

            if (p_h_0numberOfPoints > p_h_1numberOfPoints) {
                playerHand0.setHighHand(true);
            }
            if (p_h_1numberOfPoints > p_h_0numberOfPoints) {
                playerHand1.setHighHand(true);
            }

            if (p_h_0numberOfPoints == p_h_1numberOfPoints) {
                if (p_h_0individualRank < p_h_1individualRank) {
                    playerHand0.setHighHand(true);
                }
                if (p_h_1individualRank < p_h_0individualRank) {
                    playerHand1.setHighHand(true);
                }
            }


        }


    }


    // sorts dealer tiles
    public String setDealerTileValues(ArrayList<Tile> dealerTiles, Hand hand0, Hand hand1) {



        // my new method
        boolean handIsSet = false;
        int numberOfPairs = 0;
        int hand1Tile0dots;
        int hand1Tile1dots;
        int addedDotValue;

        String bestSequence;

     Deck deck = new Deck();
     //   ArrayList<Tile> tileSet = dealerTiles;
        ArrayList<Tile> tileSet =  new ArrayList<Tile>();
        tileSet.add(deck.newDeck.get(8));
        tileSet.add(deck.newDeck.get(2));
        tileSet.add(deck.newDeck.get(7));
        tileSet.add(deck.newDeck.get(23));





        ArrayList<String> tileNames = new ArrayList<String>();
        tileNames.add(tileSet.get(0).getName());
        tileNames.add(tileSet.get(1).getName());
        tileNames.add(tileSet.get(2).getName());
        tileNames.add(tileSet.get(3).getName());

        String pair0name = null;
        String pair1name = null;

        Log.e("hunt", String.valueOf(tileNames.get(0)+" " +String.valueOf(tileNames.get(1))+" "+String.valueOf(tileNames.get(2))+" "+String.valueOf(tileNames.get(3))));

        for (int i = 0; i <= tileNames.size() - 2; i++) {


            // ----- gets pair names
            for (int j = i + 1; j < tileNames.size(); j++) {
                Log.e("hunt",tileNames.get(i) + "  *****   " + tileNames.get(j) );

                if (tileNames.get(i).equals(tileNames.get(j))) {
                    Log.e("hunt",tileNames.get(i) + " " + tileNames.get(j) );
                    if (numberOfPairs == 0) {
                        pair0name = tileNames.get(i);
                        numberOfPairs++;
                        continue;
                    } else {
                        pair1name = tileNames.get(i);
                    }
                }
            }

        }
            //------ puts tile pairs and non pairs in place
            Iterator<Tile> it1 = tileSet.iterator();
             Tile tempTile = null;

              switch(numberOfPairs){

                  case 0:
                      hand0.tile0 = tileSet.get(0); hand0.tile1 = tileSet.get(1); hand1.tile0 = tileSet.get(2); hand1.tile1 = tileSet.get(3);
                      break;

                  case 1:

                      while(it1.hasNext()){
                          tempTile = it1.next();

                          if(tempTile.getName().equals(pair0name)){
                              if(hand0.tile0 == null){
                                  hand0.tile0 = tempTile;
                                  hand0.setName(pair0name);
                                  hand0.isPair = true;
                                  continue;
                              }else{
                                  hand0.tile1 = tempTile;
                                  continue;
                              }

                          }else{
                              if(hand1.tile0 == null){
                                  hand1.tile0 = tempTile;
                                  continue;
                              }else{
                                  hand1.tile1 = tempTile;
                              }
                          }
                      }

                  case 2:
                      while(it1.hasNext()){
                          tempTile = it1.next();

                          if(tempTile.getName().equals(pair0name)){
                              if(hand0.tile0 == null){
                                  hand0.tile0 = tempTile;
                                  continue;
                              }else{
                                  hand0.tile1 = tempTile;
                                  continue;
                              }

                          }else{
                              if(hand1.tile0 == null){
                                  hand1.tile0 = tempTile;
                                  continue;
                              }else{
                                  hand1.tile1 = tempTile;
                                  handIsSet = true;
                              }
                          }
                      }
              }

              String  testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots())+ " " + String.valueOf(hand1.tile1.getNumberOfSpots());
              Log.e("hunt","after pair sort ran " + testValue);


            // sets unsplitable pairs ---- only runs if non pair hand is present
            handIsSet = (hand0.getHandName().equals(Constants.ngor) || hand0.getHandName().equals(Constants.bon) || hand0.getHandName().equals(Constants.chop_ng) || hand0.getHandName().equals(Constants.chong) || hand0.getHandName().equals(Constants.mooy) || hand0.getHandName().equals(Constants.ping) || hand0.getHandName().equals(Constants.foo)) ? true : false;

              Log.e("hunt",  "after unsplitable " + String.valueOf(handIsSet));


        //==splits geejoon --- only runs if non pair hand is present
        hand1Tile0dots = hand1.tile0.getNumberOfSpots();
        hand1Tile1dots = hand1.tile1.getNumberOfSpots();
        Log.e("hand1tileodot", String.valueOf(hand1Tile0dots));
        if (hand0.getHandName().equals(Constants.gee_joon) && !handIsSet) {

            String hand1spots = String.valueOf(hand1Tile0dots) + String.valueOf(hand1Tile1dots);

            int spots = Integer.valueOf(hand1spots);

            switch (spots) {

                case 64:
                case 65:
                case 66:
                case 45:
                case 46:
                case 54:
                case 56:
                    Tile temp = hand0.tile0;
                    hand0.tile0 = hand1.tile0;
                    hand1.tile0 = temp;
                    handIsSet = true;
                    break;
            }

        }

        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots())+ " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt","after gee joon split ran " + testValue);

        addedDotValue = (hand1Tile0dots + hand1Tile0dots) % 10;


        // ----- splits day tiles
        if (hand0.getHandName().equals(Constants.day) && !handIsSet) {

            String hand1spots = String.valueOf(hand1Tile0dots) + String.valueOf(hand1Tile1dots);

            int spots = Integer.valueOf(hand1spots);

            switch (spots) {

                case 46:
                case 64:
                case 911:
                case 119:
                    Tile temp = hand0.tile0;
                    hand0.tile0 = hand1.tile0;
                    hand1.tile0 = temp;
                    handIsSet = true;
                    break;
            }


        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots())+ " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt","after split day ran " + testValue);

        //---- splits teen
        if (hand0.getHandName().equals(Constants.teen) && !handIsSet) {

            String hand1spots = String.valueOf(hand1Tile0dots) + String.valueOf(hand1Tile1dots);

            int spots = Integer.valueOf(hand1spots);

            switch (spots) {

                case 46:
                case 64:
                case 911:
                case 119:
                    Tile temp = hand0.tile0;
                    hand0.tile0 = hand1.tile0;
                    hand1.tile0 = temp;
                    handIsSet = true;
                    break;
            }


        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots())+ " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt","split teen ran " + testValue);


        //-------splits 99
        if (hand0.getHandName().equals(Constants.chop_gow) && hand0.isPair && !handIsSet) {
            if (hand1Tile0dots == 2 || hand1Tile0dots == 10 || hand1Tile0dots == 12 && hand1Tile1dots == 2 || hand1Tile1dots == 10 || hand1Tile1dots == 12) {

                Tile temp = hand0.tile0;
                hand0.tile0 = hand1.tile0;
                hand1.tile0 = temp;
                handIsSet = true;

            }
        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots())+ " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt","after split99 ran " + testValue);


        //=== splits 88

        if (hand0.tile0.getNumberOfSpots() == 8 && hand0.isPair && !handIsSet) {

            if (hand1Tile0dots == 2 || hand1Tile0dots == 9 || hand1Tile0dots == 10 || hand1Tile0dots == 11 || hand1Tile0dots == 12 && hand1Tile1dots == 2 || hand1Tile1dots == 9 || hand1Tile1dots == 10 || hand1Tile1dots == 11 || hand1Tile1dots == 12) {

                Tile temp = hand0.tile0;
                hand0.tile0 = hand1.tile0;
                hand1.tile0 = temp;
                handIsSet = true;

            }
        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots())+ " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt","after split88ran " + testValue);

        //---Splits 77

        if (hand0.tile0.getNumberOfSpots() == 7 && hand0.isPair && !handIsSet) {

            if (hand1Tile0dots == 2 || hand1Tile0dots == 10 || hand1Tile0dots == 11 || hand1Tile0dots == 12 && hand1Tile1dots == 2 || hand1Tile1dots == 10 || hand1Tile1dots == 11 || hand1Tile1dots == 12) {

                Tile temp = hand0.tile0;
                hand0.tile0 = hand1.tile0;
                hand1.tile0 = temp;
                handIsSet = true;

            }


        }

        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots())+ " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt","after split77 ran " + testValue);





        //----- sets dots ArrayList
        dots.add(tileSet.get(0).getNumberOfSpots());
        dots.add(tileSet.get(1).getNumberOfSpots());
        dots.add(tileSet.get(2).getNumberOfSpots());
        dots.add(tileSet.get(3).getNumberOfSpots());



        //---checks high nine

        if (tileNames.contains((Constants.teen)) || tileNames.contains(Constants.day) && !handIsSet) {
            if (dots.contains(7)) {
                Iterator<Tile> it = tileSet.iterator();


                Tile teen = null;
                Tile day = null;
                Tile seven0 = null;
                Tile seven1 = null;
                Tile non0 = null;
                Tile non1 = null;

                while (it.hasNext()) {
                    Tile temp = it.next();

                    switch (temp.getNumberOfSpots()) {
                        case 12:
                            teen = temp;
                            continue;

                        case 2:
                            day = temp;
                            continue;

                        case 7:
                            if (seven0 == null) {
                                seven0 = temp;
                                continue;
                            } else {
                                seven1 = temp;
                                continue;
                            }

                        default:
                            if (non0 == null) {
                                non0 = temp;
                                continue;
                            } else {
                                non1 = temp;
                                continue;
                            }
                    }
                }


                    hand0.tile0 = (teen != null) ? teen : day;
                    hand0.tile1 = seven0;
                    hand1.tile0 = (day != hand0.tile0 && day!= null) ? day : non0;
                    hand1.tile1 = (seven1 != null) ? seven1 : non1;

                    isHighNine = true;






            }
        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots())+ " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt","after highNine ran " + testValue);


        //--- checks gong

        if (tileNames.contains((Constants.teen)) || tileNames.contains(Constants.day) && !handIsSet && !isHighNine) {
            if (dots.contains(8)) {
                Iterator<Tile> it = tileSet.iterator();

                Tile teen = null;
                Tile day = null;
                Tile eight0 = null;
                Tile eight1 = null;
                Tile non0 = null;
                Tile non1 = null;

                while (it.hasNext()) {
                    Tile temp = it.next();

                    switch (temp.getNumberOfSpots()) {
                        case 12:
                            teen = temp;
                            break;

                        case 2:
                            day = temp;
                            break;

                        case 8:
                            if (eight0 == null) {
                                eight0 = temp;
                                break;
                            } else {
                                eight1 = temp;
                                break;
                            }

                        default:
                            if (non0 == null) {
                                non0 = temp;
                                break;
                            } else {
                                non1 = temp;
                                break;
                            }
                    }

                    hand0.tile0 = (teen != null) ? teen : day;
                    hand0.tile1 = eight0;
                    hand1.tile0 = (day != hand0.tile0 && day!= null) ? day : non0;
                    hand1.tile1 = (eight1 != null) ? eight1 : non1;

                    isGong = true;


                }


            }
        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots())+ " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt","after gong ran " + testValue);


        //----- checks wong

        if (tileNames.contains((Constants.teen)) || tileNames.contains(Constants.day) && !handIsSet && !isHighNine && !isGong) {
            if (dots.contains(9)) {
                Iterator<Tile> it = tileSet.iterator();

                Tile teen = null;
                Tile day = null;
                Tile nine0 = null;
                Tile nine1 = null;
                Tile non0 = null;
                Tile non1 = null;

                while (it.hasNext()) {
                    Tile temp = it.next();

                    switch (temp.getNumberOfSpots()) {
                        case 12:
                            teen = temp;
                            break;

                        case 2:
                            day = temp;
                            break;

                        case 9:
                            if (nine0 == null) {
                                nine0 = temp;
                                break;
                            } else {
                                nine1 = temp;
                                break;
                            }

                        default:
                            if (non0 == null) {
                                non0 = temp;
                                break;
                            } else {
                                non1 = temp;
                                break;
                            }
                    }

                    hand0.tile0 = (teen != null) ? teen : day;
                    hand0.tile1 = nine0;
                    hand1.tile0 = (day != hand0.tile0 && day!= null) ? day : non0;
                    hand1.tile1 = (nine1 != null) ? nine1 : non1;

                    isWong = true;

                }


            }
        }


        // sets wong over gong  (exception a foxwoods)
        if (isGong && dots.contains(11) && dots.contains(9)) {
            Tile teenOrDay = null;
            Tile nine = null;
            Tile eight = null;
            Tile eleven = null;
            Tile temp = null;

            Iterator<Tile> it = tileSet.iterator();

            while (it.hasNext()) {
                temp = it.next();

                switch (temp.getNumberOfSpots()) {

                    case 2:
                    case 12:
                        teenOrDay = temp;
                        break;

                    case 9:
                        nine = temp;
                        break;

                    case 8:
                        eight = temp;
                        break;

                    case 11:
                        eleven = temp;
                        break;


                }

            }

            hand0.tile0 = teenOrDay;
            hand0.tile1 = nine;
            hand1.tile0 = eight;
            hand1.tile1 = eleven;

            isGong = false;
            isWong = true;
            handIsSet = true;
        }


        // sets wong over high nine (exception b foxwoods)
        if (isHighNine && dots.contains(11) && dots.contains(9)) {
            Tile teenOrDay = null;
            Tile nine = null;
            Tile seven = null;
            Tile eleven = null;
            Tile temp = null;

            Iterator<Tile> it = tileSet.iterator();

            while (it.hasNext()) {
                temp = it.next();

                switch (temp.getNumberOfSpots()) {

                    case 2:
                    case 12:
                        teenOrDay = temp;
                        break;

                    case 9:
                        nine = temp;
                        break;

                    case 7:
                        seven = temp;
                        break;

                    case 11:
                        eleven = temp;
                        break;


                }

            }

            hand0.tile0 = teenOrDay;
            hand0.tile1 = nine;
            hand1.tile0 = seven;
            hand1.tile1 = eleven;

            isHighNine = false;
            isWong = true;
            handIsSet = true;
        }


        //----- sets gong over high nine (foxwoods exception c 1st part)

        // sets wong over high nine (exception b foxwoods)
        if (isHighNine && dots.contains(4) && dots.contains(8)) {
            Tile teenOrDay = null;
            Tile eight = null;
            Tile seven = null;
            Tile four = null;
            Tile temp = null;

            Iterator<Tile> it = tileSet.iterator();

            while (it.hasNext()) {
                temp = it.next();

                switch (temp.getNumberOfSpots()) {

                    case 2:
                    case 12:
                        teenOrDay = temp;
                        break;

                    case 8:
                        eight = temp;
                        break;

                    case 7:
                        seven = temp;
                        break;

                    case 4:
                        four = temp;
                        break;


                }

            }

            hand0.tile0 = teenOrDay;
            hand0.tile1 = eight;
            hand1.tile0 = seven;
            hand1.tile1 = four;

            isHighNine = false;
            isGong = true;
            handIsSet = true;
        }


        //----- sets gong over high nine (foxwoods exception c 2nd part)

        if (isHighNine && dots.contains(5) && dots.contains(8) && !tileNames.contains(Constants.yun)) {
            Tile teenOrDay = null;
            Tile eight = null;
            Tile seven = null;
            Tile five = null;
            Tile temp = null;

            Iterator<Tile> it = tileSet.iterator();

            while (it.hasNext()) {
                temp = it.next();

                switch (temp.getNumberOfSpots()) {

                    case 2:
                    case 12:
                        teenOrDay = temp;
                        break;

                    case 8:
                        eight = temp;
                        break;

                    case 7:
                        seven = temp;
                        break;

                    case 5:
                        five = temp;
                        break;


                }

            }

            hand0.tile0 = teenOrDay;
            hand0.tile1 = eight;
            hand1.tile0 = seven;
            hand1.tile1 = five;

            isHighNine = false;
            isGong = true;
            handIsSet = true;
        }


        if (!handIsSet && !isPair && !isHighNine && !isWong && !isGong) {
            bestSequence = SequenceFinder.bestSequenceFinder(tileSet);
            System.out.println("bestSequence" + bestSequence);
            return bestSequence;
        }
        hand0.setHandValues();
        hand1.setHandValues();
        findHighHand(hand0, hand1);

        return "best sequence didnt run";
    }

}
