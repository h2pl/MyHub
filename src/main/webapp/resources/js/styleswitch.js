/* Style Switcher */
apclk(document).ready(function() {

    try {
        var styleswitcherstr = ' \
            <div class="toggle-switcher"> \
                    <h2>Style Switcher <a href="#"><i class="fa fa-cog fa-spin fa-3x fa-fw"></i></a></h2> \
                    <div class="switcher-box"> \
                        <div class="clearfix"></ div> \
                        <h3>Colors</h3> \
                        <a id="default" class="styleswitch color" href="#"></a> \
                        <a id="dark-red" class="styleswitch color" href="#"></a> \
                        <a id="parrot" class="styleswitch color" href="#"></a> \
                        <a id="blue" class="styleswitch color" href="#"></a> \
                        <a id="sky" class="styleswitch color" href="#"></a> \
                    </div> \
            </div> \
    ';


        var wrap = apclk('<div/>');
        wrap.addClass('switcher');
        wrap.append(styleswitcherstr);
        apclk("footer").after(wrap);
    } catch (e) {}

/* Skins Style */

    try {
        apclk(".toggle-switcher .switcher-box a").click(function() {
            var id = apclk(this).attr('id');
            if (id != null && id != undefined) {
                changeLayout(apclk(this).attr('id').replace('#', ''));
            }
        });
        var cookieName = 'apclk-cottage-color';

        function changeLayout(theme) {
            // $.cookie("test", 1);
            jQuery.cookie(cookieName, theme);
            apclk('head link[id=layout]').attr('href', 'css/' + theme + '-style.css');
        }

        if (jQuery.cookie(cookieName)) {
            changeLayout(jQuery.cookie(cookieName));
        }

    } catch (e) {}


/* Reset Switcher */
    try {
        apclk('.toggle-switcher').css('left', '-160px');
        apclk('.switcher-box').animate({
            left: '-160px'
        });
        apclk('.toggle-switcher h2 a').click(function(e) {
            e.preventDefault();
            var div = apclk('.toggle-switcher');
            console.log('btn clicked: ' + div.css('left'));
            if (div.css('left') === '-160px') {
                apclk('.toggle-switcher').animate({
                    left: '0px'
                });

            } else {
                apclk('.toggle-switcher').animate({
                    left: '-160px'
                });
            }
        });
        apclk('.toggle-switcher h2 a').toggle(

            function() {
                apclk('.switcher-box').css('left', '0')
            },
            function() {
                apclk('.switcher-box').css('left', '160px')
            })
    } catch (e) {}

});