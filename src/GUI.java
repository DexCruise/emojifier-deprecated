import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class GUI {
    private static final String ENTER = "Enter";
    static JButton enterButton;
    static JButton copyButton;
    public static JTextArea output;
    public static JTextField input;
    static JFrame frame;
    static JPanel panel;

    public static void main(String... args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        createFrame();
    }

    public static void createFrame() {
        frame = new JFrame("Emojifier v0.0.2 by Dexter");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);

        EnterListener buttonListener = new EnterListener();
        CopyListener copyListener = new CopyListener();

        output = new JTextArea(20, 50);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setEditable(false);

        JScrollPane scroller = new JScrollPane(output);

        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        input = new JTextField(30);

        enterButton = new JButton("Enter");
        enterButton.setActionCommand(ENTER);
        enterButton.addActionListener(buttonListener);


        copyButton = new JButton("Copy");
        copyButton.addActionListener(copyListener);

        // enterButton.setEnabled(false);
        input.setActionCommand(ENTER);

        input.addActionListener(buttonListener);


        DefaultCaret caret = (DefaultCaret) output.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        panel.add(scroller);
        inputPanel.add(input);
        inputPanel.add(enterButton);
        inputPanel.add(copyButton);
        panel.add(inputPanel);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        // Center of screen
        // frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        input.requestFocus();
    }

    public static class EnterListener implements ActionListener {

        public void actionPerformed(final ActionEvent ev) {
            if (!input.getText().trim().equals("")) {
                String cmd = ev.getActionCommand();
                if (ENTER.equals(cmd)) {
                    output.setText("");
                    output.append(EmojifyWrapper.emojify(input.getText().toLowerCase(Locale.ROOT)));
                }
            }
            input.setText("");
            input.requestFocus();
        }
    }

    public static class CopyListener implements ActionListener {
        public void actionPerformed(final ActionEvent ev) {
            String myString = output.getText();
            StringSelection stringSelection = new StringSelection(myString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }
}