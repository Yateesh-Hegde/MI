package com.tr.y.movie_info.Models;

import java.util.ArrayList;

/**
 * Created by y on 07-Apr-19.
 */

public class PMResponseModel {

        private float page;
        private float total_results;
        private float total_pages;

    public ArrayList<MovieInfo> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieInfo> results) {
        this.results = results;
    }

    ArrayList< MovieInfo > results = new ArrayList < >()  ;


        // Getter Methods

        public float getPage() {
            return page;
        }

        public float getTotal_results() {
            return total_results;
        }

        public float getTotal_pages() {
            return total_pages;
        }

        // Setter Methods

        public void setPage(float page) {
            this.page = page;
        }

        public void setTotal_results(float total_results) {
            this.total_results = total_results;
        }

        public void setTotal_pages(float total_pages) {
            this.total_pages = total_pages;
        }
    }