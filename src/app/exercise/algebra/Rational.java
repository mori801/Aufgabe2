package app.exercise.algebra;

public class Rational extends BasisFraction{

    long numerator = 0;

    long denumerator = 1;

    @Override
    protected void setND(long numerator, long denominator) {
        if(denominator == 0){
            throw new IllegalArgumentException("Fraction kann nicht erstellt werden");
        }
        numerator
    }

    @Override
    public long getN() {
        return this.numerator;
    }

    @Override
    public long getD() {
        return this.denumerator;
    }
}
