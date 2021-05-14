package app.exercise.algebra;

public abstract class BasisFraction implements Fractional{

    protected abstract void setND(long numerator, long denominator);

    public void add(Fractional operand){
        long numerator = (operand.getD() * getN() + getD() * operand.getN());
        long denominator = operand.getD() * getD();
        setND(numerator, denominator);
    };

    public void sub(Fractional operand){
        add(operand.negation());
    };

    public void mul(Fractional operand){ //Zähler mit Zähler und Nenner mit Nenner werden multipliziert
        long numerator = operand.getN() * getN();
        long denominator = operand.getD() * getD();
        setND(numerator, denominator);
    };

    public void div(Fractional operand){
        mul(operand.reciprocal()); //kehrert wird multipliziert
    };

    public Fractional negation(){
        setND(-1 * getN(), getD()); // zähler wird negiert
        return this;
    };

    public Fractional reciprocal(){
        if(getN() == 0){
            throw new IllegalArgumentException("Kehrbruch kann nicht gebildet werden");
        }
        setND(getD(), getN());
        return this;
    };
}
