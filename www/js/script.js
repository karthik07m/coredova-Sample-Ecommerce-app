$(window).load(function() { 
	 
	$('#status').delay(300).fadeOut(); 
	$('#preloader').delay(300).fadeOut('slow');
	$('body').delay(550).css({'overflow':'visible'});
})

$(document).ready(function() {
		
		$(".navbar-brand").hover(function () {
			$(this).toggleClass("animated shake");
		});
		
		
		$(".img_scroll").hover(function () {
			$(this).toggleClass("animated infinite bounce");
		});
});

