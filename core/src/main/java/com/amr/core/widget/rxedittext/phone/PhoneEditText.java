package com.amr.core.widget.rxedittext.phone;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;

import com.amr.core.widget.rxedittext.RxEditText;
import com.amr.core.widget.rxedittext.ValidityListener;
import com.jakewharton.rxbinding2.widget.RxTextView;

public class PhoneEditText extends RxEditText {

    private PhonePresenter presenter;

    public PhoneEditText(Context context) {
        super(context);
    }

    public PhoneEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhoneEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context) {
        presenter = new PhonePresenter(context);
        setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_CLASS_PHONE);
    }

    @Override
    public void setValidityListener(ValidityListener validityListener) {
        presenter.listenIfValid(RxTextView.afterTextChangeEvents(this), validityListener);
    }
}
