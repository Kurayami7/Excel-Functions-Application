package gui_swing_events;

// Importing the necessary classes
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// Class extends the Jframe and uses 2 interfaces
public class SwingEventWindow extends JFrame implements ActionListener, ItemListener {

    private JTextField inputField;
    private JTextField resultField;
    private JRadioButton rdoSum;
    private JRadioButton rdoAvg;
    private JRadioButton rdoMax;
    private JRadioButton rdoMin;
    private ButtonGroup rdoGroup;
    private int rdoChecked;

    public SwingEventWindow() {

        // Set up the main Swing window
        super("Excel Formulas Window");
        setSize(800, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and configure panels
        JPanel mainPanel = new JPanel(new GridLayout(6, 1));
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new GridLayout(1, 4));
        JPanel panel5 = new JPanel(new FlowLayout());
        JPanel panel6 = new JPanel(new FlowLayout());

        // Add labels and input fields
        JLabel lblMain = new JLabel("Excel Functions");
        panel1.add(lblMain);

        JLabel lblRequest = new JLabel("Enter your numbers separated by spaces");
        panel2.add(lblRequest);

        inputField = new JTextField(20);
        panel3.add(inputField);

        // Create and configure radio buttons for different operations
        rdoSum = new JRadioButton("Sum");
        rdoAvg = new JRadioButton("Avg");
        rdoMax = new JRadioButton("Max");
        rdoMin = new JRadioButton("Min");

        // Attach item listeners to radio buttons
        rdoSum.addItemListener(this);
        rdoAvg.addItemListener(this);
        rdoMax.addItemListener(this);
        rdoMin.addItemListener(this);

        rdoGroup = new ButtonGroup();

        // Adding buttonsto the group of buttons
        rdoGroup.add(rdoSum);
        rdoGroup.add(rdoAvg);
        rdoGroup.add(rdoMax);
        rdoGroup.add(rdoMin);

        panel4.add(rdoSum);
        panel4.add(rdoAvg);
        panel4.add(rdoMax);
        panel4.add(rdoMin);

        // Creating a 'Calculate' button and result display fields
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        panel5.add(calculateButton);

        // Just creating a label to display output
        JLabel resultLabel = new JLabel("Result:");
        panel6.add(resultLabel);

        // Ensuring the result field isn't editable
        resultField = new JTextField(20);
        resultField.setEditable(false);
        panel6.add(resultField);

        // Add panels to the main panel
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(panel5);
        mainPanel.add(panel6);

        // Add the main panel to the window
        add(mainPanel);

    }

    // Handle changes in the selected radio button
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof JRadioButton && e.getStateChange() == ItemEvent.SELECTED) {
            JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
            if (selectedRadioButton == rdoSum) {
                rdoChecked = 1;
            } else if (selectedRadioButton == rdoAvg) {
                rdoChecked = 2;
            } else if (selectedRadioButton == rdoMax) {
                rdoChecked = 3;
            } else if (selectedRadioButton == rdoMin) {
                rdoChecked = 4;
            }
        }
    }

    // Handling button click (calculate) event using if elses
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            String userInput = inputField.getText();
            Excel excel = new Excel(userInput);
            double result = 0.0;
            if (rdoChecked == 1) {
                result = excel.findTotal();
            } else if (rdoChecked == 2) {
                result = excel.findAvg();
            } else if (rdoChecked == 3) {
                result = excel.findMax();
            } else if (rdoChecked == 4) {
                result = excel.findMin();
            }
            // setting the field display as the resulting output
            resultField.setText(String.valueOf(result));
        }
    }
}
