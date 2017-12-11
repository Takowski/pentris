import java.util.*;
import java.io.Serializable;

public class Genome implements Serializable{
    private ArrayList<double[]> connections; //[inovation, in node (-76 - 0) , out node(hidden: >7; output: -1 - -6)]
    private ArrayList<Double> weights;
    private ArrayList<Integer> hiddenNodes; //[5->MAX NODE AMOUNT]
    private int fitness;

    public Genome(ArrayList<double[]> connections, int[] hiddenNodes, int fitness){
        this.connections = connections;
        this.hiddenNodes = hiddenNodes;
        this.fitness = fitness;
    }
    public Genome(){}
    public double[] getOutput(double[] inputs){
        double[] outputs = new double[5];
        ArrayList<Double> hiddenActivation = new ArrayList<Double>();

        for(int i=0; i<connections.size(); i++){
            double[] connection = connections.get(i);
            int in = (int)connection[0];
            int out = (int)connection[1];
            double weight = connection[2];
            if(out>=5){
                for(int i=1; i<hiddenActivation.size(); i+=2){
                    hiddenActivation.set(i,sigmoid(hiddenActivation.get(i)));
                }
            }
            if(in<=0) {
                if(out>=5) {
                    int pos = hiddenActivation.indexOf(1.0*out);
                    if(pos == -1){
                        hiddenActivation.add(1.0*out);
                        hiddenActivation.add(inputs[-in] * weight);
                    }
                    else {
                        hiddenActivation.set(pos+1,hiddenActivation.get(pos+1)+(inputs[-in] * weight));
                    }
                }
                else {
                    outputs[out] += inputs[-in] * weight;
                }
            }
            else {
                int pos = hiddenActivation.indexOf(1.0*in);
                if(pos>=0){
                    if(out>=5) {
                        int pos2 = hiddenActivation.indexOf(1.0*out);
                        if(pos2 == -1){
                            hiddenActivation.add(1.0*out);
                            hiddenActivation.add(hiddenActivation.get(pos+1) * weight);
                        }
                        else {
                            hiddenActivation.set(pos2+1,hiddenActivation.get(pos2+1)+(hiddenActivation.get(pos+1) * weight));
                        }
                    }
                    else {
                        outputs[out] += hiddenActivation.get(pos+1) * weight;
                    }
                }
            }
        }
        for(int i=0; i<outputs.length; i++){
            outputs[i] = sigmoid(outputs[i]);
        }
        return outputs;
    }
    private double sigmoid(double value){
        return 1/(1+Math.exp(value)); //to be adjusted?
    }
    public void setFitness(int score, int time){
        this.fitness = score/time;
    }
    public void addConnection(double[] connection){
        connections.add(connection);
    }
    public void removeConnection(double[] connection){
        connections.remove(connection);
    }
    public ArrayList<double[]> getConnections(){
        return connections;
    }
    public ArrayList<Integer> getHiddenNodes(){
        return hiddenNodes;
    }
    public int getFitness(){
        return fitness;
    }
    public Genome copy(){
        return new Genome(connections,hiddenNodes,fitness);
    }
}
