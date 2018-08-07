package com.example.test_async.rx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test_async.R;
import com.example.test_async.async.AsyncUtils;
import com.example.test_async.base.BaseFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class TestRxFragment extends BaseFragment {

    private TextView text;
    private Disposable taskDisposable;


    @Override
    public void onCreate(@Nullable Bundle state) {
        super.onCreate(state);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        super.onCreateView(inflater, container, state);
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        text = view.findViewById(R.id.text);

        Observable
                .create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) {
                        for (int i = 0; i < 100; i++) {
                            if (emitter.isDisposed()) {
                                emitter.onComplete();
                                return;
                            }
                            AsyncUtils.sleep(100);
                            emitter.onNext(i);
//                            if (i == 15) {
//                                throw new RuntimeException("BOOM!");
//                            }
                        }
                        emitter.onComplete();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        taskDisposable = d;
                        text.setText("Start! ");
                    }

                    @Override
                    public void onNext(Integer i) {
                        text.append(i + " ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        text.append(" ERROR: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        text.append("Finish!");
                    }
                });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (taskDisposable != null) {
            taskDisposable.dispose();
        }
    }
}
