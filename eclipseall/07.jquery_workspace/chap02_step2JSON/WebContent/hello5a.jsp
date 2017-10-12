<%@ page contentType="application/javascript;charset=utf-8" %>
<%@ page import="java.util.*" %> 
<%@ page import="net.sf.json.*" %> 

<%
/* 
## client가 입력한 데이타를 서버프로그램이 획득시 사용 메소드
	request.getParameter("form의 name이름");
	JSON  사이트에서 지원하는 library들 활용시에는 getParameter가 아님

## 개발 방법
1. 2byte 단위로 데이타를 read할수 있는 데이타 입출력(스트림) 객체로 부터 Stirng 변수 획득
2. JSONObject 객체를 stream을 기반으로 획득한 String객체를 대입하면서 생성
3. 그 이후에 get("form 애칭명") 으로 데이타값 획득 : 
	(see: hello5a.html#window.onload = function(){})
	var name = $('helloTxt').value;		// 클라이언트 입력데이터(이름) 추출
	postBody:JSON.stringify({name:name})
*/ 
String json = request.getReader().readLine();
JSONObject jsonObj = JSONObject.fromObject(json); 
String name = (String)(jsonObj.get("name"));

/*
## name.substring(0,1).toUpperCase() 분석
1. name은 client가 입력한 데이타 보유 변수
2. substring(0,1) :  name변수가 보유하고 있는 문자열의 index 0부터 두번째 인자 위치의 전까지의 음절을 반환
3. 모든 문자열 대문자로 변환
	영어 철자를 의미하는 원서 표현 = case
	LowerCase = 소문자
	UpperCase = 대문자
*/ 
jsonObj.put("initial", name.substring(0,1).toUpperCase());	//"initial":"대문자한음절"

String[] likes = new String[]{ "JavaScript", "Skiing", "Apple Pie" };
jsonObj.put("likes", likes);			//"likes":["JavaScript","Skiing","Apple Pie"]

Map<String, String> ingredients=new HashMap<String, String>();		//key, value 쌍으로 매핑해서 저장할수 있는 자바 객체
ingredients.put("apples","3kg");
ingredients.put("sugar","1kg");
ingredients.put("pastry","2.4kg");
ingredients.put("bestEaten","outdoors");
// System.out.println(ingredients);  // {apples=3kg, pastry=2.4kg, bestEaten=outdoors, sugar=1kg}

jsonObj.put("ingredients", ingredients);
/* "ingredients":{"apples":"3kg","sugar":"1kg","bestEaten":"outdoors","pastry":"2.4kg"}*/

System.out.println("값 확인 " + jsonObj);
%>

<%= jsonObj %>

<%--
서버 관점에서 고려하셔야 할 사항
1. client가 입력한 데이타 첫 음절만 발췌-> 대문자로 변환
	
2. 최종 브라우저 화면에 보여지는 데이타값들을 서버에서 출력
	1. JSON 포멧 선정
	2. 데이타의 정확한 매핑 필수
	   - key, value 쌍으로 관리하는 타입(map)  선정
	3. 자바 타입을 JSON 타입으로 변화시켜서 출력
		-JSONlib 단순 활용 
		- JSONObject 객체에 map계열의 자바 객체를 put 
		- 즉, JSONObject에 저장해서 브라우저 출력만 하시면 끝


## jsp에서 자바 객체의 내용을 json 구조로 변환후 출력한 응답 내용
{	"name":"브라우저에서 입력한 데이타값",	
	"initial":"브라우저에서 입려간 데이타값의 첫 음절만 대문자화한 데이타",	
	"likes":["JavaScript","Skiing","Apple Pie"],
	"ingredients":{"apples":"3kg","sugar":"1kg","bestEaten":"outdoors","pastry":"2.4kg"}
}
--%>