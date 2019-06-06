package tribalway.by.paigow.com.paigowtilesbyrob;

public class Tile {


 private String name;
 private boolean isMixedPair;
 private int mixedPairNumber;
 private int numberOfSpots;
 private int pairRank;
 private int individualRank;
 private int imgId;
 int viewId;



    public Tile(){};


    public Tile(String name, boolean isMixedPair, int mixedPairNumber, int numberOfSpots,int pairRank, int individualRank, int imgId) {
        this.name = name;
        this.isMixedPair = isMixedPair;
        this.mixedPairNumber = mixedPairNumber;
        this.numberOfSpots = numberOfSpots;
        this.pairRank = pairRank;
        this.individualRank = individualRank;
        this.imgId = imgId;
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

    public int getPairRank(){
        return pairRank;
    }

    public boolean isMixedPair() {

        return isMixedPair;
    }

    public String toString(){
        String name = this.getName();
        return name;
    }

    public int getImgId(){
        return imgId;
    }

    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }
}
