package com.amr.core.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import javax.inject.Inject;

public class PhoneUtil {
    TelephonyManager telephonyManager;

    @Inject
    public PhoneUtil(Context context) {
        telephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
    }

    @SuppressLint("MissingPermission")
    public String getIME() {
        return telephonyManager.getDeviceId();
    }

    @SuppressLint("MissingPermission")
    public String getSerialSIMCard() {
        String getSimSerialNumber = telephonyManager.getSimSerialNumber();
        return getSimSerialNumber;
    }
}
