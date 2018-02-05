package pl.almestinio.stockphoto.webservice;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mesti193 on 2/5/2018.
 */

public class RestClient extends BaseRequest {

    static PixabayService client;

    String API_BASE_URL = "https://pixabay.com/";

    public RestClient(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());

//                Request request = chain.request();
//
//                HttpUrl url = request.url().newBuilder().addQueryParameter("key", KEY).build();
//
////                HttpUrl url = request.url();
//                request = request.newBuilder().url(url).build();
//                return chain.proceed(request);
                return response;
            }
        });

        Retrofit builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        client = builder.create(PixabayService.class);

    }

    static public PixabayService getClient(){
        return client;
    }

}
