package RenderingInformazioneGrafica;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageDrawer extends JFrame{

    private BufferedImage img;
    //private Image img = null;

    public ImageDrawer(String fileImage) {
        super("ImageDrawer");

        LoadImage(fileImage);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        Container contPane = getContentPane();
        contPane.add(new DrawingCanvas() ,BorderLayout.CENTER);
        pack();
    }

    private void LoadImage(String fileImage){
        this.img = null;

        try {
            this.img = ImageIO.read(new File(fileImage));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    class DrawingCanvas extends JPanel{
        public DrawingCanvas(){
            super();
            setBackground(Color.white);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            draw(g);
        }
    }

    private void draw (Graphics g){
        g.drawImage(img, 0, 0, 1280, 720, 0, 0, 3840, 2160, null); //LaF
        //g.drawImage(img, 100, 100, null); //fragola
        //g.drawImage(img, 100, 100, 165, 165, 0, 1386, 64, 1451, null); //goblin
    }

    public static void main(String[] args) {

        String LaF = ".\\RenderingInformazioneGrafica\\2014-Ferrari-LaFerrari-016-2160.jpg";
        //String fragola = ".\\RenderingInformazioneGrafica\\strawberry.jpg";
        //String goblin = ".\\RenderingInformazioneGrafica\\ghostandgoblins.gif";

        /*if(args.length < 1){
            String erorrMsg = "Usage: java ImageDrawer <file-image>";
            System.out.println(erorrMsg);
            System.exit(-1);
        }
        String fileImage = args[0];*/

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageDrawer(LaF).setVisible(true);
            }
        });
    }
}
