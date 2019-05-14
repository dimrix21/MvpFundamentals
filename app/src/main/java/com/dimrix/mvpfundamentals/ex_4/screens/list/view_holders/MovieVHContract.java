package com.dimrix.mvpfundamentals.ex_4.screens.list.view_holders;

import com.dimrix.mvpfundamentals.base.BaseVH;

public interface MovieVHContract extends BaseVH {

    void setTitle(String title);

    void setOverView(String overView);

    void setThumbnailUrl(int res);

}