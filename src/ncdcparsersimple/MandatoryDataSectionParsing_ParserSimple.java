package ncdcparsersimple;


/**
 * 
 *   This class' methods provide an opportunity to analyze the mandatory 
 * data of an ISD record before it will be stored and to return the data 
 * as it seems appropriate.
 *  
 *   Currently, some of methods convert a string (e.g. a part of the ISD 
 * record) to an int. If the string cannot be parsed to an int then these 
 * methods will return either a minimum value or a 'missing value' as defined 
 * in Federal Climate Complex Data Documentation for Integrated Surface Data 
 * (ISD) for that particular part of the record. Otherwise an int will be 
 * returned as is. 
 * 
 * @author BusyBee
 *
 */
public class MandatoryDataSectionParsing_ParserSimple {
	
	/*
	 * Note: For the quality code fields with each data element, the following may appear in data 
	 * which were processed through NCEI’s Interactive QC system (manual interaction), for selected 
	 * parameters:
	 * 		A – Data value flagged as suspect, but accepted as good value.
	 * 		U – Data value replaced with edited value. 
	 * 		P – Data value not originally flagged as suspect, but replaced by validator.
	 * 		I – Data value not originally in data, but inserted by validator.
	 * 		M – Manual change made to value based on information provided by NWS or FAA.
	 * 		C – Temperature and dew point received from Automated Weather Observing Systems (AWOS) 
	 * 			are reported in whole degrees Celsius. Automated QC flags these values, but they are 
	 * 			accepted as valid.
	 * 		R – Data value replaced with value computed by NCEI software.
	 */
	
	/**
	 *  13
	 	POS: 61-63
		WIND-OBSERVATION direction angle
		The angle, measured in a clockwise direction, between true north and the direction from which the wind is blowing.
		MIN: 001
		MAX: 360
		UNITS: Angular Degrees
		SCALING FACTOR: 1
		DOM: A general domain comprised of the numeric characters (0-9).
		999 = Missing. If type code (below) = V, then 999 indicates variable wind direction.
	 * 
	 * @param data
	 * @return 
	 */
	int parseWindObservation_DirectionAngle(String data) {
		
		final int DATA_IS_MISSING_INT = 999;		
		
		int angle = 0;
		try {
			
			angle = Integer.parseInt(data);
			
		} catch (NumberFormatException e) {
			// the string does not contain a parsable integer.
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
			
		} catch (NullPointerException e) {
			// The string is null.
			// Return ??.		
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
		}	
		
		return angle;		
		
	}
	// ^^ parseWindObservation_DirectionAngle(string)
	
	
	
	/**
	 *	14
	 	POS: 64-64
		WIND-OBSERVATION direction quality code
		The code that denotes a quality status of a reported WIND-OBSERVATION direction angle.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		0 = Passed gross limits check
		1 = Passed all quality control checks
		2 = Suspect
		3 = Erroneous
		4 = Passed gross limits check, data originate from an NCEI data source
		5 = Passed all quality control checks, data originate from an NCEI data source
		6 = Suspect, data originate from an NCEI data source
		7 = Erroneous, data originate from an NCEI data source
		9 = Passed gross limits check if element is present
 
	 * @param data
	 * @return 
	 */
	char parseWindObservation_DirectionQualityCode(char data) {
		
		// Currently, the data will be returned as is. 
		return data;
		
	}
	// ^^ parseWindObservation_DirectionQualityCode(char)
	
	
	
