package com.example.usuario.personalsoftwareprocess.ClasesInterfaz;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.personalsoftwareprocess.R;

public class tabtimeinphase extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_time_in_phase, container, false);

        return rootView;
    }
}
