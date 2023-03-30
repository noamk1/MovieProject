package hackeru.noam.lec18.data.repository

import hackeru.noam.lec18.data.dao.MovieDao
import hackeru.noam.lec18.service.TMDBService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun refreshMovies(){
        withContext(Dispatchers.IO){
            //fetch movies from API

            val service = TMDBService.create()

            val movieRes = service.popularMovies()
            val genreResponse = service.genres()
            //save to local database
            movieDao.addMovies(movieRes.movies)
            movieDao.addGenres(genreResponse.genres)
        }
    }
}