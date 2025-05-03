package my_project.model;
import my_project.control.LevelController;

public enum Level {
    LEVEL1(1, 8, 84, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png"),
    LEVEL2(2, 8, 60, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png"),
    LEVEL3(3, 8, 60, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png"),
    LEVEL4(4, 8, 60, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png"),
    LEVEL5(5, 8, 100, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png");

    public int myScene;
    public int nSpaceships;
    public int nBullets;
    public int nShields;
    public String bgSong;
    public String bgPicture;

    Level(int myScene, int nSpaceships, int nBullets, int nShields, String bgSong, String bgPicture) {
        this.myScene = myScene;
        this.nSpaceships = nSpaceships;
        this.nBullets = nBullets;
        this.nShields = nShields;
        this.bgSong = bgSong;
        this.bgPicture = bgPicture;
    }
}
