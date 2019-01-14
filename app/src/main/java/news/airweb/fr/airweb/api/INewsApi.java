package news.airweb.fr.airweb.api;

import java.util.List;

import news.airweb.fr.airweb.model.News;
import news.airweb.fr.airweb.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;

public interface INewsApi {

    @GET("psg/psg.json")
    Call<Result> getPSGNews();

}
