package com.example.kun.mydemo.netutils.datalist;

import com.example.kun.mydemo.model.ContentBean;

import com.example.kun.mydemo.model.ResultContent;
import com.example.kun.mydemo.model.TokenBean;

import java.util.List;

/**
 * Created by 眼神 on 2018/3/27.
 */
public interface OnSuccessDataListListener {
    void onSuccess(ResultContent result);

    void onFault(String errorMsg);
}
