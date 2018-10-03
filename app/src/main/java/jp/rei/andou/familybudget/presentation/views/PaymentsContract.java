package jp.rei.andou.familybudget.presentation.views;

import java.util.List;

import jp.rei.andou.familybudget.presentation.general.BaseView;
import jp.rei.andou.familybudget.presentation.presenters.Presenter;

public interface PaymentsContract {

    interface PaymentsView extends BaseView {

        void renderPaymentsList(List<Object> payments);

    }

    abstract class PaymentsPresenter extends Presenter<PaymentsView> {

        public abstract void onPaymentClick();

    }

}
