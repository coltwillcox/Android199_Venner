package com.koltinjo.venner;

import com.koltinjo.venner.data.auth.AuthInjection;
import com.koltinjo.venner.data.auth.AuthSource;
import com.koltinjo.venner.login.ContractLogin;
import com.koltinjo.venner.login.PresenterLogin;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by colt on 05.03.17.
 */

@RunWith(MockitoJUnitRunner.class)
public class PresenterLoginTest {

    @Mock
    private ContractLogin.View view;

    private PresenterLogin presenter;
    private AuthSource authSource;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        authSource = AuthInjection.provideAuthSource();
        presenter = new PresenterLogin(authSource, view, SchedulerInjection.provideSchedulerProvider());
    }

    @Test
    public void whenUserLoginAttemptSucceeds() throws Exception {
        presenter.onLogInClick();
        Mockito.verify(view).startActivityProfile();
    }

    @Test
    public void whenUserLoginAttempFails() throws Exception {
        Mockito.verify(view).makeToast(Mockito.anyString());
    }

    @Test
    public void whenUserClicksCreateAccount() throws Exception {
        Mockito.verify(view).startActivityCreateAccount();
    }

    @Test
    public void whenActiveUserFound() throws Exception {
        Mockito.verify(view).startActivityProfile();
    }

    @Test
    public void whenEmailEmpty() throws Exception {
        Mockito.when(view.getEmail()).thenReturn("");
        Mockito.when(view.getPassword()).thenReturn("123456");
        Mockito.verify(view).makeToast(Mockito.anyString());
    }

    @Test
    public void whenEmailInvalid() throws Exception {
        Mockito.when(view.getEmail()).thenReturn("testemail");
        Mockito.when(view.getPassword()).thenReturn("derp");
        Mockito.verify(view).makeToast(Mockito.anyString());
    }

    @Test
    public void whenPasswordEmpty() throws Exception {
        Mockito.when(view.getEmail()).thenReturn("derp@example.com");
        Mockito.when(view.getPassword()).thenReturn("");
        Mockito.verify(view).makeToast(Mockito.anyString());
    }

    @Test
    public void whenPasswordTooLong() throws Exception {
        Mockito.when(view.getEmail()).thenReturn("derp@example.com");
        Mockito.when(view.getPassword()).thenReturn("12345678901234567890");
        Mockito.verify(view).makeToast(Mockito.anyString());
    }

}