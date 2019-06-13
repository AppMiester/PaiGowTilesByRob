package tribalway.by.paigow.com.paigowtilesbyrob;

import java.util.ArrayList;
import java.util.Iterator;

public class SequenceFinder{

    boolean isHighNine = false;

    String sequenceID = null;
    int lowPoints = -1;
    int highPoints = -1;









    public SequenceFinder(String id){
        sequenceID = id;

    }

    public String getSequenceID() {
        return sequenceID;
    }



    public boolean isHighNine() {
        return isHighNine;
    }

    public void setHighNine(boolean highNine) {
        isHighNine = highNine;
    }

    public int getHighPoints() {
        return highPoints;
    }

    public void setHighPoints(int highPoints) {
        this.highPoints = highPoints;
    }

    public int getLowPoints() {
        return lowPoints;
    }

    public void setLowPoints(int bestLowPoints) {
        this.lowPoints = bestLowPoints;
    }


    static String bestSequenceFinder(ArrayList<Tile> tiles){
        Hand hand0 = new Hand();
        Hand hand1 = new Hand();
        Hand tempLow = null;
        Hand tempHigh = null;

        //----sequence 0123
        hand0.tile0 = tiles.get(0);
        hand0.tile1 = tiles.get(1);
        hand1.tile0 = tiles.get(2);
        hand1.tile1 = tiles.get(3);

        hand0.setHandValues();
        hand1.setHandValues();

        Hand.findHighHand(hand0,hand1);

        tempHigh = (hand0.isHighHand())?hand0:hand1;
        tempLow = (!hand0.isHighHand())?hand0:hand1;

        SequenceFinder sequence0123 = new SequenceFinder("0123");

        sequence0123.setHighPoints(tempHigh.numberOfPoints);
        sequence0123.setLowPoints(tempLow.numberOfPoints);

        if(sequence0123.getLowPoints()>3){
            sequence0123.setHighNine(true);
        }
        if(sequence0123.getLowPoints() == 3 && tempLow.getHighTileIndividualRank() >= 6){
            sequence0123.setHighNine(true);
        }



        //----sequence 1230
        hand0.tile0 = tiles.get(1);
        hand0.tile1 = tiles.get(2);
        hand1.tile0 = tiles.get(3);
        hand1.tile1 = tiles.get(0);

        hand0.setHandValues();
        hand1.setHandValues();

        Hand.findHighHand(hand0,hand1);

        tempHigh = (hand0.isHighHand())?hand0:hand1;
        tempLow = (!hand0.isHighHand())?hand0:hand1;

        SequenceFinder sequence1230 = new SequenceFinder("1230");

        sequence1230.setHighPoints(tempHigh.numberOfPoints);
        sequence1230.setLowPoints(tempLow.numberOfPoints);

        if(sequence1230.getLowPoints()>3){
            sequence1230.setHighNine(true);
        }
        if(sequence1230.getLowPoints() == 3 && tempLow.getHighTileIndividualRank() >= 6){
            sequence1230.setHighNine(true);
        }



        //----sequence 2310
        hand0.tile0 = tiles.get(2);
        hand0.tile1 = tiles.get(3);
        hand1.tile0 = tiles.get(0);
        hand1.tile1 = tiles.get(1);

        hand0.setHandValues();
        hand1.setHandValues();

        Hand.findHighHand(hand0,hand1);

        tempHigh = (hand0.isHighHand())?hand0:hand1;
        tempLow = (!hand0.isHighHand())?hand0:hand1;

        SequenceFinder sequence2301 = new SequenceFinder("2301");

        sequence2301.setHighPoints(tempHigh.numberOfPoints);
        sequence2301.setLowPoints(tempLow.numberOfPoints);

        if(sequence2301.getLowPoints()>3){
            sequence2301.setHighNine(true);
        }
        if(sequence2301.getLowPoints() == 3 && tempLow.getHighTileIndividualRank() >= 6){
            sequence2301.setHighNine(true);
        }

        String bestSequence = findBestSequence(sequence0123,sequence1230,sequence2301);






        return bestSequence;
    }








     //------------ finds best sequence and returns id
  public static String findBestSequence(SequenceFinder s1, SequenceFinder s2, SequenceFinder s3 ){
        boolean highNinePresent= false;



        ArrayList <Boolean> hasNine = new ArrayList<Boolean>();
        hasNine.add(s1.isHighNine());hasNine.add(s2.isHighNine());hasNine.add(s2.isHighNine());
         highNinePresent = hasNine.contains(true);

        ArrayList<SequenceFinder> sequenceList = new ArrayList<SequenceFinder>();
        sequenceList.add(s1);sequenceList.add(s2);sequenceList.add(s3);

        SequenceFinder bestSequence = sequenceList.get(0);
        SequenceFinder tempSequence = null;

        Iterator<SequenceFinder> it = sequenceList.iterator();

        if(highNinePresent){
            System.out.println("best high nine ran");

            while(it.hasNext()){
                tempSequence = it.next();

                if(tempSequence.isHighNine() && tempSequence.getHighPoints() > bestSequence.getHighPoints()){
                    bestSequence = tempSequence;
                }
            }
           return bestSequence.getSequenceID();
        } else{
            tempSequence = it.next();

            System.out.println("best else ran");
            if(tempSequence.getHighPoints() > bestSequence.getHighPoints()){
                bestSequence = tempSequence;
            }
        }

        return bestSequence.getSequenceID();
    }
}






