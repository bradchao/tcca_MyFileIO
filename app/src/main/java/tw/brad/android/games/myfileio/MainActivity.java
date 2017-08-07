package tw.brad.android.games.myfileio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
        boolean isSound = sp.getBoolean("sound", false);
        String username = sp.getString("username","guest");
        int stage = sp.getInt("stage", 0);
        int temp = sp.getInt("temp", 100);
        tv.setText("User Name:" + username + "\n" +
            "Stage: " + stage + "\n" +
            "Sound: " + (isSound?"On":"Off") + "\n" +
            "Temp: " + temp);

    }
    public void test3(View view){
        try(FileOutputStream fout = openFileOutput("brad.txt", MODE_PRIVATE)) {
            fout.write("電腦公會\n".getBytes());
            fout.write("Brad2\n".getBytes());
            fout.write("Brad3\n".getBytes());
            fout.write("Brad4\n".getBytes());
            Toast.makeText(this, "Save OK", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.i("brad", e.toString());
        }
    }
    public void test4(View view){
        try {
            FileInputStream fin = openFileInput("brad.txt");
            byte[] buf = new byte[4096];
            int len = fin.read(buf);
            String data = new String(buf,0,len);
            fin.close();
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void test5(View view){

    }

}
