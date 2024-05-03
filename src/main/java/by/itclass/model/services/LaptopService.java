package by.itclass.model.services;

import by.itclass.model.dao.LaptopDao;
import by.itclass.model.dao.TVDao;
import by.itclass.model.entities.Laptop;
import by.itclass.model.entities.TV;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static by.itclass.constants.JSPConstant.*;
import static by.itclass.constants.JSPConstant.PRICE_TO_PARAM;

public class LaptopService implements Service {

    private final LaptopDao dao;

    public LaptopService() {
        dao = new LaptopDao();
    }


    public List<Laptop> getLaptops(Map<String, String[]> params) {
        var laptops = dao.selectAllLaptop();
        if (params.isEmpty()) {
            return laptops;
        }
        var vendors = params.get(VENDOR_PARAM);
        var cpus = params.get(CPU_PARAM);
        var memorySize = params.get(MEMORY_SIZE_PARAM);
        var from = params.get(PRICE_FROM_PARAM)[0];
        var to = params.get(PRICE_TO_PARAM)[0];
        return laptops.stream()
                .filter(it -> vendors == null || ArrayUtils.contains(vendors, it.getVendor()))
                .filter(it -> cpus == null || ArrayUtils.contains(cpus, it.getCpu()))
                .filter(it -> memorySize == null || ArrayUtils.contains(memorySize, String.valueOf(it.getMemorySize())))
                .filter(it -> from.isEmpty() || it.getPrice() >= Double.parseDouble(from))
                .filter(it -> to.isEmpty() || it.getPrice() <= Double.parseDouble(to))
                .toList();
    }
}
