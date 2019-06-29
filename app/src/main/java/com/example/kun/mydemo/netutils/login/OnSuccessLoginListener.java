package com.example.kun.mydemo.netutils.login;

import com.example.kun.mydemo.model.TokenBean;

/**
 * Created by 眼神 on 2018/3/27.
 */
public interface OnSuccessLoginListener {
    void onSuccess(TokenBean result);

    void onFault(String errorMsg);
}
