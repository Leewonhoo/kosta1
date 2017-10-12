//각 함수를 호출되는 실행 시점 및 데이타 출력을 위한 코드 부분 확인 

/*  $(this).fadeIn();
 * 1. 로드된 데이터가 갑자기 나타나지않고 점진적으로 나타나도록 적용한 코드
 * 2. 데이터 로드가 완료된 시점에 실행되도록 하기 위해 load()에 대한 콜백에서 호출
 * 3. 핵심
 * 	a. letter-a의 서브 tag중 a 엥커 tag에 click 발생시 실행되는 함수
 *  b. 클릭하면 a.html 파일이 서서히 오픈
 *  
 * 4. a.html 구조를 확인 
 * 	- 완벽한 html 구조
 *  - a.html값 read해서 별도의 데이타 가공 로직은 없어도 됨 
 *  
 * 5. 참고 a.html의 내용
 * - index.html에서 A 부분을 클릭하면 body부분 일부에 출력되는 
 *   html 조각 문서 start html tag등은 중복 선언 불필요 */
$(document).ready(function() {
  $("#letter-a a").click(function() {
    $('#dictionary').hide().load('a.html', function() {
      $(this).fadeIn();
    });   
  });
});

/* 메인 화면의 'B' 메뉴 클릭시 자동 호출되는 사용자 정의함수
 * 1. 응답 데이타 포멧 = json
 * 2. 개발자 관점에서 고려하셔야 할 사항
 * 	a. json데이타 파싱(서버가
 * 		 전송한 JSON 데이타를 자바스크립에서 활용하시기 위한 객체화
 * 		 jQury( $.getJSON 함수), 일반 자바스크립트인 경우 eval()
 *  b. 응답된 데이타의 JSON 형식이 문제가 없더냐?
 *  	 json 포멧 에러시에는 에러 메세지를 명쾌하게 보여주지 않음 
 * 3. 개발 순서
 * 	- 화면 clear
 *  - 애칭 별 정확한 데이타를 정확한 위치에 출력
 *  최종 결론 - 
 *  jQuery의 .each()(json문서를 순환해 가면서 반복시키는 함수)활용하면서
 *  json데이타의 정확한 애칭으로 해당데이타 발췌 한 후
 *  정확한 출력 위치에 출력을 위해서 html tag 자체를 생성(구성)  
 *   */
$(document).ready(function() {
  $('#letter-b a').click(function() {
    $.getJSON('b.json', function(data) {
      $('#dictionary').empty();//id값이 dictionary 부분 clear
      $.each(data, function(entryIndex, entry) {
        var html = '<div class="entry">';
        html += '<h3 class="term">' + entry['term'] + '</h3>';
        html += '<div class="part">' + entry['part'] + '</div>';
        html += '<div class="definition">';
        html += entry['definition'];
        if (entry['quote']) {
          html += '<div class="quote">';
          $.each(entry['quote'], function(lineIndex, line) {
            html += '<div class="quote-line">' + line + '</div>';
          });
          if (entry['author']) {
            html += '<div class="quote-author">' + entry['author'] + '</div>';
          }
          html += '</div>';
        }
        html += '</div>';
        html += '</div>';
        $('#dictionary').append(html);
      });
    });
    return false;
  });
});

/* 응답 자체가 이미 완벽하게 구현된 js구조라면 getScript 함수 사용만으로
 * 모든 응답 처리 가능 */
$(document).ready(function() {
  $('#letter-c a').click(function() {
    $.getScript('c.js');
    return false;
  });
});

/* xml데이타를 응답받아서 출력하는 함수
 * 개발자 고려사항
 * 1. parsing 필수
 * 2. tag별 해당 데이타 착출 -> 정확한 위치에 출력   */
$(document).ready(function() {
  $('#letter-d a').click(function() {
    $.get('d.xml', function(data) {
      $('#dictionary').empty();
      $(data).find('entry:has(quote[author])').each(function() {
        var $entry = $(this);
        var html = '<div class="entry">';
        html += '<h3 class="term">' + $entry.attr('term') + '</h3>';
        html += '<div class="part">' + $entry.attr('part') + '</div>';
        html += '<div class="definition">';
        html += $entry.find('definition').text();//definition tag가 보유한 text값 반환
        var $quote = $entry.find('quote');
        if ($quote.length) {
          html += '<div class="quote">';
          $quote.find('line').each(function() {
            html += '<div class="quote-line">' + $(this).text() + '</div>';
          });
          if ($quote.attr('author')) {
            html += '<div class="quote-author">' + $quote.attr('author') + '</div>';
          }
          html += '</div>';
        }
        html += '</div>';
        html += '</div>';
        $('#dictionary').append($(html));
      });
    });
    return false;
  });
});

/* 요청이 처리중 표시 함수
 * 1. ajaxStart함수 - Ajax 요청이 시작되고 데이터를 전달하기 바로 전에 실행
 * 2. ajaxStop함수 - 요청이 끝나기 전에 호출
 */
$(document).ready(function() {
  $('<div id="loading">Loading...</div>')
    .insertBefore('#dictionary')
    .ajaxStart(function() {
      $(this).show();
    }).ajaxStop(function() {
      $(this).hide();
    });
});

/* 사용자가 단어를 click했을때 definition 클래스를 가진 요소의
 * 형제 요소를 찾아 위쪽으로 또는 아래쪽으로 슬라이드 시키는 기능 
 * .live() - 브라우저에서 발생되는 모든 click을 감지
 * 하단 로직 - .term 이라는 css 선택자가 적용된 tag 클릭시 sliding
 * */
$(document).ready(function() {
  $('.term').live('click', function() {
    $(this).siblings('.definition').slideToggle();
  });
});
