import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BuyShipController extends GameStart
{
	@FXML private Button ApolloButton;
	@FXML private Button FXWingButton;
	@FXML private Button BlackOneButton;
	@FXML private Button MilleniumHawkButton;
	@FXML private Button DebtStarButton;
	@FXML private Button playerMenuButton;
	
	public void buyApollo(ActionEvent e) throws Exception // buys the base ship
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();

		AllPlayers.getPlayer().changePrimaryRocket(0);
		updateBoughtScreen(window);
	}
	
	public void buyFXWing(ActionEvent e) throws Exception // buys the FXWing
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		if(!AllPlayers.getPlayer().getRockets().get(1).getBought())
		{
			if(AllPlayers.getPlayer().getCoins()>=5000)
			{
				AllPlayers.getPlayer().buyFXWing();
				AllPlayers.getPlayer().removeCoins(5000);
				AllPlayers.getPlayer().changePrimaryRocket(1);
				updateBoughtScreen(window);
			}
		}
		else
		{
			AllPlayers.getPlayer().changePrimaryRocket(1);
			updateBoughtScreen(window);
		}
	}
	
	public void buyBlackOne(ActionEvent e) throws Exception // buys the Black One
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		if(!AllPlayers.getPlayer().getRockets().get(2).getBought())
		{
			if(AllPlayers.getPlayer().getCoins()>=10000)
			{
				AllPlayers.getPlayer().buyBlackOne();
				AllPlayers.getPlayer().removeCoins(10000);
				AllPlayers.getPlayer().changePrimaryRocket(2);
				updateBoughtScreen(window);
			}
		}
		else
		{
			AllPlayers.getPlayer().changePrimaryRocket(2);
			updateBoughtScreen(window);
		}
	}
	
	public void buyMilleniumHawk(ActionEvent e) throws Exception // buys Millenium Hawk
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		if(!AllPlayers.getPlayer().getRockets().get(3).getBought())
		{
			if(AllPlayers.getPlayer().getCoins()>=50000)
			{
				AllPlayers.getPlayer().buyMilleniumHawk();;
				AllPlayers.getPlayer().removeCoins(50000);
				AllPlayers.getPlayer().changePrimaryRocket(3);
				updateBoughtScreen(window);
			}
		}
		else
		{
			AllPlayers.getPlayer().changePrimaryRocket(3);
			updateBoughtScreen(window);
		}
	}
	
	public void buyDebtStar(ActionEvent e) throws Exception // buys the debt star
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		if(!AllPlayers.getPlayer().getRockets().get(4).getBought())
		{
			if(AllPlayers.getPlayer().getCoins()>=99999)
			{
				AllPlayers.getPlayer().buyDebtStar();;
				AllPlayers.getPlayer().removeCoins(99999);
				AllPlayers.getPlayer().changePrimaryRocket(4);
				updateBoughtScreen(window);
			}
			else
			{
				AllPlayers.getPlayer().changePrimaryRocket(4);
				updateBoughtScreen(window);
			}
		}
	}
	
	public void playerMenuButtonClicked(ActionEvent e) throws Exception // what happens when back to player menu is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		enterPlayerMenu(window);
	}
}
