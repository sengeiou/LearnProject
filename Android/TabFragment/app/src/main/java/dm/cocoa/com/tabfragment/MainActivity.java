package dm.cocoa.com.tabfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost) findViewById(R.id.f_tab);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.f_content);

        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
                CountingFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("Contacts"),
                CountingFragment2.class, null);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(MainActivity.this,tabId,Toast.LENGTH_SHORT).show();

            }
        });


//        mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator("Custom"),
//                LoaderCustomSupport.AppListFragment.class, null);
//        mTabHost.addTab(mTabHost.newTabSpec("throttle").setIndicator("Throttle"),
//                LoaderThrottleSupport.ThrottledLoaderListFragment.class, null);


    }
}
