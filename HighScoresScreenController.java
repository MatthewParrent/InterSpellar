import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HighScoresScreenController extends GameStart
{
	@FXML private Button playerMenuButton;
	
	public void playerMenuButtonClicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		enterPlayerMenu(window);
	}
}
