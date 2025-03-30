package my_project.model.userInterface;

public class Setting {


    // Attribute
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
    public double getVariable(){return variable;}
}