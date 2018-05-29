import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TypeAsker
{
	static Stage window;
	public TypeAsker()
	{
		window = new Stage();
		display();
	}
	public void display() // displays the alert box asking to type a certain term
	{
	//	window = new Stage();
				
		// Blocks playing the game without closing the window
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Interspellar");
		window.setWidth(650);
		window.setHeight(250);
		
		Words w = new Words();
		String word = w.getWord();
		Label s = new Label("Type the word below and hit ENTER to go back to game.");
		Label wo = new Label(word);
		TextField t = new TextField();
		VBox v = new VBox(10);
		v.getChildren().addAll(s, wo, t);
		v.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(v, 250, 650);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
				{
					public void handle(KeyEvent e)
					{
						String code = e.getCode().toString();
						checkClose(code, t, word, window, false);
							
					}
				});
		
		window.setOnCloseRequest(e->{e.consume();
				checkClose("no", t, word, window, false);
		});
		
		window.setScene(scene);
		window.show();
	}
	
	public void checkClose(String code, TextField t, String word, Stage window, boolean b) // checks if window should be closed
	{
		if(code.equals("ENTER")&& t.getText().contains(word) || b)
		{	
			window.close();
		
		}
	}
	
	public void close() // closes the window
	{
		window.close();
	}
}
