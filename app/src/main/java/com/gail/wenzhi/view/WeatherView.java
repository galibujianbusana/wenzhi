package com.gail.wenzhi.view;

import com.gail.wenzhi.base.BaseView;
import com.gail.wenzhi.bean.WeatherInfo;

public interface WeatherView  extends BaseView {

    void showSuccessData(WeatherInfo date);

    void showErrorData(String s);


}
