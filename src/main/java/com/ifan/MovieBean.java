package com.ifan;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class MovieBean implements Writable {

    private long movie;
    private long rate;
    private long timeStamp;
    private long uid;

    public MovieBean()
    {
    }

    public MovieBean(Long movie,Long rate,Long timeStamp,Long uid)
    {
        super();
        this.movie = movie;
        this.rate = rate;
        this.timeStamp = timeStamp;
        this.uid = uid;
    }

    public long getMovie() {
        return movie;
    }

    public long getRate() {
        return rate;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public long getUid() {
        return uid;
    }

    public void setMovie(long movie) {
        this.movie = movie;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.movie = dataInput.readLong();
        this.rate = dataInput.readLong();
        this.timeStamp = dataInput.readLong();
        this.uid = dataInput.readLong();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException{
        dataOutput.writeLong(movie);
        dataOutput.writeLong(rate);
        dataOutput.writeLong(timeStamp);
        dataOutput.writeLong(uid);
    }
}
