package powertools.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import powertools.core.dto.ReturnItemDTO;
import powertools.dao.custom.ReturnItemDAO;
import powertools.dao.db.DBConnection;

public class ReturnItemDAOImpl implements ReturnItemDAO {

    @Override
    public boolean add(ReturnItemDTO dto) throws Exception {
        String SQL = "INSERT INTO returnitem VALUES (?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getReturnID());
        stm.setObject(2, dto.getBatchID());
        stm.setObject(3, dto.getSellItemID());
        stm.setObject(4, dto.getReason());
        stm.setObject(5, dto.getQty());
        stm.setObject(6, dto.getDate());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(ReturnItemDTO dto) throws Exception {
        String SQL = "UPDATE returnitem SET batchID=?, SItemID=?, reason=?, qty=?, Date=? WHERE returnID=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, dto.getBatchID());
        stm.setObject(2, dto.getSellItemID());
        stm.setObject(3, dto.getReason());
        stm.setObject(4, dto.getQty());
        stm.setObject(5, dto.getDate());
        stm.setObject(6, dto.getReturnID());
        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(ReturnItemDTO dto) throws Exception {
        String SQL = "DELETE FROM returnitem WHERE returnID='" + dto.getReturnID() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(SQL) > 0;
    }

    @Override
    public ReturnItemDTO search(ReturnItemDTO dto) throws Exception {
        String SQL = "SELECT * FROM returnitem WHERE returnID='" + dto.getReturnID() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        rst.next();
        return new ReturnItemDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDate(6));
    }

    @Override
    public ArrayList<ReturnItemDTO> getAll() throws Exception {
        String SQL = "SELECT * FROM returnitem";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ReturnItemDTO> returnList = new ArrayList<>();
        while (rst.next()) {
            returnList.add(new ReturnItemDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDate(6)));
        }
        return returnList;
    }

}