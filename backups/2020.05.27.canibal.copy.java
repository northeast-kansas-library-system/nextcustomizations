$(document).ready(function() {
//never delete anything above this comment


$('#pat_memberentrygen #zipcode').attr('maxlength', '5');

  $('#wrong-transfer-modal .modal-footer, #item-transfer-modal .modal-footer, #hold-found2 .modal-footer').append('<button id="dropme" type="button" class="btn btn-default" style="display: inline; position: absolute; left: -999px">playsound</button><audio id=alarm><source src=https://raw.githubusercontent.com/northeast-kansas-library-system/next.training/master/source/sounds/transfer.ogg></audio>');

$('#wrong-transfer-modal, #item-transfer-modal').on('shown.bs.modal', function () {
    $('.approve').focus();
})

$('#hold-found2').on('shown.bs.modal', function () {
    $('#dropme').focus();
})

$("#wrong-transfer-modal .approve, #item-transfer-modal .approve").keypress(function(event) {
  event.preventDefault();
  if (event.which == 32) {
   $(".approve").click()
  } else if (event.which == 13) {
   document.getElementById('alarm').play();
   $('.modal-content').fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
   $('.modal-content').attr('style','background-color: chartreuse; font-size: 200%');
  }
});

$("#hold-found2 #dropme").keypress(function(event) {
  event.preventDefault();
  if(event.which == 32) {
   document.getElementById('alarm').play();
  } else if  (event.which == 13) {
   document.getElementById('alarm').play();
   $('.modal-content').fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
   $('.modal-content').attr('style','background-color: chartreuse');
   $('.modal-content h4').attr('style','font-size: 300%; background-color: chartreuse');
   $('.modal-content h4:contains("Notes:"), .modal-content li, .modal-content h5').hide()
  }
});


$('#circ_returns .problem:contains("Item is withdrawn.")').parent().parent().addClass('lostreturned');
$('#circ_returns .problem:contains("Item was lost, now found.")').parent().parent().addClass('lostreturned');
$('#circ_returns .approve:contains("Confirm hold and transfer")').parent().parent().addClass('transfer-alert');
$('#circ_returns .approve:contains("Confirm hold")').parent().parent().addClass('hold-arrived');

$('#manual_restriction_form #rcomment').attr('required', 'required').attr('class','required');

  //restriction note
   $('#manual_restriction_form input[value="Add restriction"]').one( "click", function(){
    $("#manual_restriction_form #rcomment").val( function( index, val ) {
     return val + " - manual restriction added by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim())
    })
   });

//$('#catalog_moredetail .label:contains("Last returned by:")').html("Last patron to have the item:");

  $('#table_account_fines th:contains("Return date"), #finest th:contains("Return date")').text("Last status change");

//Home > Patrons > Pay fines for PATRONNAME > Pay an individual fine
 //Hide "Collected from patron:" and "Change to give:" drop-downs but also add a button to make their appearance optional
  $('#pat_paycollect #change, #pat_paycollect #collected').parent().hide();
  $('#pat_paycollect #paid').parent().append("<li><label></label><button id='changecalc' type='button' class='btn btn-default' style='margin:10px 0px 0px 0px;'>Calculate change (optional)</button></li>");
  $("#changecalc").click( function() {
   $("#changecalc").hide();
   $('#pat_paycollect #change, #pat_paycollect #collected').parent().show();
  });

$('#pat_paycollect #paid').keyup(function() {
    $('#collected').val($('#paid').val());
});

/*  $('#pref_IntranetUserJS').show();
  $('#expand_IntranetUserJS').hide(); */

$("#pat_paycollect label[for='payment_type']").html("Payment type<br />(optional):");

$('#pat_paycollect #change, #pat_paycollect #collected').parent().hide();

$('#phone').attr('placeholder','999-999-9999');

  $('#cat_additem option[value="MEDIA"]').attr('disabled','disabled').remove();

$('#homebranch_id ul li:nth-child(1)').prepend('<li style="display: none;">X</li>');

//BEGIN add accelerated reader searches to advanced search
if ( $('#catalog_advsearch').length ) {
$("select.advsearch").append('<option value="arl,phr">Accelerated Reading Level</option>');
$("select.advsearch").append('<option value="arp,phr">Accelerated Reading Point</option>');
}

if ( $('#area-userblock').length ) {
 $.getJSON("/cgi-bin/koha/svc/report?id=3262%26param_name=library1&sql_params=" + ($(".logged-in-branch-code").html().trim()) + "&param_name=library2&sql_params=" +  ($(".logged-in-branch-code").html().trim()), function( data1 ) {
   $.each(data1, function(index, value) {
    // json is a record arr
    var json = value;
    var tr;
    tr = $('<tr/>');
    $.each(json, function(index, value) {
    tr.append("<td>" + value + "</td>");
    });
    $('#localrequests_table').append(tr); // alert( index + ": " + value );
   });
 });
}

$('#cat_additem span[id^="error"]').parent().css('text-align', 'right');

    $('[id*="tag_952_subfield_y_"] option[value="LOCALHOLD1"]').attr('disabled', 'disabled');

 var branchescode = $(".logged-in-branch-code").first().text().trim()
 $("body").addClass(branchescode);

//Koha > * (all pages)
 //BEGIN Prevent Checkout search for short strings
  $("#patronsearch").on('submit', function(e){
   e.preventDefault();
   var len = $('#findborrower').val().length;
   if (len > 3 && len > 1) {
    this.submit();
    } else {
    alert("Please enter four or more characters to perform a checkout search to avoid returning too many results");
   }
  });

/* //BEGIN Prevent Patron search for short strings
  $("#patron_search form").on('submit', function(e){
   e.preventDefault();
   var len = $('#searchmember').val().length;
   if (len > 3 && len > 1) {
    this.submit();
    } else {
    alert("Please enter four or more characters to perform a patron search to avoid returning too many results");
   }
  });
*/

 //BEGIN open drop-downs on hover
  $(".navbar-nav li.dropdown:lt(3)").hover(function(){
   $(this).addClass("open");
   }, function(){
    $(this).removeClass("open");
   }
  );

 //BEGIN adds date in mm/dd/yyyy format to #todaysdate on every page in the system - very useful
  var now = new Date();
  var day = ("0" + now.getDate()).slice(-2);
  var month = ("0" + (now.getMonth() + 1)).slice(-2);
  var year = ("0" + (now.getFullYear())).slice(-4);
  var now = (month) + "/" + (day) + "/" + (year);
  $(".gradient").before("<span id='todaysdate' style='display: none;'>"+ now + "</span>");

 //BEGIN Fix searches by striping parenthesis and semicolons from links
  $('a[href*="search.pl"]').attr('href', function(_,v){
   return v.replace(/(\w)(\(|\)|\;|\!)(\w)/g,'$1 $3')
     }).attr('href', function(_,v){
   return v.replace(/(\(|\)|\;|\!)/g,'')
  });

 //BEGIN disable autocomplete in checkout box
  $("#patronsearch").attr("autocomplete","off")

 //BEGIN re-logo the staff client
  //All pages-url for logo https://nekls.org/wp-content/uploads/2018/03/nekls_next_logo.png
   $("#header_search").before('<div id="newlogo" style="float: left; padding: 10px; height: 88;"><a href="/cgi-bin/koha/mainpage.pl"><img src="https://nekls.org/wp-content/uploads/2018/03/nekls_next_logo.png" height="50" width="150"><p style="font-size: 75%;">A service of NEKLS</p></a></div>');

//Catalog > Details for -TITLE-//
 //BEGIN Redirect NoveList Select links to the staff client instead of the OPAC
$("#NovelistSelect").one("mouseenter", function(e){
   $("#NovelistSelect a").each(function() {
    this.href = this.href.replace('/cgi-bin/koha/opac-search.pl', '/cgi-bin/koha/catalogue/search.pl');
   })
});


//KOHA > * (all pages with breadcrumbs)
 //BEGIN add message to all screens with breadcrumbs - requires css to hide ids and classes (good for upgrade notes, etc.)
  $("#breadcrumbs").prepend("<br /><h4>New check-outs will follow normal circulation rules.  <a href='https://northeast-kansas-library-system.github.io/nexttraining/pages/circ.modifydue.html' target='_blank'>Click here for instructions on how to update due dates when checking out items.</a></h4>");

//Administration > System preferences
 //BEGIN add link to bypass Code Mirror on IntranetUserJS system preference
  $('#expand_IntranetUserJS').text('Edit with Code Mirror');
  $('#expand_IntranetUserJS').after('<p></p><a id="intranomirror" href="#pref_IntranetUserJS">Edit without Code Mirror</a>');
  $("#intranomirror").click( function() {
   $("#expand_IntranetUserJS, #intranomirror").hide();
   $('#pref_IntranetUserJS').show();
  });
  $("#expand_IntranetUserJS").click( function() {
   $("#intranomirror").hide();
  });

 //BEGIN add link to bypass Code Mirror on OPACUserJS system preference
  $('#expand_OPACUserJS').text('Edit with Code Mirror');
  $('#expand_OPACUserJS').after('<p></p><a id="opacnomirror" href="#pref_OPACUserJS">Edit without Code Mirror</a>');
  $("#opacnomirror").click( function() {
   $("#expand_OPACUserJS, #opacnomirror").hide();
   $('#pref_OPACUserJS').show();
  });
  $("#expand_OPACUserJS").click( function() {
   $("#opacnomirror").hide();
  });

//Administration > Circulation and fine rules
 //BEGIN Click on rule to move it to the bottom of the table
   $("#default-circulation-rules tr:contains(Edit)").click(function() {
    $(this).insertAfter("#default-circulation-rules tbody tr:last");
   });

 //BEGIN Highlight row on hover
  $("#default-circulation-rules tr").hover(
    function() {
      $( this ).addClass( "highlighted-row" );
    }, function() {
      $( this ).removeClass( "highlighted-row" );
    }
  );

 //BEGIN Create button to hide left hand navigation
  $("#admin_smart-rules #navmenu").parent().prepend("<button id='navhide' type='button' style='margin: 5px'>Hide admin column</button>");
  $("#navhide").click( function() {
   $("#navhide, #navmenu, #allshows").hide();
   $(".row .col-sm-10.col-sm-push-2").removeClass("col-sm-push-2");
  });

 //BEGIN Create button to expand collapsed rule columns
  $("#admin_smart-rules #navmenu").parent().prepend("<button id='allshows' type='button' style='margin: 5px'>Show all</button>");
  $("#allshows").click( function() {
   $("#navhide, #navmenu, #allshows").hide();
   $(".hiderule").removeClass();
   $(".row .col-sm-10.col-sm-push-2").removeClass("col-sm-push-2");
  });

 //BEGIN Hide unneeded columns in circulation rules by clicking on header (--requires corresponding css--)
  $("#default-circulation-rules thead th").append("<br /><br /><span>Hide<br />Column</span>");
  $('#default-circulation-rules thead th').click(function() {
   var index = (this.cellIndex + 1);
   var cells = $('#default-circulation-rules tr > :nth-child(' + index + ')');
   cells.toggleClass('hiderule');
   if ($(this).hasClass('hiderule')) {
    $(this).find('span').html('+');
    } else {
    $(this).find('span').html('Hide<br />Column');
   }
   if ($('table tr > th:not(.collapsed)').length)
    $('table').removeClass('collapsed');
     else
    $('table').addClass('collapsed');
   });

 //BEGIN hide columns by default
  $("#default-circulation-rules th:nth-child(15), #default-circulation-rules td:nth-child(15)").addClass("hiderule");
  $("#default-circulation-rules th:nth-child(16), #default-circulation-rules td:nth-child(16)").addClass("hiderule");
  $("#default-circulation-rules th:nth-child(17), #default-circulation-rules td:nth-child(17)").addClass("hiderule");
  $("#default-circulation-rules th:nth-child(18), #default-circulation-rules td:nth-child(18)").addClass("hiderule");
  $("#default-circulation-rules th:nth-child(21), #default-circulation-rules td:nth-child(21)").addClass("hiderule");
  $("#default-circulation-rules th:nth-child(22), #default-circulation-rules td:nth-child(22)").addClass("hiderule");
  $("#default-circulation-rules th:nth-child(23), #default-circulation-rules td:nth-child(23)").addClass("hiderule");
  $("#default-circulation-rules th:nth-child(24), #default-circulation-rules td:nth-child(24)").addClass("hiderule");
  $("#default-circulation-rules th:nth-child(30), #default-circulation-rules td:nth-child(30)").addClass("hiderule");
  $("#default-circulation-rules th:nth-child(31), #default-circulation-rules td:nth-child(31)").addClass("hiderule");
  $("#default-circulation-rules > thead > tr > th.hiderule > span").html("+");

 //BEGIN Sort circulation rules by clicking on footer
   $('#default-circulation-rules tfoot tr th').click(function(){
     var table = $(this).parents('table').eq(0)
     var rows = table.find("tbody tr").toArray().sort(comparer($(this).index()))
     this.asc = !this.asc
     if (!this.asc){rows = rows.reverse()}
     for (var i = 0; i < rows.length; i++){table.append(rows[i])}
   })
   function comparer(index) {
     return function(a, b) {
       var valA = getCellValue(a, index), valB = getCellValue(b, index)
       return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA.toString().localeCompare(valB)
     }
   }
   function getCellValue(row, index){
     return $(row).children('td').eq(index).text()
   }
   $("#default-circulation-rules #edit_row").insertBefore("tfoot");

 //BEGIN Create button to copy the bottom row on the rules table
  $("#admin_smart-rules #edit_row td:nth-child(3)").append("<br /><button id='copyrrow' type='button' style='margin: 5px' class='btn btn-default btn-xs'>Copy bottom row</button>");
  $("#copyrrow").click( function() {
   $('#lrrow').removeAttr('id');
   $('#default-circulation-rules tbody tr:last').attr('id','lrrow');
   $('#maxissueqty').val($('#lrrow td:eq(4)').text().trim());
   $('#maxonsiteissueqty').val($('#lrrow td:eq(5)').text().trim());
   $('#issuelength').val($('#lrrow td:eq(6)').text().trim());
   $('#fine').val($('#lrrow td:eq(9)').text().trim());
   $('#chargeperiod').val($('#lrrow td:eq(10)').text().trim());
   $('#firstremind').val($('#lrrow td:eq(12)').text().trim());
   $('#overduefinescap').val($('#lrrow td:eq(13)').text().trim());
   $('#fined').val($('#lrrow td:eq(15)').text().trim());
   $('#maxsuspensiondays').val($('#lrrow td:eq(16)').text().trim());
   $('#suspension_chargeperiod').val($('#lrrow td:eq(17)').text().trim());
   $('#renewalsallowed').val($('#lrrow td:eq(18)').text().trim());
   $('#renewalperiod').val($('#lrrow td:eq(19)').text().trim());
   $('#norenewalbefore').val($('#lrrow td:eq(20)').text().trim());
   $('#no_auto_renewal_after').val($('#lrrow td:eq(22)').text().trim());
   $('#reservesallowed').val($('#lrrow td:eq(24)').text().trim());
   $('#holds_per_day').val($('#lrrow td:eq(25)').text().trim());
   $('#holds_per_record').val($('#lrrow td:eq(26)').text().trim());
   $('#rentaldiscount').val($('#lrrow td:eq(30)').text().trim());
  });

//Administration > Libraries and groups > Modify library
 //BEGIN Branch input - relabel address line input
  $("#admin_branches.admin label[for='branchaddress1']").html("Mailing address:");
  $("#admin_branches.admin label[for='branchaddress2']").html("Street address /<br />Physical address:");
  $("#admin_branches.admin label[for='branchaddress3']").html("Director / ILL contact:");
  $("#admin_branches.admin label[for='branchcountry']").html("KLE Code:");

//Administration > Transportation cost matrix
 //BEGIN Click on library name and row will move to the top of the table
   $("#cost_matrix_form #transport-cost-matrix tr th:nth-child(1)").click(function() {
    $(this).parent().insertAfter("#cost_matrix_form #transport-cost-matrix tbody tr:first");
   });

//Catalog
 //BEGIN Make patron link in title details page go to "Circulation > Checkouts > -PATRONNAME-" instead of "Patrons > Patron details for -PATRONNAME-"
  $('#catalog_detail a').each(function() {
   this.href = this.href.replace('members/moremember.pl', 'circ/circulation.pl');
  });

 //BEGIN Toggle "Show contents"
  $('#catalog_detail .contentblock').hide();
  $('#catalog_detail span:contains("Contents")').html('<div class="contents_s" style="text-align: left; display: block;"><h2><ins>Click to show contents</ins></h2></div><div class="contents_h" style="text-align: left; display: none;"><h2>Click to hide contents</h2></div>');
  $('#catalog_detail .contentblock, .contents_s, .contents_h').click(function() {
   $('#catalog_detail .contentblock, .contents_s, .contents_h').toggle();
  });

//Catalog > Detalis for -TITLE-
 //Enhance item statuses

  $('.status .lost, .status .dmg').prepend('<i class="fa fa-exclamation-triangle"></i>&nbsp;').parent().css('background','red');
  $('.status .intransit').prepend('<i class="fa fa-truck"></i>&nbsp;').parent().css('background','orange');
  $('.status:contains("Not for loan")')
    .contents()
    .filter(function() {
      return this.nodeType == Node.TEXT_NODE;
    }).wrap("<span class='noloan'></span>");
  $('.status .noloan, .status .wdn').prepend('<i class="fa fa-ban"></i>&nbsp;').parent().css('background','red');

  $('.status:contains("Item-level"), .status:contains("item level hold")')
    .contents()
    .filter(function() {
      return this.nodeType == Node.TEXT_NODE;
    }).wrap("<span class='ilrequest'></span>");
  $('.ilrequest:contains("priority = 0")').remove();
  $('.ilrequest:not(:contains("level"))').remove();
  $('.ilrequest').html('<p><i class="fa fa-info-circle"></i>&nbsp; Has item level request.</p>');
  $('.ilrequest').next('a').hide();

  $('.status:contains("Waiting at")')
    .contents()
    .filter(function() {
      return this.nodeType == Node.TEXT_NODE;
    }).wrap("<span class='waiting-hold'></span>");
  $('.status .waiting-hold:not(:contains("Waiting at"))').remove();
  $('.status .waiting-hold').prepend('<i class="fa fa-clock-o"></i>&nbsp;').parent().css('background','lawngreen');

//Catalog > Item details for -TITLE-
 //BEGIN Hide lost value 2  (Lost (more than 45 days overdue)) from item details screen
  $("div.listgroup:nth-child(3) > ol:nth-child(2) > li:nth-child(4) > form:nth-child(2) > select:nth-child(4) option[value='2']").hide();

 //BEGIN hide paid for by and rename last borrower information
  $('#catalog_moredetail li:contains("Paid for")').hide();
  $('#catalog_moredetail .label:contains("Last returned by:")').addClass("lreturned");
  $('.lreturned').text('Last patron to have item:').attr('title', '"Last patron to have item" and "Last borrower" should be the same unless the most recent borrower has their checkout history disabled.');
  $('#catalog_moredetail .label:contains("Last borrower:")').parent().addClass("lborrower");
  $('.lborrower span').attr('title', '"Last borrower" and "Last patron to have item" should be the same unless the most recent borrower has their checkout history disabled.');
  $('#catalog_moredetail .label:contains("Previous borrower:")').parent().addClass("pborrower");
  $('.lborrower').next('.pborrower').addClass("2");
  $('.pborrower.2 .label').text('Previous borrower (2):');
  $('.pborrower.2').next('.pborrower').addClass("3");
  $('.pborrower.3 .label').text('Previous borrower (3):');

/*  $('.pborrower').eq(2).text('Previous borrower (3):');
*/  //$('#catalog_moredetail li:contains("Last borrower")').addClass("lborrower2");
  //$('#catalog_moredetail li:contains("Last borrower")').next().addClass("pborrower2");
  //$('#catalog_moredetail li:contains("Last borrower")').next().next().addClass("pborrower3");
  //$('.pborrower2 .label').text('Previous borrower (2)');
  //$('.pborrower3 .label').text('Previous borrower (3)');
  //$('.lborrower2 .label').text('Last borrower (1)');

//Catalog > -TITLE- > Place a hold on -TITLE-//
 //BEGIN Make patron link on this page go to "Circulation > Checkouts > -PATRONNAME-" instead of "Patrons > Patron details for -PATRONNAME-"
  $('#circ_request a').each(function() {
   this.href = this.href.replace('members/moremember.pl', 'circ/circulation.pl');
  });

 //BEGIN add staff information to notes when placing requests
  $('#circ_request #hold-request-form input[type="submit"]').one( "click", function(){
   $("#holdnotes").val( function( index, val ) {
    return val + " - request placed by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim())
   })
  });

//Catalog > Search
 //BEGIN Puts the cursor in the search field on the results screen
  $("#catalog_results #search-form").focus();
  $("#catalog_results #search-form").attr('value', '');

//Catalog > Search for SEARCHTERMS
 //BEGIN change "available" to "not checked out"
/*  $('#bookbag_form > table > tbody > tr td:last-child > div > strong').each(function() {
   var text = $(this).text();
   $(this).text(text.replace(' available:', ' not checked out'));
  });*/

 //BEGIN Hoopla items unavailable > digital content
  $('#bookbag_form > table > tbody > tr td .availability:contains("DIGITAL CONTENT")').addClass('digitalavailable');
  $('.digitalavailable strong, .digitalavailable .unavailable').each(function() {
   var text = $(this).text();
   $(this).text(text.replace('None available', 'Digital content'));
  });
  $('.digitalavailable .unavailable').each(function() {
   var text = $(this).text();
   $(this).text(text.replace('1 unavailable:', 'Digital content'));
  });

 //BEGIN Toggle non-local copies in search results
  //Create buttons to revert view
   $("#catalog_results #selection_ops").append('<div class="btn-group" style="padding-left: 50px"><a class="btn btn-default btn-xs" id="results_sh" href="#" style="display: block; width: 125px; border-radius: 5px;"><span id="results_all" style="display: block;">Show all copies</span><span id="results_loc" style="display: none;">Show local copies</span></a></div>');
   $("#results_all").click(function(){
    $("#results_loc").show();
    $("#results_all").hide();
    $(".availability").children("ul").show();
    return false;
   });
   $("#results_loc").click(function(){
    $("#results_loc").hide();
    $("#results_all").show();
    $(".availability").children("ul").hide();
    return false;
   });

  //Show only ‘Local Copies [logged in library]’ or ‘No Local Copies’ in staff search results
   var loglibnode=$("span.logged-in-branch-name:nth-child(1)").text().trim();
   $(".availability").each(function(){
    var ownedlocal=false;
    var our_copy_item;
    $(this).children("ul").each(function(){
     our_copy_item=$(this).find('li:contains("'+loglibnode+'")')
     if(our_copy_item.length){
      ownedlocal=true;
      $(this).parent('.availability').after("<ul>",our_copy_item,"</ul>");
     }
    });
    $(this).append("<br>Click + OR title for full availability");
    if(ownedlocal){
     $(this).append("<h4><span style='color:green; font-weight:bolder;'>Local copies:</span></h4>");
      } else {
     $(this).append("<br/><p><span style='color:red; font-weight:bold;'>No local copies</span></p>");
    }
   });
  //Condense Locations on Staff Catalog Results
   $("#bookbag_form div[class='availability']").children("ul").hide();
   $("#bookbag_form div[class='availability'] strong").wrap("<a class='viewLocations' />");
   $("#bookbag_form div[class='availability'] strong").append("<span class='instruct'> (+)</span><span class='instruct' style='display: none;'> (-)</span>");
   $("#bookbag_form div[class='availability']").parent("td").attr('width','290');
  //Trigger for condensed locations
   $(".viewLocations").click(function() {
    $(this).find(".instruct").toggle();
    $(this).parent().parent().find("ul").toggle("slow");
   });

//Catalog > TITLE > Place a hold on TITLE
 //BEGIN changes default item sort order to Home library
  $('#requestspecific').on( 'init.dt', function () {
   $(this).dataTable().fnSort( [ $(this).find('tr[role=row] th:contains("Home library")').index('th'), 'asc' ] );
  });

 //BEGIN Set newly placed holds in staff client to expire after one year if not filled
  var holdtodate = new Date();
  var day = ("0" + holdtodate.getDate()).slice(-2);
  var month = ("0" + (holdtodate.getMonth() + 1)).slice(-2);
  var year = ("0" + (holdtodate.getFullYear() + 1)).slice(-4);
  var holdtill = (month) + "/" + (day) + "/" + (year);
  $('#hold-request-form #to').val(holdtill);

//Cataloging
 //BEGIN Hide Z, DVD, and Online resource Frameworks
  $("#cat_addbooks li:contains('Z Framework')").hide();
  $("#cat_addbooks li:contains('DVD framework')").hide();
  $("#cat_addbooks li:contains('Online resource')").hide();

 //BEGIN Hide merge button on cataloging search
  $("#cat_addbooks .merge-items").hide();

//Cataloging > ADD MARC RECORD
 //BEGIN highlight subfield row
  $("#cat_addbiblio .subfield_line, #cat_addbiblio .tag, #cat_additem .subfield_line").hover(
    function() {
      $( this ).addClass( "cathover" );
    }, function() {
      $( this ).removeClass( "cathover" );
    }
  );

 //BEGIN Add labels to Marc tabs
  $(".toolbar-tabs-container a[href='#tab0XX']").append("<br />Control and coded fields");
  $("#tab0XX h3").append(" - Control and coded fields");
  $(".toolbar-tabs-container a[href='#tab1XX']").append("<br />Main entry");
  $("#tab1XX h3").append(" - Main entry");
  $(".toolbar-tabs-container a[href='#tab2XX']").append("<br />Title and edition");
  $("#tab2XX h3").append(" - Title and edition");
  $(".toolbar-tabs-container a[href='#tab3XX']").append("<br />Physical description");
  $("#tab3XX h3").append(" - Physical description");
  $(".toolbar-tabs-container a[href='#tab4XX']").append("<br />Series");
  $("#tab4XX h3").append(" - Series");
  $(".toolbar-tabs-container a[href='#tab5XX']").append("<br />Notes");
  $("#tab5XX h3").append(" - Notes");
  $(".toolbar-tabs-container a[href='#tab6XX']").append("<br />Subject access");
  $("#tab6XX h3").append(" - Subject access");
  $(".toolbar-tabs-container a[href='#tab7XX']").append("<br />Added and linking entry");
  $("#tab7XX h3").append(" - Added and linking entry");
  $(".toolbar-tabs-container a[href='#tab8XX']").append("<br />Series added entry<br />and electronic access");
  $("#tab8XX h3").append(" - Series added entry and electronic access");
  $(".toolbar-tabs-container a[href='#tab9XX']").append("<br />Koha related");
  $("#tab9XX h3").append(" - Koha related");

//Cataloging > Edit -TITLE- > Items
 //BEGIN Hide lost value 2  (Lost (more than 45 days overdue)) and "Materials specified" on edit page
  $("#subfield9521 select option[value='2']").remove();
  $('#subfield9523').hide();
 //BEGIN add focus to search bar after adding an item
  $("#cat_additem input[name=q]:eq(0)").focus();

 //BEGIN prevent deletion of non-local items
  var newsnode=$(".logged-in-branch-name").text().trim().substring(0, 5);
  $('#cataloguing_additem_itemlist td:contains('+ newsnode +')').parent().addClass('local');
  $('#cataloguing_additem_itemlist .delete').hide();
  $('#cataloguing_additem_itemlist .local .delete').show();

//BEGIN reorganize and enchance add/edit item page
 //add classes to additem.pl fields
  $('#cat_additem span:contains("Withdrawn status")').parent().parent().parent().addClass('iawithdrawn emb');
  $('#cat_additem span:contains("Lost status")').parent().parent().parent().addClass('ialost emb');
  $('#cat_additem span:contains("Materials specified")').parent().parent().parent().addClass('iaspecified emb');
  $('#cat_additem span:contains("Damaged status")').parent().parent().parent().addClass('iadamaged emb');
  $('#cat_additem span:contains("Not for loan")').parent().parent().parent().addClass('ianotloan emb');
  $('#cat_additem span:contains("Collection")').parent().parent().parent().addClass('iaccode emb');
  $('#cat_additem span:contains("Home library")').parent().parent().parent().addClass('iahomebranch emb');
  $('#cat_additem span:contains("Current")').parent().parent().parent().addClass('iaholdingbranch emb');
  $('#cat_additem span:contains("Shelving location")').parent().parent().parent().addClass('iashelfloc emb');
  $('#cat_additem span:contains("Date acquired")').parent().parent().parent().addClass('iaaccessiondate emb');
  $('#cat_additem span:contains("Source of acquisition")').parent().parent().parent().addClass('iasource emb');
  $('#cat_additem span:contains("Cost, normal purchase price")').parent().parent().parent().addClass('iapurchase emb');
  $('#cat_additem span:contains("call number")').parent().parent().parent().addClass('iacallnumber emb');
  $('#cat_additem span:contains("Barcode")').parent().parent().parent().addClass('iabcode emb');
  $('#cat_additem span:contains("Copy number")').parent().parent().parent().addClass('iacopy emb');
  $('#cat_additem span:contains("Cost, replacement price")').parent().parent().parent().addClass('iareplacement emb');
  $('#cat_additem span:contains("Non-public note")').parent().parent().parent().addClass('ianonpublic emb');
  $('#cat_additem span:contains("Item type")').parent().parent().parent().addClass('iaitype emb');
  $('#cat_additem span:contains("Public note")').parent().parent().parent().addClass('iapublic emb');
  $('#cat_additem span:contains("Koha date last seen")').parent().parent().parent().addClass('hidden');

 //embiggen the label text
  $('.emb').attr('style','font-size: 125%;');

 //add headings/boxes
  $('#cat_additem span:contains("Non-public note")').parent().parent().parent().before('<fieldset id="statuses" class="rows"><legend style="font-size: 135%">Statuses</legend></fieldset>');
  $('#cat_additem span:contains("Home Library")').parent().parent().parent().before('<fieldset id="clasifications" class="rows"><legend style="font-size: 135%">Library, classification, and barcode</legend></fieldset>');
  $('#cat_additem span:contains("Date acquired")').parent().parent().parent().before('<fieldset id="acquisitionss" class="rows"><legend style="font-size: 135%">Acquisition data</legend></fieldset>');
  $('#cat_additem span:contains("Non-public note")').parent().parent().parent().before('<fieldset id="notess" class="rows"><legend style="font-size: 135%">Notes</legend></fieldset>');

 //reorder the things on the page
  $('#cat_additem .iawithdrawn').insertAfter('#cat_additem #statuses legend');
  $('#cat_additem .ialost').insertAfter('#cat_additem .iawithdrawn');
  $('#cat_additem .iadamaged').insertAfter('#cat_additem .ialost');
  $('#cat_additem .ianotloan').insertAfter('#cat_additem .iadamaged');
  $('#cat_additem .iahomebranch').insertAfter('#cat_additem #clasifications legend');
  $('#cat_additem .iaholdingbranch').insertAfter('#cat_additem .iahomebranch');
  $('#cat_additem .iashelfloc').insertAfter('#cat_additem .iaholdingbranch'); //itemtype
  $('#cat_additem .iaitype').insertAfter('#cat_additem .iashelfloc'); //itemtype
  $('#cat_additem .iaccode').insertAfter('#cat_additem .iaitype'); //ccode
  $('#cat_additem .iacallnumber').insertAfter('#cat_additem .iaccode'); //ccode
  $('#cat_additem .iacopy').insertAfter('#cat_additem .iacallnumber'); //copy
  $('#cat_additem .iabcode').insertAfter('#cat_additem .iacopy'); //copy
  $('#cat_additem .iaaccessiondate').insertAfter('#cat_additem #acquisitionss legend');
  $('#cat_additem .iasource').insertAfter('#cat_additem .iaaccessiondate');
  $('#cat_additem .iapurchase').insertAfter('#cat_additem .iasource');
  $('#cat_additem .iareplacement').insertAfter('#cat_additem .iapurchase');
  $('#cat_additem .ianonpublic').insertAfter('#cat_additem #notess legend');
  $('#cat_additem .iapublic').insertAfter('#cat_additem .ianonpublic');
  $('#cat_additem .iaspecified').insertAfter('#cat_additem .iapublic');
  $('.iashelfloc label, .iaccode label').addClass('required');
  $('.iashelfloc div, .iaccode div').append('<span class="required">Required</span>');

//Cataloging > Z39.50/SRU pop-up
 //BEGIN Resize Z39.50 window
   if (document.location.href.indexOf('z3950_search.pl')>-1) window.moveTo(0, 0), window.resizeTo((screen.width * .9), (screen.height * .9));
  $(window).on('load resize', function(){
   $('#cat_z3950_search .col-xs-6 .rows, #cat_z3950_search #z3950_search_targets').height($(this).height() * .75);
   $('#cat_z3950_search .col-xs-6 .rows').css('overflow-y', 'scroll')
  });

//Circulation > *
 //Affects any pages where you can add a message to the patron's account
 //BEGIN renames "note" to "message" where appropriate
  $("#message_type option[value='L']").html("Staff - Internal message");
  $("#circ_circulation label[for='select_patron_messages']").html("Predefined messages: ");
  $("#select_patron_messages option:contains(Select note)").html("Select message");

 //BEGIN Remove Transfer, Set library, Fast cataloging, and Offline circulation links from left column and circulation sidebar
  $('.circ-button[href="/cgi-bin/koha/circ/selectbranchprinter.pl"]').hide();
  $('.circ-button[href="/cgi-bin/koha/cataloguing/addbiblio.pl?frameworkcode=FA"]').hide();
  $('.circ-button[href="/cgi-bin/koha/circ/checkout-notes.pl"]').hide();
  $('.circ-button[href="/cgi-bin/koha/circ/pendingreserves.pl"]').hide();
  $('#offline-circulation ').hide();
  $('#navmenu #navmenulist h5:contains("Circulation")').parent().addClass('circsidebar');
  $('.circsidebar li:contains("Set library"), .circsidebar li:contains("Fast cataloging"), .circsidebar li:contains("Checkout notes"), .circsidebar li:contains("Holds to pull")').hide();

//Circulation › Check in
 //BEGIN add classes to check in to trigger sounds
  $('#circ_returns .problem:contains("Item was lost, now found.")').parent().parent().addClass('lostreturned');
  $('#circ_returns .approve:contains("Confirm hold and transfer")').parent().parent().addClass('transfer-alert');
  $('#circ_returns .approve:contains("Confirm hold")').parent().parent().addClass('hold-arrived');

 //BEGIN redirect patron data to check-out instead of details
  $("#circ_returns .ci-patron a").each(function() {
   this.href = this.href.replace('members/moremember.pl', 'circ/circulation.pl');
  });

 //BEGIN Add patron name to "Hold found" modal
  if ( $('#hold-found2').length ) {
   $.getJSON("/cgi-bin/koha/svc/report?id=3186%26param_name=borrowernumber&sql_params=" + ($("#hold-found2 input[name=borrowernumber]").val()) + "&annotated=1", function(data) {
    var zname = data[0].BORROWER_NAME;
    $('#hold-found2 li span[class=patron-category]').parent().prepend(zname);
   });
  }

 //BEGIN Add KLE code to hold found modal
  if ( $('#hold-found2').length ) {
   $.getJSON("/cgi-bin/koha/svc/report?id=3194%26param_name=branchcode&sql_params=" + ($("#hold-found2 input[name=diffBranch]").val()) + "&annotated=1", function(data) {
    var reqbrncode = data[0].SHIP_TO;
    $('.modal-body > h4:nth-child(8)').append(reqbrncode);
   });
  }

 //BEGIN add KLE code to non-hold transfer modal
   $(window).load(function(){
    if ( $("#circ_returns [id$=transfer-modal]").length ) {
     $.getJSON("/cgi-bin/koha/svc/report?id=3195%26param_name=branchname&sql_params=" + ($('[id$=transfer-modal] .modal-header h3:nth-child(1)').text().trim().substr(27)) + "&annotated=1", function(data) {
      var ownbname = data[0].SHIP_TO;
      $("[id$=transfer-modal] h3").append(ownbname);
     });
    }
   });

 //BEGIN Add KLE code to rotating collection modal
  if ( $('#rotating-collection').length ) {
   $.getJSON("/cgi-bin/koha/svc/report?id=3195%26param_name=branchname&sql_params=" + ($('#rotating-collection h3').text().trim().substr(25)) + "&annotated=1", function(data) {
    var rotbrncode = data[0].SHIP_TO;
    $('#rotating-collection h3').append(rotbrncode);
   });
  }

 //BEGIN "Patron note" modifications

  //BEGIN adds ID to the patron note message
   $("#circ_returns .dialog.message:contains('Patron note')").attr('id', 'ppnote');

  //BEGIN adds an ID to the last barcode number checked in and its home library (allows us to put these into the note later)
   $("tr:nth-child(1) td:nth-child(4) a").attr('id', 'lastbcin');
   $("tr:nth-child(1) td:nth-child(5)").attr('id', 'lasthome');
   $("tr:nth-child(1) td:nth-child(11)").attr('id', 'lastpatron');

  //BEGIN removes focus from the barcode input
   if ($("#ppnote").length){
    $("#barcode").blur();
   }

  //BEGIN embiggens the title and the note and adds identifiers
   $('#ppnote p:nth-of-type(2n)').wrapInner("<span style='font-size: 110%;'>Title: </span>");
   $('#ppnote p:nth-of-type(3n)').wrapInner("<span style='font-size: 110%; font-weight: bold;'>The patron says: </span>");

  //BEGIN adds the print button and the e-mail button
   $("#ppnote").last("p").append('<br /><input type="button" id="problemprint" style="margin: 20px; padding: 5px;" value="Print this note"><input type="button" id="problemcopy" style="margin: 20px; padding: 5px;" value="Email this note to the home library">');

  //BEGIN adds the barcode number and the home library of the last checked in item to the note between the title and the patron's note
   $(window).load(function(){
    $('#ppnote p:nth-of-type(2n)').after("<p style='font-size: 110%;'>Item BC: <ins>" + $('#lastbcin').html()+ "</ins></p>");
    $('#ppnote p:nth-of-type(3n)').after("<p style='font-size: 110%;'>Home library: <ins>" + $('#lasthome').html()+ "</ins></p>");
   });

  //BEGIN adds function onto the print button
   $("#problemprint").click(function () {
    $("#barcode").focus();
    var divContents = $("#ppnote").html();
    var problemWindow = window.open('', '', 'height=500,width=500');
    problemWindow.document.write('<html><head><style>body {width: 260px; padding: 10px; word-wrap: break-word} input {display: none;}</style><title></title></head><body><div>');
    problemWindow.document.write(divContents);
    problemWindow.document.write('<h1>Patron note</h1></div></body></html>');
    problemWindow.document.close();

    problemWindow.onload=function(){
     problemWindow.focus();
     problemWindow.print();
     problemWindow.close();
    }
   });

  //BEGIN adds function to the send button
   $("#problemcopy").click(function () {
    var el = document.getElementById("ppnote");
    var range = document.createRange();
    range.selectNodeContents(el);
    var sel = window.getSelection();
    sel.removeAllRanges();
    sel.addRange(range);
    document.execCommand('copy');
    window.open("https://news.nexpresslibrary.org/patron-placed-problem-notes/", "_blank");
    $("#barcode").focus();
   });

//Circulation > Checkouts > PATRONNAME
 //BEGIN Adds color to "autoswitched" message
  $('#autoswitched').attr('style','background: yellow');

 //BEGIN Add locked message to multiple patron pages if patron's login attempts is greater than 5 (requires corresponding css)
  if ( $('.patroninfo').length ) {
   $.getJSON("/cgi-bin/koha/svc/report?id=3187%26param_name=borrowernumber&sql_params=" + ($("input[name=borrowernumber]").val()) + "&annotated=1", function(data) {
    var loginblocked = data[0].CLASS;
    $('body').addClass(loginblocked);
     $('.loginblock #toolbar').before('<div id="blockedpatron"><center><br /><br /><br /><h1>This account is locked due to more than five login attempts with an incorrect password.<br /><br />Use the "Change password" button to set a new password for the patron and unlock the account.</h1><br /><p><button id="blockedrep" type="button">Run locked status report for this patron</button></p><br /></center></div>');
     $('.loginblock #toolbar').after('<div id="dontedit" style="display: none;"><center><br /><h3>Using "Edit" to modify a password will not unlock the account.  Use "Change password" to unlock the account.</h3><br /></center></div>');
    $('#changepassword').wrapInner('<span id="cphighlight"></span>');
    $( "#editpatron" ).hover(
     function() {
      $('#dontedit').show();
       }, function() {
      $('#dontedit').hide();
      }
     );
    //opens report 3079 for this patron when button is clicked
     var patronxid=$("input[name=borrowernumber]").val();
      $("#blockedrep").click( function() {
     window.open('/cgi-bin/koha/reports/guided_reports.pl?reports=3163&phase=Run+this+report&sql_params=' + patronxid + '');
    });
   });
  }

 //BEGIN re-tool print and clear icon to do quick slip
  $('#printclearscreen').hide();
  $('#clearscreen').prepend('<span style="position: absolute; right: 43px; top: 0;" id="qprintclearscreen"><a href="#" title="Print qslip and clear screen"><i class="fa fa-print"></i></a></span>');
  $("#circ_circulation #qprintclearscreen").click(function() {
   printx_window("qslip");
   window.location.replace("/cgi-bin/koha/circ/circulation.pl");
   }
  );

 //BEGIN rename print drop-downs
  $('#toolbar #printsummary').html('Full page-summary');
  $('#toolbar #printslip').html('Receipt-all checkouts');
  $('#toolbar #printquickslip').html("Receipt-today's checkouts");

//Checkout Summary and Visual Media limit warning
$('#checkouts').on( 'init.dt', function () {
$('.checkouts-by-itemtype').attr('open', '').addClass('checkout-summary').insertAfter('#circ_circulation #mainform');
$('.checkout-summary summary').text('Checkout summary (by item type)').css({'font-size' : '105%', 'font-weight' : '700'});
$('.checkout-summary').css({'background-color' : '#f4f8f9', 'border' : '2px solid #b9d8d9', 'border-radius' : '5px', 'margin' : '1em 0', 'padding' : '1em'});
$('.checkout-summary strong').contents().unwrap();
$('.checkout-summary ul li').css({'list-style-type' : 'none', 'display' : 'inline-block', 'margin-right' : '1em', 'padding-top' : '2px', 'width' : '45%'});
$('.checkout-summary ul li').html(function(i, v) {
    return v.replace(/(\d){1,2}/g, '<strong>$&</strong>');
});

$('.checkout-summary ul li:contains("MOVIE")').addClass('visualMedia');
$('.checkout-summary ul li:contains("Incoming ILL: Shorter Term")').addClass('visualMedia');

var vmSum = 0
var libcode = $('#logged-in-info-full .logged-in-branch-code').text();
var vmLimit2 = []
var vmLimit3 = []
var vmLimit4 = []
var vmLimit5 = []
var vmLimit6 = ['LEAVENWRTH']
var vmLimit10 = []
var vmLimit20 = []
var vmLimit30 = []
$('.visualMedia strong').each(function(){
    vmSum += parseFloat($(this).text());
});

if ((vmSum >= 2 && $.inArray(libcode, vmLimit2) != -1) || (vmSum >= 3 && $.inArray(libcode, vmLimit3) != -1) ||
    (vmSum >= 4 && $.inArray(libcode, vmLimit4) != -1) || (vmSum >= 5 && $.inArray(libcode, vmLimit5) != -1) ||
    (vmSum >= 6 && $.inArray(libcode, vmLimit6) != -1) || (vmSum >= 10 && $.inArray(libcode, vmLimit10) != -1) ||
    (vmSum >= 20 && $.inArray(libcode, vmLimit20) != -1) || (vmSum >= 30 && $.inArray(libcode, vmLimit30) != -1)){
    $('.checkouts-by-itemtype').before('<div style="background:repeating-linear-gradient(45deg,#f2eeee,#f2eeee 20px, #f2dede 20px, #f2dede 40px);border:2px solid red;border-radius:5px;margin:1em 0;padding:1em;color:#bd0000;text-align:center;font-weight:bold;font-size:larger;">Movie limit reached or exceeded. Total: ' + vmSum + '</div>');
}
});

$('.checkouts-by-itemtype').addClass('checkout-summary');

 //BEGIN blocks checkout to patron with "Expired" flag on their account
  $(".patronattributelabel:contains('Account expiration')").wrap("<span style='background-color: Red;color: white;'></span>");
  $(".patronattributelabel:contains('Account expiration'), #pat_moremember #aai_EXPIRED").closest("body").addClass("expiredpatronx");
  $(".expiredpatronx #addchild, .expiredpatronx #changepassword, .expiredpatronx #duplicate, .expiredpatronx #searchtohold, .expiredpatronx .btn-group, .expiredpatronx a:contains('Renew'), .expiredpatronx #barcode, .expiredpatronx #menu a:contains(Batch check out)").hide();
  $('.expiredpatronx #barcode').parent().prepend("<p style='background: #FFFF00;font-size: 110%;font-weight: bold;'><br />This patron's account has been expired for a very long time and the account is scheduled to be automatically deleted.  The patron cannot check out items until the 'Account expiration' message has been removed.<br /><br />First click the 'EDIT' button and clear the 'Account expiration' message, then update the patron's contact information and click on 'Save.'  Then make sure their account has been renewed before proceeding.<br /> </p>");
  $("#aai_EXPIRED").css("background-color","yellow");

 //BEGIN Changes messages back to HTML
  $('#messages .circ-hlt').each(function() {
   $(this).toHtml();
  });

 //BEGIN Change "Fines" tab on checkout to "Fines and fees" with underline
  $('#doc3 #bd .yui-b #menu ul li a:contains("Fines")').each(function() {
   var text = $(this).text();
   $(this).text(text.replace('Fines', 'Fines and fees'));
   $(this).css("text-decoration", "underline").css("font-weight", "bold");
  });

 //BEGIN Prevents unauthorized use of ILL cards
  //LEAVENWORTH
   $('#circ_circulation, #pat_moremember').each(function(){
    if($(".logged-in-branch-name:not(:contains(Leavenworth))", this).length && $(".patroninfo .patronlibrary:contains(Leavenworth)", this).length && $(".patroninfo .patroncategory:contains(ILL)", this).length){
     $('#barcode').hide();
     $('#menu a:contains(Batch check out)').hide();
     $('#toolbar').hide();
    }
   });

  //OTTAWA
   $('#circ_circulation, #pat_moremember').each(function(){
    if($(".logged-in-branch-name:not(:contains(Ottawa))", this).length && $(".patroninfo .patronlibrary:contains(Ottawa)", this).length && $(".patroninfo .patroncategory:contains(ILL)", this).length){
    $('#barcode').hide();
    $('#menu a:contains(Batch check out)').hide();
    $('#toolbar').hide();
   }
  });

 //BEGIN Prevents unauthorized non-school use of school cards
  //PHSD
   $('#circ_circulation, #pat_moremember').each(function(){
    if($(".logged-in-branch-name:not(:contains(Prairie))", this).length && $(".patroninfo .patronlibrary:contains(Prairie)", this).length){
     $('#barcode').hide();
     $('#menu a:contains(Batch check out)').hide();
     $('#toolbar').hide();
     $('.patronlibrary').css('background','#FFFF00');
     $('#barcode').parent().prepend("<p style='background: #FFFF00;font-size: 110%;font-weight: bold;'>Prairie Hills school district accounts can only be used to check out items at school.<br />If the patron wants to check out items at a public library,<br />they must get a public library card (if they do not already have one).</p>");
    }
   });

 //BEGIN Prevents unauthorized use of 239500
 //(also Circulation > Batch check out > PATRONNAME)
 //(also Patrons > |*| for PATRONNAME)
  $(".patroninfo:contains('239500')").attr('patronblock', 'block');
  if ($(".patroninfo").attr('patronblock')) {
   $(".yui-g #mainform").prepend("<p><strong>This is not a patron account - it is a system account.</p><p>Please contact nexpresshelp@nekls.org for more information.</p>");
   $("#toolbar").hide();
   $("#circ_circulation_issue").hide();
   $("#messages.circmessage").hide();
   $(".action").hide();
   $("#menu").hide();
  };

 //BEGIN re-label "Remember for session:" text
  $("#circ_circulation label[for='stickyduedate']").html("Use this date until the browser is closed:");

 //BEGIN Make due date stand out (accompanying css highlights the whole box)
  $('div.lastchecked > p:nth-child(1)').html(function(index, html) {
   return html.replace('Due on', '<mark style="font-size: 18px;"><strong>Due on');
  });
  $('div.lastchecked > p:nth-child(1)').html(function(index, html) {
   return html.replace('</p>', '</mark></strong></p>');
  });

 //BEGIN disable change hold pickup location on tab in checkout since it doesn't work right
 //(also Patrons > Patron details for PATRONNAME)
  $('#reserves').on( 'init.dt', function () {
   $(".hold_location_select").attr("disabled","disabled");
  });

 //BEGIN Rename Renew or check in button
  $(":button:contains('Renew or check in selected items')" ).text("Renew checked items");

 //BEGIN creates "E-mail receipt button" button
  $("#circ_circulation #toolbar #addnewmessageLabel").after("<div class='btn-group'><button id='digreceipt' type='button' class='btn btn-default btn-sm'>One time e-mail receipt</button></div>");
 //opens report 3076 for this patron
  var patronid=$("#borrowernumber").val();
  $("#digreceipt").click( function() {
   window.open('/cgi-bin/koha/reports/guided_reports.pl?reports=3076&phase=Run+this+report&sql_params=' + patronid + '');
  });

//Circulation › Holds awaiting pickup
 //BEGIN Remove "Cancel hold" and "Cancel hold and return" column and buttons
  $("#holdswaiting #holdst").find("tbody td:last-child,thead th:last-child").hide();
  $("#holdsover #holdso").find("tbody td:last-child, thead th:last-child").hide();

 //BEGIN Remove "Cancell all" button an accompanying text at top of screen
  $("form[name='cancelAllReserve']").hide();
  $("#holdsover").contents().filter(function(){
   return this.nodeType === 3;
  }).wrap("<p style='display: none;'></p>");

//Home
 $('#main_intranet-main #area-pending #checkout_notes_pending').hide();

//Patrons › Manual credit
 //BEGIN Add automatic notes to manual credit
  $("#mancredit > fieldset.action > input[type='submit']").one( "click", function(){
   $("#mancredit #note").val( function( index, val ) {
    return val + " - credit created by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim())
   })
  });

//Patrons › Manual invoice
 //BEGIN Add automatic notes to manual invoice
  $("#maninvoice > fieldset.action > input[type='submit']").one( "click", function(){
   $("#pat_maninvoice #note").val( function( index, val ) {
    return val + " - invoice created by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim())
   })
  });

//Patrons > PATRONNAME > Add patron|Modify patron
 //BEGIN Collapse unused patron entry boxes
  //Adds elements and components to legends on boxes
   $("#entryform legend, #cataloguing_additem_newitem legend").each(function() {
    $(this).append("<span class='instruct' style='display: none;'> (+)</span><span class='instruct'> (-)</span>");
    $(this).wrapInner("<a class='viewSwitch' />");
    $(this).parent().children().not("legend").wrap("<div class='contentsToggle' />");
    $("#memberentry_patron_attributes div:first").removeAttr('class');
   });

  //Pre-hides specified boxes
   if($("#memberentry_identity").is(":visible")) {
    $("#entryform legend:contains('Guarantor information'), #entryform legend:contains('Alternate address'), #entryform legend:contains('Alternate contact'), #entryform legend:contains('Library set-up'), #entryform legend:contains('Patron account flags'), #entryform legend:contains('Patron restrictions'), #entryform legend:contains('Additional attributes and identifiers')").parent().children().not("legend").hide();
   };

  //Shows boxes that already contain data
   $("#aai_EXPIRED").hide();
   if($("#aai_EXPIRED select option:selected").val()!=0){
    $("#aai_EXPIRED").show();
   }

   if($("#contactname").val()!="") {
    $("#entryform legend:contains('Guarantor information')").parent().children().not("legend").show();
   };
   $("#memberentry_address input,#memberentry_altaddress input").each(function() {
    if($(this).val()!="") {
     $(this).parents(".rows").children(".contentsToggle").show();
    };
   });
   if($("#borrowernotes").html()!="") {
    $("#memberentry_subscription").children(".contentsToggle").show();
   };
   $("#entryform legend:contains('Patron account flags')").parents(".rows").find("input").each(function() {
    if($(this).is(':checked') && $(this).val()=="1") {
     $(this).attr('class','thisone');
     $(this).parents(".rows").children(".contentsToggle").show();
    };
   });

  //Update switch labels
   $(".contentsToggle").each(function() {
    if($(this).is(':hidden')) {
     $(this).parent().find(".instruct").toggle();
    };
   });

  //Triggers the click element
   $(".viewSwitch").click(function() {
    $(this).find(".instruct").toggle();
    $(this).parent().parent().children(".contentsToggle").toggle("slow");
   });

  //Patron identity
   //BEGIN rename fields "Surname" to "Last Name," "First Name" to "First/Middle Name," "Other Names" to "Nickname/Other name"
    $("#memberentry_identity label[for='surname']").html("Last name:");
    $("#memberentry_identity label[for='firstname']").html("First name +/<br />middle initial /<br />or middle name:");
    $("#memberentry_identity label[for='othernames']").html("Nickname /<br />other name:");

  //Guarantor information
   //BEGIN rename fields "Surname" to "Last Name," "First Name" to "First/Middle Name"
    $("#memberentry_guarantor label[for='contactname']").html("Last name:");
    $("#memberentry_guarantor label[for='contactfirstname']").html("First name +/<br />middle initial /<br />or middle name:");

  //Main address / Alternate address / Alternate contact
   //BEGIN Rename "Zip/Postal Code" to "Zip code"
    $(".pat label[for='zipcode'], .pat label[for='altcontactzipcode'], .pat label[for='B_zipcode']").html("Zip code:");

   //BEGIN Move "School" attributes into the Main address block
    $("#aai_School").insertBefore($("#memberentry_mainaddress label[for='address']").parent('li'));

   //BEGIN Move "Expired" attributes into the Main address block
    $("li.radio").parent().append("<li id='lastinname'></p>");
    $("#aai_EXPIRED").insertBefore($("#memberentry_identity"));

  //Contact
   //BEGIN create clear e-mail buttons
    $("#pat_memberentrygen #email").parents().eq(1).append("<li><label>Clear e-mail:</label><button id='clearprimeemail' type='button' style='margin: 5px'>Clear primary e-mail</button><button id='clearsecondemail' type='button' style='margin: 5px'>Clear secondary e-mail</button>");
    $("#clearprimeemail").click(function() {
     $("#pat_memberentrygen #email").val("")
    });
    $("#clearsecondemail").click(function() {
     $("#pat_memberentrygen #emailpro").val("")
    });

   //BEGIN Move "Holds contact" attributes to Contact box
    $("#aai_Holdscon").insertBefore($("#memberentry_contact label[for='phone']").parent('li'));

  //Library Management
   //BEGIN Hide Louisburg and Digital from patron dropdown (Library management)
    $("#pat_memberentrygen option[value='branch:LOUISBURG'], #pat_memberentrygen option[value='LOUISBURG']").hide();
    $("#pat_memberentrygen option[value='branch:DIGITAL'], #pat_memberentrygen option[value='DIGITAL']").hide();

   //BEGIN Move "Location" and "Permission" attributes into the Library management box
    $("#aai_Location").insertBefore($("#memberentry_library_management label[for='sort1']").parent('li'));
    $("#aai_Permissions").insertBefore($("#memberentry_library_management label[for='sort1']").parent('li'));
    $("#aai_COLLECT").insertBefore($("#memberentry_library_management label[for='sort1']").parent('li'));
    $("#aai_PREF").insertBefore($("#memberentry_library_management label[for='sort1']").parent('li'));

  //OPAC/Staff login
   //BEGIN Easy fill username options
    $("#pat_memberentrygen #userid").parent().append("<li><label>Easy-fill<br />username<br />options:</label><br /><button id='cardid' type='button' style='margin: 5px'>Use library card number for username</button><button id='nameid' type='button' style='margin: 5px'>Use firstname.lastname for username (Next default)</button><p style='font-size: 125%;color: red;'><br />If a patron has been locked out of their account due to more than 5 failed login attempts, you can only remove the lockout through the <ins>'Change password'</ins> button on the checkout or patron details pages.<br />Assigning a new password here will not clear the lockout.</p>");
    $("#cardid").click( function() {
     $("#entryform #userid").val($("#entryform #cardnumber").val());
    });
    $("#nameid").click( function() {
     $("#entryform #userid").val($("#entryform #firstname").val().toLowerCase().replace(/[^a-zA-Z 0-9]+/g, "").replace(" ","") + '.' +$("#entryform #surname").val().toLowerCase().replace(/[^a-zA-Z 0-9]+/g, "").replace(" ",""));
    });

   //BEGIN Easy fill password buttons
    $("#pat_memberentrygen #password2").parent().append("<button id='deletepass' type='button'>Clear current password data</button>");
    $("#pat_memberentrygen #password2").parent().parent().append("<li><label>Easy-fill<br />password<br />options:</label><button id='lnamepass' type='button' style='margin-right: 5px'>Use last name for password (case sensitive)</button>   <button id='phonepass' type='button'>Use last 4 digits of phone for password</button><br><br>   <button id='townpass' type='button'style='margin-right: 5px'>Use name of town in lowercase letters</button>   <button id='birthpass' type='button'>Use birthdate in format MMDDYYYY (no / marks)</button>");
    $("#phonepass").click( function() {
     $("#entryform #password, #entryform #password2").val($("#entryform #phone").val().slice(-4));
    });
    $("#lnamepass").click( function() {
     $("#entryform #password, #entryform #password2").val($("#entryform #surname").val());
    });
    $("#townpass").click( function() {
     $("#entryform #password, #entryform #password2").val($("#entryform #city").val().toLowerCase());
    });
    $("#birthpass").click( function() {
     $("#entryform #password, #entryform #password2").val($("#entryform #dateofbirth").val().replace(/\//g,''));
    });
    $("#deletepass").click(function() {
     $("#entryform #password, #entryform #password2").val("")
    });

   //Patron messaging preferences
    //BEGIN force "Digests only" if SMS or e-mail is selected
     $("#sms1, #email1, #digest1").change(function () {
      if($("#sms1").is(':checked')) {
       $("#digest1").prop('checked', true);
      }
      else if($("#email1").is(':checked')) {
       $("#digest1").prop('checked', true);
      }
      else {
       $("#digest1").prop('checked', false);
      }
     });
     $("#sms2, #email2, #digest2").change(function () {
      if ($("#sms2").is(':checked')) {
       $("#digest2").prop('checked', true);
      }
       else if ($("#email2").is(':checked')) {
        $("#digest2").prop('checked', true);
      }
       else {
        $("#digest2").prop('checked', false);
      }
     });

   //BEGIN Easy fill messaging preferences
    $("#patron_messaging_prefs_lgd").after("<p id='emailbuttons' style='margin: 5px'><button id='clearemail' type='button' style='margin: 5px'>Clear all</button></p>");
    $("#holdonly").click( function() {
     $("#memberentry_messaging_prefs input").prop('checked', false);
     $("#email4").prop('checked', 'checked');
    });
    $("#5dayemail").click( function() {
     $("#email1, #email2, #digest1, #digest2, #email4").attr("checked","checked");
     $("#memberentry_messaging_prefs table select option[value=5]").attr("selected","selected");
    });
    $("#3dayemail").click( function() {
     $("#email1, #email2, #digest1, #digest2, #email4").attr("checked","checked");
     $("#memberentry_messaging_prefs table select option[value=3]").attr("selected","selected");
    });
    $("#clearemail").click( function() {
     $("#email1, #email2, #digest1, #digest2, #email4, #email5, #email6").prop('checked', false);
     $("#memberentry_messaging_prefs table select option[value=0]").attr("selected","selected");
    });

   //BEGIN SMS changes in the staff client
    //BEGIN Hides SMS number and all SMS checkboxes when page is loaded
     $("#SMSnumber").parent().hide();
     $("#sms1, #sms2, #sms4, #sms5, #sms6").attr("disabled","disabled");

   //BEGIN Show SMS number if provider is not null and clear number and all SMS checkboxes if the provider is changed to null
    $(".pat").on("mousemove change click keyup", function(){
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
    $("#pat_memberentrygen").on("mousemove change click keyup", function(){
     if($("#SMSnumber").val().length == 10){
      $("#sms1, #sms2, #sms4, #sms5, #sms6").removeAttr("disabled");
      $("#smsbuttons").fadeIn("slow");
      } else {
      $("#sms1, #sms2, #sms4, #sms5, #sms6").attr("disabled", "disabled");
      $("#sms1, #sms2, #sms4, #sms5, #sms6").prop("checked", false);
      $("#smsbuttons").fadeOut("slow");
     }
    });

// possible switch  - $('th:contains("Days in advance")').parent().wrap('<div id="messagetable"></div>');
    $('th:contains("Days in advance")').parents().eq(3).wrap('<div id="messagetable"></div>');
    $("#memberentry_messaging_prefs label:contains('SMS number:')").parent().wrap('<div id="smsnumbermove"></div>');
    $("#memberentry_messaging_prefs label:contains('SMS provider:')").parent().wrap('<div id="smsprovidermove"></div>');
    $("#smsnumbermove").prependTo("#messagetable").parent();
    $("#smsprovidermove").prependTo("#messagetable").parent();

   //BEGIN Rename SMS "Text messaging" for the sake of staff who don't know what SMS stands for
    $('#memberentry_messaging_prefs label, #messagetable th').each(function() {
     var text = $(this).text();
     $(this).text(text.replace('SMS', 'Text message'));
    });

   //BEGIN add links to carrier lookup sites
    $("#smsnumbermove").append("<div><p style='font-weight: bold; text-decoration: underline; color: red;'><br />'Advanced Notices' and 'Item Due' notices (e-mail and text) are sent between 2:00 and 2:30 a.m.<br />Patrons should set the 'Do Not Disturb' settings on their phone appropriately if they do not want their phones to alert them to these notices at that time of day.<br />Instructions for setting the do-not-disturb feature on most phones can be found at<br /><a href='https://www.imore.com/how-to-setup-use-do-not-disturb-iphone-ipad' target='_blank'>Set do-not-disturb for iPhone</a> | <a href='https://www.howtogeek.com/260225/androids-confusing-do-not-disturb-settings-explained/' target='_blank'>Set do-not-disturb for Android phones</a><br /><br />Charges for text messages may be incurred when using this service.<br/>Please have the patron check with their mobile service provider if they have questions about fees for text messages.</p><p style='font-weight: bold; text-decoration: underline;'><br /><a href='https://freecarrierlookup.com/' target='_blank'>Free Carrier Lookup - Click here to lookup a mobile phone provider (limited to 30 searches per month)</a><br /><a href='https://www.carrierlookup.com/' target='_blank'>Carrier Lookup - Click here to lookup a mobile phone provider</a><br /><a href='https://realphonevalidation.com/resources/phone-carrier-lookup/' target='_blank'>Phone Carrier Lookup - Click here to lookup a mobile phone provider</a><br /><a href='https://www.fonefinder.net/' target='_blank'>Fone finder - Click here to lookup a mobile phone provider</a><br /></p></div>").parent();

   //BEGIN
    $("#sms_provider_id option:contains('Unknown')").text(' Unknown');
    $("#sms_provider_id").one( "click", function() {
     alert("Charges for text messages may be incurred when using this service.  Please have the patron check with their mobile service provider if they have questions about fees for text messages.  Also note that 'Advanced Notices' and 'Item Due' notices are sent at 2:15 a.m.  The patron should set the 'Do Not Disturb' settings on their phone appropriately if they do not want their phones to alert them to these notices at 2:15 a.m.");
     var selexted = $('#sms_provider_id option:selected').val();
     $("#sms_provider_id").html($('#sms_provider_id option').sort(function(x, y) {
      return $(x).text().toUpperCase() < $(y).text().toUpperCase() ? -1 : 1;
     }));
     $("#sms_provider_id").val(selexted);
    });

    $("#emailbuttons").append("<p id='smsbuttons' style='display: none;'> <button id='holdonlysms' type='button' style='margin: 5px'>Hold texts only</button>     <button id='5daysms' type='button' style='margin: 5px'>5 Day advance texts + Item due</button>     <button id='3daysms' type='button' style='margin: 5px'>3 Day advance texts + Item due</button>     <button id='clearsms' type='button' style='margin: 5px'>Clear all</button></p>");

    $("#holdonlysms").click( function() {
     $("#sms1, #sms2").prop('checked', false);
     $("#sms4").prop('checked', 'checked');
    });

    $("#5daysms").click( function() {
     $("#sms1, #sms2, #sms4, #digest1, #digest2").attr("checked","checked");
     $("#memberentry_messaging_prefs table select option[value=5]").attr("selected","selected");
    });
    $("#3daysms").click( function() {
     $("#sms1, #sms2, #sms4, #digest1, #digest2").attr("checked","checked");
     $("#memberentry_messaging_prefs table select option[value=3]").attr("selected","selected");
    });
    $("#clearsms, #clearemail").click( function() {
     $("#sms1, #email1, #sms2, #email2, #sms4, #email4, #sms5, #email5, #sms6, #email6, #digest1, #digest2").prop('checked', false);
     $("#memberentry_messaging_prefs table select option[value=0]").attr("selected","selected");
    });

  //BEGIN adds registration library to field in additional attributes and identifiers
   if (window.location.href.indexOf("cgi-bin/koha/members/memberentry.pl?op=add") > -1 ) {
    $("li label:contains('Registration')").parent().attr("class","reglibrary");
    $(".reglibrary textarea").attr("value",$(".logged-in-branch-name").html());
    $(".reglibrary a, .reglibrary textarea").hide();
   }

   if ((window.location.href.indexOf("cgi-bin/koha/members/memberentry.pl?op=modify") > -1 )|| (window.location.href.indexOf("cgi-bin/koha/members/memberentry.pl?op=duplicate") > -1 ) ) {
    $("li label:contains('Registration')").parent().attr("class","reglibrary");
    $(".reglibrary textarea").attr('readonly', true);
    $(".reglibrary a").hide();
   }

//Patrons › PATRONNAME › Modify patron - Patron messaging preferences
  $('#messagetable td:contains("Item check-in")').each(function() {
   var text = $(this).text();
   $(this).text(text.replace('Item check-in', 'Email check-in receipt'));
  });
  $('#messagetable td:contains("Item checkout")').each(function() {
   var text = $(this).text();
   $(this).text(text.replace('Item checkout', 'Email check-out/renewal receipt'));
  });

//Patrons › Pay fines for PATRONNAME
 //BEGIN Add automatic notes to payments and writeoffs
  //Pay individual button
   $("[name^=pay_indiv]").one( "click", function(){
    $("#finest [name^=payment_note]").val( function( index, val ) {
     return val + " - Paid/processed by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim())+ " (pi)"
    })
   });
  //Write off individual
   $("[name^=wo_indiv]").one( "click", function(){
    $("#finest [name^=payment_note]").val( function( index, val ) {
     return val + " - Written off/forgiven by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim())+ " (wi)"
    })
   });
  //Write off all
   $("#woall").one( "click", function(){
    $("#finest [name^=payment_note]").val( function( index, val ) {
     return val + " - Written off/forgiven by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim())+ " (wa)"
    })
   });
  //Pay selected/pay all
   $('#payfine :input[value="payment"]').parent().addClass('paynote');
   $(".paynote .action > input:nth-child(1)").one( "click", function(){
    $("#selected_accts_notes").val( function( index, val ) {
     return val + " - Paid/processed by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim())+ " (ps/pa)"
    })
   });
  //Write off selected
   $('#payfine :input[value="writeoff"]').parent().addClass('writeoffnote');
   $(".writeoffnote .action > input:nth-child(1)").one( "click", function(){
    $("#selected_accts_notes").val( function( index, val ) {
     return val + " - Written off/forgiven by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim())+ " (ws)"
    })
   });

//Patrons › Set permissions for -PATRONNAME-
 //BEGIN Highlight selected permissions
  $("#pat_member-flags input:checked").parent().css("background-color", "yellow");

 //BEGIN buttons to set staff permissions
  $('#pat_member-flags #permissionstree').before('<button id="exptree" type="button" style="font-size:14px">Expand all</button>&nbsp;&nbsp;&nbsp;<button id="cleartree" type="button" style="font-size:14px">Clear all</button>  <button id="setdirector" type="button" style="font-size:14px">Set director</button>  <button id="settech" type="button" style="font-size:14px">Set tech</button>  <button id="setcirc" type="button" style="font-size:14px">Set circ</button>  <button id="setassist" type="button" style="font-size:14px">Set assistant</button>  <button id="setsco" type="button" style="font-size:14px">Set SCO</button>');

  $("#exptree").click(function() {
    $('#pat_member-flags [id$="-children"]').attr('style','display: block;');
  });

  $( "#cleartree" ).click(function() {
   $('#pat_member-flags input.flag').removeAttr('checked').siblings().css("background-color", "");
   $("#pat_member-flags input").parent().css("background-color", "");
   $('#pat_member-flags [id$="-children"]').attr('style','display: none;');
  });

  $( "#setdirector" ).click(function() {
   $('#pat_member-flags [id$="-children"]').attr('style','display: block;');
   $('#pat_member-flags input.flag').removeAttr('checked').removeAttr('disabled');
   $('#pat_member-flags').find('#flag-1, #flag-2, #flag-4, #reserveforothers_place_holds, #editcatalogue_edit_catalogue, #editcatalogue_edit_items, #editcatalogue_fast_cataloging, #flag-10, #acquisition_order_manage, #tools_edit_calendar, #tools_edit_news, #tools_edit_notice_status_triggers, #tools_edit_notices, #tools_items_batchdel, #tools_items_batchmod, #tools_label_creator, #tools_manage_patron_lists, #tools_manage_staged_marc, #tools_moderate_comments, #tools_moderate_tags, #tools_stage_marc_import, #tools_upload_general_files, #tools_upload_local_cover_images, #flag-16, #clubs_edit_clubs, #clubs_enroll').each(function() {
    $(this).attr('checked','checked')
    $(this).siblings().css("background-color", "yellow");
   });
  });

  $( "#settech" ).click(function() {
   $('[id$="-1-children"], [id$="-2-children"], [id$="-4-children"], [id$="-6-children"], [id$="-9-children"], [id$="-10-children"], [id$="-11-children"], [id$="-13-children"], [id$="-16-children"], [id$="-21-children"]').attr('style','display: block;');
   $('#pat_member-flags input.flag').removeAttr('checked').removeAttr('disabled');
   $('#pat_member-flags').find('#flag-1, #flag-2, #flag-4, #reserveforothers_place_holds, #editcatalogue_edit_catalogue, #editcatalogue_edit_items, #editcatalogue_fast_cataloging, #flag-10, #acquisition_order_manage, #tools_export_catalog, #tools_inventory, #tools_items_batchdel, #tools_items_batchmod, #tools_label_creator, #tools_manage_patron_lists, #tools_manage_staged_marc, #tools_moderate_comments, #tools_moderate_tags, #tools_rotating_collections, #tools_stage_marc_import, #tools_upload_general_files, #tools_upload_local_cover_images, #reports_create_reports, #reports_execute_reports, #clubs_enroll').each(function() {
    $(this).attr('checked','checked')
    $(this).siblings().css("background-color", "yellow");
   });
  });

  $( "#setcirc" ).click(function() {
   $('[id$="-1-children"], [id$="-2-children"], [id$="-4-children"], [id$="-6-children"], [id$="-10-children"], [id$="-13-children"], [id$="-16-children"], [id$="-21-children"]').attr('style','display: block;');
   $('#pat_member-flags input.flag').removeAttr('checked').removeAttr('disabled');
   $('#pat_member-flags').find('#flag-1, #flag-2, #flag-4, #reserveforothers_place_holds, #flag-10, #tools_inventory, #tools_moderate_comments, #tools_moderate_tags, #reports_execute_reports, #clubs_enroll').each(function() {
    $(this).attr('checked','checked')
    $(this).siblings().css("background-color", "yellow");
   });
  });

  $( "#setassist" ).click(function() {
   $('[id$="-1-children"], [id$="-2-children"], [id$="-4-children"], [id$="-6-children"]').attr('style','display: block;');
   $('#permissionstree input.flag').removeAttr('checked');
   $('#pat_member-flags').find('#circulate_circulate_remaining_permissions, #flag-2, #borrowers_view_borrower_infos_from_any_libraries, #reserveforothers_place_holds').each(function() {
    $(this).attr('checked','checked')
    $(this).siblings().css("background-color", "yellow");
   });
  });

  $( "#setsco" ).click(function() {
   $('[id$="-23-children"]').attr('style','display: block;');
   $('#pat_member-flags input.flag').removeAttr('checked').removeAttr('disabled');
   $('#pat_member-flags').find('#flag-23').each(function() {
    $(this).attr('checked','checked')
    $(this).siblings().css("background-color", "yellow");
   });
  });

//Patrons › Update patron records
 //BEGIN Hide patron update notices from other branches (based on first 4 letters of the branch name)
  $(window).load(function(){
   var loglibnode=$(".logged-in-branch-name").text().trim().substring(0, 3);
   $('#pending_updates h3 a:not(:contains("('+loglibnode+'"))').parent().hide();
   $('#pending_updates a:not(:contains("('+loglibnode+'"))').parent().next('.ui-accordion-content').hide();
  });

//Reports › Guided reports wizard
 //BEGIN Auto-fill some reports data
  //Date to today
   $("#rep_guided_reports_start fieldset input.datepicker").val($('#todaysdate').text().trim());
  //Date range start (date1)
   $("#rep_guided_reports_start li label:contains('date1')").next().val('01/01/2000');
  //prefill a wildcard
   $("label:contains('or a % symbol')").next().val("%");

//Reports › Guided reports wizard › Saved reports
 //BEGIN adds "ADMINREPORT" class to some reports
  $('#table_reports td:contains("ADMINREPORT")').parent().addClass('adminreport');

 //BEGIN Hides "Delete selected" button on the bottom of the saved reports table
  $("#reports_form > fieldset > input[type='submit']").hide();

 //BEGIN Hides "Duplicate" and "Schedule" option on action button
  $("#table_reports a:contains('Duplicate')").hide();
  $("#table_reports a:contains('Schedule')").hide();

//Reports › Guided reports wizard › Saved reports › -REPORTNAME- Report
 //BEGIN Hides SQL output, adds toggle button for SQL and for report info
  $("#rep_guided_reports_start .label:contains('Notes:')").parent().wrap("<div id='reportnotes'></div>");
  $("#rep_guided_reports_start #limitselect").prepend("<p><button id='toginfor'> Toggle report info </button></p>");
  $("#toginfor").click(function(event) {
   event.preventDefault();
   $("#reportinfo").toggle("slow");
  });
 //BEGIN renders notes on reports in HTML
  $('#table_reports tr td:nth-child(7), #reportnotes').each(function() {
   $(this).toHtml();
  });

//Tools > Automatic item modifications by age
 //BEGIN add Up/Down controls to re-order modification rules
  $("#tools_automatic_item_modification_by_age #rules fieldset legend").each(function(){
    $(this).prepend('<a class="moveup" href="#">- Up - </a>');
  });
  $(".moveup").click(function(){
    $(this).closest("fieldset").insertBefore( $(this).closest("fieldset").prev() );
  });

//Tools > Calendar
 //Disable ability to copy holidays to all calendars
  $('#tools_holidays #allBranches').attr('disabled','disabled');
  $('#tools_holidays #allBranches').parent().hide();

 //Libraries can only modify their own calendars
  var calnode=$(".logged-in-branch-name").text().trim().substring(0, 5);
  $('#tools_holidays #branch option:not(:contains('+ calnode +'))').hide();
  $('#tools_holidays #branchcode option:not(:contains('+ calnode +'))').hide();

 //BEGIN add description with name and date to holidays
  $(".cancel.hidePanel.newHoliday").prev().one( "click", function(){
   $("#newDescription").val( function( index, val ) {
    return val + " - holiday added by "+ ($(".loggedinusername").html().trim())+ " at "+ ($(".logged-in-branch-code").html().trim()+ " - "+ ($("#todaysdate").html().trim()))
   })
  });

//Tools › Inventory
 //BEGIN Set location filter to home library by default
  $("#tools_inventory #inventory_form input[value='homebranch']").attr("checked","checked");

 //BEGIN set default home library to logged in library
  var invnode=$(".logged-in-branch-name").text().trim().substring(0, 5);
  $('#tools_inventory #branchloop option:contains('+ invnode +')').attr("selected","selected");

//Tools > News
 //Libraries can only modify their own news
/*
  $("#tools_koha-news #lang > option:contains('All'), #tools_koha-news #lang option[value='en'], #tools_koha-news #lang option[value='es-ES'], #tools_koha-news  #branch option:contains('All libraries')").attr("disabled","disabled");

  $("#tools_koha-news #lang > option:contains('All'), #tools_koha-news #branch > option:nth-child(1)").removeAttr("selected");
  $("#tools_koha-news #lang > option:nth-child(2)").attr('selected','selected');
  var newsnode=$(".logged-in-branch-name").text().trim().substring(0, 5);
  $('#tools_koha-news #branch option:not(:contains('+ newsnode +'))').hide();
  $('#tools_koha-news #branch option:not(:contains('+ newsnode +'))').attr("disabled","disabled");
  $('#tools_koha-news #branch option:contains('+ newsnode +')').attr("selected","selected");
  $("#tools_koha-news #number").val("25");

*/

//Tools › Notices & slips
 //BEGIN highlights notice row on hover
  $("#tools_letter #lettert tr").hover(
   function() {
    $( this ).addClass( "highlighted-row" );
   }, function() {
    $( this ).removeClass( "highlighted-row" );
  });

 //BEGIN add focus to the name field when editing a notice
  $("#tools_letter #add_notice li #name").focus();

//Tools > Overdue notice/status triggers
 //BEGIN highlights non-billed patrons
  if (window.location.href.indexOf("tools/overduerules.pl") > -1 ) {
   $("tr:nth-child(5), tr:nth-child(22), tr:nth-child(38), tr:nth-child(40), tr:nth-child(41)").css( "color", "red" )
   $("tr:nth-child(21)").css("color","blue");
  }

//Tools › Stage MARC records for import
 //BEGIN Add processing tips
  $("#processfile li:contains('Record matching rule')").append("<strong><em>Change to ISBN 020$a</em></strong>");
  $("#processfile li:contains('Action if matching record found')").append("<strong><em> Change to Ignore Incoming</em></strong>");
  $("#processfile li:contains('Action if no match is found')").append("<strong><em> Change to Add Incoming</em></strong>");
  $("#processfile li:contains('How to process items')").append("<strong><em>Change to Add Items only if matching bib was found</em></strong>");

//BEGIN SCHOOL
  /*
  //BEGIN redirect school holds to nearest public library during the summer
    $("#pickup option[value='PHAXTELL']").attr("value","SENECA").html('Prairie Hills - Axtell: Closed to requests till fall');
    $("#pickup option[value='PHSES']").attr("value","SABETHA").html('Prairie Hills - Sabetha Elementary: Closed to requests till fall');
    $("#pickup option[value='PHSHS']").attr("value","SABETHA").html('Prairie Hills - Sabetha High: Closed to requests till fall');
    $("#pickup option[value='PHSMS']").attr("value","SABETHA").html('Prairie Hills - Sabetha Middle: Closed to requests till fall');
    $("#pickup option[value='PHWAC']").attr("value","WETMORE").html('Prairie Hills - Wetmore: Closed to requests till fall');
  */

//BEGIN Add features for superusers
  $(".loggedinusername:contains('admin')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('nekls')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('mmcdonald')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('robin.hastings')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('SEKLSLOGIN')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('bywater')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('dan.alexander')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('gwilliams')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('kylemhall')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('ghwtest')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('greg.gantz')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('bwssupport')").attr('neklssuperduperuser','yes');
  $(".loggedinusername:contains('NEXTBRAND')").attr('neklssuperduperuser','yes');
  if($(".loggedinusername").attr('neklssuperduperuser')) {

    //Allow merge patrons
  $('#merge-patrons').show();

//Allow superusers to access catalogging editor
  //$("#switcheditor").show();

//Show "Super Librarian" on gradient to identify super users
  $(".gradient").prepend("<li>NExpress Super Librarian!</li>");

//Allow superusers to back-date requests
  $('#hold-request-form #from').removeClass('datepickerfrom').addClass('datepicker');

//Allow superusers access to restricted catalogging tools
  $('#batchedit').show();
  $('#batchdelete').show();
  $('#deleteallitems').show();
  $('#batchedit-disabled').show();
  $('#batchdelete-disabled').show();
  $('#deleteallitems-disabled').show();
  $("#cat_addbooks li:contains('Z Framework')").show();
  $("#cat_addbooks li:contains('DVD framework')").show();
  $("#cat_addbooks li:contains('Online resource')").show();

//Add button to show all pending patron updates
  $('#pat_update h2:contains(Update patron records)').parent().prepend("<button id='pudshow' type='button'>Show all pending updates</button>");
  $("#pudshow").click( function() {
    $("#pudshow").hide();
    $('#pending_updates h3 a:not(:contains("('+loglibnode+'"))').parent().show();
    $('#pending_updates .ui-accordion-content:first').show();
  });

//Tools > News
//BEGIN Enable News features for superlibrarians
  $("#tools_koha-news fieldset.rows > ol").prepend("<button id='newsshow' type='button' style='margin: 10px;'>Release limits</button>");
  $("#newsshow").click( function() {
    $("#newsshow").fadeOut();
    $('#tools_koha-news option').show();
    $('#tools_koha-news option').removeAttr("disabled");
    $("#tools_koha-news .yui-t7 #branch option:contains('All libraries')").attr("selected", "selected");
  });

//Tools > LIBRARY NAME Calendar
  $("#tools_holidays #branch").after("<button id='calshow' type='button' style='margin: 10px;'>Choose any branch</button>");
  $("#calshow").click( function() {
    $("#calshow").fadeOut();
    $('#tools_holidays option').show();
  });

//BEGIN Show "Duplicate" and "Schedule" option on action button
  $("#table_reports a:contains('Duplicate')").show();
  $("#table_reports a:contains('Schedule')").show();

//GHW - movie type select
  $('#searchterms').after("<button id='movselectx' type='button'  style='margin: 5px'>Select all video types</button>");
  $("#movselectx").click( function() {
    $("#catalog_advsearch [value*='NVID']").attr("checked","checked");
  });

//GHW - load all reports in descending order
  $('#table_reports').on("init.dt", function () {
    var table = $('#table_reports').DataTable();
    table.page.len(-1);
    table.order([1, "desc"]);
    table.draw();
  });

//Reports > Guided reports wizard > Saved reports
  $('#rep_guided_reports_start #tabs').before("<button id='showallreports' type='button' class='btn btn-default btn-sm' style='margin: 5px'>Show hidden reports</button>");
  $("#showallreports").click( function() {
    $(".adminreport").show();
    $('#showallreports').hide();
  });

//BEGIN Onetime

$('#subfield9523').show();

/*$('#dateofbirth').val('01/01/1999');

var cardnum = $('#cardnumber').val();
$('#surname').click(function() {
$('#cardnumber').val('000' + cardnum + '');
});
*/

//$('#circ_circulation #suspend_until').val('10/16/2019');

/*
$('#holds_patronsearch #patron').val('1003008055971');
$('#holdnotes').val('Please route LINWOOD items to NEKLS during the current health emergency');
$('#hold-request-form').parent().mousemove( function() {$('#hold-request-form #to').val('03/25/2020')});
$('#hold-request-form').parent().mousemove( function() {$('input[value="Place hold"]').click();}).delay('1000');
$('#requestspecific td:nth-child(4):contains("Linwood")').parent().attr('id','irow');
$('#irow input[type="radio"]').attr('checked', 'checked');
$('#circ_request #circ_holds_selectborrower').mousemove( function() {$('input[value="Search"]').click();});
*/


//END Onetime

};

//BEGIN remove newmedia from add item page (only needed temporarily)
 $('[id^="tag_952_subfield_y"] option[value="NEWMEDIA"]').remove();

$('#catalog_detail #batchedit').attr('disabled', 'disabled');

//BEGIN push local library to top of virtual holds queue and collapse remote queues
 var holdsnode=$(".logged-in-branch-name").text().trim().substring(0, 5);
 $('#circ_request form fieldset fieldset legend:contains('+ holdsnode +')').parent().addClass('localqueue');
 $('#circ_request form fieldset fieldset legend:not(:contains('+ holdsnode +'))').parent().addClass('remotequeue');
 $('.localqueue').insertBefore('#circ_request form .rows > fieldset:nth-child(2)');
 $(".remotequeue legend").each(function() {
  $(this).append("<span class='rcloser' style='display: none;'> (+)</span><span class='rcloser'> (-)</span>");
  $(this).wrapInner("<a class='viewRSwitch' />");
  $(this).parent().children().not("legend").wrap("<div class='contentsRToggle' />");
  $("#memberentry_patron_attributes div:first").removeAttr('class');
  $('.contentsRToggle').hide();
 });

 //Triggers the click element
  $(".viewRSwitch").click(function() {
   $(this).find(".rcloser").toggle();
   $(this).parent().parent().children(".contentsRToggle").toggle("slow");
  });

  //BEGIN Create button to hide left hand navigation
 $(".remotequeue").last().after("<fieldset><button id='remshowall' type='button' style='margin: 5px; display: block;'>Show all other queuess</button><button id='remhideall' type='button' style='margin: 5px; display: none;'>Hide all other queuess</button></fieldset>");
 $("#remshowall").click( function() {
  $('.contentsRToggle').show("slow");
  $('#remshowall').hide();
  $('#remhideall').show();
 });
 $("#remhideall").click( function() {
  $('.contentsRToggle').hide("slow");
  $('#remhideall').hide();
  $('#remshowall').show();
 });

$('.NEKLS #remshowall').each(function(){
 $(this).click();
});

//Circulation > Check-in
 //Display a pop-up if an item has a damage status set (requires corresponding report)
  if ( $('#checkin-form').length ) {
   $.getJSON("/cgi-bin/koha/svc/report?id=3250%26param_name=Enter+item+barcode+number&sql_params=" + ($('.yui-u fieldset input[name="ri-0"]').val()) + "&annotated=1", function(data) {
    var damaged1 = data[0].DISPLAY;
    var message1 = data[0].MESSAGE;
    $('#circ_returns .yui-b .yui-g #exemptfines').before('<div id="damageditemcheckin" class="dialog alert audio-alert-warning" style="display: ' + damaged1 + '"><h2>Damaged item message</h2>' + message1 + '<p>DAMAGED statuses must be removed manually - they are not removed by the checkin process.</p></div>');
   });
  }
/*
 //Block non-loacl item level requests
  var reqlibnode=$("span.logged-in-branch-name:nth-child(1)").text().trim().substring(0, 5);
  $('#hold-request-form #requestspecific tr').addClass('remoteitem');
  $('#hold-request-form #requestspecific td:contains('+ reqlibnode +')').parent().removeClass('remoteitem');
  $('#hold-request-form #requestspecific td:nth-child(4):contains('+ reqlibnode +')').parent().addClass('localitem');
  $('.localitem').insertBefore('#hold-request-form #requestspecific tbody');
  $('.localitem td:contains('+ reqlibnode +')').siblings().attr('style','background-color: #ffe6f2;');
  //$('.remoteitem input').attr('disabled','disabled');
  $('.remoteitem input').click( function() {
   alert('Item level requests can only be placed on items owned by your library.');
   $('#requestany').attr('checked','checked');
   $('input[name="checkitem"]').attr('checked', false);
  });
*/
$("#patron_list_id").one( "click", function() {
 var selisted = $('#patron_list_id:selected').val();
 $("#patron_list_id").html($('#patron_list_id option').sort(function(x, y) {
  return $(x).text().toUpperCase() < $(y).text().toUpperCase() ? -1 : 1;
 }));
 $("#patron_list_id").val(selisted);
});

$(function() {
  // choose target dropdown
  var select = $('.attributes > label:nth-child(1) > select:nth-child(1)');
  select.html(select.find('option').sort(function(x, y) {
    // to change to descending order switch "<" for ">"
    return $(x).text() > $(y).text() ? 1 : -1;
  }));
  // select default item after sorting (first item)
  $('.attributes > label:nth-child(1) > select:nth-child(1) > option:nth-child(1)').attr('selected', true);
});

$(".writeoffnote label[for='paid']").html("Amount written<br />off :");
$(".writeoffnote #collected, .writeoffnote #change, .writeoffnote #payment_type").parent().remove();
$(".writeoffnote #changecalc").remove();
/*
$('.LEAVENWRTH label:contains("Kanopy (LEAVENWRTH):")').parent().addClass('leavenwrthkanopy');

$('.leavenwrthkanopy select option[value=LEAVENWRTH]').attr("selected","selected");

$('.LEAVENWRTH #libraries').change(function () {
 $('.leavenwrthkanopy select option[value="0"]').attr("selected","selected");
});

$('.LEAVENWRTH #libraries option[value=LEAVENWRTH]').click(function () {
 $('.leavenwrthkanopy select option[value=LEAVENWRTH]').attr("selected","selected");
});
*/
$("#rep_guided_reports_start #notes").attr('class','sqlnotes')
 $('.sqlnotes').on('click keyup', function(){
  $('.sqlnotes').css('height','auto');
  $('.sqlnotes').height(this.scrollHeight);
  $('.sqlnotes').css('overflow-y', 'hidden;');
});

/*
$('dd:contains("hoopla")').parent().parent().parent().addClass('hooplarow');
$('.hooplarow .import_record').hide();
$('.hooplarow .dropdown').append('<br /><br />Records for electronic<br />resources cannot be imported');
*/

$('#rep_guided_reports_start .col-sm-2.col-sm-pull-10, #rep_guided_reports_start .navbar, #rep_guided_reports_start .gradient, #rep_guided_reports_start #breadcrumbs, #rep_guided_reports_start .gradient, #rep_guided_reports_start #newlogo, .gradient li').addClass('noprint');

  $('.problem:contains("refund has been")').each(function() {
    var text = $(this).text();
   $(this).text(text.replace("has been applied to the borrowing", "may have been applied to the last"));
  });

  var urx = $(location).attr('href');
  if(urx.indexOf("memberentry.pl?op=add&guarantorid") != -1){
   $('#email1, #email2, #email4, #email6, #digest1, #digest2').attr('checked', 'checked');
   $('select[name$="2-DAYS"] option[value="3"]').attr('selected', 'selected');
  }

 //Causes 856 links to open in new window
  $("#catalogue_detail_biblio .results_summary.online_resources a").attr('target','_blank');

  $('#pat #state').on('keydown', function(e) {
    var charCode = e.key.charCodeAt(0);
    if (!((charCode >= 0x30 && charCode <= 0x39) || (charCode >= 0x41 && charCode <= 0x7a))) {
        e.preventDefault();
    }
});

$('#pat_memberentrygen #state, #pat_memberentrygen #cardnumber').on('keyup', function(e) {
    $(this).val($(this).val().toUpperCase());
});

/*$('#pat_memberentrygen #address').on('keyup', function(e) {
$(this).val(function(i,val) {
    var r = ['Rd','St','Ave'];
    var f = ['Road','Street','Avenue'];
    var valArray = val.split(' ');
    $.each(valArray, function(i,v){
       var inF = $.inArray(v, f);
       if(inF !== -1){
         valArray[i] = v.replace(f[inF], r[inF]);
       }
    });
    return valArray.join(' ');
});
});*/

$('#pat_memberentrygen #saverecord').hover(function() {
  $("input, textarea").val((i, v) => v.replace(/\s{2,}/g, ' '));
  $('[id^="add"], [id^="B_add"], [id^="B_add"]').val((i, v) => v.replace(/[.,\+\!$%\^&\*;:{}=_`~@<>]/g,''));
});

$("#pat_memberentrygen #state").parent().append("<span class='required longstate' style='display: none; font-weight: bold;'>State names should be abbreviated following USPS guidelines at <a href='https://pe.usps.com/text/pub28/28apb.htm' target='_blank'>this link</a></span>")
$("#pat_memberentrygen #state").keyup(function() {
    if($(this).val().length > 2) {
         $('.longstate').show();
         $('#state').addClass('alert');
    } else if($(this).val().length < 3) {
         $('.longstate').hide();
         $('#state').removeClass('alert');
    }
});


  $("#pat_memberentrygen #phone").after("<span class='required shortphone' style='display: none; font-weight: bold;'>Phone numbers should start with a phone number in the format 999-999-9999 or start with 'No phone' or 'Disconnected'</span>")
  $("#pat_memberentrygen #phone").keyup(function() {
   var phone = $("#pat_memberentrygen #phone").val();
   var phoneReg = /^([2-9][0-9]{2}-[0-9]{3}-[0-9]{4}|No phone|No phone|Disconnected|^$)+.*$/;
   if (!phoneReg.test(phone)) {
    $('.shortphone').show();
    $('#phone').addClass('alert');
   }
   else if (phoneReg.test(phone)) {
    $('.shortphone').hide();
    $('#phone').removeClass('alert');
   }
  });

$('#rep_guided_reports_start .col-sm-10 main h1').first().append(" - (Report #" + $('#limitselect input[name="reports"]').val() + ")")

$('#pickup option:contains("closed1")').bind('click keydown', function() {
  $('#hold-request-form #from').val('2020-04-01').parent().hide()
});

$('#pickup option:contains("closed2")').bind('click keydown', function() {
  $('#hold-request-form #from').val('2020-03-24').parent().hide()
});

$('#pickup option:contains("closed3")').bind('click keydown', function() {
  $('#hold-request-form #from').val('2020-04-06').parent().hide()
});

$('#pickup option:not(:contains("closed"))').bind('click keydown', function() {
 $('#hold-request-form #from').val('').parent().show()
});

$('#transport-cost-matrix').click(function () {
$('#transport-cost-matrix .enable_cost_input').click()
});

$('#transport-cost-matrix tr').click(function () {
  $('#transport-cost-matrix .disable_transport_cost').attr("checked","false")
});

$('#pat_memberentrygen span:contains("AutoMemberNum is set to enabled")').hide();

$('#set-automatic-renewal').hide();

$(window).load(function() {
  $('.checkout-settings').show();
});

$('#circ_circulation #specify-due-date #cleardate').after('<br /><h3>If you need to modify a due date,<br />use these controls to set a new due date <span style="font-style: italic; text-decoration: underline;">before</span> you scan an item barcode.</h3>');

  $('.CARBONDALE #breadcrumbs, .DONIELWD #breadcrumbs, .DONIHIGH #breadcrumbs, .DONITROY #breadcrumbs, .DONIWATH #breadcrumbs, .EUDORA #breadcrumbs, .HIAWATHA #breadcrumbs, .HIGH_CC #breadcrumbs, .HOLTON #breadcrumbs, .HORTON #breadcrumbs, .LYNDON #breadcrumbs, .NEKLS #breadcrumbs, .PERRY #breadcrumbs, .PHAXTELL #breadcrumbs, .PHSES #breadcrumbs, .PHSHS #breadcrumbs, .PHSMS #breadcrumbs, .PHWAC #breadcrumbs, .TONGANOXIE #breadcrumbs').prepend('<h1 class="closed upgrade1">Your library is currently listed as <span style="font-style: italic; text-decoration: underline;">Closed</span> on the OPAC.  Please contact <a href="mailto:nexthelp@nekls.org">nexthelp@nekls.org</a> when you are ready to reopen.</h1>');
    $('.upgrade1, .upgrade2').parent().hover(function() {
   $('body, .upgrade1, .upgrade2').css('background-color','#e6e600');
   }, function(){
   $('.upgrade1, .upgrade2').css('background-color','#E6F0F2');
   $('body').css('background-color','#ffffff');
  });




      $("#reserves").on("mousemove change click keyup", function(){
     $('option[value="del"]').attr('selcted','selected');
    });

$("#tools_batch_extend_due_dates #branchcodes").attr('size','53');

$("#tools_batch_extend_due_dates #categorycodes").attr('size','20');

$("#checkouts td:nth-child(6n):contains('07/06/2019'), #checkouts td:nth-child(6n):contains('07/13/2019'), #checkouts td:nth-child(6n):contains('07/20/2019'), #checkouts td:nth-child(6n):contains('07/27/2019'), #checkouts td:nth-child(6n):contains('08/03/2019'), #checkouts td:nth-child(6n):contains('08/10/2019'), #checkouts td:nth-child(6n):contains('08/17/2019'), #checkouts td:nth-child(6n):contains('08/24/2019'), #checkouts td:nth-child(6n):contains('08/31/2019'), #checkouts td:nth-child(6n):contains('09/07/2019'), #checkouts td:nth-child(6n):contains('09/14/2019'), #checkouts td:nth-child(6n):contains('09/21/2019'), #checkouts td:nth-child(6n):contains('09/28/2019'), #checkouts td:nth-child(6n):contains('10/05/2019'), #checkouts td:nth-child(6n):contains('10/12/2019'), #checkouts td:nth-child(6n):contains('10/19/2019'), #checkouts td:nth-child(6n):contains('10/26/2019'), #checkouts td:nth-child(6n):contains('11/02/2019'), #checkouts td:nth-child(6n):contains('11/09/2019'), #checkouts td:nth-child(6n):contains('11/16/2019'), #checkouts td:nth-child(6n):contains('11/23/2019'), #checkouts td:nth-child(6n):contains('11/30/2019'), #checkouts td:nth-child(6n):contains('12/07/2019'), #checkouts td:nth-child(6n):contains('12/14/2019'), #checkouts td:nth-child(6n):contains('12/21/2019'), #checkouts td:nth-child(6n):contains('12/28/2019'), #checkouts td:nth-child(6n):contains('01/04/2020'), #checkouts td:nth-child(6n):contains('01/11/2020'), #checkouts td:nth-child(6n):contains('01/18/2020'), #checkouts td:nth-child(6n):contains('01/25/2020'), #checkouts td:nth-child(6n):contains('02/01/2020'), #checkouts td:nth-child(6n):contains('02/08/2020'), #checkouts td:nth-child(6n):contains('02/15/2020'), #checkouts td:nth-child(6n):contains('02/22/2020'), #checkouts td:nth-child(6n):contains('02/29/2020'), #checkouts td:nth-child(6n):contains('03/07/2020'), #checkouts td:nth-child(6n):contains('03/14/2020'), #checkouts td:nth-child(6n):contains('03/21/2020'), #checkouts td:nth-child(6n):contains('03/28/2020'), #checkouts td:nth-child(6n):contains('04/04/2020'), #checkouts td:nth-child(6n):contains('04/11/2020'), #checkouts td:nth-child(6n):contains('04/18/2020'), #checkouts td:nth-child(6n):contains('04/25/2020'), #checkouts td:nth-child(6n):contains('05/02/2020'), #checkouts td:nth-child(6n):contains('05/09/2020'), #checkouts td:nth-child(6n):contains('05/16/2020'), #checkouts td:nth-child(6n):contains('05/23/2020')").css('background','yellow').parent().attr('class','checkme');

$(".checkme").click( function() {
   $(".checkme input[type='checkbox']").attr('checked','checked');
  });


$(".icon_general.icon_course_reserves").draggable();


//never delete anything below this comment
});
