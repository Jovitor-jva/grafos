package List;

public class aresta {
    int id;
    String name;
    adjacente[] verticeAdjacente;
    public aresta(int id, String name){
        this.id = id;
        this.name = name;
		this.verticeAdjacente = new adjacente[0];
    }
    // public Nodes(int[] adj){
    //     this.adj = new Adjacent[adj.length];
    //     for(int i = 0; i < adj.length; i++){
    //         this.adj[i] = new Adjacent(adj[i], 1);
    //     }
    // }
    
    public void adicionaNoAdjacente(int id, double peso){
        adjacente[] noAdjacente = new adjacente[this.verticeAdjacente.length + 1];
        for(int i = 0; i < this.verticeAdjacente.length; i++){
        	noAdjacente[i] = this.verticeAdjacente[i];
        }
        noAdjacente[this.verticeAdjacente.length] = new adjacente(id, peso);
        this.verticeAdjacente = noAdjacente;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public adjacente[] getAdjacent(){
        return this.verticeAdjacente;
    }
    
}
