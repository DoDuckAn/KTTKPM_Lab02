package observer.task;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TeamMember extends JPanel implements TaskObserver {
    private final String name;
    private final JLabel messageLabel;

    public TeamMember(String name) {
        this.name = name;
        this.messageLabel = new JLabel("Dang cho su kien");

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Team Member " + name));
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(messageLabel, BorderLayout.CENTER);
    }

    @Override
    public void taskChanged(Task task) {
        messageLabel.setText(task.getTitle() + " -> " + task.getStatus());
        setBackground(new Color(239, 248, 233));
        setOpaque(true);
    }
}
