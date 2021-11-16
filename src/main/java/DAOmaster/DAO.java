package DAOmaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static int insertBoard(boardVO aa){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_board (title, ctnt, writer) VALUES (?, ?, ?) ";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, aa.getTitle());
            ps.setString(2,aa.getCtnt());
            ps.setString(3, aa.getWriter());
            return ps.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps);
        }return 0;

    }

    public static List<boardVO> selList(){
        List<boardVO> list = new ArrayList(); // 전체다 가져옴
        Connection con = null; //연결
        PreparedStatement ps = null; // 쿼리 실행
        ResultSet rs = null; //정보 담는거?
        String sql = "SELECT * FROM t_board ORDER BY iboard DESC";
                //iboard title ctnt writer rdt  = *
        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql); //sql
            rs = ps.executeQuery(); //쿼리실행

            while (rs.next()){
                boardVO vo = new boardVO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
         }return list;

    }
    public static boardVO selDetail(boardVO param){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_board WHERE iboard = ? ";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,param.getIboard());
            rs = ps.executeQuery();
            if(rs.next()){
                boardVO vo = new boardVO();
                vo.setIboard(param.getIboard());
                vo.setTitle(rs.getString("title"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
                return vo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        } return null;


    }

//PK값 return
    //이전글 iboard 값 가져오기
    public static int selPrevIboard(boardVO param){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT iboard FROM t_board " +
                " WHERE iboard > ? " +
                " ORDER BY iboard " +
                " LIMIT 1 ";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,param.getIboard());
            rs = ps.executeQuery();

            if(rs.next()){ //쿼리문에서 받아오는건 iboard 값만 이므로 return iboard
               int iboard = rs.getInt("iboard");
               return iboard;
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        }
        return 0;
    }

    //다음글 iboard 값 가져오기

    public static int selNextIboard(boardVO param){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT iboard FROM t_board " +
                " WHERE iboard < ? " +
                " ORDER BY iboard DESC " +
                " LIMIT 1 ";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,param.getIboard());
            rs = ps.executeQuery();

            if(rs.next()){   
                int iboard = rs.getInt("iboard");
                return iboard;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        }
        return 0;
    }




    public static int upBoard(boardVO param){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE t_board SET title=?, ctnt=?, writer=? WHERE iboard=?";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);

            ps.setString(1,param.getTitle());
            ps.setString(2,param.getCtnt());
            ps.setString(3,param.getWriter());
            ps.setInt(4,param.getIboard());
            return ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
           DbUtils.close(con,ps);
        }return 0;



    }

    public static int delBoard(int iboard){
        Connection con =null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM t_board WHERE iboard = ? ";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, iboard);

            return ps.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps);
        }return 0;

    }








}
