package com.svalero.library.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.svalero.library.Model.Author;
import com.svalero.library.Utils.LocalDateAdapter;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.LocalDate;
import java.util.List;

public class LibraryService {
    private static final String BASE_URL = "http://localhost:8090/";
    private LibraryApi libraryApi;

    //Configuramos el cliente http
    public LibraryService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Gson gsonParser = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gsonParser))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        this.libraryApi = retrofit.create(LibraryApi.class);

    }

    public Observable<List<Author>> getAllAuthors(){
        return this.libraryApi.getAllAuthors();
    }
}
