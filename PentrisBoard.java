import java.lang.*;

public class PentrisBoard {
	private String[][] board;
	//private ShapeFactory shapeOp = new ShapeFactory();

	public PentrisBoard(){
		this. board = new String[15][5];
	}
	public PentrisBoard(String[][] board) {
		this.board = board;
	}

	public String[][] getBoard() {
		return board;
	}

	// We use this method to add shapes to board
	public void addShapeToBoard(Shape shape, int x, int y) {
		int k = 0;

		String[][] addShape = shape.getShape();


//		while (addShape[0][k].equals("-")) {
//			y = y - 1;
//			k++;
//		}
		for (int i = 0; i < addShape.length; i++) {
			for (int j = 0; j < addShape[0].length; j++) {

				/* If the element of the shape array is not empty we copy it to the board */
				if (!addShape[i][j].equals("-") && x+i<board.length && y+j<board[0].length) {
					board[x + i][y + j] = addShape[i][j];
				}
			}
		}
	}
	public void addShapeToBoard(Shape shape){
		int x = board[0].length / 2;
		String[][] s = shape.getShape();
		if(s.length>s[0].length){
			shape.rotateL();
			x -= (int)s.length*1.0 / 2;
		}
		else x -= (int)s[0].length*1.0 / 2;
		int y=3;
		addShapeToBoard(shape,x,y);
	}

	/*
	 * This method removes shapes from the board, we dont need it for the specific
	 * algorithm we used right now but we will probably need it at some point
	 */
	public void removeShapeFromBoard(Shape shape, int x, int y) {
		String[][] removeShape = shape.getShape();
		for (int i = removeShape.length - 1; i >= 0; i--) {
			for (int j = removeShape[0].length - 1; j >= 0; j--) {
				if (!removeShape[i][j].equals("-") && x+i<board.length && y+j<board[0].length) {
					board[x + i][y + j] = "-";
				}
			}
		}
	}


	public boolean isPlaced(Shape shape, int x, int y) {

		for (int j = 0; j < shape.getShape()[0].length; j++) {
			int i = shape.getShape().length - 1;
			while (shape.getShape()[i][j].equals("-")) {
				i--;
			}
			if (i + x + 1< board.length && y+j<board[0].length) {
				if (!shape.getShape()[i][j].equals("-") && !board[i + x +1][y + j].equals("-")) {
					return true;
				}
			}
		}

		return false;
	}

//	public void avoidColisions(Shape newShape, int x, int y) {
//
//		String[][] shape = newShape.getShape();
//
//		for (int i = 0; i < shape.length; i++) {
//
//			if (!shape[i][shape[0].length - 1].equals("-")
//					&& (shape[0].length - 1 + y > board[0].length - 1 || board[i][shape[0].length - 1] != "-")) {
//				y--;
//
//				avoidColisions(newShape, x, y);
//
//			} else if (shape[i][0] != "-" && (y < 0 || board[x + i][y] != "-")) {
//
//				y++;
//
//				avoidColisions(newShape, x, y);
//			}
//		}
//	}

	public boolean isLineFull(int line) {
		for (int j = 0; j < board[line].length; j++) {
			if (board[line][j].equals("-"))
				return false;
		}
		return true;
	}

	public void emptyLine(int line) {
		for (int i = 0; i < board[line].length; i++) {
			board[line][i] = "-";
		}
	}

	public boolean isLineEmpty(int line) {
		for(int j=0; j<board[line].length; j++) {
			if(!board[line][j].equals("-"))
				return false;
		}
		return true;
	}

	public void breakLines() {

		String[][] newBoard = board;
		for (int i = board.length - 1; i > 0; i--) {

			if(isLineFull(i)) {
				int j=i;
				while(!isLineEmpty(j)) {
					for(int k=0; k<board[0].length; k++) {
						newBoard[j][k]=newBoard[j-1][k];
					}
					j--;
				}
				i++;
			}
		}
		board=newBoard;
	}

	public boolean isRotatePossible(Shape shape, int x, int y) {

		boolean isPossible=true;

		shape.rotateR();

		for(int i=0; i<shape.getShape().length; i++) {
			for(int j=0; j<shape.getShape()[0].length; j++) {

					if(!shape.getShape()[i][j].equals("-") && !board[x+i][y+j].equals("-") )
						isPossible=false;
			}
		}
			return isPossible;
		}

	public boolean isMoveLeftPossible(Shape shape, int x, int y) {
		for(int i=0; i<shape.getShape().length; i++) {

				if(y>0 && !shape.getShape()[i][0].equals("-") && !board[x+i][y-1].equals("-"))

					return false;


		}
		return true;
	}

	public boolean isMoveRightPossible(Shape shape, int x, int y) {
		boolean isPossible=true;
		for(int i=0; i<shape.getShape()[0].length; i++) {
			if(y<shape.getShape()[0].length && !shape.getShape()[i][shape.getShape()[0].length-1].equals("-") && !board[i][y+shape.getShape()[0].length].equals("-"))
				isPossible=false;

		}
		return isPossible;

	}

	/*public static void moveLeft() {
		 if(collisionLeft(activePentomino, xCoordinateBoard, yCoordinateBoard) == false ) {
			  removeShapeFromBoard(activePentomino, xCoordinateBoard, yCoordinateBoard);
			  xCoordinateBoard--;
			  addShapeToBoard(activePentomino, xCoordinateBoard, yCoordinateBoard);
		 }
	}

	public static void moveRight() {
		 if(collisionLeft(activePentomino, xCoordinateBoard, yCoordinateBoard) == false ) {
			  removeShapeFromBoard(activePentomino, xCoordinateBoard, yCoordinateBoard);
			  xCoordinateBoard++;
			  addShapeToBoard(activePentomino, xCoordinateBoard, yCoordinateBoard);
		 }
	}

	public Boolean collisionLeft(String[][] pentomino, int x, int y) {
		 int i = 0;
		 int j = 0;
		 while(i < pentomino.length) {
			  while(j < pentomin[0].length) {
					if(pentomino[i][j] != "-"  && x - 1 >= 0 && board[y+i][x+j-1] == "-" ) { // Looks if there is space to the left of the shape
						 counter++;
						 i++;
						 j = 0;
					}
					else {
						 if(j < pentomino[0].length-1) {
							  j++;
						 }
						 else { // So j equal to pentomino[0].length-1
							  i++;
							  j = 0;
						 }
					}
			  }
		 }
		 if(counter == pentomino[0].length) {
			  return false;
		 }
	}

	public Boolean collisionRight(String[][] pentomino, int x, int y) {
		 int i = 0;
		 int j = 0;
		 while(i < pentomino.length) {
			  while(j < pentomin[0].length) {
					if(pentomino[i][j] != "-" && x + pentomino.length < board.length - 1 && board[y+i][x+j+1] == "-") { // Looks if there is space to the right of the shape()
						 counter++;
						 i++;
						 j = 0;
					}
					else {
						 if(j < pentomino[0].length-1) {
							  j++;
						 }
						 else { // So j equal to pentomino[0].length-1
							  i++;
							  j = 0;
						 }
					}
			  }
		 }
		 if(counter == pentomino[0].length) {
			  return false;
		 }
	}*/


	public void printBoard() {
		for (int m = 0; m < board.length; m++) {
			for (int n = 0; n < board[m].length; n++) {
				System.out.print(board[m][n] + " ");

			}
			System.out.println("");
		}
	}

}