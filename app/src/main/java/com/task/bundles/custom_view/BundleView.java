package com.task.bundles.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.TextView;

import com.task.bundles.R;

public class BundleView extends ConstraintLayout {

    private String title;
    private String price;
    private String type;
    private String description;

    private TextView tvTitle;
    private TextView tvPrice;
    private TextView tvType;
    private TextView tvDescription;

    public BundleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.BundleView, 0, 0);

        try {
            title = a.getString(R.styleable.BundleView_title);
            price = a.getString(R.styleable.BundleView_price);
            type = a.getString(R.styleable.BundleView_type);
            description = a.getString(R.styleable.BundleView_description);

        } finally {
            a.recycle();
        }


        init();

    }

    private void init() {
        inflate(getContext(), R.layout.view_bundle, this);
        tvTitle = findViewById(R.id.tv_title);
        tvPrice = findViewById(R.id.tv_price);
        tvType = findViewById(R.id.tv_type);
        tvDescription = findViewById(R.id.tv_description);

        tvTitle.setText(title);
        tvPrice.setText(price);
        tvType.setText(type);
        tvDescription.setText(description);

    }

    public String getTitle() {
        return tvTitle.getText().toString();
    }

    public String getPrice() {
        return tvPrice.getText().toString();
    }

    public String getType() {
        return tvType.getText().toString();
    }

    public String getDescription() {
        return tvDescription.getText().toString();
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
        invalidate();
        requestLayout();
    }

    public void setPrice(String price) {
        tvPrice.setText(price);
        invalidate();
        requestLayout();
    }

    public void setType(String type) {
        tvType.setText(type);
        invalidate();
        requestLayout();
    }

    public void setDescription(String description) {
        tvDescription.setText(description);
        invalidate();
        requestLayout();
    }
}
