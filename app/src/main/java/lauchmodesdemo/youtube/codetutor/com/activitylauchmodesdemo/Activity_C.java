package lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity_C extends BaseActivity {

    private static final String TAG=Activity_C.class.getSimpleName();

    private Button buttonStartActivityA,buttonStartActivityB,buttonStartActivityC,buttonStartActivityD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        buttonStartActivityA=(Button)findViewById(R.id.buttonStartActivityA);
        buttonStartActivityB=(Button)findViewById(R.id.buttonStartActivityB);
        buttonStartActivityC=(Button)findViewById(R.id.buttonStartActivityC);
        buttonStartActivityD=(Button)findViewById(R.id.buttonStartActivityD);

        buttonStartActivityA.setOnClickListener(this);
        buttonStartActivityB.setOnClickListener(this);
        buttonStartActivityC.setOnClickListener(this);
        buttonStartActivityD.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonStartActivityA: startActivity(this,Activity_A.class);break;
            case R.id.buttonStartActivityB: startActivity(this,Activity_B.class);break;
            case R.id.buttonStartActivityC: startActivity(this,Activity_C.class);break;
            case R.id.buttonStartActivityD: startActivity(this,Activity_D.class);break;
            default:break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getAppTaskState());
    }
}
