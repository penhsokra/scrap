package camdev.sokra.khmer24.model.pests.detail;

import java.util.List;

import pl.droidsonroids.jspoon.annotation.Selector;

public class ContentRespone {
    @Selector(".item.item-1") private Content imageSlides;
    @Selector(".item-short-description") private Content contentDetail;
    @Selector(".item-detail") private Content contentTextDetail;
    @Selector(".list_numbers") private Content phoneDetail;

    public Content getImageSlides() {
        return imageSlides;
    }

    public void setImageSlides(Content imageSlides) {
        this.imageSlides = imageSlides;
    }

    public Content getContentDetail() {
        return contentDetail;
    }

    public void setContentDetail(Content contentDetail) {
        this.contentDetail = contentDetail;
    }

    public Content getContentTextDetail() {
        return contentTextDetail;
    }

    public void setContentTextDetail(Content contentTextDetail) {
        this.contentTextDetail = contentTextDetail;
    }

    public Content getPhoneDetail() {
        return phoneDetail;
    }

    public void setPhoneDetail(Content phoneDetail) {
        this.phoneDetail = phoneDetail;
    }

    @Override
    public String toString() {
        return "ContentRespone{" +
                "imageSlides=" + imageSlides +
                ", contentDetail=" + contentDetail +
                ", contentTextDetail=" + contentTextDetail +
                ", phoneDetail=" + phoneDetail +
                '}';
    }
}
