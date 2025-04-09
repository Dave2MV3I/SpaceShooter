package my_project.control;

public class SettingController {

    private boolean[] settings;

    // Methoden
    public SettingController(int size) {
        this.settings = new boolean[size];
    }

    /**
     *
     * @param i
     * 0 - music
     * 1 - sounds
     * 2 - level StatusDisplay
     * 3 - levelTimer StatusDisplay
     * 4 - globalTimer StatusDisplay
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
     */

    public boolean getActivity(int i){
        return settings[i];
    }

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
}