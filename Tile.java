package tribalway.by.paigow.com.paigowtilesbyrob;

public class Tile {


 private String name;
 private boolean isMixedPair;
 private int mixedPairNumber;
 private int numberOfSpots;
 private int pairRank;
 private int individualRank;


    public Tile(String name, boolean isMixedPair, int mixedPairNumber, int numberOfSpots,int pairRank, int individualRank) {
        this.name = name;
        this.isMixedPair = isMixedPair;
        this.mixedPairNumber = mixedPairNumber;
        this.numberOfSpots = numberOfSpots;
        this.pairRank = pairRank;
        this.individualRank = individualRank;
    }



    public int getIndividualRank() {
        return individualRank;
    }

    public int getNumberOfSpots() {
        return numberOfSpots;
    }

    public String getName() {

        return name;
    }

    public int getMixedPairNumber() {

        return mixedPairNumber;
    }

    public boolean isMixedPair() {

        return isMixedPair;
    }
}
