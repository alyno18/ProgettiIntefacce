package primaGuiInterattiva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingApplication extends JFrame{
    private int numClicks = 0;
    private int numSlowClicks = 0;
    private final static String LABEL_PREFIX = "Number of button clicks: ";
    private final static String LABEL_PREFIX_2 = "Execution of slow method: ";
    private JLabel label;
    private JLabel label2;

    public SwingApplication(){
        super("SwingAppication");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(0,1)); //griglia Nx1  uguale a 0x1
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        
        Container contPane = this.getContentPane();
        contPane.add(panel, BorderLayout.CENTER);
        this.setSize(800,500);

        //first pair
        label = new JLabel(LABEL_PREFIX +numClicks);
        JButton button = new JButton("i'm a swing button");

        panel.add(button);
        panel.add(label);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                numClicks++;
                label.setText(LABEL_PREFIX +numClicks);
            }
        });
        button.setMnemonic(KeyEvent.VK_ENTER);

        //second pair
        label2 = new JLabel(LABEL_PREFIX_2 +numSlowClicks);
        JButton button2 = new JButton("start slow method");

        panel.add(button2);
        panel.add(label2);

        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                executeSlowMethodInBackground(1);
            }
        });
        button2.setMnemonic(KeyEvent.VK_SPACE);
    }

    private void slowMethod(int sec){
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void executeSlowMethodInBackground(int sec){
        SwingWorker worker = new SwingWorker<Void,Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                System.out.println("In....background");
                slowMethod(sec);
                return null;
            }

            @Override
            protected void done() {
                System.out.println("In....done");
                numSlowClicks++;
                label2.setText(LABEL_PREFIX_2 +numSlowClicks);
            }
        };
        worker.execute();
    }

    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("errore nella creazione del look and feel");
        }
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingApplication().setVisible(true);
            }
        });
    }
}
