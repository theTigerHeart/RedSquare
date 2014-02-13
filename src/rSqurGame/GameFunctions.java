package rSqurGame;

import squares.SpeedKey;
import squares.Wall;
import squares.WallBuild;
import squares.YellowSquare;

public class GameFunctions {
	
	/*Main Game Function methods
	 * goMenu activates all the correct buttons for the menu screen
	 * inLevel deactivates all the buttons for playing a level
	 * pauseMenu sets the pause menu
	 * survivalLevel runs everything for the survival game
	 *  
	 */	
	
public static void goMenu() {
		RedSquare.goSurvival = false;
		resetSpawn();
		RedSquare.counters.get(1).on = false;
		RedSquare.counters.get(2).on = true;
		RedSquare.a = false;
		RedSquare.d = false;
		RedSquare.s = false;
		RedSquare.w = false;
		RedSquare.menu = true;
		RedSquare.mainList.clear();
		//mainList.add(new Square( 300, 220, 20, 20, 3, 3));

		for(int i = 0; i < RedSquare.buttonList.size(); i++) {
			RedSquare.buttonList.get(i).on = true;
		}
		for(int i = 0; i < RedSquare.oFunctions.size(); i++) {
			RedSquare.oFunctions.get(i).on = false;
		}
		RedSquare.oFunctions.get(0).on = true;
		RedSquare.score = 0;
		RedSquare.seconds = 0;
		RedSquare.timeLag = 0;
		RedSquare.oFunctions.get(3).on = true;
		RedSquare.oFunctions.get(3).x1 = 520;
		RedSquare.oFunctions.get(3).y1 = 355;
	}
	
public static void inLevel() {
		RedSquare.menu = false;
		RedSquare.toggle = true;
		RedSquare.counters.get(1).on = true;
		RedSquare.counters.get(2).on = false;
		for(int i = 0; i < RedSquare.buttonList.size(); i++) {
			RedSquare.buttonList.get(i).on = false;
		}
		for(int i = 0; i < RedSquare.oFunctions.size(); i++) {
			RedSquare.oFunctions.get(i).on = false;
		}
		RedSquare.oFunctions.get(2).on = true;
		RedSquare.oFunctions.get(1).on = false;
		RedSquare.oFunctions.get(3).on = false;
		RedSquare.score = 0;
	}
	
public static void resetSpawn() {
		RedSquare.pSpawn = 2;
		RedSquare.gSpawn = 9;
		RedSquare.ySpawn = 18;
	}
	
public static void pauseMenu() {
		RedSquare.run = false;
		RedSquare.oFunctions.get(1).on = true;
		RedSquare.oFunctions.get(3).on = true;
		RedSquare.oFunctions.get(3).x1 = 520;
		RedSquare.oFunctions.get(3).y1 = 325;
	}
	
public static void survivalLevel() {
		RedSquare.timeSet = true;
		RedSquare.toggle = true;
		RedSquare.counters.get(0).on = true;
		RedSquare.counters.get(1).on = false;
		RedSquare.counters.get(2).on = false;
		RedSquare.mainList.clear();
		RedSquare.score = 0;
		RedSquare.difficulty = 1;
			RedSquare.mainList.add(new squares.Square( 300, 220, 20, 20, 3, 3));
			RedSquare.mainList.get(0).red = 255;
			RedSquare.mainList.get(0).green = 0;
			RedSquare.mainList.get(0).blue = 0;
			RedSquare.mainList.add(new squares.WallBuild( 700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.a = false;
		RedSquare.s = false;
		RedSquare.d = false;
		RedSquare.w = false;
		RedSquare.score = 0;
		inLevel();
		RedSquare.goSurvival = true;
		System.out.println("survival");
		RedSquare.oFunctions.get(3).on = false;
	}
	
public static void levelCollisions() {
		for(int p = 0; p < RedSquare.buttonList.size(); p++){
			boolean xc = false;
			boolean yc = false;
			if( (RedSquare.buttonList.get(p).x1 + RedSquare.buttonList.get(p).w)  >= RedSquare.mainList.get(0).x && 
				RedSquare.buttonList.get(p).x1  <= (RedSquare.mainList.get(0).x + RedSquare.mainList.get(0).with)) {
					xc = true;
			}
			if( (RedSquare.buttonList.get(p).y1 + RedSquare.buttonList.get(p).h)  >= RedSquare.mainList.get(0).y && 
				RedSquare.buttonList.get(p).y1  <= (RedSquare.mainList.get(0).y + RedSquare.mainList.get(0).hite)) {
					yc = true;
			}
			
			if( xc == true && yc ==true) {
				
				if( RedSquare.buttonList.get(p) instanceof levels.LevelOne) {
					if( RedSquare.buttonList.get(0).on == true) {
						RedSquare.level = 1;
						System.out.println(RedSquare.level + "l1");
						inLevel();
					}
				}
				if( RedSquare.buttonList.get(p) instanceof levels.LevelTwo) {
					if( RedSquare.buttonList.get(1).on == true) {
						RedSquare.level = 2;
						System.out.println(RedSquare.level + "l2");
						inLevel();
					}
				}
				if( RedSquare.buttonList.get(p) instanceof levels.LevelThree) {
					if( RedSquare.buttonList.get(2).on == true) {
						RedSquare.level = 3;
						System.out.println(RedSquare.level);
						inLevel();
					}
				}
				if( RedSquare.buttonList.get(p) instanceof levels.LevelFour) {
					if( RedSquare.buttonList.get(3).on == true) {
						RedSquare.level = 4;
						System.out.println(RedSquare.level);
						inLevel();
					}
				}
				if( RedSquare.buttonList.get(p) instanceof levels.LevelFive) {
					if( RedSquare.buttonList.get(4).on == true) {
						RedSquare.level = 5;
						System.out.println(RedSquare.level);
						inLevel();
					}
				}
				if( RedSquare.buttonList.get(p) instanceof levels.LevelSix) {
					if( RedSquare.buttonList.get(5).on == true) {
						RedSquare.level = 6;
						System.out.println(RedSquare.level);
						inLevel();
					}
				}
				if( RedSquare.buttonList.get(p) instanceof levels.LevelSeven) {
					if( RedSquare.buttonList.get(6).on == true) {
						RedSquare.level = 7;
						System.out.println(RedSquare.level);
						inLevel();
					}
				}
				chooseLevel();
			}  //end
		} //end buttonList loop
		boolean upX = false;
		boolean upY = false;
		if( (RedSquare.oFunctions.get(0).x1 + RedSquare.oFunctions.get(0).w)  >= RedSquare.mainList.get(0).x &&       //Check for Survival Level
				RedSquare.oFunctions.get(0).x1  <= (RedSquare.mainList.get(0).x + RedSquare.mainList.get(0).with)) {
					upX = true;
			}
		if( (RedSquare.oFunctions.get(0).y1 + RedSquare.oFunctions.get(0).h)  >= RedSquare.mainList.get(0).y && 
			RedSquare.oFunctions.get(0).y1  <= (RedSquare.mainList.get(0).y + RedSquare.mainList.get(0).hite)) {
					upY = true;
			}
		if( upX == true && upY == true) {
			survivalLevel();
		}  	
	}

public static void chooseLevel() {
		RedSquare.counters.get(0).on = false;
		resetSpawn();
		RedSquare.score = 0;
		RedSquare.seconds = 0;
		RedSquare.timeLag = 0;
		RedSquare.winning = 0;
		RedSquare.winCount = 1;
		RedSquare.mainList.clear();
		if( RedSquare.level == 0 || RedSquare.level > RedSquare.buttonList.size()) {
			RedSquare.modifier = .4;
			goMenu();
			RedSquare.mainList.add(new squares.Square(310, 230, 20, 20, 3, 3));
			RedSquare.mainList.get(0).red = 255;
			RedSquare.mainList.get(0).green = 0;
			RedSquare.mainList.get(0).blue = 0;
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
		}
		if( RedSquare.level == 1) {
			RedSquare.a = false;
			RedSquare.d = false;
			RedSquare.w = false;
			RedSquare.s = false;
			RedSquare.modifier = .5;
			RedSquare.winCount = 1;
			RedSquare.mainList.add(new squares.Square( 310, 230, 20, 20, 3, 3));
			RedSquare.mainList.get(0).red = 255;
			RedSquare.mainList.get(0).green = 0;
			RedSquare.mainList.get(0).blue = 0;
			RedSquare.mainList.add(new squares.WallBuild( 280, 200, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 280, 260, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 340, 200, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 340, 260, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 310, 200, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 280, 230, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 240, 160, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 360, 180, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 380, 160, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 360, 280, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 380, 300, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 260, 280, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 240, 300, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.YellowSquare( 260, 180, 20, 20, 0, 0, 0, 0, 0, 0));   //15 items
			
			RedSquare.mainList.add(new squares.GreenSquare( 400, 230, 20, 20, 0, 0, 0, 0, 0, 0, 2));
		}
		if( RedSquare.level == 2) {
			RedSquare.a = false;
			RedSquare.d = false;
			RedSquare.w = false;
			RedSquare.s = false;
			RedSquare.modifier = .5;
			RedSquare.winCount = 1;
			RedSquare.mainList.add(new squares.Square( 310, 270, 20, 20, 3, 3));
			RedSquare.mainList.get(0).red = 255;
			RedSquare.mainList.get(0).green = 0;
			RedSquare.mainList.get(0).blue = 0;
			RedSquare.mainList.add(new squares.WallBuild(280, 200, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(280, 220, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(280, 240, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(260, 240, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(240, 240, 20, 20, 0, 0, 0, 0, 0, 0));
			
			RedSquare.mainList.add(new squares.WallBuild(200, 200, 20, 20, 4, 4, 160, 160, 240, 240));
			RedSquare.mainList.add(new squares.WallBuild(180, 180, 20, 20, 4, 4, 160, 160, 240, 240));
			RedSquare.mainList.add(new squares.WallBuild(220, 220, 20, 20, 4, 4, 160, 160, 240, 240));
			RedSquare.mainList.add(new squares.WallBuild(240, 160, 20, 20, 4, 4, 200, 120, 280, 200));
			RedSquare.mainList.add(new squares.WallBuild(220, 140, 20, 20, 4, 4, 200, 120, 280, 200));
			RedSquare.mainList.add(new squares.WallBuild(260, 180, 20, 20, 4, 4, 200, 120, 280, 200));
			
			RedSquare.mainList.add(new squares.WallBuild(200, 120, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(160, 160, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.YellowSquare(250, 210, 20, 20, 0, 0, 0, 0, 0, 0));    //15 items
			
		}
		if( RedSquare.level == 3) {
			RedSquare.a = false;
			RedSquare.d = false;
			RedSquare.w = false;
			RedSquare.s = false;
			RedSquare.modifier = .5;
			RedSquare.winCount = 1;
			RedSquare.mainList.add(new squares.Square(10, 80, 20, 20, 3, 3));   //80, 130
			RedSquare.mainList.get(0).red = 255;
			RedSquare.mainList.get(0).green = 0;
			RedSquare.mainList.get(0).blue = 0;
			RedSquare.mainList.add(new squares.WallBuild( 50, 40, 300, 180, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 50, 260, 300, 160, 0, 0, 0, 0, 0, 0));
			
			RedSquare.mainList.add(new squares.WallBuild( 50, 230, 20, 300, 3, 0, 0, 0, 400, 0));
			RedSquare.mainList.add(new squares.WallBuild( 0, 40, 520, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 400, 100, 200, 320, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.YellowSquare( 10, 10, 20, 20, 0, 0, 0, 0, 0, 0));    //7 items
			
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));      //filler
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild(700, 700, 20, 20, 0, 0, 0, 0, 0, 0));
		}
		if( RedSquare.level == 4) {
			RedSquare.a = false;
			RedSquare.d = false;
			RedSquare.w = false;
			RedSquare.s = false;
			RedSquare.modifier = .3;
			RedSquare.winCount = 1;
			RedSquare.mainList.add(new squares.Square( 10, 10, 20, 20, 3, 3));
			RedSquare.mainList.get(0).red = 255;
			RedSquare.mainList.get(0).green = 0;
			RedSquare.mainList.get(0).blue = 0;
			RedSquare.mainList.add(new squares.WallBuild( 40, 40, 100, 10, 0, 0, 0, 0, 0, 0));  //y40
			RedSquare.mainList.add(new squares.WallBuild( 180, 40, 100, 10, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 280, 80, 10, 180, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 240, 80, 10, 100, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 0, 90, 100, 10, 0, 0, 0, 0, 0, 0));   //y90
			RedSquare.mainList.add(new squares.WallBuild( 140, 90, 100, 10, 0, 0, 0, 0, 0, 0)); 
			RedSquare.mainList.add(new squares.WallBuild( 40, 140, 160, 10, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 200, 170, 20, 20, 6, 4, 20, 160, 260, 180));
			RedSquare.mainList.add(new squares.WallBuild( 0, 220, 250, 10, 0, 0, 0, 0, 0, 0));  //y220
			RedSquare.mainList.add(new squares.WallBuild( 290, 90, 45, 10, 2, 0, 245, 0, 335, 0));
			RedSquare.mainList.add(new squares.WallBuild( 250, 170, 45, 10, 2, 0, 245, 0, 335, 0));
			RedSquare.mainList.add(new squares.WallBuild( 330, 0, 10, 270, 0, 0, 0, 0, 0, 0));         //Quadrant One 
			RedSquare.mainList.add(new squares.WallBuild( 40, 260, 260, 10, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 0, 300, 300, 10, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 50, 350, 340, 10, 0, 0, 0, 0, 0, 0)); //main corner
			RedSquare.mainList.add(new squares.WallBuild( 380, 50, 10, 300, 0, 0, 0, 0, 0, 0)); //main corner
			RedSquare.mainList.add(new squares.PurpleSquare( 15, 375, 20, 20, 0, 0, 0, 0, 0, 0, 1));
			RedSquare.mainList.add(new squares.PurpleSquare( 400, 15, 20, 20, 0, 0, 0, 0, 0, 0, 1));
			RedSquare.mainList.add(new squares.PurpleSquare( 400, 375, 20, 20, 0, 0, 0, 0, 0, 0, 1));
			RedSquare.mainList.add(new squares.WallBuild( 300, 315, 20, 20, 3, 3, 280, 250, 370, 340));
			RedSquare.mainList.add(new squares.WallBuild( 500, 60, 60, 360, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.WallBuild( 502, 0, 200, 220, 4, 0, 502, 0, 680, 0));
			RedSquare.mainList.add(new squares.WallBuild( 680, 280, 200, 200, 4, 0, 502, 0, 680, 0));
			RedSquare.mainList.add(new squares.YellowSquare( 580, 240, 20, 20, 0, 0, 0, 0, 0, 0));	
		}
		if( RedSquare.level == 5) {
			RedSquare.a = false;
			RedSquare.d = false;
			RedSquare.w = false;
			RedSquare.s = false;
			RedSquare.modifier = .2;
			RedSquare.winCount = 2;
			RedSquare.mainList.add(new squares.Square( RedSquare.windowX - 10, RedSquare.windowY - 10, 20, 20, 3, 3));
			RedSquare.mainList.get(0).red = 255;
			RedSquare.mainList.get(0).green = 0;
			RedSquare.mainList.get(0).blue = 0;
			RedSquare.mainList.add(new squares.YellowSquare(10, 10, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.YellowSquare(10, 430, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.PurpleSquare( 50, 160, 20, 20, 0, 0, 0, 0, 0, 0, 1));
			
			RedSquare.mainList.add(new squares.Wall( 0, 40, 40, 360));
			RedSquare.mainList.add(new squares.Wall( 40, 40, 500, 20));
			RedSquare.mainList.add(new squares.Wall( 40, 380, 540, 20));
			RedSquare.mainList.add(new squares.Wall( 80, 100, 260, 20));
			RedSquare.mainList.add(new squares.Wall( 80, 320, 260, 20));
			RedSquare.mainList.add(new squares.Wall( RedSquare.windowX + 15, 100, 20, 240));
			RedSquare.mainList.add(new squares.Wall( 40, RedSquare.windowY - 10, 200, 20));
			RedSquare.mainList.add(new squares.Wall( 390, 40, 20, 140));
			RedSquare.mainList.add(new squares.Wall( RedSquare.windowX + 15, RedSquare.windowY - 10, 310, 20));
			
			RedSquare.mainList.add(new squares.WallBuild( 410, 60, 20, 20, 3, 3, 410, 60, 620, 210));
			RedSquare.mainList.add(new squares.WallBuild( 410, 210, 20, 20, 3, 3, 410, 60, 620, 210));
			RedSquare.mainList.add(new squares.WallBuild( 620, 60, 20, 20, 3, 3, 410, 60, 620, 210));
			RedSquare.mainList.add(new squares.WallBuild( 620, 210, 20, 20, 3, 3, 410, 60, 620, 210));
			
			RedSquare.mainList.add(new squares.WallBuild( 120, 380, 10, 40, 0, 2, 0, 320, 0, 420));
			RedSquare.mainList.add(new squares.WallBuild( 140, 390, 10, 40, 0, 2, 0, 320, 0, 420));
			RedSquare.mainList.add(new squares.WallBuild( 160, 400, 10, 40, 0, 2, 0, 320, 0, 420));
			RedSquare.mainList.add(new squares.WallBuild( 180, 410, 10, 40, 0, 2, 0, 320, 0, 420));
		}
		if( RedSquare.level == 6) {
				RedSquare.a = false;
				RedSquare.d = false;
				RedSquare.w = false;
				RedSquare.s = false;
				RedSquare.modifier = .3;
				RedSquare.winCount = 4;
				RedSquare.mainList.add(new squares.Square( 290, RedSquare.windowY - 10, 20, 20, 3, 3));
				RedSquare.mainList.get(0).red = 255;
				RedSquare.mainList.get(0).green = 0;
				RedSquare.mainList.get(0).blue = 0;
				RedSquare.mainList.add(new squares.PurpleSquare(330, 230, 20, 20, 0, 0, 0, 0, 0, 0, 3));
				RedSquare.mainList.add(new squares.Wall( RedSquare.windowX - 10, 0, 20, 200));    
				RedSquare.mainList.add(new squares.Wall( RedSquare.windowX - 10, 280, 20, 200));
				RedSquare.mainList.add(new squares.Wall( 0, RedSquare.windowY - 10, 260, 20));
				RedSquare.mainList.add(new squares.Wall( 380, RedSquare.windowY - 10, 260, 20));  //Quadrant sides
				
				RedSquare.mainList.add(new squares.SpeedKey(10, 10, 20, 20, 0, -3, -800, -800, 800, 800, 1, 1));
				RedSquare.mainList.add(new squares.WallBuild( 10, 40, 20, 20, 0, 0, 0, 0, 100, 100)); 
				RedSquare.mainList.add(new squares.SpeedKey(10, 10, 20, 20, 3, 0, -800, -800, 800, 800, 1, 1));
				RedSquare.mainList.add(new squares.WallBuild( 310, 10, 20, 20, 0, 0, 0, 0, 100, 100)); 
				RedSquare.mainList.add(new squares.SpeedKey( 200, 80, 20, 20, -3, 0, -800, -800, 800, 800, 1, 1));
				RedSquare.mainList.add(new squares.WallBuild( 10, 80, 140, 140, 0, 0, 0, 0, 0, 0));
				
				RedSquare.mainList.add(new squares.Wall( 40, 40, 220, 20));
				RedSquare.mainList.add(new squares.WallBuild( 250, 40, 20, 140, 0, 0, 0, 0, 0, 0));
				
				RedSquare.mainList.add(new squares.Wall( 380, 60, 20, 180));
				
				RedSquare.mainList.add(new squares.SpeedKey(410, 200, 20, 20, 2, -3, 390, 0, 630, 0, 1, 1));
				RedSquare.mainList.add(new squares.WallBuild( 390, 60, 20, 20, 3, 0, 390, 0, 630, 0));
				RedSquare.mainList.add(new squares.SpeedKey(410, 200, 20, 20, 2, -3, 390, 0, 630, 0, 1, 1));
				RedSquare.mainList.add(new squares.WallBuild( 450, 80, 20, 20, 3, 0, 390, 0, 630, 0));
				RedSquare.mainList.add(new squares.SpeedKey(410, 200, 20, 20, 2, -3, 390, 0, 630, 0, 1, 1));
				RedSquare.mainList.add(new squares.WallBuild( 510, 100, 20, 20, 3, 0, 390, 0, 630, 0));
				RedSquare.mainList.add(new squares.SpeedKey(410, 200, 20, 20, 2, -3, 390, 0, 630, 0, 1, 1));
				RedSquare.mainList.add(new squares.WallBuild( 570, 120, 20, 20, 3, 0, 390, 0, 630, 0));
				RedSquare.mainList.add(new squares.SpeedKey(410, 200, 20, 20, 2, -3, 390, 0, 630, 0, 1, 1));
				RedSquare.mainList.add(new squares.WallBuild( 620, 140, 20, 20, 3, 0, 390, 0, 630, 0));
				
				RedSquare.mainList.add(new squares.Wall( 400, 60, 60, 130));
				RedSquare.mainList.add(new squares.Wall( 500, 20, 120, 170));
				RedSquare.mainList.add(new squares.Wall( 400, 170, 40, 20));
				
				RedSquare.mainList.add(new squares.YellowSquare(10, 40, 20, 20, 0, 0, 0, 0, 0, 0));
				RedSquare.mainList.add(new squares.YellowSquare( 10, 430, 20, 20, 0, 0, 0, 0, 0, 0));
				RedSquare.mainList.add(new squares.YellowSquare( 600, 400, 20, 20, 0, 0, 0, 0, 0, 0));
				
				RedSquare.mainList.add(new squares.YellowSquare( 410, 200, 20, 20, 0, 0, 0, 0, 0, 0));
		}
		if( RedSquare.level == 7) {
			RedSquare.a = false;
			RedSquare.d = false;
			RedSquare.w = false;
			RedSquare.s = false;
			RedSquare.modifier = .2;
			RedSquare.winCount = 3;
			RedSquare.mainList.add(new squares.Square( 30, 30, 20, 20, 3, 3));
			RedSquare.mainList.add(new squares.YellowSquare( 110, 360, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.add(new squares.YellowSquare( 210, 270, 20, 20, 0, 0, 0, 0, 0, 0));
			
			RedSquare.mainList.add(new squares.SpeedKey( 210, 190, 20, 20, -3, 0, 0, 0, 8000, 8000, 1, 1));
			RedSquare.mainList.add(new squares.WallBuild( 210, 270, 40, 40, 0, 0, 0, 0, 0, 0));
			
			RedSquare.mainList.add(new squares.YellowSquare( 210, 190, 20, 20, 0, 0, 0, 0, 0, 0));
			RedSquare.mainList.get(0).red = 255;
			RedSquare.mainList.get(0).green = 0;
			RedSquare.mainList.get(0).blue = 0;
			RedSquare.mainList.add(new squares.Wall( 0, 0, 10, 480 )); //Edges
			RedSquare.mainList.add(new squares.Wall( 630, 0, 10, 480));
			RedSquare.mainList.add(new squares.Wall( 0, 0, 640, 10));
			RedSquare.mainList.add(new squares.Wall( 0, 450, 640, 10));
			
			RedSquare.mainList.add(new squares.Wall( 140, 0, 60, 80));
			RedSquare.mainList.add(new squares.Wall( 0, 60, 100, 20));
			
			RedSquare.mainList.add(new squares.SpeedKey( 30, 100, 20, 20, 0, 3, 0, 0, 800, 8000, 1, 5));
			RedSquare.mainList.add(new squares.SpeedKey( 30, 100, 20, 20, 0, -3, 0, 0, 800, 8000, 1, 2));
			RedSquare.mainList.add(new squares.SpeedKey( 30, 100, 20, 20, 3, 0, -8000, 0, -8000, 640, 1, 2));
			RedSquare.mainList.add(new squares.WallBuild( 20, 140, 110, 110, 0, 0, 0, 0, 0, 0)); //Moves down
			RedSquare.mainList.add(new squares.WallBuild( 140, 90, 60, 40, 0, 0, 0, 0, 0, 0)); //Moves left
			RedSquare.mainList.add(new squares.WallBuild( 20, -100, 110, 110, 0, 0, 0, 0, 0, 0));
			
			RedSquare.mainList.add(new squares.Wall( 140, 140, 60, 280));
			RedSquare.mainList.add(new squares.Wall( 0, 220, 100, 20));
			RedSquare.mainList.add(new squares.Wall( 60, 330, 100, 20));
			RedSquare.mainList.add(new squares.Wall( 145, 95, 50, 20));
			RedSquare.mainList.add(new squares.Wall( 140, 220, 400, 40));
			RedSquare.mainList.add(new squares.Wall( 590, 40, 20, 400));
			RedSquare.mainList.add(new squares.Wall( 530, 80, 20, 340));
			
			RedSquare.mainList.add(new squares.SpeedKey( 260, 180, 20, 20, - 3, 0, 0, 0, 8000, 8000, 1, 1));
			RedSquare.mainList.add(new squares.WallBuild( 210, 170, 40, 40, 0, 0, 0, 0, 0, 0));
			
			RedSquare.mainList.add(new squares.Wall( 260, 140, 220, 20));
			RedSquare.mainList.add(new squares.WallBuild( 400, 10, 20, 20, 4, 4, 320, 5, 440, 125));
			RedSquare.mainList.add(new squares.WallBuild( 420, 30, 20, 20, 4, 4, 320, 5, 440, 125));
			
			RedSquare.mainList.add(new squares.WallBuild( 400, 310, 20, 20, 4, 4, 320, 310, 440, 430));
			RedSquare.mainList.add(new squares.WallBuild( 420, 330, 20, 20, 4, 4, 320, 310, 440, 430));
			RedSquare.mainList.add(new squares.Wall( 260, 300, 220, 20));
		}
		/* 		base level template
		   if( RedSquare.level == X) {
				RedSquare.a = false;
				RedSquare.d = false;
				RedSquare.w = false;
				RedSquare.s = false;
				RedSquare.modifier = .2;
				RedSquare.winCount = 2;
				RedSquare.mainList.add(new squares.Square( RedSquare.windowX - 10, RedSquare.windowY - 10, 20, 20, 3, 3));
				RedSquare.mainList.get(0).red = 255;
				RedSquare.mainList.get(0).green = 0;
				RedSquare.mainList.get(0).blue = 0;
			}
		 */
		//RedSquare.mainList.add(new squares.Wall( 700, 700, 20, 20)); //Filler, to ensure correct function 
	}
}

