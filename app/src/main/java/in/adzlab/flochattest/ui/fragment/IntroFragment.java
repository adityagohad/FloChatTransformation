package in.adzlab.flochattest.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.adzlab.flochattest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {

    int position;
    public static IntroFragment newInstance(int position) {
        IntroFragment introFragment = new IntroFragment();
        introFragment.position = position;
        return introFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return loadView(position, inflater, container, savedInstanceState);
    }

    private View loadView(int position, LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState){
        switch (position){
            case 0:
                return getParallaxPage(inflater, container, savedInstanceState);
            case 1:
                return getRotationPage(inflater, container, savedInstanceState);
            case 2:
                return getFinalPage(inflater, container, savedInstanceState);
            default:
                return getFinalPage(inflater, container, savedInstanceState);
        }
    }

    private View getParallaxPage(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_parallax, container, false);
        return view;
    }

    private View getRotationPage(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_rotation, container, false);
        return view;
    }

    private View getFinalPage(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_final, container, false);
        return view;
    }
}
