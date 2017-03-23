package com.example.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 向客户度啊公开接口
 * Created by nullop on 2017/3/23.
 */

public class RemoteService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("执行了onCreat()");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("执行了onBind()");
        //在onBind()返回继承自Binder的Stub类型的Binder，非常重要
        return new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("执行了onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("执行了onDestory()");
    }

//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//
//        System.out.println("执行了onBind()");
//        //在onBind()返回继承自Binder的Stub类型的Binder，非常重要
//        return mBinder;
//    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("执行了onUnbind()");
        return super.onUnbind(intent);
    }

//    IMyRemoteInterface.Stub mBinder = new IMyRemoteInterface.Stub() {
//        @Override
//        public String getName() throws RemoteException {
//            return "RemoteService";
//        }
//
//        @Override
//        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
//
//        }
//    };

}
