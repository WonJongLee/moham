package wj.com.moham.presenter;

import wj.com.moham.common.model.LoginData;

/**
 * Created by admin on 2017. 12. 5..
 */

public interface LoginContract{

    interface Presenter extends BaseContract.Presenter{
        void onLoginBtnClickEvent(LoginData loginData);
        void onSignUpBtnClickEvent(LoginData loginData);
    }

    interface Ui extends BaseContract.Ui{
        void goSignUp(LoginData loginData);
        void goPwdLogin(LoginData loginData);
    }
}
