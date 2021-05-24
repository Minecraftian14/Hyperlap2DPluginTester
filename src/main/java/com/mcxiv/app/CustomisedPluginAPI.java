package com.mcxiv.app;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kotcrab.vis.ui.widget.VisImageButton;
import games.rednblack.editor.renderer.SceneLoader;
import games.rednblack.editor.renderer.data.ProjectInfoVO;
import games.rednblack.h2d.common.IItemCommand;
import games.rednblack.h2d.common.plugins.PluginAPI;
import games.rednblack.h2d.common.view.tools.Tool;
import games.rednblack.h2d.common.vo.CursorData;
import games.rednblack.h2d.common.vo.EditorConfigVO;
import games.rednblack.h2d.common.vo.ProjectVO;
import games.rednblack.h2d.common.vo.SceneConfigVO;
import org.puremvc.java.interfaces.IFacade;
import org.puremvc.java.patterns.facade.Facade;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

class CustomisedPluginAPI implements PluginAPI {

    static final CustomisedPluginAPI instance = new CustomisedPluginAPI();

    IFacade facade = new Facade();

    private CustomisedPluginAPI() {
    }

    @Override
    public SceneLoader getSceneLoader() {
        return null;
    }

    @Override
    public IFacade getFacade() {
        return facade;
    }

    @Override
    public PooledEngine getEngine() {
        return null;
    }

    @Override
    public Stage getUIStage() {
        return PluginTester.instance.stage;
    }

    @Override
    public String getPluginDir() {
        return null;
    }

    @Override
    public String getCacheDir() {
        return System.getenv("APPDATA") + File.separator + ".hyperlap2d" + File.separator + "cache";
    }

    @Override
    public String getProjectPath() {
        return null;
    }

    @Override
    public TextureAtlas getProjectTextureAtlas() {
        return null;
    }

    @Override
    public void addMenuItem(String menu, String subMenuName, String notificationName) {

    }

    @Override
    public void addTool(String toolName, VisImageButton.VisImageButtonStyle toolBtnStyle, boolean addSeparator, Tool tool) {

    }

    @Override
    public void toolHotSwap(Tool tool) {

    }

    @Override
    public void toolHotSwapBack() {

    }

    @Override
    public void setDropDownItemName(String action, String name) {

    }

    @Override
    public void reLoadProject() {

    }

    @Override
    public void saveProject() {

    }

    @Override
    public void revertibleCommand(IItemCommand command, Object body) {

    }

    @Override
    public void removeFollower(Entity entity) {

    }

    @Override
    public Entity drawImage(String regionName, Vector2 position) {
        return null;
    }

    @Override
    public HashSet<Entity> getProjectEntities() {
        return null;
    }

    @Override
    public boolean isEntityVisible(Entity entity) {
        return false;
    }

    @Override
    public void showPopup(HashMap<String, String> actionsSet, Object observable) {

    }

    @Override
    public void setCursor(CursorData cursorData, TextureRegion region) {

    }

    @Override
    public String getCurrentSelectedLayerName() {
        return null;
    }

    EditorConfigVO editorConfigVO = new EditorConfigVO();

    @Override
    public EditorConfigVO getEditorConfig() {
        return editorConfigVO;
    }

    public void setEditorConfigVO(EditorConfigVO editorConfigVO) {
        this.editorConfigVO = editorConfigVO;
    }

    @Override
    public SceneConfigVO getCurrentSceneConfigVO() {
        return null;
    }

    @Override
    public ProjectVO getCurrentProjectVO() {
        return null;
    }

    @Override
    public ProjectInfoVO getCurrentProjectInfoVO() {
        return null;
    }
}
