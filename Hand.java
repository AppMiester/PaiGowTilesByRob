package tribalway.by.paigow.com.paigowtilesbyrob;

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

        // return (playerHand0.isHighHand())? playerHand0 :playerHand1;

    }

}

