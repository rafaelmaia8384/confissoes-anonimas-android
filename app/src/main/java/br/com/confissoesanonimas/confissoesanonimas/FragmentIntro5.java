package br.com.confissoesanonimas.confissoesanonimas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.angads25.toggle.LabeledSwitch;
import com.github.paolorotolo.appintro.ISlidePolicy;

public class FragmentIntro5 extends Fragment implements ISlidePolicy {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_intro5, container, false);
    }

    @Override
    public boolean isPolicyRespected() {

        int count = 0;

        if (((LabeledSwitch)getActivity().findViewById(R.id.toggleButton1)).isOn()) count++;
        if (((LabeledSwitch)getActivity().findViewById(R.id.toggleButton2)).isOn()) count++;
        if (((LabeledSwitch)getActivity().findViewById(R.id.toggleButton3)).isOn()) count++;
        if (((LabeledSwitch)getActivity().findViewById(R.id.toggleButton4)).isOn()) count++;
        if (((LabeledSwitch)getActivity().findViewById(R.id.toggleButton5)).isOn()) count++;

        return count > 0;
    }

    @Override
    public void onUserIllegallyRequestedNextPage() {

        IntroActivity.dialogHelper.showError(getResources().getString(R.string.intro5_error1));
    }
}

