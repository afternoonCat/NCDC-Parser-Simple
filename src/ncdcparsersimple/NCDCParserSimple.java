package ncdcparsersimple;

import org.apache.hadoop.io.Text;

/**
 * 
 *   This simple NCDC record parser is based on Federal Climate 
 * Complex Data Documentation for Integrated Surface Data (ISD) 
 * released on January 12, 2018.
 * 
 *   The purpose of this parser is to parse an ISD record and 
 * get the control and mandatory data. All additional ISD data 
 * (if any) is currently returned as a string due to a great 
 * number of the properties and getters and setters to be 
 * additionally coded. 
 * 
 *   Parsed data are stored as a String, or as  a char, or as 
 * an int (where it seemed appropriate). 
 *
 *   If a setter cannot parse a substring of the ISD record to 
 * an int (e.g. the data is malformed), it will return either 
 * a minimum value or a 'missing value' defined in Federal Climate 
 * Complex Data Documentation for Integrated Surface Data (ISD) 
 * for that particular part of the ISD record. 
 * 
 * TODO It might be useful to signal if an ISD record contains 
 *      a malformed data that this parser 'transformed' either to 
 *      a minimum value or to a 'missing value'.
 *      It might be also useful to indicate which part of 
 *      the ISD record was malformed. 
 *
 * @author BusyBee
 *
 */
public class NCDCParserSimple {	
	
	private final int iMaxRecordLength = 105;
/* 
 * ==========================
 * 
 *    CONTROL DATA SECTION
 *
 * --------------------------	
 */

	// 1
	private int iTotalVariableChars; // POS: 1-4
	/*
	 * TOTAL-VARIABLE-CHARACTERS (this includes remarks, additional data, and element quality section)
	 */
	
	// 2
	private String sUSAFMasterStationCatId; // POS: 5-10
	/*
	 * FIXED-WEATHER-STATION USAF MASTER STATION CATALOG identifier
	 */
	
	// 3
	private String sNCEIWbanId; // POS: 11-15
	/*
	 * FIXED-WEATHER-STATION NCEI WBAN identifier
	 */

	
	/* -------------------------------------
	 *
	 *    GEOPHYSICAL POINT OBSERVATION
	 *   
	 * -------------------------------------
	 */
	
	
	// 4
	private String sObservationDate; // POS: 16-23
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION date
	 */
	
	
	// 5
	private String sObservationTime; // POS: 24-27
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION time 
	 */
	
	
	// 6
	private char cDataSourceFlag; // POS: 28-28
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION data source flag
	 */
	
	
	// 7
	private int iLlatitudeCoord; //  POS: 29-34
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION latitude coordinate
	 */
	
	
	// 8
	private int iLongitudeCoord; //	POS: 35-41
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION longitude coordinate
	 */
	
	
	// 9 
	private String sReportTypeCode; //	POS: 42-46 
	/*
	 * GEOPHYSICAL-REPORT-TYPE code
	 */
	
	// 10
	private int iElevationDimention; //	POS: 47-51
	/*
	GEOPHYSICAL-POINT-OBSERVATION elevation dimension
	*/
	
		
	// 11
	private String sCallLetterId; //	POS: 52-56
	/*
	FIXED-WEATHER-STATION call letter identifier
	*/
	
	
	// 12
	private String sQualityControlProcessName; //	POS: 57-60
	/*
	METEOROLOGICAL-POINT-OBSERVATION quality control process name
	*/
	

/* 
 * ==========================
 * 
 *   MANDATORY DATA SECTION
 *
 * --------------------------	
 */
	

