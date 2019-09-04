package camdev.sokra.khmer24.model.pests;

import pl.droidsonroids.jspoon.annotation.Selector;

public class Pets {
    @Selector(value = ".item > a",attr = "href") private String link;
    @Selector(value = ".item > a > article > .item-image > .img-cover", attr = "src")
    private String imageURL;
    @Selector(".item > a > article > .item-detail > .item-title")
    private String itemTitle;
    @Selector(".item > a > article > .item-detail > .description")
    private String description;
    @Selector(".item > a > article > .item-detail > .item-price")
    private String itemPrice;
    @Selector(".item > a > article > .item-detail > .summary li:first-child")
    private String location;
    @Selector(".item > a > article > .item-detail > .summary li:last-child")
    private String hits;
    @Selector(".item > a > article > .item-detail > .summary li > time")
    private String datePost;
    @Selector(value = ".justify-content-center ul li:last-child > a", attr = "rel")
    private String rel;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "link='" + link + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", itemTitle='" + itemTitle + '\'' +
                ", description='" + description + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                ", location='" + location + '\'' +
                ", hits='" + hits + '\'' +
                ", datePost='" + datePost + '\'' +
                ", rel='" + rel + '\'' +
                '}';
    }
}
