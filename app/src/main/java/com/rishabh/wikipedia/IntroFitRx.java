package com.rishabh.wikipedia;

import com.rishabh.wikipedia.models.Response;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Rishabh on 08-04-2018.
 */


//https://en.wikipedia.org/w/api.php?action=query&formatversion=2&generator=prefixsearch&
// gpssearch=Albert%20Ei&gpslimit=10&prop=pageimages%7Cpageterms&piprop=thumbnail
// &pithumbsize=50&pilimit=10&redirects=&wbptterms=description

        //https://en.wikipedia.org/w/api.php?action=query
// &formatversion=2&prop=pageimages%7Cpageterms&titles=Sachin%20Tendulkar

public interface IntroFitRx {
    @GET("")
    public Observable<Response> getResponse(
            @QueryMap Map<String, String> map
    );

    @GET
    @Streaming
    Observable<retrofit2.Response<ResponseBody>> download(
            @Url String url
    );

    @Multipart
    @POST("capture")
    Observable<retrofit2.Response<ResponseBody>> upload(
            @PartMap Map<String, String> map,
            @Part MultipartBody.Part file
    );


}
