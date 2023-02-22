import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "4294967297";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM employee WHERE id=2")) {

                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next())
                    System.out.println(resultSet.getInt("id") + " "
                            + resultSet.getString("first_name") + " "
                            + resultSet.getString("last_name") + " "
                            + resultSet.getString("gender") + " "
                            + resultSet.getString("age") + " "
                            + resultSet.getString("city_id"));

            } catch (SQLException e) {
                e.printStackTrace();
            }

            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            City cityMax = new City(7, "GasTown");
            Employee employeeMax = new Employee(7, "Max", "Mad", "male", 30, cityMax);
            employeeDAO.create(employeeMax);

            System.out.println(employeeDAO.readById(7));

            employeeDAO.updateById(7, 4);

            System.out.println(employeeDAO.readById(7));

            employeeDAO.deleteById(7);

            List<Employee> employeeList = new ArrayList<>(employeeDAO.readAll());

            for (Employee employee : employeeList) {
                System.out.println(employee);
            }


        }
    }
}
