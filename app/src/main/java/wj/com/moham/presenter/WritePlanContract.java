package wj.com.moham.presenter;

import wj.com.moham.common.model.RoomData;

/**
 * Created by user on 2017-12-13.
 */

public interface WritePlanContract {
    interface Presenter extends BaseContract.Presenter{
        void onTopLayoutClick();

        void onConfirmBtnClick(RoomData rData);
    }

    interface Ui extends BaseContract.Ui{
        void makeRoom(RoomData rData);
    }
}
