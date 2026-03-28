package composite;

import javax.swing.SwingUtilities;

import composite.ui.CompositeFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CompositeFrame().setVisible(true));
    }
}
