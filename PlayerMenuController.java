import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PlayerMenuController extends GameStart {

	@FXML private Button playButton; // the play button
	@FXML private Button mainMenuButton; // the main menu Button
	@FXML private Button shopButton;
	@FXML private Button selectShipButton;
	
	public void playClicked(ActionEvent e) throws Exception // what happens when play is clicked
	{
		//Gets previous window information
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		playGame(window);
		
	}
	
	public void mainMenuClicked(ActionEvent e) throws Exception // what happens when main menu is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		start(window);
	}
	
	public void shopButtonClicked(ActionEvent e) throws Exception // what happens when shop is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		enterShopMain(window);
	}
	
	public void selectShipButtonClicked(ActionEvent e) throws Exception // what happens when select ship is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		selectShipScreen(window);
	}
	
	public void highScoresClicked(ActionEvent e) throws Exception // what happens when high scores is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		highScoresScreen(window);
	}
}
