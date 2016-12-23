package com.codebreaker.vrlib.strategy.projection;

import android.content.Context;

import com.codebreaker.vrlib.MD360DirectorFactory;
import com.codebreaker.vrlib.model.MDMainPluginBuilder;
import com.codebreaker.vrlib.plugins.MDAbsPlugin;
import com.codebreaker.vrlib.strategy.IModeStrategy;

/**
 * Created by hzqiujiadi on 16/6/25.
 * hzqiujiadi ashqalcn@gmail.com
 */
public abstract class AbsProjectionStrategy implements IModeStrategy, IProjectionMode {

    @Override
    public void onResume(Context context) {

    }

    @Override
    public void onPause(Context context) {

    }

    protected MD360DirectorFactory hijackDirectorFactory(){ return null; }

    abstract MDAbsPlugin buildMainPlugin(MDMainPluginBuilder builder);
}
