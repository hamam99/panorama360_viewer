package com.codebreaker.vrlib.strategy.projection;

import android.app.Activity;

import com.codebreaker.vrlib.MD360Director;
import com.codebreaker.vrlib.MD360DirectorFactory;
import com.codebreaker.vrlib.common.MDDirection;
import com.codebreaker.vrlib.model.MDMainPluginBuilder;
import com.codebreaker.vrlib.model.MDPosition;
import com.codebreaker.vrlib.objects.MDAbsObject3D;
import com.codebreaker.vrlib.objects.MDObject3DHelper;
import com.codebreaker.vrlib.objects.MDStereoSphere3D;
import com.codebreaker.vrlib.plugins.MDAbsPlugin;
import com.codebreaker.vrlib.plugins.MDPanoramaPlugin;

/**
 * Created by hzqiujiadi on 16/6/26.
 * hzqiujiadi ashqalcn@gmail.com
 */
public class StereoSphereProjection extends AbsProjectionStrategy {

    private static class FixedDirectorFactory extends MD360DirectorFactory{
        @Override
        public MD360Director createDirector(int index) {
            return MD360Director.builder().build();
        }
    }

    private MDDirection direction;

    private MDAbsObject3D object3D;

    public StereoSphereProjection(MDDirection direction) {
        this.direction = direction;
    }

    @Override
    public void on(Activity activity) {
        object3D = new MDStereoSphere3D(direction);
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
    protected MD360DirectorFactory hijackDirectorFactory() {
        return new FixedDirectorFactory();
    }

    @Override
    public MDAbsPlugin buildMainPlugin(MDMainPluginBuilder builder) {
        return new MDPanoramaPlugin(builder);
    }
}
