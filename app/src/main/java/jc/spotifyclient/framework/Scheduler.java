package jc.spotifyclient.framework;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class Scheduler {

    @Inject
    public Scheduler() { }

    public io.reactivex.Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    public io.reactivex.Scheduler io() {
        return io.reactivex.schedulers.Schedulers.io();
    }

    public io.reactivex.Scheduler computation() {
        return io.reactivex.schedulers.Schedulers.computation();
    }

    public io.reactivex.Scheduler newThread() {
        return io.reactivex.schedulers.Schedulers.newThread();
    }

}
