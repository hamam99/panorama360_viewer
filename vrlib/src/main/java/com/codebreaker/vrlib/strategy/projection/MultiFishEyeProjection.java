package com.codebreaker.vrlib.strategy.projection;

import com.codebreaker.vrlib.common.MDDirection;
import com.codebreaker.vrlib.model.MDMainPluginBuilder;
import com.codebreaker.vrlib.plugins.MDAbsPlugin;
import com.codebreaker.vrlib.plugins.MDMultiFishEyePlugin;

/**
 * Created by hzqiujiadi on 16/7/29.
 * hzqiujiadi ashqalcn@gmail.com
 */
public class MultiFishEyeProjection extends SphereProjection {

    private float radius;
    private MDDirection direction;

    public MultiFishEyeProjection(float radius, MDDirection direction) {
        this.radius = radius;
        this.direction = direction;
    }

    @Override
    public MDAbsPlugin buildMainPlugin(MDMainPluginBuilder builder) {
        return new MDMultiFishEyePlugin(builder, radius, direction);
    }
}
