
import java.util.Collections;
public class Monom implements Comparable<Monom>{
    private double coef;
    private int exp;

    public Monom(double b,int a){
        this.coef=b;
        this.exp=a;
    }

    public int getExp() {
        return exp;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    @Override
    public int compareTo(Monom c) {
        return c.getExp()-this.exp;
    }
}
