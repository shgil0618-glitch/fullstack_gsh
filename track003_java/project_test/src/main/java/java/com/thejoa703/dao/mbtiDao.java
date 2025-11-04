package java.com.thejoa703.dao;

import java.com.thejoa703.dto.mbtiDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class mbtiDao {
//	1. [글쓰기] sql : 
//  insert into post (id, app_user_id, title, content, pass) 
//  values(post_seq.nextval, ?,?,?,?);
	/*
	 * private int MBTI_TYPE_ID; private String NAME; private String DESCRIPTION;
	 */
	 public int insert(mbtiDto dto){
     	int result = -1;
     	String sql = "insert into mbtitype (MBTI_TYPE_ID,NAME,DESCRIPTION)"
     			+ " values(mbtitype_seq.nextval,?,?)";
     	//String sql = "select * from dept where deptno=?";
     	
     	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
 		String driver ="oracle.jdbc.driver.OracleDriver";
 		String url = "jdbc:oracle:thin:@localhost:1521:xe";
 		String user = "scott", pass ="tiger";
 		
     	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////	
// 2. [전체보기]전체게시글 가져오기
	 public  ArrayList<mbtiDto> selectAll(){
         ArrayList<mbtiDto> result = new ArrayList<>();
         String sql = " SELECT      *     "
                    + " FROM      mbtitype ";
         // 드 커 프 리
         Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
         String driver="oracle.jdbc.driver.OracleDriver";
         String    url="jdbc:oracle:thin:@localhost:1521:xe";
         String   user="scott" , pass="tiger";
         	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//3. [상세보기]글번호 해당하는 글가져오기 sql :  

	 public mbtiDto select(int postId){
		 mbtiDto result = new mbtiDto();
		 String sql = "select * from mbtitype where MBTI_TYPE_ID=?";
		        	// 드 커 프 리
		 Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
		 String driver ="oracle.jdbc.driver.OracleDriver";
		 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 String user = "scott", pass ="tiger";

		 
		        
		        
}        
	 
	 

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//4. 글수정하기 sql
		 public int update(mbtiDto dto){			//매개변수 많은면 dto 받아!
			 int result = -1;
			 String sql = "update mbtytype set name=?, description=? where MBTI_TYPE_ID=?";
			 // 드 커 프 리
			 Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
			 String driver ="oracle.jdbc.driver.OracleDriver";
			 String url = "jdbc:oracle:thin:@localhost:1521:xe";
			 String user = "scott", pass ="tiger";

			 
	

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//5. 글번호 해당하는 삭제
		 public int delete(mbtiDto dto){			//매개변수 많은면 dto 받아!
			 int result = -1;
			 String sql = "delete from mbtytype where MBTI_TYPE_ID=?";
			 // 드 커 프 리
			 Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
			 String driver ="oracle.jdbc.driver.OracleDriver";
			 String url = "jdbc:oracle:thin:@localhost:1521:xe";
			 String user = "scott", pass ="tiger";

			 

}
