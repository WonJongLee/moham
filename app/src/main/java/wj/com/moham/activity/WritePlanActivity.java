package wj.com.moham.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import wj.com.moham.R;
import wj.com.moham.common.data.Const;
import wj.com.moham.common.model.RoomData;
import wj.com.moham.common.ui.dialog.DialogMoham;
import wj.com.moham.common.ui.dialog.OnAlertClickListener;
import wj.com.moham.databinding.ActivityWritePlanBinding;
import wj.com.moham.presenter.WritePlanContract;
import wj.com.moham.presenter.WritePlanPresenter;

public class WritePlanActivity extends AppCompatActivity implements WritePlanContract.Ui {
    private ActivityWritePlanBinding mBinding;
    private WritePlanPresenter       mPresenter;
    private RoomData                 mRData;
    private GestureDetector          mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_write_plan);

        mPresenter = new WritePlanPresenter(this, this);
        mRData = new RoomData();

        mBinding.setWpPre(mPresenter);
        mBinding.setRData(mRData);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        DialogMoham alertDialog = new DialogMoham();
        alertDialog.setOnAlertClickListener(new OnAlertClickListener() {
            @Override
            public void onClickPositiveButton(DialogInterface dialog) {
                goPlanAct();
                dialog.cancel();
            }

            @Override
            public void onClickNegativeButton(DialogInterface dialog) {
                dialog.cancel();
            }
        });
        alertDialog.showAlertDialog(WritePlanActivity.this, getString(R.string.alert) ,getString(R.string.msg_write_plan_finish));
    }

    private void goPlanAct() {
        startActivity(new Intent(WritePlanActivity.this, PlanActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        finish();
    }

    @Override
    public void makeRoom(RoomData rData) {

    }

    @Override
    public void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        mBinding.editTitleWritePlan.clearFocus();
        mBinding.editIdGroupWritePlan.clearFocus();
        inputMethodManager.hideSoftInputFromWindow(mBinding.editTitleWritePlan.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(mBinding.editIdGroupWritePlan.getWindowToken(), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Const.MSG_REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    mBinding.imgWritePlan.setImageBitmap(bitmapImage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
