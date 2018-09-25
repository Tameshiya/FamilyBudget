package jp.rei.andou.familybudget.presentation.payments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.List;

import javax.inject.Inject;

import jp.rei.andou.familybudget.presentation.App;

public class PaymentsFragment extends Fragment implements PaymentsContract.PaymentsView {

    @Inject
    PaymentsPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplicationContext()).inject(this);
        presenter.bindView(this);
    }

    @Override
    public void showToast(int message, int duration) {

    }

    @Override
    public void showToast(String message, int duration) {

    }

    @Override
    public void showSnackbar(int message, int duration) {

    }

    @Override
    public void renderPaymentsList(List<Object> payments) {

    }
}
