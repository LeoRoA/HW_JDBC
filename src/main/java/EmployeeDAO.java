import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void create (Employee employee) throws SQLException;
    Employee readById (int id);
    List<Employee> readAll ();
    void updateById(int id, int city_id);
    void deleteById(int id);
}
