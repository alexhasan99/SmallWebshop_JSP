package ui;

public class ItemInfo {
    private String name;
    private String description;

    private byte[] imageData;

    public ItemInfo(String name, String description, byte[] imageData) {
        this.name = name;
        this.description = description;
        this.imageData=imageData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImageData() {
        return imageData;
    }
}
