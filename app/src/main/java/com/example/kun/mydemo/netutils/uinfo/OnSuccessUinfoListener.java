package com.example.kun.mydemo.netutils.uinfo;

import com.example.kun.mydemo.model.TokenBean;
import com.example.kun.mydemo.model.UserInfo;

/**
 * Created by 眼神 on 2018/3/27.
 */
public interface OnSuccessUinfoListener {
    void onSuccess(UserInfo result);

    void onFault(String errorMsg);
}
