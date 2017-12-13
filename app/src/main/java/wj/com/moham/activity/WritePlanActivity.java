package wj.com.moham.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wj.com.moham.R;
import wj.com.moham.common.model.RoomData;
import wj.com.moham.common.ui.dialog.DialogMoham;
import wj.com.moham.common.ui.dialog.OnAlertClickListener;
import wj.com.moham.presenter.WritePlanContract;

public class WritePlanActivity extends AppCompatActivity implements WritePlanContract.Ui {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_plan);
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
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        finish();
    }


    @Override
    public void makeRoom(RoomData rData) {

    }

    @Override
    public void closeKeyboard() {

    }
}