	/* -----------------------
	 *
	 *    WIND OBSERVATION
	 *   
	 * -----------------------
	 */

	
	// 13
	private int iDirectionAngle; //	POS: 61-63
	/*
	WIND-OBSERVATION direction angle
	*/
	
	
	// 14
	private char cDirectionQualityCode; // 	POS: 64-64
	/*
	WIND-OBSERVATION direction quality code
	*/
	
	
	// 15
	private char cWindObservationTypeCode; // 	POS: 65-65
	/*
	WIND-OBSERVATION type code
	*/
	
	
	// 16
	private int iWindSpeedRate; // 	POS: 66-69
	/*
	WIND-OBSERVATION speed rate
	*/
	
	
	// 17
	private char cWindSpeedQualityCode; // 	POS: 70-70
	/*
	WIND-OBSERVATION speed quality code
	*/
	

	/* -------------------------------
	 *
	 *    SKY CONDITION OBSERVATION
	 *   
	 * -------------------------------
	 */
	
	// 18
	private int iSkyCeilingHeightDimention; //  POS: 71-75
	/*
	SKY-CONDITION-OBSERVATION ceiling height dimension
	*/
	
	
	
	// 19
	private char cSkyCeilingQualityCode; //   POS: 76-76
	/*
	SKY-CONDTION-OBSERVATION ceiling quality code
	*/
	
	
	// 20
	private char cSkyCeilingDeterminationCode; //	POS: 77-77
	/*
	SKY-CONDITION-OBSERVATION ceiling determination code
	*/
	
	
	// 21
	private char cCAVOKCode; //	POS: 78-78
	/*
	SKY-CONDITION-OBSERVATION CAVOK code
	*/
	

	/* -----------------------------
	 *
	 *    VISIBILITY OBSERVATION
	 *   
	 * -----------------------------
	 */
	
	// 22
	private int iVisibilityDistanceDimension; // 	POS: 79-84
	/*
	VISIBILITY-OBSERVATION distance dimension
	*/
	
	
	
	// 23
	private char cVisibilityDistanceQualityCode; //	POS: 85-85
	/*
	VISIBILITY-OBSERVATION distance quality code
	*/
	
	
	// 24
	private char cVisibilityVariabilityCode; // 	POS: 86-86
	/*
	VISIBILITY-OBSERVATION variability code
	*/
	
	
	// 25
	private char cVisibilityQualityVariablityCode; //	POS: 87-87
	/*
	VISIBILITY-OBSERVATION quality variability code
	*/
	
	
	
	/* ----------------------------------
	 *
	 *    AIR TEMPERATURE OBSERVATION
	 *   
	 * ---------------------------------
	 */
	
	
	// 26
	private int iAirTemperature; //	POS: 88-92
	/*
	AIR-TEMPERATURE-OBSERVATION air temperature
	*/
	
	
	// 27 
	private char cAirTemperatureQualityCode; // 	POS: 93-93
	/*
	AIR-TEMPERATURE-OBSERVATION air temperature quality code
	*/
	
	
	// 28
	private int iDewPointTemperature; //	POS: 94-98
	/*
	AIR-TEMPERATURE-OBSERVATION dew point temperature
	*/
	
	
	// 29
	private char cDewPointQualityCode; //	POS: 99-99
	/*
	AIR-TEMPERATURE-OBSERVATION dew point quality code
	*/
	
	/* ----------------------------------
	 *
	 *  ATMOSPHERIC PRESSURE OBSERVATION
	 *   
	 * ---------------------------------
	 */
	
	// 30
	private int iSeaLevelPressure; // 	POS: 100-104
	/*
	ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure
	*/
	
	
	// 31
	private char sSeaLevelPressureQualityCode; //	POS: 105-105
	/*
	ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure quality code
	*/


/* 
 * ==========================
 * 
 *  ADDITIONAL DATA SECTION
 *
 * --------------------------	
 */

	// 32
	private String sAdditionalData; // everything that goes after pos 105.
	/*
	 * Additional data
	 */


	/*
	 * =======================
	 * ///////////////////////
	 * 
	 *   GETTERS AND SETTERS
	 *  
	 * ///////////////////////
	 */
	
	/*
	 * ==================================
	 *  Control data getters and setters
	 * ---------------------------------- 
	 */
	
	// 1
	/*
	POS: 1-4
	TOTAL-VARIABLE-CHARACTERS
	*/
	public void setTotalVariableChars(String data) {		
		this.iTotalVariableChars = parseControlData.parseTotalVariableChars(data);
	}

