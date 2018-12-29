package com.wenzisay.scaffold.commons.lang;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 日期处理API
 * 
 * <p>SQL -> Java</p>
 * <p>--------------------------</p>
 * <p>date -> LocalDate</p>
 * <p>time -> LocalTime</p>
 * <p>timestamp -> LocalDateTime</p>
 * @author wenzi
 *
 */
public class LocalDateUtil {
	
	/**
	 * 返回当前日期
	 * @return
	 */
	public static LocalDate today() {
		return LocalDate.now();
	}
	
	/**
	 * 返回当前时间（包含毫秒）
	 * @return
	 */
	public static LocalTime nowTime() {
		return LocalTime.now();
	}
	
	/**
	 * 返回当前时间（清除毫秒）
	 * @return
	 */
	public static LocalTime nowTimeWithoutNano() {
		return LocalTime.now().withNano(0);
	}
	
	/**
	 * 返回当前日期时间
	 * @return
	 */
	public static LocalDateTime nowDateTime() {
		return LocalDateTime.now();
	}
	
	
}
