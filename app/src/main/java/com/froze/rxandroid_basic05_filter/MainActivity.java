package com.froze.rxandroid_basic05_filter;

import rx.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    Integer dataset[] = {1,2,3,1,4,5,3,6,7,8,7,9,4,5,4,2,1};
    Button btnFilter, btnForEach, btnTake, btnFirst, btnLast, btnDistict, btnGroupBy;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFilter = (Button)findViewById(R.id.btnFilter);
        btnForEach = (Button)findViewById(R.id.btnForEach);
        btnTake = (Button)findViewById(R.id.btnTake);
        btnFirst = (Button)findViewById(R.id.btnFirst);
        btnLast = (Button)findViewById(R.id.btnLast);
        btnDistict = (Button)findViewById(R.id.btnDistict);
        btnGroupBy = (Button)findViewById(R.id.btnGroupBy);
        tv=(TextView)findViewById(R.id.textView);

        btnFilter.setOnClickListener(this);
        btnForEach.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        btnFirst.setOnClickListener(this);
        btnLast.setOnClickListener(this);
        btnDistict.setOnClickListener(this);
        btnGroupBy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnFilter :
                filter();
                break;
            case R.id.btnForEach :
                foreach();
                break;
            case R.id.btnTake :
                take(3);
                break;
            case R.id.btnFirst :
                first();
                break;
            case R.id.btnLast :
                last();
                break;
            case R.id.btnDistict :
                distinct();
                break;
            case R.id.btnGroupBy :
                groupby();
                break;

        }
    }

    public void filter(){
        Observable.from(dataset)
                .filter(item -> item%2 == 0 )
                .subscribe(result -> Log.i(TAG, result+"")
                );
    }

    public void take(int takecount){
        Observable.from(dataset)
                .take(takecount)
                .subscribe(result -> Log.i(TAG, result+"")
                );
    }

    public void foreach(){
        Observable.from(dataset)
                .forEach(result -> Log.i(TAG, result+"")
                );
    }

    public void distinct(){
        Observable.from(dataset)
                .distinct()     //유일한 값만 리턴
                .subscribe(result -> Log.i(TAG, result+"")
                );
    }

    public void first(){
        Observable.from(dataset)
                .first()     //첫번째 값 리턴
                .subscribe(result -> Log.i(TAG, result+"")
                );
    }

    public void last(){
        Observable.from(dataset)
                .last()     //마지막 값 리턴
                .subscribe(result -> Log.i(TAG, result+"")
                );
    }

    public void groupby(){
        Observable.from(dataset)
                .groupBy(item -> item%2 == 0)     //첫번째 값 리턴
                .subscribe(grouped -> grouped.toList().subscribe(result -> Log.i(TAG, result+""+" Even:"+grouped.getKey()))
                );
    }

}
