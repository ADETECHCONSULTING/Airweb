package news.airweb.fr.airweb.view;

import java.util.List;

import news.airweb.fr.airweb.model.News;

public interface IMainView {
    void displayNews(List<News> newsList);
    void failedDisplayNews(String error);

}
