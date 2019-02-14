package br.com.confissoesanonimas.confissoesanonimas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.snatik.storage.Storage;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public static final String STORAGE_NOT_FIRST_ACCESS = "not-first-access.data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Storage storage = new Storage(getApplicationContext());

        if (!storage.isFileExist(storage.getInternalFilesDirectory() + File.separator + STORAGE_NOT_FIRST_ACCESS)) {

            Intent i = new Intent(MainActivity.this, IntroActivity.class);

            startActivity(i);
            finish();
        }

        setContentView(R.layout.activity_main);
    }
}
