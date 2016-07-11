      $(function(){
          // FIJAR BOTON CONFIRMAR EN CEL
          var confirmar = $('#cuerpo').offset().top;
          var footer = $('footer').offset().top;
          $('#btn-confirmar div').toggleClass("resp-btn", ($(window).scrollTop() > confirmar && $(window).scrollTop()+$(window).height() < footer));
        });