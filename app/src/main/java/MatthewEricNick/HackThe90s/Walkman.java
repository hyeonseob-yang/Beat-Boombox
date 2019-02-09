package MatthewEricNick.HackThe90s;

import android.content.Context;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;

class Walkman extends Entity {

    private final float VELOCITY = 20;
    private int direction;

    Walkman(Context con, int direction) {
        super(con);
        setDirection(direction);
    }

    void spawnImage() {

        float x;
        float y;

        switch (direction) {
            case 0:
                x = MainUtility.getScreenWidth(con)/2;
                y = -MainUtility.getScreenHeight(con)/10;
                break;
            case 1:
                x = MainUtility.getScreenWidth(con) + MainUtility.getScreenWidth(con)/10;
                y = MainUtility.getScreenHeight(con)/2;
                break;
            case 2:
                x = MainUtility.getScreenWidth(con)/2;
                y = MainUtility.getScreenHeight(con) + MainUtility.getScreenHeight(con)/10;
                break;
            case 3:
                x = -MainUtility.getScreenWidth(con)/10;
                y = MainUtility.getScreenHeight(con)/2;
                break;
            default:
                x = 0;
                y = 0;
                break;
        }

        imageView = MainUtility.addImage(con,"gameLayout", "walkman_base", x, y);
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(200, 200));
        MainUtility.centerImage(imageView);
        imageView.setRotation(180 + (float)Math.toDegrees(getAngle()));
    }

    private float getAngle() {
        return direction * (float)Math.PI/2;
    }

    private void setDirection(int direction) {
        this.direction = direction;

        float angle = getAngle();

        velocityX = -VELOCITY * (float)Math.sin(angle);
        velocityY = VELOCITY * (float)Math.cos(angle);
    }

    @Override
    void delete() {

    }
}
