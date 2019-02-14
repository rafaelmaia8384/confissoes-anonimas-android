package br.com.confissoesanonimas.confissoesanonimas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.angads25.toggle.LabeledSwitch;
import com.github.angads25.toggle.interfaces.OnToggledListener;
import com.github.paolorotolo.appintro.ISlidePolicy;

public class FragmentIntro2 extends Fragment implements ISlidePolicy {

    private boolean canContinue = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_intro2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        ((LabeledSwitch)getActivity().findViewById(R.id.toggleButton)).setOnToggledListener(new OnToggledListener() {

            @Override
            public void onSwitched(LabeledSwitch labeledSwitch, boolean isOn) {

                canContinue = isOn;
            }
        });
    }

    @Override
    public boolean isPolicyRespected() {

        return canContinue;
    }

    @Override
    public void onUserIllegallyRequestedNextPage() {

        IntroActivity.dialogHelper.showError(getResources().getString(R.string.intro2_error1));
    }
}
