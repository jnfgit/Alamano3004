	$(function(){
         // FIJAR MENU
        $(window).scroll(function () {
          $('#menu').toggleClass("solid", ($(window).scrollTop() > 100));
        });
      });