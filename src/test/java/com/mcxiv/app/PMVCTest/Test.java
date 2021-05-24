package com.mcxiv.app.PMVCTest;

import com.mcxiv.app.PluginTester;
import jdk.jfr.EventSettings;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        PluginTester.launchTest(null, Test::Test);
    }

    private static void Test() {

        PluginExample plugin = new PluginExample();

        PluginTester.setPlugin(plugin);

        PluginTester.setTable(plugin.mediator.getViewComponent());

        plugin.facade.sendNotification(EventExample.ADD_NEW_BUTTON.getName());

    }


}
