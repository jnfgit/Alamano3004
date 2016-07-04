      $(function(){
        // TOOLTIPS
        $('[data-toggle="tooltip"]').tooltip();

        // MOVER A PASOS
        ScrollTo("#pasos", 180);

        // FIJAR MENU
        $(window).scroll(function () {
          $('#menu').toggleClass("solid", ($(window).scrollTop() > 100));

          // FIJAR BOTON CONFIRMAR EN CEL
          var confirmar = $('#cuerpo').offset().top;
          var footer = $('footer').offset().top;
          $('#btn-confirmar div').toggleClass("resp-btn", ($(window).scrollTop() > confirmar && $(window).scrollTop()+$(window).height() < footer));
        });

        /* SLIDERS */
        $('.slider').slick({
          slidesToShow: 4,
          slidesToScroll: 4,
          autoplay: true,
          arrows: true,
          dots: true
        });

        // FECHA
        var picker = new Pikaday(
        {
          field: document.getElementById('datepicker'),
          firstDay: 1,
          minDate: new Date((new Date).getFullYear(), (new Date).getMonth(), (new Date).getDay()),
          maxDate: new Date((new Date).getFullYear(), (new Date).getMonth()+1, (new Date).getDay()),
          bound: false,
          format: "DD/MM/YYYY",
          container: document.getElementById('container'),
          i18n: {
            previousMonth : 'Mes Anterior',
            nextMonth     : 'Siguiente Mes',
            months        : ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            weekdays      : ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
            weekdaysShort : ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb']
          },
        });

      });