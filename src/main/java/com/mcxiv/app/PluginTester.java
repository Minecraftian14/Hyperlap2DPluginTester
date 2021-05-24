package com.mcxiv.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;
import games.rednblack.h2d.common.plugins.H2DPluginAdapter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PluginTester extends ScreenAdapter {

    static PluginTester instance = null;
    static H2DPluginAdapter plugin;

    Stage stage;
    Table root;

    @Override
    public void show() {
        super.show();

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        instance = this;
    }

    public static void setPlugin(H2DPluginAdapter _plugin) {
        plugin = _plugin;
        plugin.setAPI(CustomisedPluginAPI.instance);
        plugin.initPlugin();
    }

    public static H2DPluginAdapter getPlugin() {
        return plugin;
    }

    public static CustomisedPluginAPI getAPI() {
        return CustomisedPluginAPI.instance;
    }

    public static void setTable(Table table) {

        if (instance == null || instance.root != null || table == null) return;

        instance.root = table;
        instance.root.setFillParent(true);
        instance.stage.addActor(instance.root);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }

    public static void launchTest(LwjglApplicationConfiguration config, Runnable testMethod) throws InterruptedException {

        if(config==null){
            config = new LwjglApplicationConfiguration();
            config.title = "Hyperlap2D Plugin Tester";
            config.width = 800;
            config.height = 480;
        }

        ExecutorService service = Executors.newSingleThreadExecutor();
        LwjglApplicationConfiguration finalConfig = config;
        service.execute(() -> new LwjglApplication(new Pack(), finalConfig));
        service.shutdown();

        while (PluginTester.instance==null) {
            System.out.println("Lapse");
            Thread.sleep(1000);
        }

        testMethod.run();
    }

    private static class Pack extends Game {

        @Override
        public void create() {
            VisUI.load();
            setScreen(new PluginTester());
        }

        @Override
        public void dispose() {
            super.dispose();
            VisUI.dispose();
        }
    }

}
