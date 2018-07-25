package com.example.talhaaits.jsonparsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitApiClientBook.createClient(getApplicationContext());

       getMediaData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);

    }

    private void onError(Throwable throwable) {
        Log.d("MainActivity", "onSuccess: "+throwable.getMessage());
    }

    private void onSuccess(Rss response) {
        Log.d("MainActivity", "onSuccess: "+response.toString());
    }

    public static Flowable<Rss> getMediaData() {
        RetrofitApiInterface apiInterface = RetrofitApiClientBook.getClient().create(RetrofitApiInterface.class);
        return apiInterface.getMediaData();
    }
}
