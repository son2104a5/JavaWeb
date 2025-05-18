package demo.ss08.service;

import demo.ss08.model.LandPlot;

import java.util.List;

public interface FarmService {
    List<LandPlot> getLandPlots();
    void plantSeed(int plotId, int seedId);
}

