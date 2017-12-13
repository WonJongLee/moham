package wj.com.moham.presenter;

/**
 * Created by user on 2017-12-13.
 */

public interface BaseContract {
    interface Presenter {
        void onTopLayoutClickEvent();
    }
    interface Ui {
        void closeKeyboard();
    }
}
