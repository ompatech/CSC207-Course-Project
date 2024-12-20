package com.example.csc207courseproject.ui;

import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import org.jetbrains.annotations.NotNull;

/**
 * Our extension of the Fragment class that is used for our style of views in this project.
 */
public abstract class AppFragment extends Fragment {
    protected Context mContext;

    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        mContext = context;
    }


    protected void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
