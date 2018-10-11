package p2pchat;

import javax.swing.SwingUtilities;

public class P2PChat {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainForm mf = new MainForm();
            mf.setVisible(true);
        });
    }
    
}
