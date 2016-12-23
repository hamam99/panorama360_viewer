package com.codebreaker.vrlib.strategy.interactive;

import com.codebreaker.vrlib.MD360Director;
import com.codebreaker.vrlib.strategy.IModeStrategy;

import java.util.List;

/**
 * Created by hzqiujiadi on 16/3/19.
 * hzqiujiadi ashqalcn@gmail.com
 */
public abstract class AbsInteractiveStrategy implements IModeStrategy, IInteractiveMode {

    private InteractiveModeManager.Params params;

    public AbsInteractiveStrategy(InteractiveModeManager.Params params) {
        this.params = params;
    }

    public InteractiveModeManager.Params getParams() {
        return params;
    }

    protected List<MD360Director> getDirectorList() {
        return params.projectionModeManager.getDirectors();
    }
}
