package com.example.talhaaits.jsonparsing;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * API endpoints
 */

public interface RetrofitApiInterface {
    @GET("rss/media")
    Flowable<Rss> getMediaData();

}
