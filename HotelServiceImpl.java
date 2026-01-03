package service;

import dao.HotelDAO;
import dao.HotelDaoImpl;
import model.THotel;

import java.util.List;

/**
 * 实现酒店业务管理功能的业务服务类
 */
public class HotelServiceImpl implements HotelService{
    private HotelDAO hdao = new HotelDaoImpl();

    @Override
    public THotel getHotelById(int hotelid) {
        return hdao.selectByPrimaryKey(hotelid);
    }

    @Override
    public List<THotel> getHotelsByNameAndCity(String city, String hotelname) {
        THotel record = new THotel();
        record.setCity(city);
        record.setHotelname(hotelname);
        return hdao.selectBySelective(record);
    }

    @Override
    public int addHotel(THotel record) {
        return hdao.insert(record);
    }

    @Override
    public boolean modifyHotel(THotel record) {
        int rows = hdao.update(record);
        if(rows>0) return true;
        else return false;
    }

    @Override
    public boolean removeHotel(int hotelid) {
        int rows = hdao.deleteHotelAndRoomByPrimaryKey(hotelid);
        if(rows>0) return true;
        else return false;
    }

    @Override
    public List<THotel> getHotelsByUser(String userid) {
        THotel record = new THotel();
        record.setUserid(userid); //查询userid账号下管理的所有酒店
        return hdao.selectBySelective(record);
    }
}
