package composite.ui_component;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextBox implements UIComponent {
    private final String placeholder;

    public TextBox(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public String getDisplayName() {
        return placeholder;
    }

    @Override
    public JComponent render() {
        JPanel panel = new JPanel(new BorderLayout(6, 6));
        panel.add(new JLabel(placeholder), BorderLayout.WEST);
        panel.add(new JTextField(14), BorderLayout.CENTER);
        return panel;
    }
}
