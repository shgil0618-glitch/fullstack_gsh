package com.thejoa703;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.thejoa703.dao.Sboard2Dao;
import com.thejoa703.dto.BasicDto;
import com.thejoa703.dto.Sboard2Dto;
import com.thejoa703.service.Sboard2Service;
import com.thejoa703.service.TestService;

@SpringBootTest
class Boot001ApplicationTests {

	@Autowired TestService service;
	@Autowired Sboard2Dao dao;
	@Autowired Sboard2Service boardService;
	
	@Test
	public void test10() {
		//1. 10개씩 가져오기
		HashMap<String ,Integer> para = new HashMap<>();
		para.put("start", 1);
		para.put("end", 10);
		System.out.println(".............." + dao.select10(para));
		
		//2. 전체갯수
		System.out.println(".............." + dao.selectTotalCnt());
	}
	
	
	@Disabled @Test		// junit4: @ignore 5 : @Disabled
	void contextLoads() {
		BasicDto dto = new BasicDto();
		dto.setName("sally");
		dto.setAge(10);
		System.out.println("........" + dto.getName());
		System.out.println("........" + dto.getAge());
	}
	
	@Disabled @Test void serviceTest() {
		System.out.println("..........." + service.readTime());
	}
	
	 

	@Disabled @Test
	    void insertTest() {
	        Sboard2Dto dto = new Sboard2Dto();
	        dto.setAppUserId(1);
	        dto.setBtitle("테스트 제목");
	        dto.setBcontent("테스트 내용");
	        dto.setBpass("1234");
	        dto.setBfile(null);
	        dto.setBip("127.0.0.1");

	        int result = dao.insert(dto);
	        System.out.println("INSERT RESULT = " + result);
	    }

	@Disabled @Test
	    void updateTest() {
	        Sboard2Dto dto = new Sboard2Dto();
	        dto.setId(1);
	        dto.setBtitle("수정된 제목");
	        dto.setBcontent("수정된 내용");
	        dto.setBpass("1234");
	        dto.setBfile("newfile.jpg");

	        int result = dao.update(dto);
	        System.out.println("UPDATE RESULT = " + result);
	    }

	@Disabled @Test
	    void updateHitTest() {
	        int result = dao.updateHit(1);
	        System.out.println("UPDATE HIT RESULT = " + result);
	    }

	@Disabled @Test
	void deleteTest() {
	    Sboard2Dto dto = new Sboard2Dto();
	    dto.setId(1);
	    dto.setBpass("1234");

	    int result = dao.delete(dto);
	    System.out.println("DELETE RESULT = " + result);
	}


	@Disabled  @Test
	    void selectAllTest() {
	        List<Sboard2Dto> list = dao.selectAll();
	        for (Sboard2Dto dto : list) {
	            System.out.println(dto.getId() + " / " + dto.getBtitle());
	        }
	    }

	@Disabled @Test
	    void selectOneTest() {
	        Sboard2Dto dto = dao.select(1);
	        if (dto != null) {
	            System.out.println("ID: " + dto.getId());
	            System.out.println("TITLE: " + dto.getBtitle());
	            System.out.println("CONTENT: " + dto.getBcontent());
	            System.out.println("HIT: " + dto.getBhit());
	        } else {
	            System.out.println("없음");
	        }
	    }
	
	
/////////////////////////////////////////////////////////////////////////////
	
	// INSERT 테스트
	@Disabled  @Test
    void insertTest2() throws UnknownHostException{
    	
    	Sboard2Dto dto = new Sboard2Dto();
        dto.setAppUserId(1);
        dto.setBtitle("테스트 제목");
        dto.setBcontent("테스트 내용");
        dto.setBpass("1234");
        
        MockMultipartFile file = new MockMultipartFile(
                "file2",
                "test2.txt",
                "text/plain",
                "".getBytes()
        );
        dto.setBip(InetAddress.getLocalHost().getHostAddress());

        System.out.println(boardService.insert(file, dto));
    }

    // SELECT ALL 테스트
    @Disabled  @Test
    void selectAllTest2() {
      System.out.println(boardService.selectAll());
    }

    // SELECT + 조회수 증가 테스트
     @Disabled @Test
    void selectTest2() {
    	System.out.println(boardService.select(1));
    }

    // UPDATE 테스트
    @Disabled @Test
    void updateTest2() {
    	Sboard2Dto dto = new Sboard2Dto();
        dto.setId(1);
        dto.setBtitle("테스트 제목");
        dto.setBcontent("테스트 내용");
        dto.setBpass("1234");
    	
    	MockMultipartFile file = new MockMultipartFile(
                "file2",
                "test2.txt",
                "text/plain",
                "".getBytes()
        );
    	 System.out.println(boardService.insert(file, dto));
    }

    // DELETE 테스트
    @Disabled @Test
    void deleteTest2() {
        Sboard2Dto dto = new Sboard2Dto();
        dto.setBpass("1111"); dto.setId(1);
        System.out.println(boardService.delete(dto));
    }

	

}
