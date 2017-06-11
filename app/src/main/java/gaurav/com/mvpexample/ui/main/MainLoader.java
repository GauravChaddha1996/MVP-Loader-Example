package gaurav.com.mvpexample.ui.main;

import android.content.Context;
import android.support.v4.content.Loader;

/**
 * Created by gaurav on 11/6/17.
 */

class MainLoader extends Loader<MainPresenter> {
    private MainPresenter presenter;

    MainLoader(Context context, MainPresenter presenter) {
        super(context);
        this.presenter = presenter;
    }

    @Override
    protected void onStartLoading() {
        deliverResult(presenter);
    }
}
