package com.winks.base_utils.ui.mvp;


import com.winks.base_utils.ui.view.KBaseActivity;

/**
 * MVP KBaseActivity
 * @param <T>
 */
public  abstract  class KBaseMVPActivity<T extends KBasePresenter> extends KBaseActivity implements KBaseView {
    protected T mPresenter;

    /**
     * 创建BasePresenter并且绑定BaseView
     */
    @Override
    protected void initPresenter() {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        //页面销毁时解除绑定
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 创建Presenter
     *
     * @return
     */
    protected abstract T createPresenter();

    @Override
    public void onNetWorkError() {
    }
}
