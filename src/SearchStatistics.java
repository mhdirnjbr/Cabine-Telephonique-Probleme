public class SearchStatistics {
    private int numberOfVisitedStates = 0;
    private int numberOfDevelopedStates = 0;

    public void increaseVisited() {
        numberOfVisitedStates++;
    }

    public void increaseDeveloped() {
        numberOfDevelopedStates++;
    }

    public String statistics() {
        return "Number of visited nodes : " + numberOfVisitedStates + "\n" +
                "Number of developed nodes : " + numberOfDevelopedStates + "\n";
    }
}