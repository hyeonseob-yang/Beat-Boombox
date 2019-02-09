package MatthewEricNick.HackThe90s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class GameActivity extends AppCompatActivity {

    private BoomBox boomBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        boomBox = new BoomBox(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        boomBox.motion(e);

        for (int i = 0; i < 4; i++) {
            Walkman something = new Walkman(this, i);

            something.spawnImage();
            something.startMove();
        }

        return true;
    }
}
