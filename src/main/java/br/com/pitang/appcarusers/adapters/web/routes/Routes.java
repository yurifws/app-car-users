package br.com.pitang.appcarusers.adapters.web.routes;

public class Routes {

	public static final String BASE_PATH = "/api";

	public static final String USERS_ROUTE = "/users"; 
	
	public static final String USER_ID = "user_id";

	public static final String USERS_BY_ID_ROUTE = USERS_ROUTE + "/{"+USER_ID+"}";
	
	public static final String CARS_ROUTE = "/cars"; 
	
	public static final String CAR_ID = "car_id";

	public static final String CARS_BY_ID_ROUTE = CARS_ROUTE + "/{"+CAR_ID+"}";
}
