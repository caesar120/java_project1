<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  <%
  
   Calendar cal =Calendar.getInstance();

  int nowYear = cal.get(Calendar.YEAR);
  int nowMonth = cal.get(Calendar.MONTH)+1; // +1
  int nowDay = cal.get(Calendar.DAY_OF_MONTH);
  request.setCharacterEncoding( "utf-8");
  String strYear = request.getParameter( "year");
  String strMonth = request.getParameter( "month");
 
    int year = nowYear; // 현재의 년을 받아옴.
    int month = nowMonth; // 현재의 월을 받아옴.
    String cate = request.getParameter( "cate");
    int i;
    int j;
    if(strYear != null)
    {
     year = Integer.parseInt(strYear); 
    }
  
    if(strMonth != null)
    {
     month = Integer.parseInt(strMonth);
    }
   
    cal.set(year,month-1,1);
    int startDay = 1;
   
    int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int week = cal.get(Calendar.DAY_OF_WEEK);
   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../scripts/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function window_onload()
 {
    for ( i=2008;i<=2018 ; i++)
   {
        var op= new Option(i+ "년",i);
         syear.options[i -2008]=op; 
         if(i== <%=year %> )
         {
            syear.options[i -2008].selected ="selected" ;
         }
   }
     for ( i=1;i<=12 ; i++)
     {
        var op= new Option(i+ "월",i);
         smonth.options[i -1]=op;
         if(i== <%=month %>)
         {
             smonth.options[i -1].selected = "selected";
         }
     }
     for ( i=0;i<=2 ; i++)
     {
        //var op= new Option(i+ "카테고리",i);
         
         if(scate.options[i].value== '<%=cate %>')
         {
             scate.options[i].selected = "selected";
         }
     } 
 }
function cate_onchange()
{
    var month = smonth.value;
    var year = syear.value;
    var cate = scate.value;
    var addr = "MenuControl.do?action=list&year=" + year +"&month=" + month + "&cate=" + cate;
    //var addr = "table.jsp?year=" + year +"&month=" + month + "&cate=" + cate;
   // alert(addr);
   //addr 이 가지는 주소값으로  페이지를 이동시킨다.       
  location.href = addr;
   
}
 
function month_onchange()
{   
     var month = smonth.value;
     var year = syear.value;
     var cate = scate.value;
     var addr = "MenuControl.do?action=list&year=" + year +"&month=" + month + "&cate=" + cate;
     
     //var addr = "table.jsp?year=" + year +"&month=" + month + "&cate=" + cate
    // alert(addr);
    //addr 이 가지는 주소값으로  페이지를 이동시킨다.       
   location.href = addr;
   
}
function year_onchange()
{
     var year = syear.value;
     var month = smonth.value;
     var cate = scate.value;
     var addr = "MenuControl.do?action=list&year=" + year +"&month=" + month + "&cate=" + cate;
     //var addr = "table.jsp?year=" + year +"&month=" + month + "&cate=" + cate
        location.href = addr;
    
}

function regist(day)
{
 	var year = $("#syear").val();
	var month = $("#smonth").val();
	var cate = $("#scate").val();
/* 	if(month<10){month=(0+month)};
	if(length(day)==1){day=(0+day)}; */
	
	var regi = "./tableRegist.jsp?year=" + year +"&month=" + month + "&day=" + day +"&cate=" + cate;
	window.open(regi,'reg','width=400px,height=400px');
	

}

function update(day)
{
 	var year = $("#syear").val();
	var month = $("#smonth").val();
	var cate = $("#scate").val();

	var regi = "./tableUpd.jsp?year=" + year +"&month=" + month + "&day=" + day +"&cate=" + cate;
	window.open(regi,'reg','width=400px,height=400px');
	}

/* function dele(day)
{
 	var year = $("#syear").val();
	var month = $("#smonth").val();
	var cate = $("#scate").val();

	var regi = "./tableUpd.jsp?year=" + year +"&month=" + month + "&day=" + day +"&cate=" + cate;
	window.open(regi,'reg','width=400px,height=400px');
	} */

