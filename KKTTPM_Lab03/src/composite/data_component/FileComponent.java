package composite.data_component;

import javax.swing.tree.DefaultMutableTreeNode;

public interface FileComponent {
    String getName();
    long getSize();
    DefaultMutableTreeNode asTreeNode();
}
