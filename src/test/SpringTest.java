package test;

import concrete.Book;
import concrete.BookFactory;
import dao.DAO;
import framework.Factory;
import framework.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 2017-07-28.
 */
@ContextConfiguration(classes = context.MyContext.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    DAO dao;

    Product book1;
    Product book2;
    Product book3;

    @Before
    public void set(){
        book1=new Book();
        book1.setProperty("aaa","aaa",500);
        book2=new Book();
        book2.setProperty("bbb","bbb",500);
        book3=new Book();
        book3.setProperty("ccc","ccc",500);
    }

    @Test
    public void connect(){
        assertThat(dataSource,is(notNullValue()));
    }

    @Test
    public void addAndcnt(){
        dao.removeAll();
        dao.add(book1);
        assertThat(dao.count(), is(1));

        assertThat(dao.get(book1.getName()).getProductList().get(0).getName(),is(book1.getName()));
    }
}
