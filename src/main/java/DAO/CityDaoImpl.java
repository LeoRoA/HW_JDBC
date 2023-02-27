package DAO;

import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import session.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {
    public CityDaoImpl() {
    }

    @Override
    public void create(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public City readById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
    }

    @Override
    public List<City> readAll() {
        List<City> cities;
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            cities = new ArrayList<>(session.createQuery("From City", City.class).list());
            transaction.commit();
        }
        return cities;
    }

    @Override
    public void updateById(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
