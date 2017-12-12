package wj.com.moham.common.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Bitmap;

import java.util.List;

public class RoomData extends BaseObservable {
    private String roomTitle;
    private String roomRecentDate;
    private String roomPersonNum;
    private String roomImageUrl;
    private List<String> roomItemList;

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomRecentDate() {
        return roomRecentDate;
    }

    public void setRoomRecentDate(String roomRecentDate) {
        this.roomRecentDate = roomRecentDate;
    }

    public String getRoomPersonNum() {
        return roomPersonNum;
    }

    public void setRoomPersonNum(String roomPersonNum) {
        this.roomPersonNum = roomPersonNum;
    }

    public String getRoomImageUrl() {
        return roomImageUrl;
    }

    public void setRoomImageUrl(String roomImageUrl) {
        this.roomImageUrl = roomImageUrl;
    }

    public List<String> getRoomItemList() {
        return roomItemList;
    }

    public void setRoomItemList(List<String> roomItemList) {
        this.roomItemList = roomItemList;
    }
}