	/**
	 *  15
		POS: 65-65
		WIND-OBSERVATION type code
		The code that denotes the character of the WIND-OBSERVATION.
		DOM: A specific domain comprised of the characters in the ASCII character set.
			A = Abridged Beaufort
			B = Beaufort
			C = Calm
			H = 5-Minute Average Speed
			N = Normal
			R = 60-Minute Average Speed
			Q = Squall
			T = 180 Minute Average Speed
			V = Variable
			9 = Missing
		NOTE: If a value of 9 appears with a wind speed of 0000, this indicates calm winds.
	 * 
	 * @param data
	 * @return 
	 */
	char parseWindObservation_TypeCode(char data) {
		
		// Currently, the data will be returned as is. 
		return data;
		
	}
	// ^^ parseWindObservation_TypeCode(char)

	
	
	
	/**
	 * 	16
		POS: 66-69
		WIND-OBSERVATION speed rate
		The rate of horizontal travel of air past a fixed point.
		MIN: 0000
		MAX: 0900
		UNITS: meters per second
		SCALING FACTOR: 10
		DOM: A general domain comprised of the numeric characters (0-9).
		9999 = Missing.
		
	 * @param data
	 * @return 
	 */
	int parseWindObservation_SpeedRate(String data) {

		final int DATA_IS_MISSING_INT = 9999;
		
		int speedRate = 0;
		try {
			
			speedRate = Integer.parseInt(data);
			
		} catch (NumberFormatException e) {
			// the string does not contain a parsable integer.
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
			
		} catch (NullPointerException e) {
			// The string is null.
			// Return ??.		
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
		}	
		
		return speedRate;
		
	}
	// ^^ parseWindObservation_SpeedRate(string)
	
	
	
	
	/**
	 *  17
		POS: 70-70
		WIND-OBSERVATION speed quality code
		The code that denotes a quality status of a reported WIND-OBSERVATION speed rate.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		0 = Passed gross limits check
		1 = Passed all quality control checks
		2 = Suspect
		3 = Erroneous
		4 = Passed gross limits check, data originate from an NCEI data source
		5 = Passed all quality control checks, data originate from an NCEI data source
		6 = Suspect, data originate from an NCEI data source
		7 = Erroneous, data originate from an NCEI data source
		9 = Passed gross limits check if element is present
		
	 * @param data
	 * @return 
	 */
	char parseWindObservation_SpeedQualityCode(char data) {
		
		// Currently, we return data as is. 
		return data;
	}
	// ^^ parseWindObservation_SpeedQualityCode(char)


	
	
