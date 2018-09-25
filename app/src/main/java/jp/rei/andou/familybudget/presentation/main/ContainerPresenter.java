package jp.rei.andou.familybudget.presentation.main;

import javax.inject.Inject;

import jp.rei.andou.familybudget.presentation.payments.PaymentsFragment;
import jp.rei.andou.familybudget.presentation.router.FragmentNavigator;

public class ContainerPresenter extends ContainerContract.MainPresenter {

    private final FragmentNavigator navigator;

    @Inject
    public ContainerPresenter(FragmentNavigator navigator) {
        this.navigator = navigator;
        //Exact fragment creating is non context-safe approach?
        navigator.newScreen(new PaymentsFragment());
    }
}

