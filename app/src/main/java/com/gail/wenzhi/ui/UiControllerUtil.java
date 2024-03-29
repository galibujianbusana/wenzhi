package com.gail.wenzhi.ui;


import android.util.Log;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gail.wenzhi.R;
import com.gail.wenzhi.ui.fragment.HomeFragment;
import com.gail.wenzhi.ui.fragment.HomeItemFragment;
import com.gail.wenzhi.ui.fragment.MoKuaiFragment;
import com.gail.wenzhi.ui.fragment.SettingFragment;
import com.gail.wenzhi.ui.fragment.WeiXinFragment;


public class UiControllerUtil {

    private static final String TAG = "UiControllerUtil";
    private static UiControllerUtil fragmentController = null;
    public static final int HOME_TAG = 0;
    public static final int SETTING_TAG = 1;
    public static final int WEIXIN_TAG = 2;
    public static final int HOME_ITEM_TAG = 3;
    public static final int MOKUAI_TAG = 4;

    public HomeFragment homeFragment;
    public SettingFragment settingFragment;
    public WeiXinFragment weiXinFragment;
    public HomeItemFragment homeItemFragment;
    public MoKuaiFragment moKuaiFragment;


    public FragmentTransaction fragmentTransaction;
    public FragmentManager fragmentManager;
    public static int fragmentNow = 0, fragmentOlder = 0;


    public static int curFragmentIndex = -1;
    public static int olderFragmentIndex = -1;


    private UiControllerUtil() {

        initFragment();
    }


    public static UiControllerUtil getInstance() {
        if (fragmentController == null) {
            synchronized (UiControllerUtil.class) {
                if (fragmentController == null) {
                    return fragmentController = new UiControllerUtil();
                }
            }
        }
        return fragmentController;


    }


    private void initFragment() {

        Log.d(TAG, "initFragment: ");
        weiXinFragment = new WeiXinFragment();
        settingFragment = new SettingFragment();
        homeFragment = new HomeFragment();
        homeItemFragment = new HomeItemFragment();
        moKuaiFragment = new MoKuaiFragment();


    }


    public void changeFragment(int i, FragmentActivity context) {

        fragmentManager = context.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentNow > i) {
            fragmentTransaction.setCustomAnimations(R.anim.back_left_in, R.anim.back_right_out);

        } else if (fragmentNow < i) {
            fragmentTransaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out);
        }
        fragmentOlder = fragmentNow;
        hideFragment(fragmentTransaction);
        addShow(fragmentTransaction, i, i + "");
        fragmentNow = i;
        fragmentTransaction.commit();

    }


    private void hideFragment(FragmentTransaction fragmentTransaction) {


        fragmentTransaction.hide(homeFragment);


        fragmentTransaction.hide(settingFragment);

        fragmentTransaction.hide(weiXinFragment);

        fragmentTransaction.hide(homeItemFragment);

        fragmentTransaction.hide(moKuaiFragment);




    }


    private void addShow(FragmentTransaction fragmentTransaction, int i, String tag) {

        olderFragmentIndex = curFragmentIndex;

        switch (i) {

            case HOME_TAG:

                if (!homeFragment.isAdded() && null == fragmentManager.findFragmentByTag(tag)) {
                    fragmentTransaction.add(R.id.layout_content, homeFragment, HOME_TAG + "");
                    fragmentTransaction.show(homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case SETTING_TAG:
                if (!settingFragment.isAdded() && null == fragmentManager.findFragmentByTag(tag)) {
                    fragmentTransaction.add(R.id.layout_content, settingFragment, SETTING_TAG + "");
                }
                fragmentTransaction.show(settingFragment);
                break;
            case WEIXIN_TAG:
                if (!weiXinFragment.isAdded() && null == fragmentManager.findFragmentByTag(tag)) {
                    fragmentTransaction.add(R.id.layout_content, weiXinFragment, WEIXIN_TAG + "");
                }
                fragmentTransaction.show(weiXinFragment);
                break;
            case HOME_ITEM_TAG:
                if (!homeItemFragment.isAdded() && null == fragmentManager.findFragmentByTag(tag)) {
                    fragmentTransaction.add(R.id.layout_content, homeItemFragment, HOME_ITEM_TAG + "");
                }
                fragmentTransaction.show(homeItemFragment);
                break;
            case MOKUAI_TAG:
                if (!moKuaiFragment.isAdded() && null == fragmentManager.findFragmentByTag(tag)) {
                    fragmentTransaction.add(R.id.layout_content, moKuaiFragment, MOKUAI_TAG + "");
                }
                fragmentTransaction.show(moKuaiFragment);
                break;
        }

        curFragmentIndex = i;
    }


    public void destroy() {

        try {
            hideFragment(fragmentTransaction);
            if (fragmentController != null) {
                fragmentController = null;
            }
            fragmentController = null;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
