import java.util.ArrayList;
import java.util.Collections;

//import java.util.Iterator;
//import java.util.Date;

public class Polinom {
    ArrayList <Monom> elem;

    public Polinom(){
    elem=new ArrayList<Monom>();
    }

public Monom gradMax(Polinom p){
        Monom max=new Monom(0,0);
        for(Monom e:p.elem)
            if(e.getExp()>max.getExp())
                max=e;
        return max;
}

public void Sortare( ArrayList <Monom> m){
    Collections.sort(m);
}

public int adauga(Monom a){
        int k=0;
    ArrayList <Monom> mon=new ArrayList<Monom>();
        for(Monom e:this.elem){
            if(e.getExp()==a.getExp()){
                elem.set(elem.indexOf(e),new Monom(e.getCoef()+a.getCoef(),a.getExp()));
                if(e.getCoef()==0)
                    mon.add(e);
                k=1;
            }
        }
        if(k==0){
            elem.add(a);
        }
        elem.removeIf(x->(x.getCoef()==0));
    return k; }

    public void schimbaSemn(Polinom a){
        for(Monom e:a.elem){
        e.setCoef(-e.getCoef());
        }
    }


    @Override
public String toString(){
        String s="";
        this.Sortare(this.elem);
        for (Monom e:this.elem)
        {if(e.getCoef()>0)
                s+="+";
            s+=e.getCoef()+"X^"+e.getExp();}
        return s;

}
}
