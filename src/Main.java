import views.WindowEdit;
import views.WindowList;
import views.WindowRec;

public class Main {
    protected static WindowRec mainWin;
    protected static WindowList listWin;
    protected static WindowEdit editWin;
    public static void main(String[] args) {

        mainWin = new WindowRec();
        mainWin.setVisible(true);

        listWin = new WindowList();
        listWin.setVisible(false);

        editWin = new WindowEdit();
        editWin.setVisible(false);
    }
}
