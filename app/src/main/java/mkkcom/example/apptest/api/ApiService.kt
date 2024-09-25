package mkkcom.example.apptest.api

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import mkkcom.example.apptest.api.model.MoviePage
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("discover/movie")
    fun getMovies(): Single<MoviePage>


}
