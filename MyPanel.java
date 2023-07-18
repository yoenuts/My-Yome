
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener{
    //create a panel that holds the painting, so that it doesnt overlap the entire box
    Image img;
    Image ball;
    Timer timer;
    int xVelocity = 0, yVelocity = 15;
    //starting positions
    int x = 330, y = 420;

    MyPanel(){
        this.setPreferredSize(new Dimension(500,500));
        img = new ImageIcon(getClass().getResource("background.jpg")).getImage();
        ball = new ImageIcon(getClass().getResource("basketball.png")).getImage();
        timer = new Timer(100,null);
        timer.addActionListener(this);
        timer.start();
        
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        int[] xPoints = {150, 235, 320};
        int[] yPoints = {290, 170, 290};
        int nPoints = 3;

        int ballWidth = 50;
        int ballHeight = 50;

        //background
        g2D.drawImage(img, 0, 0, null);

        //label
        g2D.setFont(new Font("Verdana", Font.BOLD, 15));
        g2D.drawString("Yippie Yoenuts Yome", 180, 30);

        //Draw a house
        g2D.setPaint(Color.black); 
        g2D.fillPolygon(xPoints, yPoints, nPoints);
        
        g2D.setPaint(Color.PINK); 
        g2D.fillRect(150,290,170,170);

        g2D.setPaint(Color.BLUE); 
        g2D.fillRect(170, 350, 70, 110);
        //the sun
        g2D.setPaint(Color.yellow); 
        g2D.fillOval(0, 0, 80, 80);

        g2D.drawImage(ball, x, y, ballWidth, ballHeight, null);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(y >= 90){
            yVelocity = yVelocity * -1;
        }
        y = y + yVelocity;
        repaint();
    }
}
