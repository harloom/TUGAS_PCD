
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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
public class MainFramePcd extends JFrame implements MouseListener, MouseMotionListener, MouseWheelListener {

    private JButton btnLoad;
    private ImagePanel mPanel;
    private JFileChooser mChooser;
    private int maxSize = 10;
    private int minSize = 1;
    private int currentSize = 5;

    public static void main(String[] args) {
        // TODO code application logic here
        new MainFramePcd();
    }

    private final ActionListener btnLoadOnclick = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mChooser.showOpenDialog(null);
            if (mChooser.getSelectedFile() != null) {
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
        mPanel.addMouseListener(this);
        mPanel.addMouseMotionListener(this);
        mPanel.addMouseWheelListener(this);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void paintL(Point point) {

        for (int i = 0; i < currentSize; i++) {
            for (int b = 0; b < currentSize; b++) {
                System.out.println(point.x + i + "  ,  " + point.y + b);
                mPanel.getImage().setRGB(point.x + i, point.y + b, Color.black.getRGB());

            }

        }

        mPanel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Object src = me.getSource();

        if (src.equals(mPanel)) {
            Point point = me.getPoint();
            paintL(point);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        Object src = me.getSource();

        if (src.equals(mPanel)) {
            Point point = me.getPoint();
            paintL(point);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println(e.getWheelRotation());

        if (e.getWheelRotation() < 0) {
            if (currentSize < maxSize) {
                if (currentSize > maxSize) {
                    currentSize = currentSize;
                } else {
                    currentSize++;
                }
            }
            System.out.println("mouse wheel Up" + currentSize);
        } else {
            if (currentSize > minSize) {
                if (currentSize > maxSize) {
                    currentSize = currentSize;
                } else {
                    currentSize--;
                }

            }
            System.out.println("mouse wheel Down" + currentSize);
        }
    }

}
