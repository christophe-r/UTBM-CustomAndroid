package fr.utbm.lo52.CustomAndroid.mediacenter.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmars on 08/12/2016.
 */

public class Season implements Serializable {

        private String title;
        private String year;
        private String illustrationPath;
        private String actors;
        private String seasonNumber;
        private List<Episode> episodes;

        public Season(String title, String year, String illustrationPath, String actors, String seasonNumber) {
            this.title = title;
            this.year = year;
            this.illustrationPath = illustrationPath;
            this.actors = actors;
            this.seasonNumber = seasonNumber;
            this.episodes = new ArrayList<>();
        }

        public void addEpisode(Episode episode) {
            this.episodes.add(episode);
        }

        public List<Episode> getEpisodes() {
            return this.episodes;
        }

        public String getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(String seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getIllustrationPath() {
            return illustrationPath;
        }

        public void setIllustrationPath(String illustrationPath) {
            this.illustrationPath = illustrationPath;
        }

        public String getActors() {
            return actors;
        }

        public void setActors(String actors) {
            this.actors = actors;
        }

    }