	public int getTotalVariableChars() {
		return iTotalVariableChars;
	}


	// 2
	/*
	POS: 5-10
	FIXED-WEATHER-STATION USAF MASTER STATION CATALOG identifier
	*/
	public void setFixedWeatherStation_USAFMasterStationCatId(String data) {
		this.sUSAFMasterStationCatId = parseControlData.parseFixedWeatherStation_USAFMasterStationCatId(data);
	}
	
	
	public String getFixedWeatherStation_USAFMasterStationCatId() {
		return sUSAFMasterStationCatId;
	}


	// 3
	/*
	POS: 11-15
	FIXED-WEATHER-STATION NCEI WBAN identifier
	*/
	public void setFixedWeatherStation_NCEIWbanId(String data) {
		this.sNCEIWbanId = parseControlData.parseFixedWeatherStation_NCEIWbanId(data);
	}

	public String getFixedWeatherStation_NCEIWbanId() {
		return sNCEIWbanId;
	}



	// 4
	/*
	POS: 16-23
	GEOPHYSICAL-POINT-OBSERVATION date
	*/
	public void setGeophysicalPointObservation_Date(String data) {
		this.sObservationDate = parseControlData.parseGeophysicalPointObservation_Date(data);
	}

	public String getGeophysicalPointObservation_Date() {
		return sObservationDate;
	}

	

	// 5
	/*
	POS: 24-27
	GEOPHYSICAL-POINT-OBSERVATION time
	*/
	public void setGeophysicalPointObservation_Time(String data) {
		this.sObservationTime = parseControlData.parseGeophysicalPointObservation_Time(data);
	}

	public String getGeophysicalPointObservation_Time() {
		return sObservationTime;
	}



	// 6
	/*
	POS: 28-28
	GEOPHYSICAL-POINT-OBSERVATION data source flag
	*/
	public void setGeophysicalPointObservation_DataSourceFlag(char dataSourceFlag) {
		this.cDataSourceFlag = parseControlData.parseGeophysicalPointObservation_DataSourceFlag(dataSourceFlag);
	}
	
	public char getGeophysicalPointObservation_DataSourceFlag() {
		return cDataSourceFlag;
	}




	// 7
	/*
	POS: 29-34
	GEOPHYSICAL-POINT-OBSERVATION latitude coordinate
	*/
	public void setGeophysicalPointObservation_LatitudeCoord(String latitudeCoord) {
		this.iLlatitudeCoord = parseControlData.parseGeophysicalPointObservation_LatitudeCoord(latitudeCoord);
	}
	
	public int getGeophysicalPointObservation_LatitudeCoord() {
		return iLlatitudeCoord;
	}



	// 8
	/*
	POS: 35-41
	GEOPHYSICAL-POINT-OBSERVATION longitude coordinate
	*/
	public void setGeophysicalPointObservation_LongitudeCoord(String longitudeCoord) {
		this.iLongitudeCoord = parseControlData.parseGeophysicalPointObservation_LongitudeCoord(longitudeCoord);
	}

	public int getGeophysicalPointObservation_LongitudeCoord() {
		return iLongitudeCoord;
	}



	// 9
	/*
	POS: 42-46
	GEOPHYSICAL-REPORT-TYPE code
	*/
	public void setGeophysicalReportType_Code(String code) {
		this.sReportTypeCode = parseControlData.parseGeophysicalReportType_Code(code);
	}
	
	public String getGeophysicalReportType_Code() {
		return sReportTypeCode;
	}



	// 10
	/*
	POS: 47-51
	GEOPHYSICAL-POINT-OBSERVATION elevation dimension
	*/
	
	public void setGeophysicalPointObservation_ElevationDimention(String elevationDimention) {
		this.iElevationDimention = parseControlData.parseGeophysicalPointObservation_ElevationDimention(elevationDimention);
	}
	
