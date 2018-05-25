import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SelectShipController extends GameStart
{

	@FXML private Button playerMenuButton;
	@FXML private Button ApolloButton;
	@FXML private Button BlackOneButton;
	@FXML private Button FXWingButton;
	@FXML private Button MilleniumHawkButton;
	@FXML private Button DebtStarButton;
	
	public void playerMenuButtonClicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		enterPlayerMenu(window);
	}
	
	public void ApolloButtonClicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		AllPlayers.getPlayer().changePrimaryRocket(0);
		selectShipScreen(window);
	}
	
	public void BlackOneButtonClicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		AllPlayers.getPlayer().changePrimaryRocket(2);
		selectShipScreen(window);

	}
	
	public void FXWingButtonClicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		AllPlayers.getPlayer().changePrimaryRocket(1);
		selectShipScreen(window);

	}
	
	public void MilleniumHawkButtonClicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		AllPlayers.getPlayer().changePrimaryRocket(3);
		selectShipScreen(window);

	}
	
	public void DebtStarButtonClicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		AllPlayers.getPlayer().changePrimaryRocket(4);
		selectShipScreen(window);

	}
}
