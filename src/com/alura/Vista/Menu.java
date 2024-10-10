package com.alura.Vista;


import com.alura.Modelo.Conversion;
import com.alura.Modelo.ConversionFile;
import com.alura.Modelo.ExchangeRateAPI;
import com.alura.Modelo.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ExchangeRateAPI api;
    private User user;
    private Conversion covert;
    private List<Conversion> conversionHistory;
    private ArrayList<String> messages;
    private int type;

    public Menu() {
        api = new ExchangeRateAPI();
        scanner = new Scanner(System.in);
        conversionHistory = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public ExchangeRateAPI getApi() {
        return api;
    }

    private boolean insertUser() {
        System.out.println("Bienvenido al sistema conversor de moneda");
        System.out.println("Por favor ingrese su nombre de usuario:");
        String name = scanner.nextLine();
        // Validar que el nombre no esté vacío y que solo contenga texto
        if (name != null && !name.trim().isEmpty()) {
            // Aquí puedes agregar más validaciones si es necesario
            System.out.println("Nombre de usuario válido: " + name);
            System.out.println("Iniciando sistema......");
            user = new User(name);
            return true; // Indica que la inserción fue exitosa
        } else {
            System.out.println("El nombre de usuario no puede estar vacío. Inténtalo de nuevo.");
        }
        return false;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public void showOpcions(int type) {
        messages.clear();
        setType(type);
        if (getType() == 1) {
            messages.add("Seleccione una tasa de cambio:");
            messages.add("1) Dólar ==> Peso Argentino");
            messages.add("2) Peso Argentino ==> Dólar");
            messages.add("3) Dólar ==> Real Brasileño");
            messages.add("4) Real Brasileño ==> Dólar");
            messages.add("5) Dólar ==> Peso Colombiano");
            messages.add("6) Peso Colombiano ==> Dólar");
            messages.add("7) Ver histroial de esta sesion");
            messages.add("0) Salir");
        } else if (getType() == 2) {
            messages.add("Que desea hacer");
            messages.add("1) Realizar otra conversión en la misma tasa de cambio");
            messages.add("2) Escojer otra tasa de cambio");
            messages.add("3) Ver histroial de esta sesion");
            messages.add("4) Salir"); // Nueva opción para salir
        } else if (getType() == 3) {
            messages.add("Que desea hacer");
            messages.add("1) Escojer otra tasa de cambio");
            messages.add("0) Salir"); // Nueva opción para salir
        } else if (getType() == 4) {
            messages.add("Que desea hacer");
            messages.add("1) Escojer otra tasa de cambio");
            messages.add("0) Salir"); // Nueva opción para salir
        } else if (getType() == 5) {
            messages.add("Seleccione una tasa de cambio:");
            messages.add("1) Dólar ==> Peso Mexicano");
            messages.add("2) Peso Mexicano ==> Dólar");
            messages.add("3) Dólar ==> Boliviano Bolivia");
            messages.add("4) Boliviano Bolivia ==> Dólar");
            messages.add("5) Dólar ==> Peso Chileno");
            messages.add("6) Peso Chileno ==> Dólar");
            messages.add("8) Volver al menu anterior");
            messages.add("0) Salir");
        } else {
            messages.add("Opción no válida.");
        }
       /* for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }*/

        for (String message : messages) {
            System.out.println(message);
        }
    }


    public void goOut() {
        System.out.println("Gracias por utilizar el conversor de moneda...");
        System.out.println("Saliendo...");
        System.exit(0); // Termina el programa
    }

    public String allHistoryUser() {
        String result ="";
        try {
            result = "Historial generado " + covert.getCurrentDateTime();
            int i = 1;
            for (Conversion conver : conversionHistory) {
                result += "\n" + (i++) + ". " + conver.formater();
            }

            //history().forEach(c -> c.toString());
       } catch (NullPointerException e) {
            result ="No se han realizado cambios";
        }
        return result;

    }

    private void selectOptions(int option) {

        switch (option) {
            case 1:
                if (getType() == 1) {
                    performConversion("USD", "ARS");
                } else {
                    performConversion("USD", "MXN");
                }
                break;
            case 2:
                if (getType() == 1) {
                    performConversion("ARS", "USD");
                } else {
                    performConversion("MXN", "USD");
                }
                break;
            case 3:
                if (getType() == 1) {
                    performConversion("USD", "BRL");
                } else {
                    performConversion("USD", "BOB");
                }
                break;
            case 4:
                if (getType() == 1) {
                    performConversion("BRL", "USD");
                } else {
                    performConversion("BOB", "USD");
                }
                break;
            case 5:
                if (getType() == 1) {
                    performConversion("USD", "COP");
                } else {
                    performConversion("USD", "CLP");
                }
                break;
            case 6:
                if (getType() == 1) {
                    performConversion("COP", "USD");
                } else {
                    performConversion("CLP", "USD");
                }
                break;
            case 7:
                System.out.println(allHistoryUser());
                break;
            case 8:
                showOpcions(1);
                setType(5);
                break;
            case 0:
                goOut();
                break;
            default:
                break;
        }
    }

    public void pages() {
        if (getType() != 5) {
            showOpcions(1);
        }
    }

    public void showMenu() {
        while (insertUser()) {
            int option;
            do {
                pages();
                while (true) {
                    try {
                        option = Integer.parseInt(scanner.nextLine());
                        if (option >= 0 && option <= 7) {
                            break;
                        } else {
                            System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    }
                }
                selectOptions(option);
            } while (option != 0);
        }
    }

    private void performConversion(String baseCurrency, String targetCurrency) {
        boolean anotherConversion = true;

        while (anotherConversion) {
            System.out.printf("Ingresa la cantidad de %s a convertir en %s: ", baseCurrency, targetCurrency);

            double amount = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    amount = scanner.nextDouble();
                    validInput = true;
                    // Limpiar el buffer después de leer el número
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingresa un número.");
                    scanner.nextLine(); // Limpiar el buffer
                }
            }

            double conversionRate = getApi().getConversionRate(baseCurrency, targetCurrency);

            if (conversionRate != -1) {
                double convertedAmount = amount * conversionRate;
                System.out.printf("%.2f %s es igual a %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
                covert = new Conversion(user.getName(), baseCurrency, targetCurrency, amount, convertedAmount);
                conversionHistory.add(covert);
                ConversionFile.writeJson(covert);

            } else {
                System.out.println("Error al obtener la tasa de cambio. Verifica las monedas ingresadas.");
            }

            showOpcions(2);

            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1 && getType() == 2) {
                        anotherConversion = true; // Continuar la conversión
                        break;
                    } else if (choice == 2 && getType() == 2) {
                        anotherConversion = false; // Volver al menú
                        break;
                    } else if (choice == 3 && getType() == 2) {
                        System.out.println(allHistoryUser());
                        showOpcions(3);
                    } else if (choice == 4 && getType() == 2) {
                        goOut();
                    } else if (choice == 0 && getType() == 3) {
                        goOut();
                    } else if (choice == 1 && getType() == 3) {
                        anotherConversion = false; // Volver al menú
                        break;
                    } else {
                        System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                }
            }
        }
    }
}
