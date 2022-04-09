package com.sunil.properties.file.propertiesfileaccess.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.properties.file.propertiesfileaccess.config.DbSettings;

@RestController
public class GreetingController {

	@Value("${my.greetings:default value}")
	private String greetingMessage;

	@Value("some static message")
	private String staticMessage;

	@Value("${my.list.values}")
	private List<String> listValues = new ArrayList<>();

	@Autowired
	private DbSettings dbSettings;

	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage;
	}

	@GetMapping("/listValues")
	public String listValues() {
		return listValues.toString();
	}

	@GetMapping("/dbValues")
	public String dbValues() {
		return dbSettings.getConnection() + "=" + dbSettings.getHost() + "=" + dbSettings.getPort();
	}

}
