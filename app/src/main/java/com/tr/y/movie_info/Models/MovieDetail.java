package com.tr.y.movie_info.Models;

import java.util.ArrayList;

/**
 * Created by y on 08-Apr-19.
 */

public class MovieDetail {

        private boolean adult;
        private String backdrop_path;
        PosterAndBackDrop Belongs_to_collectionObject;
        private float budget;
        ArrayList< genere > genres = new ArrayList < genere>() ;
        private String homepage;
        private float id;
        private String imdb_id;
        private String original_language;
        private String original_title;
        private String overview;
        private float popularity;
        private String poster_path;
        ArrayList < PCompanies > production_companies = new ArrayList < PCompanies>() ;
        ArrayList < Pcountries > production_countries = new ArrayList < Pcountries>() ;
        private String release_date;
        private float revenue;
        private float runtime;
        ArrayList < Object > spoken_languages = new ArrayList < Object > ();
        private String status;
        private String tagline;
        private String title;
        private boolean video;
        private float vote_average;
        private float vote_count;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public PosterAndBackDrop getBelongs_to_collectionObject() {
        return Belongs_to_collectionObject;
    }

    public void setBelongs_to_collectionObject(PosterAndBackDrop belongs_to_collectionObject) {
        Belongs_to_collectionObject = belongs_to_collectionObject;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public ArrayList<genere> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<genere> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public ArrayList<PCompanies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(ArrayList<PCompanies> production_companies) {
        this.production_companies = production_companies;
    }

    public ArrayList<Pcountries> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(ArrayList<Pcountries> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public float getRuntime() {
        return runtime;
    }

    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }

    public ArrayList<Object> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(ArrayList<Object> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }


    // Getter Methods

    }


