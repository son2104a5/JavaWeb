package demo.ss08.service;

import demo.ss08.model.LandPlot;
import demo.ss08.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    private final List<LandPlot> landPlots = new ArrayList<>();

    @Autowired
    private WarehouseSeedsService warehouseService;

    public FarmServiceImpl() {
        for (int i = 1; i <= 20; i++) {
            landPlots.add(new LandPlot(i));
        }
    }

    @Override
    public List<LandPlot> getLandPlots() {
        return landPlots;
    }

    @Override
    public void plantSeed(int plotId, int seedId) {
        Warehouse ws = warehouseService.findById(seedId);
        if (ws != null && ws.getQuantity() > 0) {
            for (LandPlot plot : landPlots) {
                if (plot.getPlotId() == plotId && plot.isEmpty()) {
                    plot.setSeed(ws);
                    ws.setQuantity(ws.getQuantity() - 1);
                    break;
                }
            }
        }
    }
}

