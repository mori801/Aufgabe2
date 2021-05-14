package app.exercise.algebra;

import java.util.Enumeration;

public class Rational extends BasisFraction{

    long numerator = 0;

    long denominator = 1;

    public Rational(long numerator, long denominator){
        setND(numerator, denominator);//erstellen des Objektes plus kürzen
    }

    @Override
    protected void setND(long numerator, long denominator) {
        if(denominator == 0){
            throw new IllegalArgumentException("Fraction kann nicht erstellt werden");
        }else if(denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }
        long gcd = gcd(numerator, denominator);

        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;

    }

    @Override
    public long getN() {
        return this.numerator;
    }

    @Override
    public long getD() {
        return this.denominator;
    }

    private long gcd(long numerator, long denominator){
        long gcd = numerator % denominator;
        long a = denominator;
        long b;

        while (a != 0) {
            b = gcd%a;
            gcd = a;
            a = b;
        }

        return gcd;
    }
    @Override
    public Rational clone() {
        return new Rational(getN(), getD());
    }

    @Override
    public int hashCode() {
        setND(getN(), getD());
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        setND(getN(), getD()); //Nur für den Fall, dass der Bruch kürzbar ist oder Nenner = 0

        Rational rat = (Rational) obj; //Damit man bei Benutzung von obj nicht jedes mal casten muss
        rat.setND(rat.getN(), rat.getD()); //Ebenfalls für den Fall, dass Bruch kürzbar...

        return getN() == rat.getN() && getD() == rat.getD(); //Gib zurück ob die Zähler und Nenner gleich sind
    }

    @Override
    public String toString() {
        if (getD() > 1) {
            return "(" + getN() + "/" + getD() + ")"; //Wenn Nenner größer 1 ist, dann muss Nenner mit angegeben werden
        } else {
            return "" + getN(); //Sonst reicht Angabe des Zählers
        }
    }
}
