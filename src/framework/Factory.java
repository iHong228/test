package framework;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-07-26.
 */
public abstract class Factory {

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    private List<Product> productList = new ArrayList<>();

    public final Product create(){
        Product p = createProduct();
        addList(p);
        return p;
    }

    abstract protected Product createProduct();
    abstract protected void addList(Product product);
    abstract public ArrayList<Product> getList();

}