	/**
	 *  18
		POS: 71-75
		SKY-CONDITION-OBSERVATION ceiling height dimension
		The height above ground level (AGL) of the lowest cloud or obscuring phenomena layer aloft with 5/8 or more summation total sky
		cover, which may be predominantly opaque, or the vertical visibility into a surface-based obstruction. Unlimited = 22000.
		MIN: 00000
		MAX: 22000 
		UNITS: Meters
		SCALING FACTOR: 1
		DOM: A general domain comprised of the numeric characters (0-9).
		99999 = Missing.
		
	 * @param data
	 * @return 
	 */
	int parseSkyConditionObservation_CeilingHeightDimention(String data) {
		
		final int DATA_IS_MISSING_INT = 99999;
		
		int ceilingHeightDimention = 0;
		try {
			
			ceilingHeightDimention = Integer.parseInt(data);
			
		} catch (NumberFormatException e) {
			// the string does not contain a parsable integer.
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
			
		} catch (NullPointerException e) {
			// The string is null.
			// Return ??.		
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
		}
		
		return ceilingHeightDimention;
	}
	// ^^ parseSkyConditionObservation_CeilingHeightDimention(string)



	
	/**
	 *  19
		POS: 76-76
		SKY-CONDTION-OBSERVATION ceiling quality code
		The code that denotes a quality status of a reported ceiling height dimension.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		0 = Passed gross limits check
		1 = Passed all quality control checks
		2 = Suspect
		3 = Erroneous
		4 = Passed gross limits check, data originate from an NCEI data source
		5 = Passed all quality control checks, data originate from an NCEI data source
		6 = Suspect, data originate from an NCEI data source
		7 = Erroneous, data originate from an NCEI data source
		9 = Passed gross limits check if element is present
		
	 * @param data
	 * @return 
	 */
	char parseSkyConditionObservation_CeilingQualityCode(char data) {

		// Currently, the data will be returned as is. 
		return data;
	}
	// ^^ parseSkyConditionObservation_CeilingQualityCode(char)



	
	/**
	 *  20
		POS: 77-77
		SKY-CONDITION-OBSERVATION ceiling determination code
		The code that denotes the method used to determine the ceiling.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		A = Aircraft
		B = Balloon
		C = Statistically derived
		D = Persistent cirriform ceiling (pre-1950 data)
		E = Estimated
		M = Measured
		P = Precipitation ceiling (pre-1950 data)
		R = Radar
		S = ASOS augmented
		U = Unknown ceiling (pre-1950 data)
		V = Variable ceiling (pre-1950 data)
		W = Obscured
		9 = Missing
		
	 * @param data
	 * @return 
	 */
	char parseSkyConditionObservation_CeilingDeterminationCode(char data) {
		
		// Currently, the data will be returned as is. 
		return data;
		
	}
	// ^^ parseSkyConditionObservation_CeilingDeterminationCode(char)



	
	/**
	 *  21
		POS: 78-78
		SKY-CONDITION-OBSERVATION CAVOK code
		The code that represents whether the 'Ceiling and Visibility Okay' (CAVOK) condition has been reported.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		N = No
		Y = Yes
		9 = Missing
		
	 * @param data
	 * @return 
	 */
	char parseSkyConditionObservation_CavokCode(char data) {
		
		// Currently, the data will be returned as is. 
		return data;
		
	}
	// ^^ parseSkyConditionObservation_CavokCode(char)



	
	/**
	 *  22
		POS: 79-84
		VISIBILITY-OBSERVATION distance dimension
		The horizontal distance at which an object can be seen and identified.
		MIN: 000000
		MAX: 160000
		UNITS: Meters
		DOM: A general domain comprised of the numeric characters (0-9).
		Missing = 999999
		NOTE: Values greater than 160000 are entered as 160000
		
	 * @param data
	 * @return 
	 */
	int parseVisibilityObservation_DistanceDimension(String data) {
		
		final int DATA_IS_MISSING_INT = 999999;
		
		int distanceDimention = 0;
		try {
			
			distanceDimention = Integer.parseInt(data);
			
		} catch (NumberFormatException e) {
			// the string does not contain a parsable integer.
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
			
		} catch (NullPointerException e) {
			// The string is null.
			// Return ??.		
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
		}
		
		return distanceDimention;
		
	}
	// ^^ parseVisibilityObservation_DistanceDimension(string)



	
	/**
	 *  23
		POS: 85-85
		VISIBILITY-OBSERVATION distance quality code
		The code that denotes a quality status of a reported distance of a visibility observation.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		0 = Passed gross limits check
		1 = Passed all quality control checks
		2 = Suspect
		3 = Erroneous
		4 = Passed gross limits check, data originate from an NCEI data source
		5 = Passed all quality control checks, data originate from an NCEI data source
		6 = Suspect, data originate from an NCEI data source
		7 = Erroneous, data originate from an NCEI data source
		9 = Passed gross limits check if element is present
		
	 * @param data
	 * @return
	 */
	char parseVisibilityObservation_DistanceQualityCode(char data) {

		// Currently, the data will be returned as is. 
		return data;

	}
	// ^^ parseVisibilityObservation_DistanceQualityCode(char)


	

	
	/**
	 *  24
		POS: 86-86
		VISIBILITY-OBSERVATION variability code
		The code that denotes whether or not the reported visibility is variable.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		N = Not variable
		V = Variable
		9 = Missing
		
	 * @param data
	 * @return
	 */
	char parseVisibilityObservation_VariabilityCode(char data) {

		// Currently, the data will be returned as is. 
		return data;

	}
	// ^^ parseVisibilityObservation_VariabilityCode(char)



	
	/**
	 *  25
		POS: 87-87
		VISIBILITY-OBSERVATION quality variability code
		The code that denotes a quality status of a reported VISIBILITY-OBSERVATION variability code.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		0 = Passed gross limits check
		1 = Passed all quality control checks
		2 = Suspect
		3 = Erroneous
		4 = Passed gross limits check, data originate from an NCEI data source
		5 = Passed all quality control checks, data originate from an NCEI data source
		6 = Suspect, data originate from an NCEI data source
		7 = Erroneous, data originate from an NCEI data source
		9 = Passed gross limits check if element is present
		
	 * @param data
	 * @return
	 */
	char parseVisibilityObservation_QualityVariablityCode(char data) {

		// Currently, the data will be returned as is. 
		return data;

	}
	// ^^ parseVisibilityObservation_QualityVariablityCode(char)



	
	/**
	 *  26
		POS: 88-92
		AIR-TEMPERATURE-OBSERVATION air temperature
		The temperature of the air.
		MIN: -0932
		MAX: +0618
		UNITS: Degrees Celsius
		SCALING FACTOR: 10
		DOM: A general domain comprised of the numeric characters (0-9), a plus sign (+), and a minus sign (-).
		+9999 = Missing.
		
	 * @param data
	 * @return
	 */
	int parseAirTemperatureObservation_AirTemperature(String data) {		
		
		final int DATA_IS_MISSING_INT = 9999;
		
		int dataValue_int = 0;
		try {
			if( data.substring(0,1).equals("+") ) {
				dataValue_int = Integer.parseInt(data.substring(1) );
			} else {
				dataValue_int = Integer.parseInt(data);
			}
		} catch (NumberFormatException e) {
			// the string does not contain a parsable integer.
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
			
		} catch (NullPointerException e) {
			// The string is null.
			// Return ??.		
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
		}
		
		return dataValue_int;

	}
	// ^^ parseAirTemperatureObservation_AirTemperature(string)



	
	
