package nyft.diploma.report.db;

import nyft.diploma.dao.DBConnect;
import nyft.diploma.report.model.ManagerReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Vlad on 21.05.2016.
 */
public class ManagerDataBeanMaker {
    public ArrayList<ManagerReport> getDataBeanList() throws SQLException, ClassNotFoundException {

        ArrayList<ManagerReport> userRolesList = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection()) {
            String query = "SELECT Manager.Manager_code AS \"Manager code\",\n" +
                    "       Manager.Initials AS \"Initials\",\n" +
                    "       Manager.Experience AS \"Experience\",\n" +
                    "       Manager.Successful_deals AS \"Successful deals\"\n" +
                    "FROM Manager";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        userRolesList.add(new ManagerReport(rs.getLong("manager Code"),rs.getString("initials"), rs.getLong("experience"), rs.getString("successful Deals")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRolesList;
    }
}
