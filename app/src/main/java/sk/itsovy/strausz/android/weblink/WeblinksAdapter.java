package sk.itsovy.strausz.android.weblink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WeblinksAdapter extends RecyclerView.Adapter<WeblinksAdapter.WeblinksViewHolder> {

    private List<Weblink> weblinks;
    private OnWeblinkListener listener;

    public WeblinksAdapter(OnWeblinkListener listener) {
        this.listener = listener;
        this.weblinks = new ArrayList<>();
        weblinks.add(new Weblink("Vermilion flycatcher",3));
        weblinks.add(new Weblink("HMS royalist",1.2f));
        weblinks.add(new Weblink("Radonvilliers",3));
        weblinks.add(new Weblink("The Oceanides",3));
        weblinks.add(new Weblink("Tex Nelson",3));
        weblinks.add(new Weblink("Ahibaran",3));
        weblinks.add(new Weblink("Delmorad Bazar",3));

    }

    @NonNull
    @Override
    public WeblinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weblink_layout,parent, false);
        return new WeblinksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeblinksViewHolder holder, int position) {
        holder.bind(weblinks.get(position), listener);

    }

    @Override
    public int getItemCount() {
       return weblinks.size();
    }



    public void update(Weblink weblink) {

        for (int i = 0; i <weblinks.size() ; i++) {
            if(weblinks.get(i).getUuid().equals(weblink.getUuid())){
                weblinks.set(i, weblink);
                notifyItemChanged(i);
                return;

            }

                weblinks.add(0,weblink);
            notifyItemInserted(0);


        }
    }

    public void remove(int position) {

        weblinks.remove(position);
        notifyItemRemoved(position);
    }

    public static class WeblinksViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RatingBar ratingBar;

        public WeblinksViewHolder(@NonNull View layout) {
            super(layout);
            textView = layout.findViewById(R.id.textViewWeblinkTitle);
            ratingBar = layout.findViewById(R.id.ratingBar);

        }

        public void bind(final Weblink weblink, final OnWeblinkListener listener){
            textView.setText(weblink.getTitle());
            ratingBar.setRating(weblink.getRating());
            textView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    listener.onWeblinkClick(weblink);

                }


            });
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onWeblinkLongClick(weblink);

                   return true;
                }
            });

            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    weblink.setRating(rating);
                }
            });

        }


    }




}
