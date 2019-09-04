package camdev.sokra.khmer24.adapter.pets;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;
import camdev.sokra.khmer24.R;
import camdev.sokra.khmer24.model.pests.Pets;

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.Viewholder> {
    private AppCompatActivity context;
    private List<Pets> petsListRespone;
    private OnCallback listener;

    public PetsAdapter(List<Pets> petsListRespone, AppCompatActivity context) {
        this.petsListRespone = petsListRespone;
        this.context = context;
        this.listener = (OnCallback) context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pets_rows_lists,viewGroup,false);
        return new PetsAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {
        final Pets pets = petsListRespone.get(i);
        viewholder.title.setText(pets.getItemTitle());
        viewholder.des.setText(pets.getDescription());
        viewholder.price.setText(pets.getItemPrice());
        viewholder.datetime.setText(pets.getLocation()+ " / "+pets.getDatePost());
        viewholder.hits.setText(pets.getHits());
        Glide.with(context).load(pets.getImageURL()).thumbnail(Glide.with(context).load(R.drawable.loading)).into(viewholder.imageURL);

        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (listener !=null){
                listener.OnArticleClick(i,pets);
            }
            }
        });
    }

    @Override
    public int getItemCount() {
        return petsListRespone.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        private TextView title,datetime,hits,des,price;
        ImageView imageURL;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            des = itemView.findViewById(R.id.desciption);
            price = itemView.findViewById(R.id.price);
            datetime = itemView.findViewById(R.id.dateTime);
            imageURL = itemView.findViewById(R.id.imageURL);
            hits = itemView.findViewById(R.id.hits);
        }
    }

    public void addMoreItem(List<Pets> pets){
        int previousDataSize = this.petsListRespone.size();
        this.petsListRespone.addAll(pets);
        notifyItemRangeInserted(previousDataSize, pets.size());
    }

    public interface OnCallback{
        void OnArticleClick(int position, Pets pets);
    }
}
