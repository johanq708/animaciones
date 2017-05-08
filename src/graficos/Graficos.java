/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 */
public class Graficos extends JFrame{

    public Graficos(){
        add(new nuevoPanel());
    }
    public static void main(String[] args) {
        Graficos frame = new Graficos();
        frame.setTitle("hola mundo");
        frame.setSize(1024, 512);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
class nuevoPanel extends JPanel implements ActionListener{
    private int x;
    private int y;
    private int secuencia=0;
    private int sec=0;
    private Timer timer;
    public nuevoPanel(){
        
        timer=new Timer(50, this);
        timer.start();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondo = loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, null);
        
        Image moneda = loadImage("FullCoins.png");
        g.drawImage(moneda, 500, 360, 532,392,(this.secuencia*16),0,(this.secuencia*16)+16,16,this);
        
        Image muñeco=loadImage("free_radical_game_sprites.png");
        g.drawImage(muñeco, 100+x, 350, 164+x,414,192+(this.sec*32),192,192+(this.sec*32)+32,192+32,this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x+=3;
        if(this.secuencia==5){
            this.secuencia=0;
        }else{
            this.secuencia++;
        }
        if(this.sec==2){
            this.sec=0;
        }else{
            this.sec++;
        }
        //colisiones();
        repaint();
    }
    public Rectangle getBounds(){
        return new Rectangle(20+x, 380, 95,50);
    }
    /**public void colisiones(){
        Rectangle rc=getBounds();
        Rectangle a=new Rectangle(300,360,50,50);
        if(rc.intersects(a)){
            System.out.println("colision");
            timer.stop();
        }
    }
    */public Image loadImage(String nombre){
        ImageIcon ii=new ImageIcon(nombre);
        Image image=ii.getImage();
        return image;
    }

}
