package service;

import dao.RoomTypeDAO;
import dao.RoomTypeDaoImpl;
import model.TRoomType;

import java.util.List;

/**
 * 房间类型业务功能管理服务类
 */
public class RoomTypeServiceImpl implements RoomTypeService{
    //依赖RoomTypeDAO数据访问类的对象实现业务功能
    private RoomTypeDAO rdao = new RoomTypeDaoImpl();

    @Override
    public int addHotelRoomType(TRoomType record) {
        return rdao.insert(record);
    }

    @Override
    public boolean modifyHotelRoomType(TRoomType record) {
        int rows = rdao.update(record);
        if(rows>0) return true;
        else return false;
    }

    @Override
    public boolean removeHotelRoomType(int typeid) {
        int rows = rdao.deleteByPrimaryKey(typeid);
        if(rows>0) return true;
        else return false;
    }

    @Override
    public boolean removeHotelRoomTypes(int hotelid) {
        return false;  //不做，因为没有实现类似selectBySelecive的动态删除，因此无法实现
    }

    @Override
    public TRoomType getRoomTypeById(int typeid) {
        return rdao.selectByPrimaryKey(typeid);
    }

    @Override
    public List<TRoomType> getRoomTypeListByHotelid(int hotelid) {
        TRoomType record = new TRoomType();
        record.setHotelid(hotelid);
        return rdao.selectBySelective(record);
    }

    @Override
    public int getCheapestPrice(int hotelid) {
        return rdao.selectMinPriceByHotelid(hotelid);
    }
}
