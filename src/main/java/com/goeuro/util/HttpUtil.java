package com.goeuro.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.apache.log4j.Logger;
import com.goeuro.exception.GoEuroClientException;

public class HttpUtil {

	private final static String BASE_URL_V2 = "http://api.goeuro.com/api/v2/";
	private final static String POSITION_SUGGEST = "position/suggest/en/";
	private final static String strGet = "GET";
	private final static Logger logger = Logger.getLogger(HttpUtil.class);

	public static final String sendGet_PositionSuggest(String city) throws GoEuroClientException {
		StringBuffer response = new StringBuffer();
		HttpURLConnection con = getHttpConnnection_GET(constructUrl_PositionSuggest(city));
		if (con != null) {
			try {
				int responseCode = con.getResponseCode();
				if (responseCode == 200) {
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
				} else
					throw new GoEuroClientException("Response code unsuccessful" + responseCode);

			} catch (GoEuroClientException e) {
				throw e;
			} catch (Exception e) {
				logger.fatal("Exception in reading the response");
				throw new GoEuroClientException("Exception in reading the response");
			}
		} else
			throw new GoEuroClientException("IOEXCEPTION in constructing HttpURLConnection");

		return response.toString();
	}

	private static final String constructUrl_PositionSuggest(String city) {
		StringBuilder urlBuilber = new StringBuilder();
		urlBuilber.append(BASE_URL_V2);
		urlBuilber.append(POSITION_SUGGEST);
		urlBuilber.append(city);
		logger.info("URL formed is" + urlBuilber.toString());
		return urlBuilber.toString();
	}

	private static final HttpURLConnection getHttpConnnection_GET(String url) {

		HttpURLConnection con = null;
		URL obj;
		try {
			obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod(strGet);
			logger.info("HttpURLConnection Successfull created");
		} catch (IOException e1) {
			logger.fatal("IOEXCEPTION in constructing HttpURLConnection");
		}

		return con;

	}

}
