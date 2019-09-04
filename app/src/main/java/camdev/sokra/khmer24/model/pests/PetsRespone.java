package camdev.sokra.khmer24.model.pests;

import java.util.List;

import pl.droidsonroids.jspoon.annotation.Selector;

public class PetsRespone {
    @Selector(".list-items.item-list .item:not(.item-sponsors)") private List<Pets> pets;

    public List<Pets> getPets() {
        return pets;
    }

    public void setPets(List<Pets> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "PetsRespone{" +
                "pets=" + pets +
                '}';
    }


}
