package Game.GUI.ui;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Game.PLUG.gameDrawer.GameAnimatedDrawer;
import Game.gameBase.GamePoint;
import Game.state.MouseState;

public abstract class GameButtonBase implements GameAnimatedDrawer {
    protected GamePoint point;

    protected MouseState mouseState;

    protected Rectangle bounds;

    public GameButtonBase(GamePoint point) {
        this.point = point;
    }

    public MouseState getMouseState() {
        return mouseState;
    }

    public void setMouseState(MouseState mouseState) {
        this.mouseState = mouseState;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isIn(MouseEvent mouseEvent) {
        return this.bounds.contains(mouseEvent.getX(), mouseEvent.getY());
    }

    public void resetState() {
        this.mouseState = MouseState.NONE;
    }

    protected abstract void initBounds();

}