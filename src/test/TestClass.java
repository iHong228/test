package test;

import dao.DAOFW;
import framework.Factory;
import framework.Product;
import concrete.Book;
import concrete.BookFactory;
import connection.ConnectionMaker;
import dao.DAOMySql;
import dto.FrameworkDTO;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 2017-07-26.
 */
public class TestClass {

    DAOFW dao = new DAOMySql();
    Factory factory = new BookFactory();
    Product book = factory.create();
    Product book2 = factory.create();
    Product book3 = factory.create();

    @Before
    public void setBook(){
        book.setName("abc1");
        book.setWriter("abc1");
        book.setPrice(1000);
        book2.setName("abc2");
        book2.setWriter("abc2");
        book2.setPrice(2000);
        book3.setName("abc3");
        book3.setWriter("abc3");
        book3.setPrice(3000);

        dao.removeAll();
    }
    @Test
    public void connection(){
        Connection c = ConnectionMaker.MakeConnection();
        assertThat(c,is(notNullValue()));
    }

    @Test
    public void daoget(){
        Product book = new Book();
        book.setName("abc");
        book.setWriter("abc");
        book.setPrice(1000);

        dao.add(book);
        String name = dao.get(book.getName()).getProductList().get(0).getName();
        assertThat(name,is(book.getName()));
    }

    @Test
    public void count(){
        assertThat(dao.count(),is(0));
        dao.add(book);
        assertThat(dao.count(),is(1));
        dao.add(book2);
        assertThat(dao.count(),is(2));
        dao.add(book3);
        assertThat(dao.count(),is(3));
        dao.removeAll();
        assertThat(dao.count(),is(0));
    }

    @Test
    public void getAll(){
        dao.add(book);
        dao.add(book2);
        dao.add(book3);

        FrameworkDTO dto = dao.getAll();

        assertThat(dto.getProductList().get(0).getName(),is(book.getName()));
        assertThat(dto.getProductList().get(1).getName(),is(book2.getName()));
        assertThat(dto.getProductList().get(2).getName(),is(book3.getName()));

    }
    @Test
    public void edit(){
        dao.add(book);

        dao.edit(book.getName(), book2);
        assertThat(dao.get(book.getName()).getProductList().get(0).getWriter(),is(book2.getWriter()));
    }
}
