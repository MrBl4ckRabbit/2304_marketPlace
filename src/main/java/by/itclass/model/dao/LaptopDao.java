package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.Laptop;
import by.itclass.model.entities.TV;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static by.itclass.constants.DBConstant.*;

public class LaptopDao {
    public static final String SELECT_ALL_LAPTOP = "Select * From laptop";

    public List<Laptop> selectAllLaptop() {

        var laptops = new ArrayList<Laptop>();
        try (var cn = ConnectionManager.getConnection();
             var ps = cn.prepareStatement(SELECT_ALL_LAPTOP)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                var id = rs.getInt(ID_COL);
                var vendor = rs.getString(VENDOR_COL);
                var model = rs.getString(MODEL_COL);
                var cpu = rs.getString(CPU_COL);
                var memorySize = rs.getInt(MEMORY_SIZE_COL);
                var price = rs.getDouble(PRICE_COL);
                laptops.add(new Laptop(id, vendor, model, cpu, memorySize, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return laptops;
    }
}
