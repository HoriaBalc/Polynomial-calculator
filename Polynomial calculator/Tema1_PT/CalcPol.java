import java.util.ArrayList;
import java.util.regex.*;

public class CalcPol {

    public Polinom adunare(Polinom a, Polinom b) {
        Polinom rez = new Polinom();
        Monom m;
        for (Monom e : a.elem) {
            rez.adauga(e);
        }

        for (Monom e1 : b.elem) {
            rez.adauga(e1);

        }
        return rez;
    }
    public Polinom scadere(Polinom a, Polinom b) {
        Polinom rez = new Polinom();
        rez.schimbaSemn(b);
        CalcPol pii =new CalcPol();
        rez=pii.adunare(a,b);

        return rez;
    }

    public Polinom inmultireMonom(Polinom a,Monom b){
        Polinom rez = new Polinom();

        for(Monom e:a.elem)
        {
                Monom m=new Monom(0,0);
                m.setCoef(b.getCoef()*e.getCoef());
                m.setExp(b.getExp()+e.getExp());
                rez.adauga(m);
            }
        return rez;
    }

    public Polinom inmultire(Polinom a,Polinom b){
        Polinom rez = new Polinom();

        for(Monom e:a.elem)
            for(Monom e1:b.elem){
                Monom m=new Monom(0,0);
                m.setCoef(e1.getCoef()*e.getCoef());
                m.setExp(e1.getExp()+e.getExp());
                rez.adauga(m);
            }
        return rez;
    }



    Polinom p=new Polinom();


    public void impartire(Polinom deimp,Polinom imp,Polinom ca,Polinom r) {
        ArrayList<Polinom> rezultate=new ArrayList<Polinom>();
        Polinom aux=new Polinom();
        CalcPol d=new CalcPol();
        Polinom pol1=deimp;
        Polinom pol2=imp;
        Polinom cat=new Polinom();
        Monom m1=new Monom(0,0);
        cat.elem.add(m1);
        Polinom rest=new Polinom();
        rest.elem.add(m1);
        while( !pol1.toString().isEmpty() && deimp!=d.adunare(d.inmultire(cat,imp),rest)) {
            if (pol1.gradMax(pol1).getExp() < imp.gradMax(imp).getExp()) {
                rest = pol1;
                pol1=aux;
            } else {
                double c = pol1.gradMax(pol1).getCoef() / pol2.gradMax(pol2).getCoef();//cu cat se inmulteste b
                int e = pol1.gradMax(pol1).getExp() - pol2.gradMax(pol2).getExp();
                Monom m = new Monom(c, e);
                cat.adauga(m);
                pol1 = d.scadere(pol1, d.inmultireMonom(imp, m));
            }
        }
            ca.elem=cat.elem;
            r.elem=rest.elem;
        }


    public Polinom derivare(Polinom a){
        Polinom rez=new Polinom();
        Monom m=new Monom(0,0);
        for(Monom e:a.elem){
            Monom m1=new Monom(0,0);
            if(e.getExp()==0)
            {
                m=e;
                rez.adauga(m);
            }
            else {
                m1.setCoef(e.getCoef()*e.getExp());
                m1.setExp(e.getExp()-1);
               rez.adauga(m1);
            }
        }
        rez.elem.remove(m);
        return rez;
    }

    public Polinom integrare(Polinom a){
        Polinom rez=new Polinom();
        for(Monom e:a.elem){
            Monom m1=new Monom(0,0);

                m1.setExp(e.getExp()+1);
                m1.setCoef(e.getCoef()/m1.getExp());
                rez.adauga(m1);
        }
        return rez;
    }

    public static void regexx(String x, Polinom pol) {
        Monom m;
        x=x.replaceAll("\\-", "\\+\\-");
        String[] splitString = (x.split("\\+"));
        for (String sting : splitString) {
        if(!sting.isEmpty()){
            Double coef;
            Integer put;
            if (sting == "x") {
                coef = 1.0;
                put = 1;
            } else {
                if ("x" == sting.substring(sting.length() - 1)) {
                    coef = Double.parseDouble(sting.substring(0, sting.length() - 2));
                    put = 1;
                } else {
                    String[] m1 = sting.split("x\\^");
                    coef = Double.parseDouble(m1[0]);
                    put = Integer.parseInt(m1[1]);
                    m = new Monom((double) coef, (int) put);
                    pol.adauga(m);
                }
              }
            }
        }
    }
}

