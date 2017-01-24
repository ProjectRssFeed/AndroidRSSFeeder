package com.exmple.rssfeed.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.databinding.ActivityAddRssBinding;
import com.exmple.rssfeed.databinding.ActivityMainBinding;
import com.exmple.rssfeed.viewModel.AddRssActivityViewModel;
import com.exmple.rssfeed.viewModel.MainActivityViewModel;

public class AddRssActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddRssBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_add_rss);
        AddRssActivityViewModel arvm = new AddRssActivityViewModel(this);
        bind.setHandlers(arvm);
        bind.setViewmodel(arvm);
    }
}
