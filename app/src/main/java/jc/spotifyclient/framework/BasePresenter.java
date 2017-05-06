package jc.spotifyclient.framework;

public class BasePresenter<T extends BaseView> {

    protected T view;

    protected void bindView(T view) {
        this.view = view;
    }

    protected void unbindView() {
        this.view = null;
    }

}
