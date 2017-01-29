package com.exmple.rssfeed.viewModel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.exmple.rssfeed.BR;
import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.view.ArticleActivity;
import com.exmple.rssfeed.view.RssActivity;

import java.util.logging.Logger;

import butterknife.Bind;

/**
 * Created by Quentin on 12/01/2017.
 */

public class MainActivityViewModel extends BaseObservable {

    private String Login;
    private String Passwd;
    private String Ip = "";
    private String Port = "";

    public MainActivityViewModel() {
        SharedPreferences settings = RSSFeed.getContext().getSharedPreferences("ApiCredentials", RSSFeed.getContext().MODE_PRIVATE);
        setLogin(settings.getString("ApiLogin", ""));
        setPasswd(settings.getString("ApiPasswd", ""));
        if (!Login.isEmpty() && !Passwd.isEmpty())
            onClickSignIn(null);
    }

    @Bindable
    public String getLogin() {
        return this.Login;
    }

    public void setLogin(String login) {
        this.Login = login;
        notifyPropertyChanged(BR.login);
    }

    @Bindable
    public String getPasswd() {
        return this.Passwd;
    }

    public void setPasswd(String passwd) {
        this.Passwd = passwd;
        notifyPropertyChanged(BR.passwd);
    }

    @Bindable
    public String getIp() {return this.Ip; }

    public void setIp(String ip) {
        this.Ip = ip;
        notifyPropertyChanged(BR.ip);
    }

    @Bindable
    public String getPort() { return this.Port; }

    public void setPort(String port) {
        this.Port = port;
        notifyPropertyChanged(BR.port);
    }

    public synchronized void onClickSignIn(View view) {
        if (!Ip.isEmpty() && !Port.isEmpty())
            Data.getInstance().setAddress(Ip, Port);
        else
            Data.getInstance().setDefaultAddress();
        // Call API to Login
        SharedPreferences sharedPreferences = RSSFeed.getContext().getSharedPreferences("ApiCredentials", RSSFeed.getContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ApiLogin", getLogin());
        editor.putString("ApiPasswd", getPasswd());
        editor.commit();
        Intent i = new Intent(RSSFeed.getContext(), RssActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        RSSFeed.getContext().startActivities(new Intent[] { i });
    }
}
