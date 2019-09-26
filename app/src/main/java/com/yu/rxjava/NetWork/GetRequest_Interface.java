package com.yu.rxjava.NetWork;

import com.yu.rxjava.Bean.ChildBean;
import com.yu.rxjava.Bean.MainBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * CREATED BY DY ON 2019/9/12.
 * TIME BY 9:29.
 **/
public interface GetRequest_Interface {

    @GET("categories")
    Observable<MainBean> GetCall();


    @GET("{type}/{count}/{page}")
    Observable<ChildBean> GetChild(@Path("type") String type, @Path("count") String count, @Path("page") String page);

    // @GET注解的作用:采用Get方法发送网络请求

    // getCall() = 接收网络请求数据的方法
    // 其中返回类型为Call<*>，*是接收数据的类（即上面定义的Translation类）
    // 如果想直接获得Responsebody中的内容，可以定义网络请求返回值为Call<ResponseBody>
}
