package service;

import model.*;
import java.util.List;

/**
 * 酒店管理模块接口
 */
public interface HotelService {
    /**
     * 根据酒店id返回对应的THotel
     * @param hotelid
     * @return
     */
    public THotel getHotelById(int hotelid);

    /**
     * 根据record中非空的字段内容提供组合查询得到List<THotel>
     * @param record
     * @return
     */
    public List<THotel> getHotelsByNameAndCity(String city,String hotelname);

    /**
     * 添加一个新的酒店信息
     * @param record
     * @return 成功返回新酒店的主键值，失败返回0
     */
    public int addHotel(THotel record);

    /**
     * 修改指定的酒店信息
     * @param record
     * @return 成功返回true，失败返回false
     */
    public boolean modifyHotel(THotel record);

    /**
     * 删除指定的酒店信息
     * @param hotelid
     * @return 成功返回true，失败返回false
     */
    public boolean removeHotel(int hotelid);

    /**
     * 根据用户的userid查询所管理的所有的酒店信息
     * @param userid
     * @return
     */
    public List<THotel> getHotelsByUser(String userid);
}
