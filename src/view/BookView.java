package view;

import framework.Product;
import dto.FrameworkDTO;

/**
 * Created by user on 2017-07-26.
 */
public class BookView extends View {
    @Override
    public void printDTO(FrameworkDTO dto) {
        for(Product book : dto.getProductList()){
            System.out.println(book.toString());
        }
    }
}
