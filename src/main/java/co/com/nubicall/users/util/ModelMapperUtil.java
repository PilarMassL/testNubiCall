package co.com.nubicall.users.util;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil {

	private static ModelMapper modelMapper = new ModelMapper();

	private ModelMapperUtil() {
		super();
	}

	public static Object convert(Object sourceObject, Class<?> targetClass) {
		Object modelObject = modelMapper.map(sourceObject, targetClass);
		return modelObject;
	}

}
