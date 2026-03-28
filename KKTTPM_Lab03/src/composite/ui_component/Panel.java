package composite.ui_component;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel implements UIComponent {
    private static final Color[] COLORS = {
        new Color(235, 245, 255),
        new Color(245, 239, 230),
        new Color(233, 246, 239),
        new Color(250, 237, 240)
    };

    private final String title;
    private final List<UIComponent> components;

    public Panel(String title) {
        this.title = title;
        this.components = new ArrayList<>();
    }

    public void add(UIComponent component) {
        components.add(component);
    }

    @Override
    public String getDisplayName() {
        return title;
    }

    @Override
    public JComponent render() {
        return render(0);
    }

    private JComponent render(int depth) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(COLORS[depth % COLORS.length]);
        panel.setBorder(BorderFactory.createTitledBorder(title));

        for (UIComponent component : components) {
            JComponent child = component instanceof Panel nestedPanel
                ? nestedPanel.render(depth + 1)
                : component.render();
            child.setAlignmentX(0.0f);
            panel.add(child);
        }

        return panel;
    }
}
