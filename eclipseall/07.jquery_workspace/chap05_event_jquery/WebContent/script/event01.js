/*  ��ư Ŭ�� �̺�Ʈ  */
/*
$(document).ready(function() {
	// bind(�̺�ƮŸ��, �̺�Ʈ�ڵ鷯���޵�����, �̺�Ʈ�ڵ鷯�Լ�)
	// �̺�ƮŸ�� : click, dblclick, focus, blur, mouseover

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

  // TODO :  ��� button�� click, double-click event 
//  $('.buttons').bind('dblclick', function(){
//    alert('You have clicked the ' + $(this).text());
//  });
  
 });
*/

//## �̺�Ʈ ��ü�� target �Ӽ� : Ŭ�� �̺�Ʈ�� �߻���Ų ������Ʈ �˻��û��
//## �ڹٽ�ũ��Ʈ�� �̺�Ʈ�� �߻���Ų �̺�Ʈ ��ü�� �̺�Ʈ ó���Լ��� ��������
//## ����Ŭ�� �̺�Ʈ : dblclick()
//  TODO : 
/*
$(document).ready(function() {
	$('.buttons').bind('dblclick', function(event){ // �̺�Ʈ��ü�� �Ѱܹ���
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

//## �ڵ����� �̺�Ʈ �߻�
// trigger('�̺�ƮŸ��');
//TODO : 
/*
$(document).ready(function() {
  $('.buttons').bind('click', function(){
	  alert('You have clicked the ' + $(this).text());
  });
  // �ڵ����� .button-3 �̺�Ʈ�� �߻����Ѻ��� ==> popup �������� Ȱ��
  $('.button-3').trigger('click');
});
*/

/* ��ư ���� �� ��Ȱ��ȭ ��Ű�� 
 * unbind(�̺�ƮŸ��, bind()�������ߴ��̺�Ʈ�ڵ鷯)
 * unbind(�̺�ƮŸ��) : �ش��̺�Ʈ ����
 * unbind() : ��� �̺�Ʈ ����
 */
//TODO : 
$(document).ready(function() {
  $('.dbuttons').bind('click', function(){
	  alert('You have clicked the ' + $(this).text() + ' button aftef disabled button');
	  // �̺�Ʈ�� �߻���Ų ��ü�� ���ؼ� ��Ȱ��ȭ��Ű��
	  $('.dbuttons').unbind('click');
	  // ��Ȱ��ȭ ��Ų ��ư�����ؼ� css .setDisabled ��Ÿ�� ���� ����
	  $('.dbuttons.').addClass('setDisabled');
  });
});
















