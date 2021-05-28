package ncdcparsersimple;

import static org.junit.Assert.*;

import org.junit.Test;



public class TestNCDCParserSimple {
	
	//
	// Control data
	//
	// 1-4
	private final int EXPECTED_RESULT_totalChars = 128;
	// 5-10
	private final String EXPECTED_RESULT_catalogID = "007026";
	// 11-15
	private final String EXPECTED_RESULT_wbanID = "99999";
	// 16-23
	private final String EXPECTED_RESULT_observationDate = "20120713";
	// 24-27
	private final String EXPECTED_RESULT_observationTime = "1200";
	// 28-28
	private final char EXPECTED_RESULT_dataSourceFlag = '4';
	// 29-34
	private final int EXPECTED_RESULT_latitudeCoord = 0;
	// 35-41
	private final int EXPECTED_RESULT_longitudeCoord = 0;
	// 42-46
	private final String EXPECTED_RESULT_reportTypeCode = "FM-15";
	// 47-51
	private final int EXPECTED_RESULT_eleveationDimension = 7026; 
	// 52-56
	private final String EXPECTED_RESULT_callLetterId = "7026 ";
	// 57-60
	private final String EXPECTED_RESULT_qualityControlPrrocessName = "V020";
	
	//
	// Mandatory data
	//
	// 61-63
	private final int EXPECTED_RESULT_directionAngle = 110;
	// 64-64
	private final char EXPECTED_RESULT_directionQualityCode = '1';
	// 65-65
	private final char EXPECTED_RESULT_typeCode = 'N';
	// 66-69
	private final int EXPECTED_RESULT_speedRate = 5;
	// 70-70
	private final char EXPECTED_RESULT_speedQualityCode = '1'; 
	// 71-75
	private final int EXPECTED_RESULT_ceilingHeightDimention = 99999;
	// 76-76
	private final char EXPECTED_RESULT_ceilingQualityCode = '9';
	// 77-77
	private final char EXPECTED_RESULT_ceilingDeterminationCode = '9';
	// 78-78
	private final char EXPECTED_RESULT_cavokCode = 'N'; 
	// 79-84
	private final int EXPECTED_RESULT_distanceDimention = 999999;
	// 85-85
	private final char EXPECTED_RESULT_distanceQualityCode = '9';
	// 86-86
	private final char EXPECTED_RESULT_variabilityCode = 'N';
	// 87-87
	private final char EXPECTED_RESULT_qualityVariablityCode = '1';
	// 88-92
	private final int EXPECTED_RESULT_airTemperature = 240;
	// 93-93
	private final char EXPECTED_RESULT_airTemperatureQualityCode = '1';
	// 94-98
	private final int EXPECTED_RESULT_dewPointTemperature = 230;
	// 99-99
	private final char EXPECTED_RESULT_dewPointQualityCode = '1';
	// 100-104
	private final int EXPECTED_RESULT_seaLevelPressure = 99999;
	// 105-105
	private final char EXPECTED_RESULT_seaLevelPressureQualityCode = '9';
	// 106+
	private final String EXPECTED_RESULT_additionalData = "ADDKA1999M+99999MA1102501999999REMMET069MOBOB0 METAR 7026 //010 000000 131159Z AUTO 11001KT //// 24/23 A3027;EQDQ01 -00012ATMX  ";

	
	
