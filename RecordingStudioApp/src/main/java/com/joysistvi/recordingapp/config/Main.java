package com.joysistvi.recordingapp.config;

import com.joysistvi.recordingapp.dao.ArtistDao;

public class Main {

    public static void main(String[] args) {

        // Create database connection
        DbConnection db = new DbConnection();

        // Create Artist DAO
        ArtistDao artistDao = new ArtistDao(db);

        // CREATE
        // artistDao.createArtist("Justin");

        // READ
        artistDao.readAllArtists();

        // UPDATE
        // artistDao.updateArtist("Vince", 1);

        // ARCHIVE
        // artistDao.archiveArtist(1);

        // RESTORE
        // artistDao.restoreArtist(1);

        // DELETE
        // artistDao.deleteArtist(1);
    }
}