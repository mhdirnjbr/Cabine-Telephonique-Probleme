public class Main {
    public static final int VERTICES = 7;
    public static final int INITIAL_STATE = 0;
    public static final int FINAL_STATE = 6;


    public static void main(String[] args) {

        // Création de graphe
        Graph g = new Graph(VERTICES, INITIAL_STATE, FINAL_STATE);

        // Initialisation de matrice d'adjacence (dans ce cas-là : matrice des poids)

        g.addEdge(0, 1, 2000);
        g.addEdge(0, 2, 2400);
        g.addEdge(0, 3, 3600);
        g.addEdge(0, 6, 17800);
        g.addEdge(1, 2, 2000);
        g.addEdge(1, 3, 2600);
        g.addEdge(1, 6, 13000);
        g.addEdge(2, 3, 2000);
        g.addEdge(2, 4, 3400);
        g.addEdge(2, 6, 8600);
        g.addEdge(3, 4, 2000);
        g.addEdge(3, 5, 4000);
        g.addEdge(3, 6, 4800);
        g.addEdge(4, 5, 2000);
        g.addEdge(4, 6, 2400);
        g.addEdge(5, 6, 2000);

        // g.printGraph();

        System.out.println("Optimal path : " + g.findOptimalPath());
        System.out.println("Optimal cost : " + g.getOptimalCost());
        System.out.println("-------------------------------");
        System.out.println(g.statistics());

    }
}
