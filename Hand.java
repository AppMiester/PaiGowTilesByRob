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
        Log.e("set",this.tile0.getName() + " " + String.valueOf(this.tile0.getNumberOfSpots()));
        Log.e("set",this.tile1.getName() + " " + String.valueOf(this.tile1.getNumberOfSpots()));
        Log.e("set",  String.valueOf(this.isGong) + " " + String.valueOf(this.isHighNine) +  "" + String.valueOf(this.isPair) + " " + String.valueOf(this.isWong));

        if (tile0.getName().equals(tile1.getName())) {
            isPair = true;
            handRank = tile0.getPairRank();
            handName = Constants.pair;



        }

         Log.e("set", "names = " + String.valueOf(this.tile0.getName().equals(Constants.teen)) + " "+ String.valueOf(this.tile1.getName().equals(Constants.chop_gow)));
        if (this.tile0.getName().equals(Constants.teen) || this.tile1.getName().equals(Constants.teen)) {
            Log.e("set", "line 100" + String.valueOf(this.getHandRank()));
            if (this.tile0.getName().equals(Constants.chop_gow) || this.tile1.getName().equals(Constants.chop_gow)) {


                isWong = true;
                handName = Constants.teen_gow_wong;
                handRank = 17;

                Log.e("set", "line 106" + String.valueOf(this.getHandRank()));

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
        Log.e("set", String.valueOf(this.getHandRank()));

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
        Log.e("set", String.valueOf(this.getHandRank()));

        if (this.isPair == false && this.isGong == false && this.isWong == false && this.isHighNine == false && !jeeJoon) {
            System.out.println("setaaa points only ran");


            numberOfPoints = (tile0.getNumberOfSpots() + tile1.getNumberOfSpots()) % 10;
            highTileIndividualRank = (tile0.getIndividualRank() < tile1.getIndividualRank()) ? tile0.getIndividualRank() : tile1.getIndividualRank();

            handRank = 100;
            handName = "point only";
            System.out.println("setaa num of points " + numberOfPoints);


        }
        Log.e("set", String.valueOf(this.getHandRank()));

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
        boolean Pair = false;
        boolean Wong = false;
        boolean Gong = false;
        boolean HighNine = false;
        int numberOfPairs = 0;
        int hand1Tile0dots;
        int hand1Tile1dots;
        int addedDotValue;

        String bestSequence;

        Deck deck = new Deck();
        //   ArrayList<Tile> tileSet = dealerTiles;

        // 0 36,1 36, 2 12, 3 12, 4 2, 5 2, 6 8, 7 8, 8 4, 9 4, 10 10
        // 11 10, 12 6 , 13 6, 14 4, 15 4, 16 11, 17 11, 18 10, 19 10, 20 7 , 21 7
        // 22 6, 23 6, 24 9, 25 9, 26 8, 27 8, 28 7, 29 7, 30 5, 31 5
        ArrayList<Tile> tileSet = new ArrayList<Tile>();
        tileSet.add(deck.newDeck.get(11));//mooy
        tileSet.add(deck.newDeck.get(27));//chop baht
        tileSet.add(deck.newDeck.get(18));//ping
        tileSet.add(deck.newDeck.get(13));//chong


        ArrayList<String> tileNames = new ArrayList<String>();
        tileNames.add(tileSet.get(0).getName());
        tileNames.add(tileSet.get(1).getName());
        tileNames.add(tileSet.get(2).getName());
        tileNames.add(tileSet.get(3).getName());

        String pair0name = null;
        String pair1name = null;

        Log.e("hunt", String.valueOf(tileNames.get(0) + " " + String.valueOf(tileNames.get(1)) + " " + String.valueOf(tileNames.get(2)) + " " + String.valueOf(tileNames.get(3))));

        for (int i = 0; i <= tileNames.size() - 2; i++) {


            // ----- gets pair names
            for (int j = i + 1; j < tileNames.size(); j++) {
                Log.e("hunt", tileNames.get(i) + "  *****   " + tileNames.get(j));

                if (tileNames.get(i).equals(tileNames.get(j))) {
                    Log.e("hunt", tileNames.get(i) + " " + tileNames.get(j));
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

        switch (numberOfPairs) {

            case 0:
                hand0.tile0 = tileSet.get(0);
                hand0.tile1 = tileSet.get(1);
                hand1.tile0 = tileSet.get(2);
                hand1.tile1 = tileSet.get(3);
                break;

            case 1:

                while (it1.hasNext()) {
                    tempTile = it1.next();

                    if (tempTile.getName().equals(pair0name)) {
                        if (hand0.tile0 == null) {
                            hand0.tile0 = tempTile;
                            hand0.setName(pair0name);
                            hand0.isPair = true;
                            continue;
                        } else {
                            hand0.tile1 = tempTile;
                            continue;
                        }

                    } else {
                        if (hand1.tile0 == null) {
                            hand1.tile0 = tempTile;
                            continue;
                        } else {
                            hand1.tile1 = tempTile;
                        }
                    }
                }

            case 2:
                while (it1.hasNext()) {
                    tempTile = it1.next();

                    if (tempTile.getName().equals(pair0name)) {
                        if (hand0.tile0 == null) {
                            hand0.tile0 = tempTile;
                            continue;
                        } else {
                            hand0.tile1 = tempTile;
                            continue;
                        }

                    } else {
                        if (hand1.tile0 == null) {
                            hand1.tile0 = tempTile;
                            continue;
                        } else {
                            hand1.tile1 = tempTile;
                            handIsSet = true;
                        }
                    }
                }
        }

        String testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after pair sort ran " + testValue);


        // sets unsplitable pairs ---- only runs if non pair hand is present
        handIsSet = (hand0.getHandName().equals(Constants.ngor) || hand0.getHandName().equals(Constants.bon) || hand0.getHandName().equals(Constants.chop_ng) || hand0.getHandName().equals(Constants.chong) || hand0.getHandName().equals(Constants.mooy) || hand0.getHandName().equals(Constants.ping) || hand0.getHandName().equals(Constants.foo)) ? true : false;

        Log.e("hunt", "after unsplitable " + String.valueOf(handIsSet));


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

        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after gee joon split ran " + testValue);

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
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after split day ran " + testValue);

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
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "split teen ran " + testValue);


        //-------splits 99
        if (hand0.getHandName().equals(Constants.chop_gow) && hand0.isPair && !handIsSet) {
            if (hand1Tile0dots == 2 || hand1Tile0dots == 10 || hand1Tile0dots == 12 && hand1Tile1dots == 2 || hand1Tile1dots == 10 || hand1Tile1dots == 12) {

                Tile temp = hand0.tile0;
                hand0.tile0 = hand1.tile0;
                hand1.tile0 = temp;
                handIsSet = true;

            }
        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after split99 ran " + testValue);


        //=== splits 88

        if (hand0.tile0.getNumberOfSpots() == 8 && hand0.isPair && !handIsSet) {

            if (hand1Tile0dots == 2 || hand1Tile0dots == 9 || hand1Tile0dots == 10 || hand1Tile0dots == 11 || hand1Tile0dots == 12 && hand1Tile1dots == 2 || hand1Tile1dots == 9 || hand1Tile1dots == 10 || hand1Tile1dots == 11 || hand1Tile1dots == 12) {

                Tile temp = hand0.tile0;
                hand0.tile0 = hand1.tile0;
                hand1.tile0 = temp;
                handIsSet = true;

            }
        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after split88ran " + testValue);

        //---Splits 77

        if (hand0.tile0.getNumberOfSpots() == 7 && hand0.isPair && !handIsSet) {

            if (hand1Tile0dots == 2 || hand1Tile0dots == 10 || hand1Tile0dots == 11 || hand1Tile0dots == 12 && hand1Tile1dots == 2 || hand1Tile1dots == 10 || hand1Tile1dots == 11 || hand1Tile1dots == 12) {

                Tile temp = hand0.tile0;
                hand0.tile0 = hand1.tile0;
                hand1.tile0 = temp;
                handIsSet = true;

            }


        }

        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after split77 ran " + testValue);


        //----- sets dots ArrayList
        dots.add(tileSet.get(0).getNumberOfSpots());
        dots.add(tileSet.get(1).getNumberOfSpots());
        dots.add(tileSet.get(2).getNumberOfSpots());
        dots.add(tileSet.get(3).getNumberOfSpots());


        //---checks high nine
        if (tileNames.contains((Constants.teen)) || tileNames.contains(Constants.day)) {
            if (dots.contains(7) && !handIsSet) {
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
                hand1.tile0 = (day != hand0.tile0 && day != null) ? day : non0;
                hand1.tile1 = (seven1 != null) ? seven1 : non1;

                HighNine = true;


            }
        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after highNine ran " + testValue);


        //--- checks gong

        if (tileNames.contains((Constants.teen)) || tileNames.contains(Constants.day)) {
            if (dots.contains(8) && !handIsSet && !HighNine) {
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
                }

                hand0.tile0 = (teen != null) ? teen : day;
                hand0.tile1 = eight0;
                hand1.tile0 = (day != hand0.tile0 && day != null) ? day : non0;
                hand1.tile1 = (eight1 != null) ? eight1 : non1;

                Gong = true;
                Log.e("hunt", String.valueOf(Gong) + " #1");


            }
        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after gong ran " + testValue);


        //----- checks wong

        if (tileNames.contains((Constants.teen)) || tileNames.contains(Constants.day)) {
            Log.e("hunt", String.valueOf(Gong));
            if (dots.contains(9) && !handIsSet && !HighNine && !Gong) {
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
                }
                hand0.tile0 = (teen != null) ? teen : day;
                hand0.tile1 = nine0;
                hand1.tile0 = (day != hand0.tile0 && day != null) ? day : non0;
                hand1.tile1 = (nine1 != null) ? nine1 : non1;

                Wong = true;


            }
        }

        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after wong ran " + testValue);


        // sets wong over gong  (exception a foxwoods)
        if (Gong && dots.contains(11) && dots.contains(9)) {
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

            Gong = false;
            Wong = true;
            handIsSet = true;
        }
        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "sets wong over gong " + testValue);


        // sets wong over high nine (exception b foxwoods)
        if (HighNine && dots.contains(11) && dots.contains(9)) {
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

            HighNine = false;
            Wong = true;
            handIsSet = true;
        }


        //----- sets gong over high nine (foxwoods exception c 1st part)
        if (HighNine && dots.contains(4) && dots.contains(8)) {
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

            HighNine = false;
            Gong = true;
            handIsSet = true;
        }


        //----- sets gong over high nine (foxwoods exception c 2nd part)

        if (HighNine && dots.contains(5) && dots.contains(8) && !tileNames.contains(Constants.yun)) {
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

            HighNine = false;
            Gong = true;
            handIsSet = true;
        }

        testValue = String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()) + " " + String.valueOf(hand1.tile0.getNumberOfSpots()) + " " + String.valueOf(hand1.tile1.getNumberOfSpots());
        Log.e("hunt", "after last ran " + testValue);

        // non good hands
        if (!handIsSet && !Pair && !HighNine && !Wong && !Gong) {
            bestSequence = SequenceFinder.bestSequenceFinder(tileSet);
            Log.e("bestSequence", bestSequence);

            hand0.tile0 = tileSet.get(Integer.valueOf(Integer.parseInt(String.valueOf(bestSequence.charAt(0)))));
            hand0.tile1 = tileSet.get(Integer.valueOf(Integer.parseInt(String.valueOf(bestSequence.charAt(1)))));
            hand1.tile0 = tileSet.get(Integer.valueOf(Integer.parseInt(String.valueOf(bestSequence.charAt(2)))));
            hand1.tile1 = tileSet.get(Integer.valueOf(Integer.parseInt(String.valueOf(bestSequence.charAt(3)))));

            hand0.setHandValues();
            hand1.setHandValues();


            // EXCEPTION  A checks for 9 / 8 total

            // first hand
            if (hand0.getNumberOfPoints() + hand1.getNumberOfPoints() == 17) {

                if (tileNames.contains(Constants.mooy) && tileNames.contains(Constants.chop_gow) && tileNames.contains(Constants.chop_baht) && tileNames.contains(Constants.ping)) {

                    Tile temp = null;

                    Iterator<Tile> it = tileSet.iterator();

                    while (it.hasNext()) {

                        temp = it.next();
                        String name = temp.getName();

                        if (name.equals(Constants.mooy)) {
                            hand0.tile0 = temp;
                            continue;
                        }
                        if (name.equals(Constants.chop_gow)) {
                            hand0.tile1 = temp;
                            continue;
                        }
                        if (name.equals(Constants.ping)) {
                            hand1.tile0 = temp;
                            continue;
                        }
                        if (name.equals(Constants.chop_baht)) {
                            hand1.tile1 = temp;
                        }
                    }
                    handIsSet = true;
                }


                // second hand
                if (tileNames.contains(Constants.foo) && tileNames.contains(Constants.yun) && tileNames.contains(Constants.chop_baht) && tileNames.contains(Constants.ping)) {

                    Tile temp = null;

                    Iterator<Tile> it = tileSet.iterator();

                    while (it.hasNext()) {

                        temp = it.next();
                        String name = temp.getName();

                        if (name.equals(Constants.foo)) {
                            hand0.tile0 = temp;
                            continue;
                        }
                        if (name.equals(Constants.yun)) {
                            hand0.tile1 = temp;
                            continue;
                        }
                        if (name.equals(Constants.ping)) {
                            hand1.tile0 = temp;
                            continue;
                        }
                        if (name.equals(Constants.chop_baht)) {
                            hand1.tile1 = temp;
                        }
                    }
                    handIsSet = true;
                }


                // third
                if (tileNames.contains(Constants.mooy) && tileNames.contains(Constants.yun) && tileNames.contains(Constants.chop_baht) && tileNames.contains(Constants.foo)) {

                    Tile temp = null;

                    Iterator<Tile> it = tileSet.iterator();

                    while (it.hasNext()) {

                        temp = it.next();
                        String name = temp.getName();

                        if (name.equals(Constants.foo)) {
                            hand0.tile0 = temp;
                            continue;
                        }
                        if (name.equals(Constants.yun)) {
                            hand0.tile1 = temp;
                            continue;
                        }
                        if (name.equals(Constants.mooy)) {
                            hand1.tile0 = temp;
                            continue;
                        }
                        if (name.equals(Constants.chop_baht)) {
                            hand1.tile1 = temp;
                        }
                    }
                    handIsSet = true;
                }


            }

        }

        testValue = String.valueOf(hand0.tile0.getName()) + " " + String.valueOf(hand0.tile1.getName()) + " " + String.valueOf(hand1.tile0.getName()) + " " + String.valueOf(hand1.tile1.getName());

        Log.e("hunt", "first exception ran" + testValue);


        //EXCEPTION B
        // first hand
        if (hand0.getNumberOfPoints() + hand1.getNumberOfPoints() == 15) {

            if (tileNames.contains(Constants.teen) && tileNames.contains(Constants.day) && tileNames.contains(Constants.gee_joon) && tileNames.contains(Constants.chop_ng)) {

                Tile temp = null;

                Iterator<Tile> it = tileSet.iterator();

                while (it.hasNext()) {

                    temp = it.next();
                    String name = temp.getName();

                    if (name.equals(Constants.teen)) {
                        hand0.tile0 = temp;
                        continue;
                    }
                    if (name.equals(Constants.gee_joon)) {
                        hand0.tile1 = temp;
                        continue;
                    }
                    if (name.equals(Constants.day)) {
                        hand1.tile0 = temp;
                        continue;
                    }
                    if (name.equals(Constants.chop_ng)) {
                        hand1.tile1 = temp;
                    }
                }
                handIsSet = true;
            }


            // second hand no need of third
            if (tileNames.contains(Constants.teen) && tileNames.contains(Constants.day) && tileNames.contains(Constants.chop_ng) && tileNames.contains(Constants.chong)) {

                Tile temp = null;

                Iterator<Tile> it = tileSet.iterator();

                while (it.hasNext()) {

                    temp = it.next();
                    String name = temp.getName();

                    if (name.equals(Constants.teen)) {
                        hand0.tile0 = temp;
                        continue;
                    }
                    if (name.equals(Constants.chong)) {
                        hand0.tile1 = temp;
                        continue;
                    }
                    if (name.equals(Constants.day)) {
                        hand1.tile0 = temp;
                        continue;
                    }
                    if (name.equals(Constants.chop_ng)) {
                        hand1.tile1 = temp;
                    }
                }
                handIsSet = true;
            }

        }


        //Exception c  only one set of conditions for both


            if (tileNames.contains(Constants.yun) && tileNames.contains(Constants.chop_baht) && tileNames.contains(Constants.ngor)) {

                if (tileNames.contains(Constants.chop_chit) || tileNames.contains(Constants.tit)) {

                    Tile temp = null;

                    Iterator<Tile> it = tileSet.iterator();

                    while (it.hasNext()) {

                        temp = it.next();
                        String name = temp.getName();

                        if (name.equals(Constants.yun)) {
                            hand0.tile0 = temp;
                            continue;
                        }
                        if (name.equals(Constants.tit)|| name.equals(Constants.chop_chit)) {
                            hand0.tile1 = temp;
                            continue;
                        }
                        if (name.equals(Constants.chop_baht)) {
                            hand1.tile0 = temp;
                            continue;
                        }
                        if (name.equals(Constants.ngor)) {
                            hand1.tile1 = temp;
                        }
                    }
                    handIsSet = true;
                }
            }



         //   exception d 1 set of conditions for both
        if (tileNames.contains(Constants.mooy) && tileNames.contains(Constants.chong) && tileNames.contains(Constants.ping)) {

            if (tileNames.contains(Constants.chop_chit) || tileNames.contains(Constants.tit)) {

                Tile temp = null;

                Iterator<Tile> it = tileSet.iterator();

                while (it.hasNext()) {

                    temp = it.next();
                    String name = temp.getName();

                    if (name.equals(Constants.mooy)) {
                        hand0.tile0 = temp;
                        continue;
                    }
                    if (name.equals(Constants.tit)|| name.equals(Constants.chop_chit)) {
                        hand0.tile1 = temp;
                        continue;
                    }
                    if (name.equals(Constants.chong)) {
                        hand1.tile0 = temp;
                        continue;
                    }
                    if (name.equals(Constants.ping)) {
                        hand1.tile1 = temp;
                    }
                }
                handIsSet = true;
            }
        }













        hand0.setHandValues();
        hand1.setHandValues();
        findHighHand(hand0, hand1);


        testValue = String.valueOf(hand0.tile0.getName()) + " " + String.valueOf(hand0.tile1.getName()) + " " + String.valueOf(hand1.tile0.getName()) + " " + String.valueOf(hand1.tile1.getName());

        Log.e("hunt ", testValue );













        return ("");


    }
}
