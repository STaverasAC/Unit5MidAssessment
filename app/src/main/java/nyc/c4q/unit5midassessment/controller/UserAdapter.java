package nyc.c4q.unit5midassessment.controller;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.unit5midassessment.DetailActivity;
import nyc.c4q.unit5midassessment.R;
import nyc.c4q.unit5midassessment.model.User;

/**
 * Created by Shant on 1/24/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    List<User> userList = new ArrayList<>();

    public UserAdapter(List<User> userList){
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.onBind(user);


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private ImageView thumbnail;

        public UserViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_item_name);
            thumbnail = itemView.findViewById(R.id.user_item_thumbnail);
        }

        public void onBind(final User user){
            String firstName = user.getName().getFirst();
            String lastName = user.getName().getLast();

            StringBuilder fullNameBuilder = new StringBuilder();
            fullNameBuilder.append(firstName);
            fullNameBuilder.append(" ");
            fullNameBuilder.append(lastName);
            final String fullName = fullNameBuilder.toString();

            String thumbnailUrl = user.getPicture().getThumbnail();
            name.setText(fullName);
            Picasso.with(itemView.getContext()).load(thumbnailUrl).into(thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToDetail = new Intent(itemView.getContext(), DetailActivity.class);
                    goToDetail.putExtra("fullname",fullName);
                    goToDetail.putExtra("dob",user.getDob());
                    goToDetail.putExtra("email",user.getEmail());
                    goToDetail.putExtra("cell",user.getCell());
                    goToDetail.putExtra("city",user.getLocation().getCity());
                    goToDetail.putExtra("street",user.getLocation().getStreet());
                    goToDetail.putExtra("state",user.getLocation().getState());
                    goToDetail.putExtra("postcode",user.getLocation().getPostcode());
                    itemView.getContext().startActivity(goToDetail);
                }
            });

        }


    }
}
