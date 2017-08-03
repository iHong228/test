package concrete;

import framework.Factory;
import framework.Product;

import java.util.ArrayList;

/**
 * Created by user on 2017-07-26.
 */
public class BookFactory extends Factory {

    @Override
    protected Product createProduct() {
        return new Book();
    }

    @Override
    protected void addList(Product product) {
        getProductList().add(product);
    }

    @Override
    public ArrayList<Product> getList() {
        return (ArrayList<Product>) getProductList();
    }
}
