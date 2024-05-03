package by.itclass.model.services;

import by.itclass.model.dao.TVDao;
import by.itclass.model.entities.TV;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static by.itclass.constants.JSPConstant.*;

public class TVService implements Service {

    private final TVDao dao;

    public TVService() {
        dao = new TVDao();
    }



    public List<TV> getTVS(Map<String, String[]> params) {
        if (params.isEmpty()) {
            return dao.selectAllTV();
        }
        var vendors = params.get(VENDOR_PARAM);
        var screenSize = params.get(SCREEN_SIZE_PARAM);
        var from = params.get(PRICE_FROM_PARAM)[0];
        var to = params.get(PRICE_TO_PARAM)[0];
        return dao.selectFilteredTV(vendors, screenSize, from, to);

    }


}
