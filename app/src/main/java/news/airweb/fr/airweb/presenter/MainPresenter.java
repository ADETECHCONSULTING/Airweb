package news.airweb.fr.airweb.presenter;

import android.app.ProgressDialog;
import android.content.Context;

import news.airweb.fr.airweb.api.INewsApi;
import news.airweb.fr.airweb.model.Result;
import news.airweb.fr.airweb.view.IMainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter {

    private IMainView IMainView;
    private Context context;
    private static final String BASEURL = "https://airweb-demo.airweb.fr/psg/psg.json";
    private Retrofit retrofit;
    private INewsApi newsAPI;

    public MainPresenter(IMainView IMainView, Context context){
        this.IMainView = IMainView;
        this.context = context;
    }

    public void getAllNews(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        newsAPI = retrofit.create(INewsApi.class);

        // Set up progress before call
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setTitle("ProgressDialog bar example");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // show it
        progressDoalog.show();

        Call<Result> resultCall = newsAPI.getPSGNews();

        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDoalog.dismiss();
                IMainView.displayNews(response.body().getNews());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDoalog.dismiss();
                IMainView.failedDisplayNews(t.getMessage());
            }
        });
    }
}
