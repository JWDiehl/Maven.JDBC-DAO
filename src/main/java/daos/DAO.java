package daos;

import java.util.List;

//Generic DAO interface for CRUD operations
public interface DAO<T> {
    T findById(int id);
    List<T> findAll();
    T update(T dto);
    T create(T dto);
    void delete(int id);
}