</script>
<title>Insert title here</title>
</head>
<body>
 <body onload ="window_onload()" >
  
 
  <table align = "center" cellspacing= "1" cellpadding= "2" bgcolor ="#e6f6e6" >
  <tr >
   <td width="1000px" colspan = "7" style=" color: blue; border: solid 1px green;" >
   <b>&nbsp;연
   <select id = "syear" onchange= "year_onchange()" >
    <option ></option >
    </select ></b>
    <b>&nbsp;월
    <select   id= "smonth" onchange= "month_onchange()"  >
     <option ></option >
    </select ></b>
    <b>&nbsp;카테고리
    <select   id= "scate" onchange= "cate_onchange()"  >
	 <option >AA</option>
     <option >AB</option>
     <option >AC</option>
    </select ></b><br>
    <div align="center" style="color:red; font-size:100px;"> <%=cate==null?"AA":cate %> 식단표
    </div>
   </td>
  
  </table >
  
  <table width = "1000px"  align = "center" cellspacing= "1" cellpadding= "2" bgcolor ="#cccccc" >
   <tr align = "center" height = "30px">
     <td bgcolor = "#e6e4e6" width="100"  style=" color: red;" > 일</td >
     <td bgcolor = "#e6e4e6" width="100" > 월 </td >
     <td bgcolor = "#e6e4e6" width="100" > 화 </td >
     <td bgcolor = "#e6e4e6" width="100" > 수 </td >
     <td bgcolor = "#e6e4e6" width="100" > 목 </td >
     <td bgcolor = "#e6e4e6" width="100" > 금 </td >
     <td bgcolor = "#e6e4e6" width="100"  style=" color: blue;" > 토  </td>
    
   </tr >
   <%
      int newLine=0;
      out.print( "<tr>");
     
	//해당 달의 메뉴리스트
      ArrayList<Map<String,String>> list = (ArrayList<Map<String,String>>)request.getAttribute("menu");
      
	//시작하는 요일까지 빈칸출력
      for(i=1; i<week; i++)
      {
       out.print( "<td width='100' height='100' bgcolor='#eee'>&nbsp;</td>");
       newLine++;
      }
     
     //1일부터 마지막날까지 달력출력
		for(i=startDay; i<endDay; i++)
		{		

			//공휴일 스타일
       		String fontColor=(newLine==0)?
                "red":(newLine==6)? "blue": "black";
       		String bgColor=(nowYear==year)&&(nowMonth==month)
                &&(nowDay==i)? " #0a0": "#fff";

 			//날짜별 메뉴데이터     	  
			String data = "";
   	        String caca = "";
 			
		if( list!= null ) {
				for(j=0; j<list.size(); j++	){
		 		  
					String menuMonth = (String)list.get(j).get("menu_month");
					//System.out.println(Integer.parseInt(menuMonth));
					if( Integer.parseInt(menuMonth)==i){
						data += list.get(j).get("menu_category_id");
						caca = list.get(j).get("menu_category_id");
						data += "<br>";
						data += list.get(j).get("prod_name");
						data += "<br>";
					}
				}	
			} 
			//메뉴가 있으면 수정, 없으면 등록버튼
			if( data.isEmpty()){
				data += "<br><input type = 'button' id = inn value = '등록' onclick = 'regist("+i+")'>";
				//nowYear,nowMonth,i
				
			} else{
				data += "<br><input type = 'button' id = upp value = '수정' onclick = 'update("+i+")'>";
				//data += "<input type = 'button' id = del value = '삭제' onclick = 'dele("+i+")'>";
			}


       
			out.print( "<td width='100' height='100' bgcolor="+bgColor+ "><font color="+fontColor+ ">"
	    		   +i+"<br>"
	    		   +data   
				   +"</font></td>" );
			newLine++;
     
           if(newLine ==7 &&i!=endDay)
           {
            out.print( "</tr><tr>" );
            newLine=0;
           }
      }
	// 날짜 없는곳 회색처리
     while(newLine>0 && newLine<7)
     {
      out.print( "<td width='100' height='100' bgcolor='#eee'>&nbsp;</td>");
      newLine++;
     }
     out.print( "</tr>");
      
   %>
</table>
</body>
</html>