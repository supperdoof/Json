package com.ifan;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieReducer extends Reducer<LongWritable,MovieBean,LongWritable,Text> {
    @Override
    protected void reduce(LongWritable key, Iterable<MovieBean> values, Context context)
        throws IOException, InterruptedException {

        List<MovieBean> movieBeanList = new ArrayList<>();

        for(MovieBean movieBean : values)
        {
            MovieBean bean = new MovieBean();
            bean.setMovie(movieBean.getMovie());
            bean.setRate(movieBean.getRate());
            bean.setTimeStamp(movieBean.getTimeStamp());
            bean.setUid(movieBean.getUid());

            movieBeanList.add(bean);
        }


        for(int i=0; i<movieBeanList.size();i++)
        {
            context.write(key,new Text("Rate:"+movieBeanList.get(i).getRate()+" TimeStamp:"+movieBeanList.get(i).getTimeStamp()+" Uid:"+movieBeanList.get(i).getUid()));
        }

    }
}
