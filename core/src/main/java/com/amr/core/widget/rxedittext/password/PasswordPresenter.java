package com.amr.core.widget.rxedittext.password;

import android.content.Context;

import com.amr.core.util.Preconditions;
import com.amr.core.util.TextUtil;
import com.amr.core.widget.rxedittext.RxEditTextPresenter;
import com.amr.core.widget.rxedittext.ValidityListener;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

class PasswordPresenter extends RxEditTextPresenter {

    private final TextUtil textUtil;

    PasswordPresenter(Context context) {
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
                        .map(textUtil::getIfValidPasswordResult)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(validityListener::onAfterTextChange, Timber::e));
    }

    private Observable<String> getStringObservable(InitialValueObservable<TextViewAfterTextChangeEvent> afterTextChangeEvent) {
        return afterTextChangeEvent
                .filter(et -> et.view() != null)
                .map(TextViewAfterTextChangeEvent::editable)
                .map(CharSequence::toString)
                .map(String::trim);
    }

    void checkIfPasswordMatches(InitialValueObservable<TextViewAfterTextChangeEvent> passwordAfterTextChangeEvent,
                                InitialValueObservable<TextViewAfterTextChangeEvent> confirmationAfterTextChangeEvent,
                                ValidityListener validityListener) {
        Preconditions.checkNonNull(validityListener, "validityListener cannot be null");
        disposable.add(
                Observable.combineLatest(
                        getStringObservable(passwordAfterTextChangeEvent),
                        getStringObservable(confirmationAfterTextChangeEvent),
                        textUtil::getIfPasswordsMatchResult)
                        .distinctUntilChanged()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(validityListener::onAfterTextChange, Timber::e));
    }
}