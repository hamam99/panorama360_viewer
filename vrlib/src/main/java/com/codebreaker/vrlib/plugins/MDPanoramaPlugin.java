package com.codebreaker.vrlib.plugins;

import android.content.Context;

import com.codebreaker.vrlib.MD360Director;
import com.codebreaker.vrlib.MD360Program;
import com.codebreaker.vrlib.model.MDMainPluginBuilder;
import com.codebreaker.vrlib.model.MDPosition;
import com.codebreaker.vrlib.objects.MDAbsObject3D;
import com.codebreaker.vrlib.strategy.projection.ProjectionModeManager;
import com.codebreaker.vrlib.texture.MD360Texture;

import static com.codebreaker.vrlib.common.GLUtil.glCheck;

/**
 * Created by hzqiujiadi on 16/7/22.
 * hzqiujiadi ashqalcn@gmail.com
 */
public class MDPanoramaPlugin extends MDAbsPlugin {

    private MD360Program mProgram;

    private MD360Texture mTexture;

    private ProjectionModeManager mProjectionModeManager;

    public MDPanoramaPlugin(MDMainPluginBuilder builder) {
        mTexture = builder.getTexture();
        mProgram = new MD360Program(builder.getContentType());
        mProjectionModeManager = builder.getProjectionModeManager();
    }

    @Override
    public void init(Context context) {
        mProgram.build(context);
        mTexture.create();
    }

    @Override
    public void beforeRenderer(int totalWidth, int totalHeight) {

    }

    @Override
    public void renderer(int index, int width, int height, MD360Director director) {

        MDAbsObject3D object3D = mProjectionModeManager.getObject3D();
        // check obj3d
        if (object3D == null) return;

        // Update Projection
        director.updateViewport(width, height);

        // Set our per-vertex lighting program.
        mProgram.use();
        glCheck("MDPanoramaPlugin mProgram use");

        mTexture.texture(mProgram);

        object3D.uploadVerticesBufferIfNeed(mProgram, index);

        object3D.uploadTexCoordinateBufferIfNeed(mProgram, index);

        // Pass in the combined matrix.
        director.shot(mProgram, getModelPosition());
        object3D.draw();

    }

    @Override
    public void destroy() {
        mTexture = null;
    }

    @Override
    protected MDPosition getModelPosition() {
        return mProjectionModeManager.getModelPosition();
    }

    @Override
    protected boolean removable() {
        return false;
    }

}
