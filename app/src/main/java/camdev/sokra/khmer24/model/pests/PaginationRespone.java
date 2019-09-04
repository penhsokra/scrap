package camdev.sokra.khmer24.model.pests;

import java.util.List;

import pl.droidsonroids.jspoon.annotation.Selector;

public class PaginationRespone {
    @Selector(".pagination") private Pagination paginationList;

    public Pagination getPaginationList() {
        return paginationList;
    }

    public void setPaginationList(Pagination paginationList) {
        this.paginationList = paginationList;
    }

    @Override
    public String toString() {
        return "PaginationRespone{" +
                "paginationList=" + paginationList +
                '}';
    }
}
