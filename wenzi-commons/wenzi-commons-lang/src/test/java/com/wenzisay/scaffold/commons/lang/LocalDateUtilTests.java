package com.wenzisay.scaffold.commons.lang;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class LocalDateUtilTests {

	@Test
	public void format() {
		System.out.println("测试format相关方法：");
		System.out.println("format 【default】->"+LocalDateUtil.format(LocalDateUtil.nowDateTime()));
		System.out.println("format 【yyyy年MM月dd日】->"+LocalDateUtil.format(LocalDateUtil.nowDateTime(),"yyyy年MM月dd日"));
	}
	
	@Test
	public void diff() {
		System.out.println("测试时间差相关方法：");
		LocalDate localDate = LocalDateUtil.dateOf(2018, 1, 1);
		LocalDate localDate2 = LocalDateUtil.dateOf(2019, 1, 1);
		long days = LocalDateUtil.getDiffDays(localDate, localDate2);
		assertEquals(365, days);
		System.out.println("days="+days);
		long months = LocalDateUtil.getDiffMonths(localDate, localDate2);
		assertEquals(12, months);
		System.out.println("months="+months);
		LocalDateTime localDateTime = LocalDateUtil.nowDateTime();
		LocalDateTime localDateTime2 = localDateTime.plusMinutes(-10000);
		long minutes = LocalDateUtil.getDiffMinutes(localDateTime, localDateTime2);
		assertEquals(-10000, minutes);
		System.out.println("minutes="+minutes);
		long hours = LocalDateUtil.getDiffHours(localDateTime, localDateTime2);
		System.out.println("hours="+hours);
		assertEquals(-166, hours);
	}
	
	@Test
	public void parse() {
		System.out.println("测试parse相关方法：");
		System.out.println("parseDate 【2018-11-01】->"+LocalDateUtil.parseDate("2018-11-01"));
		System.out.println("parseDate 【2018年11月01日】->"+LocalDateUtil.parseDate("2018年11月01日", "yyyy年MM月dd日"));
		System.out.println("parseDate 【2018-11-01 11:11:11】->"+LocalDateUtil.parseDate("2018-11-01 11:11:11"));
		System.out.println("parseDate 【2018-11-01 11:11:11】->"+LocalDateUtil.parseDateTime("2018-11-01 11:11:11"));
		System.out.println("parseTime 【2018-11-01 11:11:11】->"+LocalDateUtil.parseTime("2018-11-01 11:11:11"));
		System.out.println("parseTime 【11:11:11】->"+LocalDateUtil.parseTime("11:11:11"));
	}

}
