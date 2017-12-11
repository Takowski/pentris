import java.util.*;

public class Population{
    private int size;
    private Genome[] genomes;
    private ArrayList<int[]> innovations; //index = innovation# , int[0] in-node#, int[1] out-node#

    private final double NODE_MUTATION_CHANCE = 0.4;
    private final double CONNECTION_MUTATION_CHANCE = 0.6;
    private final double WEIGHT_MUTATION_CHANCE = 0.8;
    //private final double NODE_MUTATION_CHANCE = 0.4;

    private final int MAX_AMOUNT_NODE = 1000;

    private double[] inputs;
    private double[] outputs;

    public Population(int size){
        this.size = size;
        genomes = new Genome[size];
        for(Genome g: genomes){
            g = new Genome();
        }
    }
    public void initialize(){
        innovations = new ArrayList<int[]>();
        inputs = new double[76]; //75gridCells + bias
        outputs = new double[5]; //5buttons
        for(int i=0; i<size; i++){

        }
    }
    private void CrossOver(Genome g1, Genome g2){

    }
    private void mutuation(Genome g){
        //node mutation
        if(Math.random()>NODE_MUTATION_CHANCE){
            ArrayList<Integer> hidden = g.getHiddenNodes();
            hidden.sort();
        }
        //weight mutation
        if(Math.random()>WEIGHT_MUTATION_CHANCE){
            //int[] hidden = g.getHiddenNodes();
        }
        //node mutation
        if(Math.random()>CONNECTION_MUTATION_CHANCE){
            ArrayList<Integer> hidden = g.getHiddenNodes();
            int inputConnection, outputConnection;
            do{
                do{
                    inputConnection = ((int)Math.random()*(inputs.length + hidden.get(hidden.size()-1) - 5))-inputs.length;
                    if(inputConnection > 0) inputConnection += 4;
                } while(inputConnection > 0 && hidden.indexOf(inputConnection != -1));
                do{
                    if(hidden.get(hidden.size()-1) != 0) outputConnection = (int)(Math.random()*hidden.get(hidden.size()-1));
                    else outputConnection = (int)(Math.random()*outputs.length);
                } while(outputConnection >= 5 && hidden.indexOf(outputConnection != -1));
            } while(outputConnection = inputConnection);
            if(inputConnection > outputConnection){
                int temp = inputConnection;
                inputConnection = outputConnection;
                outputConnection = temp;
            }
            
            int[] newConnection = {inputConnection,outputConnection};
            if(innovations.indexOf(newConnection) == -1){

            }
        }
        //node mutation
    }
    public void setPopulation(ArrayList<Genome> list){
        for(int i=0; i<size; i++){
            genomes[i] = list.get(i);
        }
    }
    public ArrayList<Genome> getPopulationList(){
        ArrayList<Genome> list = new ArrayList<Genome>();
        for(int i=0; i<size; i++){
            list.add(genomes[i]);
        }
        return list;
    }
    public int getGeneralFitness(){
        int sumFitness = 0;
        for(Genome g: genomes){
            sumFitness += g.getFitness();
        }
        return sumFitness/size;
    }
    public Genome getGenome(int n){
        return genomes[n];
    }
}
