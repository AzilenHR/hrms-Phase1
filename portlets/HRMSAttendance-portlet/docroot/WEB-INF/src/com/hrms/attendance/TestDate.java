package com.hrms.attendance;

import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		/*
		 * Date d1 = new SimpleDateFormat("d/MM/yyyy hh:mm a")
		 * .parse("16/03/2015 10:35 AM"); Date d2 = new Date();
		 * System.out.println(new
		 * SimpleDateFormat("d/MM/yyyy hh:mm a").format(d1));
		 * System.out.println(new
		 * SimpleDateFormat("d/MM/yyyy hh:mm a").format(d2)); long diff =
		 * d2.getTime() - d1.getTime(); long hrs = diff / (1000 * 60 * 60) % 24;
		 * long mins = diff / (1000 * 60) % 60; System.out.println(hrs +
		 * " hours " + mins + " minutes");
		 */

		DecimalFormat df = new DecimalFormat("#####.##");
		Date dt = new Date();
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.YEAR));
		now.set(Calendar.MONTH, 0);
		System.out.println(now.get(Calendar.MONTH));
		System.out.println(now.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(new DateFormatSymbols().getShortMonths()[now
				.get(Calendar.MONTH)]);

	}

}
