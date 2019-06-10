package tribalway.by.paigow.com.paigowtilesbyrob;

import java.util.ArrayList;

public class Hand {


    String handName;

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
    public void setDealerTileValues(ArrayList<Tile> dealerTiles, Hand hand0, Hand hand1) {

        // my new method
        boolean handIsSet = true;
        int numberOfPairs = 0;
        int hand1Tile0dots;
        int hand1Tile1dots;
        int addedDotValue;


        ArrayList<Tile> tileSet = new ArrayList<Tile>();
        tileSet.add(hand0.tile0);
        tileSet.add(hand0.tile1);
        tileSet.add(hand1.tile0);
        tileSet.add(hand1.tile1);

        ArrayList<String> tileNames = new ArrayList<String>();
        tileNames.add(hand0.tile0.getName());
        tileNames.add(hand0.tile1.getName());
        tileNames.add(hand1.tile0.getName());
        tileNames.add(hand1.tile1.getName());

        for (int i = 0; i < tileNames.size() - 1; i++) {

            for (int j = i + 1; j < tileNames.size(); i++) {
                if (tileNames.get(i).equals(tileNames.get(j))) {
                    if (!hand0.isPair) {
                        hand0.tile0 = tileSet.get(i);
                        hand0.tile1 = tileSet.get(j);
                        hand0.isPair = true;
                        numberOfPairs++;
                        continue;
                    } else {

                        hand1.tile0 = tileSet.get(i);
                        hand1.tile1 = tileSet.get(j);
                        hand1.isPair = true;
                        numberOfPairs++;
                        handIsSet = true;
                        continue;
                    }
                }
            }


            //populates non pair hand
            if (numberOfPairs == 1) {

                String handName = hand0.getHandName();

                for (i = 0; i < dealerTiles.size(); i++) {

                    if (!dealerTiles.get(i).getName().equals(handName)) {
                        hand1.tile0 = (hand1.tile0 == null) ? dealerTiles.get(i) : hand1.tile0;
                        break;
                    }
                    if (!dealerTiles.get(i).getName().equals(handName)) {
                        hand1.tile1 = (hand0.tile1 == null) ? dealerTiles.get(i) : hand1.tile1;
                        break;
                    }

                }
            }


            // sets unsplitable pairs
            handIsSet = (hand0.tile0.getName().equals(Constants.ngor) || hand0.tile0.getName().equals(Constants.bon) || hand0.tile0.getName().equals(Constants.chop_ng) || hand0.tile0.getName().equals(Constants.chong) || hand0.tile0.getName().equals(Constants.mooy) || hand0.tile0.getName().equals(Constants.ping) || hand0.tile0.getName().equals(Constants.foo)) ? true : false;

        }


        //==splits geejoon
        hand1Tile0dots = hand1.tile0.getNumberOfSpots();
        hand1Tile1dots = hand1.tile1.getNumberOfSpots();

        if (hand1.getHandName().equals(Constants.gee_joon) && !handIsSet) {

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


        //---- spits teen
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


        //-------splits 99
        if (hand0.getHandName().equals(Constants.chop_gow) && !handIsSet) {
            if (hand1Tile0dots == 2 || hand1Tile0dots == 10 || hand1Tile0dots == 12 || hand1Tile1dots == 2 || hand1Tile1dots == 10 || hand1Tile1dots == 12) {

                Tile temp = hand0.tile0;
                hand0.tile0 = hand1.tile0;
                hand1.tile0 = temp;
                handIsSet = true;

            }
        }


        //=== splits 88

        if (hand0.tile0.getNumberOfSpots() == 8 && !handIsSet) {

            if (hand1Tile0dots == 2 || hand1Tile0dots == 9 || hand1Tile0dots == 10 || hand1Tile0dots == 11 || hand1Tile0dots == 12 || hand1Tile1dots == 2 || hand1Tile1dots == 9 || hand1Tile1dots == 10 || hand1Tile1dots == 11 || hand1Tile1dots == 12) {

                Tile temp = hand0.tile0;
                hand0.tile0 = hand1.tile0;
                hand1.tile0 = temp;
                handIsSet = true;

            }


            //---Splits 77

            if (hand0.tile0.getNumberOfSpots() == 7 && !handIsSet) {

                if (hand1Tile0dots == 2 || hand1Tile0dots == 10 || hand1Tile0dots == 11 || hand1Tile0dots == 12 || hand1Tile1dots == 2 || hand1Tile1dots == 10 || hand1Tile1dots == 11 || hand1Tile1dots == 12) {

                    Tile temp = hand0.tile0;
                    hand0.tile0 = hand1.tile0;
                    hand1.tile0 = temp;
                    handIsSet = true;

                }


            }//===== end of findWongGong


        }

    }
}