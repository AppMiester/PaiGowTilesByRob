package tribalway.by.paigow.com.paigowtilesbyrob;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class SequenceFinder {

    boolean isHighThree = false;

    String sequenceID = null;
    int lowPoints = -1;
    int highPoints = -1;


    public SequenceFinder(String id) {
        sequenceID = id;

    }

    public String getSequenceID() {
        return sequenceID;
    }


    public boolean isHighThree() {
        return isHighThree;
    }

    public void setHighThree(boolean highThree) {
        isHighThree = highThree;
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

    static String seq = "";

    static String bestSequenceFinder(ArrayList<Tile> tiles) {
        Hand hand0 = new Hand();
        Hand hand1 = new Hand();
        Hand tempLow = null;
        Hand tempHigh = null;

        //----sequence 0123
        hand0.tile0 = tiles.get(0);
        hand0.tile1 = tiles.get(1);
        hand1.tile0 = tiles.get(2);
        hand1.tile1 = tiles.get(3);

        Log.e("sequence", "0123" + String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()));
        Log.e("sequence", "0123" + String.valueOf(hand0.tile0.getNumberOfSpots()) + " " + String.valueOf(hand0.tile1.getNumberOfSpots()));

        hand0.setHandValues();
        hand1.setHandValues();

        Hand.findHighHand(hand0, hand1);

        tempHigh = (hand0.isHighHand()) ? hand0 : hand1;
        tempLow = (!hand0.isHighHand()) ? hand0 : hand1;

        SequenceFinder sequence0123 = new SequenceFinder("0123");

        sequence0123.setHighPoints(tempHigh.numberOfPoints);
        sequence0123.setLowPoints(tempLow.numberOfPoints);

        seq = sequence0123.getSequenceID() + " " + sequence0123.getHighPoints() + " " + sequence0123.getLowPoints();
        Log.e("sequence", "0123 high and low" + seq);

        if (sequence0123.getLowPoints() > 3) {
            sequence0123.setHighThree(true);
        }
        if (sequence0123.getLowPoints() == 3 && tempLow.getHighTileIndividualRank() >= 6) {
            sequence0123.setHighThree(true);
        }


        //----sequence 1230
        hand0.tile0 = tiles.get(1);
        hand0.tile1 = tiles.get(2);
        hand1.tile0 = tiles.get(3);
        hand1.tile1 = tiles.get(0);

        hand0.setHandValues();
        hand1.setHandValues();

        Hand.findHighHand(hand0, hand1);

        tempHigh = (hand0.isHighHand()) ? hand0 : hand1;
        tempLow = (!hand0.isHighHand()) ? hand0 : hand1;

        SequenceFinder sequence1230 = new SequenceFinder("1230");

        sequence1230.setHighPoints(tempHigh.numberOfPoints);
        sequence1230.setLowPoints(tempLow.numberOfPoints);
        seq = sequence1230.getSequenceID() + " " + sequence1230.getHighPoints() + " " + sequence1230.getLowPoints();
        Log.e("sequence", "1230 high low" + seq);

        if (sequence1230.getLowPoints() > 3) {
            sequence1230.setHighThree(true);
        }
        if (sequence1230.getLowPoints() == 3 && tempLow.getHighTileIndividualRank() >= 6) {
            sequence1230.setHighThree(true);
        }


        //----sequence 0213
        hand0.tile0 = tiles.get(0);
        hand0.tile1 = tiles.get(2);
        hand1.tile0 = tiles.get(1);
        hand1.tile1 = tiles.get(3);

        hand0.setHandValues();
        hand1.setHandValues();

        Hand.findHighHand(hand0, hand1);

        tempHigh = (hand0.isHighHand()) ? hand0 : hand1;
        tempLow = (!hand0.isHighHand()) ? hand0 : hand1;

        SequenceFinder sequence0213 = new SequenceFinder("0213");

        sequence0213.setHighPoints(tempHigh.numberOfPoints);
        sequence0213.setLowPoints(tempLow.numberOfPoints);

        seq = sequence0213.getSequenceID() + " " + sequence0213.getHighPoints() + " " + sequence0213.getLowPoints();
        Log.e("sequence", " 0213 high low " + seq);

        if (sequence0213.getLowPoints() > 3) {
            sequence0213.setHighThree(true);
        }
        if (sequence0213.getLowPoints() == 3 && tempLow.getHighTileIndividualRank() >= 6) {
            sequence0213.setHighThree(true);
        }

        Log.e("sequence", sequence0123.getSequenceID() + " " + sequence1230.getSequenceID() + " " + sequence0213.getSequenceID());

        String bestSequence = findBestSequence(sequence0123, sequence1230, sequence0213);


        Log.e("sequence", " " + bestSequence);


        return bestSequence;
    }


    //------------ finds best sequence and returns id
    public static String findBestSequence(SequenceFinder s1, SequenceFinder s2, SequenceFinder s3) {
        boolean isHighThree = false;


        ArrayList<Boolean> hasNine = new ArrayList<Boolean>();
        hasNine.add(s1.isHighThree());
        hasNine.add(s2.isHighThree());
        hasNine.add(s2.isHighThree());
        isHighThree = hasNine.contains(true);
        Log.e("sequence" ," is high 3 boolean = " + String.valueOf(isHighThree));

        ArrayList<SequenceFinder> sequenceList = new ArrayList<SequenceFinder>();
        sequenceList.add(s1);
        sequenceList.add(s2);
        sequenceList.add(s3);

        SequenceFinder bestSequence = sequenceList.get(0);
        SequenceFinder tempSequence = null;

        Iterator<SequenceFinder> it = sequenceList.iterator();

        if (isHighThree) {

            while (it.hasNext()) {
                tempSequence = it.next();

                if (tempSequence.isHighThree() && tempSequence.getHighPoints() > bestSequence.getHighPoints()) {
                    bestSequence = tempSequence;
                    continue;
                }
            }
        }
                if (!isHighThree) {

                    while(it.hasNext()){
                        tempSequence = it.next();
                    System.out.println("best else ran");
                    Log.e("sequence", String.valueOf(tempSequence.getHighPoints() + " " + String.valueOf(bestSequence.getHighPoints())));
                    if (tempSequence.getHighPoints() > bestSequence.getHighPoints()) {
                        bestSequence = tempSequence;
                        continue;
                    }
                }



            }


        return bestSequence.getSequenceID();
    }
}



