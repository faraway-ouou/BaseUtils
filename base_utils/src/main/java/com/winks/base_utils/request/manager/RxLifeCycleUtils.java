package com.winks.base_utils.request.manager;

import com.trello.rxlifecycle3.LifecycleTransformer;
import com.trello.rxlifecycle3.android.ActivityEvent;
import com.trello.rxlifecycle3.android.FragmentEvent;
import com.trello.rxlifecycle3.components.RxDialogFragment;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle3.components.support.RxAppCompatDialogFragment;
import com.trello.rxlifecycle3.components.support.RxFragment;
import com.trello.rxlifecycle3.components.support.RxFragmentActivity;
import com.winks.base_utils.ui.mvp.KBaseView;

/**
 * RxLifeCycle 工具类
 */
public class RxLifeCycleUtils {
    /**
     * RxLifeCycle绑定RxJava的生命周期
     *
     * @param KBaseView activity 或fragment继承的接口view
     * @param <L>      RxJava数据泛型
     * @return
     */
    public static <L> LifecycleTransformer<L> bindToLifecycle(KBaseView KBaseView) {
        if (KBaseView != null) {
            if (KBaseView instanceof RxAppCompatActivity) {
                return ((RxAppCompatActivity) KBaseView).bindToLifecycle();
            } else if (KBaseView instanceof RxFragmentActivity) {
                return ((RxFragmentActivity) KBaseView).bindToLifecycle();
            } else if (KBaseView instanceof RxFragment) {
                return ((RxFragment) KBaseView).bindToLifecycle();
            } else if (KBaseView instanceof RxDialogFragment) {
                return ((RxDialogFragment) KBaseView).bindToLifecycle();
            } else if (KBaseView instanceof RxAppCompatDialogFragment) {
                return ((RxAppCompatDialogFragment) KBaseView).bindToLifecycle();
            } else {
                throw new IllegalArgumentException("view isn't activity or fragment");
            }
        } else {
            throw new IllegalArgumentException("view is null");
        }
    }

    /**
     * RxLifeCycle绑定RxJava的生命周期 ，支持指定某个生命周期
     *
     * @param KBaseView activity 继承的接口view
     * @param event    activity的生命周期
     * @param <L>      RxJava数据泛型
     * @return
     */
    public static <L> LifecycleTransformer<L> bindUntilEvent(KBaseView KBaseView, ActivityEvent event) {
        if (KBaseView != null) {
            if (KBaseView instanceof RxAppCompatActivity) {
                return ((RxAppCompatActivity) KBaseView).bindUntilEvent(event);
            } else if (KBaseView instanceof RxFragmentActivity) {
                return ((RxFragmentActivity) KBaseView).bindUntilEvent(event);
            } else {
                throw new IllegalArgumentException("view isn't activity");
            }
        } else {
            throw new IllegalArgumentException("view is null");
        }
    }

    /**
     * RxLifeCycle绑定RxJava的生命周期，支持指定某个生命周期
     *
     * @param KBaseView fragment继承的接口view
     * @param event    fragment的生命周期
     * @param <L>      RxJava数据泛型
     * @return
     */
    public static <L> LifecycleTransformer<L> bindUntilEvent(KBaseView KBaseView, FragmentEvent event) {
        if (KBaseView != null) {
            if (KBaseView instanceof RxFragment) {
                return ((RxFragment) KBaseView).bindUntilEvent(event);
            } else if (KBaseView instanceof RxDialogFragment) {
                return ((RxDialogFragment) KBaseView).bindUntilEvent(event);
            } else if (KBaseView instanceof RxAppCompatDialogFragment) {
                return ((RxAppCompatDialogFragment) KBaseView).bindUntilEvent(event);
            } else {
                throw new IllegalArgumentException("view isn't  fragment");
            }
        } else {
            throw new IllegalArgumentException("view is null");
        }
    }
}
