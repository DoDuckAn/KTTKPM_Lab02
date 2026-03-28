package composite.ui_component;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Button implements UIComponent {
    private final String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public String getDisplayName() {
        return label;
    }

    @Override
    public JComponent render() {
        JButton button = new JButton(label);
        return button;
    }
}
