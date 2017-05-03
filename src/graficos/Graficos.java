/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
class nuevoPanel extends JPanel implements ActionListener, MouseListener{
    private int x;
    private int y;
    private Timer timer;
    public nuevoPanel(){
        
        timer=new Timer(25, this);
        timer.start();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(10+x, 370, 100, 60);
        g.fillOval(25+x, 430, 22, 22);
        g.fillOval(75+x, 430, 22, 22);
        g.fillRect(110+x, 380, 60, 15);
        g.drawRect(7+x, 367 ,165 ,88);
        
        g.drawRect(220+x, 370, 100, 60);
        g.drawOval(235+x, 430, 22, 22);
        g.drawOval(285+x, 430, 22, 22);
        g.drawRect(320+x, 380, 60, 15);
        g.drawRect(217+x, 367 ,165 ,88);
        
        g.drawRect(120,100+y,30,80);
        g.drawRect(190,110+y,30,80);
        g.drawOval(350, 150+y, 30, 30);
        g.drawOval(300, 180+y, 30, 30);
        
        g.drawRect(440,415,40,40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x+=1;
        y+=1;
        repaint();
    }
    public Rectangle getBounds(){
        return new Rectangle(7, 367 ,165 ,88);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp=e.getPoint();
        if(getBounds().contains(mp)){
            this.timer.stop();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
