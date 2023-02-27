import DAO.CityDao;
import DAO.CityDaoImpl;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDao cityDao = new CityDaoImpl();

        City citySix = new City("City 6");

        cityDao.create(citySix);
        cityDao.updateById(new City(6,"City 10"));
        System.out.println(cityDao.readById(10));
        List<City> cities= cityDao.readAll();
        for (City city : cities) {
            System.out.println(city);
        }
        cityDao.deleteById(new City(6,"City 10"));

        City cityMax = new City(7, "GasTown");
        cityDao.create(cityMax);
        Employee employeeMax = new Employee("Max", "Mad", "male", 30, cityMax);

        employeeDAO.create(employeeMax);
        System.out.println(employeeDAO.readById(13));

        employeeDAO.updateById(new Employee(18, "Max", "Mad", "male", 32, citySix));

        System.out.println(employeeDAO.readById(4));

        employeeDAO.deleteById(employeeMax);

        List<Employee> employeeList = (employeeDAO.readAll());

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }


    }
}

