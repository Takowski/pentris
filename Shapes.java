/** In this Class we build the shapes and some methods to rotate or mirroring them */
public class Shapes {

	/**
	Build a 2D array filled with '-'
	@param length The amount of rows the empty array will have
	@param width The amount of columns the empty array will have
	@return shape The empty array.
	*/
	public String[][] buildShapes(int length, int width){
		String[][] shape = new String[length][width];

		for(int i=0;i<length;i++) {
			for (int j=0; j<width;j++) {
				shape[i][j]="-";
			}
		}
		return shape;
	}

	/**
	Filling an empty array with I's at the right places
	@return shapeI The filled array
	*/
	public String[][] buildShapeI() {
	   String[][]  shapeI=buildShapes(5,1);

	   for (int i=0; i<shapeI.length; i++) {
	   	shapeI[i][0]="I";
	   }
	   return shapeI;
	}

	/**
	Filling an empty array with L's at the right places
	@return shapeL The filled array
	*/
	public String[][] buildShapeL(){
		String[][] shapeL=buildShapes(4,2);

		for (int i=0; i<shapeL.length; i++) {
			for (int j=0; j<shapeL[i].length; j++) {
				if(j==0 	|| i==0 & j==1) {
					shapeL[i][j]="L";
				}
			}
		}
		return shapeL;
	}

	/**
	Filling an empty array with Y's at the right places
	@return shapeY The filled array
	*/
	public String[][] buildShapeY(){
		String[][] shapeY=buildShapes(4,2);

		for (int i=0; i<shapeY.length; i++) {
			for (int j=0; j<shapeY[i].length; j++) {
				if(j==0 	|| i==1 && j==1) {
				shapeY[i][j]="Y";
				}
			}
		}
		return shapeY;
	}

	/**
	Filling an empty array with P's at the right places
	@return shapeP The filled array
	*/
	public String[][] buildShapeP(){
		String[][] shapeP=buildShapes(3,2);

		for (int i=0; i<shapeP.length; i++) {
			for (int j=0; j<shapeP[i].length; j++) {
				if(j==0 || (i<=1 && j==1)) {
					shapeP[i][j]="P";
				}
			}
		}
		return shapeP;
	}

	/**
	Filling an empty array with N's at the right places
	@return shapeN The filled array
	*/
	public String[][] buildShapeN(){
		String[][] shapeN=buildShapes(4,2);

		for (int i=0; i<shapeN.length; i++) {
			for (int j=0; j<shapeN[i].length; j++) {
				if(j==0 && i<3 || i>1 && j==1) {
					shapeN[i][j]="N";
				}
			}
		}
		return shapeN;
	}

	/**
	Filling an empty array with U's at the right places
	@return shapeU The filled array
	*/
	public String[][] buildShapeU(){
		String[][] shapeU=buildShapes(3,2);

		for (int i=0; i<shapeU.length; i++) {
			for (int j=0; j<shapeU[i].length; j++) {
				if(j==0 || i==0 && j==1 || i==2 && j==1) {
				shapeU[i][j]="U";
				}
			}
		}
		return shapeU;
	}

	/**
	Filling an empty array with V's at the right places
	@return shapeV The filled array
	*/
	public String[][] buildShapeV(){
		String [][] shapeV=buildShapes(3,3);

		for (int i=0; i<shapeV.length; i++) {
			for (int j=0; j<shapeV[i].length; j++) {
				if(j==0 	|| i==0) {
				shapeV[i][j]="V";
				}
			}
		}
		return shapeV;
	}

	/**
	Filling an empty array with T's at the right places
	@return shapeT The filled array
	*/
	public String [][] buildShapeT(){
		String [][] shapeT=buildShapes(3,3);

		for (int i=0; i<shapeT.length; i++) {
			for (int j=0; j<shapeT[i].length; j++) {
				if(j==1 	|| i==0 ) {
				shapeT[i][j]="T";
				}
			}
		}
		return shapeT;
	}

	/**
	Filling an empty array with X's at the right places
	@return shapeX The filled array
	*/
	public String [][] buildShapeX(){
		String [][] shapeX=buildShapes(3,3);

		for (int i=0; i<shapeX.length; i++) {
			for (int j=0; j<shapeX[i].length; j++) {
				if(j==1 	|| i==1) {
				shapeX[i][j]="X";
				}
			}
		}
		return shapeX;
	}

