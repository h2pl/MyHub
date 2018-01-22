/* -------------------------------------------------------------------------------- /

    +----------------------------------------------------+
        TABLE OF CONTENTS
    +----------------------------------------------------+
    
    [2]     Initialize Boostrap
    [3]     Main Menu
    [4]     Smooth Scroll to Section
    [5]     Sticky Nav Bar
    
/ -------------------------------------------------------------------------------- */

var apclk = jQuery;
apclk.noConflict();

/* ---------------------------------------------------
    Main Menu
-------------------------------------------------- */


apclk('.navbar .dropdown').hover(function() {
    apclk(this).addClass('open').find('.dropdown-menu').first().stop(true, true).slideDown(300);
}, function() {
    apclk(this).removeClass('open').find('.dropdown-menu').first().stop(true, true).hide(300);
});

apclk('.navbar .dropdown > a').on('click', function() {
    location.href = this.href;
});


apclk(document).on('click', '.apclk-nav .dropdown-menu', function(e) {
    e.stopPropagation()
})


/* ---------------------------------------------------
    Smooth Scroll to Section
-------------------------------------------------- */

apclk(function() {

    apclk('a.smooth-scroll[href*=#]:not([href=#])').on('click',function() {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

            var target = apclk(this.hash);
            target = target.length ? target : apclk('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                apclk('html,body').animate({
                    scrollTop: target.offset().top
                }, 2000, 'easeInOutExpo');
                return false;
            }
        }
    });

/* ---------------------------------------------------
    Sticky Bar
-------------------------------------------------- */

    apclk(".header-main").stickOnScroll({
        topOffset: 0,
        setParentOnStick: true
    });

    var shrinkHeader = 600;
    apclk(window).scroll(function() {
        var scroll = getCurrentScroll();
        if (scroll >= shrinkHeader) {
            apclk('.header-main').addClass('shrink');
            apclk('.navbar-toggle').css({ "top": "10px", "background-color": "#fff", "color": "#777" });
        } else {
            apclk('.header-main').removeClass('shrink');
            apclk('.navbar-toggle').css({ "top": "30px", "background-color": "transparent", "color": "#777" });
        }
    });

    function getCurrentScroll() {
        return window.pageYOffset || document.documentElement.scrollTop;
    }

});

// -------------------------- Progress Bar ----------

apclk(document).ready(function() {

    apclk('.progress .progress-bar').css("width",
        function() {
            return apclk(this).attr("aria-valuenow") + "%";
        }
    )

    // SUBMIT FORM USING AJAX
    apclk("form#contact-form,form#contact-form-2").on("submit", function(event) {
        // Stop the browser from submitting the form.
        event.preventDefault();
        // Serialize the form data.
        var formData = apclk("#contact-form").serialize();

        // Submit the form using AJAX.
        apclk.ajax({
            type: 'POST',
            url: apclk("#contact-form").attr('action'),
            data: formData,
            success: function(response) {
                apclk("p.form-status").addClass("text-success");
                apclk("p.form-status").html(response);
                jQuery('#contact-form').trigger("reset");
            },
            error: function(data) {
                apclk("p.form-status").addClass("text-danger");
                apclk("p.form-status").html("Ooopssss ! There is some error in sending mail.");
            }
        });
    });


    // Date Picker : Appointment
    if (apclk('#datePicker').length > 0) {
        apclk('#datePicker')
            .datepicker({
                format: 'dd/mm/yyyy',
                todayBtn: "linked",
                autoClose: true
            })

    }


    // Lightbox Gallery
    if (apclk('.gallery-images').length > 0) {

        apclk(function() {

            apclk('.about-cottage-gallery a.lightbox-about-cottage').lightbox();
            apclk('.gallery-images a.lightbox-bedrooms').lightbox();
            apclk('.gallery-images a.lightbox-livingrooms').lightbox();
            apclk('.gallery-images a.lightbox-kitchen').lightbox();
            apclk('.gallery-images a.lightbox-bathroom').lightbox();
            apclk('.gallery-images a.lightbox-swimming').lightbox();
        });
    }


    // Slider
    if (apclk('#slider .detail-content').length > 0) {
        var sliderObj;
        isMobile = navigator.userAgent.match(/(iPhone|iPod|Android|BlackBerry|iPad|IEMobile|Opera Mini)/);

        sliderObj = apclk('#bottom-sec').bxSlider({
            mode: 'horizontal',
            pager: false,
            controls: true,
            auto: false,
            speed: 400,
            easing: 'easeInExpo',
            infiniteLoop: true,
            useCSS: false
        });

        apclk('.top-banner').bxSlider({
            mode: 'horizontal',
            pager: false,
            speed: 1000,
            easing: 'fade',
            onSliderLoad: function() {
                apclk('.top-row strong').css('display', 'none');
                apclk('.top-row strong').eq(0).css('display', 'block');

            },
            onSlideNext: function(currentSlideNumber, totalSlideQty, currentSlideHtmlObject) {

                sliderEffect(currentSlideHtmlObject);
                apclk('.detail .bx-next').trigger('click');

            },
            onSlidePrev: function(currentSlideNumber, totalSlideQty, currentSlideHtmlObject) {

                sliderEffect(currentSlideHtmlObject);
                apclk('.detail .bx-prev').trigger('click');
            }
        });

        function sliderEffect(index) {
            apclk('.top-row strong').eq(index).fadeIn(1000);
            apclk('.top-row strong').eq(index).siblings('strong').fadeOut(1000);
        }

        apclk('.prv').on('click', function() {
            apclk('.bx-prev').trigger('click');
        });

        apclk('.next').on('click', function() {
            apclk('.bx-next').trigger('click');
        });
    }

});
