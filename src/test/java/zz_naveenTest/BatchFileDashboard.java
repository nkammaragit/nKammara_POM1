package zz_naveenTest;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BatchFileDashboard extends JFrame {
    private JRadioButton[] scriptRadioButtons;
    private JPanel startButtonPanel;
    private JButton startButton;
    private JTextArea logOutput;

    public BatchFileDashboard() {
        setTitle("Batch File Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Script Names
        String[] scripts = {"script1.bat", "script2.bat", "script3.bat"}; // Add your batch file names here
        ButtonGroup group = new ButtonGroup(); // Group for radio buttons
        scriptRadioButtons = new JRadioButton[scripts.length];
        JPanel scriptPanel = new JPanel(new GridLayout(0, 1)); // Use GridLayout for vertical arrangement
        scriptPanel.setBorder(BorderFactory.createTitledBorder("Test Cases")); // Set titled border
        for (int i = 0; i < scripts.length; i++) {
            scriptRadioButtons[i] = new JRadioButton(scripts[i]);
            group.add(scriptRadioButtons[i]); // Add to button group
            scriptPanel.add(scriptRadioButtons[i]);
        }
        JScrollPane scriptScrollPane = new JScrollPane(scriptPanel);
        add(scriptScrollPane, BorderLayout.NORTH);

        // Start Button Panel
        startButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Use FlowLayout to center the button
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeSelectedBatchScript();
            }
        });
        startButton.setPreferredSize(new Dimension(70, 30)); // Set preferred size
        startButtonPanel.add(startButton);
        add(startButtonPanel, BorderLayout.CENTER);

        // Log Output
        logOutput = new JTextArea(10, 50);
        logOutput.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logOutput);
        logScrollPane.setBorder(BorderFactory.createTitledBorder("Log Output")); // Set titled border
        add(logScrollPane, BorderLayout.SOUTH);

        pack(); // Pack the frame to size its components properly
    }

    private void executeSelectedBatchScript() {
        logOutput.setText(""); // Clear log output
        for (JRadioButton radioButton : scriptRadioButtons) {
            if (radioButton.isSelected()) {
                String selectedScript = radioButton.getText();
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder(selectedScript);
                    processBuilder.redirectErrorStream(true);
                    Process process = processBuilder.start();

                    InputStream inputStream = process.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        logOutput.append(line + "\n");
                    }

                    process.waitFor();
                } catch (IOException | InterruptedException ex) {
                    logOutput.append("Error executing batch script " + selectedScript + ": " + ex.getMessage() + "\n");
                }
                // Stop after finding the selected script
                break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BatchFileDashboard dashboard = new BatchFileDashboard();
                dashboard.setVisible(true);
            }
        });
    }
}
