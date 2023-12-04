SP.OPACUserJS.txt

----------

Preference name: OPACUserJS

Type: Systempreference

Options: 70|10

----------

Preference value: 



$(document).ready(function() {
  
$('#opac-usersuggestions #usersuggestions .alert.alert-error').each(function() {
  var html = $(this).html();
  $(this).html(html.replace('document', 'title'));
 });
  
 //BEGIN Set newly placed holds in OPAC to expire after one year if not filled
    var url = $(location).attr('href');
    if (url.indexOf('opac-reserve.pl') != -1) {
      var holdtodate = new Date();
      var day = ("0" + holdtodate.getDate()).slice(-2);
      var month = ("0" + (holdtodate.getMonth() + 1)).slice(-2);
      var year = ("0" + (holdtodate.getFullYear() + 1)).slice(-4);
      var holdtill = (month) + "/" + (day) + "/" + (year);
      $('#hold-request-form .holddateto.hasDatepicker').val(holdtill);
      $('.toggle-hold-options').hide();
      $('.hold-options').show();
      $('.clear-date').hide();
    }

  $('.main .col-12').removeClass('col-lg-9');
  
  $('.facet-label a:contains("ZZ")').hide();
  
  $('#advsearch-itemtypes img').width(60).height(60).css('padding','10');
  
  $('#advsearch-ccode img').width(30).height(30);
  
  //Special functions
  //BEGIN Creates to html function
  $.fn.toHtml = function() {
    return $(this).html($(this).text());
  };
  
  //BEGIN renders notes on reports in HTML
  $('#opac-user #userdetails .alert.alert-info li strong').each(function() {
    $(this).toHtml();
  });

$('#advsearch-loc label[for^="loc"]:contains("Z")').parent().hide();
$('#advsearch-loc label[for="loc-127"]').parent().remove();
  
$('#advsearch-loc label[for^="loc"]:contains("YY")').each(function() {
 var text = $(this).text();
 $(this).text(text.replace('YY ', ''));
});


/* to fix formatting in 20.05.09 */
if ( $('#opac-detail').length ) {
  let koha_version = $('meta[name="generator"]').attr('content').slice(0, 10);
  if ( koha_version === 'Koha 20.05' ) {
         $('#catalogue_detail_biblio').parent().addClass('span9').removeClass('col-lg-9');
         $('.row').addClass('row-fluid').removeClass('row');
  } else {
         console.log('this jQuery is not being used ^^');
  }
}
/* end 20.05.09 formatting fix */

/* --------------- TEST server --------------- */

 //BEGIN alter test server
  var url = $(location).attr('href');
   if(url.indexOf('staff-test.nexpresslibrary') != -1){
    $("body").css("background-image", "url(https://raw.githubusercontent.com/northeast-kansas-library-system/nextimages/master/testserver_blue.png)"); //background
    $('.mastheadsearch').first().prepend('<div style="text-align: center;"><h1>!! Test Server !!</h1></div>'); //warning message
    //redirects any URLS to the production OPAC back to the test OPAC
    $('a[href^="https://nextkansas.org"]').each(function(){
     var oldUrl = $(this).attr("href"); // Get current url
     var newUrl = oldUrl.replace("https://nextkansas", "http://catalog-test.nexpresslibrary"); // Create new url
     $(this).attr("href", newUrl); // Set herf value
    });
   }

/* --------------- Changes to opac-detail.pl  --------------- */

 //BEGIN enhance "Recently returned" shelving location
  $('.shelvingloc:contains("Recently returned")').prepend('<i class="fa fa-exclamation-circle"></i>&nbsp;').parent().css('background','yellow');

 //BEGIN Make "Checked out" appear in red font on details page
  $('#opac-detail #holdingst .checkedout').wrap('<span style="color: red;"></span>');

 //BEGIN Make "Checked out" appear in red font on details page
  $('#opac-detail .item-status.intransit').html('In transit');

 //BEGIN Change "Available" to "Not checked out"
  $('#opac-detail #holdingst .available').each(function() {
   var text = $(this).text();
   $(this).text(text.replace('Available', 'Not checked out'));
  });

/* --------------- Changes to opac-memberentry.pl --------------- */

//Change names of fields on patron details/update form
 $("#opac-patron-update #borrower_branchcode").attr('disabled','disabled');
 $("#opac-patron-update #borrower_dateofbirth").parent().hide();
 $("#opac-patron-update #memberentry_identity > ol > li:nth-child(3) > a").hide();
 $("label[for='borrower_emailpro']").parent().hide();
 $("#opac-patron-update #memberentry_identity label[for='borrower_surname']").html("Last name:");
 $("#opac-patron-update #memberentry_identity label[for='borrower_middle_name']").html("Middle name /<br />or middle initial:");
 $("#opac-patron-update #memberentry_identity label[for='borrower_othernames']").html("Nickname:");
 $("#opac-patron-update #memberentry_contact label[for='borrower_email']").html("Email:");

//Force State to uppercase 2 character limit
   $('#opac-patron-update #borrower_state').next().after("<div class='required shortstate' style='display: none; font-weight: bold;'>States should be abbreviated in standard USPS fasion<br />Kansas = KS; Missouri =  MO; etc.</div>");
   $('#opac-patron-update #borrower_state').on('keyup', function(e) {
    $(this).val($(this).val().toUpperCase());
  });
  $('#opac-patron-update #borrower_state').keyup(function() {
    if ($(this).val().length>2) {
      $('.shortstate').show();
      $('#borrower_state').addClass('alert');
    } else if ($(this).val().length<=2) {
      $('.shortstate').hide();
      $('#borrower_state').removeClass('alert');
    }
  });


  $('#opac-patron-update #borrower_phone, #opac-patron-update #borrower_phonepro').after("<div class='required shortphone' style='display: none; font-weight: bold;'>Phone numbers should be entered in the format 999-999-9999<br />or entered as 'No phone' or 'Disconnected'</div>");
  $('#opac-patron-update #borrower_phone, #opac-patron-update #borrower_phonepro').keyup(function() {
    var phone = $('#opac-patron-update #borrower_phone, #opac-patron-update #borrower_phonepro').val();
    var phoneReg = /^([2-9][0-9]{2}-[0-9]{3}-[0-9]{4}|No phone|No phone|Disconnected|^$)+.*$/;
    if (!phoneReg.test(phone)) {
      $('.shortphone').show();
      $('#opac-patron-update #borrower_phone, #opac-patron-update #borrower_phonepro').addClass('alert');
    } else if (phoneReg.test(phone)) {
      $('.shortphone').hide();
      $('#opac-patron-update #borrower_phone, #opac-patron-update #borrower_phonepro').removeClass('alert');
    }
  });




/* --------------- Changes to opac-search.pl  --------------- */

//opac-search.pl - Add placards to search results
  //This will create a new expression (iContains) that will be a case-insensitive version of Contains.
    jQuery.expr[':'].iContains = function(a, i, m) {
      return jQuery(a).text().toUpperCase()
        .indexOf(m[3].toUpperCase()) >= 0;
    };

    var placard_count = 0;
    var placards = [
      [
        ['flipster', 'magazine', 'emagazine', 'journal', 'American farmhouse style', 'American farmhouse', 'Farmhouse style', 'Animal tales', 'Audubon', 'Beadwork', 'Better homes and gardens', 'Better homes gardens', 'Better homes', 'homes and gardens', 'homes gardens', 'Bon appétit', 'Clean eating', 'Consumer reports buying guide', 'Consumer reports', 'reports buying', 'reports guide', 'buying guide', 'Country living', 'Countryside and small stock journal', 'Countryside small stock journal', 'countryside small stock', 'small stock', 'Diversity in STEAM magazine', 'Diversity steam', 'steam Magazine', 'Girls\' life', 'GQ', 'Gentleman\'s Quarterly', 'Gentlemans Quarterly', 'HGTV magazine', 'ideas \& discoveries', 'ideas and discoveries', 'Internet genealogy', 'Interweave crochet', 'J\-14', 'J14', 'Library journal', 'Martha Stewart living', 'Martha stewart', 'Men\'s journal', 'Men\'s', 'mens journal', 'Midwest living', 'Motor trend', 'Prevention', 'Quilter\'s world', 'Quilter\'s', 'Real simple', 'Rolling stone', 'Sew news', 'Slam', 'Sports illustrated', 'Taste \& travel international', 'Taste and travel international', 'taste \& Travel', 'Taste and Travel', 'travel international', 'Taste of home', 'Taste home', 'The Atlantic monthly', 'Atlantic monthly', 'The Family handyman', 'Family handyman', 'The Old\-house journal', 'Old\-house journal', 'The old house journal', 'Old house journal', 'old house', 'house journal', 'Time', 'Travel \& leisure', 'Travel and leisure', 'Us weekly', 'Wired', 'Women\'s health', 'Womens health'], 'https://nekls.org/wp-content/uploads/2018/03/flipster.png', '<a href="/cgi-bin/koha/opac-shelves.pl?op=view&shelfnumber=7836" target="_blank"><h2><p>Looking for magazines - check out Flipster.<br />Flipster is a digital e-magazine service provided to you by Next Search Catalog.<br />Click here to see a list of Flipster titles.</p></h2></a>'
      ],
      [
        ['hoopla', 'ebook', 'e-book', 'e book', 'eaudiobook', 'e-audiobook', 'eaudio', 'e-audio', 'graphic novel', 'hoopla digital'], 'https://raw.githubusercontent.com/northeast-kansas-library-system/nextimages/master/vendors/hoopla-logo-blue.png', '<a href="https://www.hoopladigital.com/" target="_blank" id="hoopla-placc"><h2><p>Looking for e-books, e-audiobooks, e-comics, e-videos, or e-music?</p><p>Click here to visit Hoopla (library card required).</h2></a>'
      ]
    ];
    while (placard_count < placards.length) {
      var kw_count = 0;
      while (kw_count < placards[placard_count][0].length) {
        if ($('ul.breadcrumb a').is(':contains(Results):iContains(' + placards[placard_count][0][kw_count] + ')') && ($('ul.breadcrumb a[title*="You searched"]').length)) {
          $('div.searchresults tbody tr').eq(1).after('<tr><td colspan="3" style="background-color: lightyellow; border: 1px solid black;"><div class="placard-cdarchives"><img src="' + placards[placard_count][1] + '" style="float: left; padding-right: 20px; vertical-align: middle !important;">' + placards[placard_count][2] + '</div></td></tr>');
          $('div.searchresults tbody tr').eq(9).after('<tr><td colspan="3" style="background-color: lightyellow; border: 1px solid black;"><div class="placard-cdarchives"><img src="' + placards[placard_count][1] + '" style="float: left; padding-right: 20px; vertical-align: middle !important;">' + placards[placard_count][2] + '</div></td></tr>');
          kw_count = placards[placard_count][0].length;
        } else {
          kw_count++;
        }
      }
      placard_count++;
    }
//End
  
  $('#opac-holds .holdrow .branch select').attr('style', 'width: auto;');

  /*
 //BEGIN Prairie Hills closed for the summer (sometime in August or September 2021)
  $('.branch-PHAXTEL .btn:contains(Resume), .branch-PHSES .btn:contains(Resume), .branch-PHSHS .btn:contains(Resume), .branch-PHSMS .btn:contains(Resume), .branch-PHWAC .btn:contains(Resume)').remove();
  $('.branch-PHAXTEL #holdst td:nth-child(6), .branch-PHSES #holdst td:nth-child(6), .branch-PHSHS #holdst td:nth-child(6), .branch-PHSMS #holdst td:nth-child(6), .branch-PHWAC #holdst td:nth-child(6)').text('Your library is currently closed for the summer');
  $("option[value='PHAXTELL']").attr("value","SENECA").html('Prairie Hills - Axtell: Closed for the summer - Items will route to Seneca Free Library');
  $("option[value='PHSES']").attr("value","SABETHA").html('Prairie Hills - Sabetha Elementary: Closed for the summer - Items will route to Sabetha: Mary Cotton Library');
  $("option[value='PHSHS']").attr("value","SABETHA").html('Prairie Hills - Sabetha High: Closed for the summer - Items will route to Sabetha: Mary Cotton Library');
  $("option[value='PHSMS']").attr("value","SABETHA").html('Prairie Hills - Sabetha Middle: Closed for the summer - Items will route to Sabetha: Mary Cotton Library');
  $("option[value='PHWAC']").attr("value","WETMORE").html('Prairie Hills - Wetmore: Closed for the summer - Items will route to Wetmore Community Library');
*/

$('#advsearches #advsearch-ccode label:contains("Z")').parent().hide();

//---------- Changes to opac-reserve.pl  ----------//

 //BEGIN Change text of drop-down
  $("#opac-privacy #opac-privacy-update-form #privacy .privacy1").html("Previous 13 months");
  
 //BEGIN hide any COCE cover images if the record has a local cover image
  
if($('#opac-detail #local-thumbnail-preview:not(:contains("No cover image available"))').length > 0){
  setTimeout(function() {
        $('#coce-thumbnail-preview').hide();
    }, 2000);
  
}
  
if($('#results span[id^="local-thumbnail"]:not(:contains("No cover image available"))').length > 0){
  setTimeout(function() {
        $('span[id^="local-thumbnail"]:not(:contains("No cover image available"))').next('span[id^="coce-thumbnail"]').hide();
    }, 2000);
}

//Enhance Hoopla results
  jQuery(document).ready(checkContainer);

  function checkContainer() {
    if ($('#hoopla_results').is(':visible')) {
      $('#hoopla_results').css('padding-top', '20px').wrap('<div id="hoopla-banner" style="padding-top: 20px;"><table width="100%" style="border: 1px solid black;"><tr><td style="background-color: lightyellow;"></td></tr></table></div>');
      $('#hoopla-banner td').prepend('<img src="https://raw.githubusercontent.com/northeast-kansas-library-system/nextimages/master/vendors/hoopla_resulst_small.png" style="float: left; padding-right: 20px; max-width: 400px; height: auto;">');
      $('#numresults').clone().appendTo('#userresults');
      $('#hoopla_results a').each(function() {
        var text = $(this).text();
        $(this).text(text.replace('results in Hoopla', 'results in Hoopla for this search'));
      });
    } else {
      setTimeout(checkContainer, 50); //wait 50 ms, then try again
    }
  }

  $('#report_a_problem a:contains("Report a problem")').each(function() {
   var text = $(this).text();
   $(this).text(text.replace('problem', 'problem with this web page'));
  });
  
  $('#opac-reportproblem #message').attr('placeholder','Describe your problem with the web site.  If you are trying to report a problem with your library card or an item you\'ve checkeked out, please phone your library directly.');
  
//Advanced search
//BEGIN add accelerated reader searches to advanced search
  if ($('#advsearch').length) {
    $("select[id^=search-field]").append('<option value="arl,phr">Accelerated Reading Level</option>');
    $("select[id^=search-field]").append('<option value="arp,phr">Accelerated Reading Point</option>');
  }

$('#checkoutst #checkout-notes').html('Report a problem<br />with this item');

$('#checkoutst .btn.btn-primary.btn-sm.js_submitnote').attr('title','If you believe you have already returned an item, please phone or e-mail the library where you checked the item out');
  
  $('#advsearch-tab-loc a').text('Age group');

$('#searchform input, .search-term-input .form-control').attr('onkeyup','this.value = this.value.replace(/[:|;|?|*]/g, "-")');


// start e-card jQuery
if ($('#usermenu').length) {
 let ecard_report_number = 3663;
 let eborrowernumber = $('.loggedinusername').attr('data-borrowernumber');
 $.getJSON(`/cgi-bin/koha/svc/report?id=${ecard_report_number}&sql_params=` + eborrowernumber, function(data) {
 $.each(data, function(index, value) {
 let ecard_number = data[0][0];
 let ecard_name_obj = $('.userlabel').text();
 let ecard_name = ecard_name_obj.split("Welcome, ");
 $('#menu ul li:eq(0)').before('<li class="active"><a data-toggle="modal" data-target=".ecardModal">Your library card</a></li>');
 $('body').append('<div class="ecardModal modal hide" tabindex="-1" role="dialog"> <div class="modal-dialog" role="document"> <div class="modal-content"> <div class="modal-header"> <h5 class="modal-title"></h5><h3>Your Library eCard</h3> </div><div class="modal-body"> <div id="library_ecard"> <div id="name_photo"> <h3>' + ecard_name[1] + '</h3> </div><div style="text-align: center;"> <svg id="barcode_placeholder"></svg> </div></div></div><div class="modal-footer"> <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> </div></div></div>');
 $.getScript("https://cdnjs.cloudflare.com/ajax/libs/jsbarcode/3.11.0/barcodes/JsBarcode.codabar.min.js")
 .done(function(script, textStatus) {
 var element = document.getElementById("barcode_placeholder");
 JsBarcode(element, ecard_number, {
 width: 3,
 height: 100,
 displayValue: true,
 });
 });
 });
 });
}
// end e-card jQuery

  //BEGIN Prevent leading and trailing whitespace on list name
  $('#opac-userlists #shelfname').bind("keypress", function(e) {
  if (e.keyCode == 13) {               
    e.preventDefault();
    return false;
  }
});
 $('#opac-userlists #shelfname').on('blur', function() {
  $(this).val(function(i, value) {
   return value.replace(/[^a-zA-Z 0-9]/g, '').replace(/\s+/g, ' ').trim();
  });
 });
  
$('#opac-user #holdst .branch:contains("Winchester Public Library")').parent().addClass('winc_closed');

  $('.winc_closed td:nth-child(6)').wrapInner('<span style="display: none;">');
  
if($('#opac-user #holdst .branch:contains("Winchester Public Library")').length > 0){
  $('#resume_all_submit').hide();
}

});

























