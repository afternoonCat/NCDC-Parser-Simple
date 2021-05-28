# NCDC_Parser_Simple

   This simple NCDC record parser is based on Federal Climate 
 Complex Data Documentation for Integrated Surface Data (ISD) 
 released on January 12, 2018.
 
   The purpose of this parser is to parse an ISD record and 
 get the control and mandatory data. All additional ISD data 
 (if any) is currently returned as a string due to a great 
 number of the properties and getters and setters to be 
 additionally coded. 
 
   Parsed data are stored as a String, or as  a char, or as 
 an int (where it seemed appropriate). 

   If a setter cannot parse a substring of the ISD record to 
 an int (e.g. the data is malformed), it will return either 
 a minimum value or a 'missing value' defined in Federal Climate 
 Complex Data Documentation for Integrated Surface Data (ISD) 
 for that particular part of the ISD record. 

