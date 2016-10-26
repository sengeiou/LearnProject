package com.cocoa.mixpaneltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.ResourceReader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    MixpanelAPI mixpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String projectToken = "da7a79f72b454fc33eb33b1458d39194"; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"
        mixpanel = MixpanelAPI.getInstance(this, projectToken);


        View view = this.getWindow().getDecorView().getRootView();


        List<View> allchildren = getAllChildViews(view);


        ResourceReader.Ids aa =
                new ResourceReader.Ids("com.cocoa.mixpaneltest", this);


        Button button = (Button) findViewById(R.id.xxxxxxxxxxx);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
////                try {
////                    JSONObject props = new JSONObject();
////                    props.put("Gender", "Female");
////                    props.put("Logged in", false);
////                    mixpanel.track("MainActivity - onCreate called", props);
////                } catch (JSONException e) {
////                    Log.e("MYAPP", "Unable to add properties to JSONObject", e);
////                }
//                mixpanel.flush();
//                startActivity(new Intent(MainActivity.this, H.class));

                Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_LONG).show();

            }
        });
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Toast.makeText(MainActivity.this, "onTouch", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });

    }

    private List<View> getAllChildViews(View view) {
        List<View> allchildren = new ArrayList<View>();
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                allchildren.add(viewchild);
                allchildren.addAll(getAllChildViews(viewchild));
            }

        }

        return allchildren;
    }


}
