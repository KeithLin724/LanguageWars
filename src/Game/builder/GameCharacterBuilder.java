package Game.builder;

import Game.GameCharacter;
import Game.DataPass.AniData;
import Game.DataPass.GamePlayerSpeedData;
import Game.DataPass.ImageScaleData;

/**
 * GameCharacterBuilder
 */
public class GameCharacterBuilder {
    private GameCharacter gameCharacter;

    public GameCharacterBuilder() {
        this.gameCharacter = new GameCharacter();
    }

    /**
     * This function sets the animation data for a game character using a builder
     * pattern.
     * 
     * @param aniData An object of type AniData that contains animation data for a
     *                game character. The
     *                method setAniData() sets this animation data for the game
     *                character being built by the
     *                GameCharacterBuilder.
     * @return The method is returning a GameCharacterBuilder object.
     */
    public GameCharacterBuilder setAniData(AniData aniData) {
        this.gameCharacter.setAniThing(aniData);
        return this;
    }

    /**
     * This function sets the image scale of a game character using the provided
     * ImageScaleData object and
     * returns a GameCharacterBuilder object.
     * 
     * @param isd isd is an object of type ImageScaleData which contains information
     *            about the scale of an
     *            image. This method sets the image scale of a GameCharacter object
     *            using the provided ImageScaleData
     *            object and returns a GameCharacterBuilder object.
     * @return The method is returning an instance of the GameCharacterBuilder
     *         class.
     */
    public GameCharacterBuilder setImageScale(ImageScaleData isd) {
        this.gameCharacter.setImageScale(isd);
        return this;
    }

    /**
     * This function sets the game player speed data for a game character builder
     * and returns the builder
     * object.
     * 
     * @param gps gps is an object of type GamePlayerSpeedData which contains data
     *            related to the speed of
     *            a game character. The method setGamePlayerSpeedData() sets the
     *            speed data of the game character
     *            being built by the GameCharacterBuilder object. The method returns
     *            the same GameCharacterBuilder
     *            object to allow for method
     * @return The method is returning a GameCharacterBuilder object.
     */
    public GameCharacterBuilder setGamePlayerSpeedData(GamePlayerSpeedData gps) {
        this.gameCharacter.setGamePlayerSpeedData(gps);
        return this;
    }

    /**
     * The function returns a GameCharacter object that was built using the builder
     * pattern.
     * 
     * @return A GameCharacter object is being returned.
     */
    public GameCharacter build() {
        return this.gameCharacter;
    }
}