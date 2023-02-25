import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        City cityMax = new City(7, "GasTown");
        Employee employeeMax = new Employee("Max", "Mad", "male", 30, cityMax.getCityId());
        employeeDAO.create(employeeMax);

        System.out.println(employeeDAO.readById(13));

        employeeMax = new Employee(18,"Max", "Mad", "male", 32, 4);

        employeeDAO.updateById(employeeMax);

        System.out.println(employeeDAO.readById(16));

        employeeDAO.deleteById(employeeMax);

        List<Employee> employeeList = (employeeDAO.readAll());

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }


    }
}

