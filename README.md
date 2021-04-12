# SpringWorks
<h2><a href="https://github.com/2everlove/SpringWork1/tree/main/ex00">ex00</a></h2>
<p><a href="https://github.com/2everlove/SpringWork1/blob/main/ex00/pom.xml" target="_blank">pom.xml</a> setting, <a href="https://github.com/2everlove/SpringWork1/blob/main/ex00/src/main/webapp/WEB-INF/spring/root-context.xml" target="_blank">root-context.xml(Connection Pool, My Batis)</a>, <a href="https://github.com/2everlove/SpringWork1/blob/main/ex00/src/test/java/org/zerock/persistence/DataSourceTests.java" target="_blank">persistence test</a></p>
<br>
<br>
<h2><a href="https://github.com/2everlove/SpringWork/tree/main/controller">control</a></h2>
<p><ol><li><a href="https://github.com/2everlove/SpringWork/tree/main/controller/src/main/java/jmp/spring/VO">controller에서 사용할 Object생성</a></li>
 <li><a href="https://github.com/2everlove/SpringWork/blob/main/controller/src/main/java/jmp/spring/contol/MainController.java">MainCotnroller</a><ol><li>@RequestMapping은 class나 method에 사용가능</li><li>@Get,PostMapping은 method에서 사용가능</li><li>void형태에 걸려있는 Mapping인 경우에는 Mapping에서 설정된 path로 이동</li><li>String형태에 걸려있는 Mapping인 경우 return "path";의 path로 이동</li><li>param을 꼭 입력 받고 싶으면 void p(@RequestParam("value") String value)의 형태로 받음</li><li>Model은 화면단으로 데이터를 전송할 때 wrapper개념으로 쓰임</li><li>redirect:/path 와 forward:/path의 차이는 redirect는 다시 불러오는 반면, forward는 화면을 유지한 상태에서 불러오기에 보안에 취약함</li></ol>></li>
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
