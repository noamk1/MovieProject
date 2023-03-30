package hackeru.noam.lec18.data.models


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,

    @SerializedName("status_code")
    val statusCode:Int?,
    @SerializedName("status_message")
    val statusMessage: String?


)