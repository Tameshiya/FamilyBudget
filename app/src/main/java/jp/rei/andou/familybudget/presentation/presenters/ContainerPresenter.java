package jp.rei.andou.familybudget.presentation.presenters;

import javax.inject.Inject;

import jp.rei.andou.familybudget.presentation.router.FragmentNavigator;
import jp.rei.andou.familybudget.presentation.views.ContainerContract;
import jp.rei.andou.familybudget.presentation.views.PaymentsFragment;

/**
 * Only container presenter can route fragments
 */
public class ContainerPresenter extends ContainerContract.MainPresenter {

    private final FragmentNavigator navigator;

    @Inject
    public ContainerPresenter(FragmentNavigator navigator) {
        this.navigator = navigator;
        //todo Remove exact fragment creation with proxy-factory-method, cuz it's non context-safe approach
        navigator.newScreen(new PaymentsFragment());
    }
}

