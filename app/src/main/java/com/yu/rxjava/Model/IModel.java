package com.yu.rxjava.Model;

import android.content.Context;

import com.yu.rxjava.Presenter.IOnListener;

/**
 * CREATED BY DY ON 2019/9/11.
 * TIME BY 10:32.
 **/
public interface IModel {
    void HandleData(String input, Context context, IOnListener listener);
    void LoadChild(String tag,String count, String page,IOnListener listener);
    String contentToString(String content);

}
