package Game.PLUG.gameDrawer;

import java.awt.Graphics2D;

@FunctionalInterface
public interface GameRenderInterface {

    /**
     * This function is called every time the game needs to be rendered.
     * 
     * @param g The Graphics object to draw to.
     */
    public void render(Graphics2D g);
}
