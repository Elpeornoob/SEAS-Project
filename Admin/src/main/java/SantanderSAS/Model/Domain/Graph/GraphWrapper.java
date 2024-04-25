package SantanderSAS.Model.Domain.Graph;

public class GraphWrapper {
    private GraphEntity graph;

    public GraphWrapper(GraphEntity graph) {
        this.graph = graph;
    }

    public GraphEntity getGraph() {
        return graph;
    }

    public void setGraph(GraphEntity graph) {
        this.graph = graph;
    }
}