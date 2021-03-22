import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class CView extends JFrame {
    //... Components
    private JTextField m_userInputTf = new JTextField(20);
    private JTextField m_userInputTf1 = new JTextField(20);
    private JTextField m_totalTf     = new JTextField(20);
    private JTextField m_totalTf1     = new JTextField(20);
    private JButton    m_addBtn = new JButton("Adunare");
    private JButton    m_diffBtn = new JButton("Scadere");
    private JButton    m_multiplyBtn = new JButton("Inmultirea");
    private JButton    m_derivareBtn = new JButton("Derivare");
    private JButton    m_integralaBtn = new JButton("Integrala");
    private JButton    m_impartireBtn = new JButton("Impartire");
    private JButton    m_clearBtn    = new JButton("Clear");

    private CModel m_model;

    //======================================================= constructor
    /** Constructor */
    CView(CModel model) {
        //... Set up the logic
        m_model = model;
       // m_model.setValue(CModel.INITIAL_VALUE);
        Container c;
        c=getContentPane();
        c.setLayout(new BorderLayout());
        //... Initialize components

        m_totalTf.setEditable(false);

        m_totalTf1.setEditable(false);
        //... Layout the components.
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        JPanel butoane = new JPanel();
        butoane.setLayout(new FlowLayout());
        JPanel rezultat = new JPanel();
        rezultat.setLayout(new FlowLayout());
        c.add(content,BorderLayout.NORTH);

        c.add(butoane,BorderLayout.SOUTH);
        c.add(rezultat,BorderLayout.CENTER);
        content.add(new JLabel("Input1"));
        content.add(m_userInputTf);
        content.add(new JLabel("Input2"));
        content.add(m_userInputTf1);

        //content.add(m_multiplyBtn);
        rezultat.add(new JLabel("Rezultat1"));
        rezultat.add(m_totalTf);
        rezultat.add(new JLabel("Rezultat2"));
        rezultat.add(m_totalTf1);

        //JPanel butoane = new JPanel();


        //butoane.setLayout(new BoxLayout(butoane, BoxLayout.PAGE_AXIS));
        butoane.add(m_addBtn);
        butoane.add(m_diffBtn);
        butoane.add(m_multiplyBtn);
        butoane.add(m_integralaBtn);
        butoane.add(m_derivareBtn);
        butoane.add(m_impartireBtn);
        butoane.add(m_clearBtn);

        //... finalize layout
        this.setContentPane(c);
      //  this.setContentPane(butoane);
        this.pack();

        this.setTitle("Calculator-polinoame");
        // The window closing event should probably be passed to the
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void reset() {
        setTotal("");
        setTotal1("");
        m_userInputTf.setText("");
        m_userInputTf1.setText("");
    }

    String getUserInput() {
        return m_userInputTf.getText();
    }
    String getUserInput1() {
        return m_userInputTf1.getText();
    }
    void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }
    void setTotal1(String newTotal) { m_totalTf1.setText(newTotal); }


    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }


    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
    void addAddListener(ActionListener tal) {
        m_addBtn.addActionListener(tal);
    }
    void addDiffListener(ActionListener tal) { m_diffBtn.addActionListener(tal); }
    void addInmultireListener(ActionListener tal) { m_multiplyBtn.addActionListener(tal); }
    void addIntegrareListener(ActionListener tal) { m_integralaBtn.addActionListener(tal); }
    void addDerivareListener(ActionListener tal) { m_derivareBtn.addActionListener(tal); }
    void addImpartireListener(ActionListener tal) { m_impartireBtn.addActionListener(tal); }




}
