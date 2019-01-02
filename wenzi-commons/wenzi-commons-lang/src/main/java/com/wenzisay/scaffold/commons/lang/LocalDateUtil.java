package com.wenzisay.scaffold.commons.lang;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.DAY_OF_YEAR;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.YEARS;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期处理API
 * 
 * <p>
 * SQL -> Java
 * </p>
 * <p>
 * --------------------------
 * </p>
 * <p>
 * date -> LocalDate
 * </p>
 * <p>
 * time -> LocalTime
 * </p>
 * <p>
 * timestamp -> LocalDateTime
 * </p>
 * 
 * @author wenzi
 *
 */
public class LocalDateUtil {

	public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	/**
	 * 返回当前日期
	 * 
	 * @return
	 */
	public static LocalDate today() {
		return LocalDate.now();
	}

	/**
	 * 返回当前时间（包含毫秒）
	 * 
	 * @return
	 */
	public static LocalTime nowTime() {
		return LocalTime.now();
	}

	/**
	 * 返回当前时间（清除毫秒）
	 * 
	 * @return
	 */
	public static LocalTime nowTimeWithoutNano() {
		return LocalTime.now().withNano(0);
	}

	/**
	 * 返回当前日期时间
	 * 
	 * @return
	 */
	public static LocalDateTime nowDateTime() {
		return LocalDateTime.now();
	}

	/**
	 * 返回特定日期
	 * 
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 * @return
	 */
	public static LocalDate dateOf(int year, int month, int dayOfMonth) {
		return LocalDate.of(year, month, dayOfMonth);
	}

	/**
	 * 检查是否是闰年
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isLeapYear(LocalDate date) {
		return date.isLeapYear();
	}

	// -----------------Parse from string--------------------------------

	/**
	 * 日期字符串转日期对象LocalDate
	 * 
	 * @param dateStr 格式：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static LocalDate parseDate(String dateStr) {
		try {
			return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
		} catch (DateTimeParseException e) {
			return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
		}
	}

	/**
	 * 日期字符串转日期对象LocalDate
	 * 
	 * @param datetimeStr 日期字符串
	 * @param pattern     格式
	 * @return
	 */
	public static LocalDate parseDate(String dateStr, String pattern) {
		if (StringUtils.isEmpty(pattern)) {
			return parseDate(dateStr);
		}
		return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
	}

	/**
	 * 日期时间字符串转日期时间对象LocalDateTime
	 * 
	 * @param datetimeStr 时间字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static LocalDateTime parseDateTime(String datetimeStr) {
		return LocalDateTime.parse(datetimeStr, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
	}

	/**
	 * 日期时间字符串转日期时间对象LocalDateTime
	 * 
	 * @param datetimeStr 日期时间字符串
	 * @param pattern     格式
	 * @return
	 */
	public static LocalDateTime parseDateTime(String datetimeStr, String pattern) {
		if (StringUtils.isEmpty(pattern)) {
			return parseDateTime(datetimeStr);
		}
		return LocalDateTime.parse(datetimeStr, DateTimeFormatter.ofPattern(pattern));
	}

