package nyft.diploma.report.db;

import nyft.diploma.dao.DBConnect;
import nyft.diploma.report.model.FreeApparmentReport;
import nyft.diploma.report.model.SaledAppartmentReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Vlad on 22.05.2016.
 */
public class FreeApparmentDataBeanMaker {
    public ArrayList<FreeApparmentReport> getDataBeanList() throws SQLException, ClassNotFoundException {

        ArrayList<FreeApparmentReport> userRolesList = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection()) {
            String query = "SELECT Free_appartment.Appartment_code AS \"Appartment code\",\n" +
                    "       Free_appartment.Adress AS \"Adress\",\n" +
                    "       Free_appartment.Price AS \"Price\",\n" +
                    "       Free_appartment.Appartment_number AS \"Appartment number\",\n" +
                    "       Free_appartment.Area AS \"Area\",\n" +
                    "       Free_appartment.Developer_code AS \"Developer code\"\n" +
                    "FROM Free_Appartment";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        userRolesList.add(new FreeApparmentReport(rs.getLong("appartment Code"), rs.getString("adress"), rs.getLong("price"), rs.getLong("appartment Number"), rs.getLong("area"), rs.getLong("developer Code")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRolesList;

    }
}
