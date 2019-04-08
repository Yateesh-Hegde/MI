package com.tr.y.movie_info;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.tr.y.movie_info.Models.MovieDetail;
import com.tr.y.movie_info.Models.genere;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MovieDetails extends AppCompatActivity {
    MovieDetail movieDetail = null;
    private String url = "https://api.themoviedb.org/3/movie/";
    String apiKey = "?api_key=09c283fd5b09f40f535f15345b503187&language=en-US";
    Response response = null;
    String baseURI = "http://image.tmdb.org/t/p/w780/";;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        int movieId = Math.round(Float.parseFloat(String.valueOf(getIntent().getExtras().get("Movie"))));
        getSupportActionBar().setTitle(String.valueOf(movieId));
        movieDetail = new MovieDetail();
        final OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody body = RequestBody.create(mediaType, "{}");
        final Request request = new Request.Builder()
                .url(url+movieId+apiKey)
                .get()
                .build();

        new AsyncTask<String ,String,String>(){
            @Override
            protected String doInBackground(String... strings) {
                try {
                    response = client.newCall(request).execute();
                    Gson gson = new Gson();
                    movieDetail = gson.fromJson(response.body().string(),MovieDetail.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                populateView();
            }
        }.execute();



    }

    private void populateView() {

        ImageView banner = findViewById(R.id.banner);

        Glide.with(getApplicationContext())
                .load(baseURI+movieDetail.getBackdrop_path())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(banner);

        TextView content = findViewById(R.id.content);
        content.setText(movieDetail.getOverview());

        TextView date = findViewById(R.id.date);
        date.setText(movieDetail.getRelease_date());

        TextView revenue = findViewById(R.id.revenue);
        revenue.setText(String.valueOf(movieDetail.getRevenue()));

        TextView budget = findViewById(R.id.budget);
        budget.setText(String.valueOf(movieDetail.getBudget()));

        TextView rating = findViewById(R.id.rating);
        rating.setText(String.valueOf(movieDetail.getVote_average()));

        TextView language = findViewById(R.id.language);
        language.setText(movieDetail.getOriginal_language());

        ArrayList<genere> geners = movieDetail.getGenres();
        StringBuilder s = new StringBuilder();
        for (genere genere:geners)
        {
            s.append(genere.getName()).append(",");
        }
        TextView gener = findViewById(R.id.gener);
        gener.setText(s);

    }

}
