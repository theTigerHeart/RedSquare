package rSqurGame;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;

import javax.swing.*;
import java.util.Random;

public class RedSquare extends JComponent implements KeyListener, MouseListener, Runnable{
	
	static Font font = new Font("Courier",Font.PLAIN,20);   //Fonts and Counter Strings along with their unique variables
	static String Score = "";
	static String Time = "";
	static String HighScore = "";
	static String TotalDeaths = "";
		int tDeaths = 0;
	static String Deaths = "";
		int deaths = 0;
	static String Last = "";
		int last = 0;
	static String TimePlayed = "";
	
	static char AccelaWobble = 1;
	
	boolean Start = true;              //function Booleans
	static boolean timeSet = false;
	static boolean goSurvival = false; //Survival mode
	static boolean menu = true; //level bumps
	static boolean a = false; //movement
	static boolean d = false;
	static boolean w = false;
	static boolean s = false;
	static boolean run = true;//pause
	static boolean toggle = false;//timer reset
	
	static int level = 0;                   //Int's for either Strings or basic functions, like chooseLevel()
	static int winning = 0;
	static int winCount = 1;
	int shift = 1;
	static int score = 0;
	int highScore = 0;
	int moves = 0;
	int goPurple = 1;
	int r = 1;
	
	static int pSpawn = 0;    //Survival mode spawners
	static int gSpawn = 0;
	static int ySpawn = 0;
	
	double timeNow = 0;     //computation variables, usually for time
	static double timeLag = 0;
	double timeT = 0;
	static double seconds = 0;
	double secondsPreRound = 0;
	double time = 0;
	static double difficulty = .5;
	double tries = 1;
	
	static int windowX = 320;
	static int windowY = 240;
	public static int count = 0;
	
	long start = 0;                       //Program function variables
	long tick_end_time;
	long tick_duration;
	long sleep_duration;
	
	static double modifier = .5; //Acceleration speed, level dependant
	
	static final int MIN_SLEEP_TIME = 10;              
	static final int MAX_FPS = 20;
	static final int MAX_MS_PER_FRAME = 1000 / MAX_FPS;
	float fps = 0;
	
	static ArrayList<Object> mainList = new ArrayList<Object>();              //Array list for all pieces of levels
	static ArrayList<MouseButton> buttonList = new ArrayList<MouseButton>();  //Array list for all Level buttons
	static ArrayList<MouseButton> oFunctions = new ArrayList<MouseButton>();  //Array list for all non-level button functions
	static ArrayList<Object> counters = new ArrayList<Object>();              //Array list for all counters to be displayed
	
