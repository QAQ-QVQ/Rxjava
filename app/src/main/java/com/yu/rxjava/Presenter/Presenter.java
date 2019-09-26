package com.yu.rxjava.Presenter;

import android.content.Context;

import com.yu.rxjava.Bean.ChildBean;
import com.yu.rxjava.Model.Model;
import com.yu.rxjava.View.IView;

/**
 * CREATED BY DY ON 2019/9/11.
 * TIME BY 10:19.
 **/
public class Presenter implements IPresenter, IOnListener {
    private IView iView;
    private Model model;

    // private IView iView;
    public Presenter(IView iView) {
        this.iView = iView;
        model = new Model();
    }

    @Override
    public void InputToModel(String input, Context context) {
        model.HandleData(input, context, this);
    }

    @Override
    public void LoadToModel(String tag,String count, String page, Context context) {
        model.LoadChild(tag,count,page,this);
    }

    @Override
    public void Success(ChildBean.ResultsBean resultsBean) {
        iView.SetInfo(resultsBean);
    }

    @Override
    public void Error(String err) {
        iView.SetErr(err);
    }
}
