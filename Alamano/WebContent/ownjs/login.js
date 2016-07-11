      $(function(){
        // TOOLTIPS
        $('[data-toggle="tooltip"]').tooltip();

        // FIJAR MENU
        $(window).scroll(function () {
          $('#menu').toggleClass("solid", ($(window).scrollTop() > 100));
        });
      });