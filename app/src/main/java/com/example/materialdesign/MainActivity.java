package com.example.materialdesign;

import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    AppCompatButton buttonBegin;
    TextInputLayout inputName;
    TextInputLayout inputSurname;
    private String userName;
    private String userSurname;

    BottomSheetBehavior bottomSheetBehavior;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initUI();
        initBottomSheet();
    }

    private void initUI() {
        inputName = findViewById(R.id.inputLayoutName);
        inputSurname = findViewById(R.id.inputLayoutSurname);
        buttonBegin = findViewById(R.id.buttonBegin);
        buttonBegin.setOnClickListener((view) -> {
            saveUser();
            checkRegistration();
        });
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view ->
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED));
    }

    private void initBottomSheet() {
        LinearLayout linearLayout = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(linearLayout);
        TextView bottomLabel = findViewById(R.id.bottom_label);
        TextView bottomText = findViewById(R.id.bottom_text);
        fab.setAlpha(0f);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == 3) {
                    fab.setAlpha(1f);
                    YoYo.with(Techniques.Pulse).repeat(4).playOn(fab);
                } else if (newState == 4) {
                    YoYo.with(Techniques.ZoomOut).playOn(fab);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                if (slideOffset > 0) {
                    inputName.setAlpha(1f - slideOffset);
                    inputSurname.setAlpha(1f - slideOffset);
                    buttonBegin.setAlpha(1f - slideOffset * 2);
                    bottomText.setAlpha(slideOffset);
                }
            }
        });
    }

    private void checkRegistration() {
        if (userName.isEmpty()) {
            Toast.makeText(this, "Введите имя", Toast.LENGTH_SHORT).show();
            YoYo.with(Techniques.Shake).playOn(inputName);
        } else if (userSurname.isEmpty()) {
            Toast.makeText(this, "Введите фамилию", Toast.LENGTH_SHORT).show();
            YoYo.with(Techniques.Shake).playOn(inputSurname);
        } else {
            Toast.makeText(this, "Зарегистрирован пользователь \n"
                    + userName + " " + userSurname, Toast.LENGTH_SHORT).show();
        }
    }

    private void saveUser() {
        userName = Objects.requireNonNull(inputName.getEditText()).getText().toString();
        userSurname = Objects.requireNonNull(inputSurname.getEditText()).getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.theme_settings) {
            setContentView(R.layout.fragment_themes);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
