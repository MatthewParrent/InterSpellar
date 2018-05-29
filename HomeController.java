import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import java.io.IOException;

// This class is a controller of the FMXL file for home
// It controls what happens when the "Enter" button is clicked
public class HomeController extends GameStart
{
	@FXML private TextField nameTextField;
	
	// ActionEvent gets event information
	// In this case clicking Enter
	public void enterClicked(ActionEvent event) throws Exception // what happens when enter is clicked
	{
		// gets window information from the event
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		if(!nameTextField.getText().equals(""))
		{	Player p = new Player(nameTextField.getText());
			enterPlayerMenu(window);
		}
	}
	
}
