package nyft.diploma.report.db;

import nyft.diploma.dao.DBConnect;
import nyft.diploma.report.model.ClientReport;
import nyft.diploma.report.model.ManagerReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Vlad on 21.05.2016.
 */
public class ClientDataBeanMaker {
    public ArrayList<ClientReport> getDataBeanList() throws SQLException, ClassNotFoundException {

        ArrayList<ClientReport> userRolesList = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection()) {
            String query = "SELECT Client.Client_code AS \"Client code\",\n" +
                    "       Client.Initials AS \"Initials\",\n" +
                    "       Client.Mobile_phone AS \"Mobile phone\",\n" +
                    "       Client.Adress AS \"Adress\",\n" +
                    "       Client.Passport_serial AS \"Passport serial\",\n" +
                    "       Client.Appartment_code AS \"Appartment code\"\n" +
                    "FROM Client";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        userRolesList.add(new ClientReport(rs.getLong("client Code"), rs.getString("initials"), rs.getString("mobile Phone"), rs.getString("adress"), rs.getString("passport Serial"), rs.getLong("appartment Code")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRolesList;
    }
}
