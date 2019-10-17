package com.gail.wenzhi.callback;

import com.gail.wenzhi.base.BaseCallback;
import com.gail.wenzhi.bean.TopRootInfo;

public interface HomeCallBack  extends BaseCallback {

    void showSuccess(TopRootInfo data);

    void shoError(String s);
}
