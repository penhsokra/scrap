package camdev.sokra.khmer24.model.pests;

import pl.droidsonroids.jspoon.annotation.Selector;

public class Pagination {
    @Selector(value = ".pagination .page-item:last-child > a",attr = "rel") private String rel;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "rel='" + rel + '\'' +
                '}';
    }
}
