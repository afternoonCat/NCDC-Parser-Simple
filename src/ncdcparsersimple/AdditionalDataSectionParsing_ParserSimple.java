package ncdcparsersimple;

/**
 * 
 * TODO  This class' methods provide an opportunity to analyze the 
 *       Additional data of an ISD record before it will be stored 
 *       and to return the data as it seems appropriate.
 *  
 *   Currently, all additional data is returned as a sting as is due to 
 * a great number of the methods to be additionally coded. 
 * 
 * @author BusyBee
 *
 */
class AdditionalDataSectionParsing_ParserSimple {
	
	/*
	Note: For the quality code fields with each data element, the following may appear in data which were processed through
	NCEI’s Interactive QC system (manual interaction), for selected parameters:
	A – Data value flagged as suspect, but accepted as good value.
	U – Data value replaced with edited value.
	P – Data value not originally flagged as suspect, but replaced by validator.
	I – Data value not originally in data, but inserted by validator.
	M - Manual change made to value based on information provided by NWS or FAA
	C - Temperature and dew point received from Automated Weather Observing Systems (AWOS) are reported in whole
	degrees Celsius. Automated QC flags these values, but they are accepted as valid.
	R - Data value replaced with value computed by NCEI software.
	*/
	
	String parseAdditionalData(String data) {
		//      Currently, this method will return 
		//      everything that goes after the record's 
		//      105th character as is (if any). 
		return data;
	}

}
// ^^ class AdditionalDataSectionParsing_ParserSimple

////////////////////////
//
//    END OF FILE
//
////////////////////
