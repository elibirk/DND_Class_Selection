package com.example.spec.dnd_class_selection;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Spec on 2/13/2017.
 */

public class LAdapter extends ArrayAdapter{
    private Activity context_;
    private String[] classes_;
    //Constructor
    public LAdapter(Activity context, String[] classes){
        super(context, R.layout.type2, classes); //call the base class ArrayAdapter's constructor

        context_ = context;        //initialize private member variable
        this.classes_ = classes;   //initialize private member variable
    }//end LAdapter constructor

    //Inflate row.xml for each row.
    public View getView(int position, View convertView, ViewGroup parent){
        if (position % 2 == 0){ //if an even position, use layout one
            if(convertView == null) {
                LayoutInflater inflater = context_.getLayoutInflater();
                convertView = inflater.inflate(R.layout.type1, null);
            } //inflates the layout if it isn't already

            //view holder object for a row, so we can reduce the number of times calling
            //findViewById();
            ViewHolder holder = (ViewHolder) convertView.getTag();

            //If a row does not have a view holder, create a new object for the row.
            if(holder == null) {
                holder = new ViewHolder(convertView);
                holder.tv_link.setText(classes_[position]);
                convertView.setTag(holder);
            } else{
                //if the row has a view holder, reuse it.
                holder.tv_link.setText(classes_[position]);
            }//end else

            //return the row's view object.
            return convertView;

        } else { //if an odd position use layout two
            if (convertView == null){
                LayoutInflater inflater = context_.getLayoutInflater();
                convertView = inflater.inflate(R.layout.type2, null);
            }//inflates the layout if it isn't already

            //view holder object for a row, so we can reduce the number of times calling
            //findViewById();
            ViewHolder holder = (ViewHolder) convertView.getTag();

            //If a row does not have a view holder, create a new object for the row.
            if(holder == null){
                holder = new ViewHolder(convertView);
                holder.tv_link.setText(classes_[position]);
                convertView.setTag(holder);
            } else {
                //if the row has a view holder, reuse it.
                holder.tv_link.setText(classes_[position]);
            }//end else
            //return the row's view object.
            return convertView;
        }//end else

    }//end getView

    //ViewHolder class contains the two items in each row.
    private class ViewHolder{
        TextView tv_link;
        RatingBar ratingBar;

        public ViewHolder(View row){
            tv_link = (TextView) row.findViewById(R.id.tv_class);
            ratingBar = (RatingBar) row.findViewById(R.id.rbar);
        }//end ViewHolder constructor
    }//end ViewHolder Class
}//End LAdapter
