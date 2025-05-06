package my_project.model;

public class DeathReason {

    private String reason;

    public DeathReason() {
        this.reason = "Unbekannt";
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

}
