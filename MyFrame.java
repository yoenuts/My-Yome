import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javafx.embed.swing.JFXPanel;
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

        Menu pRoom = new Menu("Paint Room");
        pRoom.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
                openFxmlFile("PaintScene.fxml");
                System.out.println("Print me");
            }
        });
        Menu exit = new Menu("Bye");
        menuBar.add(pRoom);
        menuBar.add(exit);

        this.setMenuBar(menuBar);
    }

    private void openFxmlFile(String filename) {
        try {
            SwingUtilities.invokeLater(() -> {
                JFXPanel fxPanel = new JFXPanel(); // Initialize JavaFX on the EDT
                System.out.println("open fxml is working");
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filename));
                    Pane root = fxmlLoader.load();
                    aPanel.removeAll(); // Remove the existing components from the panel
                    aPanel.setLayout(new BorderLayout());
                    aPanel.add(fxPanel, BorderLayout.CENTER); // Add the JFXPanel
                    aPanel.revalidate();
    
                    // Create a JavaFX scene and set the content
                    Scene scene = new Scene(root);
                    fxPanel.setScene(scene);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
