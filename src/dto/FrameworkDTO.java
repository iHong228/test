package dto;

import framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-07-26.
 */
abstract public class FrameworkDTO {
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    private List<Product> productList = new ArrayList<>();
}
