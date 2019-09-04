package camdev.sokra.khmer24.ui.pets;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import camdev.sokra.khmer24.R;
import camdev.sokra.khmer24.adapter.pets.PetsAdapter;
import camdev.sokra.khmer24.connection.Khmer24ServiceGenerator;
import camdev.sokra.khmer24.model.pests.PaginationRespone;
import camdev.sokra.khmer24.model.pests.Pets;
import camdev.sokra.khmer24.model.pests.PetsRespone;
import camdev.sokra.khmer24.service.Khmer24Service;
import camdev.sokra.khmer24.ui.pets.mvp.PetsMVP;
import camdev.sokra.khmer24.ui.pets.mvp.PetsPresenter;
import camdev.sokra.khmer24.util.pagination.PaginationScrollListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class PetsActivity extends AppCompatActivity implements PetsMVP.View,PetsAdapter.OnCallback{
    private PetsMVP.Presenter presenter;
    private int page = 0;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private RecyclerView rvPet;
    private ProgressBar progressBar;
    private List<Pets> petsList = new ArrayList<>();
    private PetsAdapter petsAdapter;
    private Khmer24Service khmer24Service;
    private CompositeDisposable disposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        rvPet = findViewById(R.id.rvPet);
        progressBar = findViewById(R.id.progressBar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvPet.setLayoutManager(linearLayoutManager);
        petsAdapter = new PetsAdapter(petsList,this);
        rvPet.setAdapter(petsAdapter);

        khmer24Service = Khmer24ServiceGenerator.createService(Khmer24Service.class);
        presenter = new PetsPresenter(this);
        rvPet.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {

            @Override
            protected void loadMoreItems() {
                progressBar.setVisibility(View.VISIBLE);
                isLoading = true;
                if (!isLastPage) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            checkPagenat(page);
                            presenter.onLoadingData(page);
                            //Log.e("0000",""+page);
                        }
                    }, 100);
                }
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
        checkPagenat(0);
        presenter.onLoadingData(0);

    }

    @Override
    public void onRequestSuccess(PetsRespone pets) {
        //Log.e("0000",""+pets.getPets().size());
        progressBar.setVisibility(View.GONE);
       // Log.e("0000",""+ pets.getPets().toString());
        petsAdapter.addMoreItem(pets.getPets());
    }

    @Override
    public void onRequestComplete(String message) {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onRequestError(String message) {
        Toast.makeText(this, ""+message.toString(), Toast.LENGTH_SHORT).show();
        //Log.e("0000",""+ message.toString());
        progressBar.setVisibility(View.GONE);
    }

    public void checkPagenat(int paginate){
        disposable.add(khmer24Service.getPagenate(paginate).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSubscriber<PaginationRespone>() {
            @Override
            public void onNext(PaginationRespone paginationRespone) {
                Log.e("0000",""+paginationRespone.getPaginationList());
                isLoading = false;
                if (paginationRespone != null) {
                    if (paginationRespone.getPaginationList().getRel().isEmpty()) {
                        isLastPage = true;
                        Toast.makeText(getApplicationContext(), "All of Articles", Toast.LENGTH_LONG).show();
                        Log.e("0000","All of Articles");
                    } else {
                        page =page+50;
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onComplete() {

            }
        }));
    }

    @Override
    public void OnArticleClick(int position, Pets pets) {
        Intent intent = new Intent(this,DetailActivity.class);
        String url = pets.getLink();
        intent.putExtra("url",url);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}

