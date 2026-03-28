package observer.stock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Investor extends JPanel implements StockObserver {
    private final String name;
    private final JLabel messageLabel;

    public Investor(String name) {
        this.name = name;
        this.messageLabel = new JLabel("Chua co cap nhat");

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Investor " + name));
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(messageLabel, BorderLayout.CENTER);
    }

    @Override
    public void update(Stock stock) {
        messageLabel.setText(stock.getSymbol() + " = " + stock.getPrice());
        setBackground(new Color(233, 245, 255));
        setOpaque(true);
    }
}