	/**
	 *  27
		POS: 93-93
		AIR-TEMPERATURE-OBSERVATION air temperature quality code
		The code that denotes a quality status of an AIR-TEMPERATURE-OBSERVATION.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		0 = Passed gross limits check
		1 = Passed all quality control checks
		2 = Suspect
		3 = Erroneous
		4 = Passed gross limits check, data originate from an NCEI data source
		5 = Passed all quality control checks, data originate from an NCEI data source
		6 = Suspect, data originate from an NCEI data source
		7 = Erroneous, data originate from an NCEI data source
		9 = Passed gross limits check if element is present
		A = Data value flagged as suspect, but accepted as a good value
		C = Temperature and dew point received from Automated Weather Observing System (AWOS) are reported in
		whole degrees Celsius. Automated QC flags these values, but they are accepted as valid.
		I = Data value not originally in data, but inserted by validator
		M = Manual changes made to value based on information provided by NWS or FAA
		P = Data value not originally flagged as suspect, but replaced by validator
		R = Data value replaced with value computed by NCEI software
		U = Data value replaced with edited value
		
	 * @param data
	 * @return
	 */
	char parseAirTemperatureObservation_AirTemperatureQualityCode(char data) {
		
		// Currently, the data will be returned as is. 
		return data;		
		
	}
	// ^^ parseAirTemperatureObservation_AirTemperatureQualityCode(char)


	
	
	
	/**
	 *  28
		POS: 94-98
		AIR-TEMPERATURE-OBSERVATION dew point temperature
		The temperature to which a given parcel of air must be cooled at constant pressure and water vapor
		content in order for saturation to occur.
		MIN: -0982
		MAX: +0368
		UNITS: Degrees Celsius
		SCALING FACTOR: 10
		DOM: A general domain comprised of the numeric characters (0-9), a plus sign (+), and a minus sign (-).
		+9999 = Missing.
		
	 * @param data
	 * @return
	 */
	int parseAirTemperatureObservation_DewPointTemperature(String data) {

		final int DATA_IS_MISSING_INT = 9999;
		
		int dataValue_int = 0;
		try {
			if( data.substring(0,1).equals("+") ) {
				dataValue_int = Integer.parseInt(data.substring(1) );
			} else {
				dataValue_int = Integer.parseInt(data);
			}
		} catch (NumberFormatException e) {
			// the string does not contain a parsable integer.
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
			
		} catch (NullPointerException e) {
			// The string is null.
			// Return ??.		
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
		}
		
		return dataValue_int;

	}
	// ^^ parseAirTemperatureObservation_DewPointTemperature(string)



	
	/**
	 *  29
		POS: 99-99
		AIR-TEMPERATURE-OBSERVATION dew point quality code
		The code that denotes a quality status of the reported dew point temperature.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		0 = Passed gross limits check
		1 = Passed all quality control checks
		2 = Suspect
		3 = Erroneous
		4 = Passed gross limits check, data originate from an NCEI data source
		5 = Passed all quality control checks, data originate from an NCEI data source
		6 = Suspect, data originate from an NCEI data source
		7 = Erroneous, data originate from an NCEI data source
		9 = Passed gross limits check if element is present
		A = Data value flagged as suspect, but accepted as a good value
		C = Temperature and dew point received from Automated Weather Observing System (AWOS) are reported in
		whole degrees Celsius. Automated QC flags these values, but they are accepted as valid.
		I = Data value not originally in data, but inserted by validator
		M = Manual changes made to value based on information provided by NWS or FAA
		P = Data value not originally flagged as suspect, but replaced by validator
		R = Data value replaced with value computed by NCEI software
		U = Data value replaced with edited value
		
	 * @param data
	 * @return
	 */
	char parseAirTemperatureObservation_DewPointQualityCode(char data) {
		
		// Currently, the data will be returned as is. 
		return data;		
		
	}
	// ^^ parseAirTemperatureObservation_DewPointQualityCode(char)



	
	/**
	 *  
		POS: 100-104
		ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure
		The air pressure relative to Mean Sea Level (MSL).
		MIN: 08600
		MAX: 10900
		UNITS: Hectopascals
		SCALING FACTOR: 10
		DOM: A general domain comprised of the numeric characters (0-9).
		99999 = Missing.
		
	 * @param data
	 * @return
	 */
	int parseAtmosphericPressueObservation_SeaLevelPressure(String data) {
		
		final int DATA_IS_MISSING_INT = 99999;
		
		int seaLevelPressure = 0;
		try {
			
			seaLevelPressure = Integer.parseInt(data);
			
		} catch (NumberFormatException e) {
			// the string does not contain a parsable integer.
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
			
		} catch (NullPointerException e) {
			// The string is null.
			// Return ??.		
			// TODO counter up ?
			return DATA_IS_MISSING_INT;
		}
		
		return seaLevelPressure;

	}
	// ^^ parseAtmosphericPressueObservation_SeaLevelPressure(string)



	
	/**
	 * 
		POS: 105-105
		ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure quality code
		The code that denotes a quality status of the sea level pressure of an
		ATMOSPHERIC-PRESSURE-OBSERVATION.
		DOM: A specific domain comprised of the characters in the ASCII character set.
		0 = Passed gross limits check
		1 = Passed all quality control checks
		2 = Suspect
		3 = Erroneous
		4 = Passed gross limits check, data originate from an NCEI data source
		5 = Passed all quality control checks, data originate from an NCEI data source
		6 = Suspect, data originate from an NCEI data source
		7 = Erroneous, data originate from an NCEI data source
		9 = Passed gross limits check if element is present
		
	 * @param data
	 * @return
	 */
	char parseAtmosphericPressueObservation_SeaLevelPressureQualityCode(char data) {
		
		// Currently, the data will be returned as is. 
		return data;		
		
	}
	// ^^ parseAtmosphericPressueObservation_SeaLevelPressureQualityCode(char)	
	
	
	
	
}
// ^^ class MandatoryDataSectionParsing_ParserSimple

////////////////////////
//
//   END OF FILE
//
////////////////////
