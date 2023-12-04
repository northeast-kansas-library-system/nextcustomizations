SP.page_hcc.txt

----------

Preference name: page_hcc

Type: Textarea

Options: 80|50

----------

Preference value: 



<script type="text/javascript">
  //<![CDATA[

function init() {

$('#select_library').hide();
$('#select_library option').val('HIGH_CC');
$('a:contains("Sign up for a Library Card")').hide();

}

  //]]>
</script>

<body onload="init()">

<center>
  <h3>Highland Community College Library</h3>

<h3>Regular School Year Hours:</h3>

			<p>Monday - Thursday 7:30 am to 10:00 pm Fridays - 7:30 am to 4:00 pm<br />
			Saturday - 10:00 am to 4:00 pm<br />
			Sundays - 3:30 pm to 10:00 pm</p>

			<h3>Summer Hours:</h3>

			<p>Monday - Thursday 7:30 am to 4:00 pm<br />
			Fridays and&nbsp;Weekends - Closed</p>

			<h3>Phone numbers:</h3>

			<p>Circulation/reference desk 785-442-6053<br />
			Librarian&#39;s office (Main hours 8:00 am to 5:00 pm) 785-442-6054<br />
			Library fax (please inform library if you are receiving fax) 785-442-6101</p>

			<h3>Doniphan County Newspapers:</h3>

			<p>&bull; Kansas Chief (Wathena) 12/2002 - Current<br />
			&bull; Kansas Chief (Troy) 9/1886 - 12/2002<br />
			&bull; Highland Vidette 2/1892 - 12/2002<br />
			&bull; Wathena Times 6/1889 - 12/2002</p>

			<p>Contact Information<br />
			785-442-6054<br />
			<a href="mailto:Library@Highlandcc.edu?subject=email%20from%20website">Library@Highlandcc.edu</a></p>


<!-- Debut du carrousel -->
<div class='carrouselFrame'>
    <div class="loadingDiv"></div>
    <div id="HCC_New" class='carrousel'>
        <a id="left-but" class='left carousel-control'>‹</a>
        <a id="right-but" class='right carousel-control'>›</a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=998251"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/031641638X.01.MZZZZZZZ.jpg" title="12" alt="12"/></a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=998252"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/0062872710.01.MZZZZZZZ.jpg" title="The truth about Aaron" alt="The truth about Aaron"/></a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=998254"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/0306903075.01.MZZZZZZZ.jpg" title="Beyond the call" alt="Beyond the call"/></a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=998256"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/0062857487.01.MZZZZZZZ.jpg" title="Dreaming out loud" alt="Dreaming out loud"/></a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=998257"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/0763692344.01.MZZZZZZZ.jpg" title="The bigfoot files" alt="The bigfoot files"/></a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=998258"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/0062652443.01.MZZZZZZZ.jpg" title="Game changers" alt="Game changers"/></a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=998265"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/0316316539.01.MZZZZZZZ.jpg" title="3 kings" alt="3 kings"/></a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=1000313"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/0735220867.01.MZZZZZZZ.jpg" title="Frenemies" alt="Frenemies"/></a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=1000315"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/1493031740.01.MZZZZZZZ.jpg" title="Brothers in valor" alt="Brothers in valor"/></a>
        
        <a href="/cgi-bin/koha/opac-detail.pl?biblionumber=1000318"><img class="cloudcarousel" src="https://images-na.ssl-images-amazon.com/images/P/1432856278.01.MZZZZZZZ.jpg" title="Eliza Hamilton" alt="Eliza Hamilton"/></a>
        
        <div class="carousel-caption">
            <p id="title-text"></p>
        </div>
    </div>
</div>

<style>



.carrouselFrame {
    background: #DDDDDD;
    border-radius: 8px;
    margin: 1em 0;
    overflow: hidden;
    padding: 1em 0;
    position: relative;
}

.carrousel
{
    height : 300px;
}

.loadingDiv
{
    background : white;
    position : absolute;
    height : 100%;
    width : 100%;
    z-index : 2000;
    top : 0;
}
#title-text{
    color : ##ffffff;
}
.carousel-control,
.carousel-caption
{
    background-color : ##000000;
    z-index:1000;
    cursor : pointer;
}

.carousel-caption
{
    font-weight : bold;
}

usel-control,
.carousel-caption
{
    background-color : ##000000;
    z-index:1000;
}

.carousel-caption
{
    font-weight : bold;
}

a.locked
{
    width:100px;
}
</style>

