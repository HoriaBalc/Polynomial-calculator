import static org.junit.Assert.*;
import org.junit.*;

public class JUnitTest {

    private static CModel m;
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;

    public JUnitTest()
    {
        System.out.println("Constructor inaintea fiecarui test!");
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("O singura data inaintea executiei setului de teste din clasa!");
        m = new CModel();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("O singura data dupa terminarea executiei setului de teste din clasa!");
        System.out.println("S-au executat " + nrTesteExecutate + " teste din care "+ nrTesteCuSucces + " au avut succes!");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Incepe un nou test!");
        nrTesteExecutate++;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("S-a terminat testul curent!");
    }

    @Test
    public void testResetGetValue() {
        m.reset();
        String t = m.getValue();
        assertNotNull(t); // verifica t sa nu fie null
        assertEquals(t,"0"); // verifica continutul lui t sa fie identic cu "1"
        nrTesteCuSucces++;
    }

    @Test
    public void testAdunareBy(){
        CalcPol a=new CalcPol();
        Polinom p=new Polinom();
        String s2="1x^2+2x^1";
        Polinom p2=new Polinom();
        a.regexx(s2,p2);
        String s1="2x^3+2x^2";
        Polinom p1=new Polinom();
        a.regexx(s1,p1);
        p=a.adunare(p1,p2);
        assertEquals(p.toString(),"+2.0X^3+3.0X^2+2.0X^1");
        nrTesteCuSucces++;
    }
    @Test
    public void testScadereBy(){
        CalcPol a=new CalcPol();
        Polinom p=new Polinom();
        String s1="1x^2+2x^1";
        Polinom p2=new Polinom();
        String s2="2x^3+2x^2";
        Polinom p1=new Polinom();
        a.regexx(s1,p1);
        a.regexx(s2,p2);
        p=a.scadere(p1,p2);
        assertEquals(p.toString(),"-2.0X^3-1.0X^2+2.0X^1");
        nrTesteCuSucces++;
    }
    @Test
    public void testInmultireBy(){
        CalcPol a=new CalcPol();
        Polinom p=new Polinom();
        String s2="1x^2+2x^1";
        Polinom p2=new Polinom();
        a.regexx(s2,p2);
        String s1="2x^3";
        Polinom p1=new Polinom();
        a.regexx(s1,p1);
        p=a.inmultire(p1,p2);
        assertEquals(p.toString(),"+2.0X^5+4.0X^4");
        nrTesteCuSucces++;
    }
    @Test
    public void testImpartireBy(){
        CalcPol a=new CalcPol();
        Polinom rez1=new Polinom();
        Polinom rez2=new Polinom();
        String s2="1x^2+2x^1";
        Polinom p2=new Polinom();
        a.regexx(s2,p2);
        String s1="2x^3+2x^2";
        Polinom p1=new Polinom();
        a.regexx(s1,p1);
        a.impartire(p1,p2,rez1,rez2);
        assertEquals(rez2.toString(),"+4.0X^1");
        assertEquals(rez1.toString(),"+2.0X^1-2.0X^0");
        nrTesteCuSucces++;
    }
    @Test
    public void testIntegrareBy(){
        CalcPol a=new CalcPol();
        Polinom p=new Polinom();
        String s1="2x^3";
        Polinom p1=new Polinom();
        a.regexx(s1,p1);
        p=a.integrare(p1);
        assertEquals(p.toString(),"+0.5X^4");
        nrTesteCuSucces++;
    }
    @Test
    public void testDerivareBy(){
        CalcPol a=new CalcPol();
        Polinom p=new Polinom();
        String s1="2x^3";
        Polinom p1=new Polinom();
        a.regexx(s1,p1);
        p=a.derivare(p1);
        assertEquals(p.toString(),"+6.0X^2");
        nrTesteCuSucces++;
    }
}
