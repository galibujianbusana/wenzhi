package com.gail.wenzhi.callback;

import com.gail.wenzhi.base.BaseCallback;
import com.gail.wenzhi.bean.WeatherInfo;

public interface WeatherCallBack  extends BaseCallback {

    void showSuccess(WeatherInfo data);

    void shoError(String s);
}
