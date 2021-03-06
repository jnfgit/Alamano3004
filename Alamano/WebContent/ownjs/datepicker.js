$(function(){
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