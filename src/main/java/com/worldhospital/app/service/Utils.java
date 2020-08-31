package com.worldhospital.app.service;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	private static final String TIME24HOURS_PATTERN = "(([0-1]?[0-9])|(2[0-3])):[0-0][0-0]:[0-0][0-0]";
	private static Pattern pattern = Pattern.compile(TIME24HOURS_PATTERN);
	private static Matcher matcher;

	/**
	 * Validate time in 24 hours format with regular expression
	 * 
	 * @param time time address for validation
	 * @return true valid time fromat, false invalid time format
	 */
	public static boolean validateTimeFormat(final String time) {

		matcher = pattern.matcher(time);
		return matcher.matches();

	}
	
	public static boolean isValidAppointmentTimeSlot(String inputTime, String inputDate) {
		LocalDate inputLocalDate = LocalDate.parse(inputDate);
		
		DayOfWeek dayOfWeek = inputLocalDate.getDayOfWeek();

		Time startTime = Time.valueOf("09:00:00");
		Time endTime = Time.valueOf("17:00:00");
		Time lunchTime = Time.valueOf("13:00:00");
		Time satEndTime = Time.valueOf("13:00:00");
		
		if (validateTimeFormat(inputTime)) {
			if (inputLocalDate.isBefore(LocalDate.now()) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
				return false;
			} else if (dayOfWeek.equals(DayOfWeek.SATURDAY)
					&& (Time.valueOf(inputTime).equals(startTime) || (Time.valueOf(inputTime).after(startTime) && !Time.valueOf(inputTime).after(satEndTime))
							|| (Time.valueOf(inputTime).before(satEndTime) && !Time.valueOf(inputTime).before(startTime)) || Time.valueOf(inputTime).equals(satEndTime))) {
				return true;
			} else if ((Time.valueOf(inputTime).equals(startTime) || (Time.valueOf(inputTime).after(startTime) && !Time.valueOf(inputTime).after(endTime))
					|| (Time.valueOf(inputTime).before(endTime) && !Time.valueOf(inputTime).before(startTime)) || Time.valueOf(inputTime).equals(endTime))
					&& !Time.valueOf(inputTime).equals(lunchTime) && (!dayOfWeek.equals(DayOfWeek.SATURDAY) && !dayOfWeek.equals(DayOfWeek.SUNDAY))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
}
