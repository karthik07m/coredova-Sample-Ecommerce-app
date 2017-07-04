(function ($) {
    $.fn.slideshow = function (options) {
        options = $.extend({
            slides: ".slide",
            speed: 3000,
            easing: "linear"

        }, options);

        var timer = null;
        var index = 0;

        var slideTo = function (slide, element) {
            var $currentSlide = $(options.slides, element).eq(slide);

            $currentSlide.stop(true, true).
			animate({
			    opacity: 1
			}, options.speed, options.easing).
			siblings(options.slides).
			css("opacity", 0);

        };

        var autoSlide = function (element) {
            timer = setInterval(function () {
                index++;
                if (index == $(options.slides, element).length) {
                    index = 0;
                }
                slideTo(index, element);
            }, options.speed);
        };

        var startStop = function (element) {
            element.hover(function () {
                clearInterval(timer);
                timer = null;
            }, function () {
                autoSlide(element);
            });
        };

        return this.each(function () {
            var $element = $(this),
				$previous = $(options.previous, $element),
				$next = $(options.next, $element),
				index = 0,
				total = $(options.slides).length;

            $(options.slides, $element).each(function () {
                var $slide = $(this);
                var image = $slide.data("image");
                $slide.css("backgroundImage", "url(" + image + ")");
            });

            autoSlide($element);
            startStop($element);

        });
    };

    $(function () {
        $("#main-slider").slideshow();

    });

})(jQuery);
