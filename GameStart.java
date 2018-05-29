import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.Collections;

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

import java.awt.Button;
import java.io.IOException;

public class GameStart extends Application
{
	Stage window;
	private static AllPlayers a;
	
	public static void main(String args[])
	{
		a = new AllPlayers();
		launch(args); //NEED THIS TO RUN PROGRAM
	}
	
	// start(Stage stage) is an abstract method in the Application class which our game extends(is a sub-class of)
	public void start(Stage primaryStage) throws Exception //loads the game's first screen
	{
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
	
	public void enterPlayerMenu(Stage window) throws IOException //loads the player menu
	{
		// refers to FXML file where player Menu was created
		Parent root = FXMLLoader.load(getClass().getResource("playerMenu.fxml"));
		// sets the scene to the player menu as specified in FXML file
		window.setScene(new Scene(root, 850, 476));
	}
	
	public void playGame(Stage window) throws IOException // loads the game itself
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
		
		// Defines the graphics
		GraphicsContext graph = play.getGraphicsContext2D();
		
		//Creates the players rocket
		Rocket r = AllPlayers.getPlayer().getPrimaryRocket();
		
		// creates an arraylist of asteroid objects
		ArrayList<Asteroids> a = new ArrayList<>();
		
		//creates an arraylist of stars
		ArrayList<Stars> s = new ArrayList<>();
		// adds a few asteroids to start off
		for(int i =0; i < 3; i++)
		{
			Asteroids ast = new Asteroids();
			a.add(ast);
		}
		
		// adds a few stars at the beginning
		for(int i = 0; i < 3; i++)
		{
			s.add(new Stars());
		}
		
		//can't call primitives so i had to create a class
		LongV lastNanoTime = new LongV(System.nanoTime());
		
		//gets the armor
		LongV hits = new LongV(AllPlayers.getPlayer().getPrimaryRocket().getArmor());
		
		//generate random type request
		LongV ran =  new LongV((int)(Math.random()*700));
		
		ArrayList<TypeAsker> ty = new ArrayList<>();
		//creates the animation which runs at 60 frames per second
		new AnimationTimer()
		{
			double time; //how long since the game started
			double timeX; //time multiplier for speed of asteroids
			double freqA; // frequency of asteroids
			double d;
			int turn;
			public void handle(long currentNanoTime)
			{
				//makes the background black
				graph.setFill(Color.BLACK);
				//fills the background as black
				graph.fillRect(0, 0, 850, 476);
				int cool;
				if(time<=150)
					cool = (int)(Math.random()*(700-time));		
				else
					cool = (int)(Math.random()*550);
				//how long since the last frame was accessed
				double elapsed = (currentNanoTime - lastNanoTime.getValue())/1000000000.0;
				lastNanoTime.set(currentNanoTime);
				time += elapsed; // keeps track of how long since the game started
				// time multiplier for speed of asteroids
				timeX = 10*(time/2);
				freqA = (time/10)*0.005; // determines frequency of asteroids introduced
				
				if((cool != ran.getValue() && d==0) || (ty.size()>0 && d>5))
				{
					if(time%0.5<freqA)
						a.add(new Asteroids());
					r.render(graph);
					
					if(time%0.5<0.003)
						s.add(new Stars());
					
					r.setVelocity(0);
					if(input.contains("LEFT"))
						r.setVelocity(-45);
					if(input.contains("RIGHT"))
						r.setVelocity(45);
					
					if((r.getPosition()<=0&& r.getVelocity()<0) || (r.getPosition()>=785 && r.getVelocity()>0))
						r.setVelocity(0);
					
					r.newPosition(elapsed);
					
					// draws asteroid
					for(Asteroids ast: a)
						ast.render(graph);
					
					// draws star
					for(Stars st: s)
					{	
						st.render(graph);
						st.newPosition(elapsed);
					}
					
					for(int i = 0; i < a.size(); i++)
					{
						Asteroids ast = a.get(i);
						ast.setVelocity(timeX);
						ast.newPosition(elapsed);										
						// checks to see if hitting asteroid
						if(r.getPosition()-ast.getPositionX()<= AllPlayers.getPlayer().getPrimaryRocket().getHitX() && r.getPosition()-ast.getPositionX()>=(0-AllPlayers.getPlayer().getPrimaryRocket().getHitX()) && ast.getPositionY()>= AllPlayers.getPlayer().getPrimaryRocket().getHitY() && ast.getPositionY()<=455)
						{
							hits.removeOne();
							a.remove(i);
							if(hits.getValue()<0)
							{
								for(int l = 0;l<ty.size();l++)
								{
									ty.get(l).close();
								}
								stop();
								AllPlayers.getPlayer().addScore((int)time);
								try {
									gameOverScreen(window);
								} catch (IOException e) {
									System.out.println("I suck");
								}
								break;
							}
						}
						
					}
				
				
					for(int i = 0; i < s.size(); i++)
					{
						Stars st = s.get(i);
						st.setVelocity(time/1.5);
						st.newPosition(elapsed);										
						
					
					}
				}
				else
				{
					r.setVelocity(0);
					if(input.size()>0)
						input.remove(input.size()-1);
					turn++;
					d+= elapsed;
					if(turn == 1)
					{
							ty.add(new TypeAsker());
					}
					if(d>5)
					{
						turn = 0;
						d=0;
					}
				}
				String scoreDisplay = "Score: " + (int)(time);
				Font f = Font.font( "Arial", FontWeight.BOLD, 30 );
				graph.setFont(f);
				graph.setFill(Color.AQUA);
				graph.fillText(scoreDisplay, 680, 36);
				String life = "Armor: " + (int)(hits.getValue());
				graph.setFont(f);
				graph.setFill(Color.AQUA);
				graph.fillText(life, 10, 36);
			}
		}.start();
		
		
		window.setScene(gameScreen);
	}
	
