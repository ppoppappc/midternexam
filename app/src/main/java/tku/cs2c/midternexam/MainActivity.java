package tku.cs2c.midternexam;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class MainActivity extends AppCompatActivity {
    String temp;
    ArrayList<SpannableString> list = new ArrayList<>();
    int size = 15,//dp
        i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txv = (TextView)findViewById(R.id.txv);
        txv.setTextSize(size);
    }

    public void bigger(View v){
        EditText ed = findViewById(R.id.ed1);
        ed.setTextSize(++size);
    }

    public void smaller(View v){
        EditText ed = findViewById(R.id.ed1);
        ed.setTextSize(--size);
    }

    public void set(View v){
        EditText ed = findViewById(R.id.ed1);
        TextView txv = (TextView)findViewById(R.id.txv);

        temp = ed.getText().toString();

        SpannableString wordtoSpan = new SpannableString(temp);
        i++;
        i %= 4;
        switch(i){
            case 0:
                wordtoSpan.setSpan((new ForegroundColorSpan(Color.BLUE)),0,temp.length(),0);
                break;
            case 1:
                wordtoSpan.setSpan((new ForegroundColorSpan(Color.GREEN)),0,temp.length(),0);
                break;
            case 2:
                wordtoSpan.setSpan((new ForegroundColorSpan(Color.RED)),0,temp.length(),0);
                break;
            case 3:
                wordtoSpan.setSpan((new ForegroundColorSpan(Color.YELLOW)),0,temp.length(),0);
                break;
        }
        wordtoSpan.setSpan(new AbsoluteSizeSpan(size,true),0,temp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        list.add(wordtoSpan);
        txv.append(wordtoSpan);
        txv.setMovementMethod(new ScrollingMovementMethod());
    }

   public void reverse(View v){
        TextView txv = (TextView)findViewById(R.id.txv);
        Collections.reverse(list);
        txv.setText("");
        for(int n = 0;n<list.size();n++){
            txv.append((SpannableString)list.get(n));
        }

        txv.setMovementMethod(new ScrollingMovementMethod());
    }

    public void clear(View v){
        EditText ed = findViewById(R.id.ed1);
        ed.setText("");
    }
}
