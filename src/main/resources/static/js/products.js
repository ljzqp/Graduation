
//动态生成
$(function () {

    var sort=9;
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    getjson(sort);
    $('#nav dl dd a').click(function(e){
        e.preventDefault();
        var sort=$(this).attr('data-sort');
        $($(this)).addClass('active').parent().siblings().children('a').removeClass('active');
        getjson(sort);

    });
    $('#search').click(function(e){
        e.preventDefault();
        var keyword=$('#keyword').val();
        $($(this)).addClass('active').parent().siblings().children('a').removeClass('active');
        search_getjson(keyword);
    });
    function getjson(sort) {//封装函数动态生成页面
        $.getJSON('/kknq/cakes',{'sort':sort},function(pager){
            var html='';
            $.each(pager.data,function(i,p){
                html+=`
           <div class="good-box" data-id="${p.productId}">
                <div class="good-box-top" >
                    <a href="#" data-id="${p.productId}"><img src="${p.productImgUrl}" data-id="${p.productId}" class="img"></a>
                    <div class="mask hide">
                        <div class="sugar-title">
                            甜度指数：
                        </div>
                        <div class="suger-index">★</div>
                        <div class="sugar-icon">
                            <a href="#" data-id="${p.productId}" class="addCar" id="P_addCar"><img src="images/icon.png" id="icon-img" data-id="${p.pid}" ></a>
                        </div>
                    </div>
                </div>
                <div class="good-introduce">
                    <p><a href="${webName}/details" data-id="${p.productId}">【${p.productTitle}】</a></p>
                    <p><a href="${webName}/details" data-id="${p.productId}">${p.productName}</a></p>
                    <p><a href="${webName}/details" data-id="${p.productId}">¥${p.price}RMB</a></p>
                </div>
                
                <div></div>
            </div>
           `
            });
            $('#sort').html(html);
        });
    }

    function search_getjson(keyword) {//封装函数动态生成页面
        $.getJSON('/kknq/keyWord/cakes',{'keyword':keyword},function(pager){
            var html='';

            $.each(pager.data,function(i,p){
                html+=`
           <div class="good-box" data-id="${p.productId}">
                <div class="good-box-top" >
                    <a href="#" data-id="${p.productId}"><img src="${p.productImgUrl}" data-id="${p.productId}" class="img"></a>
                    <div class="mask hide">
                        <div class="sugar-title">
                            甜度指数：
                        </div>
                        <div class="suger-index">★</div>
                        <div class="sugar-icon">
                            <a href="#" data-id="${p.productId}" class="addCar" id="P_addCar"><img src="images/icon.png" id="icon-img" data-id="${p.pid}" ></a>
                        </div>
                    </div>
                </div>
                <div class="good-introduce">
                    <p><a href="deteil.html" data-id="${p.productId}">【${p.productTitle}】</a></p>
                    <p><a href="deteil.html" data-id="${p.productId}">${p.productName}</a></p>
                    <p><a href="deteil.html" data-id="${p.productId}">¥${p.price}RMB</a></p>
                </div>
            </div>
           `
            });
            $('#sort').html(html);
        });
    }
});
//鼠标经过图片时的效果
   $('#sort ').on("mouseenter",'.good-box-top img',function () {
        $($($(this).parent().parent().children('.mask'))[0]).addClass('show').removeClass('hide1').removeClass('hide');
    });
    $('#sort ').on("mouseleave",'.good-box-top',function () {
        $($($(this).children('.mask'))[0]).addClass('hide1').removeClass('show');
    });


//
$('#sort').on('click','.good-box-top>a,.good-introduce>p>a',function (e) {
    e.preventDefault();
    window.location.href="/kknq/details?pid="+$(this).data('id');
//    加入购物车

});



