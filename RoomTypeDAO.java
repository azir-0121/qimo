package dao;

import model.TRoomType;

import java.util.List;

/**
 * 面向t_roomtype表，实现酒店房间类型数据的增删查改的数据访问接口
 */
public interface RoomTypeDAO {
    public int insert(TRoomType record);
    public int update(TRoomType record);
    public int deleteByPrimaryKey(int typeid);
    public TRoomType selectByPrimaryKey(int typeid);
    public List<TRoomType> selectBySelective(TRoomType record);
    //查询并返回某酒店下最低房间价格
    public int selectMinPriceByHotelid(int hotelid);
}
