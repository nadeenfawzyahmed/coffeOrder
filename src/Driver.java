import java.sql.*;

public class Driver {
    public String retrievecoffeName( int id) throws Exception {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/coffeapp?user=root&password=pluralsight&serverTimezone=UTC");
        PreparedStatement statement = connection.prepareStatement("select coffeName from coffetypes where coffeId='"+id+"' ");

        ResultSet result = statement.executeQuery();
        String name="";

        if(result.next()) {

            name = result.getString("coffeName");
        }
        result.close();
        statement.close();
        connection.close();


        return name;
    }
    public  void addorder(String userName, String orderName) throws Exception {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/coffeapp?user=root&password=pluralsight&serverTimezone=UTC");

             PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "INSERT INTO new_table "
                                     + "(userName, orderName, currentTime) "
                                     + "VALUES (?, ?, current_timestamp())",

                             Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, userName);

            preparedStatement.setString(2, orderName);


            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

                int autogenkey = 0;

                if (resultSet.next()) {
                    autogenkey = resultSet.getInt(1);
                }




            }
        }

    }


}
