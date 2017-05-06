package jc.spotifyclient.framework;

public class BasePresenter<T extends BaseView> {

    protected T view;

    public void bindView(T view) {
        this.view = view;
    }

    public void unbindView() {
        this.view = null;
    }

}
