package hackeru.noam.lec18.service

import hackeru.noam.lec18.data.models.GenreResponse
import hackeru.noam.lec18.data.models.MovieResponse
import hackeru.noam.lec18.utils.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface TMDBService {
    @GET("3/discover/movie?sort_by=popularity.desc")
    suspend fun popularMovies():MovieResponse

    @GET("3/discover/movie?sort_by=release_date.desc")
    suspend fun newMovies():MovieResponse

    @GET("3/discover/movie?sort_by=vote_average.desc")
    suspend fun mostRated():MovieResponse

    @GET("3/genre/movie/list")
    suspend fun genres():GenreResponse

    companion object{
        fun create():TMDBService{
            val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor())
                .addInterceptor(logger)
                .build()


            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TMDBService::class.java)
        }
    }


}
