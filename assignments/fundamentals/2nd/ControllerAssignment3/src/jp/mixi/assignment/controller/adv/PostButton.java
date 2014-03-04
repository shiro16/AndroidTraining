package jp.mixi.assignment.controller.adv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PostButton extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // このフラグメント用のレイアウトをインフレートする
        return inflater.inflate(R.layout.post_button, container, false);
    }
}