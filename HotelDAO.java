package dao;

import model.THotel;

import java.util.List;

/**
 * 面向_hotel表，实现酒店数据的增、删、查、改的数据访问接口
 */
public interface HotelDAO {
    public int insert(THotel record);
    public int update(THotel record);
    public int deleteByPrimaryKey(int hotelid);
    public int deleteHotelAndRoomByPrimaryKey(int hotelid);
    public THotel selectByPrimaryKey(int hotelid);
    public List<THotel> selectBySelective(THotel record);
}
