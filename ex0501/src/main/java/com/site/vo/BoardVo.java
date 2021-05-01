package com.site.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {
   int sno;
   String stitle;
   String scontent;
   String sname;
   String sdate;
   String supdateDate;
   String replycnt;
   String shit;
   
}
