package com.secutest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

	private final ObjectMapper objectMapper;

	private JsonUtils() {
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, true);
		objectMapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
	}

	public static JsonUtils getInstance() {
		return new JsonUtils();
	}

	private static ObjectMapper getMapper() {
		return getInstance().objectMapper;
	}

	public static String toJson(Object value) {
		try {
			return getMapper().writeValueAsString(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] toJsonAsByte(Object value) {
		try {
			return getMapper().writeValueAsBytes(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}