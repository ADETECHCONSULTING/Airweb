package news.airweb.fr.airweb.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import news.airweb.fr.airweb.adapter.NewsAdapter;
import news.airweb.fr.airweb.R;
import news.airweb.fr.airweb.model.News;
import news.airweb.fr.airweb.view.IMainView;

public class NewsFragment extends Fragment implements IMainView {

    @BindView(R.id.rcvNews)
    RecyclerView rcvNews;

    NewsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new NewsAdapter(getContext());

        rcvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvNews.hasFixedSize();
        rcvNews.setAdapter(adapter);
    }

    @Override
    public void displayNews(List<News> newsList) {
        adapter.resetData(newsList);
        Log.i("NewsFragment", "News Fetch : Count = "+newsList.size());
    }

    @Override
    public void failedDisplayNews(String error) {
        //Dialog error
        Log.e("NewsFragment", error);
    }
}