	public int getGeophysicalPointObservation_ElevationDimention() {
		return iElevationDimention;
	}




	// 11
	/*
	POS: 52-56
	FIXED-WEATHER-STATION call letter identifier
	*/

	public void setFixedWeatherStation_CallLetterId(String callLetterId) {
		this.sCallLetterId = parseControlData.parseFixedWeatherStation_CallLetterId(callLetterId);
	}
	
	public String getFixedWeatherStation_CallLetterId() {
		return sCallLetterId;
	}



	
	// 12
	/*
	POS: 57-60
	METEOROLOGICAL-POINT-OBSERVATION quality control process name
	*/
	
	public void setMeteorogicalPointObservation_QualityControlProcessName(String qualityControlProcessName) {
		this.sQualityControlProcessName = parseControlData.parseMeteorogicalPointObservation_QualityControlProcessName(qualityControlProcessName);
	}
	
	public String getMeteorogicalPointObservation_QualityControlProcessName() {
		return sQualityControlProcessName;
	}




	/*
	 * ===================================
	 *    Mandatory getters and setters
	 * -----------------------------------
	 */
	
	// 13
	/*
	POS: 61-63
	WIND-OBSERVATION direction angle
	 */
	public void setWindObservation_DirectionAngle(String directionAngle) {
		this.iDirectionAngle = parseMandatoryData.parseWindObservation_DirectionAngle(directionAngle);
	}

	public int getWindObservation_DirectionAngle() {
		return iDirectionAngle;
	}




	// 14
	/*
	POS: 64-64
	WIND-OBSERVATION direction quality code
	 */
	
	public void setWindObservation_DirectionQualityCode(char directionQualityCode) {
		this.cDirectionQualityCode = parseMandatoryData.parseWindObservation_DirectionQualityCode(directionQualityCode);
	}
	
	public char getWindObservation_DirectionQualityCode() {
		return cDirectionQualityCode;
	}



	// 15
	/*
	65-65
	WIND-OBSERVATION type code
	 */
	
	public void setWindObservation_TypeCode(char typeCode) {
		this.cWindObservationTypeCode = parseMandatoryData.parseWindObservation_TypeCode(typeCode);
	}

	public char getWindObservation_TypeCode() {
		return cWindObservationTypeCode;
	}



	// 16
	/*	 
	POS: 66-69
	WIND-OBSERVATION speed rate
	 */
	
	public void setWindObservation_SpeedRate(String speedRate) {
		this.iWindSpeedRate = parseMandatoryData.parseWindObservation_SpeedRate(speedRate);
	}
	
	public int getWindObservation_SpeedRate() {
		return iWindSpeedRate;
	}




	// 17
	/*
	POS: 70-70
	WIND-OBSERVATION speed quality code
	 */
	public char getWindObservation_SpeedQualityCode() {
		return cWindSpeedQualityCode;
	}


	public void setWindObservation_SpeedQualityCode(char speedQualityCode) {
		this.cWindSpeedQualityCode = parseMandatoryData.parseWindObservation_SpeedQualityCode(speedQualityCode);
	}


	// 18
	/*
	POS: 71-75
	SKY-CONDITION-OBSERVATION ceiling height dimension
	*/
	
	public void setSkyConditionObservation_CeilingHeightDimention(String ceilingHeightDimention) {
		this.iSkyCeilingHeightDimention = parseMandatoryData.parseSkyConditionObservation_CeilingHeightDimention(ceilingHeightDimention);
	}
	
	public int getSkyConditionObservation_CeilingHeightDimention() {
		return iSkyCeilingHeightDimention;
	}



	// 19
	/*
	POS: 76-76
	SKY-CONDTION-OBSERVATION ceiling quality code
	*/

	public void setSkyConditionObservation_CeilingQualityCode(char ceilingQualityCode) {
		this.cSkyCeilingQualityCode = parseMandatoryData.parseSkyConditionObservation_CeilingQualityCode(ceilingQualityCode);
	}

	public char getSkyConditionObservation_CeilingQualityCode() {
		return cSkyCeilingQualityCode;
	}



