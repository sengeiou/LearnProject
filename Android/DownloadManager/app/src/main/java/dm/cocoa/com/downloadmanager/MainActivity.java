package dm.cocoa.com.downloadmanager;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.utils.L;

import java.io.File;

import dm.cocoa.com.downloadmanager.update.UpdateFragment;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://120.55.185.35:8080/old.apk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String  name =  VersionUtil.getVersionName(this);
        int  code =  VersionUtil.getVersionCode(this);
        Log.e("--",name+"---------"+code);
        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateFragment updateFragment = new UpdateFragment();
                updateFragment.show(getSupportFragmentManager(),"UpdateFragment");



            }
        });




    }
}
