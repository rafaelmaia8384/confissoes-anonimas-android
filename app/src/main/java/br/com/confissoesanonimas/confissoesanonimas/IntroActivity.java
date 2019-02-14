package br.com.confissoesanonimas.confissoesanonimas;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.angads25.toggle.LabeledSwitch;
import com.github.paolorotolo.appintro.AppIntro2;

public class IntroActivity extends AppIntro2 {

    public static final int CODE_PERMISSION_REQUEST = 100;
    public static DialogHelper dialogHelper;
    private Fragment currFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addSlide(new FragmentIntro1());
        addSlide(new FragmentIntro2());
        addSlide(new FragmentIntro3());
        addSlide(new FragmentIntro4());
        addSlide(new FragmentIntro5());

        setSwipeLock(true);

        showSkipButton(false);

        getPager().setOffscreenPageLimit(4);

        dialogHelper = new DialogHelper(IntroActivity.this);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {

        super.onDonePressed(currentFragment);


    }


    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {

        currFragment = newFragment;

        super.onSlideChanged(oldFragment, newFragment);
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CODE_PERMISSION_REQUEST) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                findViewById(R.id.layoutDistanciaMaxima).setVisibility(View.VISIBLE);
            }
            else {

                dialogHelper.showError(getResources().getString(R.string.intro4_error1));

                findViewById(R.id.layoutDistanciaMaxima).setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        ((LabeledSwitch)findViewById(R.id.toggleButtonGPS)).setOn(false);
                    }
                }, 500);
            }
        }
    }
}