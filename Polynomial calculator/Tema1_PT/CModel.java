import java.util.ArrayList;
import java.math.BigInteger;

public class CModel {
    //... Constants
    static final String INITIAL_VALUE = "0";

    //... Member variable defining state of calculator.
    private BigInteger m_total;  // The total current value state.
    private Polinom p;
    //============================================================== constructor
    /** Constructor */
    CModel() {
        reset();
    }

    //==================================================================== reset
    /** Reset to initial value. */
    public void reset() {
        m_total = new BigInteger(INITIAL_VALUE);
    }

    //=============================================================== multiplyBy
    /** Multiply current total by a number.
     *@param operand Number (as string) to multiply total by.
     */

    public Polinom adunareBy(String operand1,String operand2) {
        CalcPol a= new CalcPol();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        a.regexx(operand1,p1);
        a.regexx(operand2,p2);
        p=a.adunare(p1,p2);

        return p;
    }
    public Polinom scadereBy(String operand1,String operand2) {
        CalcPol a= new CalcPol();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        a.regexx(operand1,p1);
        a.regexx(operand2,p2);
        p=a.scadere(p1,p2);
        return p;
    }
    public Polinom inmultireBy(String operand1,String operand2) {
        CalcPol a= new CalcPol();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        a.regexx(operand1,p1);
        a.regexx(operand2,p2);
        p=a.inmultire(p1,p2);
        return p;
    }
    public void impartireBy(String operand1,String operand2,Polinom pol1,Polinom pol2) {

        CalcPol a= new CalcPol();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        Polinom rez=new Polinom();
        Polinom rez1=new Polinom();
        a.regexx(operand1,p1);
        a.regexx(operand2,p2);
        a.impartire(p1,p2,rez,rez1);
        pol1.elem=rez.elem;
        pol2.elem=rez1.elem;
    }
    public Polinom integrareBy(String operand1) {
        CalcPol a= new CalcPol();
        Polinom p1=new Polinom();
        a.regexx(operand1,p1);
        p=a.integrare(p1);
        return p;
    }
    public Polinom derivareBy(String operand1) {
        CalcPol a= new CalcPol();
        Polinom p1=new Polinom();
        a.regexx(operand1,p1);
        p=a.derivare(p1);
        return p;
    }
    //================================================================= setValue
    /** Set the total value.
     *@param value New value that should be used for the calculator total.
     */
    public void setValue(String value) {
        m_total = new BigInteger(value);
    }

    //================================================================= getValue
    /** Return current calculator total. */
    public String getValue() {
        return m_total.toString();
    }
}