	public static synchronized void main(String args[]){
		RedSquare r = new RedSquare();
		JFrame f = new JFrame("");
		f.addWindowListener(new WindowAdapter(){
			public void WindowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		f.setBackground(Color.white);
		f.setTitle("Red Square Game");
		f.setSize(windowX*2, windowY*2);
		f.add(r);
		f.addKeyListener(r);
		f.addMouseListener(r);
		f.setResizable(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		r.run();
		SoundEffect.init();
		SoundEffect.volume = SoundEffect.Volume.LOW;
		/*Sound Effects Note:
		 * While running through Eclipse, the .wav files cannot be accessed.
		 * Each sound effect's file must be in the same folder as the exported
		 * jar. While testing in edit, comment out sound commands
		 */
	}
	public void run() {
		//Stuff here happens once upon creation of window.
		//SoundEffect.HIT.play();
		GameFunctions g = new GameFunctions();
		mainList.add(new squares.Square( (windowX - 10), (windowY - 10), 20, 20, 3, 3));   //Set field
		mainList.get(0).red = 255;
		mainList.get(0).green = 0;
		mainList.get(0).blue = 0;
		/*NOTES FOR CREATING A NEW LEVEL
		 * Step 1: Create new class in the 'levels' package named 'LevelX'
		 * Step 2: Add the the 'instanceof' recognition in the mousePressed and levelCollisions methods
		 * Step 3: Add the level button to the buttonList.
		 * Step 4: Add hotkey in keyPressed.
		 * Step 5: Go to chooseLevel and build from the template the desired blocks
		 */
		
		buttonList.add(new levels.LevelOne( 10, 10, 80, 20));       //Set Menu Display
		buttonList.add(new levels.LevelTwo( 10, 40, 80, 20));
		buttonList.add(new levels.LevelThree( 10, 70, 80, 20));
		buttonList.add(new levels.LevelFour( 10, 100, 80, 20));
		buttonList.add(new levels.LevelFive( 10, 130, 80, 20));
		buttonList.add(new levels.LevelSix( 10, 160, 80, 20));
		buttonList.add(new levels.LevelSeven( 10, 190, 80, 20));
		          												//Set other buttons
		oFunctions.add(new SurvivalButton( 10, 430, 100, 20)); //0
		oFunctions.add(new MenuButton( 280, 230, 80, 20));     //1
		oFunctions.get(1).on = false;
		oFunctions.add(new PauseButton( 560, 430, 70, 20));    //2
		oFunctions.get(2).on = false;
		
		oFunctions.add(new Instructions( 520, 355, 109, 94));  //3
		
		counters.add(new SurvivalCounter( 550, 10));           //Set counters 
		counters.get(0).on = false;
		counters.add(new LevelCounter(550, 10));
		counters.get(1).on = false;
		counters.add(new MenuCounter( 540, 10));
		
		g.resetSpawn();
		while(true){
			Timer time = new Timer();
			time.TimerSeconds();
			if (run == true) {                        //Initialize and update all the Strings for counters
				shift = shift * (-1);
				Score = String.valueOf(score);
				Time = String.valueOf(seconds);
				HighScore = String.valueOf(highScore);
				Deaths = String.valueOf(deaths);
				TotalDeaths = String.valueOf(tDeaths);
				TimePlayed = String.valueOf(time.TimerSeconds());
				Last = String.valueOf(last);
				
				if( toggle == true) {                  //Resets the Timer
					timeNow = time.TimerSeconds();
					toggle = false;
				}
				timeT = time.TimerSeconds() - timeNow;
					secondsPreRound = Math.round(timeT * 10);
					seconds = secondsPreRound/10;
					
					for( int i = 1; i < mainList.size(); i++) {                 //Advance time for squares
						if( mainList.get(i) instanceof squares.PurpleSquare ||
							mainList.get(i) instanceof squares.GreenSquare ||
							mainList.get(i) instanceof squares.SpeedKey ||
							mainList.get(i) instanceof squares.SlowKey) {
							mainList.get(i).time = seconds;
						}
					}
		
			if( (mainList.get(0).x + mainList.get(0).with) > (windowX*2) ) {    //Right collision
				g.chooseLevel();
				a = false;
				d = false;
				w = false;
				s = false;
				System.out.println("loser");
				tDeaths++;
				deaths++;
			}
			if( (mainList.get(0).y + 2 * mainList.get(0).hite) > (windowY*2) ) {    //Bottom collision
				g.chooseLevel();
				a = false;
				d = false;
				w = false;
				s = false;
				System.out.println("loser");
				tDeaths++;
				deaths++;
			}
			if( mainList.get(0).x < 0){     //Left collision
				g.chooseLevel();
				a = false;
				d = false;
				w = false;
				s = false;
				System.out.println("loser");
				tDeaths++;
				deaths++;
			}
			if( mainList.get(0).y < 0){     //Top collision
				g.chooseLevel();
				a = false;
				d = false;
				w = false;
				s = false;
				System.out.println("loser"); 
				tDeaths++;
				deaths++;
			}
			if( menu == true) {
				g.levelCollisions();
			}else{    //Normal game function when not in Menu 
				for(int p = 1; p < mainList.size(); p++){
					boolean xc = false;
					boolean yc = false;
					if( (mainList.get(p).x + mainList.get(p).with)  >= mainList.get(0).x && 
						 mainList.get(p).x  <= (mainList.get(0).x + mainList.get(0).with)){
							xc = true;
					}
					if( (mainList.get(p).y + mainList.get(p).hite)  >= mainList.get(0).y && 
						 mainList.get(p).y  <= (mainList.get(0).y + mainList.get(0).hite)){
							yc = true;
					}
					
					if( xc == true && yc ==true) {
						if( mainList.get(p) instanceof squares.YellowSquare)   {
							System.out.println("yellow");
								if( goSurvival) {                  //Survival scoring Squares
									score += 10;
									mainList.remove(p);
								}else{
									System.out.println("good");
								winning++;
								mainList.remove(p);
								
								if( winning == winCount) {                //Multi objective victory
									System.out.println("winner!");
									toggle = true;
									a = false;
									d = false;
									s = false;
									w = false;
										level += 1;
										deaths = 0;
										g.chooseLevel();
								}
								}
							}else{  //if yellow square
							if(mainList.get(p) instanceof squares.PurpleSquare && mainList.get(p).on == true
								&& mainList.get(p).use > 0 && mainList.get(p).time > mainList.get(p).timeLag + 2) {
									mainList.get(p).timeLag = mainList.get(p).time;
									moves = 0;
									score += 3;
									mainList.get(p).use = mainList.get(p).use - 1;
									mainList.get(0).Vx = 3 + (modifier * moves * moves * moves);
									mainList.get(0).Vy = 3 + (modifier * moves * moves * moves);
					
								mainList.get(0).red = 255;
								mainList.get(0).green = 0;
								mainList.get(0).blue = 0;
									if(mainList.get(p).use <= 0) {
										mainList.get(p).on = false;
									}
							}
							if(mainList.get(p) instanceof squares.GreenSquare && mainList.get(p).on == true
									&& mainList.get(p).use > 0 && mainList.get(p).time > mainList.get(p).timeLag + 2) {    //GreenSquare draws an orange square
										mainList.get(p).timeLag = mainList.get(p).time;
										moves = 0;
										score += 13;
										mainList.get(p).use -= 1;
										mainList.get(0).Vx += 4;
										mainList.get(0).Vy += 4;
											if(mainList.get(0).red > 5 ) {
												mainList.get(0).red -= 30;
											}
											if(mainList.get(0).green < 250 ) {
												mainList.get(0).green += 5;
											}
											if(mainList.get(0).blue < 215) {
												mainList.get(0).blue += 40;
											}else{
												mainList.get(0).blue = 255;
											}
											if(mainList.get(p).use <= 0) {
												mainList.get(p).on = false;
											}
								}
						if( mainList.get(p) instanceof squares.WallBuild || mainList.get(p) instanceof squares.Wall 
							|| mainList.get(p) instanceof squares.DodgeBlock) {
						System.out.println("loser");
							tDeaths++;
							deaths++;
							g.chooseLevel();
							a = false;
							d = false;
							w = false;
							s = false;
						}
						if( mainList.get(p) instanceof squares.SpeedKey && mainList.get(p).on == true) {
							if(mainList.get(p).time > mainList.get(p).timeLag + 2) {
									mainList.get(p).use -= 1;
								mainList.get(p).timeLag = mainList.get(p).time; 
								mainList.get(p + mainList.get(p).sD).Vx += mainList.get(p).sX;
								mainList.get(p + mainList.get(p).sD).Vy += mainList.get(p).sY;
								mainList.get(p + mainList.get(p).sD).dx1 = mainList.get(p).dx1;
								mainList.get(p + mainList.get(p).sD).dy1 = mainList.get(p).dy1;
								mainList.get(p + mainList.get(p).sD).dx2 = mainList.get(p).dx2;
								mainList.get(p + mainList.get(p).sD).dy2 = mainList.get(p).dy2;
									if(mainList.get(p).use <= 0) {
										mainList.get(p).on = false;
									}
							}
							}
						if( mainList.get(p) instanceof squares.SlowKey && mainList.get(p).on == true) {
							if( mainList.get(p).time > mainList.get(p).timeLag + 2) {
									mainList.get(p).use -= 1;
								mainList.get(p).timeLag = mainList.get(p).time;
								mainList.get(p + mainList.get(p).sD).Vx -= mainList.get(p).sX;
								mainList.get(p + mainList.get(p).sD).Vy -= mainList.get(p).sY;
								mainList.get(p + mainList.get(p).sD).dx1 = mainList.get(p).dx1;
								mainList.get(p + mainList.get(p).sD).dy1 = mainList.get(p).dy1;
								mainList.get(p + mainList.get(p).sD).dx2 = mainList.get(p).dx2;
								mainList.get(p + mainList.get(p).sD).dy2 = mainList.get(p).dy2;
									if(mainList.get(p).use <= 0) {
										mainList.get(p).on = false;
									}
							}
							}
						}
					}
				}
			}       //Basic Level functions end
				
			if( goSurvival == true) {
					counters.get(1).on = false;
						//secondsPreRound = Math.round(timeT * 10);
						//seconds = secondsPreRound/10;
						if( seconds >= timeLag + 1) {
							score += 1 + (mainList.get(0).Vx / 30);
							timeLag = seconds;
						}
						if( score >= highScore) {
							highScore = score;
						}
					last = score;    //Score System, for Last score and High score
					modifier = .2;
					tries += .5;                        //Increases chance of Square spawn when one hasn't 
					difficulty = difficulty + .001;     //Difficulty ramping
					Random random = new Random();
					double r = random.nextDouble() * 100;   //Variables for checking for spawn
					double go = 1.15 * tries * difficulty;
						if( r <= go) {
							tries = 1;
							//SoundEffect.POP.play();
							double type = random.nextDouble() * 110;
							if( type >= 18) {                                  //Spawn left side
								goPurple ++;
								double rW = (random.nextDouble() * 30) + (8 * difficulty);
								double rH = (random.nextDouble() * 30) + (8 * difficulty);
								double rY = random.nextDouble() * 440;
								double rVx = random.nextDouble() * 10 + 1;
								double rVy = random.nextDouble() * 4 + 1;
								mainList.add(new squares.DodgeBlock( 0, rY, rW, rH, rVx, rVy * shift));
							}
							if( type > 9 && type <= 18) {
								double rW = (random.nextDouble() * 30) + 10;
								double rH = (random.nextDouble() * 30) + 10;
								double rY = random.nextDouble() * 440;
								double rVx = random.nextDouble() * 10 + 1;
								double rVy = random.nextDouble() * 4 + 1;
								mainList.add(new squares.YellowSquare( 0, rY, rW, rH, rVx, rVy * shift, 0, 0, 650-rW, 440-rH));
							}
							if( type > 2 && type <= 9){
								goPurple = 1;
								double rW = (random.nextDouble() * 30) + 10;
								double rH = (random.nextDouble() * 30) + 10;
								double rY = random.nextDouble() * 440;
								double rVx = random.nextDouble() * 10 + 1;
								double rVy = random.nextDouble() * 4 + 1;
								mainList.add(new squares.PurpleSquare( 0, rY, rW, rH, rVx, rVy * shift, 0, 0, 650-rW, 440-rH, 1));
							}
							if( type <= 2) {
								double rW = (random.nextDouble() * 30) + 10;
								double rH = (random.nextDouble() * 30) + 10;
								double rY = random.nextDouble() * 440;
								double rVx = random.nextDouble() * 10 + 1;
								double rVy = random.nextDouble() * 4 + 1;
								mainList.add(new squares.GreenSquare( 0, rY, rW, rH, rVx, rVy * shift, 0, 0, 650-rW, 440-rH, 1));
							}
						}
						if(  go * 2 >= r && r >= go ) {     //Spawn on the right side
							tries = 0;
							//SoundEffect.POP.play();
							double type = random.nextDouble() * 110;
							if( type >= 18) {
								goPurple ++;
								double rW = (random.nextDouble() * 30) + (8 * difficulty);
								double rH = (random.nextDouble() * 30) + (8 * difficulty);
								double rY = random.nextDouble() * 440;
								double rVx = random.nextDouble() * 10 + 1;
								double rVy = random.nextDouble() * 4 + 1;
								mainList.add(new squares.DodgeBlock( 640, rY, rW, rH, -rVx, rVy * shift));
							}
							if( type > 9 && type < 18) {
								double rW = (random.nextDouble() * 30) + 10;
								double rH = (random.nextDouble() * 30) + 10;
								double rY = random.nextDouble() * 440;
								double rVx = random.nextDouble() * 10 + 1;
								double rVy = random.nextDouble() * 4 + 1;
								mainList.add(new squares.YellowSquare( 640, rY, rW, rH, -rVx, rVy * shift, 0, 0, 650-rW, 440-rH));
							}
							if( type > 2 && type <= 9){
								goPurple = 1;
								double rW = (random.nextDouble() * 30) + 10;
								double rH = (random.nextDouble() * 30) + 10;
								double rY = random.nextDouble() * 440;
								double rVx = random.nextDouble() * 10 + 1;
								double rVy = random.nextDouble() * 4 + 1;
								mainList.add(new squares.PurpleSquare( 640, rY, rW, rH, -rVx, rVy * shift, 0, 0, 650-rW, 440-rH, 1));
							}
							if( type <= 2) {
								double rW = (random.nextDouble() * 30) + 10;
								double rH = (random.nextDouble() * 30) + 10;
								double rY = random.nextDouble() * 440;
								double rVx = random.nextDouble() * 10 + 1;
								double rVy = random.nextDouble() * 4 + 1;
								mainList.add(new squares.GreenSquare( 0, rY, rW, rH, rVx, rVy * shift, 0, 0, 650-rW, 440-rH, 1));
							}
						}
					for( int i = 1; i < mainList.size(); i++) {        //Remove excess squares
						mainList.get(i).x = mainList.get(i).Vx + mainList.get(i).x;       
						mainList.get(i).y = mainList.get(i).Vy + mainList.get(i).y;
						
						int x = (int) mainList.get(i).x;
						int y = (int) mainList.get(i).y;
						if( x > 2 * windowX || y > 2 * windowY || 
							x < 0 - mainList.get(i).with || y < 0 - mainList.get(i).hite) {
							mainList.remove(i);
						}
					}    //End of Survival mode
				}else{
			
				for(int v = 1; v < mainList.size(); v++) {    //moving obstacles
					if( mainList.get(v) instanceof squares.WallBuild ||
						mainList.get(v) instanceof squares.PurpleSquare ||
						mainList.get(v) instanceof squares.GreenSquare ||
						mainList.get(v) instanceof squares.YellowSquare) {
						if( mainList.get(v).dx1 >= mainList.get(v).x) {
							mainList.get(v).right = true;
						}
						if( mainList.get(v).dy1 >= mainList.get(v).y) {
							mainList.get(v).down = true;
						}
						if( mainList.get(v).x >= mainList.get(v).dx2) {
							mainList.get(v).right = false;
						}
						if( mainList.get(v).y >= mainList.get(v).dy2) {
							mainList.get(v).down = false;
						}
						if( mainList.get(v).right == true) {
							mainList.get(v).x += mainList.get(v).Vx;
						}else{
							mainList.get(v).x -= mainList.get(v).Vx;
						}
						if( mainList.get(v).down == true) {
							mainList.get(v).y += mainList.get(v).Vy;
						}else{
							mainList.get(v).y -= mainList.get(v).Vy;
						}
				}
				if( mainList.get(v) instanceof squares.WallStick) {
					mainList.get(v).x += mainList.get(v).Vx;
					mainList.get(v).y += mainList.get(v).Vy;
					if( mainList.get(v).dx1 >= mainList.get(v).x) {
						mainList.get(v).Vx = 0;
						mainList.get(v).Vy = 0;
					}
					if( mainList.get(v).dy1 >= mainList.get(v).y) {
						mainList.get(v).Vx = 0;
						mainList.get(v).Vy = 0;
					}
					if( mainList.get(v).x >= mainList.get(v).dx2) {
						mainList.get(v).Vx = 0;
						mainList.get(v).Vy = 0;
					}
					if( mainList.get(v).y >= mainList.get(v).dy2) {
						mainList.get(v).Vx = 0;
						mainList.get(v).Vy = 0;
					}
				}
				}
			}
					
			if(a == true){                                          //Change coordinates for movement
				mainList.get(0).x -= mainList.get(0).Vx;
			}else{
			}
			if(d == true){
				mainList.get(0).x += mainList.get(0).Vx;
			}else{
			}
			if(w == true){
				mainList.get(0).y -= mainList.get(0).Vy;
			}else{
			}
			if(s == true){
				mainList.get(0).y += mainList.get(0).Vy;
			}else{
			}
			//System.out.println(mainList.get(0).Vx);
			}  //End if run statement
			
			//Stuff here happens repeatedly after sleep duration delay.
		start = System.currentTimeMillis();
		repaint();
		tick_end_time = System.currentTimeMillis();
		tick_duration = tick_end_time - start;
		sleep_duration = MAX_MS_PER_FRAME - tick_duration;
		if(sleep_duration < MIN_SLEEP_TIME){
			sleep_duration = MIN_SLEEP_TIME;
		}
		fps = 1000 / (sleep_duration + tick_duration);
		try{
			Thread.sleep(sleep_duration);
		} catch(InterruptedException e){
		}	
		repaint();
	}  //while true
}  // run

public void keyPressed(KeyEvent ke){                               //Coasting Key commands
	
	System.out.println(ke.getKeyChar());
	System.out.println(AccelaWobble);
	if(ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A' && ke.getKeyChar() != AccelaWobble ) {
		a = true;
		d = false;
		w = false;
		s = false;
	}
	if(ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D') {
		d = true;
		a = false;
		w = false;
		s = false;
	}
	if(ke.getKeyChar() == 'w' || ke.getKeyChar() == 'W') {
		w = true;
		d = false;
		a = false;
		s = false;
	}
	if(ke.getKeyChar() == 's' || ke.getKeyChar() == 'S') {
		s = true;
		d = false;
		w = false;
		a = false;
	}
	if(ke.getKeyChar() == 'm' || ke.getKeyChar() == 'M') {       //Menu Key Commands and other Hotkeys
		GameFunctions.goMenu();
		run = true; 
		r = 1;
		level = 0;
		GameFunctions.chooseLevel();
	}
	if(ke.getKeyChar() == 'p') {
		r = r * -1;
		if( r == 1) {
			run = true; 
			oFunctions.get(1).on = false;
			oFunctions.get(3).on = false;
		}else{
			GameFunctions.pauseMenu();
		}
	}
	if( menu == true) {
		if(ke.getKeyChar() == '1') {    //Level HotKeys
			level = 1;
			GameFunctions.chooseLevel();
			GameFunctions.inLevel();
		}
		if(ke.getKeyChar() == '2') {
			level = 2;
			GameFunctions.chooseLevel();
			GameFunctions.inLevel();
		}
		if(ke.getKeyChar() == '3') {
			level = 3;
			GameFunctions.chooseLevel();
			GameFunctions.inLevel();
		}
		if(ke.getKeyChar() == '4') {
			level = 4;
			GameFunctions.chooseLevel();
			GameFunctions.inLevel();
		}
		if(ke.getKeyChar() == '0') {
			GameFunctions.survivalLevel();
		}
		if(ke.getKeyChar() == '5') {
			level = 5;
			GameFunctions.chooseLevel();
			GameFunctions.inLevel();
		}
		if(ke.getKeyChar() == '6') {
			level = 6;
			GameFunctions.chooseLevel();
			GameFunctions.inLevel();
		}
		if(ke.getKeyChar() == '7') {
			level = 7;
			GameFunctions.chooseLevel();
			GameFunctions.inLevel();
		}

	}
		if( run == true && ke.getKeyChar() != AccelaWobble) {                   //Acceleration and BlueShift
		mainList.get(0).Vx += modifier;
		mainList.get(0).Vy += modifier;
		if( mainList.get(0).blue < 250 - (modifier * 15)) {
			mainList.get(0).blue += modifier * 20;
		}
		if( mainList.get(0).red > 5 + (modifier * 5)) {
			mainList.get(0).red -= modifier * 15;
		}
		moves++;
	}
		if( ke.getKeyChar() == 'w' || ke.getKeyChar() == 'a' || 
				ke.getKeyChar() == 's' || ke.getKeyChar() == 'd' ||
				ke.getKeyChar() == 'W' || ke.getKeyChar() == 'A' || 
				ke.getKeyChar() == 'S' || ke.getKeyChar() == 'D')   {
					AccelaWobble = ke.getKeyChar();
			}
} // End Key Method
	
public void paint(Graphics g){           //Paint method
	for(Object o: mainList){
		o.draw(g);
	}
	for(MouseButton p: buttonList){
		p.draw(g);
	}
	for(MouseButton i: oFunctions){
		i.draw(g);
	}
	for(Object k: counters){
		k.draw(g);
	}
}
@Override
public void keyTyped(KeyEvent e) {      //These keep keyPressed working
	// TODO Auto-generated method stub	
	}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	}
@Override  
public void mouseClicked(MouseEvent e) {   //These keep MousePressed working
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {  
	System.out.println(e.getX() + "," + e.getY());
	int Mx = e.getX();
	int My = e.getY() - 20;
	for(int i = 0; i < buttonList.size(); i++){
		if(buttonList.get(i).on == true) {       //check for on, then bounds, then type
			if( Mx >= buttonList.get(i).x1 && Mx <= (buttonList.get(i).x1 + buttonList.get(i).w) &&   
				My >= buttonList.get(i).y1 && My <= (buttonList.get(i).y1 + buttonList.get(i).h )) {
				System.out.println("click");
				a = false;
				s = false;
				d = false;
				w = false;
				//buttonList.get(i).run = true;
				if( buttonList.get(i) instanceof levels.LevelOne) {  //Level One
					level = 1;
					GameFunctions.inLevel();
				}
				if( buttonList.get(i) instanceof levels.LevelTwo) {  //Level Two
					level = 2;
					GameFunctions.inLevel();
				}
				if( buttonList.get(i) instanceof levels.LevelThree) {
					level = 3;
					GameFunctions.inLevel();
				}
				if( buttonList.get(i) instanceof levels.LevelFour) {
					level = 4;
					GameFunctions.inLevel();
				}
				if( buttonList.get(i) instanceof levels.LevelFive) {
					level = 5;
					GameFunctions.inLevel();
				}
				if( buttonList.get(i) instanceof levels.LevelSix) {
					level = 6;
					GameFunctions.inLevel();
				}
				if( buttonList.get(i) instanceof levels.LevelSeven) {
					level = 7;
					GameFunctions.inLevel();
				}
				GameFunctions.chooseLevel();
				deaths = 0;
			}
		} //Edges loop
	}
	for( int i = 0; i < oFunctions.size(); i++) {
		if(oFunctions.get(i).on == true) {             //Repeat for non-level buttons
			if( Mx >= oFunctions.get(i).x1 && Mx <= (oFunctions.get(i).x1 +  oFunctions.get(i).w) && 
				My >= oFunctions.get(i).y1 && My <= (oFunctions.get(i).y1 + oFunctions.get(i).h )) {
				System.out.println("other click");
				a = false;
				s = false;
				d = false;
				w = false;
			if( oFunctions.get(i) instanceof SurvivalButton) {
				GameFunctions.survivalLevel();
			}
			if( oFunctions.get(i) instanceof PauseButton) {
				r = r * -1;
				if( r == 1) {
					run = true; 
					oFunctions.get(1).on = false;
				}else{
					GameFunctions.pauseMenu();
				}
			}
			if( oFunctions.get(i) instanceof MenuButton) {
				GameFunctions.goMenu();
				level = 0;
				GameFunctions.chooseLevel();
				run = true;
			}
		}
		}
	}  //end
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub	
}
}