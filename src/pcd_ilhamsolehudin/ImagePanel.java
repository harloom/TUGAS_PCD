/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcd_ilhamsolehudin;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author lab1a
 */
public class ImagePanel  extends JPanel{
    
    BufferedImage bfImage;
    AffineTransform aft = new AffineTransform();
    
    
    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0, 0, getWidth(), getHeight());
        if(bfImage != null){
        g.drawImage(bfImage, 0, 0, null);
    }
    }
    
    public synchronized BufferedImage getImage(){
     return bfImage;
    }
    
    public synchronized void setImage(BufferedImage image){
        this.bfImage = image;
    }
    
    public int getPixel(int x , int y){
        if(bfImage !=null){
            return bfImage.getRGB(x, y);
        }
        
        return 0 ;
    }
    
}
