package context;

import ctrl.CTRL;
import ctrl.CTRLBook;
import ctrl.CTRLFW;
import dao.DAO;
import dao.DAOFW;
import dao.DAOMySql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

/**
 * Created by user on 2017-07-28.
 */

@Configuration
public class MyContext {

    @Bean
    public DataSource dataSource() {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;
    }

    @Bean
    public DAO dao(){
        DAOFW dao = new DAOMySql();
        dao.setJdbcTemplate(dataSource());
        return dao;
    }

    @Bean
    public CTRL ctrl(){
        CTRLFW ctrl = new CTRLBook();
        ctrl.setDao(dao(), new Scanner(System.in));
        return ctrl;
    }
}
