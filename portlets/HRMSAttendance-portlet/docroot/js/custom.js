$(document).ready(function() {

	$('.div-attendance-month').hide();
	$('.div-attendance-date').hide();
	$('.div-attendance-quarter').hide();
	$('.attendance-displayMode').prop('selectedIndex', 0);
	
	$('.attendance-date-text').datepicker({
		dateFormat : 'M d, yy',
	});

	$('.attendance-displayMode').on('change', function() {
		var selectedOption = $('.attendance-displayMode option:selected').val();
		var attendanceQuarter = $('.div-attendance-quarter');
		var attendanceDate = $('.div-attendance-date');
		var attendanceMonth = $('.div-attendance-month');
		switch (selectedOption) {
		case "1":
			attendanceQuarter.hide();
			attendanceMonth.hide();
			attendanceDate.show(200);
			break;
		case "2":
			attendanceMonth.hide();
			attendanceDate.hide();
			attendanceQuarter.show(200);
			break;
		case "3":
			attendanceDate.hide();
			attendanceQuarter.hide();
			attendanceMonth.show(200);
			break;
		case "4":
			attendanceQuarter.hide(200);
			attendanceMonth.hide(200);
			attendanceDate.hide(200);
			break;
		}
	});
});