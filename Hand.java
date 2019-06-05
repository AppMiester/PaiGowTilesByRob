package tribalway.by.paigow.com.paigowtilesbyrob;

public class Hand {


    String handName;

    int handRank;
    int numberOfPoints;
    Tile tile0;
    Tile tile1;
    boolean isHighHand;
    boolean isPair;
    boolean isWong;
    boolean isGong;
    boolean isHighNine;


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


    public void setHandValues() {

        if (tile0.getName().equals(tile1.getName())) {
            isPair = true;
            handRank = tile0.getPairRank();

        }


        if ((tile0.getName().equals(Constants.teen)) || (tile1.getName().equals(Constants.teen)) && (tile0.getName().equals(Constants.chop_gow) || tile0.getName().equals(Constants.chop_gow) || tile0.getName().equals(Constants.chop_baht) || tile1.getName().equals(Constants.chop_baht))) {

            isWong = true;
            handName = Constants.teen_gow_wong;
            handRank = 17;

        }

        if ((tile0.getName().equals(Constants.day)) || (tile1.getName().equals(Constants.day)) && (tile0.getName().equals(Constants.chop_gow) || tile0.getName().equals(Constants.chop_gow) || tile0.getName().equals(Constants.chop_baht) || tile1.getName().equals(Constants.chop_baht))) {

            isWong = true;
            handName = Constants.day_gow_wong;
            handRank = 18;

        }


        if ((tile0.getName().equals(Constants.teen)) || (tile1.getName().equals(Constants.teen)) && (tile0.getName().equals(Constants.yun) || tile0.getName().equals(Constants.chop_baht) || tile1.getName().equals(Constants.yun) || tile1.getName().equals(Constants.chop_baht))) {

            isGong = true;
            handName = Constants.teen_gong;
            handRank = 19;
        }


        if ((tile0.getName().equals(Constants.day)) || (tile1.getName().equals(Constants.day)) && (tile0.getName().equals(Constants.yun) || tile0.getName().equals(Constants.chop_baht) || tile1.getName().equals(Constants.yun) || tile1.getName().equals(Constants.chop_baht))) {

            isGong = true;
            handName = Constants.day_gong;
            handRank = 20;
        }


        if ((tile0.getName().equals(Constants.teen)) || (tile1.getName().equals(Constants.teen)) && (tile0.getName().equals(Constants.tit) || tile0.getName().equals(Constants.chop_chit) || tile1.getName().equals(Constants.tit) || tile1.getName().equals(Constants.chop_chit))) {


            handName = Constants.teen_high_nine;
            handRank = 21;
            isHighNine = true;
        }

        if ((tile0.getName().equals(Constants.day)) || (tile1.getName().equals(Constants.day)) && (tile0.getName().equals(Constants.tit) || tile0.getName().equals(Constants.chop_chit) || tile1.getName().equals(Constants.tit) || tile1.getName().equals(Constants.chop_chit))) {


            handName = Constants.day_high_nine;
            handRank = 22;
            isHighNine = true;
        }


        if( tile0.getName().equals(Constants.gee_joon) || tile1.getName().equals(Constants.gee_joon) && !isPair){

            Tile geeJoon = (tile0.getName().equals(Constants.gee_joon)? tile0 :tile1);
            Tile notJeeJoon = (tile0.getName().equals(geeJoon.getName())? tile1 :tile0);


            int valueThree = geeJoon.getNumberOfSpots() + notJeeJoon.getNumberOfSpots() % 10;
            int valueSix = (6 + notJeeJoon.getNumberOfSpots()) % 10;

            if( valueThree > valueSix ){
                numberOfPoints = valueThree;
                } else{
                  numberOfPoints = valueSix;
            }

            handRank = notJeeJoon.getIndividualRank();


        }






    }


}
