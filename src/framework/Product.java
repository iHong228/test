package framework;

/**
 * Created by user on 2017-07-26.
 */
public abstract class Product {
    String name;
    String writer;
    int price;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", price=" + price +
                '}';
    }

    public void setProperty(String name, String writer, int price) {
        this.name = name;
        this.writer = writer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
