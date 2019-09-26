package com.yu.rxjava.Model;

import android.content.Context;
import android.util.Log;

import com.yu.rxjava.Bean.ChildBean;
import com.yu.rxjava.NetWork.RetrofitHelper;
import com.yu.rxjava.Presenter.IOnListener;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * CREATED BY DY ON 2019/9/11.
 * TIME BY 10:48.
 **/
public class Model implements IModel {
    private static final String TAG = "ss";
    private Observable<Integer> observable;
    private Observer<Integer> observer;
    @Override
    public void HandleData(String input, Context context, final IOnListener listener) {
//        initObserbavle();
//        initObserver(input, listener);
//        Subscribe();
//        RetrofitHelper retrofitHelper = new RetrofitHelper();
//        retrofitHelper.getMainBean()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<MainBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(MainBean mainBean) {
//                        for (MainBean.ResultsBean resultsBean :mainBean.getResults()) {
//                            listener.Success(resultsBean.getName());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//        retrofitHelper.GetChirldBean(input)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ChildBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(ChildBean chirldBean) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    @Override
    public void LoadChild(String tag, String count, String page, final IOnListener listener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.GetChild(tag,count,page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ChildBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ChildBean childBean) {
                for (ChildBean.ResultsBean resultsBean:childBean.getResults()) {
                    listener.Success(resultsBean);
                }
            }

            @Override
            public void onError(Throwable e) {
                listener.Error(e.toString());
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public String contentToString(String content) {
        return content;
    }

    private void Subscribe() {
        observable.subscribe(observer);
        // 或者 observable.subscribe(subscriber)；

//        <-- Observable.subscribe(Subscriber) 的内部实现 -->
//        public Subscription subscribe(Subscriber subscriber) {
//            subscriber.onStart();
//            // 步骤1中 观察者  subscriber抽象类复写的方法，用于初始化工作
//            onSubscribe.call(subscriber);
//            // 通过该调用，从而回调观察者中的对应方法从而响应被观察者生产的事件
//            // 从而实现被观察者调用了观察者的回调方法 & 由被观察者向观察者的事件传递，即观察者模式
//            // 同时也看出：Observable只是生产事件，真正的发送事件是在它被订阅的时候，即当 subscribe() 方法执行时
//        }

    }

    private void initObserbavle() {
        // 1. 创建被观察者 Observable 对象
        observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            // create() 是 RxJava 最基本的创造事件序列的方法
            // 此处传入了一个 OnSubscribe 对象参数
            // 当 Observable 被订阅时，OnSubscribe 的 call() 方法会自动被调用，即事件序列就会依照设定依次被触发
            // 即观察者会依次调用对应事件的复写方法从而响应事件
            // 从而实现被观察者调用了观察者的回调方法 & 由被观察者向观察者的事件传递，即观察者模式

            // 2. 在复写的subscribe（）里定义需要发送的事件
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                // 通过 ObservableEmitter类对象产生事件并通知观察者
                // ObservableEmitter类介绍
                // a. 定义：事件发射器
                // b. 作用：定义需要发送的事件 & 向观察者发送事件
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.tryOnError(new Throwable());
//                emitter.onComplete();
            }
        });

//        <--扩展：RxJava 提供了其他方法用于 创建被观察者对象Observable -->
// 方法1：just(T...)：直接将传入的参数依次发送出来
//                Observable observable = Observable.just("A", "B", "C");
        // 将会依次调用：
        // onNext("A");
        // onNext("B");
        // onNext("C");
        // onCompleted();

// 方法2：from(T[]) / from(Iterable<? extends T>) : 将传入的数组 / Iterable 拆分成具体对象后，依次发送出来
//        String[] words = {"A", "B", "C"};
//        Observable observable =  Observable.fromIterable(words);
        // 将会依次调用：
        // onNext("A");
        // onNext("B");
        // onNext("C");
        // onCompleted();

    }

    private void initObserver(String input, final IOnListener listener) {
//        <--方式1：采用Observer 接口 -->
        // 1. 创建观察者 （Observer ）对象
        observer = new Observer<Integer>() {
            // 2. 创建对象时通过对应复写对应事件方法 从而 响应对应事件

            // 观察者接收事件前，默认最先调用复写 onSubscribe（）
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }

            // 当被观察者生产Next事件 & 观察者接收到时，会调用该复写方法 进行响应
            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "对Next事件作出响应" + value);
              //  listener.Success(contentToString(value.toString()));
            }

            // 当被观察者生产Error事件& 观察者接收到时，会调用该复写方法 进行响应
            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "对Error事件作出响应");
                listener.Error(e.toString());
            }

            // 当被观察者生产Complete事件& 观察者接收到时，会调用该复写方法 进行响应
            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        };

//<--方式2：采用Subscriber 抽象类 -->
// 说明：Subscriber类 = RxJava 内置的一个实现了 Observer 的抽象类，对 Observer 接口进行了扩展

// 1. 创建观察者 （Observer ）对象
//        Subscriber<String> subscriber = new Subscriber<Integer>() {
//
//            // 2. 创建对象时通过对应复写对应事件方法 从而 响应对应事件
//            // 观察者接收事件前，默认最先调用复写 onSubscribe（）
//            @Override
//            public void onSubscribe(Subscription s) {
//                Log.d(TAG, "开始采用subscribe连接");
//            }
//
//            // 当被观察者生产Next事件 & 观察者接收到时，会调用该复写方法 进行响应
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, "对Next事件作出响应" + value);
//            }
//
//            // 当被观察者生产Error事件& 观察者接收到时，会调用该复写方法 进行响应
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "对Error事件作出响应");
//            }
//
//            // 当被观察者生产Complete事件& 观察者接收到时，会调用该复写方法 进行响应
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "对Complete事件作出响应");
//            }
//        };


//<--特别注意：2种方法的区别，即Subscriber 抽象类与Observer 接口的区别 -->
// 相同点：二者基本使用方式完全一致（实质上，在RxJava的 subscribe 过程中，Observer总是会先被转换成Subscriber再使用）
// 不同点：Subscriber抽象类对 Observer 接口进行了扩展，新增了两个方法：
        // 1. onStart()：在还未响应事件前调用，用于做一些初始化工作
        // 2. unsubscribe()：用于取消订阅。在该方法被调用后，观察者将不再接收 & 响应事件
        // 调用该方法前，先使用 isUnsubscribed() 判断状态，确定被观察者Observable是否还持有观察者Subscriber的引用，如果引用不能及时释放，就会出现内存泄露

    }
}
