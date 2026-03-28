package observer;

import javax.swing.SwingUtilities;

import observer.ui.ObserverFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ObserverFrame().setVisible(true));
    }
}
