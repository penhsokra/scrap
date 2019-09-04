package camdev.sokra.khmer24.ui.pets.mvp;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import camdev.sokra.khmer24.callback.InteractorResponse;
import camdev.sokra.khmer24.connection.Khmer24ServiceGenerator;
import camdev.sokra.khmer24.model.pests.PetsRespone;
import camdev.sokra.khmer24.service.Khmer24Service;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class PetsInteractor implements PetsMVP.Interactor{
    Khmer24Service khmer24Service;
    AppCompatActivity context;
    private CompositeDisposable disposable = new CompositeDisposable();
    public PetsInteractor() {
        this.khmer24Service = Khmer24ServiceGenerator.createService(Khmer24Service.class);
    }

    @Override
    public void onLoadingData(int page, final InteractorResponse<PetsRespone> response) {
        disposable.add(
            khmer24Service.getPets(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<PetsRespone>() {
                    @Override
                    public void onNext(PetsRespone petsRespone) {
                        response.onSuccess(petsRespone);
                    }

                    @Override
                    public void onError(Throwable t) {
                        response.onError(""+t.toString());
                    }

                    @Override
                    public void onComplete() {
                        response.onComplete("complete");
                    }
                }
        ));
    }

    @Override
    public void onDestroy() {
        disposable.clear();
    }
}
