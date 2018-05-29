import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ShopMainController extends GameStart
{

	@FXML private Button armorButton;
	@FXML private Button newShipButton;
	@FXML private Button playerMenuButton;
	@FXML private Button cashXButton;
	
	public void armorButtonClicked(ActionEvent e) throws Exception // what happens when armor button is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		loadArmorScreen(window);
	}
	
	public void newShipButtonClicked(ActionEvent e) throws Exception // what happens buy ship button is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		updateBoughtScreen(window);
	}
	
	public void cashXButtonClicked(ActionEvent e) throws Exception // what happens when cash multiplier button is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		loadCashXScreen(window);
	}
	public void playerMenuButtonClicked(ActionEvent e) throws Exception // what happens when player menu Button is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		enterPlayerMenu(window);
	}
}
