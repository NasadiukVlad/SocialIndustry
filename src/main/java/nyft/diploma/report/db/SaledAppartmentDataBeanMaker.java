package nyft.diploma.report.db;

import nyft.diploma.dao.DBConnect;
import nyft.diploma.report.model.ManagerReport;
import nyft.diploma.report.model.SaledAppartmentReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Vlad on 21.05.2016.
 */
public class SaledAppartmentDataBeanMaker {

    public ArrayList<SaledAppartmentReport> getDataBeanList() throws SQLException, ClassNotFoundException {

        ArrayList<SaledAppartmentReport> userRolesList = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection()) {
            String query = "SELECT Saled_appartment.Appartment_code AS \"Appartment code\",\n" +
                    "       Saled_appartment.Adress AS \"Adress\",\n" +
                    "       Saled_appartment.Price AS \"Price\",\n" +
                    "       Saled_appartment.Appartment_number AS \"Appartment number\",\n" +
                    "       Saled_appartment.Area AS \"Area\",\n" +
                    "       Saled_appartment.Developer_code AS \"Developer code\"\n" +
                    "FROM Saled_appartment";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        userRolesList.add(new SaledAppartmentReport(rs.getLong("appartment Code"), rs.getString("adress"), rs.getLong("price"), rs.getLong("appartment Number"), rs.getLong("area"), rs.getLong("developer Code")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRolesList;

    }
}
