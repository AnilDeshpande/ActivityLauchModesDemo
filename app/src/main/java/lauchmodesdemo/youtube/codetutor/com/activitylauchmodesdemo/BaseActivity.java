package lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by anildeshpande on 12/18/16.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    protected static ActivityManager activityManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(activityManager==null){
            activityManager=(ActivityManager)getSystemService(ACTIVITY_SERVICE);
        }

    }

    protected void startActivity(Activity activity, Class targetActivityClass){
        Intent intent=new Intent(activity,targetActivityClass);
        startActivity(intent);
    }

    protected static int getNumberOfTasks(){
        return activityManager.getAppTasks().size();
    }

    protected static String getAppTaskState(){

        StringBuilder stringBuilder=new StringBuilder();
        int totalNumberOfTasks=activityManager.getRunningTasks(10).size();
        stringBuilder.append("\nTotal Number of Tasks: "+totalNumberOfTasks+"\n");

        List<ActivityManager.RunningTaskInfo> taskInfo =activityManager.getRunningTasks(10);

        for(ActivityManager.RunningTaskInfo info:taskInfo){
            stringBuilder.append("Task "+totalNumberOfTasks--+", Number of Activities : "+info.numActivities+"\n");
            stringBuilder.append("TopActivity: "+info.topActivity.getClassName()+"\n");
            stringBuilder.append("BaseActivity:"+info.baseActivity.getClassName()+"\n");
            stringBuilder.append("\n\n");
        }

        /*List<ActivityManager.AppTask> appTasks=activityManager.getAppTasks();
        for(ActivityManager.AppTask task:appTasks){
            ActivityManager.RecentTaskInfo recentTaskInfo=task.getTaskInfo();
            stringBuilder.append("Number of Activities: "+recentTaskInfo.numActivities+"\n");
            stringBuilder.append("TopActivity: "+recentTaskInfo.topActivity.getClassName()+"\n");
            stringBuilder.append("BaseActivity:"+recentTaskInfo.baseActivity.getClassName()+"\n");
            stringBuilder.append("\n\n");
        }*/
        return stringBuilder.toString();
    }


}
