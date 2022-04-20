package List;

import java.util.LinkedList;

//import java.util.ArrayList;

public class vertice {
    int id;
    int originNode;
    int destinationNode;
    double weight;
    private LinkedList<vertice> verticesAdj = new LinkedList<vertice>();
    public vertice(int id, int originNode, int destinationNode, double weight) {
        this.id = id;
        this.originNode = originNode;
        this.destinationNode = destinationNode;
        this.weight = weight;
    }
    public int getId(){
        return this.id;
    }
    public int getOriginNode(){
        return this.originNode;
    }
    public int getDestinationNode(){
        return this.destinationNode;
    }
    public double getWeight(){
        return this.weight;
    }
    public LinkedList<vertice> getVerticesAdj() {
		return verticesAdj;
	}

	public void setVerticesAdj(LinkedList<vertice> vertices) {
		this.verticesAdj = vertices;
	}

}
