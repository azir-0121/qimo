package dao;

import model.THotel;
import utils.EntityToArrayConverter;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * t_hotel表的数据访问类
 */
public class HotelDaoImpl implements HotelDAO{
    private IBaseDAO bdao = new BaseDAO();
    @Override
    public int insert(THotel record) {
        String sql = "insert into t_hotel(hotelname,country,province,city," +
                "detailaddr,features,server,tels,photourl,userid) " +
                "values(?,?,?,?,?,?,?,?,?,?)";
        Object[] para = {record.getHotelname(),record.getCountry(),
            record.getProvince(),record.getCity(),record.getDetailaddr(),
            record.getFeatures(),record.getServer(),record.getTels(),
            record.getPhotourl(),record.getUserid()};
        int keys = bdao.insert(sql,para);
        return keys;
    }

    @Override
    public int update(THotel record) {
        String sql = "update t_hotel set hotelname=?,country=?," +
                "province=?,city=?,detailaddr=?,features=?," +
                "server=?,tels=?,photourl=? where hotelid=?";
        Object[] para = {record.getHotelname(),record.getCountry(),
            record.getProvince(),record.getCity(),record.getDetailaddr(),
            record.getFeatures(),record.getServer(),record.getTels(),
            record.getPhotourl(),record.getHotelid()};
        int rows = bdao.update(sql,para);
        return rows;
    }

    @Override
    public int deleteByPrimaryKey(int hotelid) {
        String sql = "delete from t_hotel where hotelid = ?";
        Object[] para = {hotelid};
        int rows = bdao.delete(sql,para);
        return rows;
    }

    @Override
    public int deleteHotelAndRoomByPrimaryKey(int hotelid) {
        String procName = "up_delhotel(?)";
        Object[] para = {hotelid};
        ResultSet rs = bdao.callProcedureWithQuery(procName,para);
        int status = 0;
        try {
            if (rs != null && rs.next()) {
                status = rs.getInt(1); //获取存储过程返回的int类型结果
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        bdao.close();
        return status;
    }

    @Override
    public THotel selectByPrimaryKey(int hotelid) {
        String sql = "select * from t_hotel where hotelid = ?";
        Object[] para = {hotelid};
        ResultSet rs = bdao.select(sql,para);
        THotel hotel = new THotel(rs);
        bdao.close();
        return hotel;
    }

    @Override
    public List<THotel> selectBySelective(THotel record) {
        String sql = "select * from t_hotel";
        String queryCondition = " where 1=1";  //where前一定加空格
        if(record!=null && record.getHotelid()!=0){
            queryCondition += " and hotelid = ?";
        }
        if(record!=null && (record.getHotelname()!=null && !record.getHotelname().equals(""))){
            queryCondition += " and hotelname like ?";
        }
        if(record!=null && (record.getCountry()!=null && !record.getCountry().equals(""))){
            queryCondition += " and country like ?";
        }
        if(record!=null && (record.getProvince()!=null && !record.getProvince().equals(""))){
            queryCondition += " and province like ?";
        }
        if(record!=null && (record.getCity()!=null && !record.getCity().equals(""))){
            queryCondition += " and city like ?";
        }
        if(record!=null && (record.getDetailaddr()!=null && !record.getDetailaddr().equals(""))){
            queryCondition += " and detailaddr like ?";
        }
        if(record!=null && (record.getFeatures()!=null && !record.getFeatures().equals(""))){
            queryCondition += " and features like ?";
        }
        if(record!=null && (record.getServer()!=null && !record.getServer().equals(""))){
            queryCondition += " and server like ?";
        }
        if(record!=null && (record.getTels()!=null && !record.getTels().equals(""))){
            queryCondition += " and tels like ?";
        }
        if(record!=null && (record.getUserid()!=null && !record.getUserid().equals(""))){
            queryCondition += " and userid = ?";
        }
        sql+= queryCondition; //组合sql命令

        //构造parac参数
        Set<String> likeFields = new HashSet<String>();
        likeFields.add("hotelname");
        likeFields.add("country");
        likeFields.add("province");
        likeFields.add("city");
        likeFields.add("detailaddr");
        likeFields.add("features");
        likeFields.add("server");
        likeFields.add("tels");

        Object[] para = EntityToArrayConverter.getNonNullProperties(record,likeFields);

        System.out.println("sql=>" + sql);
        System.out.println("para=>" + Arrays.toString(para));
        ResultSet rs = bdao.select(sql,para);
        List<THotel> list = THotel.tranList(rs);
        bdao.close();
        return list;
    }
}
