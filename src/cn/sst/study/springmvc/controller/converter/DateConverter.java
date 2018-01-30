package cn.sst.study.springmvc.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


/**
 * Converter<S, T>
 * S:source,需要转换的源的类型
 * T:target,需要转换的目标类型
 * @author sunshengteng
 *
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = simpleDateFormat.parse(source);
			return date;
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
