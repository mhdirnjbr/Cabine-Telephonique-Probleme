import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Graph extends SearchStatistics {
    private int vertices;
    private int[][] matrix;
    private int initialState;
    private int finalState;
    private int optimalCost;


    /**
     * Ça crée un graphe avec un état initial et final, et nombre de sommets spécifique.
     *
     * @param vertices     Nombre de sommets
     * @param initialState État initial
     * @param finalState   État final
     */
    public Graph(int vertices, int initialState, int finalState) {
        this.vertices = vertices;
        this.matrix = new int[vertices][vertices];
        this.initialState = initialState;
        this.finalState = finalState;
    }

    /**
     * Ça permet d'ajouter un arc avec un coût spécifique entre deux sommets du graphe.
     *
     * @param source      Sommet de départ
     * @param destination Sommet de destination
     * @param weight      Cout de l'arc
     */
    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
    }

    /**
     * Ça permet de determiner les sommets adjacents et leurs coûts par rapport au sommet en question.
     *
     * @param vertex Sommet en question
     * @return Un dictionnaire des sommets adjacents et leurs coûts
     */
    public HashMap<Integer, Integer> getAdjacents(int vertex) {
        HashMap<Integer, Integer> adjacents = new HashMap<>(); // <vertex, cost>
        for (int j = 0; j < vertices; j++) {
            if (matrix[vertex][j] != 0) {
                adjacents.put(j, matrix[vertex][j]);
            }
        }
        return adjacents;
    }

    /**
     * Ça permet de trouver le chemin le plus optimal en utilisant l'algorithme de coût uniforme (uniforme cost search).
     *
     * @return Chemin optimal de l'état initial à l'état final
     */
    public ArrayList<Integer> findOptimalPath() {

        PriorityQueue<Node> Q = new PriorityQueue<>();
        Node startNode = new Node(initialState, null, 0);

        Q.add(startNode);
        increaseVisited();

        while (!Q.isEmpty()) {
            Node node = Q.poll();
            increaseDeveloped();

            if (node.getState() == finalState) {
                optimalCost = node.getCost();
                return determinePath(node);
            }

            HashMap<Integer, Integer> adjacents = this.getAdjacents(node.getState());
            for (int adjacentState : adjacents.keySet()) {
                int cost = adjacents.get(adjacentState);
                Node nodeAdjacent = new Node(adjacentState, node, node.getCost() + cost);
                Q.add(nodeAdjacent);
                increaseVisited();
            }
        }
        return null;
    }

    /**
     * Ça permet de determiner le chemin à traver lequel on est arrivé à l'état final.
     *
     * @param node Un node représentant l'etat final
     * @return Chemin optimal de l'état initial à l'état final
     */
    private ArrayList<Integer> determinePath(Node node) {
        ArrayList<Integer> optimalPath = new ArrayList<>();
        while (node != null) {
            optimalPath.add(0, node.getState());
            node = node.getParent();
        }
        return optimalPath;
    }


    /**
     * Ça permets d'afficher la matrice d'adjacentes.
     */
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.printf("%8d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int getOptimalCost() {
        return optimalCost;
    }
}
