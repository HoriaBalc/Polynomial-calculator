
import javax.swing.*;

public class CMVC {
    //... Create model, view, and controller.  They are
    //    created once here and passed to the parts that
    //    need them so there is only one copy of each.
    public static void main(String[] args) {

        CModel      model      = new CModel();
        CView       view       = new CView(model);
        CControler controller = new CControler(model, view);

        view.setVisible(true);
    }
}
