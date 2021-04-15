# SpringWorks
<h2><a href="https://github.com/2everlove/SpringWork1/tree/main/ex00">ex00</a></h2>
<p><a href="https://github.com/2everlove/SpringWork1/blob/main/ex00/pom.xml" target="_blank">pom.xml</a> setting, <a href="https://github.com/2everlove/SpringWork1/blob/main/ex00/src/main/webapp/WEB-INF/spring/root-context.xml" target="_blank">root-context.xml(Connection Pool, My Batis)</a>, <a href="https://github.com/2everlove/SpringWork1/blob/main/ex00/src/test/java/org/zerock/persistence/DataSourceTests.java" target="_blank">persistence test</a></p>
<br>
<br>
<h2><a href="https://github.com/2everlove/SpringWork1/tree/main/controller">control</a> & <a href="https://github.com/2everlove/SpringWork1/tree/main/Exception">exception</a></h2>
<p><ol><li><a href="https://github.com/2everlove/SpringWork1/tree/main/controller/src/main/java/jmp/spring/VO">controller에서 사용할 Object생성</a></li>
 <li><a href="https://github.com/2everlove/SpringWork1/blob/main/controller/src/main/java/jmp/spring/contol/MainController.java">MainCotnroller</a><ul><li>@RequestMapping은 class나 method에 사용가능</li><li>@Get,PostMapping은 method에서 사용가능</li><li>void형태에 걸려있는 Mapping인 경우에는 Mapping에서 설정된 path로 이동</li><li>String형태에 걸려있는 Mapping인 경우 return "path";의 path로 이동</li><li>param을 꼭 입력 받고 싶으면 void method(@RequestParam("value") String value)의 형태로 받음</li><li>Model은 화면단으로 데이터를 전송할 때 wrapper개념으로 쓰임</li><li>redirect:/path 와 forward:/path에서 redirect는 다시 불러오는 반면, forward는 화면을 유지한 상태에서 불러오기에 보안에 취약함</li></ul></li>
 <li>fileupload
  <ul><li><a href="https://github.com/2everlove/SpringWork1/blob/main/controller/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml">file-upload를 위한 servlet-context.xml setting</a></li><li><a href="https://github.com/2everlove/SpringWork/blob/main/controller/src/main/java/jmp/spring/contol/MainController.java">file-upload를 위한 method작성</a>@Get방식으로 들어오는지 @Post방식으로 들어오는지에 따라서 작동하는 method가 다름</li><li><a href="https://github.com/2everlove/SpringWork1/blob/main/controller/src/main/webapp/WEB-INF/views/fileUpload.jsp">file-upload를 수행할 jsp파일 작성</a></li>
 </ul></li>
 <li>exception
    <ul><li><a href="https://github.com/2everlove/SpringWork1/blob/main/Exception/src/main/webapp/WEB-INF/web.xml">web.xml</a>을 통해서 tomcat의 설정에서 404error가 발생하면 지정한 page로 이동하게 설정, 그 외의 error가 web.xml에 잡히면 error-page에 전송하기 위해 아래와 같은 설정을 함</a></li>
 <li><a href="https://github.com/2everlove/SpringWork1/blob/main/Exception/src/main/java/jmp/spring/exception/CommonExceptionAdvice.java">@ExceptionHandler</a>를 설정하여, 발생하는 error를 model에 담아서 지정한 error-page의 화면단으로 전송한다.</li></ul></li>
</ol></p>
<br>
<br>
<h2><a href="https://github.com/2everlove/dbWorks/tree/main/spring">DB</a> & <a href="https://github.com/2everlove/SpringWork1/blob/main/board/src/main/resources/jmp/spring/mapper/BoardMapper.xml">Mapper</a></h2>
<p><ol>
 <p><strong>DB</srong>
 <li><a href="https://github.com/2everlove/dbWorks/blob/main/spring/newuser.sql">DB를 사용하기 앞서서 프로젝트에서 사용할 oracle developer 계정 생성</a></li>

 <li><a href="https://github.com/2everlove/dbWorks/blob/main/spring/boardReply.sql">CREATE TABLE</a></li>
  <p><table>
   <tr><th colspan=5>TBL_BOARD</th></tr>
   <tr><th>column</th><th>type</th><th>NOT NULL</th><th>key</th><th>value</th></tr>
   <tr><td>bno</td><td>NUMBER(10)</td><td>O</td><td>PK</td><td>-</td></tr>
   <tr><td>title</td><td>VARCHAR2(200)</td><td>O</td><td>-</td><td>-</td></tr>
   <tr><td>content</td><td>VARCHAR2(2000)</td><td>O</td><td>-</td><td>-</td></tr>
   <tr><td>wirter</td><td>VARCHAR2(50)</td><td>O</td><td>-</td><td>-</td></tr>
   <tr><td>regdate</td><td>DATE</td><td>-</td><td>-</td><td>SYSDATE</td></tr>
   <tr><td>updatedate</td><td>DATE</td><td>-</td><td>-</td><td>-</td></tr>
  </table>
 </P>
 <li><a href="https://github.com/2everlove/dbWorks/blob/main/spring/boardReply.sql">CREATE SEQUENCE</a></li>
 </p>
 <p><storngMapper</strong>

</p>
 
 
 
 </ol></p>
 
 
<br>
<hr>
<p>Configuration
 <ul>
  <li>STS 3.9.11</li>
  <li>apache-tomcat-9.0.43</li>
  <li>oracle DBMS 11g</li>
 </ul>
</p>
