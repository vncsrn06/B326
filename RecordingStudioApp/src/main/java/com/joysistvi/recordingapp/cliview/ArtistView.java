package com.joysistvi.recordingapp.cliview;

import com.joysistvi.recordingapp.controller.ArtistController;
import com.joysistvi.recordingapp.model.Artist;

import java.util.List;
import java.util.Scanner;

public class ArtistView {
    private final ArtistController artistController;
    private final Scanner scanner;

    public ArtistView(ArtistController artistController, Scanner scanner) {
        this.artistController = artistController;
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println("\n ------- Artist Management ------- ");
        System.out.println("1. View All Artists");
        System.out.println("2. Search Artists");
        System.out.println("3. Add Artists");
        System.out.println("4. Update Artists");
        System.out.println("5. Archive Artists");
        System.out.println("6. Delete Artists");
        System.out.println("7. View All Archived Artists");
        System.out.println("0. Back");
    }

    public int promptChoice() {
        System.out.print("Choice: ");
        return readInt();
    }

    private int readInt() {
        while (true) {
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private void viewAllArtists() {
        System.out.println("\n ----- View All Artists -----");

        List<Artist> artists = artistController.handleViewAllArtist();
        printArtists(artists);
    }

    private void searchArtist() {
        System.out.println("\n ----- Search Artists -----");
        System.out.print("Enter name: ");

        String keyword = scanner.nextLine();

        // Replace this with your controller's search method if available.
        List<Artist> artists = artistController.handleViewAllArtist();

        printArtists(artists);
    }

    private void addArtist() {
        System.out.println("\n ----- Add Artist -----");
        System.out.print("Name: ");

        String name = scanner.nextLine();

        Artist artist = new Artist(name);

        boolean isSuccess = artistController.handleCreateArtist(artist);

        System.out.println(
                isSuccess
                        ? "Artist added successfully."
                        : "Failed to add artist."
        );

        if (isSuccess) {
            System.out.println();
            viewAllArtists();
        }
    }

    public void updateArtists() {
        System.out.println("\n ----- Update Artist -----");

        // Show all artists first so the admin can see which ID to pick.
        viewAllArtists();

        System.out.print("Artist ID to update: ");
        int id = readInt();

        Artist current = artistController.handleGetArtistById(id);

        if (current == null) {
            System.out.println(
                    "No artist found with ID " + id + ". Please check the ID and try again."
            );
            return;
        }

        System.out.print(
                "New name [" + current.getName() +
                        "] (press Enter to keep the current): ");

        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            name = current.getName();
        }

        Artist artist = new Artist(id, name);

        // Use your controller's UPDATE method here.
        boolean isSuccess = artistController.handleUpdateArtist(artist);

        System.out.println(
                isSuccess
                        ? "Artist updated successfully."
                        : "Failed to update artist."
        );

        if (isSuccess) {
            System.out.println();
            viewAllArtists();
        }
    }

    public void printArtists(List<Artist> artists) {
        if (artists.isEmpty()) {
            System.out.println("No artists found.");
            return;
        }

        String border =
                "+" + "-".repeat(6) +
                        "+" + "-".repeat(27) +
                        "+";

        System.out.println(border);
        System.out.printf("| %-4s | %-25s |%n", "ID", "Name");
        System.out.println(border);

        for (Artist artist : artists) {
            System.out.printf(
                    "| %-4s | %-25s |%n",
                    artist.getId(),
                    artist.getName()
            );
        }

        System.out.println(border);
    }
}