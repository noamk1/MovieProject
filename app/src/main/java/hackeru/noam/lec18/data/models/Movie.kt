package hackeru.noam.lec18.data.models


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val movieId: Int,
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int,


){

    val backdropUrl
        get() = if (backdropPath != null) "https://image.tmdb.org/t/p/w300${backdropPath}"
        else "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/681px-Placeholder_view_vector.svg.png"

    val posterUrl
        get() = if (posterPath != null) "https://image.tmdb.org/t/p/w342${posterPath}"
        else "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/681px-Placeholder_view_vector.svg.png"


    @Ignore
    @SerializedName("genre_ids")
    val genreIds: List<Int> = mutableListOf()
}