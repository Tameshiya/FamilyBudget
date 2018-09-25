package jp.rei.andou.familybudget.presentation.payments;

import java.util.List;

import jp.rei.andou.familybudget.presentation.general.BaseView;
import jp.rei.andou.familybudget.presentation.general.Presenter;

public interface PaymentsContract {

    interface PaymentsView extends BaseView {

        void renderPaymentsList(List<Object> payments);

    }

    abstract class PaymentsPresenterContract extends Presenter<PaymentsView> {

        abstract void onPaymentClick();

    }

}
