package com.example.materialdesign;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.AndroidViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThemesFragment extends ListFragment {
    private String[] themes = new String[]{"Красная", "Синяя", "Желтая"};

    public ThemesFragment() {
        // Required empty public constructor
    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_theme, null);
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                Objects.requireNonNull(getActivity()),
                android.R.layout.simple_list_item_1,
                themes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (position == 0) {
            changeTheme(R.style.ThemeRed, "красная");
        } else if (position == 1) {
            changeTheme(R.style.ThemeBlue, "синяя");
        } else if (position == 2) {
            changeTheme(R.style.ThemeYellow, "желтая");
        }
    }

    private void changeTheme(int id, String nameTheme) {
        Activity activity = getActivity();
        assert activity != null;
        activity.setContentView(R.layout.activity_main);
        activity.setTheme(id); //Почему не меняется тема?
        activity.recreate();
        Toast.makeText(activity, "Используется " + nameTheme + " тема", Toast.LENGTH_SHORT).show();
    }
}
