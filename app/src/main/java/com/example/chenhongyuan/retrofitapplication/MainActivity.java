package com.example.chenhongyuan.retrofitapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends ActionBarActivity {
    RestAdapter adapter = new RestAdapter.Builder()
            .setEndpoint("http://news-at.zhihu.com")
            .build();
    final TestService service = adapter.create(TestService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_test)
    public void btn_test(Button testbtn){
        service.information().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Information>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Information information) {
                        Toast.makeText(MainActivity.this, new Gson().toJson(information), Toast.LENGTH_LONG).show();
                    }
                });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Information result = service.information();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(MainActivity.this, new Gson().toJson(result), Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        }).start();
    }
    public static interface TestService {
        @GET("/api/4/news/latest")
        HashMap dateList ();
        @GET("/api/4/news/latest")
        Observable<Information> information ();
        @GET("/api/4/start-image/1080*1776")
        Observable<Image> image();
        @GET("/api/4/version/android/2.3.0")
        Observable<Version> version();
        @GET("/api/4/news/3892357")
        Observable<Info> info();
        @GET("/api/4/news/before/20131119")
        Observable<OldInfo> oldinfo();
        @GET("/api/4/story-extra/{id}")
        Observable<News> news(@Path("id") int newsId);
        @GET("/api/4/story/4232852/long-comments")
        Observable<Comment> comments();
        @GET("/api/4/themes")
        Observable<Themes> themes();
        @GET("/api/3/news/hot")
        Observable<HotNews> hotnews();
    }
    @OnClick(R.id.btn1)
    public void btn_imge (Button btn_image){
        service.image().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Image>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Image image) {
                        Toast.makeText(MainActivity.this, new Gson().toJson(image), Toast.LENGTH_LONG).show();
                    }
                });
    }
    @OnClick(R.id.btn2)
    public void btn_version(Button btn_version){
        service.version().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Version>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Version version) {
                        Toast.makeText(MainActivity.this, new Gson().toJson(version), Toast.LENGTH_LONG).show();
                    }
                });
    }
    @OnClick(R.id.btn3)
    public void setBtn_getinfo(Button btn){
        service.info().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Info>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Info info) {
                        Toast.makeText(MainActivity.this, new Gson().toJson(info), Toast.LENGTH_LONG).show();
                    }
                });

    }
    @OnClick(R.id.btn4)
    public void btn_oldinfo(Button btn_oldinfo){
        service.oldinfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OldInfo>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(OldInfo oldInfo) {
                        Toast.makeText(MainActivity.this, new Gson().toJson(oldInfo), Toast.LENGTH_LONG).show();
                    }
                });
    }
    @OnClick(R.id.btn5)
    public void btn_news(Button btn_news) {
        service.news(3930445).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<News>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(News news) {
                        Toast.makeText(MainActivity.this, new String(" "+news.popularity), Toast.LENGTH_LONG).show();
                    }
                });
    }
    @OnClick(R.id.btn6)
    public void Btn_comments(Button btn_comments){
        service.comments().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Comment>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Comment comment) {
                        Toast.makeText(MainActivity.this, new Gson().toJson(comment), Toast.LENGTH_LONG).show();
                    }
                });
    }
    @OnClick(R.id.btn7)
    public void btn_themes(Button btn_themes){
        service.themes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Themes>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Themes themes) {
                        Toast.makeText(MainActivity.this, new Gson().toJson(themes), Toast.LENGTH_LONG).show();
                    }
                });
    }
    @OnClick(R.id.btn8)
    public void btn_hotnews(Button btn_hotnews){
        service.hotnews().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotNews>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(HotNews hotNews) {
                        Toast.makeText(MainActivity.this, new Gson().toJson(hotNews), Toast.LENGTH_LONG).show();
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
