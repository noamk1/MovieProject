package hackeru.noam.lec18.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import hackeru.noam.lec18.TMDBApp
import hackeru.noam.lec18.data.models.Movie
import hackeru.noam.lec18.databinding.MovieItemBinding

class MoviesAdapter(private val movies:List<Movie>): Adapter<MoviesAdapter.VH>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )


    override fun getItemCount() = movies.size



    override fun onBindViewHolder(holder: VH, position: Int) {
        val movie = movies[position]
        with(holder.binding){
           textTitle.text = movie.title
            Picasso.get()
                .load(movie.posterUrl)
                .into(imagePoster)
        }

    }

    class VH(val binding: MovieItemBinding):ViewHolder(binding.root)

}


