package dao;

import model.TRoomType;
import utils.EntityToArrayConverter;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 面向t_roomtype表，实现酒店房间数据的增删查改的数据访问类
 */
public class RoomTypeDaoImpl implements RoomTypeDAO{
    private IBaseDAO bdao = new BaseDAO(); //使用BaseDAO类对象来实现数据库访问操作
    @Override
    public int insert(TRoomType record) {
        String sql = "insert into t_roomtype(hotelid,roomtype,photourl,area," +
                "bedtype,roomserver,wifi,personamount,roomamount,price)" +
                " values(?,?,?,?,?,?,?,?,?,?)";
        Object[] para = {record.getHotelid(),record.getRoomtype(),record.getPhotourl(),
            record.getArea(),record.getBedtype(),record.getRoomserver(),
            record.getWifi(),record.getPersonamount(),record.getRoomserver(),
            record.getPrice()};
        return bdao.insert(sql,para);
    }

    @Override
    public int update(TRoomType record) {
        String sql = "update t_roomtype set roomtype=?,photourl=?,area=?," +
                "bedtype=?,roomserver=?,wifi=?,personamount=?,roomamount=?," +
                "price=? where typeid=?";
        Object[] para = {record.getRoomtype(),record.getPhotourl(),
            record.getArea(),record.getBedtype(),record.getRoomserver(),
            record.getWifi(),record.getPersonamount(),record.getRoomamount(),
            record.getPrice()};
        return bdao.update(sql,para);
    }

    @Override
    public int deleteByPrimaryKey(int typeid) {
        String sql = "delete from t_roomtype where typeid = ?";
        Object[] para = {typeid};
        return bdao.delete(sql,para);
    }

    @Override
    public TRoomType selectByPrimaryKey(int typeid) {
        String sql = "select * from t_roomtype where typeid = ?";
        Object[] para = {typeid};
        ResultSet rs = bdao.select(sql,para);
        TRoomType roomType = new TRoomType(rs);
        bdao.close();
        return roomType;
    }

    @Override
    public List<TRoomType> selectBySelective(TRoomType record) {
        String sql = "select * from t_roomtype";
        String queryCondition = " where 1=1";
        if(record!=null && record.getTypeid()!=0){
            queryCondition += " and typeid = ?";
        }
        if(record!=null && record.getHotelid()!=0){
            queryCondition += " and hotelid = ?";
        }
        if(record!=null && (record.getRoomtype()!=null && !record.getRoomtype().equals(""))){
            queryCondition += " and roomtype like ?";
        }
        if(record!=null && (record.getBedtype()!=null && !record.getBedtype().equals(""))){
            queryCondition += " and bedtype like ?";
        }
        if(record!=null && (record.getRoomserver()!=null && !record.getRoomserver().equals(""))){
            queryCondition += " and roomserver like ?";
        }
        if(record!=null && record.getPrice()!=0){
            queryCondition += " and (price >= ?-50 and price <= ?+50)";
        }
        sql += queryCondition; //组合出完整的select sql命令

        //设置模糊查询字段
        Set<String> likeFields = new HashSet<String>();
        likeFields.add("roomtype");
        likeFields.add("bedtype");
        likeFields.add("roomserver");
        //设置要生成两次参数的查询字段
        Set<String> doubleFields = new HashSet<String>();
        doubleFields.add("price"); //price字段的值要添加两次

        Object[] para = EntityToArrayConverter.getNonNullProperties(
                record,likeFields,doubleFields);

        System.out.println("sql=>" + sql);
        System.out.println("para=>" + Arrays.toString(para));
        ResultSet rs = bdao.select(sql,para);
        List<TRoomType> list = TRoomType.tranList(rs);
        bdao.close();
        return list;
    }

    @Override
    public int selectMinPriceByHotelid(int hotelid) {
        String sql = "select min(price) as minprice from t_roomtype where hotelid=?";
        Object[] para = {hotelid};
        ResultSet rs = bdao.select(sql, para);
        int minprice = 0;
        try{
            if(rs!=null && rs.next()){
                minprice = rs.getInt(1); //rs.getInt("minprice"); //使用别名
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        bdao.close();
        return minprice;  //返回最低价格
    }
}
