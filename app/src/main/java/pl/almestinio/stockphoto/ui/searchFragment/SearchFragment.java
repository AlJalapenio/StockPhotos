package pl.almestinio.stockphoto.ui.searchFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindString;
import butterknife.ButterKnife;
import pl.almestinio.stockphoto.R;

/**
 * Created by mesti193 on 2/5/2018.
 */

public class SearchFragment extends Fragment{

    @BindString(R.string.search_photos)
    String appSearchPhotos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        setHasOptionsMenu(true);
        ButterKnife.bind(this, view);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(appSearchPhotos);

        return view;
    }
}
