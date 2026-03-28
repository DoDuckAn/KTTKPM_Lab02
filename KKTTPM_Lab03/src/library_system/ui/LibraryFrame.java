package library_system.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import library_system.model.Book;
import library_system.repository.InMemoryLibraryRepository;
import library_system.service.BorrowResult;
import library_system.service.LibraryService;

public class LibraryFrame extends JFrame {
    private final LibraryService libraryService;
    private final DefaultListModel<Book> listModel;
    private final JList<Book> bookList;
    private final JTextArea logArea;
    private final JLabel statusLabel;
    private final JTextField addIdField;
    private final JTextField addTitleField;
    private final JTextField addAuthorField;
    private final JTextField searchField;
    private final JComboBox<String> searchModeBox;
    private final JTextField memberField;

    public LibraryFrame() {
        setTitle("Library System - Swing UI");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1080, 680);
        setLocationRelativeTo(null);

        logArea = new JTextArea();
        logArea.setEditable(false);
        statusLabel = new JLabel("San sang thao tac voi thu vien.");
        addIdField = new JTextField();
        addTitleField = new JTextField();
        addAuthorField = new JTextField();
        searchField = new JTextField();
        searchModeBox = new JComboBox<>(new String[] {"Theo ten sach", "Theo tac gia"});
        memberField = new JTextField();

        libraryService = new LibraryService(InMemoryLibraryRepository.getInstance(), this::appendLog);

        listModel = new DefaultListModel<>();
        bookList = new JList<>(listModel);
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bookList.setCellRenderer(new BookCellRenderer());

        JPanel addPanel = buildAddPanel();
        JPanel actionPanel = buildActionPanel();
        JScrollPane listScrollPane = new JScrollPane(bookList);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Danh sach sach"));

        JScrollPane logScrollPane = new JScrollPane(logArea);
        logScrollPane.setBorder(BorderFactory.createTitledBorder("Thong bao va nhat ky"));

        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));
        rightPanel.add(addPanel, BorderLayout.NORTH);
        rightPanel.add(actionPanel, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 12, 12));
        centerPanel.add(listScrollPane);
        centerPanel.add(rightPanel);

        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        root.add(centerPanel, BorderLayout.CENTER);
        root.add(logScrollPane, BorderLayout.SOUTH);
        root.add(statusLabel, BorderLayout.NORTH);

        setContentPane(root);
        refreshBooks(libraryService.getAllBooks());
    }

    private JPanel buildAddPanel() {
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(event -> addBook());

        JPanel panel = new JPanel(new GridLayout(4, 2, 8, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Them sach"));
        panel.add(new JLabel("Book ID"));
        panel.add(addIdField);
        panel.add(new JLabel("Title"));
        panel.add(addTitleField);
        panel.add(new JLabel("Author"));
        panel.add(addAuthorField);
        panel.add(new JLabel("Action"));
        panel.add(addButton);
        return panel;
    }

    private JPanel buildActionPanel() {
        JButton searchButton = new JButton("Search Book");
        searchButton.addActionListener(event -> searchBooks());

        JButton showAllButton = new JButton("Hien tat ca" );
        showAllButton.addActionListener(event -> refreshBooks(libraryService.getAllBooks()));

        JButton borrowButton = new JButton("Borrow Book");
        borrowButton.addActionListener(event -> borrowSelectedBook());

        JButton returnButton = new JButton("Tra sach");
        returnButton.addActionListener(event -> returnSelectedBook());

        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Tim kiem va muon sach"));
        panel.add(new JLabel("Tu khoa"));
        panel.add(searchField);
        panel.add(new JLabel("Kieu tim"));
        panel.add(searchModeBox);
        panel.add(new JLabel("Nguoi muon/tra"));
        panel.add(memberField);
        panel.add(searchButton);
        panel.add(showAllButton);
        panel.add(borrowButton);
        panel.add(returnButton);
        return panel;
    }

    private void addBook() {
        BorrowResult result = libraryService.addBook(addIdField.getText(), addTitleField.getText(), addAuthorField.getText());
        applyResult(result);
        if (result.isSuccess()) {
            clearAddForm();
            refreshBooks(libraryService.getAllBooks());
        }
    }

    private void searchBooks() {
        boolean byAuthor = searchModeBox.getSelectedIndex() == 1;
        List<Book> results = libraryService.searchBooks(searchField.getText(), byAuthor);
        refreshBooks(results);
        statusLabel.setText("Tim thay " + results.size() + " sach phu hop.");
    }

    private void borrowSelectedBook() {
        Book selectedBook = bookList.getSelectedValue();
        if (selectedBook == null) {
            statusLabel.setText("Can chon sach truoc khi muon.");
            return;
        }
        BorrowResult result = libraryService.borrowBook(selectedBook.getId(), memberField.getText());
        applyResult(result);
        refreshBooks(libraryService.getAllBooks());
    }

    private void returnSelectedBook() {
        Book selectedBook = bookList.getSelectedValue();
        if (selectedBook == null) {
            statusLabel.setText("Can chon sach truoc khi tra.");
            return;
        }
        BorrowResult result = libraryService.returnBook(selectedBook.getId(), memberField.getText());
        applyResult(result);
        refreshBooks(libraryService.getAllBooks());
    }

    private void applyResult(BorrowResult result) {
        statusLabel.setText(result.getMessage());
        appendLog(result.getMessage());
    }

    private void refreshBooks(List<Book> books) {
        listModel.clear();
        for (Book book : books) {
            listModel.addElement(book);
        }
    }

    private void clearAddForm() {
        addIdField.setText("");
        addTitleField.setText("");
        addAuthorField.setText("");
    }

    private void appendLog(String message) {
        SwingUtilities.invokeLater(() -> logArea.setText(message + "\n" + logArea.getText()));
    }

    private static class BookCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Book book) {
                label.setText(book.toString());
            }
            return label;
        }
    }
}