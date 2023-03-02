package DAO;

import model.City;

import java.util.List;

public interface CityDao {
    void create(City city);

    City readById(int id);

    List<City> readAll();

    void updateById(City city);

    void deleteById(City city);
}
