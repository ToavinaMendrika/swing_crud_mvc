package views;

public class WindowIndex {
    protected static WindowRec mainWin;
    protected static WindowList listWin;
    protected static WindowEdit editWin;

    public static void setVisibleRec() {
        mainWin.setVisible(true);
        listWin.setVisible(false);
        editWin.setVisible(false);
    }
    public static void setVisibleList() {
        listWin.setVisible(true);
        mainWin.setVisible(false);
        editWin.setVisible(false);
    }
    public static void setVisibleEdit() {
        listWin.setVisible(false);
        mainWin.setVisible(false);
        editWin.setVisible(true);
    }
}
