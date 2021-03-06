import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import java.util.ArrayList;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class GameStart extends Application
{
	Stage window;
	AllPlayers a;
	
	public static void main(String args[])
	{
		launch(args); //NEED THIS TO RUN PROGRAM
	}
	
	// start(Stage stage) is an abstract method in the Application class which our game extends(is a sub-class of)
	public void start(Stage primaryStage) throws Exception
	{
		a = new AllPlayers();
		window = primaryStage;
		// refers to FXML file where the menu was created
		Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
		// sets the name of the stage to InterSpellar
		window.setTitle("InterSpellar");
		//Sets the scene of the stage to the home menu as specified in the FXML file
		window.setScene(new Scene(root, 850, 476));
		// shows the stage
		window.show(); //NEED THIS TO SEE ANYTHING
	}
	
	public void enterPlayerMenu(Stage window) throws IOException
	{
		// refers to FXML file where player Menu was created
		Parent root = FXMLLoader.load(getClass().getResource("playerMenu.fxml"));
		// sets the scene to the player menu as specified in FXML file
		window.setScene(new Scene(root, 850, 476));
	}
	
	public void playGame(Stage window) throws IOException
	{
		Group root = new Group();
		Scene gameScreen = new Scene(root); // creates the gameScreen scene
		
		Canvas play = new Canvas(850,476); // where you can add all the items(rockets, asteroids, background...)
		root.getChildren().add(play); // adds the canvas to the scene
		
		ArrayList<String> input = new ArrayList<String>(); // takes in the input as Strings
		// we want an arraylist so we can let the player type more than one thing at a time
		// for example we need them to type complete words so we need to add each letter to the input Arraylist
		
		//Moves object left or right when key is pressed
		gameScreen.setOnKeyPressed(
				new EventHandler<KeyEvent>() //handles the event of a key being pressed
				{
					public void handle(KeyEvent e) //event handler
					{
						String code = e.getCode().toString(); // turns key input into string
						if(!input.contains(code)) // if code isn't already in the arraylist, add it
							input.add(code);
					}

				}
				);
		//stop moving object when key is released
		gameScreen.setOnKeyReleased(
				new EventHandler<KeyEvent>()
				{
					public void handle(KeyEvent e)
					{
						String code = e.getCode().toString();
						if(input.contains(code))
							input.remove(code);
					}
				}
				);

		//Adds input as a string for typing part
		gameScreen.setOnKeyTyped(
				new EventHandler<KeyEvent>()
				{
					public void handle(KeyEvent e)
					{
						String code = e.getCode().toString();
						input.add(code);
					}
				}
				);
		
		// Defines the graphcis
		GraphicsContext graph = play.getGraphicsContext2D();
		
		//Creates the players rocket
		Rocket r = AllPlayers.getPlayer().getPrimaryRocket();
		
		// creates an arraylist of asteroid objects
		ArrayList<Asteroids> a = new ArrayList<>();
		
		// adds a few asteroids to start off
		for(int i =0; i < 3; i++)
		{
			Asteroids ast = new Asteroids();
			a.add(ast);
		}
		
		//can't call primitives so i had to create a class
		LongV lastNanoTime = new LongV(System.nanoTime());
		
		//creates the animation which runs at 60 frames per second
		new AnimationTimer()
		{
			double time; //how long since the game started
			double timeX; //time multiplier for speed of asteroids
			double freqA; // frequency of asteroids
			public void handle(long currentNanoTime)
			{
				//makes the background black
				graph.setFill(Color.BLACK);
				//fills the background as black
				graph.fillRect(0, 0, 850, 476);
				
				//how long since the last frame was accessed
				double elapsed = (currentNanoTime - lastNanoTime.getValue())/1000000000.0;
				lastNanoTime.set(currentNanoTime);
				time += elapsed; // keeps track of how long since the game started
				// time multiplier for speed of asteroids
				timeX = 10*(time/2);
				freqA = (time/10)*0.005; // determines frequency of asteroids introduced
				
				if(time%0.5<freqA)
					a.add(new Asteroids());
				r.render(graph);
				
				r.setVelocity(0);
				if(input.contains("LEFT"))
					r.setVelocity(-50);
				if(input.contains("RIGHT"))
					r.setVelocity(20);
				
				if((r.getPosition()<=0&& r.getVelocity()<0) || (r.getPosition()>=785 && r.getVelocity()>0))
					r.setVelocity(0);
				
				r.newPosition(elapsed);
				
				for(Asteroids ast: a)
					ast.render(graph);
				
				for(int i = 0; i < a.size(); i++)
				{
					Asteroids ast = a.get(i);
					ast.setVelocity(timeX);
					ast.newPosition(elapsed);
					if(r.getPosition()-ast.getPositionX()<=50 && r.getPosition()-ast.getPositionX()>=-50 && ast.getPositionY()>=390 && ast.getPositionY()<=470)
					{
						stop();
						AllPlayers.getPlayer().addScore((int)time);
						try {
							gameOverScreen(window);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("I suck");
						}
					}
				}
				
				String scoreDisplay = "Score: " + (int)(time);
				Font f = Font.font( "Arial", FontWeight.BOLD, 30 );
				graph.setFont(f);
				graph.setFill(Color.AQUA);
				graph.fillText(scoreDisplay, 680, 36);
			}
		}.start();
		
		
		window.setScene(gameScreen);
	}
	
	public void gameOverScreen(Stage window) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("endScreen.fxml"));;
		AnchorPane v = new AnchorPane();
		VBox x = new VBox(20);
		Label s = new Label("Score: " + AllPlayers.getPlayer().getLatestScore());
		s.setFont(new Font("Arial", 32));
		s.setTextFill(Color.BLUE);
		Label hi = new Label("High Score: " + AllPlayers.getPlayer().getHighScore());
		hi.setFont(new Font("Arial", 32));
		hi.setTextFill(Color.RED);
		x.getChildren().addAll(hi, s);
		v.getChildren().addAll(root, x);
		window.setScene(new Scene(v,850,476));
	}
	
}
