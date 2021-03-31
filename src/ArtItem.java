
public final class ArtItem extends Item {
    private String author;

    // painting, sculpture, etc...
    private String type;

    public ArtItem(User buyer, User seller, String name, String description, int startingPrice, String author, String type) {
        super(buyer, seller, name, description, startingPrice);
        this.author = author;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ArtItem{" +
                "author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                '}';
    }
}
