package my_project.control;

public class SettingController {

    private final boolean[] settings = {false, true, true, false, false, false, true};
    private final int[] statusSettingIndices = {2, 3, 4, 5, 6}; // die settings, im settings-Array zu denen ein StatusDisplay gehört

    private final String[] settingNames = {
            "music",
            "sounds",

            "level StatusDisplay",
            "levelTimer StatusDisplay",
            "globalTimer StatusDisplay",
            "FPS StatusDisplay",
            "attacks for this level left StatusDisplay"
    };
    private final String[] iconPaths = {
            "src/main/resources/graphic/menu/music.png",
            "src/main/resources/graphic/menu/sounds.png",

            "src/main/resources/graphic/menu/level.png",
            "src/main/resources/graphic/menu/time.png",
            "src/main/resources/graphic/menu/globalTime.png",
            "src/main/resources/graphic/menu/fps.png",
            "src/main/resources/graphic/menu/attacks.png"
    };

    // Methoden

    /**
     *
     * @param i
     * 0 - music
     * 1 - sounds
     * 2 - level StatusDisplay
     * 3 - levelTimer StatusDisplay
     * 4 - globalTimer StatusDisplay
     * 5 - FPS StatusDisplay
     */

    public void toggleSetting(int i){
        settings[i] = !settings[i];
    }
    public void setSetting(int i, boolean active){
        settings[i] = active;
    }

    /**
     *
     * @param i
     * 0 - music
     * 1 - sounds
     * 2 - level StatusDisplay
     * 3 - levelTimer StatusDisplay
     * 4 - globalTimer StatusDisplay
     * 5 - FPS StatusDisplay
     */

    public boolean getActivity(int i){
        return settings[i];
    }


    /**
     *
     * @param i
     * 0 - music
     * 1 - sounds
     * 2 - level StatusDisplay
     * 3 - levelTimer StatusDisplay
     * 4 - globalTimer StatusDisplay
     * 5 - FPS StatusDisplay
     */

    public String getSettingName(int i){
        return settingNames[i];
    }
    public boolean[] getSettings(){return settings;}
    public String[] getIconPaths(){return iconPaths;}
    public int[] getStatusSettingIndices() {return statusSettingIndices;}
}
