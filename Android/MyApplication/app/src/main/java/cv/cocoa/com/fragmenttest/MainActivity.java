package cv.cocoa.com.fragmenttest;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FrameLayout content;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private  Frament1 f1 =new Frament1();
    private  Frament2 f2 =new Frament2();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        content = (FrameLayout) findViewById(R.id.content);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.replace).setOnClickListener(this);
        mFragmentManager =  getSupportFragmentManager();




    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                mFragmentTransaction =mFragmentManager.beginTransaction();
                mFragmentTransaction.add(R.id.content,f1,"F1");
                mFragmentTransaction.add(R.id.content,f2,"F2");
                mFragmentTransaction.commit();

                break;
            case R.id.replace:

                if(f1.isVisible()){
                    mFragmentTransaction =mFragmentManager.beginTransaction();
                    mFragmentTransaction.hide(f1);
                    mFragmentTransaction.show(f2);
                    mFragmentTransaction.commit();
                }else{
                    mFragmentTransaction =mFragmentManager.beginTransaction();
                    mFragmentTransaction.hide(f2);
                    mFragmentTransaction.show(f1);
                    mFragmentTransaction.commit();
                }

                break;
        }
    }
}


