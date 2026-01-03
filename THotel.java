package model;

import service.RoomTypeService;
import service.RoomTypeServiceImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现与t_hotel表进行数据交换的实体类
 */
public class THotel {
    //所有属性名成要与t_hotel表的字段名称和类型保持一致
    private int hotelid;
    private String hotelname;
    private String country;
    private String province;
    private String city;
    private String detailaddr;
    private String features;
    private String server;
    private String tels;
    private String photourl;
    private String userid;
    private int minprice; //酒店所有房间的最低价格

    public THotel() {
    }

    public THotel(int hotelid, String hotelname, String country, String province,
                  String city, String detailaddr, String features, String server,
                  String tels,String photourl, String userid) {
        this.hotelid = hotelid;
        this.hotelname = hotelname;
        this.country = country;
        this.province = province;
        this.city = city;
        this.detailaddr = detailaddr;
        this.features = features;
        this.server = server;
        this.tels = tels;
        this.photourl = photourl;
        this.userid = userid;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailaddr() {
        return detailaddr;
    }

    public void setDetailaddr(String detailaddr) {
        this.detailaddr = detailaddr;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTels() {
        return tels;
    }

    public void setTels(String tels) {
        this.tels = tels;
    }

    public int getMinprice() {
        RoomTypeService rser = new RoomTypeServiceImpl();
        return rser.getCheapestPrice(hotelid);
    }

    @Override
    public String toString() {
        return "THotel{" +
                "hotelid=" + hotelid +
                ", hotelname='" + hotelname + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", detailaddr='" + detailaddr + '\'' +
                ", features='" + features + '\'' +
                ", server='" + server + '\'' +
                ", tels='" + tels + '\'' +
                ", photourl='" + photourl + '\'' +
                ", userid='" + userid + '\'' +
                '}'+"\n";
    }

    /*为了简化实体对象与结果集的数据交换，以下将定义用于专门实现t_hotel表数据
    到THotel实体对象的交换方法：交换单条酒店数据，和交换多条酒店数据的方法*/

    /**
     * 交换单条t_hotel表的记录数据
     */
    public THotel(ResultSet rs){
        try {
            if (rs != null && rs.next()) {
                this.setHotelid(rs.getInt("hotelid"));
                this.setHotelname(rs.getString("hotelname"));
                this.setCountry(rs.getString("country"));
                this.setProvince(rs.getString("province"));
                this.setCity(rs.getString("city"));
                this.setDetailaddr(rs.getString("detailaddr"));
                this.setFeatures(rs.getString("features"));
                this.setServer(rs.getString("server"));
                this.setTels(rs.getString("tels"));
                this.setPhotourl(rs.getString("photourl"));
                this.setUserid(rs.getString("userid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 交换多条t_hotel记录数据到List<THotel>中
     */
    public static List<THotel> tranList(ResultSet rs){
        List<THotel> list = new ArrayList<THotel>();
        try{
            while(rs!=null && rs.next()){
                THotel hotel = new THotel();
                hotel.setHotelid(rs.getInt("hotelid"));
                hotel.setHotelname(rs.getString("hotelname"));
                hotel.setCountry(rs.getString("country"));
                hotel.setProvince(rs.getString("province"));
                hotel.setCity(rs.getString("city"));
                hotel.setDetailaddr(rs.getString("detailaddr"));
                hotel.setFeatures(rs.getString("features"));
                hotel.setServer(rs.getString("server"));
                hotel.setTels(rs.getString("tels"));
                hotel.setPhotourl(rs.getString("photourl"));
                hotel.setUserid(rs.getString("userid"));

                list.add(hotel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list; //把交换得到的list返回
    }
}
