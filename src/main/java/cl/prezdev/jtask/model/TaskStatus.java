package cl.prezdev.jtask.model;

public enum TaskStatus {
    DONE("Done"), UNDONE("Undone");
    
    private String description;
    
    TaskStatus(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