	// 20
	/*
	POS: 77-77
	SKY-CONDITION-OBSERVATION ceiling determination code
	*/
	
	public void setSkyConditionObservation_CeilingDeterminationCode(char ceilingDeterminationCode) {
		this.cSkyCeilingDeterminationCode = parseMandatoryData.parseSkyConditionObservation_CeilingDeterminationCode(ceilingDeterminationCode);
	}
	
	public char getSkyConditionObservation_CeilingDeterminationCode() {
		return cSkyCeilingDeterminationCode;
	}



	// 21
	/*
	POS: 78-78
	SKY-CONDITION-OBSERVATION CAVOK code
	*/

	public void setSkyConditionObservation_CavokCode(char cavokCode) {
		this.cCAVOKCode = parseMandatoryData.parseSkyConditionObservation_CavokCode(cavokCode);
	}

	public char getSkyConditionObservation_CavokCode() {
		return cCAVOKCode;
	}




	// 22
	/*
	POS: 79-84
	VISIBILITY-OBSERVATION distance dimension
	*/
	
	public void setVisibilityObservation_DistanceDimension(String distanceDimension) {
		this.iVisibilityDistanceDimension = parseMandatoryData.parseVisibilityObservation_DistanceDimension(distanceDimension);
	}
	
	public int getVisibilityObservation_DistanceDimension() {
		return iVisibilityDistanceDimension;
	}




	// 23
	/*
	POS: 85-85
	VISIBILITY-OBSERVATION distance quality code
	*/
	
	public void setVisibilityObservation_DistanceQualityCode(char distanceQualityCode) {
		this.cVisibilityDistanceQualityCode = parseMandatoryData.parseVisibilityObservation_DistanceQualityCode(distanceQualityCode);
	}
	
	public char getVisibilityObservation_DistanceQualityCode() {
		return cVisibilityDistanceQualityCode;
	}




	// 24
	/*
	POS: 86-86
	VISIBILITY-OBSERVATION variability code
	*/

	public void setVisibilityObservation_VariabilityCode(char visibilityVariabilityCode) {
		this.cVisibilityVariabilityCode = parseMandatoryData.parseVisibilityObservation_VariabilityCode(visibilityVariabilityCode);
	}

	public char getVisibilityObservation_VariabilityCode() {
		return cVisibilityVariabilityCode;
	}




	// 25
	/*
	POS: 87-87
	VISIBILITY-OBSERVATION quality variability code
	*/
	
	public void setVisibilityObservation_QualityVariablityCode(char qualityVariablityCode) {
		this.cVisibilityQualityVariablityCode = parseMandatoryData.parseVisibilityObservation_QualityVariablityCode(qualityVariablityCode);
	}
	
	
	public char getVisibilityObservation_QualityVariablityCode() {
		return cVisibilityQualityVariablityCode;
	}




	// 26
	/*
	POS: 88-92
	AIR-TEMPERATURE-OBSERVATION air temperature
	*/

	public void setAirTemperatureObservation_AirTemperature(String airTemperature) {
		this.iAirTemperature = parseMandatoryData.parseAirTemperatureObservation_AirTemperature(airTemperature);
	}

	public int getAirTemperatureObservation_AirTemperature() {
		return iAirTemperature;
	}




	// 27
	/*
	POS: 93-93
	AIR-TEMPERATURE-OBSERVATION air temperature quality code
	*/

	public void setAirTemperatureObservation_AirTemperatureQualityCode(char airTemperatureQualityCode) {
		this.cAirTemperatureQualityCode = parseMandatoryData.parseAirTemperatureObservation_AirTemperatureQualityCode(airTemperatureQualityCode);
	}

	public char getAirTemperatureObservation_AirTemperatureQualityCode() {
		return cAirTemperatureQualityCode;
	}




	// 28
	/*
	POS: 94-98
	AIR-TEMPERATURE-OBSERVATION dew point temperature
	*/

