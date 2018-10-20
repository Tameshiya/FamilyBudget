package jp.rei.andou.familybudget.presentation.views.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import jp.rei.andou.familybudget.R;
import jp.rei.andou.familybudget.presentation.App;

import static jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboardingContract.IntroducingPresenter;
import static jp.rei.andou.familybudget.presentation.views.onboarding.IntroducingOnboardingContract.IntroducingView;

public class IntroducingOnboarding extends Fragment implements IntroducingView {

    @Inject
    IntroducingPresenter presenter;
    @BindView(R.id.familyName)
    EditText familyName;
    @BindView(R.id.familyDeposit)
    EditText familyDeposit;
    @BindView(R.id.kakunin_sign)
    EditText inputVerifiedSign;
    @BindView(R.id.kinshi_sign)
    EditText invalidInputSign;
    @BindViews({R.id.name_layout, R.id.deposit_layout})
    TextInputLayout[] textInputLayouts;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.introduction, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((App) getContext().getApplicationContext()).inject(this);
        presenter.bindView(this);
    }

    @Override
    public void showInputVerifiedStamp() {
        textInputLayouts[0].setVisibility(View.VISIBLE);
    }

    @Override
    public void showInvalidInputStamp() {
        textInputLayouts[1].setVisibility(View.VISIBLE);
    }

    @Override
    public void showFamilyNameInputError(String error) {
        textInputLayouts[0].setError(error);
    }

    @Override
    public void showFamilyDepositInputError(String error) {
        textInputLayouts[1].setError(error);
    }

    @Override
    public void hideFamilyNameInputError() {
        textInputLayouts[0].setError(null);
    }

    @Override
    public void hideFamilyDepositInputError() {
        textInputLayouts[1].setError(null);
    }

    @Override
    public void hideAnyStamp() {
        ButterKnife.apply(textInputLayouts, (View view, int index) -> view.setVisibility(View.INVISIBLE));
    }
}
