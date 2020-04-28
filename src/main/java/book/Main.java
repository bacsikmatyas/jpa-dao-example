package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

public class Main {
    public static void main(String[] args) {
        int n = 1000;
        if(args.length>0){
            n=Integer.parseInt(args[0]);
        }

        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        String testIsbn="";
        for (int i = 0; i < n; i++) {
            Book book = BookGenerator.randomBook();

            if (i==4){
                testIsbn=book.getIsbn13();
            }

            bookDao.persist(book);
        }

        System.out.println("A tárolt könyvek listája: ");
        bookDao.findAll().forEach(System.out::println);

        System.out.println();
        System.out.println("A "+testIsbn+" ISBN számú könyv: ");
        System.out.println(bookDao.findByIsbn13(testIsbn).toString());

    }
}
