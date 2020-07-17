$("#userdetails > h2:nth-child(1)").append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://search.ebscohost.com/login.aspx?authtype=uid&user=ns257120main&password=hkhr_c7rk3&profile=eon">Go to Flipster</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://nextkansas.org/">Go to the home page</a>');

$('.shelvingloc:contains("Recently returned")').prepend('<i class="fa fa-exclamation-circle"></i>&nbsp;').parent().css('background','yellow');

$('.branch-HIAWATHA .btn:contains(Resume)').remove();
$('.branch-HIAWATHA #holdst td:nth-child(6)').text('Morrill Public Library in Hiawatha is currently closed for remodeling');

$('.branch-PHAXTEL .btn:contains(Resume), .branch-PHSES .btn:contains(Resume), .branch-PHSHS .btn:contains(Resume), .branch-PHSMS .btn:contains(Resume), .branch-PHWAC .btn:contains(Resume)').remove();
$('.branch-PHAXTEL #holdst td:nth-child(6), .branch-PHSES #holdst td:nth-child(6), .branch-PHSHS #holdst td:nth-child(6), .branch-PHSMS #holdst td:nth-child(6), .branch-PHWAC #holdst td:nth-child(6)').text('Your library is currently closed until further notice');

$('#add-account li:contains("This email address already exists in our database.")').append('<li>If you already have a library card and are trying to create a new one because you have forgotten the card number or lost your password, please contact us at <a href="mailto:nexthelp@nekls.org?subject=Self%20registration%20help">nexthelp@nekls.org</a>.</li>');

$('#opac-patron-registration #alternateaddress_legend, #opac-patron-registration label[for="borrower_contactnote"]').html('Notes:');
$('#opac-patron-registration #borrower_contactnote').after('<a style="color: red !important;">&nbsp;(Anything you want us to know.)</a>');

//$('<option value="" selected>Select your library from this list.</option>').insertBefore('#opac-patron-registration #borrower_branchcode > option:nth-child(1)');

$('#opac-patron-registration #borrower_branchcode').css('width','500px');

$('#memberentry_password .alert.alert-info p:contains("Your password must be at least 4 characters long.")').html('Your password must be at least 10 characters long');
$('#memberentry_password .alert.alert-info p:contains("If you do not enter a password")').remove();
$('#memberentry_password #password').attr('minlength','10');

$('#opac-patron-registration label[for="borrower_surname"]').html('Last name:');
$('#opac-patron-registration label[for="borrower_firstname"]').html('First name +/<br />middle initial /<br />or middle name:');
$('#opac-patron-registration label[for="borrower_othernames"]').html('Nickname /<br />other name:');
$('#opac-patron-registration label[for="borrower_address"]').html('Street address:');
$('#opac-patron-registration label[for="borrower_address2"]').html('Mailing address:');
$('#opac-patron-registration #borrower_address2').after('<a style="color: red !important;">&nbsp;(Leave this blank if your mailing address is the same as your street address.)</a>');

$('#opac-registration-confirmation #login').show();

$("#opac-login-page .alert.alert-info p").each(function(){
    var text = $(this).text();
    $(this).text(text.replace('a fixed number of', 'five (5)'));
});

$('#itype_id a[title="ILL"]').parent().parent().hide();

//BEGIN remove patron's ability to create new public lists or add titles to existing public lists
 //$('#addtolist #category option[value="2"], #addshelf #category option[value="2"], optgroup[label="Public lists"]').remove();


$('#advsearch [id^=search-field]').append('<option value="arl,phr">Accelerated Reader level</option>');
$('#advsearch [id^=search-field]').append('<option value="arp,phr">Accelerated Reader points</option>');
/*
/*RT 55766 1.14.19 LG*/
$(document).ready(function () {
    $('<option value="branch:HIGH_CC">Highland Community College</option>').insertAfter($('#select_library option:contains("Hiawatha, Morrill Public Library")'));
});

