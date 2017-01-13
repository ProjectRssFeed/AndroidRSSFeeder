package com.exmple.rssfeed.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.exmple.rssfeed.viewModel.MainActivityViewModel;
import com.exmple.rssfeed.R;
import com.exmple.rssfeed.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityViewModel MaVm = new MainActivityViewModel();
        bind.setHandlers(MaVm);
        bind.setViewmodel(MaVm);
    }
}
