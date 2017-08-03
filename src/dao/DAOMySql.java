package dao;

import dto.DTO;
import enumpak.Bookshelf;
import framework.Product;
import concrete.Book;
import connection.ConnectionMaker;
import dto.FrameworkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Created by user on 2017-07-26.
 */
public class DAOMySql extends DAOFW {
    PreparedStatement pstmt;

    @Override
    public void add(Product book, JdbcTemplate jdbcTemplate) {
        String sql = "INSERT INTO bookshelf(name, writer, price) VALUE (?,?,?)";
        jdbcTemplate.update(sql, book.getName(), book.getWriter(), book.getPrice());
    }

    @Override
    public void remove(String BookName, JdbcTemplate jdbcTemplate) {
        String sql = "DELETE FROM bookshelf WHERE name = ?";
        jdbcTemplate.update(sql, BookName);

    }

    @Override
    public void edit(String BookName, Product Book, JdbcTemplate jdbcTemplate) {
        String sql = "UPDATE bookshelf SET writer = ?, price = ? WHERE name = ?";
        jdbcTemplate.update(sql, Book.getWriter(), Book.getPrice(), BookName);
    }

    @Override
    public FrameworkDTO get(String BookName, JdbcTemplate jdbcTemplate) {
        String sql = "SELECT * FROM bookshelf WHERE name = ?";
        FrameworkDTO dto = new DTO();
        return jdbcTemplate.queryForObject(sql, new Object[]{BookName}, new RowMapper<FrameworkDTO>() {
            @Override
            public FrameworkDTO mapRow(ResultSet resultSet, int i) throws SQLException {
                return setResult(resultSet, dto);
            }
        });
    }

    @Override
    public FrameworkDTO getAll(JdbcTemplate jdbcTemplate) {
        FrameworkDTO dto = new DTO();
        String sql = "SELECT * FROM bookshelf";
        return jdbcTemplate.queryForObject(sql, new RowMapper<FrameworkDTO>() {
            @Override
            public FrameworkDTO mapRow(ResultSet resultSet, int i) throws SQLException {
                return setResult(resultSet, dto);
            }
        });
    }

    @Override
    public int count(JdbcTemplate jdbcTemplate) {
        String sql = "SELECT COUNT(name) FROM bookshelf";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt(1);
            }
        });
    }

    @Override
    public void removeAll(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.update("DELETE FROM bookshelf");
    }

    private FrameworkDTO setResult(ResultSet rs, FrameworkDTO dto) throws SQLException {
        Product book = new Book();

        book.setName(rs.getString(Bookshelf.NAME.stringValue()));
        book.setWriter(rs.getString(Bookshelf.WRITER.stringValue()));
        book.setPrice(rs.getInt(Bookshelf.PRICE.stringValue()));
        dto.getProductList().add(book);
        return dto;
    }
}
