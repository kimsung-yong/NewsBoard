package dao;

import dto.NewsBoardDto;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewsBoardDao {
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    public Connection conDB(){
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/orcl");
            con = ds.getConnection();
            return con;
        }catch (Exception e){
            System.out.println("예외 : " + e.getMessage());
            return null;
        }
    }
    public void insert(NewsBoardDto dto) {
        conDB();
        String name = dto.getName();
        String title = dto.getTitle();
        String content = dto.getContent();


        try {
            ps = con.prepareStatement("insert into newsboard values(board_seq.nextval,?,?,?,sysdate,0)");
            ps.setString(1, name);
            ps.setString(2, title);
            ps.setString(3, content);

            ps.executeQuery();


        }catch (Exception e) {
            System.out.println("insert예외 :" +e.getMessage());
        }finally {
            try {
                ps.close();
                con.close();
            }catch (Exception e) {
                System.out.println("close 예외" + e.getMessage());
            }
        }

    }

    public List<NewsBoardDto> selectAll(){
        conDB();
        try{
            ps = con.prepareStatement("select * from newsboard");
            rs = ps.executeQuery();

            List<NewsBoardDto> list = new ArrayList<>();

            while (rs.next()){
                NewsBoardDto dto = new NewsBoardDto();
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getNString("name"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteDate(rs.getDate("writedate"));
                dto.setViewCount(rs.getLong("viewcount"));
                list.add(dto);
            }
            return list;
        }catch (Exception e){
            System.out.println("select 오류 :" + e.getMessage());
            return null;
        }
    }

    public List<NewsBoardDto> select(String search,String searchtype){
        conDB();
        List<NewsBoardDto> list = new ArrayList<>();
        try{
            NewsBoardDto dto = new NewsBoardDto();
            ps = con.prepareStatement("select * from newsboard where " + searchtype +" like'%"+search+"%'");
            rs = ps.executeQuery();
            while (rs.next()){
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setTitle(rs.getString("title"));
                dto.setWriteDate(rs.getDate("writedate"));
                dto.setViewCount(rs.getLong("viewcount"));
                list.add(dto);
            }

            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }


}
