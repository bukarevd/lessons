package DAO;



public interface Dao {
    void add(DataClass object);
//    void add(DataClass object, User user);
    void delete(DataClass object);
    void update(DataClass object);
    void getAll();
    void getById(DataClass object);
}
