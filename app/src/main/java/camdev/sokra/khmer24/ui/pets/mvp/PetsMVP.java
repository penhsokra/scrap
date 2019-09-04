package camdev.sokra.khmer24.ui.pets.mvp;

import java.util.List;

import camdev.sokra.khmer24.callback.InteractorResponse;
import camdev.sokra.khmer24.model.pests.Pets;
import camdev.sokra.khmer24.model.pests.PetsRespone;

public interface PetsMVP {
    interface View{
        void onRequestSuccess(PetsRespone pets);
        void onRequestComplete(String message);
        void onRequestError(String message);
    }
    interface Presenter{
        void onLoadingData(int page);
        void onDestroy();
    }
    interface Interactor{
        void onLoadingData(int page, InteractorResponse<PetsRespone> response);
        void onDestroy();
    }
}
