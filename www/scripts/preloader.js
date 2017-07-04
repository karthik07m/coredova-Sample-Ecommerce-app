$(window).on('load', function () { 
    $('#status').fadeOut(); 
    $('#preloader').delay(300).fadeOut('fast'); 
    $('body').delay(300).css({ 'overflow': 'visible' });
})