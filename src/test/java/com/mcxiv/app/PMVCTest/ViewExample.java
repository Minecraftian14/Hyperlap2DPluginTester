package com.mcxiv.app.PMVCTest;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.widget.LinkLabel;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;
import games.rednblack.h2d.common.plugins.H2DPluginAdapter;

class ViewExample extends VisTable {

    private final H2DPluginAdapter plugin;

    private VisLabel lbl_display;

    private Array<VisTextButton> buttons;

    private VisTextButton btn_addNew;

    public ViewExample(H2DPluginAdapter plugin) {
        this.plugin = plugin;
    }

    void initialise() {
        lbl_display = new LinkLabel("Some Text Here");

        buttons = new Array<>();

        btn_addNew = new VisTextButton("Add New Button");
        btn_addNew.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                plugin.facade.sendNotification(EventExample.ADD_NEW_BUTTON.getName());
            }
        });
        createUI();
    }

    void createUI() {
        clear();

        add(lbl_display).pad(30).center().row();

        buttons.forEach(button -> ViewExample.this.add(button).pad(20).row());

        add(btn_addNew).pad(30);
    }

    void addNewButton(VisTextButton button) {
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                plugin.facade.sendNotification(EventExample.SET_LABEL_TEXT.getName(), button.getText());
            }
        });
        buttons.add(button);
        createUI();
    }

    void setLableText(String body) {
        lbl_display.setText(body);
    }
}
