package service;

import model.TBooking;
import model.VBooking;

import java.util.List;

/**
 * 酒店房间预订管理模块接口
 */
public interface BookingService {

    /**
     * 添加一个酒店客房预订记录
     * @param booking
     * @return 成功返回主键ID，失败返回0
     */
    public int addBooking(TBooking booking);

    /**
     * 取消（删除）一个酒店客房预订（需要在入住时间前）
     * @param bookingid
     * @return 成功返回1，失败返回0
     */
    public boolean cancelBooking(int bookingid);

    /**
     * 修改酒店客房预订信息（需要在入住时间前）
     * @param booking
     * @return 成功返回1，失败返回0
     */
    public boolean modifyBookingInfo(TBooking booking);

    /**
     * 查询一条预订记录
     * @param bookingid   预订订单ID
     * @return VBooking对象，失败返回null
     */
    public VBooking getBookingById(int bookingid);

    /**
     * 查询一个酒店管理员管理下的所有酒店的客房预订记录
     * @param hoteladminid
     * @return List<VBooking>
     */
    public List<VBooking> getBookingsByAdminid(String hoteladminid);

    /**
     * 查询某个酒店的所有客房预订记录
     * @param hotelid
     * @return List<VBooking>
     */
    public List<VBooking> getBookingsByHotelid(int hotelid);

    /**
     * 查询某个会员的所有酒店客房预订记录
     * @param customerid
     * @return List<VBooking>
     */
    public List<VBooking> getBookingsByCustomerid(String customerid);
}
