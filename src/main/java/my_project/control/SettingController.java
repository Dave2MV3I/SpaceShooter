package my_project.control;

public class SettingController {

    private boolean[] settings = {false, true, false, false, false, false};
    private String[] settingNames = {"music", "sounds", "level StatusDisplay", "levelTimer StatusDisplay", "globalTimer StatusDisplay", "FPS StatusDisplay"};

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
    //System.out.println(1/dt ); /*FPS ANZEIGE*/
    //System.out.println(p1.getHealth());

    /*
    private String name;
    private String iconPath;
    private boolean active;
    private double variable;

    // Arrays


    // Referenzen


    // Konstruktoren
    public Setting(String name, String iconPath, boolean active){
        this.name = name;
        this.iconPath = iconPath;
        this.active = active;
    }
    public Setting(String name, String iconPath, boolean active, double variable){
        this.name = name;
        this.iconPath = iconPath;
        this.active = active;
        this.variable = variable;
    }

    // Methoden
    public String getName(){return name;}
    public boolean isActive(){return active;}
    public String getIconPath(){return iconPath;}
    public void switchActivity() {
        active = !active;
    }
    public double getVariable(){return variable;}*/
