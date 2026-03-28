package composite.data_component;

import javax.swing.tree.DefaultMutableTreeNode;

public class File implements FileComponent {
    private final String name;
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public DefaultMutableTreeNode asTreeNode() {
        return new DefaultMutableTreeNode(name + " (" + size + " bytes)");
    }
}
