package wj.com.moham.common.model;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by user on 2017-12-11.
 */

public class RoomData {
    private String roomId;
    private String roomTitle;
    private List   roomUser;
    private int    roomNowNum;
    private int    roomMaxNum;
    private Bitmap roomImage;
    private String roomDate;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public List getRoomUser() {
        return roomUser;
    }

    public void setRoomUser(List roomUser) {
        this.roomUser = roomUser;
    }

    public int getRoomNowNum() {
        return roomNowNum;
    }

    public void setRoomNowNum(int roomNowNum) {
        this.roomNowNum = roomNowNum;
    }

    public int getRoomMaxNum() {
        return roomMaxNum;
    }

    public void setRoomMaxNum(int roomMaxNum) {
        this.roomMaxNum = roomMaxNum;
    }

    public Bitmap getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(Bitmap roomImage) {
        this.roomImage = roomImage;
    }

    public String getRoomDate() {
        return roomDate;
    }

    public void setRoomDate(String roomDate) {
        this.roomDate = roomDate;
    }
}
