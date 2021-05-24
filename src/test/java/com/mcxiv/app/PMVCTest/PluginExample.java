package com.mcxiv.app.PMVCTest;

import games.rednblack.h2d.common.plugins.H2DPluginAdapter;
import net.mountainblade.modular.annotations.Implementation;

@Implementation(authors = "Minecraftian14", version = "0.1")
public class PluginExample extends H2DPluginAdapter {

    public static final String CLASS_NAME = PluginExample.class.getName();

    MediatorExample mediator;

    public PluginExample() {
        super(CLASS_NAME);
    }

    @Override
    public void initPlugin() {
        facade.registerMediator(mediator=new MediatorExample(this));

        facade.sendNotification(EventExample.INITIALISE_UI.getName());
    }
}
