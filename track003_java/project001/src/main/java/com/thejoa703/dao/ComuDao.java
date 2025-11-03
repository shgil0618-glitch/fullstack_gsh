package com.thejoa703.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.thejoa703.dto.ComuDto;
import com.thejoa703.dao.ComuDao;

/*

CREATE TABLE COMMUNITY_TB (
    postId      NUMBER(8) PRIMARY KEY,      -- 게시글 ID
    id      number(30) NOT NULL,      -- 작성자
    title        VARCHAR2(200) NOT NULL,    -- 제목
    content      CLOB NOT NULL,             -- 본문
    categoryId  NUMBER(3) NOT NULL,           -- 카테고리 번호
    views        NUMBER(6) DEFAULT 0,       -- 조회수
    createdAt   DATE DEFAULT SYSDATE,       -- 작성일
    updatedAt   DATE,                       -- 수정일
    FOREIGN KEY (id) REFERENCES users(id),
    FOREIGN KEY (categoryId) REFERENCES CATEGORY_TB(categoryId)
);

view
    1. list.jsp
    2. write.jsp
    3. detail.jsp
    4. edit.jsp
    5. delete.jsp

controller
    1. frontcontroller
        1-1. @webservlet 개발용     *.do, *.member, *.gsh
        1-2. web.xml     배포용           
        [com.thejoa703.controller] - MbtiController
        ㄴ index.jsp
            ㄴ [전체글보기]/MBTIboard/list.do           ■ MbtiList /           MbTIBoard/list.jsp
            ㄴ [글쓰기폼]/MBTIboard/writeView.do        □           /         MbTIBoard/write.jsp
            ㄴ [글쓰기기능]/MBTIboard/write.do          ■ MbtiInsert /알림창 + list.do
            ㄴ [상세보기]/MBTIboard/detail.do           ■ MbtiDetail /        MbTIBoard/detail.jsp
            ㄴ [글수정폼]/MBTIboard/editView.do         ■ MbtiUpdateView /    MbTIBoard/edit.jsp
            ㄴ [글수정기능]/MBTIboard/edit.do           ■ MbtiUpdate /알림창 + MbTIBoard/detail.jsp
            ㄴ [글수정폼]/MBTIboard/deleteView.do       □           /         MbTIBoard/delete.jsp
            ㄴ [글수정삭제]/MBTIboard/delete.do         ■ MbtiDelete /알림창 + list.do
            
        1-1. frontcontroller web.xml	[com.thejoa703.controller] - MbtiController
        1-2. view 연결확인

    2. service
        [com.thejoa703.service]
        MbtiService <<interface>>
            △... MbtiList			데이터 x / dao.selectAll()
            △... MbtiInsert			데이터 o / selectAll() / insert(PostDto dto)
            △... MbtiDetail			데이터 o / insert(int id) , update_hit(int id)
            △... MbtiUpdateview		데이터 o / select(int id)
            △... MbtiUpdate			데이터 o / update(PostDto dto)
            △... MbtiDelete			데이터 o / update(PostDto dto)
            
C : 게시글 작성	(comInsert.jsp)			
R : 게시글 보기	(comlist.jsp)		
				(comdetail.jsp)
U : 게시글 수정	(comupdate.jsp)
D : 게시글 삭제	(comdelete.jsp)

  ㄴ [전체글보기]/MBTIboard/list.do           ■ ComList /           MbTIBoard/list.jsp
            ㄴ [글쓰기폼]/MBTIboard/ComwriteView.do        □           /         MbTIBoard/write.jsp
            ㄴ [글쓰기기능]/MBTIboard/Comwrite.do          ■ ComInsert /알림창 + list.do
            ㄴ [상세보기]/MBTIboard/Comdetail.do           ■ ComDetail /        MbTIBoard/detail.jsp
            ㄴ [글수정폼]/MBTIboard/ComeditView.do         ■ ComUpdateView /    MbTIBoard/edit.jsp
            ㄴ [글수정기능]/MBTIboard/Comedit.do           ■ ComiUpdate /알림창 + MbTIBoard/detail.jsp
            ㄴ [글수정폼]/MBTIboard/ComdeleteView.do       □           /         MbTIBoard/delete.jsp
            ㄴ [글수정삭제]/MBTIboard/Comdelete.do         ■ ComDelete /알림창 + list.do

controller
1. frontcontroller
*/ 
 
public class ComuDao {

	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//	1. [글쓰기] sql : 
//  insert into post (id, app_user_id, title, content, pass) 
//  values(post_seq.nextval, ?,?,?,?);
	
