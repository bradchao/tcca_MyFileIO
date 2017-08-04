package tw.brad.android.games.myfileio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);

        sp = getSharedPreferences("mydata", MODE_PRIVATE);
        editor = sp.edit();

    }

    public void test1(View view){
        editor.putString("username", "brad");
        editor.putBoolean("sound", true);
        editor.putInt("stage", 7);
        editor.commit();
        Toast.makeText(this, "Save OK", Toast.LENGTH_SHORT).show();
    }
    public void test2(View view){

    }
    public void test3(View view){

    }
    public void test4(View view){

    }
    public void test5(View view){

    }

}
