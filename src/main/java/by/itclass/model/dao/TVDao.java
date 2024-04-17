package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.TV;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static by.itclass.constants.DBConstant.*;

public class TVDao {
    public static final String SELECT_ALL_TV = "Select * From tv";
    private static TVDao dao;

    private TVDao() {
        ConnectionManager.init();
    }

    public static TVDao getInstance() {
        if (Objects.isNull(dao)) {
            dao = new TVDao();
        }
        return dao;
    }

    public List<TV> selectAllTV() {
        var tvs = new ArrayList<TV>();
        try (var cn = ConnectionManager.getConnection();
             var ps = cn.prepareStatement(SELECT_ALL_TV)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                var id = rs.getInt(ID_COL);
                var vendor = rs.getString(VENDOR_COL);
                var model = rs.getString(MODEL_COL);
                var screenSize = rs.getInt(SCREEN_SIZE_COL);
                var price = rs.getDouble(PRICE_COL);
                tvs.add(new TV(id, vendor, model, screenSize, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tvs;
    }
}
