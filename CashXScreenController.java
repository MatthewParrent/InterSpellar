import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CashXScreenController extends GameStart
{
	@FXML private Button playerMenuButton;
	@FXML private Button x11Button;
	@FXML private Button x13Button;
	@FXML private Button x15Button;
	@FXML private Button x17Button;
	
	public void playerMenuButtonClicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		enterPlayerMenu(window);
	}
	
	public void x11Clicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		if(AllPlayers.getPlayer().getCoins()>=1500 && AllPlayers.getPlayer().getCashX()<1.1)
		{
			AllPlayers.getPlayer().updateCashX(1.1);
			AllPlayers.getPlayer().removeCoins(1500);
		}
		loadCashXScreen(window);
	}
	public void x13Clicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		if(AllPlayers.getPlayer().getCoins()>=5000 && AllPlayers.getPlayer().getCashX()<1.3)
		{
			AllPlayers.getPlayer().updateCashX(1.3);
			AllPlayers.getPlayer().removeCoins(5000);
		}
		loadCashXScreen(window);
	}
	
	public void x15Clicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		if(AllPlayers.getPlayer().getCoins()>=12500 && AllPlayers.getPlayer().getCashX()<1.5)
		{
			AllPlayers.getPlayer().updateCashX(1.5);
			AllPlayers.getPlayer().removeCoins(12500);
		}
		loadCashXScreen(window);
	}
	public void x17Clicked(ActionEvent e) throws Exception
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		if(AllPlayers.getPlayer().getCoins()>=40000 && AllPlayers.getPlayer().getCashX()<1.7)
		{
			AllPlayers.getPlayer().updateCashX(1.7);
			AllPlayers.getPlayer().removeCoins(40000);
		}
		loadCashXScreen(window);	}
}
