package jc.spotifyclient.framework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected T presenter;

    protected abstract void resolveDependencies();

    protected abstract int getContentViewLayoutId();

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resolveDependencies();
        setContentView(getContentViewLayoutId());
        ButterKnife.bind(this);
        presenter.bindView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("JC", "ACTIVITY DESTROYED: "+this);
        presenter.unbindView();
    }

    @Inject
    public void setPresenter(T presenter){
        this.presenter = presenter;
    }

}
