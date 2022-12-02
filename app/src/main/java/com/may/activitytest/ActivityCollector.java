package com.may.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * DES:
 * <p>
 * Date: 2022/11/7  21:15
 *
 * @author Jason
 */
public class ActivityCollector {
    public static List<Activity> activities=new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity : activities) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }

}
