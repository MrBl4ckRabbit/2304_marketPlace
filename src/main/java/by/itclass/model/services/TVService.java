package by.itclass.model.services;

import by.itclass.model.dao.TVDao;
import by.itclass.model.entities.TV;

import java.util.List;
import java.util.Objects;

public class TVService {
    private static TVService service;
    private TVDao dao;

    private TVService() {
        dao = TVDao.getInstance();
    }

    public static TVService getInstance() {
        if (Objects.isNull(service)) {
            service = new TVService();
        }
        return service;
    }

    public List<TV> getAllTV() {
        return dao.selectAllTV();
    }
}
