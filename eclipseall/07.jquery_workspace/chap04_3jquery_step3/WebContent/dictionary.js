//�� �Լ��� ȣ��Ǵ� ���� ���� �� ����Ÿ ����� ���� �ڵ� �κ� Ȯ�� 

/*  $(this).fadeIn();
 * 1. �ε�� �����Ͱ� ���ڱ� ��Ÿ�����ʰ� ���������� ��Ÿ������ ������ �ڵ�
 * 2. ������ �ε尡 �Ϸ�� ������ ����ǵ��� �ϱ� ���� load()�� ���� �ݹ鿡�� ȣ��
 * 3. �ٽ�
 * 	a. letter-a�� ���� tag�� a ��Ŀ tag�� click �߻��� ����Ǵ� �Լ�
 *  b. Ŭ���ϸ� a.html ������ ������ ����
 *  
 * 4. a.html ������ Ȯ�� 
 * 	- �Ϻ��� html ����
 *  - a.html�� read�ؼ� ������ ����Ÿ ���� ������ ��� �� 
 *  
 * 5. ���� a.html�� ����
 * - index.html���� A �κ��� Ŭ���ϸ� body�κ� �Ϻο� ��µǴ� 
 *   html ���� ���� start html tag���� �ߺ� ���� ���ʿ� */
$(document).ready(function() {
  $("#letter-a a").click(function() {
    $('#dictionary').hide().load('a.html', function() {
      $(this).fadeIn();
    });   
  });
});

/* ���� ȭ���� 'B' �޴� Ŭ���� �ڵ� ȣ��Ǵ� ����� �����Լ�
 * 1. ���� ����Ÿ ���� = json
 * 2. ������ �������� ����ϼž� �� ����
 * 	a. json����Ÿ �Ľ�(������
 * 		 ������ JSON ����Ÿ�� �ڹٽ�ũ������ Ȱ���Ͻñ� ���� ��üȭ
 * 		 jQury( $.getJSON �Լ�), �Ϲ� �ڹٽ�ũ��Ʈ�� ��� eval()
 *  b. ����� ����Ÿ�� JSON ������ ������ ������?
 *  	 json ���� �����ÿ��� ���� �޼����� �����ϰ� �������� ���� 
 * 3. ���� ����
 * 	- ȭ�� clear
 *  - ��Ī �� ��Ȯ�� ����Ÿ�� ��Ȯ�� ��ġ�� ���
 *  ���� ��� - 
 *  jQuery�� .each()(json������ ��ȯ�� ���鼭 �ݺ���Ű�� �Լ�)Ȱ���ϸ鼭
 *  json����Ÿ�� ��Ȯ�� ��Ī���� �ش絥��Ÿ ���� �� ��
 *  ��Ȯ�� ��� ��ġ�� ����� ���ؼ� html tag ��ü�� ����(����)  
 *   */
$(document).ready(function() {
  $('#letter-b a').click(function() {
    $.getJSON('b.json', function(data) {
      $('#dictionary').empty();//id���� dictionary �κ� clear
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

/* ���� ��ü�� �̹� �Ϻ��ϰ� ������ js������� getScript �Լ� ��븸����
 * ��� ���� ó�� ���� */
$(document).ready(function() {
  $('#letter-c a').click(function() {
    $.getScript('c.js');
    return false;
  });
});

/* xml����Ÿ�� ����޾Ƽ� ����ϴ� �Լ�
 * ������ �������
 * 1. parsing �ʼ�
 * 2. tag�� �ش� ����Ÿ ���� -> ��Ȯ�� ��ġ�� ���   */
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
        html += $entry.find('definition').text();//definition tag�� ������ text�� ��ȯ
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

/* ��û�� ó���� ǥ�� �Լ�
 * 1. ajaxStart�Լ� - Ajax ��û�� ���۵ǰ� �����͸� �����ϱ� �ٷ� ���� ����
 * 2. ajaxStop�Լ� - ��û�� ������ ���� ȣ��
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

/* ����ڰ� �ܾ click������ definition Ŭ������ ���� �����
 * ���� ��Ҹ� ã�� �������� �Ǵ� �Ʒ������� �����̵� ��Ű�� ��� 
 * .live() - ���������� �߻��Ǵ� ��� click�� ����
 * �ϴ� ���� - .term �̶�� css �����ڰ� ����� tag Ŭ���� sliding
 * */
$(document).ready(function() {
  $('.term').live('click', function() {
    $(this).siblings('.definition').slideToggle();
  });
});
