package ir.androidlife.countappstarts;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // گرفتن مقدار قبلی
        int currentAppState = getDataInt("appStarts", 0);
        // افزایش دادن مقدار پس از هر اجرا
        currentAppState++;
        // ذخیره مقدار جدید
        saveDataInt("appStarts", currentAppState);
        // نمایش تعداد دفعات اجرا
        textView.setText(" تعداد دفعات اجرا: " + currentAppState);
    }

    private void saveDataInt(String key, int data) {
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, data);
        editor.apply();
    }

    private int getDataInt(String key, int defValue) {
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        return preferences.getInt(key, defValue);
    }
}
