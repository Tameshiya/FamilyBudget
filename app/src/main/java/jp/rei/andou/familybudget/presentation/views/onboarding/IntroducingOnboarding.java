package jp.rei.andou.familybudget.presentation.views.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.jakewharton.rxbinding2.widget.RxTextView;

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
    ImageView inputVerifiedSign;
    @BindView(R.id.kinshi_sign)
    ImageView invalidInputSign;
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
        presenter.listenFamilyName(RxTextView.textChanges(familyName).skipInitialValue());
        presenter.listenDeposit(RxTextView.textChanges(familyDeposit).skipInitialValue());
    }

    @Override
    public void showInputVerifiedStamp() {
        hideAnyStamp();
        inputVerifiedSign.setVisibility(View.VISIBLE);
    }

    @Override
    public void showInvalidInputStamp() {
        hideAnyStamp();
        invalidInputSign.setVisibility(View.VISIBLE);
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
        inputVerifiedSign.setVisibility(View.INVISIBLE);
        invalidInputSign.setVisibility(View.INVISIBLE);
    }

    @Override
    public String getInputtedFamilyName() {
        return familyName.getText()
                         .toString();
    }

    @Override
    public long getInputtedFamilyDeposit() {
        return Long.parseLong(
                familyDeposit.getText()
                             .toString()
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((App) getActivity().getApplicationContext()).destroyComponent(this);
    }
}
