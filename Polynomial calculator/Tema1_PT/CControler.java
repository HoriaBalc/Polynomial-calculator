
import java.awt.event.*;

public class CControler {
    //... The Controller needs to interact with both the Model and View.
    private CModel m_model;
    private CView  m_view;

    //========================================================== constructor
    /** Constructor */
    CControler(CModel model, CView view) {
        m_model = model;
        m_view  = view;

        view.addAddListener(new AddListener());
        view.addDiffListener(new DiffListener());
        view.addInmultireListener(new InmultireListener());
        view.addIntegrareListener(new IntegrareListener());
        view.addDerivareListener(new DerivareListener());
        view.addImpartireListener(new ImpartireListener());
        view.addClearListener(new ClearListener());
    }

    class AddListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom p = new Polinom();
            String userInput = "";
            String userInput1 = "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                p = m_model.adunareBy(userInput, userInput1);
                m_view.setTotal(p.toString());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input " );
            }
        }
    }
    class DiffListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom p=new Polinom();
            String userInput = "";
            String userInput1= "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                p=m_model.scadereBy(userInput,userInput1);
                m_view.setTotal(p.toString());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input " );
            }
        }
    }
    class InmultireListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom p=new Polinom();
            String userInput = "";
            String userInput1= "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                p=m_model.inmultireBy(userInput,userInput1);
                m_view.setTotal(p.toString());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input " );
            }
        }
    }

    class ImpartireListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom p1=new Polinom();
            Polinom p2=new Polinom();
            String userInput = "";
            String userInput1= "";
            try {
                userInput = m_view.getUserInput();
                userInput1 = m_view.getUserInput1();
                m_model.impartireBy(userInput,userInput1,p1,p2);
                m_view.setTotal(p1.toString());
                m_view.setTotal1(p2.toString());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input " );
            }
        }
    }

    class IntegrareListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom p=new Polinom();
            String userInput = "";
            String userInput1= "";
            try {
                userInput = m_view.getUserInput();
                p=m_model.integrareBy(userInput);
                m_view.setTotal(p.toString());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input " );
            }
        }
    }
    class DerivareListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom p=new Polinom();
            String userInput = "";
            String userInput1= "";
            try {
                userInput = m_view.getUserInput();
                p=m_model.derivareBy(userInput);
                m_view.setTotal(p.toString());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: " );
            }
        }
    }
    /**  1. Reset model.
     *   2. Reset View.
     */
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            m_view.reset();
            //m_view.setTotal1("");
        }
    }
    }
    // end inner class ClearListener

