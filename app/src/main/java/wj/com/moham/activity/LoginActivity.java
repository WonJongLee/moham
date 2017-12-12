package wj.com.moham.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import wj.com.moham.R;
import wj.com.moham.common.data.Const;
import wj.com.moham.databinding.ActivityLoginBinding;
import wj.com.moham.common.model.LoginData;
import wj.com.moham.presenter.LoginContract;
import wj.com.moham.presenter.LoginPresenter;
import wj.com.moham.common.model.ui.dialog.DialogMoham;
import wj.com.moham.common.model.ui.dialog.OnAlertClickListener;
import wj.com.moham.common.model.ui.dialog.OnConfirmClickListener;
import wj.com.moham.common.util.StrUtil;

public class LoginActivity extends AppCompatActivity implements LoginContract.Ui {

    private ActivityLoginBinding    mBinding;
    private LoginPresenter          mLoginPresenter;
    private LoginData               mLoginData;
    private FirebaseAuth            mFbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        mLoginPresenter = new LoginPresenter(this, this);
        mLoginData = new LoginData();

        mBinding.setLoginPre(mLoginPresenter);
        mBinding.setLoginData(mLoginData);

        mFbAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mFbAuth.getCurrentUser();
        checkIsLogin(currentUser);
    }

    @Override
    protected void onStop() {
        super.onStop();
        closeKeyboard();
    }

    @Override
    public void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        mBinding.editIdLogin.clearFocus();
        mBinding.editPwLogin.clearFocus();
        inputMethodManager.hideSoftInputFromWindow(mBinding.editIdLogin.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(mBinding.editPwLogin.getWindowToken(), 0);
    }

    @Override
    public void goSignUp(final LoginData loginData) {
        closeKeyboard();

        if (loginData != null) {

            final DialogMoham alertDialog = new DialogMoham();
            alertDialog.setOnAlertClickListener(new OnAlertClickListener() {
                @Override
                public void onClickPositiveButton(DialogInterface dialog) {
                    doSignUp(loginData);
                    dialog.cancel();
                }

                @Override
                public void onClickNegativeButton(DialogInterface dialog) {
                    dialog.cancel();
                }
            });
            alertDialog.showAlertDialog(LoginActivity.this, getString(R.string.signup), "회원가입 하시겠습니까?");
        }

    }

    @Override
    public void goPwdLogin(LoginData loginData) {
        closeKeyboard();
        doPwdSignIn(loginData);
    }

    private void checkIsLogin(FirebaseUser user) {
        if (user != null) {
            goPlanListAct();
        } else return;
    }

    private void goPlanListAct() {
        startActivity(new Intent(LoginActivity.this, PlanActivity.class));
        finish();
    }

    private void doSignUp(LoginData loginData) {
        if (!StrUtil.isNull(loginData.getId()) && !StrUtil.isNull(loginData.getPw())) {
            String customEmailId = loginData.getId() + Const.EMAIL_FORM;
            mFbAuth.createUserWithEmailAndPassword(customEmailId, loginData.getPw())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // 회원가입 성공
                                DialogMoham dialogMoham = new DialogMoham();
                                dialogMoham.setOnConfirmClickListener(new OnConfirmClickListener() {
                                    @Override
                                    public void onClickConfirmButton(DialogInterface dialog) {
                                        goPlanListAct();
                                    }
                                });
                                dialogMoham.showConfirmDialog(LoginActivity.this, getString(R.string.signup), getString(R.string.msg_signup_success));

                            } else {
                                // 회원가입 실패
                                new DialogMoham().showNoticeDialog(LoginActivity.this, getString(R.string.signup), getString(R.string.msg_signup_fail));
                            }
                        }
                    });

        } else {
            // 아이디나 비밀번호를 입력하지 않았을 때
            new DialogMoham().showNoticeDialog(LoginActivity.this, getString(R.string.signup), getString(R.string.msg_signup_fail));

        }
    }

    private void doPwdSignIn(LoginData loginData) {
        if (!StrUtil.isNull(loginData.getId()) && !StrUtil.isNull(loginData.getPw())) {
            String customEmailId = loginData.getId() + Const.EMAIL_FORM;
            mFbAuth.signInWithEmailAndPassword(customEmailId, loginData.getPw())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // 로그인 성공
                                DialogMoham dialogMoham = new DialogMoham();
                                dialogMoham.setOnConfirmClickListener(new OnConfirmClickListener() {
                                    @Override
                                    public void onClickConfirmButton(DialogInterface dialog) {
                                        goPlanListAct();
                                    }
                                });
                                dialogMoham.showConfirmDialog(LoginActivity.this, getString(R.string.login), getString(R.string.msg_login_success));

                            } else {
                                // 로그인 실패
                                new DialogMoham().showNoticeDialog(LoginActivity.this, getString(R.string.login), getString(R.string.msg_login_fail));
                            }
                        }
                    });
        } else {
            // 아이디나 비밀번호를 입력하지 않았을 때
            new DialogMoham().showNoticeDialog(LoginActivity.this, getString(R.string.login), getString(R.string.msg_login_notice));

        }
    }
}

