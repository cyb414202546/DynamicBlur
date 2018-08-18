package com.example.cyb.dynamicblur.BluredView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;

import com.example.cyb.dynamicblur.Util.BlurBitmapUtil;

public class BluredGridLayout extends GridLayout {

    Context context;
    private boolean isBlur = true;
    private View backGroundView;
    private ViewTreeObserver.OnPreDrawListener onPreDrawListener;
    private float blurRadius = 25;
    private float scale = 8;

    public BluredGridLayout(Context context) {
        super(context);
    }

    public BluredGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BluredGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isBlur() {
        return isBlur;
    }

    public void setBlur(boolean blur) {
        isBlur = blur;
    }

    public void setBackGroundView(View backGroundView){
        this.backGroundView = backGroundView;
    }

    public ViewTreeObserver.OnPreDrawListener getOnPreDrawListener() {
        return onPreDrawListener;
    }

    public void setOnPreDrawListener(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        this.onPreDrawListener = onPreDrawListener;
        if(isBlur && backGroundView != null){
            if(getOnPreDrawListener() == null) {
                this.onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        BlurBitmapUtil.blur
                                (context, BluredGridLayout.this, getBackGroundView(),
                                        getBlurRadius(), getScale());
                        return true;
                    }
                };
            }
            getViewTreeObserver().addOnPreDrawListener(getOnPreDrawListener());

        }
    }
    public void setOnPreDrawListener() {
        if(isBlur && backGroundView != null){
            if(getOnPreDrawListener() == null) {
                this.onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        BlurBitmapUtil.blur
                                (context, getBackGroundView(), BluredGridLayout.this,
                                        getBlurRadius(), getScale());
                        return true;
                    }
                };
            }
            getViewTreeObserver().addOnPreDrawListener(getOnPreDrawListener());

        }
    }

    public View getBackGroundView() {
        return backGroundView;
    }

    public float getBlurRadius() {
        return blurRadius;
    }

    public void setBlurRadius(float blurRadius) {
        this.blurRadius = blurRadius;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
