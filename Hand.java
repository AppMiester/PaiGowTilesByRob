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


    public void setDealerTileValues(ArrayList<Tile> dealerTiles, Hand hand0, Hand hand1) {

        Boolean unsplitablePair = false;

        String tileName = "";
        //--- checking for pairs
        for (int i = 0; i < dealerTiles.size() - 1; i++) {

            Boolean carryOn = true;

            tileName = dealerTiles.get(i).getName();
            for (int j = i + 1; j <= dealerTiles.size(); i++) {

                if (tileName.equals(dealerTiles.get(j).getName())) {
                    hand0.tile0 = dealerTiles.get(i);
                    hand0.tile0 = dealerTiles.get(j);
                    hand0.isPair = true;
                    hand0.handRank = hand0.tile0.getPairRank();
                    hand0.handName = hand0.tile0.getName();
                    carryOn = false;
                    break;
                }

            }

            if (!carryOn) {
                break;
            }
        }


        // ---- loads other hand1 if hand0 = pair
        if (hand0.isPair) {
            for (int i = 0; i < dealerTiles.size(); i++) {

                if (tileName.equals(dealerTiles.get(i).getName())) {
                    continue;
                }

                if (hand1.tile0 == null) {
                    hand1.tile0 = dealerTiles.get(i);
                }
                if (hand1.tile1 == null) {
                    hand1.tile1 = dealerTiles.get(i);
                }
            }
        }



        //---- populates non pair hands

        if(!hand0.isPair){
            hand0.tile0= dealerTiles.get(0);
            hand0.tile1 = dealerTiles.get(1);
            hand1.tile0 = dealerTiles.get(2);
            hand1.tile1 = dealerTiles.get(3);
        }

        //---- checks for hand1 pair

        if (hand1.tile0.getName().equals(hand1.tile1.getName())) {
            hand1.isPair = true;
            hand1.handName = hand1.tile1.getName();
            hand1.handRank = hand1.tile1.getPairRank();
        }


        //----- sets unsplitable pair
        if (hand0.isPair && (hand0.tile0.getName().equals(Constants.ngor) || hand0.tile0.getName().equals(Constants.bon) || hand0.tile0.getName().equals(Constants.chop_ng) || hand0.tile0.getName().equals(Constants.chong) || hand0.tile0.getName().equals(Constants.mooy) || hand0.tile0.getName().equals(Constants.ping) || hand0.tile0.getName().equals(Constants.foo))) {
            unsplitablePair = true;
        }






        // -- gee joon splits
        if (hand0.getHandName().equals(Constants.gee_joon) || hand1.getHandName().equals(Constants.gee_joon) && (!hand0.isPair || !hand1.isPair)) {
            Hand geejoon = (hand0.handName.equals(Constants.gee_joon))? hand0 : hand1;
            Hand notgeejoon = (hand0.handName.equals(Constants.gee_joon)) ? hand1 : hand0;

            if (notgeejoon.tile0.getNumberOfSpots() >= 4 && notgeejoon.tile0.getNumberOfSpots() <= 6 && notgeejoon.tile1.getNumberOfSpots() >= 4 && notgeejoon.tile0.getNumberOfSpots() <= 6) {

                Tile tempGeeJoonTile = geejoon.tile0;
                Tile tempNotGeeJoonTile = notgeejoon.tile0;

                geejoon.tile0 = tempNotGeeJoonTile;
                notgeejoon.tile0 = tempGeeJoonTile;

                geejoon.isPair = false;
                unsplitablePair = true;
                }


        }

        //--- check for wong

        if(hand0.tile0.getName().equals(Constants.teen) || hand0.tile0.getName().equals(Constants.day) || hand0.tile1.getName().equals(Constants.teen)|| hand0.tile1.getName().equals(Constants.day) || hand1.tile0.getName().equals(Constants.teen) || hand1.tile0.getName().equals(Constants.day) || hand1.tile1.getName().equals(Constants.teen)|| hand1.tile1.getName().equals(Constants.day)){
            boolean hasWongGong = false;

            if(!isPair) {

                int[] nonTeenDay = new int[4];
                nonTeenDay[0] = hand0.tile0.getNumberOfSpots();
                nonTeenDay[1] = hand0.tile1.getNumberOfSpots();
                nonTeenDay[2] = hand1.tile0.getNumberOfSpots();
                nonTeenDay[3] = hand1.tile1.getNumberOfSpots();

                for (int i = 0; i < nonTeenDay.length; i++) {
                    if (nonTeenDay[i] >= 8 && nonTeenDay[i] <= 9) {
                        hasWongGong = true;
                        break;
                    }
                }

                if(hasWongGong){
                    Tile teen = null;
                    Tile day = null;
                    Tile nine0 = null;  Tile eight0 = null; Tile eight1 = null; Tile non0 = null; Tile non1 = null;

                    switch(hand0.tile0.getNumberOfSpots()){

                        case 12:
                          teen =  hand0.tile0;
                            break;

                        case 2:
                           teen =  hand0.tile0;
                           break;

                        case 9:
                                nine0 = hand0.tile0;
                                break;

                        case 8:
                            if(eight0 == null){
                                eight0 = hand0.tile0;
                                break;
                            }else{
                                eight1 = hand0.tile0;
                                break;
                            }

                        default:
                            if(non0 == null){
                                non0 = hand0.tile0;
                                break;
                            }else{
                                non1 = hand0.tile0;
                                break;
                            }

                    }

                    switch(hand0.tile1.getNumberOfSpots()){

                        case 12:
                            teen =  hand0.tile1;
                            break;

                        case 2:
                            teen =  hand0.tile1;
                            break;

                        case 9:
                            nine0 = hand0.tile1;
                            break;

                        case 8:
                            if(eight0 == null){
                                eight0 = hand0.tile1;
                                break;
                            }else{
                                eight1 = hand0.tile1;
                                break;
                            }

                        default:
                            if(non0 == null){
                                non0 = hand0.tile1;
                                break;
                            }else{
                                non1 = hand0.tile1;
                                break;
                            }

                    }

                    switch(hand1.tile0.getNumberOfSpots()){

                        case 12:
                            teen =  hand1.tile0;
                            break;

                        case 2:
                            teen =  hand1.tile0;
                            break;

                        case 9:
                            nine0 = hand0.tile0;
                            break;

                        case 8:
                            if(eight0 == null){
                                eight0 = hand1.tile0;
                                break;
                            }else{
                                eight1 = hand1.tile0;
                                break;
                            }

                        default:
                            if(non0 == null){
                                non0 = hand1.tile0;
                                break;
                            }else{
                                non1 = hand1.tile0;
                                break;
                            }

                    }

                    switch(hand1.tile1.getNumberOfSpots()){

                        case 12:
                            teen =  hand1.tile1;
                            break;

                        case 2:
                            teen =  hand1.tile1;
                            break;

                        case 9:
                            nine0 = hand1.tile1;
                            break;

                        case 8:
                            if(eight0 == null){
                                eight0 = hand1.tile1;
                                break;
                            }else{
                                eight1 = hand1.tile1;
                                break;
                            }

                        default:
                            if(non0 == null){
                                non0 = hand1.tile1;
                                break;
                            }else{
                                non1 = hand1.tile1;
                                break;
                            }

                    }

                  /* ArrayList<Tile> findWong = new ArrayList <Tile>();
                    findWong.add(teen);
                    findWong.add(day);findWong.add(nine0);findWong.add(eight0);findWong.add(eight1);findWong.add(non0);findWong.add(non1);

                    for(int i = 0; i < findWong.size(); i++){
                       if
                    }*/

                  if(teen != null){
                      hand0.tile0= teen;
                      teen = null;
                  }
                  if(teen == null && !hand0.tile0.getName().equals(Constants.teen)){
                      hand0.tile0 = day;
                      day = null;
                  }
                  if(day != null){
                      hand1.tile0= day;
                      day = null;
                  }

                  if(!hand1.tile0.getName().equals(Constants.day)){
                      hand1.tile0= non0;
                      non0 = null;
                  }

                  if(nine0 != null){
                      hand0.tile1 = nine0;
                      nine0 = null;
                  }

                  if(nine0 == null && hand0.tile1.getNumberOfSpots() != 9){
                      hand0.tile1= eight0;
                      eight0=null;
                  }

                  if(eight1 != null ){
                      hand1.tile1 = eight1;
                      eight1 = null;

                  }

                  if(hand1.tile1.getNumberOfSpots()!= 8){
                      hand1.tile1 = non1;
                      non1 = null;
                  }





                }

            }




        }//===== end of findWongGong



        //--- splits day pair

        if(hand0.getHandName().equals(Constants.day)|| hand1.getHandName().equals(Constants.day) && (!hand0.isPair || !hand1.isPair)){

             Hand day = (hand0.getHandName().equals(Constants.day))?hand0:hand1;
             Hand notDay = (hand0.equals(Constants.day))? hand1:hand0;

             int notDayTile0 = notDay.tile0.getNumberOfSpots();
             int notDayTile1 = notDay.tile1.getNumberOfSpots();



        }





    }

}