	public void setAirTemperatureObservation_DewPointTemperature(String dewPointTemperature) {
		this.iDewPointTemperature = parseMandatoryData.parseAirTemperatureObservation_DewPointTemperature(dewPointTemperature);
	}

	public int getAirTemperatureObservation_DewPointTemperature() {
		return iDewPointTemperature;
	}




	// 29
	/*
	POS: 99-99
	AIR-TEMPERATURE-OBSERVATION dew point quality code
	*/

	public void setAirTemperatureObservation_DewPointQualityCode(char dewPointQualityCode) {
		this.cDewPointQualityCode = parseMandatoryData.parseAirTemperatureObservation_DewPointQualityCode(dewPointQualityCode);
	}

	public char getAirTemperatureObservation_DewPointQualityCode() {
		return cDewPointQualityCode;
	}




	// 30
	/*
	POS: 100-104
	ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure
	*/
	
	public void setAtmosphericPressueObservation_SeaLevelPressure(String seaLevelPressure) {
		this.iSeaLevelPressure = parseMandatoryData.parseAtmosphericPressueObservation_SeaLevelPressure(seaLevelPressure);
	}
	
	public int getAtmosphericPressueObservation_SeaLevelPressure() {
		return iSeaLevelPressure;
	}




	// 31
	/*
	POS: 105-105
	ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure quality code
	*/

	public void setAtmosphericPressueObservation_SeaLevelPressureQualityCode(char seaLevelPressureQualityCode) {
		this.sSeaLevelPressureQualityCode = parseMandatoryData.parseAtmosphericPressueObservation_SeaLevelPressureQualityCode(seaLevelPressureQualityCode);
	}

	public char getAtmosphericPressueObservation_SeaLevelPressureQualityCode() {
		return sSeaLevelPressureQualityCode;
	}


	
	/*
	 *  Additional data getters and setters
	 *               TBD
	 */
	
	// 32
	public void setAdditionalData(String additionalData) {
		this.sAdditionalData = parseAdditionalData.parseAdditionalData(additionalData);
	}

	
	public String getAdditionalData() {
		return sAdditionalData;
	}


	/*
	 * ==========
	 *  
	 *   Parser
	 *   
	 * ---------- 
	 */
	
	/**
	 * 
	 * IMPORTANT: Checking out if the record's length is
	 *            less than the length of the control and 
	 *            mandatory data must be done before 
	 *            calling this parser.            
	 *            
	 *            Notes: 
	 *              According to Federal Climate Complex 
	 *            Data Documentation for ISD, both 
	 *            the control and mandatory data consist 
	 *            of 105 characters.
	 *                  
	 *              Maximum record size: 2,844 characters
	 *            
	 * @param record
	 */
	public void parse( Text record ) {
		parse(record.toString());
	}
	// ^^ parse(Text)
	

