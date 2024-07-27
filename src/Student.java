public class Student {
    private final String id;
    private final String name;

    //Each student has a Name and Unique Student ID
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}