package ncdcparsersimple;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMalformedData {

	ControlDataSectionParsing_ParserSimple pCDS = 
			new ControlDataSectionParsing_ParserSimple();
	
	MandatoryDataSectionParsing_ParserSimple pMDS =
			new MandatoryDataSectionParsing_ParserSimple();
	
	@Test
	public void testMalformedTotalVariableChars() {
		// pos 1-4
		final String data = "-%20";
		final int MIN_VALUE = 0;
		
		int actualResilt = pCDS.parseTotalVariableChars(data);
		assertEquals(MIN_VALUE, actualResilt);
	}
	

	@Test
	public void testMalformedFixedWeatherStation_NCEIWbanId() {
		// 11-15
		final String data = "%20-4"; 
		String actualResilt = pCDS.parseFixedWeatherStation_NCEIWbanId(data);
		assertEquals(data, actualResilt);
	}

	@Test
	public void testMalformedGeophysicalPointObservation_Date() {
		// pos 16-23
		final String data = "00%204&?"; 
		String actualResilt = pCDS.parseGeophysicalPointObservation_Date(data);
		assertEquals(data, actualResilt);
	}

	@Test
	public void testMalformedGeophysicalPointObservation_Time() {
		// pos 24-27
		final String data = "(+%1";
		String actualResilt = pCDS.parseGeophysicalPointObservation_Time(data);
		assertEquals(data, actualResilt);
	}

	@Test
	public void testMalformedGeophysicalPointObservation_LatitudeCoord() {
		// pos 29-34
		final String data = "-*/&6@";
		final int DATA_IS_MISSING = 99999;
		int actualResilt = pCDS.parseGeophysicalPointObservation_LatitudeCoord(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}

	@Test
	public void testMalformedGeophysicalPointObservation_LongitudeCoord() {
		// pos 35-41
		final String data = "+$%^&*)";
		final int DATA_IS_MISSING = 999999;
		int actualResilt = pCDS.parseGeophysicalPointObservation_LongitudeCoord(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}

	@Test
	public void testMalformedGeophysicalPointObservation_ElevationDimention() {
		// pos 47-51
		final String data = "/%20&";
		final int DATA_IS_MISSING = 9999;
		int actualResilt = pCDS.parseGeophysicalPointObservation_ElevationDimention(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}

	@Test
	public void testMalformedWindObservation_DirectionAngle() {
		// pos 61-63
		final String data = "*%2";
		final int DATA_IS_MISSING = 999;
		int actualResilt = pMDS.parseWindObservation_DirectionAngle(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}

	
	@Test
	public void testMalformedWindObservation_SpeedRate() {
		// pos 66-69
		final String data = "%20'"; 
		final int DATA_IS_MISSING = 9999;
		int actualResilt = pMDS.parseWindObservation_SpeedRate(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}

	
	@Test
	public void testMalformedSkyConditionObservation_CeillingHeightDimention() {
		// pos 71-75
		final String data = "^%78$";
		final int DATA_IS_MISSING = 99999;
		int actualResilt = pMDS.parseSkyConditionObservation_CeilingHeightDimention(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}

	
	@Test
	public void testMalformedVisibilityObservation_DistanceDimension() {
		// pos 79-84
		final String data = "%20%20";
		final int DATA_IS_MISSING = 999999;
		int actualResilt = pMDS.parseVisibilityObservation_DistanceDimension(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}

	
	@Test
	public void testMalformedAirTemperatureObservation_AirTemperature() {
		// pos 88-92
		final String data = "-0(8!";
		final int DATA_IS_MISSING = 9999;
		int actualResilt = pMDS.parseAirTemperatureObservation_AirTemperature(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}

	
	@Test
	public void testMalformedAirTemperatureObservation_DewPointTemperature() {
		// pos 94-98
		final String data = "-0)8&";
		final int DATA_IS_MISSING = 9999;
		int actualResilt = pMDS.parseAirTemperatureObservation_DewPointTemperature(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}

	
	@Test
	public void testMalformedAtmosphericPressueObservation_SeaLevelPressure() {
		// pos 100-104
		final String data = "*&6%4";
		final int DATA_IS_MISSING = 99999;
		int actualResilt = pMDS.parseAtmosphericPressueObservation_SeaLevelPressure(data);
		assertEquals(DATA_IS_MISSING, actualResilt);
	}
	

}
// ^^ class TestMalformedData 

////////////////////////
//
//   END OF FILE
//
////////////////////

