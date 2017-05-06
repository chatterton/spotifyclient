package jc.spotifyclient.screens.home;

import javax.inject.Inject;
import javax.inject.Singleton;

import jc.spotifyclient.framework.BasePresenter;

@Singleton
public class HomeScreenPresenter extends BasePresenter<HomeScreen> {

    private int bindCount = 0;

    @Inject
    public HomeScreenPresenter() {

    }

    @Override
    public void bindView(HomeScreen view) {
        super.bindView(view);
        bindCount++;
        view.updateHelloText("Presenter bound: "+bindCount);
    }

}
