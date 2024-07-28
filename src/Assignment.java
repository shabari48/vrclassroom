public class Assignment {
    private final String name;
    private final String details;

    public Assignment(String name, String details) {
        this.name = name;
        this.details = details;
    }

    //Getters for returning the private attributes(name and details) of Assignment

    public String getName() {
        return name;
    }

  
    public String getDetails() {
        return details;
    }
}