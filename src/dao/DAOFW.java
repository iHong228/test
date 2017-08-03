package dao;

import framework.Product;
import dto.FrameworkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

/**
 * Created by user on 2017-07-26.
 */

abstract public class DAOFW implements DAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    abstract protected void add(Product book, JdbcTemplate jdbcTemplate);

    abstract protected void remove(String BookName, JdbcTemplate jdbcTemplate);

    abstract public void edit(String BookName, Product Book, JdbcTemplate jdbcTemplate);

    abstract public FrameworkDTO get(String BookName, JdbcTemplate jdbcTemplate);

    abstract public FrameworkDTO getAll(JdbcTemplate jdbcTemplate);

    abstract public int count(JdbcTemplate jdbcTemplate);

    abstract public void removeAll(JdbcTemplate JdbcTemplate);

    public void add(Product book) {
        this.add(book, this.jdbcTemplate);
    }

    public void remove(String BookName) {
        this.remove(BookName, this.jdbcTemplate);
    }

    public void edit(String BookName, Product Book) {
        this.edit(BookName, Book, this.jdbcTemplate);
    }

    public FrameworkDTO get(String BookName) {
        return this.get(BookName, this.jdbcTemplate);
    }

    public FrameworkDTO getAll(){
        return this.getAll(this.jdbcTemplate);
    }

    public int count() {
        return this.count(this.jdbcTemplate);
    }

    public void removeAll(){
        this.removeAll(this.jdbcTemplate);
    }
}
