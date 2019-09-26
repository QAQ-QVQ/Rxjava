package com.yu.rxjava.utils.log;

/**
 * Created by Riven_rabbit on 2019/4/25
 *
 * @author Lemon酱
 */
public interface LogAdapter {
    boolean isLoggable(int priority, String tag);

    void log(int priority, String tag, String message);
}