*/
$('body[class^="branch-"] .results_summary.online_resources a[href="https://nextkansas.org/cgi-bin/koha/opac-restrictedpage.pl"]').hide();
$('body[class^="branch-default"] .results_summary.online_resources a[href="https://nextkansas.org/cgi-bin/koha/opac-restrictedpage.pl"]').show();
$('body[class^="branch-"] .results_summary.online_resources a[href="https://search.ebscohost.com/login.aspx?authtype=uid&user=ns257120main&password=hkhr_c7rk2&profile=eon"]').show();
$('body[class^="branch-default"] .results_summary.online_resources a[href="https://search.ebscohost.com/login.aspx?authtype=uid&user=ns257120main&password=hkhr_c7rk2&profile=eon"]').remove();

//BEGIN Change "Login to your account" to "Sign in" (I commented this out, after 19.11 upgrade -DA)
//$("#members > ul > li:nth-child(1) > a").html("Sign in");

//BEGIN Rename SMS "Text messaging" for the sake of people who don't know what SMS stands for
  $('#opac-detail #holdingst .available').each(function() {
    var text = $(this).text();
    $(this).text(text.replace('Available', 'Not checked out'));
  });

$('#opac-detail #holdingst .checkedout').wrap('<span style="color: red;"></span>');

$("#wrap #opac-auth .brief #userid, #wrap #opac-auth .brief #password").attr("autocomplete","off");

$(".sco_entry #mainform .checkout.brief #patronlogin, .sco_entry #mainform .checkout.brief #patronpw").attr("autocomplete","off");


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


//BEGIN
  $("#opac-messaging #usermessaging li:contains('Some charges')").wrap("<span style='font-weight: bold; color: red;'></span>").append("<li><label>Note:</label>'Item due' and 'Advance notice' messages are generated between 2:00 and 2:30 a.m.  If you do not want your phone to alert you to these messages at that time of day, please disable these messages or set your phone's 'do-not-disturb' features.</li><li><label>Help:</label><a href='https://www.imore.com/how-to-setup-use-do-not-disturb-iphone-ipad'>Set do-not-disturb for iPhone</a> | <a href='https://www.howtogeek.com/260225/androids-confusing-do-not-disturb-settings-explained/'>Set do-not-disturb for Android phones</a></li><li><label>Provider lookup:</label><a href='https://freecarrierlookup.com/' target='_blank'>Free Carrier Lookup - Click here to lookup a mobile phone provider</a></li>");

//BEGIN Hides SMS number and all SMS checkboxes when page is loaded
  $("#sms1, #sms2, #sms4, #sms5, #sms6").attr("disabled","disabled");
  $("#SMSnumber").parent().hide();

//BEGIN Show SMS number if provider is not null and clear number and all SMS checkboxes if the provider is changed to null
  $("body").on("mousemove change click keyup", function(){
    if($("#sms_provider_id").val() != ""){
      $("#SMSnumber").parent().show("slow");
      } else {
      $("#SMSnumber").parent().hide("slow");
      $("#SMSnumber").val("");
      $("#smsbuttons").hide();
      $("#sms1, #sms2, #sms4, #sms5, #sms6").attr("disabled", "disabled");
      $("#sms1, #sms2, #sms4, #sms5, #sms6").prop("checked", false);
    }
  });

//BEGIN Enable SMS checkboxes only if SMS number is 10 digits and force SMS number entry to numerals only - no punctuation, alphanumeric characters, or spaces
  $("#SMSnumber").attr('maxlength','10');
  $('#SMSnumber').keydown(function (e) {
    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
      (e.keyCode == 65 && e.ctrlKey === true) ||
      (e.keyCode >= 35 && e.keyCode <= 40)) {
        return;
      }
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
      e.preventDefault();
    }
  });
  $("body").on("mousemove change click keyup", function(){
    if($("#SMSnumber").val().length == 10){
      $("#sms1, #sms2, #sms4, #sms5, #sms6").removeAttr("disabled");
      $("#smsbuttons").show("slow");
      } else {
      $("#sms1, #sms2, #sms4, #sms5, #sms6").attr("disabled", "disabled");
      $("#sms1, #sms2, #sms4, #sms5, #sms6").prop("checked", false);
      $("#smsbuttons").hide("slow");
    }
  });

