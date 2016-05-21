package nyft.diploma.report.db;

import nyft.diploma.dao.DBConnect;
import nyft.diploma.report.model.ClientReport;
import nyft.diploma.report.model.DealReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Vlad on 21.05.2016.
 */
public class DealDataBeanMaker {
    public ArrayList<DealReport> getDataBeanList() throws SQLException, ClassNotFoundException {

        ArrayList<DealReport> userRolesList = new ArrayList<>();

        try (Connection connection = DBConnect.getConnection()) {
            String query = "SELECT Deal.Deal_code AS \"Client code\",\n" +
                    "       Deal.Deal_date AS \"Deal date\",\n" +
                    "       Deal.Adress AS \"Adress\",\n" +
                    "       Deal.Price AS \"Price\",\n" +
                    "       Deal.Client_code AS \"Client code\",\n" +
                    "       Deal.Appartment_code AS \"Appartment code\"\n" +
                    "FROM Deal";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        userRolesList.add(new DealReport(rs.getLong("client Code"), rs.getString("deal Date"), rs.getString("adress"), rs.getString("price"), rs.getLong("client Code"), rs.getLong("appartment Code")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRolesList;
    }
}
