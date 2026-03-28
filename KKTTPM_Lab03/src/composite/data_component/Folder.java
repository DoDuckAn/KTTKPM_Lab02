package composite.data_component;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Folder implements FileComponent {
    private final String name;
    private final List<FileComponent> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileComponent component) {
        children.add(component);
    }

    public void remove(FileComponent component) {
        children.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileComponent child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    @Override
    public DefaultMutableTreeNode asTreeNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(name + " [" + getSize() + " bytes]");
        for (FileComponent child : children) {
            node.add(child.asTreeNode());
        }
        return node;
    }
}