	public void gameOverScreen(Stage window) throws IOException // loads the game over screen
	{
		Parent root = FXMLLoader.load(getClass().getResource("endScreen.fxml"));
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
	
	public void enterShopMain(Stage window) throws IOException // loads shop's main screen
	{
		Parent root = FXMLLoader.load(getClass().getResource("shopmain.fxml"));
		AnchorPane stack = new AnchorPane();
		Label s = new Label("Coins: " + AllPlayers.getPlayer().getCoins());
		s.setFont(new Font("Arial Black", 25));
		s.setTextFill(Color.LIGHTGREEN);
		stack.getChildren().addAll(root, s);
		window.setScene(new Scene(stack,850,476));
	}
	
	public void selectShipScreen(Stage window) throws IOException // loads the select ship screen
	{
		Parent root = FXMLLoader.load(getClass().getResource("selectShipScreen.fxml"));
		AnchorPane v = new AnchorPane();
		Label s = new Label("Current Rocket: " + AllPlayers.getPlayer().getPrimaryRocketName());
		s.setFont(new Font("Arial", 20));
		s.setTextFill(Color.ORANGE);
		String text = "Rockets Owned: ";
		for(int i = 0; i < 5; i++)
		{
			if(AllPlayers.getPlayer().getRockets().get(i).getBought())
			{
				text += AllPlayers.getPlayer().getRockets().get(i).getRocketName() + "|";
			}
		}
		Label temp = new Label(text);
		temp.setFont(new Font("Arial", 20));
		temp.setTextFill(Color.ORANGE);
		VBox d = new VBox(20);
		d.getChildren().addAll(s, temp);
		v.getChildren().addAll(root, d);
		window.setScene(new Scene(v, 850, 476));
	}
	
	public void highScoresScreen(Stage window) throws IOException //loads high scores screen
	{
		Parent root = FXMLLoader.load(getClass().getResource("highScoresScreen.fxml"));
		BorderPane p = new BorderPane();
		p.setBottom(null);
		VBox v = new VBox(20);
		ArrayList<ScoreSorter> scores = new ArrayList<ScoreSorter>();
		for(int i = 0; i < AllPlayers.getPlayers().size(); i++)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int k = 0; k < AllPlayers.getPlayers().get(i).getScores().size(); k++)
			{
				temp.add(AllPlayers.getPlayers().get(i).getScores().get(k));
			}
			int numSco = 0;
			int size = temp.size();
			int highIndex = 0;
			while(numSco<5 && numSco<size)
			{
			
				int high = 0;
				for(int j = 0; j < temp.size(); j++)
				{
					
					if(temp.get(j)>high)
					{		
						high = temp.get(j);
						highIndex = j;
					}
					
				}
				temp.remove(highIndex);
				scores.add(new ScoreSorter(AllPlayers.getPlayers().get(i).getName(), high));
				numSco++;
				
			}
		}
		
