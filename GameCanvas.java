import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

class GameCanvas extends PentPanel implements ActionListener {
	public static void main(String[] args) {}

	private ShapeBox shapeBox;
	private TextBox timeBox;
	private TextBox scoreBox;
	private TextBox highScoreBox;
	private Timer timer;
	private ArrayList<ScoreBox> scoreBoxes= new ArrayList<ScoreBox>();
	private boolean isGameOver = false;

	private Random random = new Random();
	private int time = 0;

	public PentrisBoard board = new PentrisBoard();

	public Shape activeShape;
	public Shape nextShape;
	public ShapeList shapeList;
	public Timer runtime;
	private Timer scoreTimer;

	 private int speedDefault = 600;
	 private int speedUp = 100;
	 private int x=0;
	 private int y=0;
	 private int score = 0;
	 private int scoreTarget = 0;
	 private final int SECOND = 1000;
	 private HashMap<String, Color> colorList;
	 private HighScoreManager hm;
	 private int highScore;

	public GameCanvas(int W, int H,  Font f, int s) {
		super(W, H, f, s, 0, 0);
		shapeList = new ShapeList();
		activeShape = shapeList.getRandomShape();
		nextShape = shapeList.getRandomShape();
		colorList = new PentColors();
		drawGame();
		startGame();
		hm = new HighScoreManager();
		ArrayList<Score> sList = hm.getScores();
		Score hScore = sList.get(0);
		highScore = hScore.getScore();
		highScoreBox.setTarget(highScore);
		highScoreBox.setValue(highScore);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	private void tick() {
		time++;
		timeBox.setTarget(time);
		drawScoreBoxes();
	}

	public void startGame(){
		if(activeShape.getHeight()>activeShape.getWidth()) activeShape.rotateR();
		if(!board.addShapeToBoard(activeShape)) gameOver();
		drawBoard(board);
		shapeBox.drawValue(nextShape);

		class ActionTick implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				//shape is touching another shape
				if(board.isPlaced(activeShape,x,y)) {
					if(y==0) gameOver();
					activeShape = nextShape;
					nextShape = shapeList.getRandomShape();
					shapeBox.drawValue(nextShape);
					if(activeShape.getHeight()> activeShape.getWidth()) activeShape.rotateR();
					x=0;
					y=0;
          			switch(board.breakLines()){
					  case 1: scoreTarget = 10 + score;
					  break;
					  case 2: scoreTarget = 30 + score;
					  break;
					  case 3: scoreTarget = 50 + score;
					  break;
					  case 4: scoreTarget = 70 + score;
					  break;
					  case 5: scoreTarget = 90 + score;
					  break;
				  	}
					if(scoreTarget-score>0)scoreTimer.setDelay(SECOND/((scoreTarget-score)));
					if(!board.addShapeToBoard(activeShape)) gameOver();
				}
				else {
					board.moveDown(activeShape,x,y);
					y++;
				}
				drawBoard(board);
			}
		}
		ActionTick gameTick = new ActionTick();
		class ScoreTick implements ActionListener{
			public void actionPerformed(ActionEvent e2){
				if(scoreTarget > score){
					score++;
					scoreBox.setTarget(score);
					scoreBox.setValue(score);
					if(score>highScore){
						highScoreBox.setTarget(score);
						highScoreBox.setValue(score);
					}
				}
			}
		}
		ScoreTick scoreTick = new ScoreTick();
		scoreTimer = new Timer(SECOND, scoreTick);

		runtime = new Timer(speedDefault,gameTick);

		timer = new Timer(SECOND, this);
		timer.start();
	   	runtime.start();
		scoreTimer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tick();
		repaint();
	}

	public void upKeyPress() {
		if(!isGameOver && board.rotatePossible(activeShape,x,y)){
		  	board.rotate(activeShape,x,y);
		}
		drawBoard(board);
	}

	public void downKeyPress() {
		 runtime.setDelay(speedUp);
	}
	 public void downKeyRelease(){
		 runtime.setDelay(speedDefault);
	 }

	public void spaceKeyPress() {
		board.dropDown(activeShape, x, y);
		  activeShape = nextShape;
		  nextShape = shapeList.getRandomShape();
		  if(activeShape.getHeight()>activeShape.getWidth()) activeShape.rotateR();
		  x=0;
		  y=0;
		  score += board.breakLines();
		  board.addShapeToBoard(activeShape,x,y);
		  drawBoard(board);
	}

    public void leftKeyPress() {
        if(!isGameOver && board.moveLeftPossible(activeShape, x, y)) {
			board.moveLeft(activeShape,x,y);
		  	x--;
		}
		drawBoard(board);
    }
    public void rightKeyPress() {
		 	if(!isGameOver && board.moveRightPossible(activeShape, x, y)) {
        		board.moveRight(activeShape,x,y);
		  		x++;
	  		}
		   drawBoard(board);
	}

	private void drawGame() {
		Graphics g = image.getGraphics();
		g.setColor(BACKGROUND);
		g.fillRect(0,0,w,h);


		//'origin' x and y positions to draw the board from.
		int ox = (w-SQ*5)/2;
		int oy = SQ;


		//draw border
		Color border = new Color(48, 48, 48);
		for(int y=-1; y<16; y++) {
			drawBlock(g, ox - SQ, oy + SQ * y, border, SQ);
			drawBlock(g, ox + 5 * SQ, oy + SQ * y, border, SQ);
		}

		for(int x=0; x<5; x++) {
			drawBlock(g, ox + SQ * x, oy - SQ, border, SQ);
			drawBlock(g, ox + SQ * x, oy + 15 * SQ, border, SQ);
		}


		//create score boxes
		TextBox levelBox = new TextBox(SQ/2, SQ*7, font, SQ, "Level");
		highScoreBox = new TextBox((SQ*23)/2, SQ*6, font, SQ, "High Score");
		scoreBox = new TextBox(SQ/2, SQ*4, font, SQ, "Score");
		timeBox = new TextBox(SQ/2, SQ, font, SQ, "Time");
		shapeBox = new ShapeBox((SQ*23)/2, SQ, font, SQ, "Next Shape",nextShape);

		scoreBoxes.add(timeBox);
		scoreBoxes.add(scoreBox);
		scoreBoxes.add(levelBox);
		scoreBoxes.add(highScoreBox);
		//scoreBoxes.add(shapeBox);

		add(shapeBox);

		for(ScoreBox box : scoreBoxes) {
			add(box);
		}

		repaint();
	}

	private void drawScoreBoxes() {
		for(ScoreBox box : scoreBoxes) {
			box.tick();
		}
	}

	private void drawBoard(PentrisBoard pBoard) {

		int ox = (w-SQ*5)/2;
		int oy = SQ;

		Graphics g = image.getGraphics();
		g.setColor(BACKGROUND);
		g.fillRect(ox,oy,SQ*5,SQ*15);

		String[][] board = pBoard.getBoard();


		for(int x=0; x<board[0].length; x++) {
			for(int y=0; y<board.length; y++) {
				if(!board[y][x].equals("-")) {
					drawBlock(g, ox + x * SQ, oy + y * SQ, colorList.get(board[y][x]), SQ);
				}
			}
		}

		repaint();
	}

	 public int getScore(){
		 return score;
	 }

	 private void gameOver(){
		 runtime.stop();
		 activeShape = null;
		 timer.stop();
		 System.out.println("Game over...");
		 isGameOver = true;
		 if(score>highScore)hm.addScore("me",scoreTarget);
	 }
}
