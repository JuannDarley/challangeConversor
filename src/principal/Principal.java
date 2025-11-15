package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Conversor;
import modelos.ExchangeResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String opcao = "";
        String texto = "";

        DecimalFormat df = new DecimalFormat("#,##0.000000");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();




        while (!texto.equalsIgnoreCase("sair")){

            System.out.println("****************************");
            System.out.println("1- Dolar -> Peso Argentino");
            System.out.println("2- Peso Argentino -> Dolar");
            System.out.println("3- Dolar -> Real Brasileiro");
            System.out.println("4- Real Brasileiro -> Peso Dolar");
            System.out.println("5- Dolar -> Peso Colombiano");
            System.out.println("6- Peso Colombiano -> Dolar");
            System.out.println("0- Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("*****************************");

            opcao = leitura.nextLine();

            if(opcao.equalsIgnoreCase("0")){
                texto = "sair";
                break;
            }

            // Dola -> Peso Argentino ARS

            if(opcao.equalsIgnoreCase("1")){
                texto = "USD";

                String endereco = "https://v6.exchangerate-api.com/v6/" + "c8f0983789ad4293a13d680a" + "/latest/" + texto.replace(" ", "+");
                System.out.println(endereco);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                ExchangeResponse dados = gson.fromJson(json, ExchangeResponse.class);

                Double ars = dados.getConversion_rates().get("ARS");
                System.out.println("1 USD = " + ars + " ARS");
            }

            // Peso Argentino -> Dolar USD

            if(opcao.equalsIgnoreCase("2")){
                texto = "ARS";

                String endereco = "https://v6.exchangerate-api.com/v6/" + "c8f0983789ad4293a13d680a" + "/latest/" + texto.replace(" ", "+");
                System.out.println(endereco);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                ExchangeResponse dados = gson.fromJson(json, ExchangeResponse.class);

                Double ars = dados.getConversion_rates().get("USD");
                System.out.println("1 ARS = " + df.format(ars) + " USD");

            }

            // Dolar -> Real Brasileiro BRL

            if(opcao.equalsIgnoreCase("3")){
                texto = "USD";

                String endereco = "https://v6.exchangerate-api.com/v6/" + "c8f0983789ad4293a13d680a" + "/latest/" + texto.replace(" ", "+");
                System.out.println(endereco);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                ExchangeResponse dados = gson.fromJson(json, ExchangeResponse.class);

                Double ars = dados.getConversion_rates().get("BRL");
                System.out.println("1 USD = " + ars + " BRL");

            }

            // Ral Brasileiro -> Dolar; USD

            if(opcao.equalsIgnoreCase("4")){
                texto = "BRL";

                String endereco = "https://v6.exchangerate-api.com/v6/" + "c8f0983789ad4293a13d680a" + "/latest/" + texto.replace(" ", "+");
                System.out.println(endereco);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                ExchangeResponse dados = gson.fromJson(json, ExchangeResponse.class);

                Double ars = dados.getConversion_rates().get("USD");
                System.out.println("1 BRL = " + ars + " USD");

            }

            // Dolar -> Peso Colombiano COP

            if(opcao.equalsIgnoreCase("5")){
                texto = "USD";

                String endereco = "https://v6.exchangerate-api.com/v6/" + "c8f0983789ad4293a13d680a" + "/latest/" + texto.replace(" ", "+");
                System.out.println(endereco);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                ExchangeResponse dados = gson.fromJson(json, ExchangeResponse.class);

                Double ars = dados.getConversion_rates().get("COP");
                System.out.println("1 USD = " + ars + " COP");

            }

            // Peso Colombiano -> Dolar USD

            if(opcao.equalsIgnoreCase("6")){
                texto = "COP";

                String endereco = "https://v6.exchangerate-api.com/v6/" + "c8f0983789ad4293a13d680a" + "/latest/" + texto.replace(" ", "+");
                System.out.println(endereco);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                ExchangeResponse dados = gson.fromJson(json, ExchangeResponse.class);

                Double ars = dados.getConversion_rates().get("USD");
                System.out.println("1 COP = " + df.format(ars) + " USD");
            }



        }
        }




}
