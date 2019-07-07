package com.example.kun.mydemo.netutils.imageshow;

import com.example.kun.mydemo.model.ImageResultBean;

/**
 * Created by 眼神 on 2018/3/27.
 */
public interface OnSuccessImageShowListener {
    void onSuccess(ImageResultBean result);

    void onFault(String errorMsg);
}
