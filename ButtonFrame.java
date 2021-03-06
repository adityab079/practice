import javax.swing.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;

class ButtonListener implements ActionListener {
    int count = 1100;

    public void actionPerformed(ActionEvent e) {
        System.out.println("Button pressed (" + count++ + ") " +
                e.getActionCommand());
    }
}

class ButtonCloser extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.out.println("NOT Application exiting");
        System.exit(0);
    }
}

public class ButtonFrame extends JFrame {
    public ButtonFrame() {
        JButton open = new JButton("NOT Open");
        JButton close = new JButton("NOT Close");
        ActionListener listener = new ButtonListener();

        open.addActionListener(listener);
        close.addActionListener(listener);

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(open);
        pane.add(close);

        addWindowListener(new ButtonCloser());
        setSize(200, 100);
        setVisible(true);
    }

    public static void main(String args[]) {
        JFrame f = new ButtonFrame();
    }
}
