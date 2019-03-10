package com.example.materialdesign;

import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    AppCompatButton buttonBegin;
    TextInputLayout inputName;
    TextInputLayout inputSurname;
    private String userName;
    private String userSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initUI();
    }

    private void initUI() {
        inputName = findViewById(R.id.inputLayoutName);
        inputSurname = findViewById(R.id.inputLayoutSurname);
        buttonBegin = findViewById(R.id.buttonBegin);
        buttonBegin.setOnClickListener((view) -> {
            saveUser();
            checkRegistration();
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
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
