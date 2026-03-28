package composite.ui_component;

import javax.swing.JComponent;

public interface UIComponent {
    String getDisplayName();
    JComponent render();
}
