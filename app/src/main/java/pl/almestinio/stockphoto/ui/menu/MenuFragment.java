package pl.almestinio.stockphoto.ui.menu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.ButterKnife;
import pl.almestinio.stockphoto.R;
import pl.almestinio.stockphoto.webservice.RestClient;
import pl.almestinio.stockphoto.webservice.imagesearch.Hit;
import pl.almestinio.stockphoto.webservice.imagesearch.ImageSearch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mesti193 on 2/5/2018.
 */

public class MenuFragment extends Fragment {

    @BindString(R.string.app_name)
    String appTitle;
    @BindString(R.string.api_key)
    String apiKey;

    private List<Hit> hitList = new ArrayList<Hit>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        setHasOptionsMenu(true);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(appTitle);


//        String test;
        String test = RestClient.getClient().requestPhotos(apiKey, "yellow+flowers", "photo").request().url().toString();

        Log.e("TEST", test);

        getSomething();

        return view;
    }

    public void getSomething(){
        try{
            RestClient.getClient().requestPhotos(apiKey,"yellow+flowers", "photo").enqueue(new Callback<ImageSearch>() {
                @Override
                public void onResponse(Call<ImageSearch> call, Response<ImageSearch> response) {
                    if(response.isSuccessful()){
                        for (Hit hit : response.body().getHits()){
                            Log.e("HIT ID", hit.getId()+"");
                        }
                    }else{
                        Log.e("XW", "WTF");
                    }
                }

                @Override
                public void onFailure(Call<ImageSearch> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
