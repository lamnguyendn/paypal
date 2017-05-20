
<script type="text/javascript" src="js/dev-layout-default.js"></script>
    <script type="text/javascript" src="js/jquery.marquee.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- candlestick -->
        <script type="text/javascript" src="js/jquery.jqcandlestick.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/jqcandlestick.css"/>
        <!-- //candlestick -->

        <!--max-plugin-->
        <script type="text/javascript" src="js/plugins.js"></script>
        <!--//max-plugin-->

        <!--scrolling js-->
        <script src="js/jquery.nicescroll.js"></script>
        <script src="js/scripts.js"></script>
        <div id="ascrail2000" class="nicescroll-rails"
             style="width: 6px; z-index: 1000; background: rgb(255, 255, 255); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;">
            <div
                style="position: relative; top: 0px; float: right; width: 6px; height: 69px; background-color: rgb(103, 211, 224); border: 0px; background-clip: padding-box; border-radius: 10px;"></div>
        </div>
        <div id="ascrail2000-hr" class="nicescroll-rails"
             style="height: 6px; z-index: 1000; background: rgb(255, 255, 255); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;">
            <div
                style="position: relative; top: 0px; height: 6px; width: 1366px; background-color: rgb(103, 211, 224); border: 0px; background-clip: padding-box; border-radius: 10px;"></div>
        </div>

        <!--//scrolling js-->

        <!-- real-time-updates -->
        <script language="javascript" type="text/javascript" src="js/jquery.flot.js"></script>
        <script>
            var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
            showLeftPush = document.getElementById( 'showLeftPush' ),
            body = document.body;

            showLeftPush.onclick = function() {
            classie.toggle(this, 'active');
            classie.toggle( body, 'cbp-spmenu-push-toright' );
            classie.toggle( menuLeft, 'cbp-spmenu-open' );
            disableOther( 'showLeftPush' );
        };


            function disableOther( button ) {
            if( button !== 'showLeftPush' ) {
            classie.toggle( showLeftPush, 'disabled' );
        }
        }
        </script>