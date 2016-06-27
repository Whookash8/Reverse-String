import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Łukasz on 2016-06-24.
 */
public class Main extends JFrame
{
    private String input;
    private String output;
    private JPanel mainPanel;
    private JTextField inputField;
    private JLabel infoLabel;
    private JLabel outputLabel;
    private JButton confirmationButton;
    private GridBagConstraints GBC;
    private Font mainFont;

    public Main()
    {
        mainPanel = new JPanel();

        mainFont = new Font("Arial", Font.PLAIN, 18);

        inputField = new JTextField("Input");
        inputField.setFont(mainFont);
        inputField.setPreferredSize(new Dimension(200, 50));
        infoLabel = new JLabel("Reverse String: ");
        infoLabel.setFont(mainFont);
        infoLabel.setPreferredSize(new Dimension(200, 50));
        outputLabel = new JLabel("Output");
        outputLabel.setFont(mainFont);
        outputLabel.setPreferredSize(new Dimension(200, 50));
        confirmationButton = new JButton("Reverse!");
        confirmationButton.setPreferredSize(new Dimension(200, 50));

        confirmationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                input = inputField.getText();
                char[] signs = input.toCharArray();
                char[] result = new char[signs.length];

                for (int i = 0; i < signs.length; i++)
                {
                    result[signs.length - i - 1] = signs[i];
                }

                output = String.valueOf(result);
                outputLabel.setText(output);
            }
        });

        mainPanel.setLayout(new GridBagLayout());
        GBC = new GridBagConstraints();

        GBC.fill = GridBagConstraints.BOTH;
        GBC.anchor = GridBagConstraints.WEST;
        mainPanel.add(inputField, GBC);
        GBC.gridx = 1;
        mainPanel.add(confirmationButton, GBC);

        GBC.gridx = 0;
        GBC.gridy = 1;
        mainPanel.add(infoLabel, GBC);
        GBC.gridx = 1;
        mainPanel.add(outputLabel, GBC);

        add(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Reverse the String");
        setVisible(true);
        pack();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                new Main();
            }
        });
    }
}
