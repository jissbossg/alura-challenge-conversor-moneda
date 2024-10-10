package com.alura.Modelo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRateAPI {
    private static final String API_KEY = "fc33d5c1e984d4201886879f"; // Reemplaza con tu API key
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY;

    public List<Currency> getCurrencyList() {
        List<Currency> currencies = new ArrayList<>();
        try {
            URL url = new URL(BASE_URL + "/codes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

            if (jsonResponse.get("result").getAsString().equals("success")) {
                jsonResponse.getAsJsonArray("supported_codes").forEach(code -> {
                    JsonArray currency = code.getAsJsonArray();
                    currencies.add(new Currency(currency.get(0).getAsString(), currency.get(1).getAsString()));
                });
            } else {
                System.out.println("Error en la respuesta de la API: " + jsonResponse.get("error-type").getAsString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencies;
    }

    public void showCurrencyList() {
        for (Currency c : getCurrencyList()) {
            System.out.printf("Nombre : %s , Codigo :  %s \n",c.getName(),c.getCode());
        }
    }

    public double getConversionRate(String baseCurrency, String targetCurrency) {
        try {
            URL url = new URL(BASE_URL + "/latest/" + baseCurrency);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

            if (jsonResponse.get("result").getAsString().equals("success")) {
                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
                if (conversionRates != null && conversionRates.has(targetCurrency)) {
                    return conversionRates.get(targetCurrency).getAsDouble();
                } else {
                    System.out.println("La tasa de conversión para " + targetCurrency + " no está disponible.");
                    return -1; // Indicador de error
                }
            } else {
                System.out.println("Error en la respuesta de la API: " + jsonResponse.get("error-type").getAsString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Indicador de error
    }
}