	/**
	 * 时间时间字符串转日期时间对象LocalTime
	 * 
	 * @param timeStr 时间字符串，格式：HH:mm:ss 或 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static LocalTime parseTime(String timeStr) {
		try {
			return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT));
		} catch (DateTimeParseException e) {
			return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
		}
	}

	/**
	 * 时间字符串转日期对象LocalDate
	 * 
	 * @param datetimeStr 日期字符串
	 * @param pattern     格式
	 * @return
	 */
	public static LocalTime parseTime(String timeStr, String pattern) {
		if (StringUtils.isEmpty(pattern)) {
			return parseTime(timeStr);
		}
		return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(pattern));
	}

	// -----------------Format to string--------------------------------

	/**
	 * 把日期时间转换成字符串
	 * 
	 * @param dateTime 日期时间
	 * @param pattern  格式（例如yyyy-MM-dd HH:mm:ss）
	 * @return the formatted date-time string
	 * @throws DateTimeException if an error occurs during printing
	 */
	public static String format(LocalDateTime dateTime, String pattern) {
		if (dateTime == null) {
			return null;
		}
		if (StringUtil.isEmpty(pattern)) {
			pattern = DEFAULT_DATE_TIME_FORMAT;
		}
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		return dateTime.format(format);
	}

	/**
	 * 把日期时间转换成 默认格式的字符串（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param dateTime 日期时间
	 * @return the formatted date-time string
	 * @throws DateTimeException if an error occurs during printing
	 */
	public static String format(LocalDateTime dateTime) {
		return format(dateTime, DEFAULT_DATE_TIME_FORMAT);
	}

	/**
	 * 把日期转换成字符串
	 * 
	 * @param localDate 日期时间
	 * @param pattern   格式（例如yyyy-MM-dd）
	 * @return the formatted date-time string
	 * @throws DateTimeException if an error occurs during printing
	 */
	public static String format(LocalDate localDate, String pattern) {
		if (localDate == null) {
			return null;
		}
		if (StringUtil.isEmpty(pattern)) {
			pattern = DEFAULT_DATE_FORMAT;
		}
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		return localDate.format(format);
	}

	/**
	 * 把日期转换成字符串
	 * 
	 * @param localDate 日期时间
	 * @param pattern   格式（例如yyyy-MM-dd）
	 * @return the formatted date-time string
	 * @throws DateTimeException if an error occurs during printing
	 */
	public static String format(LocalDate localDate) {
		return format(localDate, DEFAULT_DATE_FORMAT);
	}

	// -----------------Time difference--------------------------------

	/**
	 * 计算两个日期时间之间的毫秒数
	 * 
	 * @param startDateTime
	 * @param endDateTime
	 * @return
	 */
	public static long getDiffMillis(Temporal startDateTime, Temporal endDateTime) {
		return Duration.between(startDateTime, endDateTime).toMillis();
	}

	/**
	 * 计算两个日期时间之间的秒数
	 * 
	 * @param startDateTime
	 * @param endDateTime
	 * @return
	 */
	public static long getDiffSeconds(Temporal startDateTime, Temporal endDateTime) {
		return Duration.between(startDateTime, endDateTime).toSeconds();
	}

	/**
	 * 计算两个日期时间之间的分钟数
	 * 
	 * @param startDateTime
	 * @param endDateTime
	 * @return
	 */
	public static long getDiffMinutes(Temporal startDateTime, Temporal endDateTime) {
		return Duration.between(startDateTime, endDateTime).toMinutes();
	}

	/**
	 * 计算两个日期时间之间的小时数
	 * 
	 * @param startDateTime
	 * @param endDateTime
	 * @return
	 */
	public static long getDiffHours(Temporal startDateTime, Temporal endDateTime) {
		return Duration.between(startDateTime, endDateTime).toHours();
	}

	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long getDiffDays(Temporal beginDate, Temporal endDate) {
		return ChronoUnit.DAYS.between(beginDate, endDate);
	}

	/**
	 * 计算两个日期之间的月数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long getDiffMonths(Temporal beginDate, Temporal endDate) {
		return ChronoUnit.MONTHS.between(beginDate, endDate);
	}

	/**
	 * 计算两个日期之间的年数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long getDiffYears(Temporal beginDate, Temporal endDate) {
		return ChronoUnit.YEARS.between(beginDate, endDate);
	}
	
	// -----------------Time picker--------------------------------
	
	/**
	 * 创建一个新的日期，它的值为当月的第一天
	 * 
	 * @param localDate
	 * @return
	 */
	public static LocalDate getFirstDayOfMonth(LocalDate localDate) {
		return localDate.with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * 创建一个新的日期，它的值为当月的最后一天  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getLastDayOfMonth(LocalDate date) {
		return date.with(TemporalAdjusters.lastDayOfMonth());
	}

	/**
	 * 创建一个新的日期，它的值为下月的第一天  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getFirstDayOfNextMonth(LocalDate date) {
		return date.with(TemporalAdjusters.firstDayOfNextMonth());
	}

	/**
	 * 创建一个新的日期，它的值为下月的最后一天  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getLastDayOfNextMonth(LocalDate date) {
		return date.with(
				(temporal) -> temporal.with(DAY_OF_MONTH, temporal.range(DAY_OF_MONTH).getMaximum()).plus(1, MONTHS));
	}

	/**
	 * 创建一个新的日期，它的值为上年的第一天  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getFirstDayOfLastYear(LocalDate date) {
		return date.with((temporal) -> temporal.with(DAY_OF_YEAR, 1).plus(-1, YEARS));
	}

	/**
	 * 创建一个新的日期，它的值为上年的最后一天  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getLastDayOfLastYear(LocalDate date) {
		return date.with(
				(temporal) -> temporal.with(DAY_OF_YEAR, temporal.range(DAY_OF_YEAR).getMaximum()).plus(-1, YEARS));
	}

	/**
	 * 创建一个新的日期，它的值为当年的第一天  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getFirstDayOfYear(LocalDate date) {
		return date.with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * 创建一个新的日期，它的值为今年的最后一天  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getLastDayOfYear(LocalDate date) {
		return date.with(TemporalAdjusters.lastDayOfYear());
	}

	/**
	 * 创建一个新的日期，它的值为下一年的第一天  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getFirstDayOfNextYear(LocalDate date) {
		return date.with(TemporalAdjusters.firstDayOfNextYear());
	}

	/**
	 * 创建一个新的日期，它的值为下一年的最后一天  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getLastDayOfNextYear(LocalDate date) {
		return date.with(
				(temporal) -> temporal.with(DAY_OF_YEAR, temporal.range(DAY_OF_YEAR).getMaximum()).plus(1, YEARS));
	}

	/**
	 * 创建一个新的日期，它的值为同一个月中，第一个符合星期几要求的值  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getFirstInMonth(LocalDate date, DayOfWeek dayOfWeek) {
		return date.with(TemporalAdjusters.firstInMonth(dayOfWeek));
	}

	/**
	 * 创建一个新的日期，并将其值设定为指定日期后第一个符合指定星期几要求的日期  
	 * 
	 * @param date
	 * @param dayOfWeek 星期几
	 * @return
	 */
	public static LocalDate getNext(LocalDate date, DayOfWeek dayOfWeek) {
		return date.with(TemporalAdjusters.next(dayOfWeek));
	}

	/**
	 * 创建一个新的日期，并将其值设定为指定日期前第一个符合指定星 期几要求的日期  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getPrevious(LocalDate date, DayOfWeek dayOfWeek) {
		return date.with(TemporalAdjusters.previous(dayOfWeek));
	}

	/**
	 * 创建一个新的日期，并将其值设定为指定日期后，第一个符合指定星 期几要求的日期，如果该日期已经符合要求，直接返回该对象  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getNextOrSame(LocalDate date, DayOfWeek dayOfWeek) {
		return date.with(TemporalAdjusters.nextOrSame(dayOfWeek));
	}

	/**
	 * 创建一个新的日期，并将其值设定为指定日期前，第一个符合指定星 期几要求的日期，如果该日期已经符合要求，直接返回该对象  
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate getPreviousOrSame(LocalDate date, DayOfWeek dayOfWeek) {
		return date.with(TemporalAdjusters.previousOrSame(dayOfWeek));
	}

}
