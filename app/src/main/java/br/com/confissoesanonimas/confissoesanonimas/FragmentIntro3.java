package br.com.confissoesanonimas.confissoesanonimas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.github.paolorotolo.appintro.ISlidePolicy;

public class FragmentIntro3 extends Fragment implements ISlidePolicy {

    private boolean canContinue = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_intro3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        ((CheckBox)getActivity().findViewById(R.id.checkBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                canContinue = b;
            }
        });

        getActivity().findViewById(R.id.buttonVerTermos).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                IntroActivity.dialogHelper.showSuccess("Ver Termos de Uso");
            }
        });
    }

    @Override
    public boolean isPolicyRespected() {

        return canContinue;
    }

    @Override
    public void onUserIllegallyRequestedNextPage() {

        IntroActivity.dialogHelper.showError(getResources().getString(R.string.intro3_error1));
    }
}

