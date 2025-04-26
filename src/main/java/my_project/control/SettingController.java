package my_project.control;

public class SettingController {

    private final boolean[] settings = {false, true, true, false, false, false};
    private final String[] settingNames = {"music", "sounds", "level StatusDisplay", "levelTimer StatusDisplay", "globalTimer StatusDisplay", "FPS StatusDisplay"};

    // Methoden
    public SettingController(int size) {
        if (size != settings.length) System.out.println("ERROR: Amount of Settings in SettingController wrong.");
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

    public void toggleSetting(int i){
        settings[i] = !settings[i];
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
}
