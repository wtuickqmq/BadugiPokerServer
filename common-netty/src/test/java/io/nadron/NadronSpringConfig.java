package io.nadron;

import io.nadron.app.Game;
import io.nadron.service.LookupService;
import io.nadron.service.impl.SimpleLookupService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/nadron/beans/server-beans.xml")
public class NadronSpringConfig
{

	public @Bean(name="lookupService") LookupService lookupService()
	{
		Map<String,Game> refKeyGameRoomMap = new HashMap<String, Game>();
		SimpleLookupService service = new SimpleLookupService(refKeyGameRoomMap);
		return service;
	}
}
