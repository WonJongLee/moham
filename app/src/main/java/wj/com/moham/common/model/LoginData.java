package wj.com.moham.common.model;

import android.databinding.BaseObservable;
import android.util.Log;
import android.view.View;

/**
 * Created by admin on 2017. 12. 4..
 */

public class LoginData extends BaseObservable{
    public String id;
    public String pw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

}
