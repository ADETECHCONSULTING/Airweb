package news.airweb.fr.airweb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.airweb.fr.airweb.R;
import news.airweb.fr.airweb.model.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    public Context context;
    public List<News> items;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void resetData(List<News> items){
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_news, parent, false);

        NewsHolder newsHolder = new NewsHolder(view);

        newsHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();
            }
        });

        return newsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News item = items.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txvContent) TextView txvContent;
        @BindView(R.id.txvTitle) TextView txvTitle;
        @BindView(R.id.imvThumbs) ImageView imvThumbs;


        public NewsHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(context, itemView);
        }

        public void setData(News item){
            txvContent.setText(item.getContent());
            txvTitle.setText(item.getTitle());
            Picasso.get().load(item.getPicture())
                    .centerCrop()
                    .error(R.drawable.ic_logo)
                    .into(imvThumbs);
        }
    }
}
