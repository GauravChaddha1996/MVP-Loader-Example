package gaurav.com.mvpexample.managers;

import android.content.Context;


/**
 * Created by gaurav on 11/6/17.
 */

/**
 * Data manager is the class which acts as the interface for every presenter to interact with the
 * model. It also delegates the tasks to other managers, for example: network requests for model
 * are delegated to NetworkManager, SharedPreference changes to SharedPreferencesHelper etc.
 */
public class DataManager {
    private final Context context;
    private SharedPreferencesHelper sharedPreferencesHelper;

    public DataManager(Context context) {
        this.context = context;
        // Create your delegation managers here like NetworkManager, SharedPreferencesHelper etc.
        sharedPreferencesHelper = new SharedPreferencesHelper();
    }

    /**
     * Change the name in the appropriate model. It can be shared preferences, or SQL db or
     * Realm db or making a network call (Dispatched via Network Manager) to save the name
     * in server. Here I'm using a shared preference as an example.
     *
     * @param name The name to save in the model.
     */
    public void saveName(String name) {
        sharedPreferencesHelper.saveName(context, name);
    }
}
