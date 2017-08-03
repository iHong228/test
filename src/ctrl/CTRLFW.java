package ctrl;

import dao.DAO;
import dao.DAOFW;

import java.util.Scanner;

/**
 * Created by user on 2017-07-26.
 */
public abstract class CTRLFW implements CTRL {

    DAO dao;

    Scanner scan;

    public void setDao(DAO dao, Scanner scan) {
        this.dao = dao;
        this.scan = scan;
    }

    public final void command() {
        Scanner scan = new Scanner(System.in);

        COM:
        while (true) {
            System.out.println("1: 출력, 2: 만들기, 3: 수정하기 4. 지우기");
            int sel = scan.nextInt();
            switch (sel) {
                case 1:
                    printList();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    delete();
                    break;
                case 0:
                    break COM;
            }
        }
    }

    public abstract void printList();

    public abstract void add();

    public abstract void edit();

    public abstract void delete();
}
