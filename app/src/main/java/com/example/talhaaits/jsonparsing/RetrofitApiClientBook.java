package com.example.talhaaits.jsonparsing;

import android.content.Context;

import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Retrofit singleton object implementation for book download api
 */

public class RetrofitApiClientBook {

    private static final String BASE_URL = "https://app.jigglemed.com/";
    private static Retrofit retrofit = null;
    //private static int cacheSize = 0;//10 * 1024 * 1024;
    private Context context;


    private RetrofitApiClientBook() {

    }

    public static synchronized Retrofit getClient() {
        return retrofit;
    }

    public static synchronized void createClient(Context context) {

        //Cache cache = new Cache(context.getCacheDir(), cacheSize);

        OkHttpClient.Builder clientBuilder=new OkHttpClient().newBuilder();


        //String token = SharedPreferencesManager.getInstance().getData(Constants.Configuration.TOKEN);

        clientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();
                Request.Builder requestBuilder;
                requestBuilder = request.newBuilder()
                        .header("Content-Type", "application/xml")
                        .method(request.method(), request.body());


                return chain.proceed(requestBuilder.build());
            }
        });

        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        clientBuilder.addInterceptor(loggingInterceptor);

        OkHttpClient okHttpClient = clientBuilder.readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)//.cache(cache)
                .build();

        TikXml tikXml = new TikXml.Builder().exceptionOnUnreadXml(false).build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(TikXmlConverterFactory.create(tikXml))
                    .build();
        }
    }


}