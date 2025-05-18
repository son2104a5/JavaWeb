package demo.ss08.model;

public class LandPlot {
    private int plotId;
    private Warehouse seed; // null nếu ô trống

    public LandPlot(int plotId) {
        this.plotId = plotId;
        this.seed = null;
    }

    public int getPlotId() { return plotId; }
    public void setPlotId(int plotId) { this.plotId = plotId; }

    public Warehouse getSeed() { return seed; }
    public void setSeed(Warehouse seed) { this.seed = seed; }

    public boolean isEmpty() {
        return seed == null;
    }
}

