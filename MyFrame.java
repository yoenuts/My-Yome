import java.awt.*;
import java.awt.event.ActionListener;

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
        Menu exit = new Menu("Bye");

        eHoMenu.add(pRoom);

        menuBar.add(eHoMenu);
        menuBar.add(exit);

        this.setMenuBar(menuBar);
    }

    private void openFxmlFile(String filename) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filename));
            Pane root = fxmlLoader.load();

            SwingNode swingNode = new SwingNode();
            swingNode.setContent(new JPanel()); // Replace with your Swing component if needed
            swingNode.setContent(new JFXPanel()); // Initialize JavaFX on the EDT

            // Create a JavaFX scene and set the content with the SwingNode
            Scene scene = new Scene(root);
            root.getChildren().add(swingNode);

            aPanel.removeAll(); // Remove the existing components from the panel
            aPanel.setLayout(new BorderLayout());
            aPanel.add(swingNode, BorderLayout.CENTER); // Add the SwingNode
            aPanel.revalidate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



    
}
