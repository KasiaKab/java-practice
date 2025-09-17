package com.kasiakab.clientexplorer;

import java.util.List;

public class ClientApp {

    private ConsoleHandler consoleHandler;
    private ClientService clientService;

    public ClientApp() {
        this.consoleHandler = new ConsoleHandler();
        this.clientService = new ClientService();
    }

    public void run() {

        consoleHandler.showInLine("Reading file clients.csv...");
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(700);
                consoleHandler.showProgress(".");
            }
            consoleHandler.newLine();
        } catch (InterruptedException e) {
            consoleHandler.newLine();
            consoleHandler.showMessage("Reading file clients.csv interrupted.");
        }

        List<Client> clientsList = clientService.loadClientsFromFile();

        Client mostValuableClient = clientService.findMostValuableClient(clientsList);
        consoleHandler.showMessage("The most valuable client is: \n" + mostValuableClient);


        consoleHandler.showMessage("Please enter the country: ");
        String country = consoleHandler.readLine();

        List<Client> clientsFromCountry = clientService.findClientsFromCountry(clientsList, country);

        if (clientsFromCountry.isEmpty()) {
            consoleHandler.showMessage("No client from the country %s found." + String.format(country));
        } else {
            consoleHandler.showMessage("Clients from country: \n");
        }
        for (Client client : clientsFromCountry) {
            consoleHandler.showMessage(client.toString());
        }

        double calculateAvgValue = clientService.calculateAvgValue(clientsFromCountry);
        consoleHandler.showMessage("The avarage value for a client is: " + String.format("%.2f", calculateAvgValue));


    }

}