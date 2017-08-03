import context.MyContext;
import ctrl.CTRLBook;
import ctrl.CTRLFW;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by user on 2017-07-26.
 */

public class main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyContext.class);
        CTRLFW CTRLFW = context.getBean("ctrl", CTRLBook.class);
        CTRLFW.command();
    }
}
