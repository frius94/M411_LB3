public class Data {
    private String id;
    private String name;
    private String description;
    private int styleId;

    public Data(String id, String name, String description, int styleId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.styleId = styleId;
    }

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    int getStyleId() {
        return styleId;
    }

    void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                "; name='" + name + '\'' +
                "; description='" + description + '\'' +
                "; styleId=" + styleId +
                '}';
    }
}
