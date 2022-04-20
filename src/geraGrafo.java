
//import List.adjacente;
import List.aresta;
import List.vertice;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class geraGrafo {
	public static void main(String[] args) throws Exception {
		File repositorio;
		Scanner leitorGrafo;

		LinkedList<aresta> listaArestas = new LinkedList<aresta>();
		LinkedList<vertice> vertices = new LinkedList<vertice>();

		try {
			repositorio = new File("src/File/arestas.txt");
			leitorGrafo = new Scanner(repositorio);
			while (leitorGrafo.hasNextLine()) {
				String data = leitorGrafo.nextLine();
				String[] split = data.split(",");
				int id = Integer.parseInt(split[0]);
				int origem = Integer.parseInt(split[1]);
				int destino = Integer.parseInt(split[2]);
				double peso = Double.parseDouble(split[3]);
				vertice vert = new vertice(id, origem, destino, peso);
				vertices.add(vert);
			}
			leitorGrafo.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured reading 'arestas.txt'");
			e.printStackTrace();
		}

		try {
			repositorio = new File("src/File/vertices.txt");
			leitorGrafo = new Scanner(repositorio);
			while (leitorGrafo.hasNextLine()) {
				String data = leitorGrafo.nextLine();
				String[] split = data.split(",");
				int id = Integer.parseInt(split[0]);
				String name = split[1];
				aresta node = new aresta(id, name);
				listaArestas.add(node);
			}
			leitorGrafo.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro ao ler o 'vertices.txt'");
			e.printStackTrace();
		}
		eNoAdjacente(listaArestas, vertices);
		mostraAdjacentes(listaArestas);
		System.out.println("");

	}

	public static void eNoAdjacente(LinkedList<aresta> vertice, LinkedList<vertice> aresta) {
		System.out.println("Nós lidos a partir do txt" + "\n");
		for (int i = 0; i < vertice.size(); i++) {
			aresta n = (aresta) vertice.get(i);
			for (int j = 0; j < aresta.size(); j++) {
				vertice e = (vertice) aresta.get(j);
				
				if (e.getOriginNode() == n.getId()) {
					n.adicionaNoAdjacente(e.getDestinationNode(), e.getWeight());
					
					System.out.println("Nó Adjacente" + n.getName());
				}
			}
		}
	}
	public vertice getVerticeBusca(LinkedList<vertice> vertices, int id) {
		
		vertice vert = null;//Assume que o vertice buscado é null e percorre a list
		
        for(int i=0; i < vertices.size(); i++){
            if (vertices.get(i).getId() == id){//Se na comparação for igual a ID
                vert = vertices.get(i); //A variável recebe aquele objeto
                break;
            }
        }
        return vert;
    }
	public void buscaEmLargura(LinkedList<vertice> vertices, int id){
        LinkedList<vertice> verticesMarcados = new LinkedList<vertice>(); //vertices lidos
        LinkedList<vertice> fileira = new LinkedList<vertice>(); //vertices analisados
        vertice atual = vertices.get(id - 1); //primeiro vertice lido
        verticesMarcados.add(atual); // adiciona nos lidos
        System.out.println(atual.getId()); //imprime o vertice
        fileira.add(atual); // adiciona nos analisados
        while(fileira.size() > 0){
            vertice verticeVisitado = fileira.get(0); // recebe a posi��o 0
            for(int i=0; i < verticeVisitado.getVerticesAdj().size(); i++){
                vertice proximo = verticeVisitado.getVerticesAdj().get(i); // recebe os vertices adjacentes na pos i
                if (!verticesMarcados.contains(proximo)){ //se o v�rtice ainda n�o foi marcado
                	verticesMarcados.add(proximo);
                    System.out.println(proximo.getId());
                    fileira.add(proximo);
                }
            }
            fileira.remove(0);
        }
    }

	public static void mostraAdjacentes(LinkedList<aresta> vertice) {
		int i;
		for (i = 0; i < vertice.size(); i++) {
			aresta n = (aresta) vertice.get(i);
			System.out.println("\n");
			System.out.println(" - " + "O Vértice " + n.getName() + " possui os seguintes vértices adjacentes: ");
			System.out.println("\n");
			for (int j = 0; j < n.getAdjacent().length; j++) {
				
				System.out.println("O Vértice adjacente: " 
			+ n.getAdjacent()[j].getId() + " " + "tem o seguinte " 
						+ "peso: " + n.getAdjacent()[j].getPeso());
			}
		}
	}
	/*
	 * public static void adjacentNodes(LinkedList<Nodes> node, LinkedList<Edges>
	 * edge){ // Parse Nodes for(int i = 0; i < node.size(); i++) { Nodes n =
	 * (Nodes)node.get(i); System.out.println("O vÃ©rtice " + n.getName() +
	 * " possui os seguintes vÃ©rtices adjacentes: "); // Parse Edges for(int j = 0;
	 * j < edge.size(); j++) { Edges e = (Edges)edge.get(j); // If the id is equal
	 * to the current node if(e.getOriginNode() == n.getId()) {
	 * System.out.println("-> LigaÃ§Ã£o para o vÃ©rtice " + e.getDestinationNode() +
	 * " com peso " + e.getWeight()); } else if(e.getDestinationNode()==n.getId()) {
	 * System.out.println("-> LigaÃ§Ã£o do vÃ©rtice " + e.getOriginNode() +
	 * " com peso " + e.getWeight()); } } } }
	 */

}
