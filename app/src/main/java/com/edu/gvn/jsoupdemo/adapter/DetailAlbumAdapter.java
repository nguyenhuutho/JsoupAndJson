package com.edu.gvn.jsoupdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.gvn.jsoupdemo.R;
import com.edu.gvn.jsoupdemo.model.online.DetailAlbumModel;

import java.util.ArrayList;

/**
 * Created by hnc on 23/09/2016.
 */

public class DetailAlbumAdapter extends RecyclerView.Adapter<DetailAlbumAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<DetailAlbumModel> mDetailAlbumData;
    private IReyclerViewItemOnClickListener itemOnClickListener;


    public DetailAlbumAdapter(Context context, ArrayList<DetailAlbumModel> mDetailAlbumData) {
        this.mContext = context;
        this.mDetailAlbumData = mDetailAlbumData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_detail_album, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtOrder.setText(mDetailAlbumData.get(position).getmOrder());
        holder.txtNameSong.setText(mDetailAlbumData.get(position).getmSongName());
    }

    @Override
    public int getItemCount() {
        return mDetailAlbumData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtOrder, txtNameSong;
        private ImageView download, add, toPlayer;

        public ViewHolder(final View itemView) {
            super(itemView);
            txtOrder = (TextView) itemView.findViewById(R.id.fragment_detail_album_order);
            txtNameSong = (TextView) itemView.findViewById(R.id.fragment_detail_album_song_name);

            download = (ImageView) itemView.findViewById(R.id.fragment_detail_album_btn_download);
            add = (ImageView) itemView.findViewById(R.id.fragment_detail_album_btn_add);
            toPlayer = (ImageView) itemView.findViewById(R.id.fragment_detail_album_btn_to_player);

            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnClickListener.onDownloadClick(v, getAdapterPosition());
                }
            });

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnClickListener.onAddClick(v, getAdapterPosition());
                }
            });

            toPlayer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnClickListener.onToPlayerClick(v, getAdapterPosition());
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnClickListener.onItemClick(v, getAdapterPosition());
                }
            });

        }
    }

    public void setItemOnClickListener(IReyclerViewItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    public interface IReyclerViewItemOnClickListener {
        void onItemClick(View v, int position);

        void onDownloadClick(View v, int position);

        void onAddClick(View v, int position);

        void onToPlayerClick(View v, int position);
    }
}
