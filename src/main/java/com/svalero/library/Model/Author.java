package com.svalero.library.Model;

import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import retrofit2.http.GET;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private long id;
    private String name;
    private String nationality;
    private LocalDate bornDate;
    private String biography;
    private boolean active;
    private String authorImage;
    private List<Book> books;

}
