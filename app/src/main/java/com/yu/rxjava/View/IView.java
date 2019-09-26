package com.yu.rxjava.View;

import com.yu.rxjava.Bean.ChildBean;

/**
 * CREATED BY DY ON 2019/9/11.
 * TIME BY 10:09.
 **/
public interface IView {
    void init();//初始化

    void SetInfo(ChildBean.ResultsBean resultsBean);//设置信息

    void SetErr(String err);//输出错误
}
