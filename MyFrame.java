import java.awt.*;

import javax.swing.*;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

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

        Menu eHoMenu = new Menu("Enter Home");
        MenuItem pRoom = new MenuItem("Paint Room");
        pRoom.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
                openFxmlFile("PaintScene.fxml");
            }
        });
        Menu mainMenu = new Menu("Main Menu");
        MenuItem exit = new MenuItem("Bye!");
        exit.addActionListener(e -> System.exit(0));

        eHoMenu.add(pRoom);
        mainMenu.add(exit);

        menuBar.add(eHoMenu);
        menuBar.add(mainMenu);

        this.setMenuBar(menuBar);
        
    }

    private void openFxmlFile(String filename) {
        try {
            JFXPanel fxPanel = new JFXPanel(); // Initialize JavaFX on the EDT
            Pane root = FXMLLoader.load(getClass().getResource(filename));

            aPanel.removeAll(); // Remove the existing components from the panel
            aPanel.setLayout(new BorderLayout());
            aPanel.add(fxPanel, BorderLayout.CENTER); // Add the JFXPanel
            aPanel.revalidate();
            
            fxPanel.setScene(new Scene(root));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
