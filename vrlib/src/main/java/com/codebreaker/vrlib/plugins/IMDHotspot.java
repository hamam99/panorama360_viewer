package com.codebreaker.vrlib.plugins;

import com.codebreaker.vrlib.model.MDRay;

/**
 * Created by hzqiujiadi on 16/8/5.
 * hzqiujiadi ashqalcn@gmail.com
 */
public interface IMDHotspot {
    float hit(MDRay ray);
    void onEyeHitIn(long timestamp);
    void onEyeHitOut();
    void onTouchHit(MDRay ray);
    String getTitle();
    void useTexture(int key);
}
