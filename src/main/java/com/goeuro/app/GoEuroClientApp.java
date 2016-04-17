package com.goeuro.app;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.goeuro.exception.GoEuroClientException;
import com.goeuro.util.DataUtil;
import com.goeuro.util.HttpUtil;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * Hello world!
 *
 */
public class GoEuroClientApp 
{
	private final static Logger logger = Logger.getLogger(GoEuroClientApp.class);
	
    public static void 	main( String[] args )
	{
		if (args!=null && args.length > 0) {
			try {
				String cityName=args[0];
				String response = HttpUtil.sendGet_PositionSuggest(cityName.toLowerCase());
				if(DataUtil.writeResponseToCSV(response))
					System.out.println("SUCCESS - read and stored the date from URL");
			}catch(GoEuroClientException e){
				logger.error("Failure in getting and storing the response "+e.getMessage());
				System.out.println("Failure in getting and storing the response "+e.getMessage());
			}
			catch (Exception e) {
				logger.error("Failure in getting and storing the response "+e.getMessage());
				System.out.println("Failure in getting and storing the response "+e.getMessage());
			}
		}
	}
    
}
