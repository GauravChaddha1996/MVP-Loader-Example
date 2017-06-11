package gaurav.com.mvpexample.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import gaurav.com.mvpexample.R;
import gaurav.com.mvpexample.managers.DataManager;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    private EditText editName;
    private TextView textName;
    private Button buttonSubmit;
    private Button buttonClear;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MVP-Loader Example");
        presenter = new MainPresenter(new DataManager(this));
    }

    /*
     * Lifecycle events override
     * */
    @Override
    protected void onStart() {
        super.onStart();
        /*
        instantiates views and sets on click on them.
        */
        initView();
    }

    @Override
    protected void onPause() {
        // Detach the view as UI isn't going to be visible
        presenter.detachView();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Attach the view interface as we want UI updated again.
        presenter.attachView(this);
    }

    /*
    * View related functions to init Views and updateUI
    * */

    private void initView() {
        // I'm not using ButterKnife here to keep focus on MVP and Loader API but please do use it.
        editName = (EditText) findViewById(R.id.edit_name);
        textName = (TextView) findViewById(R.id.text_name);
        buttonSubmit = (Button) findViewById(R.id.button_submit);
        buttonClear = (Button) findViewById(R.id.button_clear);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.submitName(editName.getText().toString());
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clearName();
            }
        });
    }

    @Override
    public void updateUI(MainState state) {
        switch (state.getCommand()) {
            case MainState.MainViewCommand.CLEAR_NAME:
                editName.setText("");
                textName.setText(R.string.template_name);
                break;
            case MainState.MainViewCommand.SHOW_ERROR_TOAST:
                Toast.makeText(this, "Please enter a non-empty name", Toast.LENGTH_SHORT).show();
                break;
            case MainState.MainViewCommand.SHOW_NAME:
                editName.setText("");
                textName.setText(state.getName());
                break;
        }
    }
}