//BEGIN Move SMS stuff above the table so that the first fields that need to be filled out are the first ones that patrons see
  $("#opac-messaging #usermessaging > form > fieldset.rows").insertBefore($("#opac-messaging #usermessaging > form > table"));
  $("#opac-messaging #usermessaging > form > fieldset.rows > ol:nth-child(3)").insertBefore($("#opac-messaging #usermessaging > form > fieldset.rows > ol:nth-child(2)"));

//BEGIN Rename SMS "Text messaging" for the sake of people who don't know what SMS stands for
  $('#opac-messaging label, #opac-messaging th').each(function() {
    var text = $(this).text();
    $(this).text(text.replace('SMS', 'Text message'));
  });

//BEGIN force SMS provider to sort alphabetically, put "Unknown" at top of list, and keep any pre-existing selection after sort is finished
  $("#sms_provider_id option:contains('Unknown')").text(' Unknown');
  $("#sms_provider_id").one( "click", function() {
    var preselected = $('#sms_provider_id option:selected').val();
    $("#sms_provider_id").html($('#sms_provider_id option').sort(function(x, y) {
      return $(x).text().toUpperCase() < $(y).text().toUpperCase() ? -1 : 1;
    }));
    $("#sms_provider_id").val(preselected);
  });

  $("#opac-messaging #usermessaging > form > table").parent().append("<div id='notes'><h3>Notes:</h3>Item due = the catalog sends you a notice the day an item is due<br />Advance notice = the catalog sends you a notice before an item is due - you select the number of days before items are due<br />Hold filled = the catalog sends you a notice within an hour of a hold arriving for pickup <ins>(presently not working for text messages)</ins><br />Item check-in = the catalog sends you a notice every time you check-in an item<br />Item check-out = the catalog sends you a notice every time you check-out an item<br />Digests only = 1 notice saying many items are due as opposed to many notices saying 1 single item is due<br /><br />The catalog will send notices to the address and/or text messaging number associated with your account<br />If you wish to receive text messages, you must select a provider, enter your mobile phone number, and check the boxes for the types of messages you wish to receive<br />Emails are sent to the address specified as the 'Primary e-mail' on your account (see the 'your personal details tab' on the left for more information)<br /></div>");

//BEGIN link Digest and E-mail checkboxes to work in tandem (Patron messaging preferences)
  $('#digest1').on('click', function(){
    var checked = $(this).is(':checked');
    $('#email1').attr('checked', checked);
  });
  $('#digest2').on('click', function(){
    var checked = $(this).is(':checked');
    $('#digest2, #email2').attr('checked', checked);
  });
  $('#email1').on('click', function(){
    var unchecked = $(this).is('checked', false);
    $('#digest1').attr('checked', false);
  });
  $('#email2').on('click', function(){
    var unchecked = $(this).is('checked', false);
    $('#digest2').attr('checked', false);
  });

//#borrower_branchcode


$("#opac-patron-update #borrower_branchcode").attr('disabled','disabled');
$("#opac-patron-update #borrower_dateofbirth").parent().hide();
$("#opac-patron-update #memberentry_identity > ol > li:nth-child(3) > a").hide();
$("label[for='borrower_emailpro']").parent().hide();
$("#opac-patron-update #memberentry_identity label[for='borrower_surname']").html("Last name:");
$("#opac-patron-update #memberentry_identity label[for='borrower_firstname']").html("First name +/<br />middle initial /<br />or middle name:");
$("#opac-patron-update #memberentry_identity label[for='borrower_othernames']").html("Nickname:");
$("#opac-patron-update #memberentry_contact label[for='borrower_email']").html("Email:");



//BEGIN Set newly placed holds in OPAC to expire after one year if not filled
  var holdtodate = new Date();
  var day = ("0" + holdtodate.getDate()).slice(-2);
  var month = ("0" + (holdtodate.getMonth() + 1)).slice(-2);
  var year = ("0" + (holdtodate.getFullYear() + 1)).slice(-4);
  var holdtill = (month) + "/" + (day) + "/" + (year);
  $('#hold-request-form .holddateto').val(holdtill);
//END

