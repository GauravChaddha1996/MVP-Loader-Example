package gaurav.com.mvpexample.ui.main;

import gaurav.com.mvpexample.managers.DataManager;

/**
 * Created by gaurav on 11/6/17.
 */

class MainPresenter {
    private MainViewInterface viewInterface;
    private DataManager dataManager;
    private MainState state;

    MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
        // initiate state with a default value for the initial UI of this view.
        state = new MainState("This is the template name");
    }

    /**
     * Called when the UI became visible in onResume, thus we save the interface object and
     * update the UI with the cached state
     */
    void attachView(MainViewInterface viewInterface) {
        this.viewInterface = viewInterface;
        viewInterface.updateUI(state);
    }

    /**
     * Called when the UI became invisible, thus we set the interface object to null
     * as we can't dispatch more UI updates but we keep our state object up to date
     * with the model changes and will update the UI when it attaches again.
     */
    void detachView() {
        this.viewInterface = null;
    }


    /*
    * Logic functions
    * */

    void submitName(String name) {
        // Logic for checking that the name being saved isn't empty.
        if (name.trim().equals("")) {
            state.setCommand(MainState.MainViewCommand.SHOW_ERROR_TOAST);
            viewInterface.updateUI(state);
            return;
        }
        // Save the name in the model with DataManager acting as an interface.
        dataManager.saveName(name);
        /*
        Update the UI according to the response from model.
        None in this case.
        */
        state.setCommand(MainState.MainViewCommand.SHOW_NAME);
        state.setName(name);
        viewInterface.updateUI(state);
    }

    void clearName() {
        // Clear the name in the model with DataManager acting as an interface.
        dataManager.saveName(null);
        /*
        Update the UI according to the response from model.
        None in this case.
        */
        state.setCommand(MainState.MainViewCommand.CLEAR_NAME);
        viewInterface.updateUI(state);
    }
}
