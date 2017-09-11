

function scroll_to(clicked_link, nav_height) {
	var element_class = clicked_link.attr('href').replace('#', '.');
	var scroll_to = 0;
	if(element_class != '.top-content') {
		element_class += '-container';
		scroll_to = $(element_class).eq(1).offset().top - nav_height;
	}
	if($(window).scrollTop() != scroll_to) {
		$('html, body').stop().animate({scrollTop: scroll_to}, 1000);
	}
}

$(document).ready(function() {
	/*
    Navigation
	*/
	$('a.scroll-link').on('click', function(e) {
		console.log($('.nav-landing').eq(2).outerHeight());
		scroll_to($(this), $('.nav-landing').eq(1).outerHeight());
	});
	
	// toggle "navbar-no-bg" class
	$(window).on('scroll', function(){
		if($(document).scrollTop() > $('nav').css('height').split('px')[0]){
			$('nav').removeClass('navbar-no-bg');
		} else {
			$('nav').addClass('navbar-no-bg');
		}
	});
    
	$('body').on('click', '.project-view-more', function(e){
		$('body').css("overflow", "hidden");
		$('.project-single').css("top", $(window).scrollTop());
		$('.project-single').css("overflow", "auto");
		//$('.project-single').fadeIn();
		$('.project-gallery').fadeOut();
		e.preventDefault();
	});
	
	/*$('body').on('click', '.presentation a', function(e){
		e.preventDefault();
	});*/
	
	$('body').on('click', '.project-single-tools a', function(e){
		$('body').css("overflow", "auto");
		$('.project-single').fadeOut();
		$('.project-gallery').fadeOut();
		
		e.preventDefault();
	});

	$('body').on('click', '.img-gallery-item', function(){
		$('.img-main').attr('href', ($(this).find('img').attr('src')));
		$('.img-main img').attr('src', ($(this).find('img').attr('src')));
	});

    /*
        Wow
    */
    new WOW().init();
   
    /*
     * Single Project Gallery
     */
    
    $('body').on('mouseenter', '.img-main-container', function(){
    	$('.img-main-container-overlay').fadeIn();
    });
    
    $('body').on('mouseleave', '.img-main-container', function(){
    	$('.img-main-container-overlay').fadeOut();
    });
    
    $('.project-view-more').on('click', function(){
    	alert('test');
    });
    
    /*
     * MISC
     */
	
});

