package com.svalero.library.Service;


import com.svalero.library.Model.Author;
import io.reactivex.Observable;
import retrofit2.http.GET;

import java.util.List;

public interface LibraryApi {
    @GET("authors")
    Observable<List<Author>> getAllAuthors();

}
