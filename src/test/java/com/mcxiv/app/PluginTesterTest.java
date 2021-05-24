package com.mcxiv.app;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;

import java.util.Arrays;

class PluginTesterTest extends VisTable {

    public PluginTesterTest() {
        defaults().space(10).fillX();
        add(new VisTextButton("Hello"));
        add(new VisTextButton("Hello"));
        row();
        VisTable table = new VisTable();
        add(table).colspan(2);
        table.defaults().space(10);
        table.add(new VisTextButton("Hello"));
        table.add(new VisTextButton("Hello"));
        table.add(new VisTextButton("Hello"));
        row();
        add(new VisTextButton("Hello"));
        add(new VisTextButton("Hello"));
    }

    public static void main(String[] args) throws InterruptedException {
        PluginTester.launchTest(null, PluginTesterTest::Test);
    }

    private static void Test() {
        PluginTester.setTable(new PluginTesterTest());
    }

}