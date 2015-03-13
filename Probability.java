package com.probability;

/**
 * Created by jaiprak on 3/11/2015.
 */
public class Probability {
    private static final int CERTAINITY = 1;
    private double value;

    private Probability(double value){
        this.value = value;
    }

    public static Probability setValue(int favourableEvents, int totalEvents){
        if(favourableEvents <= totalEvents && totalEvents > 0 && favourableEvents > 0)
            return new Probability((double)favourableEvents/totalEvents);
        return null;
    }

    public double getValue(){
        return value;
    }

    public Probability negate() {
        return new Probability(CERTAINITY - value);
    }

    public Probability and(Probability probability){
        return new Probability(this.value * probability.value);
    }

    public Probability or(Probability probability){
        //De Morgan's Law !(!P(A) && !P(B))
        // 1-P(A).P(B).P(C).....
        return (this.negate().and(probability.negate())).negate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Probability)) return false;

        Probability that = (Probability) o;

        if (Double.compare(that.value, value) != 0) return false;

        return true;
    }

//    @Override
//    public int hashCode() {
//        long temp = Double.doubleToLongBits(value);
//        return (int) (temp ^ (temp >>> 32));
//    }
}
