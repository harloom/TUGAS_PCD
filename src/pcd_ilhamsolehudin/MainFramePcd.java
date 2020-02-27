
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pcd_ilhamsolehudin.ImagePanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB1A
 */
public class MainFramePcd extends JFrame {

  
    
    private JButton btnLoad;
    private ImagePanel mPanel;
    private JFileChooser mChooser;
    private final ActionListener btnLoadOnclick =  new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mChooser.showOpenDialog(null);
            if(mChooser.getSelectedFile() != null){
                try {
                    BufferedImage tmp = ImageIO.read(mChooser.getSelectedFile());
                    mPanel.setImage(tmp);
                    mPanel.repaint();
                } catch (Exception e) {
                }
            }
        }
    };
    
    
    
    public MainFramePcd() {
        super("GUI IMage");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        
        //initial 
        btnLoad = new JButton("Load Image");
        this.add(btnLoad);
        btnLoad.addActionListener(btnLoadOnclick);
        
        mChooser = new JFileChooser();
        
        mPanel = new ImagePanel();
        mPanel.setPreferredSize(new Dimension(400, 400));
        mPanel.setBackground(Color.white);
        this.add(mPanel);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
      public static void main(String[] args) {
        // TODO code application logic here
             new  MainFramePcd();
    }
    
    
    
    
}
