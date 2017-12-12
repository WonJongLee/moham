package wj.com.moham.presenter;

import android.app.Activity;

import wj.com.moham.common.model.LoginData;

/**
 * Created by admin on 2017. 12. 5..
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.Ui ui;
    private Activity ctx;

    public LoginPresenter(LoginContract.Ui ui, Activity ctx) {
        this.ui = ui;
        this.ctx = ctx;
    }

    @Override
    public void onTopLayoutClickEvent() {
        ui.closeKeyboard();
    }

    @Override
    public void onLoginBtnClickEvent(LoginData loginData) {
        ui.goPwdLogin(loginData);
    }

    @Override
    public void onSignUpBtnClickEvent(LoginData loginData) {
        ui.goSignUp(loginData);
    }
}
