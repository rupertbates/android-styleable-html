package com.example.StyledHtmlTextView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView txt = (TextView) findViewById(R.id.text);
        String html = "The brainchild of Neutral Milk Hotel member Julian Koster, " +
                "the Music Tapes recorded an album in the late 90s called <blockquote>The First Imaginary Symphony For Nomad</blockquote>. " +
                "Jeff Mangum is one of the many performers who makes an appearance.";
        txt.setText(StyledHtml.fromHtml(this, html));
    }
}
