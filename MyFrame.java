import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame{
    MyPanel aPanel;

    MyFrame(){
        aPanel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(500,500);
        this.add(aPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }
    //this is explicitly invoked
    /** 
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawLine(0,0,500,500);
    }
    **/
}
