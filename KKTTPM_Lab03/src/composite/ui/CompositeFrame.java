package composite.ui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;

import composite.data_component.File;
import composite.data_component.Folder;
import composite.ui_component.Button;
import composite.ui_component.Panel;
import composite.ui_component.TextBox;

public class CompositeFrame extends JFrame {
    public CompositeFrame() {
        setTitle("Composite Pattern - Nested Swing UI");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(980, 620);
        setLocationRelativeTo(null);

        Folder rootFolder = buildFileTree();
        Panel rootPanel = buildUiTree();

        JTree tree = new JTree(rootFolder.asTreeNode());
        JScrollPane treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setBorder(BorderFactory.createTitledBorder("Cay doi tuong FileComponent"));

        JScrollPane previewScrollPane = new JScrollPane(rootPanel.render());
        previewScrollPane.setBorder(BorderFactory.createTitledBorder("Cay JPanel long nhau"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, previewScrollPane);
        splitPane.setResizeWeight(0.35);

        JLabel summaryLabel = new JLabel("Tong kich thuoc file: " + rootFolder.getSize() + " bytes");

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        root.add(splitPane, BorderLayout.CENTER);
        root.add(summaryLabel, BorderLayout.SOUTH);

        setContentPane(root);
    }

    private Folder buildFileTree() {
        Folder root = new Folder("Workspace");
        Folder documents = new Folder("Documents");
        Folder images = new Folder("Images");
        Folder reports = new Folder("Reports");

        documents.add(new File("resume.pdf", 102400));
        reports.add(new File("weekly-report.docx", 84500));
        documents.add(reports);
        images.add(new File("dashboard.png", 320000));
        images.add(new File("architecture.jpg", 280000));

        root.add(documents);
        root.add(images);
        root.add(new File("README.txt", 2048));
        return root;
    }

    private Panel buildUiTree() {
        Panel dashboard = new Panel("Dashboard Panel");
        dashboard.add(new TextBox("Keyword"));

        Panel filters = new Panel("Filter Panel");
        filters.add(new Button("Search"));
        filters.add(new Button("Reset"));

        Panel resultCard = new Panel("Result Card");
        resultCard.add(new TextBox("Title"));
        resultCard.add(new TextBox("Owner"));

        Panel nestedActions = new Panel("Nested Action Panel");
        nestedActions.add(new Button("Approve"));
        nestedActions.add(new Button("Archive"));

        resultCard.add(nestedActions);
        dashboard.add(filters);
        dashboard.add(resultCard);
        return dashboard;
    }
}