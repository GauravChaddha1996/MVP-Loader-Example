package gaurav.com.mvpexample.ui.main;

/**
 * Created by gaurav on 11/6/17.
 */

class MainState {
    // Indicates the command that can be send to the UI.
    private int command = -1;
    // This holds the actual data to be displayed on the UI.
    private String name = null;

    MainState(String name) {
        this.name = name;
    }

    /*
     * Getters and Setters
     * */

    int getCommand() {
        return command;
    }

    void setCommand(int command) {
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Commands that can be sent to Main View
     * */
    class MainViewCommand {
        static final int CLEAR_NAME = 0;
        static final int SHOW_NAME = 1;
        static final int SHOW_ERROR_TOAST = 2;
    }
}
