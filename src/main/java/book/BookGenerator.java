package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.ZoneId;

public class BookGenerator {
    public static Book randomBook(){
        Faker faker = new Faker();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(faker.date().birthday(0,200).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .pages(faker.number().numberBetween(0,2000))
                .available(faker.bool().bool())
                .build();
    }
}
