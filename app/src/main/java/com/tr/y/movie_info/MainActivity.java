package com.tr.y.movie_info;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tr.y.movie_info.Models.Configuration;
import com.tr.y.movie_info.Models.MovieInfo;
import com.tr.y.movie_info.Models.PMResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String api_key = "09c283fd5b09f40f535f15345b503187";
    TextView tv;
    static int currentPage = 0;
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private List<MovieInfo> movieList = new ArrayList<>();
    Configuration configuration = new Configuration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movieList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        populateData(1);
    }

    private void populateData(final int page) {
        currentPage ++;
        final OkHttpClient client = new OkHttpClient();
        String url = "https://api.themoviedb.org/3/discover/movie?";
        String selectedPage = null;
        if (page == 1) {
            selectedPage = String.valueOf(page);
            movieList = new ArrayList<>();

        }
        else
            selectedPage = String.valueOf(currentPage);


        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody body = RequestBody.create(mediaType, "{}");
        final Request request = new Request.Builder()
                .url(url+"page="+selectedPage+"&include_video=false&include_adult=false&sort_by=popularity.desc&language=en-US&api_key="+api_key)
                .get()
                .build();
        new AsyncTask<String, String, Response>() {


            @Override
            protected Response doInBackground(String...params) {
                Response response = null;
                try {
                    PMResponseModel pmResponseModel = new PMResponseModel();
                    response = client.newCall(request).execute();
                    Gson gson = new Gson();
                    pmResponseModel = gson.fromJson(response.body().string(),PMResponseModel.class);
                    movieList.addAll(pmResponseModel.getResults());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Response s) {
                super.onPostExecute(s);
                mAdapter.notifyDataSetChanged();
                try {
                    tv.setText(s.body().string());
                    if (page == 1) {
                        mAdapter = new MoviesAdapter(movieList,getApplicationContext());
                        recyclerView.setAdapter(mAdapter);
                        mAdapter.setOnBottomReachedListener(new OnBottomReachedListener() {
                            @Override
                            public void onBottomReached(int position) {
                                populateData(2);
                            }
                        });
                    }
                    mAdapter.notifyDataSetChanged();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.execute(null,null,null);

    }



}
