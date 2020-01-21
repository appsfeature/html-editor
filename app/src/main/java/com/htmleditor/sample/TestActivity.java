package com.htmleditor.sample;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.htmleditor.HtmlTextEditor;

public class TestActivity extends AppCompatActivity {

    private HtmlTextEditor htmlTextEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setupToolBar();
        htmlTextEditor = (HtmlTextEditor) findViewById(R.id.summernote);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test, menu);//Second es your new xml.
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.get_text:
                Toast.makeText(this, htmlTextEditor.getText(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.set_text:
                htmlTextEditor.setText("<h2>Hello World ' \"</h2>");
                break;
        }
        return true;
    }


    private void setupToolBar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(getString(R.string.app_name));
        }
    }
}