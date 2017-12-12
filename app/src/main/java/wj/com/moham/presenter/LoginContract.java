package wj.com.moham.presenter;

import wj.com.moham.common.model.LoginData;

/**
 * Created by admin on 2017. 12. 5..
 */

public interface LoginContract {
    interface Presenter {
        void onTopLayoutClickEvent();
        void onLoginBtnClickEvent(LoginData loginData);
        void onSignUpBtnClickEvent(LoginData loginData);
    }

    interface Ui {
        void closeKeyboard();
        void goSignUp(LoginData loginData);
        void goPwdLogin(LoginData loginData);
    }
}
