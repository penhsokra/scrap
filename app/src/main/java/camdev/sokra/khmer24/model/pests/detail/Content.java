package camdev.sokra.khmer24.model.pests.detail;

import java.util.List;

import pl.droidsonroids.jspoon.annotation.Selector;

public class Content {
    @Selector(".item-short-description > h1") private String title;
    @Selector(".item-short-description > .price > b") private String price;
    @Selector(".item-short-description .item-info li:first-child + li > span:last-child") private String location;
    @Selector(".item-short-description .item-info li:last-child > span:last-child") private String hits;
    @Selector(".item-short-description .item-info li + li + li > span:last-child time") private String date;
    @Selector(".item-detail .post-description") private String description;
    @Selector(value = ".list_numbers ul li a",attr = "href") private String telephone;
    @Selector(value = ".item-1 > a",attr = "href") private String bigIimge;

    public String getBigIimge() {
        return bigIimge;
    }

    public void setBigIimge(String bigIimge) {
        this.bigIimge = bigIimge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Content{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", location='" + location + '\'' +
                ", hits='" + hits + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
