import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PlayerMenuController extends GameStart {

	@FXML private Button playButton; // the play button
	
	public void playClicked(ActionEvent e) throws Exception
	{
		//Gets previous window information
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		playGame(window);
		
	}
	
	
}
