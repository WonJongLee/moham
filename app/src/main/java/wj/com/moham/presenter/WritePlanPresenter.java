package wj.com.moham.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import wj.com.moham.common.data.Const;
import wj.com.moham.common.model.LoginData;
import wj.com.moham.common.model.RoomData;

/**
 * Created by user on 2017-12-13.
 */

public class WritePlanPresenter implements WritePlanContract.Presenter {
    private WritePlanContract.Ui ui;
    private Activity act;

    public WritePlanPresenter(WritePlanContract.Ui ui, Activity activity) {
        this.ui = ui;
        this.act = activity;
    }

    @Override
    public void onTopLayoutClick() {
        ui.closeKeyboard();
    }

    @Override
    public void onConfirmBtnClick(RoomData rData) {
        ui.makeRoom(rData);
    }

    @Override
    public void onImageViewClick() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
            intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            act.startActivityForResult(intent, Const.MSG_REQ_CODE_SELECT_IMAGE);
    }

    @Override
    public void onTopLayoutClickEvent() {

    }
}
