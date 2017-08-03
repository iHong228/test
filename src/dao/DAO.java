package dao;

import dto.FrameworkDTO;
import framework.Product;

/**
 * Created by user on 2017-07-31.
 */
public interface DAO {
    void add(Product book);

    void remove(String BookName);

    void edit(String BookName, Product Book);

    FrameworkDTO get(String BookName);

    FrameworkDTO getAll();

    int count();

    void removeAll();
}
