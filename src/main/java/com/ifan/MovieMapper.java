package com.ifan;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MovieMapper extends Mapper<LongWritable,Text,LongWritable,MovieBean> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        MovieBean movieBean = JsonUtils.jsonToPojo(value.toString(),MovieBean.class);

        context.write(new LongWritable(movieBean.getUid()),movieBean);
    }
}
