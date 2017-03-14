package com.koltinjo.venner.createaccount;

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
import com.koltinjo.venner.data.auth.AuthInjection;
import com.koltinjo.venner.login.ActivityLogin;
import com.koltinjo.venner.profilepage.ActivityProfilePage;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCreateAccount extends Fragment implements ContractCreateAccount.View {

    // Views.
    private Button buttonCreateAccount;
    private TextView textViewName;
    private TextView textViewEmail;
    private TextView textViewPassword;
    private TextView textViewPasswordConfirm;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;
    // private ProgressBar progressBar;
    private RelativeLayout relativeLayout;

    private ContractCreateAccount.Presenter presenter;

    // Constructor.
    public FragmentCreateAccount() {

    }

    @Override
    public void setPresenter(ContractCreateAccount.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter == null) {
            presenter = new PresenterCreateAccount(
                    AuthInjection.provideAuthSource(),
                    DatabaseInjection.provideDatabaseSource(),
                    this,
                    SchedulerInjection.provideSchedulerProvider()
            );
        }
        presenter.subscribe();
    }

    public static FragmentCreateAccount newInstance() {
        return new FragmentCreateAccount();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_create_account, container, false);

        //progressBar = (ProgressBar) v.findViewById(R.id.pro_create_account_loading);

        relativeLayout = (RelativeLayout) root.findViewById(R.id.fragmentcreateaccount_relativelayout);

        editTextName = (EditText) root.findViewById(R.id.fragmentcreateaccount_edittext_name);
        editTextEmail = (EditText) root.findViewById(R.id.fragmentcreateaccount_edittext_email);
        editTextPassword = (EditText) root.findViewById(R.id.fragmentcreateaccount_edittext_password);
        editTextPasswordConfirm = (EditText) root.findViewById(R.id.fragmentcreateaccount_edittext_confirm);

        textViewName = (TextView) root.findViewById(R.id.fragmentcreateaccount_textview_name);
        textViewEmail = (TextView) root.findViewById(R.id.fragmentcreateaccount_textview_email);
        textViewPassword = (TextView) root.findViewById(R.id.fragmentcreateaccount_textview_password);
        textViewPasswordConfirm = (TextView) root.findViewById(R.id.fragmentcreateaccount_textview_confirm);

        buttonCreateAccount = (Button) root.findViewById(R.id.fragmentcreateaccount_button_createaccount);

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCreateAccountClick();
            }
        });

        setUpListeners();
        editTextEmail.requestFocus();

        return root;
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
    public String getPasswordConfirmation() {
        return editTextPasswordConfirm.getText().toString();
    }

    @Override
    public String getName() {
        return editTextName.getText().toString();
    }

    @Override
    public void startActivityLogin() {
        Intent i = new Intent(getActivity(), ActivityLogin.class);
        startActivity(i);
    }

    @Override
    public void startActivityProfilePage() {
        Intent i = new Intent(getActivity(), ActivityProfilePage.class);
        startActivity(i);
    }

    @Override
    public void showProgressIndicator(boolean show) {
        if (show) {
            //   progressBar.setVisibility(View.VISIBLE);
            //   relativeLayout.setVisibility(View.INVISIBLE);
        } else {
            //   progressBar.setVisibility(View.INVISIBLE);
            //   relativeLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroy() {
        presenter.unsubscribe();
        super.onDestroy();
    }


    // Sets Listeners to manage highlight colors for Inputs/Labels, based on hasFocus.
    public void setUpListeners() {
        editTextName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View label, boolean hasFocus) {
                if (hasFocus) {
                    textViewName.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.colorAccent));
                } else {
                    textViewName.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), android.R.color.white));
                }
            }
        });
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
        editTextPasswordConfirm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View label, boolean hasFocus) {
                if (hasFocus) {
                    textViewPasswordConfirm.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.colorAccent));
                } else {
                    textViewPasswordConfirm.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), android.R.color.white));
                }
            }
        });
    }

}