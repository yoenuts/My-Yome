import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

public class PaintSceneController {

    @FXML
    private MenuItem ClearAllMI;

    @FXML
    private Menu ClearM;

    @FXML
    private ToggleButton GreyBC;

    @FXML
    private MenuItem backgroundColorMI;

    @FXML
    private ToggleButton blackBC;

    @FXML
    private Canvas canvas;

    @FXML
    private ToggleButton colorBlack;

    @FXML
    private ToggleButton colorBlue;

    @FXML
    private ToggleButton colorBrown;

    @FXML
    private ToggleButton colorGreen;

    @FXML
    private MenuItem colorMI;

    @FXML
    private ToggleButton colorPink;

    @FXML
    private ToggleButton colorPurple;

    @FXML
    private ToggleButton colorRed;

    @FXML
    private ToggleButton colorYellow;

    @FXML
    private Menu customM;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Pane pane;

    @FXML
    private MenuItem undoMI;

    @FXML
    private ToggleButton whiteBC;

}
