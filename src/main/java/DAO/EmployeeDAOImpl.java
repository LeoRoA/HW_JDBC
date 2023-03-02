package DAO;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import session.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {


    public EmployeeDAOImpl() {
    }

    @Override
    public void create(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee readById(int id) {
        Employee employeeById =  HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
        HibernateSessionFactoryUtil.getSessionFactory().close();
        return employeeById;
    }

    @Override
    public List<Employee> readAll() {
        return HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Employee", Employee.class).list();
    }

    @Override
    public void updateById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