	/*
	 * postId NUMBER(8) PRIMARY KEY, -- 게시글 ID id VARCHAR2(30) NOT NULL, -- 작성자
	 * title VARCHAR2(200) NOT NULL, -- 제목 content CLOB NOT NULL, -- 본문 categoryId
	 * NUMBER(3) NOT NULL, -- 카테고리 번호 views NUMBER(6) DEFAULT 0, -- 조회수 createdAt
	 * DATE DEFAULT SYSDATE, -- 작성일 updatedAt DATE, -- 수정일
	 */
	 public int insert(ComuDto dto){
     	int result = -1;
     	String sql = "insert into Comu (postId, id, title, content, categoryId, createdAt)"
     			+ "        values(post_seq.nextval, ?,?,?,?,sysdate)";
     	//String sql = "select * from dept where deptno=?";
     	
     	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
 		String driver ="oracle.jdbc.driver.OracleDriver";
 		String url = "jdbc:oracle:thin:@localhost:1521:xe";
 		String user = "scott", pass ="tiger";
 		
     	// 드 커 프 리
 		try {
 			//1. 드라이버 연결
 			Class.forName(driver);
				//2. 커넥션
 			conn = DriverManager.getConnection(url,user,pass);
	        	//3. pstmt
 			pstmt = conn.prepareStatement(sql);
 			pstmt.setInt(1, dto.getId());
 			pstmt.setString(2, dto.getTitle());
 			pstmt.setString(3, dto.getContent());
 			pstmt.setInt(4, dto.getCategoryId());
	        //4. result (select : executeQuery , insert/update/delete : executeUpdate)
 			int presult = pstmt.executeUpdate();
 			if(presult>0) {result=1;} 	//성공
 			
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				if(rset != null) {try { rset.close(); } catch (Exception e) { e.printStackTrace(); }}
				if(pstmt != null) {try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }}
				if(conn != null) {try { conn.close(); } catch (Exception e) { e.printStackTrace(); }}
			}
     	
     	return result;
     }	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////	
