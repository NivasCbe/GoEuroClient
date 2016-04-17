package com.goeuro.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.goeuro.domain.PositionData;
import com.goeuro.exception.GoEuroClientException;
import com.google.gson.Gson;

import au.com.bytecode.opencsv.CSVWriter;

public class DataUtil {
	
	private static final String fileName="Postition.csv";
	private static final String strLatitudeKey="latitude";
	private static final String strLongitudeKey="longitude";
	private final static Logger logger = Logger.getLogger(DataUtil.class);
	
	public static final boolean writeResponseToCSV(String response) throws GoEuroClientException {
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(fileName));
			ArrayList<PositionData> positionDataList = getPositionDataFromResponse(response);
			int i=0;
			if (positionDataList != null && !positionDataList.isEmpty()) {
				for (PositionData currentPositionData : positionDataList) {
					if(currentPositionData.getGeo_position()!=null){
					String[] currentTuple = new String[] {String.valueOf(i++),currentPositionData.getName(),currentPositionData.getType(), currentPositionData.getGeo_position().get(strLatitudeKey),
							currentPositionData.getGeo_position().get(strLongitudeKey) };
					writer.writeNext(currentTuple);
					}
				}
			}
			writer.close();
			return true;
		} catch (IOException e) {
			logger.fatal("Exception in writing the respose to CSV");
			throw new GoEuroClientException("Exception in writing the respose to CSV");
		}
	}
	
	
	public static final ArrayList<PositionData> getPositionDataFromResponse(String response)  throws GoEuroClientException {
		ArrayList<PositionData> positionDataList=new ArrayList<PositionData>();
		try {
			JSONParser parser=new JSONParser();
			String locType =null;
			PositionData positionData=new PositionData();
			JSONArray responseArray = (JSONArray)parser.parse(response);
			for(int i=0;i<responseArray.size();i++){
				positionData = new Gson().fromJson(responseArray.get(i).toString(), PositionData.class); 
				positionDataList.add(positionData);
				positionData=new PositionData();
			}
		} catch (ParseException e) {
			logger.fatal("Exception in parsing the response");
			throw new GoEuroClientException("Exception parsing the response");
		}
		return positionDataList;
	}

}