<!-- This is the cloud carousel javascript(cloud-carousel.1.0.0.js) -->
<script>
//////////////////////////////////////////////////////////////////////////////////
// CloudCarousel V1.0.5
// (c) 2011 by R Cecco. <https://www.professorcloud.com>
// MIT License
//
// Reflection code based on plugin by Christophe Beyls <https://www.digitalia.be>
//
// Please retain this copyright header in all versions of the software
//////////////////////////////////////////////////////////////////////////////////
document.addEventListener('DOMContentLoaded', function() {
    (function($){function Reflection(img,reflHeight,opacity){var reflection,cntx,imageWidth=img.width,imageHeight=img.width,gradient,parent;parent=$(img.parentNode);this.element=reflection=parent.append("<canvas class='reflection' style='position:absolute'/>").find(':last')[0];if(!reflection.getContext&&$.browser.msie){this.element=reflection=parent.append("<img class='reflection' style='position:absolute'/>").find(':last')[0];reflection.src=img.src;reflection.style.filter="flipv progid:DXImageTransform.Microsoft.Alpha(opacity="+(opacity*100)+", style=1, finishOpacity=0, startx=0, starty=0, finishx=0, finishy="+(reflHeight/imageHeight*100)+")"}else{cntx=reflection.getContext("2d");try{$(reflection).attr({width:imageWidth,height:reflHeight});cntx.save();cntx.translate(0,imageHeight-1);cntx.scale(1,-1);cntx.drawImage(img,0,0,imageWidth,imageHeight);cntx.restore();cntx.globalCompositeOperation="destination-out";gradient=cntx.createLinearGradient(0,0,0,reflHeight);gradient.addColorStop(0,"rgba(255, 255, 255, "+(1-opacity)+")");gradient.addColorStop(1,"rgba(255, 255, 255, 1.0)");cntx.fillStyle=gradient;cntx.fillRect(0,0,imageWidth,reflHeight)}catch(e){return}}$(reflection).attr({'alt':$(img).attr('alt'),title:$(img).attr('title')})}var Item=function(imgIn,options){this.orgWidth=imgIn.width;this.orgHeight=imgIn.height;this.image=imgIn;this.reflection=null;this.alt=imgIn.alt;this.title=imgIn.title;this.imageOK=false;this.options=options;this.imageOK=true;if(this.options.reflHeight>0){this.reflection=new Reflection(this.image,this.options.reflHeight,this.options.reflOpacity)}$(this.image).css('position','absolute')};var Controller=function(container,images,options){var items=[],funcSin=Math.sin,funcCos=Math.cos,ctx=this;this.controlTimer=0;this.stopped=false;this.container=container;this.xRadius=options.xRadius;this.yRadius=options.yRadius;this.showFrontTextTimer=0;this.autoRotateTimer=0;if(options.xRadius===0){this.xRadius=($(container).width()/2.3)}if(options.yRadius===0){this.yRadius=($(container).height()/6)}this.xCentre=options.xPos;this.yCentre=options.yPos;this.frontIndex=0;this.rotation=this.destRotation=Math.PI/2;this.timeDelay=1000/options.FPS;if(options.altBox!==null){$(options.altBox).css('display','block');$(options.titleBox).css('display','block')}$(container).css({position:'relative',overflow:'hidden'});$(options.buttonLeft).css('display','inline');$(options.buttonRight).css('display','inline');$(options.buttonLeft).bind('mouseup',this,function(event){event.data.rotate(-1);return false});$(options.buttonRight).bind('mouseup',this,function(event){event.data.rotate(1);return false});if(options.mouseWheel){$(container).bind('mousewheel',this,function(event,delta){event.data.rotate(delta);return false})}$(container).bind('mouseover click',this,function(event){clearInterval(event.data.autoRotateTimer);var text=$(event.target).attr('alt');if(text!==undefined&&text!==null){clearTimeout(event.data.showFrontTextTimer);$(options.altBox).html(($(event.target).attr('alt')));$(options.titleBox).html(($(event.target).attr('title')));if(options.bringToFront&&event.type=='click'){var idx=$(event.target).data('itemIndex');var frontIndex=event.data.frontIndex;var diff=(idx-frontIndex)%images.length;if(Math.abs(diff)>images.length/2){diff+=(diff>0?-images.length:images.length)}event.data.rotate(-diff)}}});$(container).bind('mouseout',this,function(event){var context=event.data;clearTimeout(context.showFrontTextTimer);context.showFrontTextTimer=setTimeout(function(){context.showFrontText()},1000);context.autoRotate()});$(container).bind('mousedown',this,function(event){event.data.container.focus();return false});container.onselectstart=function(){return false};this.innerWrapper=$(container).wrapInner('<div style="position:absolute;width:100%;height:100%;"/>').children()[0];this.showFrontText=function(){if(items[this.frontIndex]===undefined){return}$(options.titleBox).html($(items[this.frontIndex].image).attr('title'));$(options.altBox).html($(items[this.frontIndex].image).attr('alt'))};this.go=function(){if(this.controlTimer!==0){return}var context=this;this.controlTimer=setTimeout(function(){context.updateAll()},this.timeDelay)};this.stop=function(){clearTimeout(this.controlTimer);this.controlTimer=0};

    this.rotate=function(direction){
        this.frontIndex-=direction;
        while (this.frontIndex<0) { this.frontIndex += items.length; }
        this.frontIndex%=items.length;
        this.destRotation+=(Math.PI/items.length)*(2*direction);
        this.showFrontText();
        this.go()
    };

    this.autoRotate=function(){if(options.autoRotate!=='no'){var dir=(options.autoRotate==='right')?1:-1;this.autoRotateTimer=setInterval(function(){ctx.rotate(dir)},options.autoRotateDelay)}};this.updateAll=function(){var minScale=options.minScale;var smallRange=(1-minScale)*0.5;var w,h,x,y,scale,item,sinVal;var change=(this.destRotation-this.rotation);var absChange=Math.abs(change);this.rotation+=change*options.speed;if(absChange<0.001){this.rotation=this.destRotation}var itemsLen=items.length;var spacing=(Math.PI/itemsLen)*2;var radians=this.rotation;var isMSIE=$.browser.msie;this.innerWrapper.style.display='none';var style;var px='px',reflHeight;var context=this;for(var i=0;i<itemsLen;i++){item=items[i];sinVal=funcSin(radians);scale=((sinVal+1)*smallRange)+minScale;x=this.xCentre+(((funcCos(radians)*this.xRadius)-(item.orgWidth*0.5))*scale);y=this.yCentre+(((sinVal*this.yRadius))*scale);if(item.imageOK){var img=item.image;w=img.width=item.orgWidth*scale;h=img.height=item.orgHeight*scale;img.style.left=x+px;img.style.top=y+px;img.style.zIndex=""+(scale*100)>>0;if(item.reflection!==null){reflHeight=options.reflHeight*scale;style=item.reflection.element.style;style.left=x+px;style.top=y+h+options.reflGap*scale+px;style.width=w+px;if(isMSIE){style.filter.finishy=(reflHeight/h*100)}else{style.height=reflHeight+px}}}radians+=spacing}this.innerWrapper.style.display='block';if(absChange>=0.001){this.controlTimer=setTimeout(function(){context.updateAll()},this.timeDelay)}else{this.stop()}};this.checkImagesLoaded=function(){var i;for(i=0;i<images.length;i++){if((images[i].width===undefined)||((images[i].complete!==undefined)&&(!images[i].complete))){return}}for(i=0;i<images.length;i++){items.push(new Item(images[i],options));$(images[i]).data('itemIndex',i)}clearInterval(this.tt);this.showFrontText();this.autoRotate();this.updateAll()};this.tt=setInterval(function(){ctx.checkImagesLoaded()},50)};$.fn.CloudCarousel=function(options){this.each(function(){options=$.extend({},{reflHeight:0,reflOpacity:0.5,reflGap:0,minScale:0.5,xPos:0,yPos:0,xRadius:0,yRadius:0,altBox:null,titleBox:null,FPS:30,autoRotate:'no',autoRotateDelay:1500,speed:0.2,mouseWheel:false,bringToFront:false},options);$(this).data('cloudcarousel',new Controller(this,$('.cloudcarousel',$(this)),options))});return this}})(jQuery);

    //This initialises carousels on the container elements specified.
    var formCarousel=$("#HCC_New").parent();
    $("#HCC_New").CloudCarousel(
        {
            xPos : formCarousel.width() * 0.5,
            yPos : 10,
            xRadius : formCarousel.width() / 2,
            yRadius : formCarousel.height() / 7,
            buttonLeft: $("#left-but"),
            buttonRight: $("#right-but"),
            altBox: $("#alt-text"),
            titleBox: $("#title-text"),
            minScale: 0.25,
            reflHeight : 40,
            reflGap : 4,
            reflOpacity : 0.75
        }
    );
    $(".loadingDiv").delay(1000);
    $(".loadingDiv").fadeOut(1000);
});
</script>
<!-- Fin du carrousel -->

<div id="hcccoverflow">test</div>

</center>

</div>


























