package camdev.sokra.khmer24.ui.pets.mvp;

import camdev.sokra.khmer24.callback.InteractorResponse;
import camdev.sokra.khmer24.model.pests.PetsRespone;

public class PetsPresenter implements PetsMVP.Presenter{
    private PetsMVP.Interactor interactor;
    private PetsMVP.View view;

    public PetsPresenter(PetsMVP.View view) {
        this.interactor = new PetsInteractor();
        this.view = view;
    }

    @Override
    public void onLoadingData(int page) {
        interactor.onLoadingData(page, new InteractorResponse<PetsRespone>() {
            @Override
            public void onSuccess(PetsRespone dataResponse) {
                view.onRequestSuccess(dataResponse);
            }

            @Override
            public void onComplete(String message) {
                view.onRequestComplete(message);
            }

            @Override
            public void onError(String message) {
                view.onRequestError(message);
            }
        });
    }

    @Override
    public void onDestroy() {
        interactor.onDestroy();
    }
}
