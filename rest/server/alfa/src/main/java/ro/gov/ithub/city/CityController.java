package ro.gov.ithub.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.gov.ithub.base.BaseController;

import java.util.*;

@RestController
public class CityController extends BaseController<City> {

	@Autowired
	private CityService cityService;

	@RequestMapping("/city")
	public List<City> getAllCities() {
		return cityService.getCities();
	}

}
