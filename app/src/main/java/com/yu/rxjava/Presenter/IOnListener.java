package com.yu.rxjava.Presenter;

import com.yu.rxjava.Bean.ChildBean;

/**
 * CREATED BY DY ON 2019/9/11.
 * TIME BY 10:23.
 **/
public interface IOnListener {
    void Success(ChildBean.ResultsBean resultsBean);

    void Error(String err);
}
