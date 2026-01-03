package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 保存来自v_remainroom视图查询的数据
 */
public class VRemainRoom {
    private int hotelid;
    private int typeid;
    private String roomtype;
    private int roomamount;
    private int bookamount;
    private int remainamount;

    public VRemainRoom() {
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public int getRoomamount() {
        return roomamount;
    }

    public void setRoomamount(int roomamount) {
        this.roomamount = roomamount;
    }

    public int getBookamount() {
        return bookamount;
    }

    public void setBookamount(int bookamount) {
        this.bookamount = bookamount;
    }

    public int getRemainamount() {
        return remainamount;
    }

    public void setRemainamount(int remainamount) {
        this.remainamount = remainamount;
    }

    @Override
    public String toString() {
        return "VRemainRoom{" +
                "hotelid=" + hotelid +
                ", typeid=" + typeid +
                ", roomtype='" + roomtype + '\'' +
                ", roomamount=" + roomamount +
                ", bookamount=" + bookamount +
                ", remainamount=" + remainamount +
                '}' + "\n";
    }

    //交换单个结果集数据
    public VRemainRoom(ResultSet rs) {
        try{
            if(rs!=null && rs.next()){
                this.setHotelid(rs.getInt("hotelid"));
                this.setTypeid(rs.getInt("typeid"));
                this.setRoomtype(rs.getString("roomtype"));
                this.setRoomamount(rs.getInt("roomamount"));
                this.setBookamount(rs.getInt("bookamount"));
                this.setRemainamount(rs.getInt("remainamount"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //交换多个结果集数据
    public static List<VRemainRoom> tranList(ResultSet rs){
        List<VRemainRoom> list = new ArrayList<VRemainRoom>();
        try{
            while(rs!=null &&rs.next()){
                VRemainRoom obj = new VRemainRoom();
                obj.setHotelid(rs.getInt("hotelid"));
                obj.setTypeid(rs.getInt("typeid"));
                obj.setRoomtype(rs.getString("roomtype"));
                obj.setRoomamount(rs.getInt("roomamount"));
                obj.setBookamount(rs.getInt("bookamount"));
                obj.setRemainamount(rs.getInt("remainamount"));
                list.add(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
