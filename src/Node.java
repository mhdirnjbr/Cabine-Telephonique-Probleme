public class Node implements Comparable<Node> {
    private int state;
    private int cost;
    private Node parent;

    Node(int state, Node parent, int cost) {
        this.state = state;
        this.parent = parent;
        this.cost = cost;
    }

    public int getState() {
        return state;
    }

    public int getCost() {
        return cost;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.cost, node.cost);
    }
}