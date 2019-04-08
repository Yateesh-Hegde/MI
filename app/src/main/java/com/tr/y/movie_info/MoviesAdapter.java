package com.tr.y.movie_info;
 
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tr.y.movie_info.Models.MovieInfo;

import java.util.List;
 
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private final Context configuration;
    private List<MovieInfo> moviesList;
    String baseURI = "http://image.tmdb.org/t/p/w92/";

    public OnBottomReachedListener getOnBottomReachedListener() {
        return onBottomReachedListener;
    }

    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener) {
        this.onBottomReachedListener = onBottomReachedListener;
    }

    OnBottomReachedListener onBottomReachedListener;
 
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,rating,overtView,releaseDate,releaseLang;
        ImageView poster;
 
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            overtView = view.findViewById(R.id.overView);
            rating = view.findViewById(R.id.rating);
            releaseDate = view.findViewById(R.id.releaseDate);
            releaseLang = view.findViewById(R.id.releaseLang);
            poster = view.findViewById(R.id.poster);
        }
    }
 
 
    public MoviesAdapter(List<MovieInfo> moviesList, Context configuration) {
        this.moviesList = moviesList;
        this.configuration = configuration;

    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_details, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final MovieInfo movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.releaseDate.setText(movie.getRelease_date());
        holder.releaseLang.setText(movie.getOriginal_language());
        holder.overtView.setText(movie.getOverview());
        holder.rating.setText(String.valueOf(movie.getVote_average()));
                    Glide.with(holder.itemView.getContext())
                        .load(baseURI+movie.getPoster_path())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.poster);
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          public void onClick(View view) {
              launchMovieDetails(movie);
          }
      });
      if (position == moviesList.size()-1)
      {
          onBottomReachedListener.onBottomReached(position);
      }
    }

    private void launchMovieDetails(MovieInfo movie) {
        Intent intent = new Intent(configuration,MovieDetails.class);
        intent.putExtra("Movie",String.valueOf(movie.getId()));
        configuration.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}