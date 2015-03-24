$(document).ready(
		function() {

			/* SCRIPT TO VALIDATE TASK DATE & TIME */

			$('.task-date').datepicker({
				dateFormat : 'M d, yy',
				changeMonth : true,
				changeYear : true
			});

			$('.task-time').timepicker({
				'step' : 05,
				'timeFormat' : 'h:i A'
			});

			$('.starttime').on(
					'change',
					function() {
						var sTime = $(this);
						if (sTime.val() != "") {

							var st = new Date(Date.parse($('.task-date').val()
									+ ' ' + sTime.val()));
							var et = new Date();
							et.setTime(st.getTime() + (5 * 60 * 1000));

							$('.endtime').timepicker({
								'minTime' : et,
								'maxTime' : '11:55 PM',
								'step' : 05,
								'timeFormat' : 'h:i A'
							});
							$('.endtime').removeAttr('disabled');
						}
					});

			$('.endtime').on(
					'change',
					function() {
						var date = $('.task-date').val();
						var st = new Date(Date.parse(date + ' '
								+ $('.starttime').val()));
						var et = new Date(Date.parse(date + ' '
								+ $('.endtime').val()));
						var diff = et - st;
						var diffInTime = (diff / (60 * 60 * 1000)).toFixed(2);
						$('.task-duration').val(diffInTime);
					});

		});