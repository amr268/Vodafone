package com.amr.core.widget.rxedittext.name;

import android.content.Context;

import com.amr.core.util.Preconditions;
import com.amr.core.util.TextUtil;
import com.amr.core.widget.rxedittext.RxEditTextPresenter;
import com.amr.core.widget.rxedittext.ValidityListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

class NamePresenter extends RxEditTextPresenter {

    private final TextUtil textUtil;

    NamePresenter(Context context) {
        textUtil = new TextUtil(context);
    }

    void listenIfValid(InitialValueObservable<TextViewAfterTextChangeEvent> afterTextChangeObservable, ValidityListener validityListener) {
        Preconditions.checkNonNull(validityListener, "validityListener cannot be null");
        disposable.add(
                afterTextChangeObservable
                        .filter(et -> et.view() != null)
                        .map(TextViewAfterTextChangeEvent::editable)
                        .map(CharSequence::toString)
                        .map(String::trim)
                        .map(textUtil::getIfValidNameResult)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(validityListener::onAfterTextChange, Timber::e));
    }
}