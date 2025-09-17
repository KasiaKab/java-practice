package com.kasiakab.clientexplorer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {


    public List<Client> loadClientsFromFile() {
        List<Client> clients = new ArrayList<>();

        try (
                var fileReader = new FileReader
                        ("C:/Users/kasia/Java Learning/my-java-practice/java-practice/src/main/java/com/kasiakab/clientexplorer/clients.csv");
                var bufferedReader = new BufferedReader(fileReader);
        ) {
            String line;
            boolean isFirstLine = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // pomijam nagłówek
                }

                createClient(line, clients);
            }

        } catch (IOException ex) {
            System.err.println("Error reading file" + ex.getMessage());
        }
        return clients;
    }

    private static void createClient(String line, List<Client> clients) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0]);
        String firstName = parts[1];
        String lastName = parts[2];
        String country = parts[3];
        double value = Double.parseDouble(parts[4]);

        Client client = new Client(id, firstName, lastName, country, value);
        clients.add(client);
    }

    public Client findMostValuableClient(List<Client> clients) {

        if (clients == null || clients.isEmpty()) {
            throw new IllegalArgumentException("No client found");
        }
        Client mostValuableClient = clients.get(0);
        for (Client client : clients) {
            if (client.getValue() > mostValuableClient.getValue()) {
                mostValuableClient = client;
            }
        }
        return mostValuableClient;
    }

    public List<Client> findClientsFromCountry(List<Client> clients, String country) {

        List<Client> clientsFromCountry = new ArrayList<>();
        for (Client client : clients) {
            if (client.getCountry().equals(country)) {
                clientsFromCountry.add(client);
            }
        }
        return clientsFromCountry;
    }

    public double calculateAvgValue(List<Client> clients) {
        if (clients == null || clients.isEmpty()) {
            throw new IllegalArgumentException("No client found");
        }
        double sum = 0;
        for (Client client : clients) {
            sum += client.getValue();
        }
        return sum / clients.size();
    }


}
