package pl.almestinio.stockphoto;

import android.app.Application;

import com.facebook.stetho.Stetho;

import pl.almestinio.stockphoto.webservice.RestClient;

/**
 * Created by mesti193 on 2/5/2018.
 */

public class PixabayApp extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        RestClient restClient = new RestClient();

    }

}
