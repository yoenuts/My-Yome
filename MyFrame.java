import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame{
    MyPanel aPanel;
    MyFrame(){
        createMenuBar();
        aPanel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(500,500);
        this.add(aPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    void createMenuBar(){
        MenuBar menuBar = new MenuBar();

        Menu pRoom = new Menu("Paint Room");
        pRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        Menu exit = new Menu("Bye");
        menuBar.add(pRoom);
        menuBar.add(exit);

        this.setMenuBar(menuBar);
    }
}
