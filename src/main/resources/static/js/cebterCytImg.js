/*
*  鍥剧墖瑁佸壀
*  imgdom锛氬浘鐗嘾om瀵硅薄 涔熷彲浠ヤ紶this
*  cutImgType(瑁佸壀褰撴椂): 灞呬腑瑁佸壀autocut  鎸夋瘮渚嬬缉鏀維caling  鎷変几stretching
*  cutImgParent: 鐖剁被閫夋嫨鍣� 渚嬪div鏍囩鐨刬d鏄痬ydiv  閭ｄ箞杩欓噷灏卞～ #mydiv
*
*  渚嬪锛�
*  cutImg(this,"autocut","#mydiv")  //浼犵埗鏍囩
*  cutImg(this,"autocut")  //涓嶄紶鐖舵爣绛�
*/
function cutImg(imgdom,CutImgType,cutImgParent){
    $(imgdom).each(function(){
        var $this=$(imgdom);

	    $this.css("cssText","");

        var objHeight,objWidth;
        //IE7+娴忚鍣ㄩ兘鑳藉吋瀹圭殑鍑芥暟灏佽:鑾峰彇鍥剧墖鐨勫師濮嬪昂瀵�
        if($this[0].naturalWidth && $this[0].naturalHeight) {
            objWidth = $this[0].naturalWidth;
            objHeight = $this[0].naturalHeight;
        } else {
            var img = new Image();
            img.src = $this[0].src;
            objWidth = img.width;
            objHeight = img.height;
        }

        var parentHeight,parentWidth;
        if (cutImgParent!=undefined){
            parentHeight=$this.parents(cutImgParent).eq(0).height();//鍥剧墖鐖跺鍣ㄩ珮搴�
            parentWidth=$this.parents(cutImgParent).eq(0).width();//鍥剧墖鐖跺鍣ㄥ搴�
        }else{
            if($this.parent().prop('tagName')=='a' || $this.parent().prop('tagName')=='A'){
                parentHeight=$this.parent().parent().height();//鍥剧墖鐖跺鍣ㄩ珮搴�
                parentWidth=$this.parent().parent().width();//鍥剧墖鐖跺鍣ㄥ搴�
            }else{
                parentHeight=$this.parent().height();//鍥剧墖鐖跺鍣ㄩ珮搴�
                parentWidth=$this.parent().width();//鍥剧墖鐖跺鍣ㄥ搴�
            }
        }

        var imgCssText = "";

		if(CutImgType == "autocut"){
			var ratio=objHeight/objWidth;
			if(objHeight > objWidth) {//璧嬪€煎楂�
                if(parentWidth*ratio < parentHeight){
                    imgCssText = "width:"+parentHeight/ratio+"px!important;height:"+parentHeight+"px!important;";
                }else{
                    imgCssText = "width:"+parentWidth+"px!important;height:"+parentWidth*ratio+"px!important;";
                }
                $this.css("cssText",imgCssText);
			}
			else if(objHeight<objWidth) {
                if(parentHeight/ratio < parentWidth){
                    imgCssText = "width:"+parentWidth+"px!important;height:"+parentWidth*ratio+"px!important;";
                }else{
                    imgCssText = "width:"+parentHeight/ratio+"px!important;height:"+parentHeight+"px!important;";
                }
                $this.css("cssText",imgCssText);
            }else{
                if(parentHeight>parentWidth) {//璧嬪€煎楂�
                    imgCssText = "width:"+parentHeight+"px!important;height:"+parentHeight+"px!important;";
                    $this.css("cssText",imgCssText);
                }else{
                    imgCssText = "width:"+parentWidth+"px!important;height:"+parentWidth+"px!important;";
                    $this.css("cssText",imgCssText);
                }
			}

/*            objHeight=$this[0].height;//閲嶆柊鑾峰彇瀹介珮
            objWidth=$this[0].width;*/
            objHeight = parseFloat($this.css("height").replace("px",""));
            objWidth = parseFloat($this.css("width").replace("px",""));



            if(objHeight>objWidth) {
                if(objHeight == parentHeight) {
                    imgCssText = $this.attr("style")+";margin-left:"+(parentWidth-objWidth)/2+"px!important;border:0px!important;float: none;";
                }else{
                    imgCssText = $this.attr("style")+";margin-top:"+(parentHeight-objHeight)/2+"px!important;border:0px!important;float: none;";
                }
                $this.css("cssText",imgCssText);
            }else if(objHeight<objWidth) {
                if(objWidth == parentWidth) {
                    imgCssText = $this.attr("style")+";margin-top:"+(parentHeight-objHeight)/2+"px!important;border:0px!important;float: none;";
                }else{
                    imgCssText = $this.attr("style")+";margin-left:"+(parentWidth-objWidth)/2+"px!important;border:0px!important;float: none;";
                }
                $this.css("cssText",imgCssText);
            }else{
                if(parentHeight >= parentWidth) {
                    imgCssText = $this.attr("style")+";margin-left:"+(parentWidth-objWidth)/2+"px!important;border:0px!important;float: none;"
                    $this.css("cssText",imgCssText);
                }else{
                    imgCssText = $this.attr("style")+";margin-top:"+(parentHeight-objHeight)/2+"px!important;border:0px!important;float: none;";
                    $this.css("cssText",imgCssText);
                }
            }

        }else{
            try
            {
                var widthrate = objWidth / parentWidth;
                var heightrate = objHeight / parentHeight;
                var imgwidth = 0;
                var imgheight = 0;

                if(widthrate > 1 || heightrate > 1 || widthrate < 1 || heightrate < 1)
                {
                    if(CutImgType == "Scaling")//鎸夋瘮渚嬬缉鏀�
                    {
                        var rate = Math.max(widthrate, heightrate);
                        imgwidth = Math.max(1, Math.min(objWidth/rate, parentWidth));
                        imgheight = Math.max(1, Math.min(objHeight/rate, parentHeight));
                    }
                    else//鎷変几
                    {
                        imgwidth = parentWidth;
                        imgheight = parentHeight;
                    }
                }
                else //澶у皬鍚堥€�
                {
                    imgwidth = parentWidth;
                    imgheight = parentHeight;
                }

                imgCssText += "width:"+imgwidth+"px!important;height:"+imgheight+"px!important;";
                $this.css("cssText",imgCssText);

                if(imgwidth>imgheight) {
                    if(imgwidth != parentWidth){
                        imgCssText = $this.attr("style")+";margin-left:"+(parentWidth-imgwidth)/2+"px!important;border:0px!important;";
                    }else{
                        imgCssText = $this.attr("style")+";margin-top:"+(parentHeight-imgheight)/2+"px!important;border:0px!important;";
                    }
                    $this.css("cssText",imgCssText);
                }
                else
                {
                    if(imgheight != parentHeight){
                        imgCssText = $this.attr("style")+";margin-top:"+(parentHeight-imgheight)/2+"px!important;border:0px!important;";
                    }else{
                        imgCssText = $this.attr("style")+";margin-left:"+(parentWidth-imgwidth)/2+"px!important;border:0px!important;";
                    }
                    $this.css("cssText",imgCssText);
                }
            }
            catch(e)
            {
            }
		}
    })
}
