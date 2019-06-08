package tribalway.by.paigow.com.paigowtilesbyrob;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;

public class DealerTileFlip implements Runnable {

    Handler handler;
    Context context;
    View view0, view1, view2,view3;
    Tile tile0, tile1, tile2, tile3;
    int x = 0;



    @Override
    public void run() {

        switch(x){

            case 0:
                x++;
                Drawable side = getBuildVersionTileSide(context);
                view0.setBackground(side);
                view1.setBackground(side);
                view2.setBackground(side);
                view3.setBackground(side);
                handler.postDelayed(this,90);
                break;

            case 1:
                Drawable face = getBuildVersionTileFace(tile0, context);
                view0.setBackground(face);
                face = getBuildVersionTileFace(tile1, context);
                view1.setBackground(face);
                face = getBuildVersionTileFace(tile2, context);
                view2.setBackground(face);
                face = getBuildVersionTileFace(tile3, context);
                view3.setBackground(face);
                x=0;
                handler.removeCallbacks(this);
                break;

        }

    }

    public DealerTileFlip(Handler handler, Context context, View view0, View view1, View view2, View view3,Tile tile0, Tile tile1, Tile tile2, Tile tile3 ){
         this.handler = handler;
         this.context = context;
         this.view0 = view0;
         this.view1= view1;
         this.view2= view2;
         this.view3= view3;
         this.tile0 = tile0;
         this.tile1 = tile1;
         this.tile2 = tile2;
         this.tile3 = tile3;
         }



    public static Drawable getBuildVersionTileFace(Tile tile, Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getResources().getDrawable(tile.getImgId(), context.getTheme());
        } else {
            return context.getResources().getDrawable(tile.getImgId());
        }
    }

    public static Drawable getBuildVersionTileSide(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getResources().getDrawable(R.drawable.side, context.getTheme());
        } else {
            return context.getDrawable(R.drawable.side);
        }
    }





    }
