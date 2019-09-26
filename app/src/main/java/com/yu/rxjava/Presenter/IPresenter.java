package com.yu.rxjava.Presenter;

import android.content.Context;

/**
 * CREATED BY DY ON 2019/9/11.
 * TIME BY 10:17.
 **/
public interface IPresenter {
    void InputToModel(String input, Context context);//将view层传递到model层
    void LoadToModel(String tag,String count, String page, Context context);//将view层传递到model层
}
