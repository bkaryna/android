package uni.projekt3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends LifeCycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void openA3(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }
}
