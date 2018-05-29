import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ArmorMenuController extends GameStart 
{
	

	@FXML private Button smallButton;
	@FXML private Button mediumButton;
	@FXML private Button largeButton;
	@FXML private Button backToShopButton;
	
	public void smallButtonClicked(ActionEvent e) throws Exception // what happens when small shield is clicked
	{

		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		if(AllPlayers.getPlayer().getCoins()>5000 && AllPlayers.getPlayer().getPrimaryRocket().getArmor()==0)
		{
			AllPlayers.getPlayer().removeCoins(5000);
			AllPlayers.getPlayer().getPrimaryRocket().addArmor();
			loadArmorScreen(window);
		}
		
	}
	
	public void mediumButtonClicked(ActionEvent e) throws Exception // what happens when medium shield is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();

		if(AllPlayers.getPlayer().getCoins()>10000 && AllPlayers.getPlayer().getPrimaryRocket().getArmor()==1)
		{
			AllPlayers.getPlayer().removeCoins(10000);
			AllPlayers.getPlayer().getPrimaryRocket().addArmor();
			loadArmorScreen(window);
		}
	}
	public void largeButtonClicked(ActionEvent e) throws Exception // what happens when large shield is clicked 
	{	
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();

		if(AllPlayers.getPlayer().getCoins()>20000 && AllPlayers.getPlayer().getPrimaryRocket().getArmor()==2)
		{
			AllPlayers.getPlayer().removeCoins(20000);
			AllPlayers.getPlayer().getPrimaryRocket().addArmor();
			loadArmorScreen(window);
		}
	}
	
	public void backToShopButtonClicked(ActionEvent e) throws Exception // what happens when back is clicked
	{
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		enterShopMain(window);
	}
	

}
