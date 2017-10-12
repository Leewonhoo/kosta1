/*  버튼 클릭 이벤트  */
/*
$(document).ready(function() {
	// bind(이벤트타입, 이벤트핸들러전달데이터, 이벤트핸들러함수)
	// 이벤트타입 : click, dblclick, focus, blur, mouseover

  $('.button-1').bind('click', function(){
    alert('You have clicked the Button-1');
  });

  $('.button-2').bind('click', function(){
    alert('You have clicked the Button-2');
  });
  
  // TODO : click(handler) 
  $(".button-3").click(function(){
	  alert("You have clicked the Button-3");
  });	  

  // TODO :  모든 button에 click, double-click event 
//  $('.buttons').bind('dblclick', function(){
//    alert('You have clicked the ' + $(this).text());
//  });
  
 });
*/

//## 이벤트 객체의 target 속성 : 클릭 이벤트를 발생시킨 엘리먼트 검색시사용
//## 자바스크립트는 이벤트를 발생시킨 이벤트 객체를 이벤트 처리함수에 전달해줌
//## 더블클릭 이벤트 : dblclick()
//  TODO : 
/*
$(document).ready(function() {
	$('.buttons').bind('dblclick', function(event){ // 이벤트객체를 넘겨받음
		var $target = $(event.target);
		if ($target.is('.button-1')) {
			alert("button-1 double-clieked");
		};
		if ($target.is('.button-2')) {
			alert("button-2 double-clieked");
		};		
		if ($target.is('.button-3')) {
			alert("button-3 double-clieked");
		};		
	});	
});
*/

//## 자동으로 이벤트 발생
// trigger('이벤트타입');
//TODO : 
/*
$(document).ready(function() {
  $('.buttons').bind('click', function(){
	  alert('You have clicked the ' + $(this).text());
  });
  // 자동으로 .button-3 이벤트를 발생시켜보죠 ==> popup 성격으로 활용
  $('.button-3').trigger('click');
});
*/

/* 버튼 누른 후 비활성화 시키기 
 * unbind(이벤트타입, bind()에전달했던이벤트핸들러)
 * unbind(이벤트타입) : 해당이벤트 제거
 * unbind() : 모든 이벤트 제거
 */
//TODO : 
$(document).ready(function() {
  $('.dbuttons').bind('click', function(){
	  alert('You have clicked the ' + $(this).text() + ' button aftef disabled button');
	  // 이벤트를 발생시킨 객체에 대해서 비활성화시키자
	  $('.dbuttons').unbind('click');
	  // 비활성화 시킨 버튼에대해서 css .setDisabled 스타일 적용 변경
	  $('.dbuttons.').addClass('setDisabled');
  });
});
















