package org.bear.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

@Embeddable
public class Location {

	@Convert(converter = CityConverter.class)
	@Column(name = "city", nullable = false, length = 15)
	private City city;

	@Column(name = "region", nullable = false, length = 10)
	@Convert(converter = RegionConverter.class)
	private Region region;

	public static class CityConverter implements AttributeConverter<City, String> {

		public String convertToDatabaseColumn(City city) {
			return city.toString();
		}

		public City convertToEntityAttribute(String city) {
			return City.valueOf(city.toUpperCase().replace(" ", "_"));
		}
	}

	public static class RegionConverter implements AttributeConverter<Region, String> {

		public String convertToDatabaseColumn(Region region) {
			return region.toString();
		}

		public Region convertToEntityAttribute(String region) {
			return Region.valueOf(region.toUpperCase().replace(" ", "_"));
		}
	}
}
