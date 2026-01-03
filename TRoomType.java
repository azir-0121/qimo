package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 存储t_roomtype表记录数据的实体类
 */
public class TRoomType {
    private int typeid;
    private int hotelid;
    private String roomtype;
    private String photourl;
    private int area;
    private String bedtype;
    private String roomserver;
    private String wifi;
    private int personamount;
    private int roomamount;
    private int price;

    public TRoomType() {
    }

    public TRoomType(int typeid, int hotelid, String roomtype, String photourl, int area, String bedtype, String roomserver, String wifi, int personamount, int roomamount, int price) {
        this.typeid = typeid;
        this.hotelid = hotelid;
        this.roomtype = roomtype;
        this.photourl = photourl;
        this.area = area;
        this.bedtype = bedtype;
        this.roomserver = roomserver;
        this.wifi = wifi;
        this.personamount = personamount;
        this.roomamount = roomamount;
        this.price = price;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    public String getRoomserver() {
        return roomserver;
    }

    public void setRoomserver(String roomserver) {
        this.roomserver = roomserver;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public int getPersonamount() {
        return personamount;
    }

    public void setPersonamount(int personamount) {
        this.personamount = personamount;
    }

    public int getRoomamount() {
        return roomamount;
    }

    public void setRoomamount(int roomamount) {
        this.roomamount = roomamount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TRoomType{" +
                "typeid=" + typeid +
                ", hotelid=" + hotelid +
                ", roomtype='" + roomtype + '\'' +
                ", photourl='" + photourl + '\'' +
                ", area=" + area +
                ", bedtype='" + bedtype + '\'' +
                ", roomserver='" + roomserver + '\'' +
                ", wifi='" + wifi + '\'' +
                ", personamount=" + personamount +
                ", roomamount=" + roomamount +
                ", price=" + price +
                '}' + "\n";
    }

    /**
     * 交换单条记录的构造方法
     * @param rs
     */
    public TRoomType(ResultSet rs){
        try{
            if(rs!=null && rs.next()){
                this.typeid = rs.getInt("typeid");
                this.hotelid = rs.getInt("hotelid");
                this.roomtype = rs.getString("roomtype");
                this.photourl = rs.getString("photourl");
                this.area = rs.getInt("area");
                this.bedtype = rs.getString("bedtype");
                this.roomserver = rs.getString("roomserver");
                this.wifi = rs.getString("wifi");
                this.personamount = rs.getInt("personamount");
                this.roomamount = rs.getInt("roomamount");
                this.price = rs.getInt("price");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 交换多条记录的静态方法
     */
    public static List<TRoomType> tranList(ResultSet rs){
        List<TRoomType> list = new ArrayList<TRoomType>();
        try{
            while(rs!=null && rs.next()){
                TRoomType room = new TRoomType();
                room.typeid = rs.getInt("typeid");
                room.hotelid = rs.getInt("hotelid");
                room.roomtype = rs.getString("roomtype");
                room.photourl = rs.getString("photourl");
                room.area = rs.getInt("area");
                room.bedtype = rs.getString("bedtype");
                room.roomserver = rs.getString("roomserver");
                room.wifi = rs.getString("wifi");
                room.personamount = rs.getInt("personamount");
                room.roomamount = rs.getInt("roomamount");
                room.price = rs.getInt("price");
                list.add(room);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
