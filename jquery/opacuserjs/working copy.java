
//Needs research
$("#opac-login-page .alert.alert-info p").each(function(){
    var text = $(this).text();
    $(this).text(text.replace('a fixed number of', 'five (5)'));
    $("href").one("mouseenter", function(e){
       $("href").each(function() {
        this.href = this.href.replace('https://nextkansas.org/', 'http://catalog-test.nexpresslibrary.org');
       })
    });
});

//Needs research
$('#itype_id a[title="ILL"]').parent().parent().hide();

//Needs research
$('body[class^="branch-"] .results_summary.online_resources a[href="https://nextkansas.org/cgi-bin/koha/opac-restrictedpage.pl"]').hide();
$('body[class^="branch-default"] .results_summary.online_resources a[href="https://nextkansas.org/cgi-bin/koha/opac-restrictedpage.pl"]').show();
$('body[class^="branch-"] .results_summary.online_resources a[href="https://search.ebscohost.com/login.aspx?authtype=uid&user=ns257120main&password=hkhr_c7rk2&profile=eon"]').show();
$('body[class^="branch-default"] .results_summary.online_resources a[href="https://search.ebscohost.com/login.aspx?authtype=uid&user=ns257120main&password=hkhr_c7rk2&profile=eon"]').remove();



//BEGIN Hide PayPal option if patron owes less than $10.00 (Except LEAVENWRTH patrons)
  var sumvalue = parseInt($('#useraccount > form > table > tfoot > tr > td').html());
  if ((sumvalue < 10) && (!$("body").hasClass("branch-LEAVENWRTH scrollto"))){
    $("#useraccount .pay-online").hide();
    $("#useraccount > form").append("<div id='olpaynote'><h2>Online payments can only be accepted for amounts of $10.00 or more</h2></div>");
  }

//BEGIN force payment of all fees at once (except LEAVENWRTH patrons)
  if ((sumvalue > 10) && (!$("body").hasClass("branch-LEAVENWRTH scrollto"))){
    $('#opac-account #useraccount .checkbox-pay.pay-online').on('click', function(){
      var checked = $(this).is(':checked');
      $('#opac-account #useraccount .checkbox-pay.pay-online').attr('checked', checked);
    });
  }





// Set up Flipster link
 if ($("#logout").length) {
     $("#digital-nav").append("<li><a href=\"https://search.ebscohost.com/login.aspx?authtype=uid&user=ns257120main&password=hkhr_c7rk2&profile=eon\">Flipster</a></li>");
     $("#fliplink").removeClass("disabledLink");
     $("#fliplog").hide();
  }






function goBack() {
  window.history.back();
}
$('.holdrow [id^="toggle-hold-options"]').after('<a style="add_user" onclick="goBack()">Go back without making a request</a>');

//Fix searches by striping parenthesis and semicolons from url links
$('a[href*="opac-search.pl"]').attr('href', function(_,v){
    return v.replace(/(\w)(\(|\)|;)(\w)/g,'$1 $3')
}).attr('href', function(_,v){
    return v.replace(/(\(|\)|;)/g,'')
});
//End fix subject search



// Create a clone of the menu, right next to original.
$('#header-menu').addClass('original').clone().insertAfter('#header-menu').addClass('cloned').css('position','fixed').css('top','0').css('margin-top','0').css('z-index','500').removeClass('original').hide();

scrollIntervalID = setInterval(stickIt, 10);


function stickIt() {

  var orgElementPos = $('.original').offset();
  orgElementTop = orgElementPos.top;

  if ($(window).scrollTop() >= (orgElementTop)) {
    // scrolled past the original position; now only show the cloned, sticky element.

    // Cloned element should always have same left position and width as original element.
    orgElement = $('.original');
    coordsOrgElement = orgElement.offset();
    leftOrgElement = coordsOrgElement.left;
    widthOrgElement = orgElement.css('width');
    $('.cloned').css('left',leftOrgElement+'px').css('top',0).css('width',widthOrgElement).show();
    $('.original').css('visibility','hidden');
  } else {
    // not scrolled past the menu; only show the original menu.
    $('.cloned').hide();
    $('.original').css('visibility','visible');
  }
}


/*$("#password-recovery .alert.alert-info p").append("<p><br /><ins>You should receive your password recovery e-mail within 15 minutes.</ins></p>");
$("#email").after("<p><ins>You should receive a 'Password reset' e-mail within 15 minutes of clicking the 'Submit' button.</ins></p>");
*/





/*
jQuery.moveColumn = function (table, from, to) {
    var rows = jQuery('tr', table);
    var cols;
    rows.each(function() {
        cols = jQuery(this).children('th, td');
        cols.eq(from).detach().insertBefore(cols.eq(to));
    });
}

var tbl = jQuery('table');
jQuery.moveColumn(tbl, 2, 0);
jQuery.moveColumn(tbl, 4, 1);
jQuery.moveColumn(tbl, 4, 3);
jQuery.moveColumn(tbl, 5, 4);

*/

/* JS for Koha CoverFlow Plugin
   This JS was added automatically by installing the CoverFlow plugin
   Please do not modify */$(document).ready(function(){$.getScript("/plugin/Koha/Plugin/Com/ByWaterSolutions/CoverFlow/bower_components/jquery-flipster/dist/jquery.flipster.min.js",function(data,textStatus,jqxhr){$("head").append("<link id='flipster-css' href='/plugin/Koha/Plugin/Com/ByWaterSolutions/CoverFlow/bower_components/jquery-flipster/dist/jquery.flipster.min.css' type='text/css' rel='stylesheet' />");$('#hcccoverflow').load("/coverflow.pl?id=3154",function(){$('.koha-coverflow img').on("load",function(){if(this.naturalHeight==1){$(this).attr("src","https://raw.githubusercontent.com/bywatersolutions/web-assets/master/NoImage.png");}});var opt={'items':'.item','minfactor':15,'distribution':1.5,'scalethreshold':0,'staticbelowthreshold':false,'titleclass':'itemTitle','selectedclass':'selectedItem','scrollactive':true,'step':{'limit':4,'width':10,'scale':true}};$('#hcccoverflow').flipster({});});});});
/* End of JS for Koha CoverFlow Plugin */

$("href").one("mouseenter", function(e){
   $("href").each(function() {
    this.href = this.href.replace('https://nextkansas.org/', 'http://catalog-test.nexpresslibrary.org');
   })
});
