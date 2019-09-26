package com.yu.rxjava.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.yu.rxjava.Bean.ChildBean;
import com.yu.rxjava.Bean.MainBean;
import com.yu.rxjava.NetWork.GetRequest_Interface;
import com.yu.rxjava.Presenter.Presenter;
import com.yu.rxjava.R;
import com.yu.rxjava.View.IView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements IView {

//    private TabLayout title;
//    private ViewPager viewPager;
    private Presenter presenter;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void init() {
        presenter = new Presenter(this);
//        title = findViewById(R.id.title_view);
//        viewPager = findViewById(R.id.View_Pager);
        webView = findViewById(R.id.webview);
        presenter.LoadToModel("休息视频","1","1",MainActivity.this);
    }

    @Override
    public void SetInfo(ChildBean.ResultsBean resultsBean) {
//        Log.e("sss",resultsBean.getUrl());
        webView.loadUrl(resultsBean.getUrl());
    }

    @Override
    public void SetErr(String err) {
//        HelloWorld.setText(err);
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }


}
