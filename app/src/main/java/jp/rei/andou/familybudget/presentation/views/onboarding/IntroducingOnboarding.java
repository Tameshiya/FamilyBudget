package jp.rei.andou.familybudget.presentation.views.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.rei.andou.familybudget.R;
import jp.rei.andou.familybudget.presentation.App;

public class IntroducingOnboarding extends Fragment { //todo implements MeetingOnboardingContract.View...

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.meeting, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((App) getContext().getApplicationContext()).inject(this);
    }
}
