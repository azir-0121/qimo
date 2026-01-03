package service;

import model.*;

import java.util.List;

/**
 *  酒店客房管理模块接口
 */
public interface RoomTypeService {
    /**
     * 添加一个酒店客房类型
     * @param room,
     * @return  成功返回新增房间记录的主键值，失败返回0
     */
    public int addHotelRoomType(TRoomType record);

    /**
     * 修改一个酒店客房类型
     * @param room
     * @return 成功返回true,失败返回false
     */
    public boolean modifyHotelRoomType(TRoomType record);

    /**
     * 删除一个酒店客房类型
     * @param roomid
     * @return 成功返回true,失败返回false
     */
    public boolean removeHotelRoomType(int typeid);

    /**
     * 删除一个酒店的所有客房类型
     * @param hotelid
     * @return 成功返回true,失败返回false
     */
    public boolean removeHotelRoomTypes(int hotelid);

    /**
     * 根据酒店客房类型id查询并返回对应的酒店对象
     * @param typeid
     * @return TRoomType实体对象
     */
    public TRoomType getRoomTypeById(int typeid);

    /**
     * 根据酒店id查询并返回该酒店所有的客房类型信息
     * @param hotelid
     * @return List<TRoomType>
     */
    public List<TRoomType> getRoomTypeListByHotelid(int hotelid);

    /**
     * 查询并返回某酒店id对应的所有客房中最便宜的价格
     * select min(price) from t_roomtype where hotelid=?
     * @param hotelid
     * @return int 最低价格
     */
    public int getCheapestPrice(int hotelid);
}
