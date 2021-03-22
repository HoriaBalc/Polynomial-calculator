import java.util.ArrayList;

public class mainClass {

    public static void main(String[] args) {
        String s = "2x^2+4x^0";
        String s1 = "2x^1";
        CalcPol a=new CalcPol();
        Polinom p=new Polinom();
        Polinom p1=new Polinom();
        Polinom rez=new Polinom();
        Polinom rez1=new Polinom();
        ArrayList<Polinom> rezultate = new ArrayList<Polinom>();
      /*  Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        Monom m1=new Monom(2,2);
        Monom m2=new Monom(-1,1);
        Monom m3=new Monom(3,3);
        Monom m4=new Monom(-2,2);
        p1.adauga(m1);
        p1.adauga(m2);
        p2.adauga(m3);
        p2.adauga(m4);
        p=a.adunare(p1,p2);*/
        a.regexx(s,p);
        a.regexx(s1,p1);
        a.impartire(p,p1,rez,rez1);
        rez1=a.adunare(p1,p);
        // s.split("x");
        //for (Monom e:rez.elem)
          //  System.out.print(e.getCoef() +"*x^"+e.getExp()+"+ ");

        //System.out.println(rezultate.get(0).toString());
        //System.out.println(rezultate.get(1).toString());
        System.out.println(rez1.toString());
    }
}
