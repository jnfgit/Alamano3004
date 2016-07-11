$(function(){
// FECHA
var picker = new Pikaday(
        {
          field: document.getElementById('input_j_idt3:j_idt22:fechanac'),
  maxDate: new Date((new Date).getFullYear()-18, (new Date).getMonth()+1, (new Date).getDay()),
  yearRange: [(new Date).getFullYear()-90,(new Date).getFullYear()-18],
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