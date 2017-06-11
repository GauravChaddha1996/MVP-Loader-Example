package gaurav.com.mvpexample.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by gaurav on 11/6/17.
 */

/**
 * SharedPreferencesHelper to help save data in shared preferences.
 */
class SharedPreferencesHelper {

    /**
     * Saves the name in 'myPrefs' shared preference
     */
    void saveName(Context context, String name) {
        SharedPreferences.Editor editor = context.
                getSharedPreferences("myPrefs", Context.MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.apply();
    }
}
