package com.example.cantor.api.connector;

import com.example.cantor.exeption.NBPResponseException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Component("com.example.cantor.api.connector.NBPApiConnector")
public class NBPApiConnector {

    public StringBuffer getExchangeRates(URL url) throws IOException, NBPResponseException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        if (status == 404) {
            throw new NBPResponseException("Currency code not allowed");
        } else {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            return content;
        }
    }
}
