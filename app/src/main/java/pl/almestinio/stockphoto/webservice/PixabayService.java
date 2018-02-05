package pl.almestinio.stockphoto.webservice;

import pl.almestinio.stockphoto.webservice.imagesearch.ImageSearch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by mesti193 on 2/5/2018.
 */

public interface PixabayService {

    @GET("api/")
    Call<ImageSearch> requestPhotos(@Query("key") String userkey,
                                    @Query("q") String query,
                                    @Query("image_type") String type);

}
