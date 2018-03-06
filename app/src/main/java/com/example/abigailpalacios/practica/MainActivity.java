package com.example.abigailpalacios.practica;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.abigailpalacios.practica.adapters.PracticaAdapter;
import com.example.abigailpalacios.practica.Api.Api;
import com.example.abigailpalacios.practica.models.Practica;
import com.example.abigailpalacios.practica.models.TweetModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        configureRecyclerView();
        fetchHttpRequest();
    }
    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    /**
     * To configure the RecyclerView
     */
    private void configureRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    /**
     * To make an http request
     */
    private void fetchHttpRequest() {
        TweetModel tweetModel = new TweetModel();
        tweetModel.setUsername("apalacios");
        tweetModel.setText("Mi primer tweet desde el API.");

        Call<TweetModel> call = Api.instance().createTweet(tweetModel);
        call.enqueue(new Callback<TweetModel>() {
            @Override
            public void onResponse(@NonNull Call<TweetModel> call, @NonNull Response<TweetModel> response) {

                try {
                    Log.i(TAG, response.body().getUsername());
                    Log.i(TAG, response.body().getText());
                } catch (NullPointerException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<TweetModel> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }
        });
    }
}
