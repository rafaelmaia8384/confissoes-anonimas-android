package br.com.confissoesanonimas.confissoesanonimas;

import android.app.Application;

import com.mehdok.views.Fontify;

/**
 * Created by rafael on 5/23/18.
 */

public class AppClass extends Application {
    @Override
    public void onCreate() {

        super.onCreate();

        Fontify.init("fonts/Roboto-Regular.ttf")
                //.addFontNormal("en", "fonts/Dancing-Script.ttf")

                .addFontNormal("en", "fonts/Cookie-Regular.ttf")
                .addFontNormal("pt", "fonts/Cookie-Regular.ttf")
                .addFontNormal("ptbr", "fonts/Cookie-Regular.ttf")
                .cacheSize(5)
                .build();

    }
}
