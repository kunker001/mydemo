package com.example.kun.mydemo.netutils.repairman;

import com.example.kun.mydemo.model.RepairManInfo;
import com.example.kun.mydemo.model.TokenBean;

/**
 * Created by 眼神 on 2018/3/27.
 */
public interface OnSuccessRepairManListener {
    void onSuccess(RepairManInfo result);

    void onFault(String errorMsg);
}
