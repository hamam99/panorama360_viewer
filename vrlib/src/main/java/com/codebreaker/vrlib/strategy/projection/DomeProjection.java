package com.codebreaker.vrlib.strategy.projection;

import android.app.Activity;
import android.graphics.RectF;

import com.codebreaker.vrlib.model.MDMainPluginBuilder;
import com.codebreaker.vrlib.model.MDPosition;
import com.codebreaker.vrlib.objects.MDAbsObject3D;
import com.codebreaker.vrlib.objects.MDDome3D;
import com.codebreaker.vrlib.objects.MDObject3DHelper;
import com.codebreaker.vrlib.plugins.MDAbsPlugin;
import com.codebreaker.vrlib.plugins.MDPanoramaPlugin;

/**
 * Created by hzqiujiadi on 16/6/25.
 * hzqiujiadi ashqalcn@gmail.com
 */
public class DomeProjection extends AbsProjectionStrategy {

    MDAbsObject3D object3D;

    private float mDegree;

    private boolean mIsUpper;

    private RectF mTextureSize;

    public DomeProjection(RectF textureSize, float degree, boolean isUpper) {
        this.mTextureSize = textureSize;
        this.mDegree = degree;
        this.mIsUpper = isUpper;
    }

    @Override
    public void on(Activity activity) {
        object3D = new MDDome3D(mTextureSize, mDegree, mIsUpper);
        MDObject3DHelper.loadObj(activity, object3D);
    }

    @Override
    public void off(Activity activity) {

    }

    @Override
    public boolean isSupport(Activity activity) {
        return true;
    }

    @Override
    public MDAbsObject3D getObject3D() {
        return object3D;
    }

    @Override
    public MDPosition getModelPosition() {
        return MDPosition.sOriginalPosition;
    }

    @Override
    public MDAbsPlugin buildMainPlugin(MDMainPluginBuilder builder) {
        return new MDPanoramaPlugin(builder);
    }
}