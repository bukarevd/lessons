package DAO;



public interface Dao {
    void add(DataClass object);
    void delete(DataClass object);
    void update(DataClass object);
    void getAll();
    void getById(DataClass object);
}
