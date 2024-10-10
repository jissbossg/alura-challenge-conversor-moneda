package com.alura.Modelo;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    private String userName;
    private String baseCodeCurrency;
    private String targetCodeCurrency;
    private double valueToConvert;
    private double convertedValue;
    private String currentDateTime;


    public Conversion(String userName, String baseCodeCurrency, String targetCodeCurrency, double valueToConvert, double convertedValue) {
        this.userName = userName;
        this.baseCodeCurrency = baseCodeCurrency;
        this.targetCodeCurrency = targetCodeCurrency;
        this.valueToConvert = valueToConvert;
        this.convertedValue = convertedValue;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        this.currentDateTime = formattedDateTime;
    }

    public String fileName() {
        return "history";
    }

    public String getTargetCodeCurrency() {
        return targetCodeCurrency;
    }

    public double getValueToConvert() {
        return valueToConvert;
    }

    public String getUser() {
        return userName;
    }

    public String getBaseCodeCurrency() {
        return baseCodeCurrency;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

   private  String formatCustomCurrency(double amount) {
        // Usar DecimalFormat para la parte entera
        DecimalFormat df = new DecimalFormat("#,###");
        String integerPart = df.format((long) amount);

        // Obtener la parte decimal
        String decimalPart = String.format("%.2f", amount).split("\\.")[1];

        // Combinar las partes
        return integerPart + "." + decimalPart;
    }

    public String formater() {
        return "Usuario=" + this.userName +
                ", Tasa de origen=" + this.baseCodeCurrency +
                ", Valor a cambiar=" + String.format("%.2f", this.valueToConvert) +
                ", Tasa de cambio=" + this.targetCodeCurrency +
                ", Valor cambiado=" + String.format("%.2f", this.convertedValue) +
                ", Fecha y hora de la transaccion=" + this.currentDateTime;
    }
    /*@Override
    public String toString() {
        return user +
                ", baseCodeCurrency:" + baseCodeCurrency +
                ", targetCodeCurrency:" + targetCodeCurrency +
                ", valueToConvert:" + String.valueOf(valueToConvert) +
                ", convertedValue:" + String.valueOf(convertedValue) +
                ", currentDateTime:" + currentDateTime.toString();
    }*/

   /* @Override
    public String toString() {
        return "Conversion{" +
                "user:" + userName +
                ",baseCodeCurrency:" + baseCodeCurrency.toString() +
                ",targetCodeCurrency:" + targetCodeCurrency.toString() +
                ",valueToConvert:" + String.valueOf(valueToConvert) +
                ",convertedValue:" + String.valueOf(convertedValue)  +
                ",currentDateTime:" +  currentDateTime.toString() +
                "}";
    }*/
}
