package com.yu.rxjava.NetWork;

import com.yu.rxjava.API.NetWorkApi;
import com.yu.rxjava.Bean.ChildBean;
import com.yu.rxjava.Bean.MainBean;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * CREATED BY DY ON 2019/9/12.
 * TIME BY 10:58.
 **/
public class RetrofitHelper {
   private Retrofit retrofit;
   private GetRequest_Interface getRequest_interface;
    public RetrofitHelper() {
         retrofit = new Retrofit.Builder()
                .baseUrl(NetWorkApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        getRequest_interface = retrofit.create(GetRequest_Interface.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public GetRequest_Interface getGetRequest_interface() {
        return getRequest_interface;
    }

    public void setGetRequest_interface(GetRequest_Interface getRequest_interface) {
        this.getRequest_interface = getRequest_interface;
    }

//    public Observable<MainBean> getMainBean(){
//        return getRequest_interface.GetCall();
//    }

    public Observable<ChildBean> GetChild(String tag, String count, String page){
        return getRequest_interface.GetChild(tag,count,page);
    }

}
