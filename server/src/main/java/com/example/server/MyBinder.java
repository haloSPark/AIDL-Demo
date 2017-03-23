package com.example.server;

import android.os.Process;
import android.os.RemoteException;

/**
 * 实现aidl重的抽象类Stub
 * Created by nullop on 2017/3/23.
 */

public class MyBinder extends IMyRemoteInterface.Stub {


    @Override
    public int getPid() throws RemoteException {
        return Process.myPid();
    }

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }
}
