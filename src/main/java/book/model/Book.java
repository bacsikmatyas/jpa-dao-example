package book.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Book {

    public static enum Format {
        HARDBACK,
        PAPERBACK
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false, unique=true)
    private String isbn13;

    @Column(nullable=false)
    private String author;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private Format format;

    @Column(nullable=false)
    private String publisher;

    private LocalDate publicationDate;

    @Positive
    private int pages;

    @Column(nullable=false)
    private boolean available;

}
