package observer.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import observer.stock.Investor;
import observer.stock.Stock;
import observer.task.Task;
import observer.task.TeamMember;

public class ObserverFrame extends JFrame {
    private final Stock stock;
    private final Task task;
    private final JTextArea eventLog;

    public ObserverFrame() {
        setTitle("Observer Pattern - UI Event Updates");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(920, 620);
        setLocationRelativeTo(null);

        stock = new Stock("AAPL", 150.0);
        task = new Task("Implement Swing UI");
        eventLog = new JTextArea();
        eventLog.setEditable(false);

        JPanel stockPanel = buildStockPanel();
        JPanel taskPanel = buildTaskPanel();

        JPanel center = new JPanel(new GridLayout(1, 2, 12, 12));
        center.add(stockPanel);
        center.add(taskPanel);

        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        root.add(center, BorderLayout.CENTER);
        root.add(eventLog, BorderLayout.SOUTH);

        setContentPane(root);
    }

    private JPanel buildStockPanel() {
        Investor john = new Investor("John");
        Investor sarah = new Investor("Sarah");
        Investor linh = new Investor("Linh");
        stock.subscribe(john);
        stock.subscribe(sarah);
        stock.subscribe(linh);

        JTextField priceField = new JTextField("155.5");
        JButton updateButton = new JButton("Cap nhat gia co phieu");
        updateButton.addActionListener(event -> updateStock(priceField));

        JPanel control = new JPanel(new GridLayout(2, 2, 8, 8));
        control.add(new JLabel("Gia moi"));
        control.add(priceField);
        control.add(new JLabel("Su kien"));
        control.add(updateButton);

        JPanel observers = new JPanel(new GridLayout(3, 1, 8, 8));
        observers.add(john);
        observers.add(sarah);
        observers.add(linh);

        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Stock Observer"));
        panel.add(control, BorderLayout.NORTH);
        panel.add(observers, BorderLayout.CENTER);
        return panel;
    }

    private JPanel buildTaskPanel() {
        TeamMember alice = new TeamMember("Alice");
        TeamMember bob = new TeamMember("Bob");
        TeamMember minh = new TeamMember("Minh");
        task.addObserver(alice);
        task.addObserver(bob);
        task.addObserver(minh);

        JComboBox<String> statusBox = new JComboBox<>(new String[] {"NOT_STARTED", "IN_PROGRESS", "REVIEW", "COMPLETED"});
        JButton updateButton = new JButton("Cap nhat trang thai task");
        updateButton.addActionListener(event -> updateTask((String) statusBox.getSelectedItem()));

        JPanel control = new JPanel(new GridLayout(2, 2, 8, 8));
        control.add(new JLabel("Trang thai"));
        control.add(statusBox);
        control.add(new JLabel("Su kien"));
        control.add(updateButton);

        JPanel observers = new JPanel(new GridLayout(3, 1, 8, 8));
        observers.add(alice);
        observers.add(bob);
        observers.add(minh);

        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Task Observer"));
        panel.add(control, BorderLayout.NORTH);
        panel.add(observers, BorderLayout.CENTER);
        return panel;
    }

    private void updateStock(JTextField priceField) {
        try {
            double value = Double.parseDouble(priceField.getText().trim());
            stock.setPrice(value);
            eventLog.setText("Stock event: AAPL -> " + value + "\n" + eventLog.getText());
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Gia co phieu phai la so hop le.", "Du lieu sai", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateTask(String status) {
        task.setStatus(status);
        eventLog.setText("Task event: " + task.getTitle() + " -> " + status + "\n" + eventLog.getText());
    }
}