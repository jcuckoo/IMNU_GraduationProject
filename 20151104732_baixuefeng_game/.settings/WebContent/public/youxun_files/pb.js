(function () {
    var host = location.host.toLowerCase();
    var href = location.href;
    if (/\/zhibo\/\d+\.html/.test(location.href)) {
        return;
    }
	if (/\/SoftView\/SoftView_139652\.html|\/s\/139652\.html|\/shouji\/357442\.html|\/azgame\/357442\.html|\/shouji\/399837\.html|\/azgame\/399837\.html|\/shouji\/401983\.html|\/azgame\/401983\.html/.test(location.href)) {
		return;
	}
    var arr_href=['http://www.yxdown.com/shouji/400570.html','http://www.yxdown.com/shouji/595806.html','http://www.yxdown.com/shouji/306497.html','http://www.yxdown.com/shouji/446257.html','http://www.yxdown.com/shouji/313320.html','http://www.yxdown.com/shouji/474519.html','http://www.yxdown.com/shouji/490291.html','http://www.yxdown.com/shouji/298485.html','http://www.yxdown.com/shouji/269711.html','http://www.yxdown.com/shouji/446669.html','http://www.yxdown.com/shouji/485043.html','http://www.yxdown.com/shouji/361071.html','http://www.yxdown.com/shouji/595799.html','http://www.yxdown.com/shouji/396672.html','http://www.yxdown.com/shouji/474530.html','http://www.yxdown.com/shouji/399743.html','http://www.yxdown.com/shouji/485051.html','http://www.yxdown.com/shouji/490335.html','http://www.yxdown.com/ios/575109.html','http://www.yxdown.com/ios/575110.html','http://www.yxdown.com/app/649653.html','http://www.yxdown.com/app/612364.html','http://www.yxdown.com/app/692024.html','http://www.yxdown.com/app/689496.html','http://www.yxdown.com/app/674839.html','http://www.yxdown.com/app/651636.html','http://www.yxdown.com/app/677171.html','http://www.yxdown.com/app/689278.html','http://www.yxdown.com/app/687807.html','http://m.yxdown.com/azgame/400570.html','http://m.yxdown.com/azgame/595806.html','http://m.yxdown.com/azgame/306497.html','http://m.yxdown.com/azgame/446257.html','http://m.yxdown.com/azgame/313320.html','http://m.yxdown.com/azgame/474519.html','http://m.yxdown.com/azgame/490291.html','http://m.yxdown.com/azgame/298485.html','http://m.yxdown.com/azgame/269711.html','http://m.yxdown.com/azgame/446669.html','http://m.yxdown.com/azgame/485043.html','http://m.yxdown.com/azgame/361071.html','http://m.yxdown.com/azgame/595799.html','http://m.yxdown.com/azgame/396672.html','http://m.yxdown.com/azgame/474530.html','http://m.yxdown.com/azgame/399743.html','http://m.yxdown.com/azgame/485051.html','http://m.yxdown.com/azgame/490335.html','http://m.yxdown.com/yxios/575109.html','http://m.yxdown.com/yxios/575110.html','http://m.yxdown.com/app/649653.html','http://m.yxdown.com/app/612364.html','http://m.yxdown.com/app/692024.html','http://m.yxdown.com/app/689496.html','http://m.yxdown.com/app/674839.html','http://m.yxdown.com/app/651636.html','http://m.yxdown.com/app/677171.html','http://m.yxdown.com/app/689278.html','http://m.yxdown.com/app/687807.html'];
    var the_href = location.href.split('?')[0];
    if(arr_href.indexOf(the_href) > -1){
        return;
    }
    var lfun = function (arr) {
        var si = false;
        var func = function () {
            if (document.title) {
                var dtitle = document.title.toLowerCase();
                for (var i = 0; i < arr.length; i++) {
                    if (dtitle.indexOf(arr[i].toLowerCase()) >= 0) {
 
                        console.log(arr[i]);
                        location = '/404';
                        break;
                    }
                }
                if (si) {
                    clearInterval(si);
                }
            }
        }
        func();
        si = setInterval(func, 100);
    }
    lfun(['小编仿佛听到', "习大", '红杏直播', '蜜桃秀', '蜂直播', '压寨直播', '蜜桃约', '默默直播', 'ZANK', '蜜播', '假装情侣吧', '一起秀直播', '酸果直播', '嗨播',
            '干露露', '桃花直播', 'BlueSky', '觅蜜直播', '悦橙直播', '乐秀直播', '蜜豆直播', '黄鳝门']);
    if (host.indexOf('yxdown.com') >= 0) {
        lfun(['1024', '红番阁', '花蝴蝶', '南宁护士门', '哈尔滨服装城', '蛇精男', '雪梨枪', '东北警花门', '请叫我青春', "陈曦", "泉州车震门", "河南浴室门", "干露露",
                "郭朝丹浴室门", "刘梓晨", "宜家不雅照", "女辅警不雅视频", "佛山星星", "易度短信批量", "啊拉qq大盗", "花蝴蝶社区", "快活林", "八优短信通", "啊D注入工具",
                "不雅", "床照", "迷奸", "强奸", "淫秽", "捡死鱼", "郭朝丹", "裸条", "徐歌阳", "MFC视讯", "无圣光", "h漫黄漫", "无翼鸟", "鬼父",
                "vr眼镜看爱情动作片资源", "vr岛国片", "陈冠希第一部", "定制女仆", "色情游戏", "奴隶少女希尔薇", "雯雅婷", "kitty酱", "与奴隶的生活", "痴汉电车", "电车迷情",
                "处女失身记", "调教女佣", "调教娇妻", "调教女仆", "日本邪恶少女", "久久热", "九色腾", "邪恶帝", "tumblr", "汤博乐", "激情综合网", "激情午夜爽片",
                "李丽莎姐妹", "推女郎小九九", "韩国女主播韶姬", "doctors", 'gif番号', 'sex', '岛国爽播', 'AV神器', '藏姬阁', '百度网盘资源你懂的', '短信群发',
                '天海翼', '黄房', '卖肉', '灰鸽子', '裸持', '360云盘资源共享', '团子系列', '闲人吧', '弱气乙女', '修罗的痴汉道', '步兵片', '步兵里番', '步兵女神',
                '步兵番号', '尤果网', "布丁丁姬", 'CC宠儿凌溪', '外教和女学生', '妈的马子', 'hentai少女颖', '最佳女忧', 'AISS爱丝', 'ROSI', '夏木七优', '欣杨',
                '死库水', '林夕', '见木一', '李丽莎', '陈诗云', '推女郎', 'tuigirl', '王俪丁', '艾栗栗', 'NTR少女', '韩子萱', '王婉悠', '王语纯', '温心怡',
                '蛋壳姬', '赵小米', "松果儿", "娜依灵儿", "方志友", "见木", "音波萝莉", "拇指兔", "千叶双子", "秀爱爱", "婶婶的诱惑", "私照", "丰满女孩", "棉兔酱",
                "邪恶吧", "新蔻", "肉丸子", "王雨纯", "康先生", "小志乃酱", "名门绣娘", "谭晓彤", "崔智燕", "韩贝贝", "苏小曼", "阮魅儿", "艳姆", "兔牙喵",
                "胡萝卜跳跳", "兔牙喵喵喵", "白茶妹儿", "锄禾酱汁", "喵咪酱", "moir", "王绾绾", "小川", "派兔酱", "杨依", "兔兔酱", "方哥", "李秀彬", "人艺体",
                "小梦雅", "夜火模特", "minana", "团子少女", "4P视频", "李喵喵", "米妮大萌萌", "小北方寺真宵", "大Y摄影", "电波萝莉酱", "王馨瑶", "欣杨kitty",
                "女主播约会被下药视频", "夏小秋秋秋", "舞陵辱", "唐馨baby", "外教和女学生幸福的生活", "9877", "朴妮唛", "长泽茉里奈", "雪露儿", "少女映画", "owakado",
                "梓喵酱", "虎牙酱", "Taro", "暗黑萝莉全套", "绵兔", "CC宠儿", "你嘴珍贵", "AISS", "少女颖", "嗲囡囡", "赵小米Kitty", "K8傲娇萌萌", "鄢爽雨",
                "小秋就是小秋秋", "冰糖娃娃小兮", "安沛蕾", "misa贞喵", "小川沙卫", "培德工家", "荷恩", "hentai", "穹妹本子", "习呆吊", "付明柏", "CL螃蟹哥",
                "云南高校副教授与女学生不雅照", "师大校花级女神", "福利社", "福利套图", "骑兵片", "影音先锋", "制服诱惑", "合租屋偷窥女同事", "G20", "赛风", "vpn", "翻墙",
                "八大中国元素", "快播", "涉黄", "91porn", "草榴视频", "91pron", "成人游戏", "成人VR", "成人展", "成人网站", "18禁游戏", "十八禁游戏",
                "18禁成人", "汉仪", "蝌蚪窝", "暗黑萝莉", "爱玩少女", "猫奴丫", "习呆呆", "八分音符酱", "暴力战车", "狂野飙车", "萌鼠跳跃", "约炮", "性爱", "爱爱",
                "露点", "黄油", "下体", "凌辱", ",18禁", "工口", "女优", "巨乳", "三点", "私照", "胸器", "osk39", "啪啪啪", "无下限", "事业线", "大尺度",
                "苍井空", "爱情动作", "泷泽萝拉", "何奕恋", "老虎机套现", "老虎机提现","炸金花","老虎机","水果机","双扣","书雁","Shuyan","Saga","shuyan","舒燕","提现","切你妹","射你妹","女神跪舔吸","恐怖游戏","小草莓"]);
    }
})();