	/**
	 * 
	 * IMPORTANT: Checking out if the record's length is
	 *            less than the length of the control and 
	 *            mandatory data must be done before 
	 *            calling this parser.            
	 *            
	 *            Notes: 
	 *              According to Federal Climate Complex 
	 *            Data Documentation for ISD, both 
	 *            the control and mandatory data consist 
	 *            of 105 characters.
	 *                  
	 *              Maximum record size: 2,844 characters
	 *                   
	 * @param record
	 */
	public void parse( String record ) {
		
		final int iRecordLength = record.length();
		
		// --------------
		//  CONTROL DATA
		// --------------
		
		// 1 pos: 1-4
		setTotalVariableChars(record.substring(0, 4));
		
		// 2 pos: 5-10
		setFixedWeatherStation_USAFMasterStationCatId(record.substring(4, 10));
		
		// 3 pos: 11-15
		setFixedWeatherStation_NCEIWbanId(record.substring(10, 15));
		
		// 4 pos: 16-23
		setGeophysicalPointObservation_Date(record.substring(15, 23));
		
		// 5 pos: 24-27
		setGeophysicalPointObservation_Time(record.substring(23, 27));
		
		// 6 pos: 28-28
		setGeophysicalPointObservation_DataSourceFlag(record.charAt(27));
		
		// 7 pos: 29-34
		setGeophysicalPointObservation_LatitudeCoord(record.substring(28, 34));
		
		// 8 pos: 35-41
		setGeophysicalPointObservation_LongitudeCoord(record.substring(34, 41));
		
		// 9 pos: 42-46
		setGeophysicalReportType_Code(record.substring(41, 46));
		
		// 10 pos: 47-51
		setGeophysicalPointObservation_ElevationDimention(record.substring(46, 51));		
		
		// 11 pos: 52-56
		setFixedWeatherStation_CallLetterId(record.substring(51, 56));		
		
		// 12 pos: 57-60
		setMeteorogicalPointObservation_QualityControlProcessName(record.substring(56, 60));
		
		// ----------------
		//  MANDATORY DATA
		// ----------------
		
		// 13 pos: 61-63
		setWindObservation_DirectionAngle(record.substring(60, 63));
		
		// 14 pos: 64-64
		setWindObservation_DirectionQualityCode(record.charAt(63));
				
		// 15 pos: 65-65
		setWindObservation_TypeCode(record.charAt(64));
		
		// 16 pos: 66-69
		setWindObservation_SpeedRate(record.substring(65, 69));
		
		// 17 pos: 70-70
		setWindObservation_SpeedQualityCode(record.charAt(69));
		
		// 18 pos: 71-75
		setSkyConditionObservation_CeilingHeightDimention(record.substring(70, 75));
		
		// 19 pos: 76-76
		setSkyConditionObservation_CeilingQualityCode(record.charAt(75));
		
		// 20 pos: 77-77
		setSkyConditionObservation_CeilingDeterminationCode(record.charAt(76));
		
		// 21 pos: 78-78
		setSkyConditionObservation_CavokCode(record.charAt(77));
		
		// 22 pos: 79-84
		setVisibilityObservation_DistanceDimension(record.substring(78, 84));
		
		// 23 pos: 85-85
		setVisibilityObservation_DistanceQualityCode(record.charAt(84));
		
		// 24 pos: 86-86
		setVisibilityObservation_VariabilityCode(record.charAt(85));
		
		// 25 pos: 87-87
		setVisibilityObservation_QualityVariablityCode(record.charAt(86));
		
		// 26 pos: 88-92
		setAirTemperatureObservation_AirTemperature(record.substring(87, 92));
		
		// 27 pos: 93-93
		setAirTemperatureObservation_AirTemperatureQualityCode(record.charAt(92));
		
		// 28 pos: 94-98
		setAirTemperatureObservation_DewPointTemperature(record.substring(93, 98));
		
		// 29 pos: 99-99
		setAirTemperatureObservation_DewPointQualityCode(record.charAt(98));
		
		// 30 pos: 100-104
		setAtmosphericPressueObservation_SeaLevelPressure(record.substring(99, 104));
		
		// 31 pos: 105-105
		setAtmosphericPressueObservation_SeaLevelPressureQualityCode(record.charAt(104));			
		
		// -----------------
		//  ADDITIONAL DATA
		// -----------------
		
		// 32 pos: 106+
		if( iRecordLength > iMaxRecordLength ) {			
			setAdditionalData(record.substring(105));			
		} else {
			// there is no additional data in the record. 
			setAdditionalData("");
		}
		
	}
	// ^^ parse(string)
	
	
	/*
	 * ===========
	 *  Delegates
	 * -----------
	 */
	private ControlDataSectionParsing_ParserSimple    parseControlData    = 
			new ControlDataSectionParsing_ParserSimple();
	private MandatoryDataSectionParsing_ParserSimple  parseMandatoryData  = 
			new MandatoryDataSectionParsing_ParserSimple();
	private AdditionalDataSectionParsing_ParserSimple parseAdditionalData = 
			new AdditionalDataSectionParsing_ParserSimple();
	
}
// ^^ class NCDCParserSimple


////////////////////////
//
//    END OF FILE
//
////////////////////
