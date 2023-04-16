package Game.Loader;

import base.loader.FileNameFormatter;

public final class ImageNamePath {
    public static final String PLAYER_MAIN_CHARACTER = "../../res/mainCharacter/";

    /**
     * `imagePath` returns a string that is the concatenation of the folder name and
     * the file name
     * 
     * @param folderName The name of the folder where the file is located.
     * @param fileName   The name of the file.
     * @return A String
     */
    public static String imagePath(String folderName, String fileName) {
        return FileNameFormatter.of(folderName + fileName, FileNameFormatter.IMAGE);
    }
}