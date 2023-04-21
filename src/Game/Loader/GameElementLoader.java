package Game.Loader;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

import Game.DataPass;
import Game.GameCharacter;
import Game.DataPass.AniData;
import Game.DataPass.GamePlayerSpeedData;
import Game.DataPass.ImageScaleData;
import Game.builder.GameCharacterBuilder;
import base.loader.BaseLoader;

import static base.BaseGameConstant.TILES_IN_HEIGHT;
import static base.BaseGameConstant.TILES_IN_WIDTH;;

// Factory 
public class GameElementLoader {

    public GameCharacter gameCharacter() {
        return null;
    }

    public static GameCharacter getTestingGameCharacter() {
        return new GameCharacterBuilder()
                .setAniData(new AniData(0, 0, 35))
                .setImageScale(new ImageScaleData(0, 0, 10))
                .setGamePlayerSpeedData(new GamePlayerSpeedData(5.0f))
                .build();
    }

    public static GameCharacter getTestingGameCharacter(String fileName) {
        try {
            return loadCharacterByPath(fileName);

        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static GameCharacter loadCharacterByPath(String fileName)
            throws IOException, URISyntaxException, NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        GameCharacterBuilder gameCharacterBuilder = new GameCharacterBuilder();
        var fileData = BaseLoader.loadTextFile(GameElementLoader.class, fileName);

        String path = fileData.get(0);
        String stateFrame = fileData.get(1);

        // state data
        var stateData = DataPass.stringDataToIntArray(stateFrame);
        gameCharacterBuilder.setAnimationImage(path, stateData[0], stateData[1]);

        // ani data
        String aniData = fileData.get(2);
        var aniDataArray = DataPass.stringDataToIntArray(aniData);
        gameCharacterBuilder.setAniData(DataPass.build(aniDataArray, AniData.class));

        // img data
        String imgData = fileData.get(3);
        var imgDataArr = DataPass.stringDataToIntArray(imgData);
        gameCharacterBuilder.setImageScale(DataPass.build(imgDataArr, ImageScaleData.class));

        // player speed
        float playerSpeed = Float.parseFloat(fileData.get(4));
        gameCharacterBuilder.setGamePlayerSpeedData(new GamePlayerSpeedData(playerSpeed));

        return gameCharacterBuilder.build();
    }

    // this is a function for load the pixel where to put
    // for the GameMapLevelManager
    /**
     * This function loads game level data from an image file and returns it as a 2D
     * integer array.
     * 
     * @param fileName         The name of the file containing the game level data.
     * @param checkHeightBlock The height of each block in pixels that is checked in
     *                         the level image.
     * @param checkWidthBlock  The width of each block in pixels that is being
     *                         checked in the level
     *                         image.
     * @return The method is returning a 2D integer array called `levelData`.
     */
    public static int[][] loadGameLevelData(String fileName, int checkHeightBlock, int checkWidthBlock)
            throws IOException {

        int[][] levelData = new int[TILES_IN_HEIGHT][TILES_IN_WIDTH];
        BufferedImage levelImage = ImageLoader.loadImage(fileName);

        for (int row = 0; row < levelImage.getHeight(); row++) {
            for (int col = 0; col < levelImage.getWidth(); col++) {
                Color color = new Color(levelImage.getRGB(col, row));

                int value = color.getRed();

                if (value >= checkHeightBlock * checkWidthBlock) {
                    value = 0;
                }

                levelData[row][col] = value;
            }
        }

        return levelData;
    }
}
