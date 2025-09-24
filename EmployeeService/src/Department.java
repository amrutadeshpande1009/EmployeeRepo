public class Department {

    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }

    // Equals and hashCode for comparison in sets/maps
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Department)) return false;
        Department other = (Department) obj;
        return id == other.id && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }
}
