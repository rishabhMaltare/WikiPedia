package com.rishabh.wikipedia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SearchView;

import com.rishabh.wikipedia.models.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private io.reactivex.Observable<Response> callRx;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);

        setUpSearchObservable();


    }

    @NonNull
    private Predicate<Response> ifSuccessful() {
        return new Predicate<Response>() {
            @Override
            public boolean test(Response serverResponse) throws Exception {
                return serverResponse.query.pages.size() > 0;
            }
        };
    }

    @NonNull
    private Observer<Response> getObserver() {
        return new Observer<Response>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Response serverResponse) {
                Log.d(TAG, "onNext: response = " + serverResponse.toString());
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
    }

    private void setUpSearchObservable() {
        RxSearchObservable.fromView(searchView)
                .debounce(300, TimeUnit.MILLISECONDS)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String text) throws Exception {
                        if (text.isEmpty()) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                })
                .distinctUntilChanged()
                .switchMap(new Function<String, ObservableSource<Response>>() {
                    @Override
                    public ObservableSource<Response> apply(String s) throws Exception {
                        Map map = new HashMap();
                        map.put("action", "query");
                        map.put("formatversion", "2");
                        map.put("prop", "pageimages|pageterms");
                        map.put("titles", s);

                        //action=query
                        // &formatversion=2&prop=pageimages%7Cpageterms&titles=Sachin%20Tendulkar

                        callRx = RetroRxUtil.getRetroService(IntroFitRx.class).getResponse(map);
                        return callRx;

                    }
                })
                //.switchMap(new Function<String, ObservableSource<String>>() {
                //    @Override
                //    public ObservableSource<String> apply(String query) throws Exception {
                //        return dataFromNetwork(query);
                //    }
                //})
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response response) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private ObservableSource<String> searchCall(String query) {
        return new ObservableSource<String>() {
            @Override
            public void subscribe(Observer<? super String> observer) {

            }
        };
    }

    /**
     * Simulation of network data
     */
    private ObservableSource<String> dataFromNetwork(final String query) {

        return new ObservableSource<String>() {
            @Override
            public void subscribe(Observer<? super String> observer) {

            }
        };


        //return new Observable.just(query)
        //        .delay(2, TimeUnit.SECONDS)
        //        .map(new Function<Boolean, String>() {
        //            @Override
        //            public String apply(Boolean value) {
        //                return query;
        //            }
        //        });
    }

}
