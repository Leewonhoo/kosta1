$(document).ready(function() {
  $('.books').hide();
  $('.movies').hide();
  $('.music').hide();

  $('#booksbutton').click(function(){
    $('.books').show('slow');
    $('.movies').hide();
    $('.music').hide();
  });

  $('#moviesbutton').click(function(){
    $('.movies').show('slow');
    $('.books').hide();
    $('.music').hide();
  });

  // TODO : musicbutton Å¬¸¯½Ã 
  $('#musicbutton').click(function(){
	    $('.music').show(2000);
	    $('.movies').hide();
	    $('.books').hide();
	  });
 });
