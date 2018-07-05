package com.spring.restws;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNames 
{
	private static final Random RANDOM_GENERATOR = new Random();
	private static final List<String> FIRST_NAME = Arrays.asList("Liviu","Viorica","Calin","Vadim","Kelemen","Florin","Ion","Adrian","Nicolae","Victor","Gigi");
	private static final List<String> LAST_NAME = Arrays.asList("Dragnea","Tariceanu","Dancila","Tudor","Hunor","Iordache","Iliescu","Nastase","Ceausescu","Ponta","Becali");

	public static String getRandomName()
	{
		return FIRST_NAME.get(RANDOM_GENERATOR.nextInt(10)) + " " + LAST_NAME.get(RANDOM_GENERATOR.nextInt(10));
	}
}