	/**
	Filling an empty array with Z's at the right places
	@return shapeZ The filled array
	*/
	public String [][] buildShapeZ(){
		String [][] shapeZ=buildShapes(3,3);

		for (int i=0; i<shapeZ.length; i++) {
			for (int j=0; j<shapeZ[i].length; j++) {
				if((j==0 && i==0 || j==2 &&i==2) || i==1 ) {
				shapeZ[i][j]="Z";
				}
			}
		}
		return shapeZ;
	}

	/**
	Filling an empty array with F's at the right places
	@return shapeF The filled array
	*/
	public String[][] buildShapeF(){
		String [][] shapeF=buildShapes(3,3);

		for (int i=0; i<shapeF.length; i++) {
			for (int j=0; j<shapeF[i].length; j++) {
				if(j==0 && i==0 || j==1 && i==2 || i==1 ) {
				shapeF[i][j]="F";
				}
			}
		}
		return shapeF;
	}

	/**
	Filling an empty array with W's at the right places
	@return shapeW The filled array
	*/
	public String[][] buildShapeW(){
		String [][] shapeW=buildShapes(3,3);

		for (int i=0; i<shapeW.length; i++) {
			for (int j=0; j<shapeW[i].length; j++) {
				if(i<2 && j==0	|| i==1 && j<2 || j>0 && i==2) {
				shapeW[i][j]="W";
				}
			}
		}
		return shapeW;
	}

	// With this method we just interchange the rows and the collumns of the shape. diagonal: '\'
	public String [][] rowCollumnInterchange(String[][] shape){
		String [][] rcShape=new String[shape[0].length][shape.length];
		for (int i=0; i<rcShape.length;i++){
			for (int j=0; j<rcShape[0].length; j++){
				rcShape[i][j]=shape[j][i];
			}
		}
		return rcShape;
	}

	// This method mirror the shape both horizontal and vertical. Diagonal: '/'

	public String[][] diagonalMirroring(String[][] shape){
		String[][] dmShape=new String[shape.length][shape[0].length];
		for (int i=0; i<dmShape.length; i++){
			for(int j=0; j<dmShape[0].length; j++){
				dmShape[i][j]=shape[shape.length-i-1][shape[0].length-j-1];
			}
		}
		return dmShape;
	}

	/**
	With this method we get the horizontal mirror image of the shape
	@param shape The shape we want to horizontally mirror
	@return mirroringShape The mirrored shape
	*/
	public String[][] horizontalMirroring(String[][] shape){
		String[][] mirroringShape = new String[shape.length][shape[0].length];
		for (int i=0; i<mirroringShape.length; i++){
			for(int j=0; j<mirroringShape[0].length; j++){
				mirroringShape[i][j]=shape[i][shape[0].length-j-1];
			}
		}
		return mirroringShape;
	}

	/**
	With this method we get the vertically mirror image of the shape
	@param shape The shape we want to vertically mirror
	@return mirroringShape The mirrored shape
	*/
	public String[][] verticalMirroring(String[][] shape){
		String[][] mirroringShape = new String[shape.length][shape[0].length];
		for (int i=0; i<mirroringShape.length; i++){
			for(int j=0; j<mirroringShape[0].length; j++){
				mirroringShape[i][j]=shape[shape.length-i-1][j];
			}
		}
		return mirroringShape;
	}

	/**
	With this method we get the clockwise rotation of the shape
	@param shape The shape we want to rotate
	@return mirroringShape The rotated shape
	*/
	public String[][] rotateClock(String[][] shape){
		String[][] temp = new String[shape[0].length][shape.length];
		for(int i=0; i<shape.length;i++){
			for(int j=0;j<shape[0].length;j++){
				temp[j][i] = shape[i][j];
			}
		}
		return horizontalMirroring(temp);
	}

	/**
	With this method we get the counter-clockwise rotation of the shape
	@param shape The shape we want to rotate
	@return mirroringShape The rotated shape
	*/
	public String[][] rotateCounterClock(String[][] shape){
		String[][] temp = new String[shape[0].length][shape.length];
		for(int i=0; i<shape.length;i++){
			for(int j=0;j<shape[0].length;j++){
				temp[j][i] = shape[i][j];
			}
		}
		return verticalMirroring(temp);
	}

	/**
	This is used to print the shape on the command prompt
	@param shape the shape to print out
	*/
	public void printShape(String[][] shape) {
		for (int i=0; i<shape.length; i++) {
			for (int j=0; j<shape[0].length; j++) {
				if (j<shape[0].length-1) {
				System.out.print(shape[i][j]+ " ");
				}else {
					System.out.println(shape[i][j]);
				}
			}
		}
	}

}
