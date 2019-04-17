package com.codeeff.networkconnection;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.util.Log;

public class App extends Application implements ConnectionReceiver.ConnectionReceiverListener {
    private final BroadcastReceiver mybroadcast = new ConnectionReceiver();

    @Override
    public void onCreate() {
        super.onCreate();
        this.setConnectionListener(this);
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.registerReceiver(mybroadcast, intentFilter);
    }

    public void setConnectionListener(ConnectionReceiver.ConnectionReceiverListener listener) {
        ConnectionReceiver.connectionReceiverListener = listener;
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        Log.d("Status Changed", "Connection isL" + isConnected);
    }
}