package tribalway.by.paigow.com.paigowtilesbyrob;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.widget.TextView;

public class TileFlip implements Runnable {


    TextView view;
    Tile tile;
    int x = 1;
    Handler handler;
    Context context;


    @Override
    public void run() {

        switch (x) {

            case 1:
                x++;
                System.out.println("runnable ran");
                Drawable tileBack = getBuildVersionTileSide(context);
                view.setBackground(tileBack);
                handler.postDelayed(this, 90);
                break;


            case 2:
                System.out.println("runnable 3");
                Drawable tileFace = getBuildVersionTileFace(tile, context);
                view.setBackground(tileFace);
                handler.removeCallbacks(this);
                break;
        }
    }

    public TileFlip(TextView view, Tile tile, Handler handler, Context context) {
        this.view = view;
        this.tile = tile;
        this.handler = handler;
        this.context = context;

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
