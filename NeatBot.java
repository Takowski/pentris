import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class NeatBot{
    private PentWindow window;
    private GameCanvas pannel;
    private String[][] boardS;
    private double[] inputs;
    private Timer t;
    private final String POPULATION_FILE = "Population.dat";

    private int genomeNb=0;
    private Genome currentGenome;
    private Population population;

    private final int SIZE_POPULATION = 100;
    private final int FITNESS_GOAL = 40; //to be adjusted

    private final boolean TRAINING = true;

    public static void main(String[] args){
        new NeatBot();
    }
    public void initializeGame(){
        //currentGenome = population.getGenome(genomeNb);
        genomeNb++;
        window = new PentWindow(true);
        try{
            Robot b = new Robot();
            if(window.getActivePanel() instanceof GameCanvas){
                pannel = (GameCanvas)window.getActivePanel();
            }
            t = pannel.getTimer();
            t.addActionListener(new BoardListener());
        }
        catch(AWTException e){
            e.printStackTrace();
        }
    }
    public NeatBot(){
        //if(!loadPopulation(new File(POPULATION_FILE))) population.initialize();
        //population = new Population(SIZE_POPULATION);
        initializeGame();
    }

    private void getInputs(){
        //boardS = pannel.getBoard();
        int posInput = 0;
        for(int i=0; i<boardS.length; i++){
            for(int j=0; j<boardS[0].length; j++){
                if(!boardS[i][j].equals("-")) inputs[posInput] = 1;
                posInput++;
            }
        }
    }
    public boolean loadPopulation(File x){
        ObjectInputStream inputStream = null;
        try{
            inputStream = new ObjectInputStream(new FileInputStream(x));
            ArrayList<Genome> genomeList = (ArrayList<Genome>) inputStream.readObject();
            if(genomeList.size() == SIZE_POPULATION){
                population.setPopulation(genomeList);
                return true;
            }
            else System.out.println("Size of saved population do not match actual population size...");
        }
        catch (FileNotFoundException e){
            System.out.println("[Load] FNF Error: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("[Load] IO Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e){
            System.out.println("[Load] CNF Error: " + e.getMessage());
        }
        finally {
            try{
                if(inputStream != null){
                    //inputStream.flush();
                    inputStream.close();
                }
            }
            catch (IOException e){
            System.out.println("[Load] IO Error: " + e.getMessage());
            }
        }
        return false;
    }
    public void savePopulation(File x){
        ObjectOutputStream outputStream = null;
        try{
			outputStream = new ObjectOutputStream(new FileOutputStream(x));
			outputStream.writeObject(population.getPopulationList());
		}
		catch (FileNotFoundException e){
			System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
		}
		catch (IOException e){
			System.out.println("[Update] IO Error: " + e.getMessage());
		}
		finally{
			try{
				if(outputStream != null){
					outputStream.flush();
					outputStream.close();
				}
			}
			catch (IOException e) {
				System.out.println("[Update] Error: " + e.getMessage());
			}
		}
    }

    private class BoardListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(pannel.getGameState()){
                try{
                    Robot b = new Robot();
                    //double[] out = currentGenome.getOutput(pannel.getBoard().getBoard()); //currentGenome to be implemented
                    double[] out = new double[5];
                    for(int i=0 ; i<out.length;i++) out[i] = Math.random();
                    if(out[0] > 0.5) b.keyPress(37);
                    if(out[1] > 0.5) b.keyPress(38);
                    if(out[2] > 0.5) b.keyPress(39);
                    if(out[3] > 0.5) b.keyPress(40);
                    if(out[4] > 0.5) b.keyRelease(40);
                }
                catch(AWTException exception){
                    exception.printStackTrace();
                }
            }
            else{
                //if training: next genome
                System.out.println("test");
            }
        }
    }
}