$("#opac-privacy #opac-privacy-update-form #privacy .privacy0").hide().attr("disabled","disabled");
$("#opac-privacy #opac-privacy-update-form #privacy .privacy1").html("Previous 13 months");
$("#opac-privacy-options-list > li.privacy0").hide();
$("#opac-privacy-options-list > li.privacy1").html("Previous 13 months: keep my reading history for the previous 13 months. This is the default option.");
$("#usersuggestions #add_suggestion_form #itemtype option").attr("disabled","disabled").hide();
$("#usersuggestions #add_suggestion_form #itemtype option[value='BOOK']").attr("selected","selected").removeAttr("disabled").show();
$("#usersuggestions #add_suggestion_form #itemtype option[value='AUDIOBOOK']").removeAttr("disabled").show();
$("#usersuggestions #add_suggestion_form #itemtype option[value='DIGITAL']").removeAttr("disabled").show();
$("#usersuggestions #add_suggestion_form #itemtype option[value='MEDIA']").removeAttr("disabled").show().html("Movie or TV show");
$("#usersuggestions #add_suggestion_form #itemtype option[value='MUSIC']").removeAttr("disabled").show().html("Music");
$("#usersuggestions #add_suggestion_form #itemtype option[value='MAGAZINE']").removeAttr("disabled").show();
$("#usersuggestions #add_suggestion_form #itemtype option[value='XXX']").removeAttr("disabled").show().html("Other");

$("#add_suggestion_form label:contains('Author')").parent().prependTo($("#add_suggestion_form label:contains('Title')").parent());
$("#add_suggestion_form label:contains('Item type')").parent().prependTo($("#add_suggestion_form label:contains('Copyright date')").parent());
$("#add_suggestion_form label:contains('Notes')").parent().appendTo($("#add_suggestion_form label:contains('Item type')").parent());
$("#add_suggestion_form label:contains('Collection title'), #add_suggestion_form label:contains('Publication place')").parent().hide();

// Set up Flipster link
 if ($("#logout").length) {
     $("#digital-nav").append("<li><a href=\"https://search.ebscohost.com/login.aspx?authtype=uid&user=ns257120main&password=hkhr_c7rk2&profile=eon\">Flipster</a></li>");
     $("#fliplink").removeClass("disabledLink");
     $("#fliplog").hide();
  }

//BEGIN Kill digital content as a pickup location
 $("#hold-request-form option[value='DIGITAL']").remove();

//BEGIN redirect school holds to nearest public library till the fall
$("option[value='PHAXTELL']").attr("value","").html('Prairie Hills - Axtell: Closed to requests until August');
$("option[value='PHSES']").attr("value","").html('Prairie Hills - Sabetha Elementary: Closed to requests until August');
$("option[value='PHSHS']").attr("value","").html('Prairie Hills - Sabetha High: Closed to requests until August');
$("option[value='PHSMS']").attr("value","").html('Prairie Hills - Sabetha Middle: Closed to requests until August');
$("option[value='PHWAC']").attr("value","").html('Prairie Hills - Wetmore: Closed to requests until August');

$("option[value='HIAWATHA']").attr("value","").html('Hiawatha, Morrill Public Library: Closed for remodelling');
$('.branch-HIAWATHA input[value="Confirm hold"]').remove();
$('.branch-HIAWATHA #holds #hold-request-form').parent().prepend('<h1>Requests cannot be placed at this time.<br />Your library is closed for remodelling.</h1>');
$("option[value='HIGH_CC']").attr("value","").html('Highland Community College: Temporarily closed');
$('.branch-HIGH_CC #holds #hold-request-form').parent().prepend('<h1>Requests cannot be placed at this time.<br />Please contact the library for information about their reopening.</h1>');

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

//Home › PATRONNAME › Your summary
  //BEGIN rename "Note" to "Report a problem"
    $("#userdetails #checkoutst th:contains(Note)").html("Report a problem");

      $('html').keyup(function() {
        $("#checkoutst [id^='save_']").text("Submit problem");
      });

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

$("#password-recovery label[for='username']").html("<br />Library card number or username:");

$('#password-recovery p').html($('#password-recovery p').html().replace('your login','your login informaion'));

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
