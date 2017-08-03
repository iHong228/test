package ctrl;

import framework.Factory;
import framework.Product;
import concrete.BookFactory;
import dto.FrameworkDTO;
import view.BookView;
import view.View;

import java.util.Scanner;

/**
 * Created by user on 2017-07-26.
 */
public class CTRLBook extends CTRLFW {

    @Override
    public void printList() {
        FrameworkDTO dto = dao.getAll();
        View view = new BookView();
        view.printDTO(dto);
    }

    @Override
    public void add() {
        Factory factory = new BookFactory();
        Product book = factory.create();

        System.out.println("책이름 입력");
        String name = scan.next();

        System.out.println("작가 입력");
        String writer = scan.next();

        System.out.println("가격 입력");
        int price = scan.nextInt();

        book.setName(name);
        book.setWriter(writer);
        book.setPrice(price);

        dao.add(book);
    }

    @Override
    public void edit() {
        System.out.println("수정할 책 이름");
        String name = scan.next();

        Factory factory = new BookFactory();
        Product book = factory.create();

        System.out.println("수정될 작가 이름");
        String writer = scan.next();
        book.setWriter(writer);

        System.out.println("수정될 가격");
        int price = scan.nextInt();
        book.setPrice(price);

        dao.edit(name, book);
    }

    @Override
    public void delete() {
        System.out.println("지울 책 이름 입력");
        String name = scan.next();
        dao.remove(name);
    }
}