// 2. [전체보기]전체게시글 가져오기
	 public  ArrayList<ComuDto> selectAll(){
         ArrayList<ComuDto> result = new ArrayList<>();
         String sql = " SELECT      *     "
                    + " FROM      Comu ";
         // 드 커 프 리
         Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
         String driver="oracle.jdbc.driver.OracleDriver";
         String    url="jdbc:oracle:thin:@localhost:1521:xe";
         String   user="scott" , pass="tiger";
         // 드 커 프 리 
         try {
            //1. 드라이버연동 
            Class.forName(driver);
            //2. 커넥션
            conn = DriverManager.getConnection(url, user, pass);
            //3. PSTMT
            pstmt = conn.prepareStatement(sql);
            //4. RESULT (  select : executeQuery  / insert,update, delete: executeUpdate)
            rset = pstmt.executeQuery();  //표
            while(rset.next()) { //줄
            	/*
            	 * postId NUMBER(8) PRIMARY KEY, -- 게시글 ID id VARCHAR2(30) NOT NULL, -- 작성자
            	 * title VARCHAR2(200) NOT NULL, -- 제목 content CLOB NOT NULL, -- 본문 categoryId
            	 * NUMBER(3) NOT NULL, -- 카테고리 번호 views NUMBER(6) DEFAULT 0, -- 조회수 createdAt
            	 * DATE DEFAULT SYSDATE, -- 작성일 updatedAt DATE, -- 수정일
            	 */
            	result.add(new ComuDto(
            		    rset.getInt("postId"),                   
            		    rset.getInt("id"),                       
            		    rset.getString("title"),                 
            		    rset.getString("content"),               
            		    rset.getInt("categoryId"),               
            		    rset.getInt("views"),					 
            		    rset.getTimestamp("createdAt").toLocalDateTime(), 
            		    rset.getTimestamp("updatedAt") != null ? rset.getTimestamp("updatedAt").toLocalDateTime() : null
            		));
            } 
         } catch (Exception e) { e.printStackTrace();
         } finally {
            if( rset  != null ) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if( pstmt != null ) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if( conn  != null ) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
         }  
         
         return result;
      }	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//3. [상세보기]글번호 해당하는 글가져오기 sql :  

	 public ComuDto select(int postId){
		 ComuDto result = new ComuDto();
		 String sql = "select * from Comu where postId=?";
		        	// 드 커 프 리
		 Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
		 String driver ="oracle.jdbc.driver.OracleDriver";
		 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 String user = "scott", pass ="tiger";

		 // 드 커 프 리
		 try {
		 	//1. 드라이버 연결
		 	Class.forName(driver);
		 	//2. 커넥션
		 	conn = DriverManager.getConnection(url, user, pass);
		 	//3. pstmt
		 	pstmt = conn.prepareStatement(sql);
		 	pstmt.setInt(1, postId);		// [?있으면 넣어줘야함]String sql = "select * from post where id=?"
		 	//4. result
		 	rset = pstmt.executeQuery();	//표
		 	while(rset.next()) {	//줄
		 		result=new ComuDto(
		 				rset.getInt("postId"),                   
            		    rset.getInt("id"),                       
            		    rset.getString("title"),                 
            		    rset.getString("content"),               
            		    rset.getInt("categoryId"),               
            		    rset.getInt("views"),					 
            		    rset.getTimestamp("createdAt").toLocalDateTime(), 
            		    rset.getTimestamp("updatedAt") != null ? rset.getTimestamp("updatedAt").toLocalDateTime() : null	
		 				);
		 	}
		 	
		 } catch (Exception e) {
		 	e.printStackTrace();
		 } finally{
		 	if(rset != null) {try { rset.close(); } catch (Exception e) { e.printStackTrace(); }}
		 	if(pstmt != null) {try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }}
		 	if(conn != null) {try { conn.close(); } catch (Exception e) { e.printStackTrace(); }}
		 }
		        	return result;
		        }
		        
		 public int update_views(int postId){
		 int result = -1;
		 String sql = "update Comu set views = views+1 where postId=?";
		 // 드 커 프 리
		 Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
		 String driver ="oracle.jdbc.driver.OracleDriver";
		 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 String user = "scott", pass ="tiger";

		 // 드 커 프 리
		 try {
		 	//1. 드라이버 연결
		     Class.forName(driver);
		     //2. 커넥션
		     conn = DriverManager.getConnection(url, user, pass);
		     //3. pstmt
		     pstmt = conn.prepareStatement(sql);
		     pstmt.setInt(1, postId);
		     //4. 실행
		     if(pstmt.executeUpdate()>0) {result=1;} 
		     
		 } catch (Exception e) {
		 	e.printStackTrace();
		 } finally{
		 	if(rset != null) {try { rset.close(); } catch (Exception e) { e.printStackTrace(); }}
		 	if(pstmt != null) {try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }}
		 	if(conn != null) {try { conn.close(); } catch (Exception e) { e.printStackTrace(); }}
		 }
		 return result;
		        
}        
	 
	 

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//4. 글수정하기 sql
		 public int update(ComuDto dto){			//매개변수 많은면 dto 받아!
			 int result = -1;
			 String sql = "update Comu set title=?, content=?, categoryId=? where postId=? and id=?";
			 // 드 커 프 리
			 Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
			 String driver ="oracle.jdbc.driver.OracleDriver";
			 String url = "jdbc:oracle:thin:@localhost:1521:xe";
			 String user = "scott", pass ="tiger";

			 // 드 커 프 리
			 try {
			 	//1. 드라이버 연결
			 	Class.forName(driver);
			 	//2. 커넥션
			 	conn = DriverManager.getConnection(url,user,pass);
			 	//3. pstmt
			 	pstmt = conn.prepareStatement(sql);
			 	pstmt.setString(1, dto.getTitle());
			 	pstmt.setString(2, dto.getContent());
			 	pstmt.setInt(3, dto.getCategoryId());
			 	pstmt.setInt(4, dto.getPostId());
			 	pstmt.setInt(5, dto.getId());
			 	//4. result
			 	if(pstmt.executeUpdate()>0) {result=1;} 
			 	
			 } catch (Exception e) {
			 	e.printStackTrace();
			 } finally{
			 	if(rset != null) {try { rset.close(); } catch (Exception e) { e.printStackTrace(); }}
			 	if(pstmt != null) {try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }}
			 	if(conn != null) {try { conn.close(); } catch (Exception e) { e.printStackTrace(); }}
			 }
			 return result;    
			 }	
	

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//5. 글번호 해당하는 삭제
		 public int delete(ComuDto dto){			//매개변수 많은면 dto 받아!
			 int result = -1;
			 String sql = "delete from Comu where postId=? and id =?";
			 // 드 커 프 리
			 Connection conn = null; PreparedStatement pstmt = null; ResultSet rset=null;
			 String driver ="oracle.jdbc.driver.OracleDriver";
			 String url = "jdbc:oracle:thin:@localhost:1521:xe";
			 String user = "scott", pass ="tiger";

			 // 드 커 프 리
			 try {
			 	//1. 드라이버 연결
			 	Class.forName(driver);
			 	//2. 커넥션
			 	conn = DriverManager.getConnection(url,user,pass);
			 	//3. pstmt
			 	pstmt = conn.prepareStatement(sql);
			 	pstmt.setInt(1, dto.getPostId());
			 	pstmt.setInt(2, dto.getId());
			 	//4. result
			 	if(pstmt.executeUpdate()>0) {result=1;} 
			 	
			 } catch (Exception e) {
			 	e.printStackTrace();
			 } finally{
			 	if(rset != null) {try { rset.close(); } catch (Exception e) { e.printStackTrace(); }}
			 	if(pstmt != null) {try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }}
			 	if(conn != null) {try { conn.close(); } catch (Exception e) { e.printStackTrace(); }}
			 }
			 return result;
			  }
		 
		 
	
}