		Collections.sort(scores);
		
		int highScores = 1;
		String temp = "";
		
		while(highScores <= 5 && (highScores-1) <scores.size())
		{
			
			temp += highScores + ". " + scores.get(highScores-1).getName() + ": " + scores.get(highScores-1).getScore() + "\n";   
			highScores++;
		}
		
		Label s = new Label("High Scores \n" + temp);
		s.setFont(new Font("Arial", 25));
		s.setTextFill(Color.WHITE);
		p.setCenter(s);
		AnchorPane stack = new AnchorPane();
		AnchorPane.setLeftAnchor(p, 350.0);
		stack.getChildren().addAll(root, p);

		
		
		window.setScene(new Scene(stack, 850,476));
	}
	
	public void updateBoughtScreen(Stage window) throws IOException // loads the buy a ship screen
	{
		Parent root = FXMLLoader.load(getClass().getResource("buyShipScreen.fxml"));
		AnchorPane stack = new AnchorPane();
		Label s = new Label("Coins: " + AllPlayers.getPlayer().getCoins());
		s.setFont(new Font("Arial Black", 25));
		s.setTextFill(Color.LIGHTGREEN);
		String text = "Rockets Owned: ";
		for(int i = 0; i < 5; i++)
		{
			if(AllPlayers.getPlayer().getRockets().get(i).getBought())
			{
				text += AllPlayers.getPlayer().getRockets().get(i).getRocketName() + "|";
			}
		}
		Label temp = new Label(text);
		temp.setFont(new Font("Arial", 20));
		temp.setTextFill(Color.ORANGE);
		VBox d = new VBox(20);
		d.getChildren().addAll(s, temp);
		stack.getChildren().addAll(root, d);
		window.setScene(new Scene(stack,850,476));
	}
	
	public void loadArmorScreen(Stage window) throws IOException // loads the armor screen
	{
		Parent root = FXMLLoader.load(getClass().getResource("armorScreen.fxml"));
		AnchorPane stack = new AnchorPane();
		VBox v = new VBox(1);
		Label s = new Label("Coins: " + AllPlayers.getPlayer().getCoins());
		s.setFont(new Font("Arial Black", 25));
		s.setTextFill(Color.LIGHTGREEN);
		Label temp = new Label("You are upgrading the " + AllPlayers.getPlayer().getPrimaryRocketName() + ". Go to Select Ship to upgrade a different one. ");
		temp.setFont(new Font("Arial Black", 15));
		temp.setTextFill(Color.LIGHTGREEN);
		Label temp1 = new Label("Current Armor: " + AllPlayers.getPlayer().getPrimaryRocket().getArmor() + ". Must buy previous shield to buy a better one.");
		temp1.setFont(new Font("Arial Black", 15));
		temp1.setTextFill(Color.LIGHTGREEN);
		v.getChildren().addAll(s, temp, temp1);
		stack.getChildren().addAll(root, v);
		window.setScene(new Scene(stack,850,476));
	}
	
	public void loadCashXScreen(Stage window) throws IOException //loads the cash multiplier screen
	{
		Parent root = FXMLLoader.load(getClass().getResource("cashXScreen.fxml"));
		AnchorPane stack = new AnchorPane();
		VBox v = new VBox(1);
		Label s = new Label("Coins: " + AllPlayers.getPlayer().getCoins());
		s.setFont(new Font("Arial Black", 25));
		s.setTextFill(Color.LIGHTGREEN);
		Label temp = new Label("Current Cash Multiplier: " + AllPlayers.getPlayer().getCashX());
		temp.setFont(new Font("Arial Black", 15));
		temp.setTextFill(Color.LIGHTGREEN);
		v.getChildren().addAll(s, temp);
		stack.getChildren().addAll(root, v);
		window.setScene(new Scene(stack,850,476));
	}
	
}
