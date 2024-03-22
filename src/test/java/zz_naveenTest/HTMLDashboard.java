package zz_naveenTest;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class HTMLDashboard extends JFrame {
    private JList<String> fileList;
    private DefaultListModel<String> listModel;

    public HTMLDashboard(String path) {
        setTitle("HTML Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileList.setCellRenderer(new HTMLFileListRenderer());
        fileList.addListSelectionListener(new FileSelectionListener());

        JScrollPane scrollPane = new JScrollPane(fileList);
        add(scrollPane, BorderLayout.CENTER);

        loadHTMLFiles(path);
    }

    private void loadHTMLFiles(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".html"));
        if (files != null) {
            Arrays.sort(files, (f1, f2) -> {
                if (f1.getName().contains("failed") && !f2.getName().contains("failed")) {
                    return -1;
                } else if (!f1.getName().contains("failed") && f2.getName().contains("failed")) {
                    return 1;
                } else {
                    return f1.getName().compareToIgnoreCase(f2.getName());
                }
            });

            for (File file : files) {
                listModel.addElement(file.getName());
            }
        }
    }

    private void openHTMLFile(String filePath) {
        // Open the selected HTML file using the default browser
        try {
            Desktop.getDesktop().open(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class HTMLFileListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            String fileName = (String) value;

            if (fileName.contains("failed")) {
                label.setForeground(Color.RED);
            } else {
                label.setForeground(Color.BLUE); // Or any color you prefer for non-failed links
            }

            label.setText("<html><a href=''>" + fileName + "</a></html>");

            return label;
        }
    }

    private class FileSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                String selectedFile = fileList.getSelectedValue();
                if (selectedFile != null) {
                    openHTMLFile(selectedFile);
                }
            }
        }
    }
}
