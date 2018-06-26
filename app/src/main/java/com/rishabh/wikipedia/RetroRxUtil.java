package com.rishabh.wikipedia;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rishabh on 09-04-2018.
 */

public class RetroRxUtil {

    private static Retrofit retrofit;
    private static OkHttpClient httpClient;

    static <T> T getRetroService(Class<T> className) {
        return getRetrofit().create(className);
    }

    static Retrofit getRetrofit() {
        if (retrofit == null) {
            String BASE_URL = "https://en.wikipedia.org/w/api.php";
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = new OkHttpClient.Builder().build();
        }
        return httpClient;
    }


}
