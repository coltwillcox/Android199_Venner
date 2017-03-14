package com.koltinjo.venner.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.koltinjo.venner.R;
import com.koltinjo.venner.createaccount.ActivityCreateAccount;
import com.koltinjo.venner.data.auth.AuthInjection;
import com.koltinjo.venner.profilepage.ActivityProfilePage;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment implements ContractLogin.View {

    // Views.
    private Button buttonLogin, buttonCreateAccount;
    private TextView textViewEmail, textViewPassword;
    private EditText editTextEmail, editTextPassword;
    //private ProgressBar progressBar;
    private RelativeLayout relativeLayout;

    private ContractLogin.Presenter presenter;

    // Constructor.
    public FragmentLogin() {

    }

    @Override
    public void setPresenter(ContractLogin.Presenter presenter) {
        this.presenter = presenter;
    }

    public static FragmentLogin newInstance() {
        return new FragmentLogin();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        if (presenter == null) {
            presenter = new PresenterLogin(
                    AuthInjection.provideAuthSource(),
                    this,
                    SchedulerInjection.provideSchedulerProvider());
//        }
        presenter.subscribe();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        relativeLayout = (RelativeLayout) root.findViewById(R.id.fragmentlogin_relativelayout);

        editTextEmail = (EditText) root.findViewById(R.id.fragmentlogin_edittext_email);
        editTextPassword = (EditText) root.findViewById(R.id.fragmentlogin_edittext_password);
        textViewEmail = (TextView) root.findViewById(R.id.fragmentlogin_textview_email);
        textViewPassword = (TextView) root.findViewById(R.id.fragmentlogin_textview_password);
        buttonLogin = (Button) root.findViewById(R.id.fragmentlogin_button_login);
        buttonCreateAccount = (Button) root.findViewById(R.id.fragmentlogin_button_createaccount);

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCreateClick();
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLogInClick();
            }
        });
        setUpListeners();
        editTextEmail.requestFocus();

        return root;
    }

    @Override
    public void showProgressIndicator(boolean show) {
        if (show) {
            //progressBar.setVisibility(View.VISIBLE);
            //relativeLayout.setVisibility(View.INVISIBLE);
        } else {
            //progressBar.setVisibility(View.INVISIBLE);
            //relativeLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void makeToast(@StringRes int id) {
        Toast.makeText(getActivity().getApplicationContext(), getString(id), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getEmail() {
        return editTextEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return editTextPassword.getText().toString();
    }

    @Override
    public void startActivityProfile() {
        presenter.unsubscribe();
        Intent i = new Intent(getActivity(), ActivityProfilePage.class);
        startActivity(i);
    }

    @Override
    public void startActivityCreateAccount() {
        presenter.unsubscribe();
        Intent i = new Intent(getActivity(), ActivityCreateAccount.class);
        startActivity(i);
    }

    /**
     * Sets Listeners to manage highlight colors for Inputs/Labels, based on hasFocus
     */
    public void setUpListeners() {
        editTextEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View label, boolean hasFocus) {
                if (hasFocus) {
                    textViewEmail.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.colorAccent));
                } else {
                    textViewEmail.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), android.R.color.white));
                }
            }
        });
        editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View label, boolean hasFocus) {
                if (hasFocus) {
                    textViewPassword.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.colorAccent));
                } else {
                    textViewPassword.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), android.R.color.white));
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        presenter.unsubscribe();
        super.onDestroy();
    }

}