package com.exmple.rssfeed.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.exmple.rssfeed.BR;
import com.exmple.rssfeed.Utils.LoggerService;

/**
 * Created by Quentin on 12/01/2017.
 */

public class MainActivityViewModel extends BaseObservable {

    private String Login;
    private String Passwd;


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

    public synchronized void onClickSignIn(View view) {
        LoggerService.Log(this.getClass().getName(), "Click on sign in");
    }
}
