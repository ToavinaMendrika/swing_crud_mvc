package views;

public class WindowIndex {
    protected static WindowRec mainWin;
    protected static WindowList listWin;
    protected static WindowEdit editWin;
    protected static WindowDel delWin;

    public static void setVisibleRec() {
        mainWin.setVisible(true);
        listWin.setVisible(false);
        editWin.setVisible(false);
        delWin.setVisible(false);
    }
    public static void setVisibleList() {
        listWin.setVisible(true);
        mainWin.setVisible(false);
        editWin.setVisible(false);
        delWin.setVisible(false);
    }
    public static void setVisibleEdit() {
        listWin.setVisible(false);
        mainWin.setVisible(false);
        editWin.setVisible(true);
    }

    public static void setVisibleDel() {
        listWin.setVisible(false);
        mainWin.setVisible(false);
        editWin.setVisible(false);
        delWin.setVisible(true);
    }
}