	@Test
	public void testRecordParsing() {
		
		final String record = "0128007026999992012071312004+00000+000000FM-15+70267026 V0201101N000519999999N9999999N1+02401+02301999999ADDKA1999M+99999MA1102501999999REMMET069MOBOB0 METAR 7026 //010 000000 131159Z AUTO 11001KT //// 24/23 A3027;EQDQ01 -00012ATMX  ";
		NCDCParserSimple parser = new NCDCParserSimple();
		parser.parse(record);
		
		// 1-4
		assertEquals(EXPECTED_RESULT_totalChars, parser.getTotalVariableChars());
		// 5-10
		assertEquals(EXPECTED_RESULT_catalogID, parser.getFixedWeatherStation_USAFMasterStationCatId());
		// 11-15
		assertEquals(EXPECTED_RESULT_wbanID, parser.getFixedWeatherStation_NCEIWbanId());
		// 16-23
		assertEquals(EXPECTED_RESULT_observationDate, parser.getGeophysicalPointObservation_Date());
		// 24-27
		assertEquals(EXPECTED_RESULT_observationTime, parser.getGeophysicalPointObservation_Time());
		// 28-28
		assertEquals(EXPECTED_RESULT_dataSourceFlag, parser.getGeophysicalPointObservation_DataSourceFlag());
		// 29-34
		assertEquals(EXPECTED_RESULT_latitudeCoord, parser.getGeophysicalPointObservation_LatitudeCoord());
		// 35-41
		assertEquals(EXPECTED_RESULT_longitudeCoord, parser.getGeophysicalPointObservation_LongitudeCoord());
		// 42-46
		assertEquals(EXPECTED_RESULT_reportTypeCode, parser.getGeophysicalReportType_Code());
		// 47-51
		assertEquals(EXPECTED_RESULT_eleveationDimension, parser.getGeophysicalPointObservation_ElevationDimention());
		// 52-56
		assertEquals(EXPECTED_RESULT_callLetterId, parser.getFixedWeatherStation_CallLetterId());
		// 57-60
		assertEquals(EXPECTED_RESULT_qualityControlPrrocessName, parser.getMeteorogicalPointObservation_QualityControlProcessName());
		// 61-63
		assertEquals(EXPECTED_RESULT_directionAngle, parser.getWindObservation_DirectionAngle());
		// 64-64
		assertEquals(EXPECTED_RESULT_directionQualityCode, parser.getWindObservation_DirectionQualityCode());
		// 65-65
		assertEquals(EXPECTED_RESULT_typeCode, parser.getWindObservation_TypeCode());
		// 66-69
		assertEquals(EXPECTED_RESULT_speedRate, parser.getWindObservation_SpeedRate());
		// 70-70
		assertEquals(EXPECTED_RESULT_speedQualityCode, parser.getWindObservation_SpeedQualityCode());
		// 71-75
		assertEquals(EXPECTED_RESULT_ceilingHeightDimention, parser.getSkyConditionObservation_CeilingHeightDimention());
		// 76-76
		assertEquals(EXPECTED_RESULT_ceilingQualityCode, parser.getSkyConditionObservation_CeilingQualityCode());
		// 77-77
		assertEquals(EXPECTED_RESULT_ceilingDeterminationCode, parser.getSkyConditionObservation_CeilingDeterminationCode());
		// 78-78
		assertEquals(EXPECTED_RESULT_cavokCode, parser.getSkyConditionObservation_CavokCode());
		// 79-84
		assertEquals(EXPECTED_RESULT_distanceDimention, parser.getVisibilityObservation_DistanceDimension());
		// 85-85
		assertEquals(EXPECTED_RESULT_distanceQualityCode, parser.getVisibilityObservation_DistanceQualityCode());
		// 86-86
		assertEquals(EXPECTED_RESULT_variabilityCode, parser.getVisibilityObservation_VariabilityCode());
		// 87-87
		assertEquals(EXPECTED_RESULT_qualityVariablityCode, parser.getVisibilityObservation_QualityVariablityCode());
		// 88-92
		assertEquals(EXPECTED_RESULT_airTemperature, parser.getAirTemperatureObservation_AirTemperature());
		// 93-93
		assertEquals(EXPECTED_RESULT_airTemperatureQualityCode, parser.getAirTemperatureObservation_AirTemperatureQualityCode());
		// 94-98
		assertEquals(EXPECTED_RESULT_dewPointTemperature, parser.getAirTemperatureObservation_DewPointTemperature());
		// 99-99
		assertEquals(EXPECTED_RESULT_dewPointQualityCode, parser.getAirTemperatureObservation_DewPointQualityCode());
		// 100-104
		assertEquals(EXPECTED_RESULT_seaLevelPressure, parser.getAtmosphericPressueObservation_SeaLevelPressure());
		// 105-105
		assertEquals(EXPECTED_RESULT_seaLevelPressureQualityCode, parser.getAtmosphericPressueObservation_SeaLevelPressureQualityCode());
		// 106+
		assertEquals(EXPECTED_RESULT_additionalData, parser.getAdditionalData());
		
	}

}
// ^^ class TestNCDCParserSimple

////////////////////////
//
//   END OF FILE
//
////////////////////

