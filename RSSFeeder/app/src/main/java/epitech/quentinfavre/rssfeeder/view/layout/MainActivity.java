package epitech.quentinfavre.rssfeeder.view.layout;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import epitech.quentinfavre.rssfeeder.R;
import epitech.quentinfavre.rssfeeder.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityMainBinding bind =  DataBindingUtil.setContentView(this, R.layout.activity_main);
//        bind.setUser(new MainActivityViewModel());
    }
}
