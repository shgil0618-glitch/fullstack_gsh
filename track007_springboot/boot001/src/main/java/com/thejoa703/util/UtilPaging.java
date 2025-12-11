package com.thejoa703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UtilPaging{
	   private  int  listtotal;    //1. 전체글 193
	   private  int  onepagelist;  //2. 한페이지에 보여줄수 있는 게시물의 수 10
	   private  int  pagetotal;    //3. 총 페이지 수 193/10 19페이지 + 3글 = 20페이지
	   private  int  bottomlist;   //4. 하단의 페이지 수 10페이지
	   private  int  pstartno;     //5. 페이지 시작번호
	   
	   private  int current;	//6. 현재 하단에 페이지 수   		 11 12 [13] 14 15
	   private  int start;      //7. 하단에 페이지 스타트	   		[11] 12 13 14 15
	   private  int end;		//8. 허던애 패아지 마지막			11 12 13 14 [15]
	   
	   public UtilPaging(int listtotal, int pageNo) {

		    this.listtotal = (listtotal <= 0) ? 1 : listtotal;
		    this.onepagelist = 10;         // 1페이지에 10개
		    this.bottomlist = 10;          // 하단 페이지 10개

		    // 전체 페이지 수
		    this.pagetotal = (int)Math.ceil(this.listtotal / (double)onepagelist);

		    // 현재 페이지 보정
		    this.current = (pageNo < 1) ? 1 : pageNo;
		    if (this.current > this.pagetotal) this.current = this.pagetotal;

		    // DB LIMIT 시작 번호
		    this.pstartno = (this.current - 1) * onepagelist;

		    // 하단 페이징 블록 계산
		    int block = (current - 1) / bottomlist;

		    this.start = (block * bottomlist) + 1;    // 시작 페이지
		    this.end = start + bottomlist - 1;        // 끝 페이지

		    if (end > pagetotal) end = pagetotal;
		}
	   
	    // ✔ 검색 포함 페이징 생성자
	    public UtilPaging(int listtotal, int pageNo, int onepagelist) {

	        this.listtotal = (listtotal <= 0) ? 1 : listtotal;
	        this.onepagelist = onepagelist;  // 검색용 3개

	        this.pagetotal = (int)Math.ceil(this.listtotal / (double)this.onepagelist);

	        this.bottomlist = 5; // 하단 1 2 3 4 5
	        
	        this.current = (pageNo <= 0) ? 1 : pageNo;

	        this.start = ((this.current - 1) / this.bottomlist) * this.bottomlist + 1;
	        this.end = this.start + this.bottomlist - 1;
	        if(this.end > pagetotal) this.end = pagetotal;

	        this.pstartno = (this.current - 1) * this.onepagelist;
	    }
   
	
	   
}
