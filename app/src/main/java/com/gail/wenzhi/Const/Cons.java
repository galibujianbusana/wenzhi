package com.gail.wenzhi.Const;

import com.gail.wenzhi.R;

public class Cons {


    // index?type=top&key=3f8238bb55566d2b3f0d2204a5e9631f
    // 类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),
    // tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)

    public static  final String BASE_TOU_TIAO = "http://v.juhe.cn/toutiao/";

    public static  final  String TOU_TIAO_KEY = "3f8238bb55566d2b3f0d2204a5e9631f";

    /**
     * params.put("pno","");//当前页数，默认1
     * params.put("ps","");//每页返回条数，最大100，默认20
     * params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
     * params.put("dtype","");//返回数据的格式,xml或json，默认json
     *
     * http://v.juhe.cn/weixin/query/?pno=1&ps=20&dtype=json&key=deab82b236a03222e69b04e13a520e55
     */
    public static final String WEIXIN_BASE = "http://v.juhe.cn/weixin/query/";

    public static final String WEIXIN_KEY = "deab82b236a03222e69b04e13a520e55";


    public static String [] MOKUAI = { "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing", "shishang"};
    public static int [] MOKUAIIMG = { R.drawable.shehui, R.drawable.guonei, R.drawable.guoji,
            R.drawable.yule, R.drawable.tiyu, R.drawable.junshi, R.drawable.keji, R.drawable.caijing, R.drawable.shishang};




   //  http://op.juhe.cn/onebox/bus/query?key=bdacc72db06d0f1d80dd9625cf09c9ba&station=%E6%B8%A9%E5%B7%9E
}
