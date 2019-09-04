package camdev.sokra.khmer24.ui.pets;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import camdev.sokra.khmer24.R;
import camdev.sokra.khmer24.connection.Khmer24ServiceGenerator;
import camdev.sokra.khmer24.model.pests.detail.ContentRespone;
import camdev.sokra.khmer24.service.Khmer24Service;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class DetailActivity extends AppCompatActivity {
    private Khmer24Service khmer24Service;
    private CompositeDisposable disposable = new CompositeDisposable();
    private TextView title,price,hits,location,phone,date,content;
    private ImageView imageView;
    private ConstraintLayout contentWrap;
    private ProgressBar xprogressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = findViewById(R.id.tititle);
        price = findViewById(R.id.price);
        hits = findViewById(R.id.hits);
        location = findViewById(R.id.location);
        phone = findViewById(R.id.telephone);
        content = findViewById(R.id.content);
        imageView = findViewById(R.id.imageView);
        contentWrap = findViewById(R.id.contentWrap);
        xprogressBar = findViewById(R.id.xprogressBar);
        khmer24Service = Khmer24ServiceGenerator.createService(Khmer24Service.class);

        if (getIntent() !=null){
            String substringURL = "https://www.khmer24.com/en/";
            String endPoint = getIntent().getExtras().getString("url").substring(substringURL.length());
            disposable.add(
                khmer24Service.getDetail(endPoint)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSubscriber<ContentRespone>() {
                        @Override
                        public void onNext(ContentRespone contentRespone) {
                            String phoneNumber = contentRespone.getPhoneDetail().getTelephone();
                            phoneNumber.substring(3);
                            title.setText(contentRespone.getContentDetail().getTitle());
                            content.setText(contentRespone.getContentTextDetail().getDescription());
                            phone.setText(contentRespone.getPhoneDetail().getTelephone());
                            hits.setText("View "+contentRespone.getContentDetail().getHits());
                            location.setText("Location "+contentRespone.getContentDetail().getLocation());
                            price.setText(contentRespone.getContentDetail().getPrice());
                            Glide.with(getApplicationContext()).load(contentRespone.getImageSlides().getBigIimge()).into(imageView);
                        }

                        @Override
                        public void onError(Throwable t) {
                            Log.e("0000",""+t.toString());
                        }

                        @Override
                        public void onComplete() {
                            contentWrap.setVisibility(View.VISIBLE);
                            xprogressBar.setVisibility(View.GONE);
                        }
                    })
            );
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
