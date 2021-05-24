package com.mcxiv.app.PMVCTest;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.kotcrab.vis.ui.widget.VisTextButton;
import games.rednblack.h2d.common.plugins.H2DPluginAdapter;
import org.lwjgl.Sys;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

public class MediatorExample extends Mediator<ViewExample> {

    public static final String CLASS_NAME = MediatorExample.class.getName();

    private final H2DPluginAdapter plugin;

    public MediatorExample(H2DPluginAdapter plugin) {
        super(CLASS_NAME, new ViewExample(plugin));
        this.plugin = plugin;
    }

    @Override
    public String[] listNotificationInterests() {
        return EventExample.getList();
    }

    @Override
    public void handleNotification(INotification notification) {
        super.handleNotification(notification);

        EventExample event = EventExample.getEventNamed(notification.getName());

        switch (event){

            case INITIALISE_UI:

                viewComponent.initialise();

                break;

            case ADD_NEW_BUTTON :

                VisTextButton button = new VisTextButton(""+Math.random());
                viewComponent.addNewButton(button);

                break;

            case SET_LABEL_TEXT:

                if(notification.getBody() instanceof String)
                    viewComponent.setLableText(notification.getBody());

                break;
        }
    }
}
