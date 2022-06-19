package ru.netology.movie;

public class MovieManager {

    private int maxLimit = 10;

    public MovieManager() {

    }

    public MovieManager(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    private MovieData[] records = new MovieData[0];

    public void add(MovieData record) {
        int length = records.length + 1;
        MovieData[] tmp = new MovieData[length];
        for (int i = 0; i < records.length; i++) {
            tmp[i] = records[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = record;
        records = tmp;
    }

    public MovieData[] findAll() {
        return records;
    }

    public void removeById(int id) {
        int length = records.length - 1;
        MovieData[] tmp = new MovieData[length];
        int index = 0;
        for (MovieData record : records) {
            if (record.getId() != id) {
                tmp[index] = record;
                index++;
            }
        }
        records = tmp;
    }

    public MovieData[] findLast() {
        int resultLength;
        if (maxLimit < records.length) {
            resultLength = maxLimit;
        } else {
            resultLength = findAll().length;
        }
        MovieData[] result = new MovieData[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = records.length - i - 1;
            result[i] = records[index];
        }
        return result;
    }

}
