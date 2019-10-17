package com.gail.wenzhi.view;

import com.gail.wenzhi.base.BaseView;
import com.gail.wenzhi.bean.TopRootInfo;

public interface HomeView extends BaseView {

    void showSuccessData(TopRootInfo date);

    void showErrorData(String s);


}
